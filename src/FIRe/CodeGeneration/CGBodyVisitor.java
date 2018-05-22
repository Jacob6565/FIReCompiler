package FIRe.CodeGeneration;

import FIRe.ASTVisitor;
import FIRe.ContextualAnalysis.SymbolData;
import FIRe.ContextualAnalysis.SymbolTable;
import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.SymbolNotFoundException;
import FIRe.Exceptions.TypeException;
import FIRe.Nodes.*;

import java.util.ArrayList;

//Emits code for the body of the program.
public class CGBodyVisitor extends ASTVisitor {
    CGBodyVisitor(SymbolTable symbolTable){
        this();
        this.symbolTable = symbolTable;
    }
    CGBodyVisitor(){
        exprGen = new CGExpressionVisitor();
        code = new MethodCodeHolder("bodyCode", "void");
    }

    CodeHolder code;
    FunctionDeclarationNode func;
    private CGExpressionVisitor exprGen;
    private SymbolTable symbolTable;

    //Used to create local variables for for loops
    static int forLoopCounter = 0;

    //Called by CGTopVisitor to generate the actual code
    String GenerateBodyCode(AbstractNode node){
        code = new MethodCodeHolder("bodyCode", "void");
        visitNode(node);
        return code.sb.toString();
    }

    //Used to see if a given node is part of a strategy sub tree
    private boolean partOfStratBody(AbstractNode node){

        if(node != null && node.Parent != null)
            if(node.Parent.Parent instanceof StrategyDeclarationNode)
                return true;
        return false;
    }

    private void generateDeclaration(String type, DeclarationNode node, boolean exprFlag, int idCounter) {
        code.emit(type + " ");

        //If the exprflag is true we are dealing with a simple declaration with an assignment
        if (exprFlag){
            code.emit(node.Id.Name + " = ");
            code.emitNL(exprGen.GenerateExprCode(code, node.expressionNode) + ";");
            return;
        }
        else
            generateSequentialIds(node.childList, idCounter);
    }

    private void generateSequentialIds(ArrayList<AbstractNode> childList, int idCounter) {
        //For-loop for emitting the correct code
        for (AbstractNode id : childList) {
            if (id instanceof IdNode && idCounter > 1) {
                code.emit(((IdNode) id).Name + ", ");
                idCounter--;
            } else if (id instanceof IdNode) {
                code.emitNL(((IdNode) id).Name + ";");
            }
        }
    }

    @Override
    public void visit(AbstractNode node, Object... arg) {

    }

    @Override
    public void visit(AdditionNode node, Object... arg){

    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {

    }

    @Override
    public void visit(AndNode node, Object... arg){

    }

    @Override
    public void visit(ArrayAccessNode node, Object... arg){

    }

    //Method also handles array assignment
    @Override
    public void visit(AssignNode node, Object... arg){
        code.emit(node.Id.Name);
        if(node.Id.ArrayIndex != null) {
            code.emit("[(int)("); //Conversion necessary for the index of the array
            code.emit(exprGen.GenerateExprCode(code, node.Id.ArrayIndex) + ")]");
        }
        code.emit(" = ");
        code.emitNL(exprGen.GenerateExprCode(code, node.Expression) + ";");
    }

    boolean stopBodyGen = false;

    @Override
    public void visit(BlockNode node,Object... arg){

        for(AbstractNode child : node.childList) {
            if(!stopBodyGen)
            {
                indent(child);
                visitNode(child);
            }
        }
        stopBodyGen = false;
    }


    @Override
    public void visit(BodyColorNode node, Object... arg) {

    }


    //Creates the java code for bool dcls. These are handled the same way for numbers and texts.
    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) {
        if (!partOfStratBody(node)) {
            int idCounter = 0;
            boolean exprFlag = false;


            //For-loop for handling the decleration(s)
            if (node.expressionNode != null){
                exprFlag = true;
            }
            else
                for (AbstractNode id : node.childList) {
                    if (id instanceof IdNode)
                        idCounter++;
                }

            generateDeclaration("boolean", node, exprFlag, idCounter);
        }
    }

