package FIRe.ContextualAnalysis;

import java.util.List;
import java.util.Map;

import FIRe.Main;
import FIRe.Nodes.*;
import FIRe.ASTVisitor;
import FIRe.Exceptions.*;
import FIRe.Tuple;

import javax.xml.soap.Text;


@SuppressWarnings("ALL")
public class ScopeTypeCheckVisitor extends ASTVisitor {
    public ScopeTypeCheckVisitor(SymbolTable symbolTable, RobotHeaderTable robotHeaderTable) {
        ST = symbolTable;
        RHT = robotHeaderTable;
    }

    //The symbol table holds all the variables and their types.
    private SymbolTable ST;
    //The RobotHeaderTable holds all constant values concerned with the robot Properties
    private RobotHeaderTable RHT;

    @Override
    public void visit(AbstractNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }
    }

    @Override
    public void visit(AdditionNode node, Object... arg) throws TypeException {
        //When visiting Addition nodes, we will visit each child (if they're not null)
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //We will set the type as the type of one of the children.
        node.type = node.LeftChild.type;

        //Addition should only work if the children are of the same type and neither of them are bool
        if(! node.LeftChild.type.equals(node.RightChild.type)){
            throw new TypeException(node.LeftChild.type, node.RightChild.type, node.LineNumber);
        }else if(node.LeftChild.type.equals(Main.BOOL) || node.RightChild.type.equals(Main.BOOL)){
            throw new TypeException("number or text", Main.BOOL, node.LineNumber);
        }else{
            node.type = node.LeftChild.type;
        }
    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }
    }

    @Override
    public void visit(AndNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both children should be bools
        if (node.LeftChild.type != Main.BOOL)
            throw new TypeException(Main.BOOL, node.LeftChild.type, node.LineNumber);

        if (node.RightChild.type != Main.BOOL)
            throw new TypeException(Main.BOOL, node.RightChild.type, node.LineNumber);

        //The result is also a bool
        node.type = Main.BOOL;
    }


    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void visit(ArrayAccessNode node, Object... arg) throws Exception {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }

        //Checking if arrayindex is valid, it can only be valid as an expression
        if(node.index instanceof ExpressionNode) {
            ExpressionNode tempExpressionNode = (ExpressionNode) node.index;
            //Checking if the index value is of a correct type
            CheckingArrayIndex(tempExpressionNode);

        }
        else
        {
            throw new TypeException(Main.NUMBER, node.index.type, node.LineNumber);
        }


        try {
            SymbolData data = ST.Search(node.Id.Name, node.LineNumber);
            node.Id.type = data.type;

            //We set the type as the the itself without the array. Could be done with a split
            switch (node.Id.type) {
                case Main.BOOLARRAY:
                    node.type = Main.BOOL;
                    break;
                case Main.NUMBERARRAY:
                    node.type = Main.NUMBER;
                    break;
                case Main.TEXTARRAY:
                    node.type = Main.TEXT;
                    break;
                default:
                    throw new TypeException("array", node.Id.type, node.LineNumber);
            }
        }
        catch (SymbolNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void visit(AssignNode node, Object... arg) throws TypeException {
        //We visit the Id and Expression, if they are not null
        if (node != null && node.Id != null && node.Expression != null) {
            visitNode(node.Id);
            visitNode(node.Expression);
        }
        //If it is an array, we cut away the "array" part
        if (node.Id.type != null && node.Id.type.contains("array") && node.Id.ArrayIndex != null)
            node.Id.type = node.Id.type.split(" ")[0];


        //If the children are not of the same type, throw an exception.
        if (node.Id.type != null && !node.Id.type.equals(node.Expression.type))
            throw new TypeException(node.Id.type, node.Expression.type, node.LineNumber);
    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {
        //We open a new block and a new scope.
        ST.OpenScope();

        //If this is a whenblock, we insert the event variable
        if (node.Parent instanceof WhenNode) {
            WhenNode Whennode = (WhenNode) node.Parent;
            ST.Insert(new EventTypeDeclarationNode((IdNode) Whennode.childList.get(1), ((IdNode)Whennode.childList.get(0)).Name, node.LineNumber));
        }

        //If this is a for node, we insert the declared variable if there is one
        if (node.Parent instanceof ForNode && ((ForNode)node.Parent).Dcl != null){
            if (((ForNode)node.Parent).Dcl instanceof NumberDeclarationNode)
                visit((NumberDeclarationNode)(((ForNode) node.Parent).Dcl));
            else if(((ForNode)node.Parent).Dcl instanceof TextDeclarationNode)
                throw new TypeException(Main.NUMBER, Main.TEXT, ((ForNode)node.Parent).LineNumber);
            else if(((ForNode)node.Parent).Dcl instanceof BooleanDeclarationNode)
                throw new TypeException(Main.NUMBER, Main.BOOL, ((ForNode)node.Parent).LineNumber);

        }
        //We also need to insert the formal parameters in the symbol table,
        //in order to make den accessible in the body.
        if(node.Parent instanceof FunctionDeclarationNode)
        {
            //Finding the blocks parent.
            FunctionDeclarationNode tempFunc = (FunctionDeclarationNode)node.Parent;

            FormalParameterNode tempFormal = null;
            //Finding the function's formalparameter.
            //We know it only got 1 formalparameter, and that contains the rest.
            for (AbstractNode child : tempFunc.childList)
            {
                if(child instanceof FormalParameterNode)
                {
                    tempFormal = (FormalParameterNode) child;
                    break;
                }
            }

            //Inserting all the formalparameters into the symbol table.
            InsertFormalParameters(tempFormal);
        }
        //We also need to insert the formal parameters in the symbol table,
        //in order to make den accessible in the body.
        else if(node.Parent instanceof StrategyDeclarationNode)
        {

            StrategyDeclarationNode tempFunc = (StrategyDeclarationNode) node.Parent;
            FormalParameterNode tempFormal = null;
            for (AbstractNode child : tempFunc.childList)
            {
                if(child instanceof FormalParameterNode)
                {
                    tempFormal = (FormalParameterNode) child;
                    break;
                }
            }

            InsertFormalParameters(tempFormal);
        }

        //Then we visit each child
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }

        //When there are no more children, we close the scope
        ST.CloseScope();
    }

    private void InsertFormalParameters(FormalParameterNode node) throws Exception {
        for (Map.Entry<IdNode, String> entry : node.parameterMap.entrySet()) {
            switch (entry.getValue()) {
                case Main.NUMBER:
                    ST.Insert(new NumberDeclarationNode(entry.getKey(),entry.getKey().LineNumber));
                    break;
                case Main.BOOL:
                    ST.Insert(new BooleanDeclarationNode(entry.getKey(),entry.getKey().LineNumber));
                    break;
                case Main.TEXT:
                    ST.Insert(new TextDeclarationNode(entry.getKey(),entry.getKey().LineNumber));
                    break;
                case Main.NUMBERARRAY:
                    ST.Insert(new NumberArrayDeclarationNode(entry.getKey(),entry.getKey().LineNumber));
                    break;
                case Main.BOOLARRAY:
                    ST.Insert(new BoolArrayDeclarationNode(entry.getKey(),entry.getKey().LineNumber));
                    break;
                case Main.TEXTARRAY:
                    ST.Insert(new TextArrayDeclarationNode(entry.getKey(),entry.getKey().LineNumber));
                    break;
                default:
                    throw new NotRecognizedTypeException(entry.getValue());
            }
        }
    }

    @Override
    public void visit(BodyColorNode node, Object... arg) throws TypeException {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }
        //If the body color is not a valid color, we throw an exception
        if (!RHT.ValidColors.contains(node.Color.Color))
            throw new TypeException("color", node.Color.Color, node.Color.LineNumber);
    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {
        //Insert the new node in the symbol table
        if (!(node.Parent instanceof ProgNode))
            ST.Insert(node);
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }
        //We set the type as bool
        node.Id.type = Main.BOOL;
    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
        //We set the type as bool array and insert it in the symbol table
        node.Id.type = Main.BOOLARRAY;
        if (!(node.Parent instanceof ProgNode))
            ST.Insert(node);
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }

        //If the size variable is not a number, throw an exception.
        if (node.Size.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER, node.Size.type, node.LineNumber);
    }

    @Override
    public void visit(BoolNode node, Object... arg) {
        //Bool nodes are of type bool
        node.type = Main.BOOL;
    }


    @Override
    public void visit(ColorValNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }
    }

    @Override
    public void visit(ControlStructureNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }
    }

    @Override
    public void visit(DeclarationNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }
    }

    @Override
    public void visit(DivisionNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both types should be number
        if (node.LeftChild.type != null && !node.LeftChild.type.equals(Main.NUMBER))
            throw new TypeException(Main.NUMBER, node.LeftChild.type, node.LineNumber);
        if (node.RightChild.type != null && !node.RightChild.type.equals(Main.NUMBER))
            throw new TypeException(Main.NUMBER, node.RightChild.type, node.LineNumber);

        //The result is also a number
        node.type = Main.NUMBER;
    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws InvalidNumberOfArgumentsException {
        //The FESVisitor deals with event declarations
        for (AbstractNode Node : node.childList) {
            if (Node != null) {
                //deal with formal parameters
                if (Node instanceof FormalParameterNode && ((FormalParameterNode) Node).parameterMap.size() > 0)
                    throw new InvalidNumberOfArgumentsException(0, ((FormalParameterNode)Node).parameterMap.size(),node.LineNumber);
                visitNode(Node);
            }


        }

    }

    @Override
    public void visit(EqualsNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both children should be of equal type
        if (node.LeftChild.type != node.RightChild.type)
            throw new TypeException(node.LeftChild.type, node.RightChild.type, node.LineNumber);

        //The result is always a bool
        node.type = Main.BOOL;
    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }
    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) throws Exception {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }

        if ( node.Parent instanceof StrategyDeclarationNode && ((StrategyDeclarationNode) node.Parent).Id.Name.equals("Default") && node.parameterMap.size() > 0)
            throw new InvalidNumberOfArgumentsException(0,node.parameterMap.size(),node.LineNumber);
    }

    @Override
    public void visit(ForNode node, Object... arg) throws TypeException {
        for (AbstractNode Node : node.childList) {
            //We visit each child note EXCEPT for the declarationNode!
            if (Node != null && !(Node instanceof DeclarationNode))
                visitNode(Node);
        }

        //If the From expression exists, it should be a number
        if (node.From != null && !node.From.type.equals(Main.NUMBER))
            throw new TypeException(Main.NUMBER, node.From.type, node.LineNumber);

        //The To expression always exists and shoud also be a number
        if (node.To.type != null && !node.To.type.equals(Main.NUMBER))
            throw new TypeException(Main.NUMBER, node.To.type, node.LineNumber);
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) throws Exception {

        //Strategy calls within function declarations are not allowed
        AbstractNode predecessor = node;
        while(!(predecessor.Parent instanceof ProgNode)){
            if (predecessor instanceof FunctionDeclarationNode && ST.Search(node.Id.Name,node.LineNumber).type.equals("strategy")){
                throw new StrategyCallException(node.LineNumber);
            }
            predecessor = predecessor.Parent;
        }

        for (AbstractNode Node : node.childList) {
            if (Node != null) {
                visitNode(Node);
            }
        }
        node.type = node.Id.type;

        //If this is not an eventfield, deal with the formal parameters
        //Event methods do not have parameters
        if(!node.Id.Name.contains(".")) {
            //We load the knowledge from the symbol table
            SymbolData formalParameters = ST.Search(node.Id.Name, node.LineNumber);
            //These are the parameters that are at the function call.
            List<AbstractNode> actualParams = node.Aparam.childList;

            //If the lists are not of the same size, throw an exception
            if (formalParameters.parameters.size() != actualParams.size())
                throw new InvalidNumberOfArgumentsException(formalParameters.parameters.size(), actualParams.size(), node.LineNumber);

            //If the actual parameters' types do not match the formal parameters' types throw an exception
            for (int i = 0; i < node.Aparam.childList.size(); ++i) {
                if (!(formalParameters.parameters.get(i).y.equals(((ExpressionNode) actualParams.get(i)).type)))
                    throw new TypeException(formalParameters.parameters.get(i).y, ((ExpressionNode) actualParams.get(i)).type, node.LineNumber);
            }

            if(!(formalParameters.nodeRef instanceof FunctionDeclarationNode || formalParameters.nodeRef instanceof StrategyDeclarationNode))
                throw new SymbolNotFoundException(node.Id.Name,node.LineNumber);
        }
    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) {
        //The FESVisitor deals with FunctionDeclarationNodes.
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }
    }

    @Override
    public void visit(GEQNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both children should be numbers
        if (node.LeftChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER, node.LeftChild.type, node.LineNumber);
        if (node.RightChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER, node.RightChild.type, node.LineNumber);

        //The resulting type is bool
        node.type = Main.BOOL;
    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both should be numbers
        if (node.LeftChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER, node.LeftChild.type, node.LineNumber);
        if (node.RightChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER, node.RightChild.type, node.LineNumber);

        //Result should be bool
        node.type = Main.BOOL;
    }

    @Override
    public void visit(GunColorNode node, Object... arg) throws TypeException {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                visitNode(Node);
        }

        //The gun color should be a valid color, otherwise throw an exception
        if (!RHT.ValidColors.contains(node.Color.Color))
            throw new TypeException("color", node.Color.Color, node.Color.LineNumber);
    }

    @Override
    public void visit(IdNode node, Object... arg) throws Exception {
        //If the node has an array index, we visit it
        if (node.ArrayIndex != null)
            visit(node.ArrayIndex);

        //If it is in the symbol table
        if (ST.Contains(node.Name))
            //we just set the type as the type found by searching the symbol table
            node.type = ST.Search(node.Name, node.LineNumber).type;

            //Otherwise, if it uses dot-notation
        else if (node.Name.contains(".")) {

            //We split the name of the Idnode into two pieces (variablename and field). "[.]" means "." but as a regular expression
            String variableName = node.Name.split("[.]")[0];
            String field = node.Name.split("[.]")[1];

            //We find the eventType by searching the Symbol table
            String EventType = ST.Search(variableName, node.LineNumber).type;

            //Then we look up THAT type, and find all its fields.
            SymbolData SD = ST.Search(EventType, node.LineNumber);

            //If the event is a custom event, it should not have any accessible fields.
            if (SD.parameters == null)
                throw new CustomEventFieldAccessException(node.LineNumber);

            //If there is an entry that matches the name of the field, we set that type
            for (Tuple<String, String> entry : SD.parameters) {
                if (entry.x.equals(field)) {
                    node.type = entry.y;
                    return;
                }
            }
            //If there is not a field with the right name, throw an exception
            throw new SymbolNotFoundException(node.Name, node.LineNumber);
        } else { //Otherwise, it should be in the formal parameters or it is a robotproperty


            //We use this trick to find the "ultimate" parent of the Idnode
            AbstractNode predecessor = node;
            while (!(predecessor instanceof FunctionDeclarationNode || predecessor instanceof StrategyDeclarationNode || predecessor instanceof EventDeclarationNode || predecessor instanceof RobotPropertiesNode)) {
                if (predecessor.Parent == null)
                    return;
                predecessor = predecessor.Parent;
            }

            //If it is part of a functiondelcaration node
            if (predecessor instanceof FunctionDeclarationNode) {
                //We go through each formal parameter
                for (Tuple<String, String> Entry : ST.Search(((FunctionDeclarationNode) predecessor).Id.Name, node.LineNumber).parameters) {
                    // If there is a match we set the type
                    if (Entry.x.equals(node.Name)) {
                        node.type = Entry.y;
                        return;
                    }
                }
                //Otherwise, throw an exception
                throw new SymbolNotFoundException(node.Name, node.LineNumber);
            }
            //If the predecessor is a strategy declaration node
            if (predecessor instanceof StrategyDeclarationNode) {
                for (Tuple<String, String> Entry : ST.Search(((StrategyDeclarationNode) predecessor).Id.Name, node.LineNumber).parameters) {
                    //We look through the formal parameters
                    if (Entry.x.equals(node.Name)) {
                        node.type = Entry.y;
                        return;
                    }
                }
                //Otherwise, throw an exception
                throw new SymbolNotFoundException(node.Name,node.LineNumber);
            }
            //If it is an event declaration node
            if (predecessor instanceof EventDeclarationNode) {
                //We go through each formal parameter and set the type if we find a match
                for (Tuple<String, String> Entry : ST.Search(((EventDeclarationNode) predecessor).Id.Name, node.LineNumber).parameters) {
                    if (Entry.x.equals(node.Name)) {
                        node.type = Entry.y;
                        return;
                    }
                }
                //Otherwise through an exception
                throw new SymbolNotFoundException(node.Name, node.LineNumber);
            }
            if (predecessor instanceof RobotPropertiesNode) {
                //If it came from the Robot properties, just ignore it.
                return;
            }
        }

        //When we declare an array, the id nodes parent will be an instance of an arraydcl node.
        if(node.Parent instanceof ArrayDeclarationNode)
        {
            //Then we typecasts it to an arraydeclarationnode in order to access its fields.
            ArrayDeclarationNode tempArrayNode = (ArrayDeclarationNode) node.Parent;
            //Then checks if the array index is a number.
            if(tempArrayNode.Size instanceof NumberNode)
            {
                //Typecasts it to a numbernode in order to access its fields.
                NumberNode tempNumberNode = (NumberNode) tempArrayNode.Size;
                //Checks if it is an integervalue.
                if(tempNumberNode.value % 1 != 0)
                {
                    throw new TypeException("Array index must be integer, found: " + tempNumberNode.value + ". Line: " + node.LineNumber);
                }

            }
            //If array index is not a number.
            else
            {
                throw new TypeException(Main.NUMBER, tempArrayNode.Size.type, node.LineNumber);
            }


        }
        //If the idnode has an array index then it is an arrayaccess.
        else if(node.ArrayIndex != null)
        {
            //Checks if the array index is a numbernode
            if(node.ArrayIndex instanceof ExpressionNode) {
                ExpressionNode tempExpressionNode = (ExpressionNode) node.ArrayIndex;
                //Checking if the index value is of a correct type
                CheckingArrayIndex(tempExpressionNode);

            }
            else
            {
                throw new TypeException(Main.NUMBER, node.ArrayIndex.type, node.LineNumber);
            }

        }

    }

    private void CheckingArrayIndex(ExpressionNode tempExpressionNode) throws Exception {

        //A numbernode as index is valid
        if(tempExpressionNode instanceof NumberNode)
        {
            NumberNode tempNumberNode = (NumberNode) tempExpressionNode;
            //Then checking if it is an integervalue.
            if(tempNumberNode.value % 1 != 0)
            {
                throw new TypeException("Array index must be an integer, found: " + tempNumberNode.value +". Line: "+ tempNumberNode.LineNumber);
            }

        }
        //An IdNode as index is valud
        else if(tempExpressionNode instanceof IdNode)
        {
            IdNode tempIdNode = (IdNode) tempExpressionNode;
            //Visiting it, so its type will get set
            visit(tempIdNode);
            //Then checking if the idnode represents a variable of type number
            if(!tempIdNode.type.equals(Main.NUMBER))
            {
                throw new TypeException(Main.NUMBER, tempIdNode.type, tempIdNode.LineNumber);
            }
        }
        //An infixExpressionNode is a valid
        else if(tempExpressionNode instanceof InfixExpressionNode)
        {
            InfixExpressionNode tempInfixExpressionNode = (InfixExpressionNode) tempExpressionNode;
            //visiting it so the type of the expression gets set.
            visit(tempInfixExpressionNode);
            //Then checking if it is a number.
            if(!tempInfixExpressionNode.type.equals(Main.NUMBER))
            {
                throw new TypeException(Main.NUMBER, tempInfixExpressionNode.type, tempInfixExpressionNode.LineNumber);
            }
        }
        //Not a valid index
        else if(tempExpressionNode instanceof BoolNode)
        {
            BoolNode tempBoolNode = (BoolNode) tempExpressionNode;
            throw new TypeException(Main.NUMBER, Main.BOOL, tempBoolNode.LineNumber);
        }
        //Not a valid index
        else if(tempExpressionNode instanceof TextNode)
        {
            TextNode tempTextNode = (TextNode) tempExpressionNode;
            throw new TypeException(Main.NUMBER, Main.TEXT, tempTextNode.LineNumber);
        }
        else if(tempExpressionNode instanceof FuncCallNode)
        {
            FuncCallNode tempFuncCallNode = (FuncCallNode) tempExpressionNode;
            SymbolData data = ST.Search(tempFuncCallNode.Id.Name);
            if(!data.type.equals(Main.NUMBER))
            {
                throw new TypeException(Main.NUMBER, data.type, tempFuncCallNode.LineNumber);
            }
        }
        //If none of the above it is invalid.
        else
        {
            throw new TypeException(Main.NUMBER, tempExpressionNode.type, tempExpressionNode.LineNumber);
        }
    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }

        //The if contains expressions and blocks for each if/else if/else in the chain
        //each of the expressions must be a bool
        for (AbstractNode AN : node.childList)
            if(AN instanceof ExpressionNode && ((ExpressionNode)AN).type != null && !((ExpressionNode) AN).type.equals(Main.BOOL)) {
                throw new TypeException(Main.BOOL, ((ExpressionNode) AN).type, AN.LineNumber);
            }
    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg) throws TypeException{
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //This is a generic class, and this is likely not called.
        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException("","",0); //This method  should never be called, because InfixExpression is abstract

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(LEQNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both should be a number.
        if(node.LeftChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER,node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER,node.RightChild.type,node.LineNumber);

        //It results in a boolean value
        node.type = Main.BOOL;
    }

    @Override
    public void visit(LessThanNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both should be a number
        if(node.LeftChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER,node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER,node.RightChild.type,node.LineNumber);

        //result is a bool
        node.type = Main.BOOL;
    }

    @Override
    public void visit(ModuloNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both should be a number
        if(node.LeftChild.type != null && node.RightChild.type != null) {
            if (!node.LeftChild.type.equals(Main.NUMBER))
                throw new TypeException(Main.NUMBER, node.LeftChild.type, node.LineNumber);
            if (!node.RightChild.type.equals(Main.NUMBER))
                throw new TypeException(Main.NUMBER, node.RightChild.type, node.LineNumber);
        }
        //the result is also a number
        node.type = Main.NUMBER;
    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both input has to be numbers
        if(node.LeftChild.type != null && node.RightChild.type != null) {
            if (!node.LeftChild.type.equals(Main.NUMBER))
                throw new TypeException(Main.NUMBER, node.LeftChild.type, node.LineNumber);
            if (!node.RightChild.type.equals(Main.NUMBER))
                throw new TypeException(Main.NUMBER, node.RightChild.type, node.LineNumber);
        }
        //The result of a multiplication can only be a number
        node.type = Main.NUMBER;
    }

    @Override
    public void visit(NegateNode node, Object... arg) {
        //Is not used
    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //The children must be of the same type
        if(!node.LeftChild.type.equals(node.RightChild.type))
            throw new TypeException(node.LeftChild.type,node.RightChild.type,node.LineNumber);

        //The result is always a bool though.
        node.type = Main.BOOL;
    }

    @Override
    public void visit(NotNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            visitNode(Node);
        }

        //If the expression is not a bool, throw an expression
        if(node.Expression.type != null && !node.Expression.type.equals(Main.BOOL))
            throw new TypeException(Main.BOOL, node.Expression.type,node.LineNumber);

        //The result is a bool
        node.type = Main.BOOL;
    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws TypeException, Exception {

        //We insert the number
        if (!(node.Parent instanceof ProgNode))
            ST.Insert(node);

        //We set the type
        node.Id.type = Main.NUMBER;
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }

            //If the number is instantiated and the right hand side is not a number, throw an exception
            if (node.childList.size() > 1 && ((ExpressionNode) node.childList.get(1)).type != null && !((ExpressionNode) node.childList.get(1)).type.equals(node.Id.type)) {
                ExpressionNode rightHandSide = (ExpressionNode) node.childList.get(1);
                throw new TypeException(node.Id.type, rightHandSide.type, node.LineNumber);
            }

    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {

        //We insert the new array
        if (!(node.Parent instanceof ProgNode))
            ST.Insert(node);

        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }

        //And set the type
        node.Id.type = Main.NUMBERARRAY;
    }

    @Override
    public void visit(NumberNode node, Object... arg) {
        //Number nodes are of type number
        node.type = Main.NUMBER;
    }

    @Override
    public void visit(OrNode node, Object... arg) throws TypeException{
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both children should be boolean
        if (node.LeftChild.type != Main.BOOL)
            throw new TypeException(Main.BOOL, node.LeftChild.type,node.LineNumber);
        if (node.RightChild.type != Main.BOOL)
            throw new TypeException(Main.BOOL,node.RightChild.type,node.LineNumber);

        //the result is also boolean
        node.type = Main.BOOL;
    }

    @Override
    public void visit(PowerNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both children should be number
        if(node.LeftChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER,node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER,node.RightChild.type,node.LineNumber);

        //The result is also a number
        node.type = Main.NUMBER;
    }

    @Override
    public void visit(ProgNode node, Object... arg) {
        //We don't care about the prognode. It just visits the children
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }
    }

    @Override
    public void visit(RadarColorNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }

        //The radarcolor must be a valid color
        if (!RHT.ValidColors.contains(node.Color.Color))
            throw new TypeException("color", node.Color.Color, node.Color.LineNumber);
    }

    @Override
    public void visit(ReturnNode node, Object... arg) throws TypeException {

        AbstractNode ancestor = node;

        //Finding where the return node belongs to.
        while (!(ancestor.Parent instanceof ProgNode)) {
            ancestor = ancestor.Parent;
        }

        //To save the return nodes type.
        String returnType = "";
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            {
                visitNode(Node);
                //We always know that the returnode got 1 child and its an expressionnode;
                //Casting it to expressionNode in order to access the field "type".
                ExpressionNode temp = (ExpressionNode) Node;
                if (temp.type != null)
                    returnType = temp.type;
            }
        }

        //The only place return nodes can appear legally is inside a function and an event.
        if(ancestor instanceof FunctionDeclarationNode)
        {
            FunctionDeclarationNode temp = (FunctionDeclarationNode) ancestor;
            if(temp.Type != null && !returnType.equals(temp.Type) && !temp.Type.equals("void"))
            {
                throw new TypeException(temp.Type , returnType, node.LineNumber);
            }

        }
        else if(ancestor instanceof EventDeclarationNode) {
            EventDeclarationNode temp = (EventDeclarationNode) ancestor;
            //Events should always return a boolean.
            if(returnType != null && !returnType.equals(Main.BOOL))
            {
                throw new TypeException(Main.BOOL, returnType, node.LineNumber);
            }
        }
    }

    @Override
    public void visit(RobotPropertiesNode node,  Object...arg){
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }
    }

    @Override
    public void visit(RoutineNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }

        //If there is an expression node in the routine, it must be a number, otherwise throw an exception
        if (node.repeatCondition != null && node.repeatCondition.type != null && !node.repeatCondition.type.equals(Main.NUMBER)){
            throw new TypeException(Main.NUMBER, node.repeatCondition.type,node.LineNumber);
        }
    }

    @Override
    public void visit(StatementNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }
    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {

        ST.OpenScope();
        for (AbstractNode Node: node.childList) {
            if (Node != null) {

                visitNode(Node);
            }
        }
        ST.CloseScope();
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            visitNode(node.LeftChild);
        if (node.RightChild != null)
            visitNode(node.RightChild);

        //Both sides must be numbers
        if(node.LeftChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER,node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER,node.RightChild.type,node.LineNumber);

        //The result is a number
        node.type = Main.NUMBER;
    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {
        //The declarationnode is put into the symbol table
        if (!(node.Parent instanceof ProgNode))
            ST.Insert(node);

        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }
        //The type is text
        node.Id.type = Main.TEXT;
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        // We insert it in the symbol table.
        if (!(node.Parent instanceof ProgNode))
            ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }

        //We set the type as text array, fittingly
        node.Id.type = Main.TEXTARRAY;

        //If the size expression does not result in a number, we throw an exception
        if (node.Size.type != Main.NUMBER)
            throw new TypeException(Main.NUMBER,node.Size.type,node.LineNumber);
    }

    @Override
    public void visit(TextNode node, Object... arg) {
        //Textnodes are of type text
        node.type = Main.TEXT;
    }

    @Override
    public void visit(ValNode node, Object... arg) {
        //ValNodes can either be of type text or Number, and we set the type accordingly
        //Bools are handled by boolvalnodes.
        //I don't think this method is called
        if(node instanceof TextNode)
            node.type = Main.TEXT;
        else if(node instanceof  NumberNode)
            node.type = Main.NUMBER;
    }

    @Override
    public void visit(WhenNode node, Object... arg) throws SymbolNotFoundException {
        for (AbstractNode Node: node.childList) {
            if (Node != null && !(Node instanceof IdNode))
                visitNode(Node);
        }
        if (!ST.Contains(((IdNode)node.childList.get(0)).Name))
            throw new SymbolNotFoundException(((IdNode)node.childList.get(0)).Name,node.LineNumber);
    }

    @Override
    public void visit(WhileNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }

        //the expression should be a bool
        if(node.Expression.type != null && !node.Expression.type.equals(Main.BOOL))
            throw new TypeException(Main.BOOL,node.Expression.type,node.LineNumber);
    }

    @Override
    public void visit(RobotNameNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }
    }

    @Override
    public void visit(RobotTypeNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                visitNode(Node);
        }
        //The robottype should be a valid robottype, as stated by tbe RHT.
        if (!RHT.RobotTypes.contains(node.RobotType.Name))
            throw new TypeException("robot, advancedRobot, or juniorRobot",node.RobotType.type,node.LineNumber);
    }
}