package FIRe;

import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.TypeException;

public class CGFunctionVisitor extends ASTVisitor {
    CodeHolder code;
    FunctionDeclarationNode func;
    CGExpressionVisitor exprGen;

    CGFunctionVisitor(){
        exprGen = new CGExpressionVisitor();
    }

    String GenerateFuncCode(CodeHolder CH, FunctionDeclarationNode funcNode){
        code = CH;
        func = funcNode;
        VisitNode(func);
        return "";
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

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {
        code.emitNL(node.Id.Name + " = " + exprGen.GenerateExprCode(code, node.Expression) + ";");
    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {
        for(AbstractNode child : node.childList)
            VisitNode(child);
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
                code.emit(((IdNode) id).Name + "[");
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

    }

    @Override
    public void visit(EqualsNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {

    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {

    }

    @Override
    public void visit(ForNode node, Object... arg) throws TypeException, ReturnException {
        boolean dclUsed = false;
        code.emit("for(");
        if (node.Dcl != null && node.Dcl.childList.get(1) instanceof ExpressionNode){
            code.emit(node.Dcl.Id.Name + " = " + exprGen.GenerateExprCode(code, (ExpressionNode) node.Dcl.childList.get(1)) + ";");
            dclUsed = true;
        }
        else if(node.Dcl != null){
            code.emit(node.Dcl.Id.Name + " = " + "0;");
            dclUsed = true;
        }
        else if(node.From != null){
            code.emit(";");
        }

        if(node.Incremental && dclUsed)
            code.emit(" " + node.Dcl.Id.Name + " < (int)" + exprGen.GenerateExprCode(code, (ExpressionNode) node.To) + ";");
        else if(node.Incremental && !dclUsed)
            code.emit(" " + node.From + " < (int)" + exprGen.GenerateExprCode(code, (ExpressionNode) node.To) + ";");
        else if(!node.Incremental && dclUsed)
            code.emit(" " + node.Dcl.Id.Name + " > (int)" + exprGen.GenerateExprCode(code, (ExpressionNode) node.To) + ";");
        else if(!node.Incremental && !dclUsed)
            code.emit(" " + node.From + " > (int)" + exprGen.GenerateExprCode(code, (ExpressionNode) node.To) + ";");

        code.emitNL("{");

        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode)
                VisitNode(child);
        }

        code.emitNL("}");
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {
        for(AbstractNode child : node.childList) {
            if (child instanceof BlockNode)
                VisitNode(child);

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

    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {

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

    }

    @Override
    public void visit(RobotDclBodyNode node, Object... arg) {

    }

    @Override
    public void visit(RoutineNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextNode node, Object... arg) {

    }

    @Override
    public void visit(ValNode node, Object... arg) {

    }

    @Override
    public void visit(WhenNode node, Object... arg) {

    }

    @Override
    public void visit(WhileNode node, Object... arg) throws TypeException {

    }
}
