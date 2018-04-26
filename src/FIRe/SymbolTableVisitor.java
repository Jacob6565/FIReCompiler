package FIRe;

import java.beans.Expression;
import java.lang.reflect.Type;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


import FIRe.Exceptions.*;
import FIRe.Parser.CFGParser;
import javafx.beans.binding.When;

import javax.lang.model.util.AbstractElementVisitor7;


@SuppressWarnings("ALL")
public class SymbolTableVisitor extends ASTVisitor {
    SymbolTableVisitor(SymbolTable symbolTable, RobotHeaderTable robotHeaderTable) {
        ST = symbolTable;
        RHT = robotHeaderTable;
    }

    private SymbolTable ST;
    private RobotHeaderTable RHT;

    @Override
    public void visit(AbstractNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(AdditionNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            VisitNode(node.LeftChild);
        if (node.RightChild != null)
            VisitNode(node.RightChild);

        if (node.LeftChild.type == "bool" && node.RightChild.type == "bool")
            throw new TypeException("number or text", "bool", node.LineNumber);
        else if (node.LeftChild.type == "number" && node.RightChild.type == "text")
            throw new TypeException("number", "text", node.LineNumber);
        else if (node.LeftChild.type == "text" && node.RightChild.type == "number")
            throw new TypeException("text", "number", node.LineNumber);
        else if ((node.LeftChild.type == "number" || node.LeftChild.type == "text") && node.RightChild.type != node.LeftChild.type)
            throw new TypeException(node.LeftChild.type, node.RightChild.type, node.LineNumber);
        else if ((node.RightChild.type == "number" || node.RightChild.type == "text") && node.LeftChild.type != node.RightChild.type)
            throw new TypeException(node.RightChild.type, node.LeftChild.type, node.LineNumber);

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(AndNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            VisitNode(node.LeftChild);
        if (node.RightChild != null)
            VisitNode(node.RightChild);

        if (node.LeftChild.type != "bool")
            throw new TypeException("bool", node.LeftChild.type, node.LineNumber);
        if (node.RightChild.type != "bool")
            throw new TypeException("bool", node.RightChild.type, node.LineNumber);

        node.type = "bool";
    }


    @Override
    public void visit(ArrayAccessNode node, Object... arg) throws TypeException, SymbolNotFoundException {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }

            node.Id.type = ST.Search(node.Id.Name, node.LineNumber).type;

            switch (node.Id.type) {
                case "bool array":
                    node.type = "bool";
                    break;
                case "number array":
                    node.type = "number";
                    break;
                case "text array":
                    node.type = "text";
                    break;
                default:
                    throw new TypeException("array", node.Id.type, node.LineNumber);
            }
        }

    @Override
    public void visit(AssignNode node, Object... arg) throws TypeException {
        if (node != null && node.Id != null && node.Expression != null) {
            VisitNode(node.Id);
            VisitNode(node.Expression);
        }
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
        if (node.Id.type.contains("array") && node.Id.ArrayIndex != null)
            node.Id.type = node.Id.type.split(" ")[0];
        if (!node.Id.type.equals(node.Expression.type))
            throw new TypeException(node.Id.type, node.Expression.type, node.LineNumber);
    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {
        ST.OpenScope();
        if (node.Parent instanceof WhenNode) {
            WhenNode Whennode = (WhenNode) node.Parent;
            ST.Insert(new EventTypeDeclarationNode((IdNode) Whennode.childList.get(1), ((IdNode)Whennode.childList.get(0)).Name));
        }
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
        ST.CloseScope();
    }

    @Override
    public void visit(BodyColorNode node, Object... arg) throws TypeException {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
        if (!RHT.ValidColors.contains(node.Color.Color))
            throw new TypeException("color", node.Color.Color, node.Color.LineNumber);
    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
        node.Id.type = "bool";
    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
        node.Id.type = "bool array";
        ST.Insert(node);
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }

        if (node.Size.type != "number")
            throw new TypeException("number", node.Size.type, node.LineNumber);
    }

    @Override
    public void visit(BoolNode node, Object... arg) {
        node.type = "bool";
    }


    @Override
    public void visit(ColorValNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(ControlStructureNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(DeclarationNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(DivisionNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            VisitNode(node.LeftChild);
        if (node.RightChild != null)
            VisitNode(node.RightChild);

        if (node.LeftChild.type != "number")
            throw new TypeException("number", node.LeftChild.type, node.LineNumber);
        if (node.RightChild.type != "number")
            throw new TypeException("number", node.RightChild.type, node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(EqualsNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            VisitNode(node.LeftChild);
        if (node.RightChild != null)
            VisitNode(node.RightChild);

        if (node.LeftChild.type != node.RightChild.type)
            throw new TypeException(node.LeftChild.type, node.RightChild.type, node.LineNumber);

        node.type = "bool";
    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(ForNode node, Object... arg) throws TypeException {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
        if (node.From != null && node.From.type != "number")
            throw new TypeException("number", node.From.type, node.LineNumber);
        if (node.To.type != "number")
            throw new TypeException("number", node.To.type, node.LineNumber);
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) throws TypeException, InvalidNumberOfArgumentsException, SymbolNotFoundException {
        for (AbstractNode Node : node.childList) {
            if (Node != null) {
                VisitNode(Node);
            }
        }
        if(!node.Id.Name.contains(".")) { //If this is not an eventfield, deal with the formal parameters
            SymbolData formalParameters = ST.Search(node.Id.Name, node.LineNumber); //Nummer
            List<AbstractNode> actualParams = node.Aparam.childList;

            if (formalParameters.parameters.size() != actualParams.size())
                throw new InvalidNumberOfArgumentsException(formalParameters.parameters.size(), actualParams.size(), node.LineNumber);
            for (int i = 0; i < node.Aparam.childList.size(); ++i) {
                if (!(formalParameters.parameters.get(i).y.equals(((ExpressionNode) actualParams.get(i)).type)))
                    throw new TypeException(formalParameters.parameters.get(i).y, ((ExpressionNode) actualParams.get(i)).type, node.LineNumber);
            }
            node.type = formalParameters.type;
        }
    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(GEQNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            VisitNode(node.LeftChild);
        if (node.RightChild != null)
            VisitNode(node.RightChild);

        if (node.LeftChild.type != "number")
            throw new TypeException("number", node.LeftChild.type, node.LineNumber);
        if (node.RightChild.type != "number")
            throw new TypeException("number", node.RightChild.type, node.LineNumber);

        node.type = "bool";
    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            VisitNode(node.LeftChild);
        if (node.RightChild != null)
            VisitNode(node.RightChild);

        if (node.LeftChild.type != "number")
            throw new TypeException("number", node.LeftChild.type, node.LineNumber);
        if (node.RightChild.type != "number")
            throw new TypeException("number", node.RightChild.type, node.LineNumber);

        node.type = "bool";
    }

    @Override
    public void visit(GunColorNode node, Object... arg) throws TypeException {
        for (AbstractNode Node : node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
        if (!RHT.ValidColors.contains(node.Color.Color))
            throw new TypeException("color", node.Color.Color, node.Color.LineNumber);
    }

    @Override
    public void visit(IdNode node, Object... arg) throws SymbolNotFoundException {

            if (ST.Contains(node.Name)) //If it is in the synmbol table
                node.type = ST.Search(node.Name, node.LineNumber).type;
            else if (node.Name.contains(".")){ //If it uses dot-notation
                String variableName = node.Name.split("\\.")[0];
                String field = node.Name.split("\\.")[1];
                String EventType = ST.Search(variableName,node.LineNumber).type;
                SymbolData SD = ST.Search(EventType,node.LineNumber);
                for (Tuple<String, String> entry: SD.parameters) {
                    if (entry.x.equals(field)){
                        node.type = entry.y;
                        return;
                    }
                }
                throw new SymbolNotFoundException(node.Name + "linje 341",node.LineNumber);
            }
            else { //Hopefully it is in the formal parameters
                AbstractNode predecessor = node;
                while (!(predecessor instanceof FunctionDeclarationNode || predecessor instanceof StrategyDeclarationNode || predecessor instanceof EventDeclarationNode)){
                    predecessor = predecessor.Parent;
                }
                if (predecessor instanceof FunctionDeclarationNode) {
                    for (Tuple<String, String> Entry: ST.Search(((FunctionDeclarationNode) predecessor).Id.Name,node.LineNumber).parameters) {
                        if(Entry.x.equals(node.Name)){
                            node.type = Entry.y;
                            return;
                        }
                    }
                    throw new SymbolNotFoundException(node.Name + "linje 355",node.LineNumber);
                }
                if (predecessor instanceof StrategyDeclarationNode) {
                    for (Tuple<String, String> Entry: ST.Search(((StrategyDeclarationNode) predecessor).Id.Name,node.LineNumber).parameters) {
                        if(Entry.x.equals(node.Name)){
                            node.type = Entry.y;
                            return;
                        }
                    }
                    //This error is also thrown in visit(FuncDcl), so no need for it here.
                   //throw new SymbolNotFoundException(node.Name,node.LineNumber);
                }
                if (predecessor instanceof EventDeclarationNode) {
                    for (Tuple<String, String> Entry: ST.Search(((EventDeclarationNode) predecessor).Id.Name,node.LineNumber).parameters) {
                        if(Entry.x.equals(node.Name)){
                            node.type = Entry.y;
                            return;
                        }
                    }
                    throw new SymbolNotFoundException(node.Name + "linje 373",node.LineNumber);
                }
            }
        }



    @Override
    public void visit(IfControlStructureNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        for (AbstractNode AN : node.childList)
             if (AN instanceof ExpressionNode && ((ExpressionNode)AN).type != "bool")
                throw new TypeException("bool",((ExpressionNode)AN).type,AN.LineNumber);
    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg) throws TypeException{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException("","",0); //This method  should never be called, because InfixExpression is abstract

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(LEQNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "bool";
    }

    @Override
    public void visit(LessThanNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "bool";
    }

    @Override
    public void visit(ModuloNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(NegateNode node, Object... arg) {
        //Is not used
    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException(node.LeftChild.type,node.RightChild.type,node.LineNumber);

        node.type = "bool";
    }

    @Override
    public void visit(NotNode node, Object... arg) {
        node.type = node.Expression.type;
    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws TypeException, Exception {
        ST.Insert(node);
        node.Id.type = "number";
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        if (node.childList.size() > 1 && ((ExpressionNode)node.childList.get(1)).type != node.Id.type)
            throw new TypeException(node.Id.type,((ExpressionNode) node.childList.get(1)).type,node.LineNumber);

    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
        node.Id.type = "number array";
    }

    @Override
    public void visit(NumberNode node, Object... arg) {
        node.type = "number";
    }

    @Override
    public void visit(OrNode node, Object... arg) throws TypeException{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if (node.LeftChild.type != "bool")
            throw new TypeException("bool", node.LeftChild.type,node.LineNumber);
        if (node.RightChild.type != "bool")
            throw new TypeException("bool",node.RightChild.type,node.LineNumber);

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(PowerNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
            VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(ProgNode node, Object... arg) {

        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);

        }
    }

    @Override
    public void visit(RadarColorNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
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
                VisitNode(Node);
                //We always know that the returnode got 1 child and its an expressionnode;
                //Casting it to expressionNode in order to access the field "type".
                ExpressionNode temp = (ExpressionNode) Node;
                returnType = temp.type;
            }
        }

        //The only place return nodes can appear legally is inside a function and an event.
        if(ancestor instanceof FunctionDeclarationNode)
        {
            FunctionDeclarationNode temp = (FunctionDeclarationNode) ancestor;

            if(!returnType.equals(temp.Type))
            {
                throw new TypeException(temp.Type , returnType, node.LineNumber);
            }

        }
        else if(ancestor instanceof EventDeclarationNode) {
            EventDeclarationNode temp = (EventDeclarationNode) ancestor;
            //Events should always return a boolean.
            if(!returnType.equals("bool"))
            {
                throw new TypeException("bool", returnType, node.LineNumber);
            }
        }








    }

    @Override
    public void visit(RobotDclBodyNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        if (!RHT.RobotTypes.contains(node.robotType)){
            throw new TypeException("RobotType", node.robotType,node.LineNumber);
        }
    }

    @Override
    public void visit(RoutineNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        if (node.repeatCondition != null && !node.repeatCondition.type.equals("number")){
            throw new TypeException("number", node.repeatCondition.type,node.LineNumber);
        }
    }

    @Override
    public void visit(StatementNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        node.Id.type = "text";
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
        node.Id.type = "text array";

        if (node.Size.type != "number")
            throw new TypeException("number",node.Size.type,node.LineNumber);
    }

    @Override
    public void visit(TextNode node, Object... arg) {
        node.type = "text";
    }

    @Override
    public void visit(ValNode node, Object... arg) {
        if(node instanceof TextNode)
            node.type = "text";
        else if(node instanceof  NumberNode)
            node.type = "number";
    }

    @Override
    public void visit(WhenNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null && !(Node instanceof IdNode))
            VisitNode(Node);
        }
    }

    @Override
    public void visit(WhileNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        if(node.Expression.type != "bool")
            throw new TypeException("bool",node.Expression.type,node.LineNumber);
    }
}
