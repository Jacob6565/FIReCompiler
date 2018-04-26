package FIRe;

import FIRe.Exceptions.*;

import java.lang.reflect.Type;

//Så skal man lave en klasse som nedarver denne klasse og som implementerer
//en traverse metode for dem alle fx depth-first, som er standarden.
public abstract class ASTVisitor
{
    public void VisitNode(AbstractNode node) {
        try {
            if (node instanceof ProgNode) //comment so I can commit
                visit((ProgNode) node);
            else if (node instanceof ActualParameterNode)
                visit((ActualParameterNode) node);
            else if (node instanceof AdditionNode)
                visit((AdditionNode) node);
            else if (node instanceof AndNode)
                visit((AndNode) node);
            else if (node instanceof ArrayAccessNode)
                visit((ArrayAccessNode) node);
            else if (node instanceof AssignNode)
                visit((AssignNode) node);
            else if (node instanceof BlockNode)
                visit((BlockNode) node);
            else if (node instanceof BodyColorNode)
                visit((BodyColorNode) node);
            else if (node instanceof BooleanDeclarationNode)
                visit((BooleanDeclarationNode) node);
            else if (node instanceof BoolNode)
                visit((BoolNode) node);
            else if (node instanceof ColorValNode)
                visit((ColorValNode) node);
            else if (node instanceof DivisionNode)
                visit((DivisionNode) node);
            else if (node instanceof EventDeclarationNode)
                visit((EventDeclarationNode) node);
            else if (node instanceof EqualsNode)
                visit((EqualsNode) node);
            else if (node instanceof FormalParameterNode)
                visit((FormalParameterNode) node);
            else if (node instanceof ForNode)
                visit((ForNode) node);
            else if (node instanceof FuncCallNode)
                visit((FuncCallNode) node);
            else if (node instanceof FunctionDeclarationNode)
                visit((FunctionDeclarationNode) node);
            else if (node instanceof GEQNode)
                visit((GEQNode) node);
            else if (node instanceof GreaterThanNode)
                visit((GreaterThanNode) node);
            else if (node instanceof GunColorNode)
                visit((GunColorNode) node);
            else if (node instanceof IdNode)
                visit((IdNode) node);
            else if (node instanceof IfControlStructureNode)
                visit((IfControlStructureNode) node);
            else if (node instanceof LEQNode)
                visit((LEQNode) node);
            else if (node instanceof LessThanNode)
                visit((LessThanNode) node);
            else if (node instanceof ModuloNode)
                visit((ModuloNode) node);
            else if (node instanceof MultiplicationNode)
                visit((MultiplicationNode) node);
            else if (node instanceof NegateNode)
                visit((NegateNode) node);
            else if (node instanceof NotEqualsNode)
                visit((NotEqualsNode) node);
            else if (node instanceof NotNode)
                visit((NotNode) node);
            else if (node instanceof NumberDeclarationNode)
                visit((NumberDeclarationNode) node);
            else if (node instanceof NumberNode)
                visit((NumberNode) node);
            else if (node instanceof OrNode)
                visit((OrNode) node);
            else if (node instanceof PowerNode)
                visit((PowerNode) node);
            else if (node instanceof RadarColorNode)
                visit((RadarColorNode) node);
            else if (node instanceof ReturnNode)
                visit((ReturnNode) node);
            else if (node instanceof RobotDclBodyNode)
                visit((RobotDclBodyNode) node);
            else if (node instanceof RoutineNode)
                visit((RoutineNode) node);
            else if (node instanceof StrategyDeclarationNode)
                visit((StrategyDeclarationNode) node);
            else if (node instanceof SubtractionNode)
                visit((SubtractionNode) node);
            else if (node instanceof TextDeclarationNode)
                visit((TextDeclarationNode) node);
            else if (node instanceof TextNode)
                visit((TextNode) node);
            else if (node instanceof ValNode)
                visit((ValNode) node);
            else if (node instanceof WhenNode)
                visit((WhenNode) node);
            else if (node instanceof WhileNode)
                visit((WhileNode) node);
            else if (node instanceof BoolArrayDeclarationNode)
                visit((BoolArrayDeclarationNode) node);
            else if (node instanceof TextArrayDeclarationNode)
                visit((TextArrayDeclarationNode)node);
            else if (node instanceof NumberArrayDeclarationNode)
                visit((NumberArrayDeclarationNode)node);
            else if (node instanceof RobotNameNode)
                visit((RobotNameNode) node);
            else if (node instanceof RobotTypeNode)
                visit((RobotTypeNode) node);
            else if (node instanceof RobotPropertiesNode)
                visit((RobotPropertiesNode) node);
            else
                System.out.println("Error");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public abstract void visit(AbstractNode node, Object... arg);
    public abstract void visit(AdditionNode node, Object... arg) throws Exception;
    public abstract void visit(ActualParameterNode node, Object... arg);
    public abstract void visit(AndNode node, Object... arg) throws Exception;
    public abstract void visit(ArrayAccessNode node, Object... arg) throws TypeException;
    public abstract void visit(AssignNode node, Object... arg) throws Exception;
    public abstract void visit(BlockNode node, Object... arg) throws Exception;
    public abstract void visit(BodyColorNode node, Object... arg) throws TypeException;
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
    public abstract void visit(ForNode node, Object... arg) throws TypeException,ReturnException;
    public abstract void visit(FuncCallNode node, Object... arg) throws Exception;
    public abstract void visit(FunctionDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(GEQNode node, Object... arg) throws Exception;
    public abstract void visit(GreaterThanNode node, Object... arg) throws Exception;
    public abstract void visit(GunColorNode node, Object... arg) throws TypeException;
    public abstract void visit(IdNode node, Object... arg) throws Exception;
    public abstract void visit(IfControlStructureNode node, Object... arg) throws Exception;
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
    public abstract void visit(ProgNode node, Object... arg) throws Exception;
    public abstract void visit(RadarColorNode node, Object... arg) throws TypeException;
    public abstract void visit(ReturnNode node, Object... arg) throws TypeException;
    public abstract void visit(RobotDclBodyNode node, Object... arg) throws TypeException;
    public abstract void visit(RoutineNode node, Object... arg) throws TypeException;
    public abstract void visit(StatementNode node, Object... arg);
    public abstract void visit(StrategyDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(SubtractionNode node, Object... arg) throws Exception;
    public abstract void visit(TextDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(TextArrayDeclarationNode node, Object... arg) throws Exception;
    public abstract void visit(TextNode node, Object... arg);
    public abstract void visit(ValNode node, Object... arg);
    public abstract void visit(WhenNode node, Object... arg);
    public abstract void visit(WhileNode node, Object... arg) throws TypeException;
    public abstract void visit(RobotNameNode node, Object... arg);
    public abstract void visit(RobotTypeNode node, Object... arg) throws TypeException;
    public abstract void visit(RobotPropertiesNode node, Object... arg);
}