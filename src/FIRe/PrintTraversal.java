package FIRe;


/*
* Each method then knows how to print out its node.
* To start it all, we just call the accept-method on the root
* of the AST which then will call its children's accept-methods and so forth.*/

import com.sun.java.accessibility.util.TopLevelWindowListener;

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
            System.out.print("            " + set.getValue().toString());
            //Calling the visit method for all the id nodes.
            visit((IdNode) set.getKey());
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
        System.out.println(node.name);
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

    public void Print(AbstractNode node, int level){
        String ToPrint = "";
        StringBuilder SB = new StringBuilder(ToPrint);
        for (int i = 0; i < level; ++i){
            SB.append("    ");
        }

        System.out.print(SB.toString());
        printNode(node);
        if (!(node instanceof InfixExpressionNode))
        for (int i = 0; i < node.childList.size();++i){
            if (node.childList.get(i) != null)
                Print(node.childList.get(i),level+1);
        }
        else {
            Print(((InfixExpressionNode) node).LeftChild, level + 1);
            Print(((InfixExpressionNode) node).RightChild, level + 1);
        }
    }

    private void printNode(AbstractNode node){
        if (node instanceof ProgNode)
            visit((ProgNode) node);
        else if (node instanceof ActualParameterNode)
            visit ((ActualParameterNode) node);
        else if (node instanceof AdditionNode)
            visit ((AdditionNode) node);
        else if (node instanceof AndNode)
            visit ((AndNode) node);
        else if (node instanceof ArrayAccessNode)
            visit ((ArrayAccessNode) node);
        else if (node instanceof AssignNode)
            visit ((AssignNode) node);
        else if (node instanceof BlockNode)
            visit ((BlockNode) node);
        else if (node instanceof BodyColorNode)
            visit ((BodyColorNode) node);
        else if (node instanceof BooleanDeclarationNode)
            visit ((BooleanDeclarationNode) node);
        else if (node instanceof BoolNode)
            visit ((BoolNode) node);
        else if (node instanceof ColorValNode)
            visit((ColorValNode) node);
        else if (node instanceof ConditionDeclarationNode)
            visit((ConditionDeclarationNode) node);
        else if (node instanceof DivisionNode)
            visit ((DivisionNode) node);
        else if (node instanceof EqualsNode)
            visit ((EqualsNode) node);
        else if (node instanceof FormalParameterNode)
            visit((FormalParameterNode) node);
        else if (node instanceof ForNode)
            visit((ForNode) node);
        else if (node instanceof FuncCallNode)
            visit((FuncCallNode) node);
        else if (node instanceof FunctionDeclarationNode)
            visit((FunctionDeclarationNode) node);
        else if (node instanceof GEQNode)
            visit ((GEQNode) node);
        else if (node instanceof GreaterThanNode)
            visit ((GreaterThanNode)node);
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
            visit ((NegateNode) node);
        else if (node instanceof NotEqualsNode)
            visit ((NotEqualsNode) node);
        else if (node instanceof NotNode)
            visit ((NotNode) node);
        else if (node instanceof NumberDeclarationNode)
            visit ((NumberDeclarationNode) node);
        else if (node instanceof NumberNode)
            visit((NumberNode) node);
        else if (node instanceof OrNode)
            visit ((OrNode) node);
        else if (node instanceof PowerNode)
            visit ((PowerNode) node);
        else if (node instanceof  RadarColorNode)
            visit ((RadarColorNode) node);
        else if (node instanceof ReturnNode)
            visit ((ReturnNode) node);
        else if (node instanceof RobotDclBodyNode)
            visit ((RobotDclBodyNode) node);
        else if (node instanceof RoutineNode)
            visit ((RoutineNode) node);
        else if (node instanceof StrategyDeclarationNode)
            visit ((StrategyDeclarationNode) node);
        else if (node instanceof SubtractionNode)
            visit ((SubtractionNode) node);
        else if (node instanceof TextDeclarationNode)
            visit ((TextDeclarationNode)node);
        else if (node instanceof TextNode)
            visit ((TextNode) node);
        else if (node instanceof ValNode)
            visit ((ValNode) node);
        else if (node instanceof WhenNode)
            visit ((WhenNode) node);
        else if (node instanceof WhileNode)
            visit ((WhileNode) node);
        else
            System.out.println("Error");

    }
}
