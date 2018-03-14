package FIRe;

//Så skal man lave en klasse som nedarver denne klasse og som implementerer
//en traverse metode for dem alle fx depth-first, som er standarden.
public abstract class ASTVisitor<T>
{
    //Har en overloaded visitmetoder for hver node.
    //Dette er lavet på baggrund af slide 82 lecture 9
    public abstract T visit(AdditionNode node);
    public abstract T visit(AndNode node);
    public abstract T visit(AssignNode node);
    public abstract T visit(BodyColorNode node);
    public abstract T visit(BooleanDeclarationNode node);
    public abstract T visit(BoolNode node);
    public abstract T visit(Color node);
    public abstract T visit(ColorValNode node);
    public abstract T visit(ConditionDeclarationNode node);
    public abstract T visit(ControlStructureNode node);
    public abstract T visit(DeclarationNode node);
    public abstract T visit(DivisionNode node);
    public abstract T visit(ForNode node);
    public abstract T visit(FunctionDeclarationNode node);
    public abstract T visit(GunColorNode node);
    public abstract T visit(IdNode node);
    public abstract T visit(IfControlStructureNode node);
    public abstract T visit(InfixExpressionNode node);
    public abstract T visit(ModuloNode node);
    public abstract T visit(MultiplicationNode node);
    public abstract T visit(NegateNode node);
    public abstract T visit(NotNode node);
    public abstract T visit(NumberDeclarationNode node);
    public abstract T visit(NumberNode node);
    public abstract T visit(OrNode node);
    public abstract T visit(PowerNode node);
    public abstract T visit(RadarColorNode node);
    public abstract T visit(ReturnNode node);
    public abstract T visit(RobotPropertiesNode node);
    public abstract T visit(RoutineNode node);
    public abstract T visit(StatementNode node);
    public abstract T visit(StrategyDeclarationNode node);
    public abstract T visit(TextDeclarationNode node);
    public abstract T visit(TextNode node);
    public abstract T visit(TypeFuncCallNode node);
    public abstract T visit(VoidFuncCallNode node);
    public abstract T visit(WhenNode node);
    public abstract T visit(WhileNode node);

    //Det er så disse som skal have if/else eller switches ud fra duden på stackoverflow.
    //Da Java ikke har keyworded "dynamic" 
    public abstract T visit(AbstractNode node);
    public abstract T visit(ExpressionNode node);



}