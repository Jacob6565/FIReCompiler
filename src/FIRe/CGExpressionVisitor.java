package FIRe;

import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.TypeException;

public class CGExpressionVisitor{
    ExpressionNode expr;
    CodeHolder code;

    String GenerateExprCode(CodeHolder CH, ExpressionNode expression){
        code = CH;
        expr = expression;
        VisitNode(expr);
        return "";
    }

    public void visit(AdditionNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" + ");
        VisitNode(node.RightChild);
    }

    public void visit(AndNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" && ");
        VisitNode(node.RightChild);
    }

    public void visit(ArrayAccessNode node, Object... arg) throws TypeException {
        code.emit("_" + node.Id.Name + "[(int)");
        VisitNode(node.index);
        code.emit("] ");
    }

    public void visit(BoolNode node, Object... arg) {
        if(node.value == true)
            code.emit("true");
        else if(node.value == false)
            code.emit("false");
    }

    public void visit(DivisionNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit("/");
        VisitNode(node.RightChild);
    }

    public void visit(EqualsNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" == ");
        VisitNode(node.RightChild);
    }

    public void visit(FuncCallNode node, Object... arg) throws Exception {
        int numOfParams = 0;

        for(AbstractNode par : node.Aparam.childList)
            numOfParams++;

        code.emit(node.Id.Name + "(");
        for(AbstractNode par : node.Aparam.childList) {
            VisitNode(par);
            if(numOfParams != 1) {
                code.emit(", ");
                numOfParams--;
            }
        }
        code.emit(")");
    }

    public void visit(GEQNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" >= ");
        VisitNode(node.RightChild);
    }

    public void visit(GreaterThanNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" > ");
        VisitNode(node.RightChild);
    }

    public void visit(IdNode node, Object... arg) throws Exception {
        code.emit("_"+node.Name);
    }

    public void visit(InfixExpressionNode node, Object... arg) throws Exception {
        for (AbstractNode Node: node.childList) {
            VisitNode(Node);
        }
    }

    public void visit(LEQNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" <= ");
        VisitNode(node.RightChild);
    }

    public void visit(LessThanNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" < ");
        VisitNode(node.RightChild);
    }

    public void visit(ModuloNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" % ");
        VisitNode(node.RightChild);
    }

    public void visit(MultiplicationNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" * ");
        VisitNode(node.RightChild);
    }

    public void visit(NegateNode node, Object... arg) {
        code.emit("-");
        VisitNode(node.childList.get(0));
    }

    public void visit(NotEqualsNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" != ");
        VisitNode(node.RightChild);
    }

    public void visit(NotNode node, Object... arg) {
        code.emit("!");
        VisitNode(node.Expression);
    }

    public void visit(NumberNode node, Object... arg) {
        code.emit(node.value);
    }

    public void visit(OrNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" || ");
        VisitNode(node.RightChild);
    }

    public void visit(PowerNode node, Object... arg) throws Exception {
        code.emit("Math.pow(");
        VisitNode(node.LeftChild);
        code.emit(", ");
        VisitNode(node.RightChild);
        code.emit(") ");
    }

    public void visit(SubtractionNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        code.emit(" - ");
        VisitNode(node.RightChild);
    }

    public void visit(TextNode node, Object... arg) {
        code.emit(node.Content);
    }

    public void visit(ValNode node, Object... arg) {

    }


    public void VisitNode(AbstractNode node) {
        try {
            if (node instanceof AdditionNode)
                visit((AdditionNode) node);
            else if (node instanceof AndNode)
                visit((AndNode) node);
            else if (node instanceof ArrayAccessNode)
                visit((ArrayAccessNode) node);
            else if (node instanceof BoolNode)
                visit((BoolNode) node);
            else if (node instanceof DivisionNode)
                visit((DivisionNode) node);
            else if (node instanceof EqualsNode)
                visit((EqualsNode) node);
            else if (node instanceof FuncCallNode)
                visit((FuncCallNode) node);
            else if (node instanceof GEQNode)
                visit((GEQNode) node);
            else if (node instanceof GreaterThanNode)
                visit((GreaterThanNode) node);
            else if (node instanceof IdNode)
                visit((IdNode) node);
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
            else if (node instanceof NumberNode)
                visit((NumberNode) node);
            else if (node instanceof OrNode)
                visit((OrNode) node);
            else if (node instanceof PowerNode)
                visit((PowerNode) node);
            else if (node instanceof SubtractionNode)
                visit((SubtractionNode) node);
            else if (node instanceof TextNode)
                visit((TextNode) node);
            else if (node instanceof ValNode)
                visit((ValNode) node);
            else
                System.out.println("Error");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
