package FIRe;

import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.TypeException;

public class CGFunctionVisitor extends ASTVisitor {
    CGFunctionVisitor(SymbolTable symbolTable){
        this();
        this.symbolTable = symbolTable;
    }
    CGFunctionVisitor(){
        exprGen = new CGExpressionVisitor();
        code = new MethodCodeHolder("bodyCode", "void");
    }

    CodeHolder code;
    FunctionDeclarationNode func;
    private CGExpressionVisitor exprGen;
    private SymbolTable symbolTable;

    String GenerateBodyCode(AbstractNode node){
        code = new MethodCodeHolder("bodyCode", "void");
        visitNode(node);
        return code.sb.toString();
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
        int i;
        while(true){}
    }

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {
        code.emit(node.Id.Name);
        if(node.Id.ArrayIndex != null) {
            code.emit("[(int)");
            code.emit(exprGen.GenerateExprCode(code, node.Id.ArrayIndex) + "]");
        }
        code.emit(" = ");
        code.emitNL(exprGen.GenerateExprCode(code, node.Expression) + ";");
    }

    @Override
    public void visit(BlockNode node,Object... arg) throws Exception {
        int numberOfIdents = 0;

        for(AbstractNode child : node.childList) {
            numberOfIdents = CalculateTabs(child);
            for(int i = 0; i < numberOfIdents; i++){
                code.emit("\t");
            }
            visitNode(child);
        }
    }


