package FIRe;

import java.util.ArrayList;
import java.util.List;

//Visitor used to check the declerations of functions, events and strategies
public class FESVisitor extends ASTVisitor{

    public List<FunctionDeclarationNode> functionDeclarationNodes = new ArrayList<FunctionDeclarationNode>();
    public List<EventDeclarationNode> eventDeclarationNodes = new ArrayList<EventDeclarationNode>();
    public List<StrategyDeclarationNode> strategyDeclarationNodes = new ArrayList<StrategyDeclarationNode>();

    @Override
    public void visit(AbstractNode node) {

    }

    @Override
    public void visit(AdditionNode node) throws Exception {

    }

    @Override
    public void visit(ActualParameterNode node) {

    }

    @Override
    public void visit(AndNode node) throws Exception {

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
    public void visit(BooleanDeclarationNode node) throws Exception {

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
    public void visit(ControlStructureNode node) {

    }

    @Override
    public void visit(DeclarationNode node) {

    }

    @Override
    public void visit(DivisionNode node) {

    }

    @Override
    public void visit(EventDeclarationNode node) throws Exception {
        eventDeclarationNodes.add(node);
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
    public void visit(FunctionDeclarationNode node) throws Exception {
        functionDeclarationNodes.add(node);

        for (AbstractNode node1: node.childList) {
            if(node1 instanceof ReturnNode)
                VisitNode(node1);
        }

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
    public void visit(IdNode node) throws Exception {

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

    }

    @Override
    public void visit(NotEqualsNode node) {

    }

    @Override
    public void visit(NotNode node) {

    }

    @Override
    public void visit(NumberDeclarationNode node) throws Exception {

    }

    @Override
    public void visit(NumberNode node) {

    }

    @Override
    public void visit(OrNode node) {

    }

    @Override
    public void visit(PowerNode node) {

    }

    @Override
    public void visit(ProgNode node) {
        for (AbstractNode Node : node.childList) {
            if(Node != null && Node instanceof FunctionDeclarationNode) // this should be enough since Funcdclsnode will be a direct child of ProgNode
                VisitNode(Node);
            if(Node != null && Node instanceof EventDeclarationNode)
                VisitNode(Node);
            if(Node != null && Node instanceof StrategyDeclarationNode)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(RadarColorNode node) {

    }

    @Override
    public void visit(ReturnNode node) {
        for (AbstractNode node1: node.childList){
            VisitNode(node1);
        }

    }

    @Override
    public void visit(RobotDclBodyNode node) {

    }

    @Override
    public void visit(RoutineNode node) {

    }

    @Override
    public void visit(StatementNode node) {

    }

    @Override
    public void visit(StrategyDeclarationNode node) throws Exception {
        strategyDeclarationNodes.add(node);
    }

    @Override
    public void visit(SubtractionNode node) {

    }

    @Override
    public void visit(TextDeclarationNode node) throws Exception {

    }

    @Override
    public void visit(TextNode node) {

    }

    @Override
    public void visit(ValNode node) {

    }

    @Override
    public void visit(WhenNode node) {

    }

    @Override
    public void visit(WhileNode node) {

    }
}
