package FIRe;


/*
* Each method then knows how to print out its node.
* To start it all, we just call the accept-method on the root
* of the AST which then will call its children's accept-methods and so forth.*/

import java.util.Map;

public class PrintTraversal extends ASTVisitor{

    @Override
    public void visit(AbstractNode node) {

    }

    @Override
    public void visit(AdditionNode node) {
        System.out.println("plus");
    }

    @Override
    public void visit(ActualParameterNode node) {
        System.out.println("Actual Parameters");
    }

    @Override
    public void visit(AndNode node) {
        System.out.println("And");
    }

    @Override
    public void visit(ArrayAccessNode node) {
        System.out.println("Array Access");
    }

    @Override
    public void visit(AssignNode node) {
        System.out.println("Assignment");
    }

    @Override
    public void visit(BlockNode node) {
        System.out.println("Block");
    }

    @Override
    public void visit(BodyColorNode node) {
        System.out.println("Body Color");
    }

    @Override
    public void visit(BooleanDeclarationNode node) {
        System.out.println("Boolean Declaration");
    }

    @Override
    public void visit(BoolNode node) {
        System.out.println("Bool Node");
    }

    @Override
    public void visit(Color node) {
        System.out.println("Color");
    }

    @Override
    public void visit(ColorValNode node) {
        System.out.println("Color Value");
    }

    @Override
    public void visit(ConditionDeclarationNode node) {
        System.out.println("Condition Declaration");
    }

    @Override
    public void visit(ControlStructureNode node) {
        //Abstract - burde
    }

    @Override
    public void visit(DeclarationNode node) {
        //abstract?
    }

    @Override
    public void visit(DivisionNode node) {
        System.out.println("Division");
    }

    @Override
    public void visit(EqualsNode node) {
        System.out.println("Equals");
    }

    @Override
    public void visit(ExpressionNode node) {
        //abstract
    }

    @Override
    public void visit(FormalParameterNode node) {
        System.out.println("Formal Parameters");
        for(Map.Entry<AbstractNode, String> set : node.parameterMap.entrySet())
        {
            //Just printing the types.
            System.out.print(set.getValue().toString());
            //Calling the visit method for all the id nodes.
            visit(set.getKey());
        }
    }

    @Override
    public void visit(ForNode node) {
        System.out.println("For");
    }

    @Override
    public void visit(FuncCallNode node) {
        System.out.println("Function Call");
    }

    @Override
    public void visit(FunctionDeclarationNode node) {
        System.out.println("Function Declaration");
    }

    @Override
    public void visit(GEQNode node) {
        System.out.println("Greater than or equal to");
    }

    @Override
    public void visit(GreaterThanNode node) {
        System.out.println("Greater than");
    }

    @Override
    public void visit(GunColorNode node) {
        System.out.println("Gun Color");
    }

    @Override
    public void visit(IdNode node) {
        System.out.println("Id");
    }

    @Override
    public void visit(IfControlStructureNode node) {
        System.out.println("If");
    }

    @Override
    public void visit(InfixExpressionNode node) {
        //abstract
    }

    @Override
    public void visit(LEQNode node) {
        System.out.println("Less than or equal to");
    }

    @Override
    public void visit(LessThanNode node) {
        System.out.println("Less than");
    }

    @Override
    public void visit(ModuloNode node) {
        System.out.println("Modulo");
    }

    @Override
    public void visit(MultiplicationNode node) {
        System.out.println("Multiplication");
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
