package FIRe;

import java.beans.Expression;

//Så skal man lave en klasse som nedarver denne klasse og som implementerer
//en traverse metode for dem alle fx depth-first, som er standarden.
public abstract class ASTVisitor
{
    //Har en overloaded visitmetode for hver node.
    //Dette er lavet på baggrund af slide 82 lecture 9
    public abstract void visit(AbstractNode node, Object... arg);
    public abstract void visit(AdditionNode node, Object... arg) throws Exception;
    public abstract void visit(ActualParameterNode node, Object... arg);
    public abstract void visit(AndNode node, Object... arg) throws Exception;
    public abstract void visit(ArrayAccessNode node, Object... arg);
    public abstract void visit(AssignNode node, Object... arg) throws Exception;
    public abstract void visit(BlockNode node, Object... arg);
    public abstract void visit(BodyColorNode node, Object... arg);
    public abstract void visit(BooleanDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(BoolNode node, Object... arg);
    public abstract void visit(ColorValNode node, Object... arg);
    public abstract void visit(ControlStructureNode node, Object... arg);
    public abstract void visit(DeclarationNode node, Object... arg);
    public abstract void visit(DivisionNode node, Object... arg) throws Exception;
    public abstract void visit(EventDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(EqualsNode node, Object... arg) throws Exception;
    public abstract void visit(ExpressionNode node, Object... arg);
    public abstract void visit(FormalParameterNode node, Object... arg);
    public abstract void visit(ForNode node, Object... arg);
    public abstract void visit(FuncCallNode node, Object... arg);
    public abstract void visit(FunctionDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(GEQNode node, Object... arg) throws Exception;
    public abstract void visit(GreaterThanNode node, Object... arg) throws Exception;
    public abstract void visit(GunColorNode node, Object... arg);
    public abstract void visit(IdNode node, Object... arg) throws Exception;
    public abstract void visit(IfControlStructureNode node, Object... arg);
    public abstract void visit(InfixExpressionNode node, Object... arg) throws Exception;
    public abstract void visit(LEQNode node, Object... arg) throws Exception;
    public abstract void visit(LessThanNode node, Object... arg) throws Exception;
    public abstract void visit(ModuloNode node, Object... arg) throws Exception;
    public abstract void visit(MultiplicationNode node, Object... arg) throws Exception;
    public abstract void visit(NegateNode node, Object... arg);
    public abstract void visit(NotEqualsNode node, Object... arg) throws Exception;
    public abstract void visit(NotNode node, Object... arg);
    public abstract void visit(NumberDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(NumberNode node, Object... arg);
    public abstract void visit(OrNode node, Object... arg) throws Exception;
    public abstract void visit(PowerNode node, Object... arg) throws Exception;
    public abstract void visit(ProgNode node, Object... arg);
    public abstract void visit(RadarColorNode node, Object... arg);
    public abstract void visit(ReturnNode node, Object... arg);
    public abstract void visit(RobotDclBodyNode node, Object... arg);
    public abstract void visit(RoutineNode node, Object... arg);
    public abstract void visit(StatementNode node, Object... arg);
    public abstract void visit(StrategyDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(SubtractionNode node, Object... arg) throws Exception;
    public abstract void visit(TextDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(TextArrayDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(TextNode node, Object... arg);
    public abstract void visit(ValNode node, Object... arg);
    public abstract void visit(WhenNode node, Object... arg);
    public abstract void visit(WhileNode node, Object... arg);
}