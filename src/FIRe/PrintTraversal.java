package FIRe;


/*
* Each method then knows how to print out its node.
* To start it all, we just call the accept-method on the root
* of the AST which then will call its childrens accept-methods and so forth.*/

public class PrintTraversal extends ASTVisitor{

    @Override
    public void visit(AbstractNode node) {

    }

    @Override
    public void visit(AdditionNode node) {

    }

    @Override
    public void visit(ActualParameterNode node) {

    }

    @Override
    public void visit(AndNode node) {

    }

    @Override
    public void visit(ArrayAccessNode node) {

    }

    @Override
    public void visit(AssignNode node) {

    }

    @Override
    public void visit(BlockNode node) {

    }

    @Override
    public void visit(BodyColorNode node) {

    }

    @Override
    public void visit(BooleanDeclarationNode node) {

    }

    @Override
    public void visit(BoolNode node) {

    }

    @Override
    public void visit(Color node) {

    }

    @Override
    public void visit(ColorValNode node) {

    }

    @Override
    public void visit(ConditionDeclarationNode node) {

    }

    @Override
    public void visit(ControlStructureNode node) {

    }

    @Override
    public void visit(DeclarationNode node) {

    }

    @Override
    public void visit(DivisionNode node) {

    }

    @Override
    public void visit(EqualsNode node) {

    }

    @Override
    public void visit(ExpressionNode node) {

    }

    @Override
    public void visit(FormalParameterNode node) {

    }

    @Override
    public void visit(ForNode node) {

    }

    @Override
    public void visit(FuncCallNode node) {

    }

    @Override
    public void visit(FunctionDeclarationNode node) {

    }

    @Override
    public void visit(GEQNode node) {

    }

    @Override
    public void visit(GreaterThanNode node) {

    }

    @Override
    public void visit(GunColorNode node) {

    }

    @Override
    public void visit(IdNode node) {

    }

    @Override
    public void visit(IfControlStructureNode node) {

    }

    @Override
    public void visit(InfixExpressionNode node) {

    }

    @Override
    public void visit(LEQNode node) {

    }

    @Override
    public void visit(LessThanNode node) {

    }

    @Override
    public void visit(ModuloNode node) {

    }

    @Override
    public void visit(MultiplicationNode node) {

    }

    @Override
    public void visit(NegateNode node) {
        System.out.println("NegateNode");
    }

    @Override
    public void visit(NotEqualsNode node) {
        System.out.println("NotEqualsNode");
    }

    @Override
    public void visit(NotNode node) {
        System.out.println("NotNode");
    }

    @Override
    public void visit(NumberDeclarationNode node) {
        System.out.println("NumDclNode");
    }

    @Override
    public void visit(NumberNode node) {
        System.out.println(node.value);
    }

    @Override
    public void visit(OrNode node) {
        System.out.println("OrNode");
    }

    @Override
    public void visit(PowerNode node) {
        System.out.println("PowerNode");
    }

    @Override
    public void visit(ProgNode node) {
        System.out.println("ProgNode");
    }

    @Override
    public void visit(RadarColorNode node) {
        System.out.println("RadarColorNode");
    }

    @Override
    public void visit(ReturnNode node) {
        System.out.println("ReturnNode");
    }

    @Override
    public void visit(RobotDclBodyNode node) {
        System.out.println("RobotDclBodyNode");
    }

    @Override
    public void visit(RoutineNode node) {
        System.out.println("RoutineNode");
    }

    @Override
    public void visit(StatementNode node) {
        System.out.println("StmtNode");
    }

    @Override
    public void visit(StrategyDeclarationNode node) {
        System.out.println("StratDclNode");
    }

    @Override
    public void visit(SubtractionNode node) {
        System.out.println("SubtractionNode");
    }

    @Override
    public void visit(TextDeclarationNode node) {
        System.out.println("TextDeclNode");
    }

    @Override
    public void visit(TextNode node) {
        System.out.println(node.Content);
    }

    @Override
    public void visit(ValNode node) {
        //Doesnt exist
    }

    @Override
    public void visit(WhenNode node) {
        System.out.println("when");
    }

    @Override
    public void visit(WhileNode node) {
        System.out.println("while");
    }
}