    @Override
    public void visit(BodyColorNode node, Object... arg) {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {
        int idCounter = 0;
        boolean exprFlag = false;


        for(AbstractNode id : node.childList){
            if(id instanceof IdNode)
                idCounter++;
            else if(id instanceof ExpressionNode)
                exprFlag = true;
        }
        code.emit("boolean ");

        for(AbstractNode id : node.childList){
            if(id instanceof IdNode && idCounter > 1){
                code.emit(((IdNode) id).Name + ", ");
                idCounter--;
            }

            else if(id instanceof IdNode && exprFlag){
                code.emit(((IdNode) id).Name + " = ");
            }

            else if(id instanceof IdNode){
                code.emitNL(((IdNode) id).Name + ";");
            }

            else if(id instanceof ExpressionNode){
                code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + ";");
            }
        }

    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
        code.emit("boolean ");

        for(AbstractNode id : node.childList){
            if(id instanceof IdNode){
                code.emit(((IdNode) id).Name + "[(int)");
            }

            else if(id instanceof ExpressionNode){
                code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + "];");
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
        boolean dclUsed = false;
        code.emit("for(");
        if (node.Dcl != null && node.Dcl.childList.get(1) instanceof ExpressionNode){
            code.emit("int " + node.Dcl.Id.Name + " = (int)");
            code.emit(exprGen.GenerateExprCode(code, (ExpressionNode) node.Dcl.childList.get(1)) + ";");
            dclUsed = true;
        }
        else if(node.Dcl != null){
            code.emit("int " + node.Dcl.Id.Name + " = " + "0;");
            dclUsed = true;
        }
        else if(node.From != null){
            code.emit(";");
        }

        if(node.Incremental && dclUsed) {
            code.emit(node.Dcl.Id.Name + " < (int)");
            code.emit(exprGen.GenerateExprCode(code, node.To) + "; " + node.Dcl.Id.Name + "++");
        }
        else if(node.Incremental && !dclUsed) {
            code.emit(" (int)");
            code.emit(exprGen.GenerateExprCode(code, node.From) + " < (int)");
            code.emit(exprGen.GenerateExprCode(code, node.To) + "; ");
            code.emit(exprGen.GenerateExprCode(code, node.From) + "++");
        }
        else if(!node.Incremental && dclUsed) {
            code.emit(node.Dcl.Id.Name + " > (int)");
            code.emit(exprGen.GenerateExprCode(code, node.To) + "; " + node.Dcl.Id.Name + "--");
        }
        else if(!node.Incremental && !dclUsed) {
            code.emit(" (int)");
            code.emit(exprGen.GenerateExprCode(code, node.From) + " > (int)");
            code.emit(exprGen.GenerateExprCode(code, node.To) + "; ");
            code.emit(exprGen.GenerateExprCode(code, node.From) + "--");
        }

        code.emitNL("){");

        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {
                visitNode(child);
                for(int i = 0; i < CalculateTabs(child); i++){
                    code.emit("\t");
                }
            } else if (child instanceof ExpressionNode){
                visit(child);
            }
        }

        code.emitNL("}");
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) throws Exception {
        String name = node.Id.Name;

        //Here we use the substring of name that begins on index 1, to avoid the underscore of the name when searching
        SymbolData symbolData = symbolTable.Search(name.substring(1));
        if (symbolData != null && symbolData.nodeRef instanceof StrategyDeclarationNode){
            code.emit("changeStrategy = \"" + node.Id.Name + "\"\n" + "return");
        }
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

        int icount = 0;
        int bcount = 0;

        int size = node.childList.size();

        for (AbstractNode Node : node.childList) {
            if (Node instanceof ExpressionNode) {
                icount++;
            } else if (Node instanceof BlockNode) {
                bcount++;
            }
        }

        if (bcount == icount) { // this is determines if the if-else chain ends with an else if
            boolean firstTime = true;
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

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws Exception {
        int idCounter = 0;
        boolean exprFlag = false;

        for(AbstractNode id : node.childList){
            if(id instanceof IdNode)
                idCounter++;
            else if(id instanceof ExpressionNode)
                exprFlag = true;
        }

        code.emit("double ");

        for(AbstractNode id : node.childList){
            if(id instanceof IdNode && idCounter > 1){
                code.emit(((IdNode) id).Name + ", ");
                idCounter--;
            }

            else if(id instanceof IdNode && exprFlag){
                code.emit(((IdNode) id).Name + " = ");
            }

            else if(id instanceof IdNode){
                code.emitNL(((IdNode) id).Name + ";");
            }

            else if(id instanceof ExpressionNode){
                code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + ";");
            }
        }
    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {
        code.emit("double ");

        for(AbstractNode id : node.childList){
            if(id instanceof IdNode){
                code.emit(((IdNode) id).Name + "[(int)");
            }

            else if(id instanceof ExpressionNode){
                code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + "];");
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
        code.emit("while(");
        if(node.repeatCondition != null)
            code.emit(exprGen.GenerateExprCode(code, node.repeatCondition) + ")");
        else
            code.emit("true)");

        code.emitNL("{");

        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {
                visitNode(child);
            }
        }

        code.emitNL("}");

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
        int idCounter = 0;
        boolean exprFlag = false;

        for(AbstractNode id : node.childList){
            if(id instanceof IdNode)
                idCounter++;
            else if(id instanceof ExpressionNode)
                exprFlag = true;
        }

        code.emit("String ");

        for(AbstractNode id : node.childList){
            if(id instanceof IdNode && idCounter > 1){
                code.emit(((IdNode) id).Name + ", ");
                idCounter--;
            }

            else if(id instanceof IdNode && exprFlag){
                code.emit(((IdNode) id).Name + " = ");
            }

            else if(id instanceof IdNode){
                code.emitNL(((IdNode) id).Name + ";");
            }

            else if(id instanceof ExpressionNode){
                code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + ";");
            }
        }
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        code.emit("String ");

        for(AbstractNode id : node.childList){
            if(id instanceof IdNode){
                code.emit(((IdNode) id).Name + "[(int)");
            }

            else if(id instanceof ExpressionNode){
                code.emitNL(exprGen.GenerateExprCode(code, (ExpressionNode) id) + "];");
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
        //code.emitNL("{");
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {
                visitNode(child);
            }
        }
        //code.emitNL("}");
    }

    @Override
    public void visit(WhileNode node, Object... arg) throws TypeException {
        code.emit("while(");
        code.emit(exprGen.GenerateExprCode(code, node.Expression) + ")");
        code.emitNL("{");
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {

                visitNode(child);
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
        int indentions = 0;

        while (node.Parent != null && !(node.Parent.Parent instanceof FunctionDeclarationNode) && !(node.Parent.Parent
                                                                                instanceof StrategyDeclarationNode)) {
            node = node.Parent; //we only increase the value, if we are at a blocknode.
            if (node instanceof BlockNode) {
                indentions++; // we know we need to indent if we are at a blocknode
            }
        }
        return indentions; //returns the number of indentions
    }
}
