package FIRe;

import java.beans.Expression;

//Så skal man lave en klasse som nedarver denne klasse og som implementerer
//en traverse metode for dem alle fx depth-first, som er standarden.
public abstract class ASTVisitor
{
    //Har en overloaded visitmetode for hver node.
    //Dette er lavet på baggrund af slide 82 lecture 9
    public abstract void visit(AbstractNode node);
    public abstract void visit(AdditionNode node);
    public abstract void visit(ActualParameterNode node);
    public abstract void visit(AndNode node);
    public abstract void visit(ArrayAccessNode node);
    public abstract void visit(AssignNode node);
    public abstract void visit(BlockNode node);
    public abstract void visit(BodyColorNode node);
    public abstract void visit(BooleanDeclarationNode node) throws Exception;
    public abstract void visit(BoolNode node);
    public abstract void visit(Color node);
    public abstract void visit(ColorValNode node);
    public abstract void visit(ControlStructureNode node);
    public abstract void visit(DeclarationNode node);
    public abstract void visit(DivisionNode node);
    public abstract void visit(EventDeclarationNode node) throws Exception;
    public abstract void visit(EqualsNode node);
    public abstract void visit(ExpressionNode node);
    public abstract void visit(FormalParameterNode node);
    public abstract void visit(ForNode node);
    public abstract void visit(FuncCallNode node);
    public abstract void visit(FunctionDeclarationNode node) throws Exception;
    public abstract void visit(GEQNode node);
    public abstract void visit(GreaterThanNode node);
    public abstract void visit(GunColorNode node);
    public abstract void visit(IdNode node) throws Exception;
    public abstract void visit(IfControlStructureNode node);
    public abstract void visit(InfixExpressionNode node);
    public abstract void visit(LEQNode node);
    public abstract void visit(LessThanNode node);
    public abstract void visit(ModuloNode node);
    public abstract void visit(MultiplicationNode node);
    public abstract void visit(NegateNode node);
    public abstract void visit(NotEqualsNode node);
    public abstract void visit(NotNode node);
    public abstract void visit(NumberDeclarationNode node) throws Exception;
    public abstract void visit(NumberNode node);
    public abstract void visit(OrNode node);
    public abstract void visit(PowerNode node);
    public abstract void visit(ProgNode node);
    public abstract void visit(RadarColorNode node);
    public abstract void visit(ReturnNode node);
    public abstract void visit(RobotDclBodyNode node);
    public abstract void visit(RoutineNode node);
    public abstract void visit(StatementNode node);
    public abstract void visit(StrategyDeclarationNode node) throws Exception;
    public abstract void visit(SubtractionNode node);
    public abstract void visit(TextDeclarationNode node) throws Exception;
    public abstract void visit(TextNode node);
    public abstract void visit(ValNode node);
    public abstract void visit(WhenNode node);
    public abstract void visit(WhileNode node);


}