    //Creates the java code for bool array dcls. These are handled the same way for numbers and texts.
    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) {
        if (!partOfStratBody(node)){
            code.emit("boolean[] ");

            for(AbstractNode id : node.childList){
                if(id instanceof IdNode){
                    code.emit(((IdNode) id).Name + " = new boolean[(int)");
                }

                else if(id instanceof ExpressionNode){
                    code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + "];");
                }
            }
        }
    }

    @Override
    public void visit(BoolNode node, Object... arg) {

    }

    @Override
    public void visit(ColorValNode node, Object... arg) {

    }

    @Override
    public void visit(ControlStructureNode node, Object... arg) {

    }

    @Override
    public void visit(DeclarationNode node, Object... arg) {

    }

    @Override
    public void visit(DivisionNode node, Object... arg) {

    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg){
        for (AbstractNode child: node.childList) {
            visitNode(child);
        }
    }

    @Override
    public void visit(EqualsNode node, Object... arg){

    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {
        exprGen.GenerateExprCode(code, node);
    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {

    }

    @Override
    public void visit(ForNode node, Object... arg){
        //Flag to see if the for-loop counter was declared inside the for-loop
        boolean dclUsed = false;

        //These are used to create local variables for the for-loop (To be in line with how for-loops are handled
        //in the semantics)
        String fromVarName = "from_" + forLoopCounter;
        String toVarName = "to_" + forLoopCounter;
        forLoopCounter++;

        //Sets up the local variables
        if(node.From != null) {
            code.emit("int " + fromVarName + " = (int)");
            code.emitNL(exprGen.GenerateExprCode(code, node.From) + ";");
        }

        if(node.To != null){
            code.emit("int " + toVarName + " = (int)");
            code.emitNL(exprGen.GenerateExprCode(code, node.To) + ";");
        }

        code.emit("for(");

        //Emits code if the for-loop counter has been declared in the loop and has been initialized
        if (node.Dcl != null && node.Dcl.childList.get(1) instanceof ExpressionNode){
            code.emit("int " + node.Dcl.Id.Name + " = (int)");
            code.emit(exprGen.GenerateExprCode(code, (ExpressionNode) node.Dcl.childList.get(1)) + ";");
            dclUsed = true;
        }
        //Emits code if the for-loop counter has been declared in the loop and has not been initialized
        else if(node.Dcl != null){
            code.emit("int " + node.Dcl.Id.Name + " = " + "0;");
            dclUsed = true;
        }
        //Emits code if the for-loop counter has not been declared in the loop.
        else if(node.From != null){
            code.emit(";");
        }

        //Generates the rest of the for loop condition based on whether its incremental and whether from or dcl was
        //used.
        if(node.Incremental && dclUsed) {
            code.emit(node.Dcl.Id.Name + " < " + toVarName + "; " + node.Dcl.Id.Name + "++");
        }
        else if(node.Incremental && !dclUsed) {
            code.emit(" " + fromVarName + " < " + toVarName + "; " + fromVarName + "++");
        }
        else if(!node.Incremental && dclUsed) {
            code.emit(node.Dcl.Id.Name + " > " + toVarName + "; " + node.Dcl.Id.Name + "--");
        }
        else if(!node.Incremental && !dclUsed) {
            code.emit(" " + fromVarName + " > " + toVarName + "; " + fromVarName + "--");
        }

        code.emitNL("){");

        //Generates code for the for loop body
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {
                visitNode(child);
                //Indents the code correctly in the output java file
                indent(child);
            } else if (child instanceof ExpressionNode){
                visit(child);
            }
        }
        code.emitNL("}");
    }

    private boolean ancestorOfRoutine(AbstractNode node){
        if(node != null && node.Parent != null){
            if(node.Parent instanceof RoutineNode)
                return true;
            else
                return ancestorOfRoutine(node.Parent);
        }
        return false;
    }

    @Override
    public void visit(FuncCallNode node, Object... arg){
        String name = node.Id.Name;
        boolean ofTypeStrategy = false;

        //Here we use the substring of name that begins on index 1, to avoid the underscore of the name when searching
        SymbolData symbolData;
        if(name.charAt(0) == '_')
            symbolData = symbolTable.Search(name.substring(1));
        else
            symbolData = symbolTable.Search(name);
        if (symbolData.nodeRef instanceof StrategyDeclarationNode)
            ofTypeStrategy = true;

        //This case indicates that we are dealing with a strategy call
        if (ofTypeStrategy){
            AbstractNode ancestor = node.Parent.Parent;
            code.emitNL("currentStrategy_ = Strategy_." + node.Id.Name + ";");
            code.emit("_stratChange = true");
            //If the strat call is in a block inside of a block, we need to make sure that it breaks the case, or return
            //from the event handler, immediately after the strat call. If we did this to every strat call, we would produce
            //java code with an unreachable code
            if (ancestor instanceof ControlStructureNode && !(ancestor instanceof RoutineNode)){
                if (ancestorOfRoutine(node))
                    code.emit(";\nbreak");
                else
                    code.emit(";\nreturn");
            }

            stopBodyGen = true;
        }
        //This indicates that we are dealing with a regular function call
        else
            exprGen.GenerateExprCode(code, node);
        code.emitNL(";");
    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg){
        for(AbstractNode child : node.childList) {
            if (child instanceof BlockNode) {
                visitNode(child);
            }

        }
    }

    @Override
    public void visit(GEQNode node, Object... arg) {

    }

    @Override
    public void visit(GreaterThanNode node, Object... arg){

    }

    @Override
    public void visit(GunColorNode node, Object... arg) {

    }

    @Override
    public void visit(IdNode node, Object... arg){

    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) {
        code.emit("if(");

        //Variables used to count the number of ifs and blocks aggregated to the if node.
        int icount = 0;
        int bcount = 0;

        int size = node.childList.size();

        //Checks how many ifs and blocks there are
        for (AbstractNode Node : node.childList) {
            if (Node instanceof ExpressionNode) {
                icount++;
            } else if (Node instanceof BlockNode) {
                bcount++;
            }
        }

        if (bcount == icount) { // this is determines if the if-else chain ends with an else if
            boolean firstTime = true;
            //For-loop that generates the if-else code based on whether it encounters an if node or a block node. Also
            // does this based on whether it is the first time or not (to see if we need to output if or else if)
            for (AbstractNode Node : node.childList) {
                if (Node instanceof ExpressionNode && firstTime) {
                    visit((ExpressionNode) Node);
                    code.emit(")");
                    firstTime = false;
                } else if (Node instanceof BlockNode) {
                    code.emitNL("{");
                    visit((BlockNode) Node);
                    indent(Node);
                    code.emitNL("}");
                } else if (Node instanceof ExpressionNode && !firstTime) {
                    indent(Node);
                    code.emit("else if(");
                    visit((ExpressionNode) Node);
                    code.emit(")");
                }
            }
        } else if (bcount > icount)  { // this else if is used if the if-else chain ends with an else
            int blocks = 0;
            int ifs = 0;
            boolean firstTime = true;
            //For-loop that generates the if-else code based on whether it encounters an if node or a block node. Also
            // does this based on whether it is the first time or not (to see if we need to output if or if else)
            for (AbstractNode Node : node.childList) {
                if (Node instanceof ExpressionNode && firstTime) {
                    visit((ExpressionNode) Node);
                    code.emit(")");
                    firstTime = false;
                    ifs++;
                } else if ((bcount -1) == blocks && Node instanceof BlockNode){
                    code.emit("else");
                    code.emitNL("{");
                    visit((BlockNode) Node);
                    code.emitNL("}");
                } else if (Node instanceof BlockNode) {
                    code.emitNL("{");
                    visit((BlockNode) Node);
                    code.emitNL("}");
                    blocks++;
                } else if(Node instanceof ExpressionNode && !firstTime){
                    code.emit("else if(");
                    visit((ExpressionNode) Node);
                    code.emit(")");
                    ifs++;
                }
            }
        }
    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg){

    }

    @Override
    public void visit(LEQNode node, Object... arg){

    }

    @Override
    public void visit(LessThanNode node, Object... arg) {

    }

    @Override
    public void visit(ModuloNode node, Object... arg) {

    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) {

    }

    @Override
    public void visit(NegateNode node, Object... arg) {

    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) {

    }

    @Override
    public void visit(NotNode node, Object... arg) {

    }

    //Handles single and multiple declerations of numbernodes
    @Override
    public void visit(NumberDeclarationNode node, Object... arg) {
        if (!partOfStratBody(node)) {
            int idCounter = 0;
            boolean exprFlag = false;

            //For-loop for handling the decleration(s)
            if (node.expressionNode != null){
                exprFlag = true;
            }
            for (AbstractNode id : node.childList) {
                if (id instanceof IdNode)
                    idCounter++;
            }

            generateDeclaration("double", node, exprFlag, idCounter);
        }
    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) {
        if (!partOfStratBody(node)) {
            code.emit("double[] ");

            for (AbstractNode id : node.childList) {
                if (id instanceof IdNode) {
                    code.emit(((IdNode) id).Name + "= new double[(int)");
                } else if (id instanceof ExpressionNode) {
                    code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + "];");
                }
            }
        }
    }

    @Override
    public void visit(NumberNode node, Object... arg) {

    }

    @Override
    public void visit(OrNode node, Object... arg) {

    }

    @Override
    public void visit(PowerNode node, Object... arg) {

    }

    @Override
    public void visit(ProgNode node, Object... arg) {

    }

    @Override
    public void visit(RadarColorNode node, Object... arg) {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) {
        code.emit("return ");
        code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) node.childList.get(0)) + ";");
    }

    @Override
    public void visit(RoutineNode node, Object... arg) {
        if(node.repeatCondition != null) {
            code.emit("for(int i = (int)(");
            code.emitNL(exprGen.GenerateExprCode(code, node.repeatCondition) + "); i > 0; i--){");
        }

        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {
                visitNode(child);
            }
            indent(child);
        }
    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg){
        DeclarationNode tempDcl;


        code.emitNL("if(_stratChange){");
        for(AbstractNode child : node.childList) {
            if (child instanceof DeclarationNode) {
                tempDcl = (DeclarationNode) child;
                if(tempDcl instanceof NumberDeclarationNode){
                    if(tempDcl.expressionNode != null) {
                        code.emit(tempDcl.Id.Name + " = ");
                        code.emitNL(exprGen.GenerateExprCode(code, tempDcl.expressionNode) + ";");
                    }
                    else{
                        code.emit(tempDcl.Id.Name + " = (int)0");
                    }
                }
                else if(tempDcl instanceof TextDeclarationNode){
                    if(tempDcl.expressionNode != null) {
                        code.emit(tempDcl.Id.Name + " = ");
                        code.emitNL(exprGen.GenerateExprCode(code, tempDcl.expressionNode) + ";");
                    }
                    else{
                        code.emitNL(tempDcl.Id.Name + " = \"\";");
                    }

                }
                else if(tempDcl instanceof BooleanDeclarationNode){
                    if(tempDcl.expressionNode != null) {
                        code.emit(tempDcl.Id.Name + " = ");
                        code.emitNL(exprGen.GenerateExprCode(code, tempDcl.expressionNode) + ";");
                    }
                    else{
                        code.emitNL(tempDcl.Id.Name + " = false;");
                    }

                }
            }
        }
        code.emitNL("_stratChange = false; \n}");


        for(AbstractNode child : node.childList)
            if(child instanceof RoutineNode)
                visitNode(child);
    }

    @Override
    public void visit(SubtractionNode node, Object... arg){

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg){
        if (!partOfStratBody(node)) {
            int idCounter = 0;
            boolean exprFlag = false;

            //For-loop for handling the decleration(s)
            if (node.expressionNode != null){
                exprFlag = true;
            }
            for (AbstractNode id : node.childList) {
                if (id instanceof IdNode)
                    idCounter++;
            }

            generateDeclaration("String", node, exprFlag, idCounter);
        }
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg){
        if (!partOfStratBody(node)) {
            code.emit("String[] ");

            for (AbstractNode id : node.childList) {
                if (id instanceof IdNode) {
                    code.emit(((IdNode) id).Name + " = new String[(int)");
                } else if (id instanceof ExpressionNode) {
                    code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + "];");
                }
            }
        }
    }

    @Override
    public void visit(TextNode node, Object... arg) {

    }

    @Override
    public void visit(ValNode node, Object... arg) {

    }

    @Override
    public void visit(WhenNode node, Object... arg) {
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {
                visitNode(child);
            }
        }
    }

    @Override
    public void visit(WhileNode node, Object... arg){
        code.emit("while(");
        code.emit(exprGen.GenerateExprCode(code, node.Expression) + ")");
        code.emitNL("{");
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {

                visitNode(child);
                //Indents correctly in the output java file
                indent(child);

            }
        }

        code.emitNL("}");
    }

    @Override
    public void visit(RobotNameNode node, Object... arg) {

    }

    @Override
    public void visit(RobotTypeNode node, Object... arg){

    }

    @Override
    public void visit(RobotPropertiesNode node, Object... arg) {

    }
    //method for calculating number of needed indentions
    public void indent(AbstractNode node){
        int indentations = 0;

        while (node.Parent != null && !(node.Parent.Parent instanceof FunctionDeclarationNode) && !(node.Parent.Parent
                instanceof StrategyDeclarationNode)) {
            node = node.Parent; //we only increase the value, if we are at a blocknode.
            if (node instanceof BlockNode) {
                indentations++; // we know we need to indent if we are at a blocknode
            }
            if (node.Parent instanceof RoutineNode || node.Parent instanceof  WhenNode)
                indentations--;
        }

        for(int i = 0; i < indentations; i++){
            code.emit("\t");
        }
    }
}