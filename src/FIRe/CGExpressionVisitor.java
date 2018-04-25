package FIRe;

import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.TypeException;

public class CGExpressionVisitor extends ASTVisitor{
    //ExpressionNode expr;
    CodeHolder code;


    CGExpressionVisitor(CodeHolder CH, ExpressionNode expr){
        code = CH;
        //expr = expression;
        VisitNode(expr);
    }


    @Override
    public void visit(AbstractNode node, Object... arg) {

    }

    @Override
    public void visit(AdditionNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" + ");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {

    }

    @Override
    public void visit(AndNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" && ");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(ArrayAccessNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BodyColorNode node, Object... arg) {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BoolNode node, Object... arg) {
        if(node.value == true)
            code.emit("true");
        else if(node.value == false)
            code.emit("false");
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
        VisitNode(node.LeftChild);
        code.emit("/");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(EqualsNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" == ");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {

    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {

    }

    @Override
    public void visit(ForNode node, Object... arg) throws TypeException, ReturnException {

    }

    @Override
    public void visit(FuncCallNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GEQNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" >= ");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" > ");
        VisitNode(node.RightChild);
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
        VisitNode(node.LeftChild);
        code.emit(" <= ");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(LessThanNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" < ");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(ModuloNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" % ");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" * ");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(NegateNode node, Object... arg) {
        code.emit("-");
        visit(node.childList.get(0));
    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" != ");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(NotNode node, Object... arg) {
        code.emit("!");
        VisitNode(node.Expression);
    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NumberNode node, Object... arg) {
        code.emit(node.value);
    }

    @Override
    public void visit(OrNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" || ");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(PowerNode node, Object... arg) throws Exception {
        code.emit("Math.pow(");
        VisitNode(node.LeftChild);
        code.emit(", ");
        VisitNode(node.RightChild);
        code.emit(") ");
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
        VisitNode(node.LeftChild);
        code.emit(" - ");
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextNode node, Object... arg) {
        code.emit("\"" + node.Content + "\"");
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
