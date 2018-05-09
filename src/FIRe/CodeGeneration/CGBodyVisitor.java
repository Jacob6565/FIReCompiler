package FIRe.CodeGeneration;

import FIRe.ASTVisitor;
import FIRe.ContextualAnalysis.SymbolData;
import FIRe.ContextualAnalysis.SymbolTable;
import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.SymbolNotFoundException;
import FIRe.Exceptions.TypeException;
import FIRe.Nodes.*;

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

    @Override
    public void visit(AbstractNode node, Object... arg) {

    }

    @Override
    public void visit(AdditionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {

    }

    @Override
    public void visit(AndNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ArrayAccessNode node, Object... arg) throws TypeException {

    }

    //Method also handles array assignment
    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {
        code.emit(node.Id.Name);
        if(node.Id.ArrayIndex != null) {
            code.emit("[(int)"); //Conversion necessary for the index of the array
            code.emit(exprGen.GenerateExprCode(code, node.Id.ArrayIndex) + "]");
        }
        code.emit(" = ");
        code.emitNL(exprGen.GenerateExprCode(code, node.Expression) + ";");
    }

    boolean stopBodyGen = false;

    @Override
    public void visit(BlockNode node,Object... arg) throws Exception {
        int numberOfIdents = 0;

        for(AbstractNode child : node.childList) {
            if(!stopBodyGen)
            {
                numberOfIdents = CalculateTabs(child);
                for(int i = 0; i < numberOfIdents; i++){
                    code.emit("\t");
                }
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
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {
        if (!partOfStratBody(node)) {
            int idCounter = 0;
            boolean exprFlag = false;


            for (AbstractNode id : node.childList) {
                if (id instanceof IdNode)
                    idCounter++;
                else if (id instanceof ExpressionNode)
                    exprFlag = true;
            }
            code.emit("boolean ");

            //For loop that checks how the declaration should be emitted (E.g. with commas and multiple variables etc.)
            for (AbstractNode id : node.childList) {
                if (id instanceof IdNode && idCounter > 1) {
                    code.emit(((IdNode) id).Name + ", ");
                    idCounter--;
                } else if (id instanceof IdNode && exprFlag) {
                    code.emit(((IdNode) id).Name + " = ");
                } else if (id instanceof IdNode) {
                    code.emitNL(((IdNode) id).Name + ";");
                } else if (id instanceof ExpressionNode) {
                    code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + ";");
                }
            }
        }
    }

    //Creates the java code for bool array dcls. These are handled the same way for numbers and texts.
    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
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
    public void visit(DivisionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws Exception {
        for (AbstractNode child: node.childList) {
            visitNode(child);
        }
    }

    @Override
    public void visit(EqualsNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {
        exprGen.GenerateExprCode(code, node);
    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {

    }

    @Override
    public void visit(ForNode node, Object... arg) throws TypeException, ReturnException {
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
                for(int i = 0; i < CalculateTabs(child); i++){
                    code.emit("\t");
                }
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
    public void visit(FuncCallNode node, Object... arg) throws Exception {
        String name = node.Id.Name;
        boolean ofTypeStrategy = false;
        try{
            //Here we use the substring of name that begins on index 1, to avoid the underscore of the name when searching
            SymbolData symbolData = symbolTable.Search(name.substring(1));
            if (symbolData.nodeRef instanceof StrategyDeclarationNode)
                ofTypeStrategy = true;
        }
        catch (SymbolNotFoundException e){
        }

        //This case indicates that we are dealing with a strategy call
        if (ofTypeStrategy){
            AbstractNode ancestor = node.Parent.Parent;
            code.emit("currentStrategy_ = Strategy_." + node.Id.Name);
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
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {
        for(AbstractNode child : node.childList) {
            if (child instanceof BlockNode) {
                visitNode(child);
            }

        }
    }

    @Override
    public void visit(GEQNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GunColorNode node, Object... arg) {

    }

    @Override
    public void visit(IdNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) throws Exception {
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
                    for(int i = 0; i < CalculateTabs(Node); i++){
                        code.emit("\t");
                    }
                    code.emitNL("}");
                } else if (Node instanceof ExpressionNode && !firstTime) {
                    for(int i = 0; i < CalculateTabs(Node); i++){
                        code.emit("\t");
                    }
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
    public void visit(InfixExpressionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(LEQNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(LessThanNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ModuloNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NegateNode node, Object... arg) {

    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NotNode node, Object... arg) {

    }

    //Handles single and multiple declerations of numbernodes
    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws Exception {
        if (!partOfStratBody(node)) {
            int idCounter = 0;
            boolean exprFlag = false;

            //For-loop for handling the decleration(s)
            for (AbstractNode id : node.childList) {
                if (id instanceof IdNode)
                    idCounter++;
                else if (id instanceof ExpressionNode)
                    exprFlag = true;
            }

            code.emit("double ");
            //For-loop for emitting the correct code
            for (AbstractNode id : node.childList) {
                if (id instanceof IdNode && idCounter > 1) {
                    code.emit(((IdNode) id).Name + ", ");
                    idCounter--;
                } else if (id instanceof IdNode && exprFlag) {
                    code.emit(((IdNode) id).Name + " = ");
                } else if (id instanceof IdNode) {
                    code.emitNL(((IdNode) id).Name + ";");
                } else if (id instanceof ExpressionNode) {
                    code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + ";");
                }
            }
        }
    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {
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
    public void visit(OrNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(PowerNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ProgNode node, Object... arg) throws Exception {

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
    public void visit(RoutineNode node, Object... arg) throws TypeException {
        if(node.repeatCondition != null) {
            code.emit("for(int i = (int)");
            code.emit(exprGen.GenerateExprCode(code, node.repeatCondition) + "; i > 0; i--)");
        }

        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {
                visitNode(child);
            }
        }

    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {
        for(AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {
        if (!partOfStratBody(node)) {
            int idCounter = 0;
            boolean exprFlag = false;

            //For-loop for handling declerations
            for (AbstractNode id : node.childList) {
                if (id instanceof IdNode)
                    idCounter++;
                else if (id instanceof ExpressionNode)
                    exprFlag = true;
            }

            code.emit("String ");

            //For-loop for emitting the correct syntax
            for (AbstractNode id : node.childList) {
                if (id instanceof IdNode && idCounter > 1) {
                    code.emit(((IdNode) id).Name + ", ");
                    idCounter--;
                } else if (id instanceof IdNode && exprFlag) {
                    code.emit(((IdNode) id).Name + " = ");
                } else if (id instanceof IdNode) {
                    code.emitNL(((IdNode) id).Name + ";");
                } else if (id instanceof ExpressionNode) {
                    code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + ";");
                }
            }
        }
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        if (!partOfStratBody(node)) {
            code.emit("String[] ");

            for (AbstractNode id : node.childList) {
                if (id instanceof IdNode) {
                    code.emit(((IdNode) id).Name + " = new[(int)");
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
    public void visit(WhileNode node, Object... arg) throws TypeException {
        code.emit("while(");
        code.emit(exprGen.GenerateExprCode(code, node.Expression) + ")");
        code.emitNL("{");
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {

                visitNode(child);
                //Indents correctly in the output java file
                for(int i = 0; i < CalculateTabs(child); i++){
                    code.emit("\t");
                }
            }
        }

        code.emitNL("}");
    }

    @Override
    public void visit(RobotNameNode node, Object... arg) {

    }

    @Override
    public void visit(RobotTypeNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(RobotPropertiesNode node, Object... arg) {

    }
    //method for calculating number of needed indentions
    public int CalculateTabs(AbstractNode node){
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
        return indentations; //returns the number of indentions
    }
}