package FIRe;

import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.SymbolNotFoundException;
import FIRe.Exceptions.TypeException;

public class CGStrategyVisitor extends ASTVisitor {
    CodeHolder CH;

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
    public void visit(ArrayAccessNode node, Object... arg) throws TypeException, SymbolNotFoundException {

    }

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BodyColorNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {
        CH.emit("boolean");
        for(AbstractNode Node: node.childList) {
            VisitNode(Node);
        }
    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
        CH.emit("boolean");
        for(AbstractNode Node: node.childList) {
            VisitNode(Node);
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
        for (AbstractNode Node:node.childList) {
            VisitNode(Node);
        }

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

    }

    @Override
    public void visit(FuncCallNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GEQNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GunColorNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(IdNode node, Object... arg) throws Exception {
        CH.emit(node.Name);

        CGExpressionVisitor CGE = new CGExpressionVisitor();

        if (node.Parent instanceof ArrayDeclarationNode) {
            CH.emit("[");
            CGE.GenerateExprCode(CH,node); //Det er en måske
            CH.emit("]");
        }
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
        CH.emit("double");
        for (AbstractNode Node: node.childList) {
            visit(Node);
        }

    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {
        CH.emit("double ");
        for (AbstractNode Node: node.childList) {
            VisitNode(Node);
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
    public void visit(RadarColorNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(RobotDclBodyNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(RoutineNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {
        for (AbstractNode Node: node.childList) {
            VisitNode(Node);
        }
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {
        CH.emit("text");
        for(AbstractNode Node: node.childList) {
            VisitNode(Node);
        }
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        CH.emit("text");
        for(AbstractNode Node: node.childList) {
            VisitNode(Node);
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

    }

    @Override
    public void visit(WhileNode node, Object... arg) throws TypeException {

    }
}
