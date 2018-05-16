package FIRe.CodeGeneration;

import FIRe.Exceptions.TypeException;
import FIRe.Nodes.*;

public class CGExpressionVisitor{
    ExpressionNode expr;
    CodeHolder code;

    private void emitLeftParenthesis()
    {
        code.emit("(");

    }

    private void emitRightParenthesis()
    {
        code.emit(")");

    }
    private void emitRightChildInInfixNode(InfixExpressionNode node)
    {
        emitLeftParenthesis();
        VisitNode(node.RightChild);
        emitRightParenthesis();
    }
    private void emitLeftChildInInfixNode(InfixExpressionNode node)
    {
        emitLeftParenthesis();
        VisitNode(node.LeftChild);
        emitRightParenthesis();
    }


    private void emitInfixExpression(InfixExpressionNode node, String operator)
    {
        emitLeftChildInInfixNode(node);
        code.emit(operator);
        emitRightChildInInfixNode(node);
    }

    String GenerateExprCode(CodeHolder CH, ExpressionNode expression){
        code = CH;
        expr = expression;
        emitLeftParenthesis();
        VisitNode(expr);
        emitRightParenthesis();
        return "";
    }

    public void visit(AdditionNode node, Object... arg) throws Exception {
        emitInfixExpression(node, "+");
    }



    public void visit(AndNode node, Object... arg) throws Exception {
        emitInfixExpression(node, "&&");
    }

    public void visit(ArrayAccessNode node, Object... arg) throws TypeException {
        emitLeftParenthesis();
        code.emit(node.Id.Name + "[(int)(");
        VisitNode(node.index);
        code.emit(")] ");
       emitRightParenthesis();
    }

    public void visit(BoolNode node, Object... arg) {
        if (node.value == true) {
           emitLeftParenthesis();
            code.emit("true");
            emitRightParenthesis();
        } else if (node.value == false) {
            emitLeftParenthesis();
            code.emit("false");
            emitRightParenthesis();
        }
    }

    public void visit(DivisionNode node, Object... arg) throws Exception {
        emitInfixExpression(node, "/");
    }

    public void visit(EqualsNode node, Object... arg) throws Exception {
        if(node.LeftChild.type.equals("text") && node.RightChild.type.equals("text")){
           emitLeftChildInInfixNode(node);
            code.emit(".equals(");
            emitRightChildInInfixNode(node);
            code.emit(")");
        }
        else{
            emitInfixExpression(node, "==");
        }
    }

    public void visit(FuncCallNode node, Object... arg) throws Exception {
        int numOfParams = 0;

        for(AbstractNode par : node.Aparam.childList)
            numOfParams++;

        if(node.Id.Name.equals("print"))
            code.emit("System.out.print(");
        else
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
        emitInfixExpression(node, ">=");
    }

    public void visit(GreaterThanNode node, Object... arg) throws Exception {
      emitInfixExpression(node, ">");
    }

    public void visit(IdNode node, Object... arg) throws Exception {
        code.emit(node.Name);
    }

    public void visit(InfixExpressionNode node, Object... arg) throws Exception {
        for (AbstractNode Node: node.childList) {
            VisitNode(Node);
        }
    }

    public void visit(LEQNode node, Object... arg) throws Exception {
        emitInfixExpression(node, "<=");
    }

    public void visit(LessThanNode node, Object... arg) throws Exception {
        emitInfixExpression(node, "<");
    }

    public void visit(ModuloNode node, Object... arg) throws Exception {
        emitInfixExpression(node, "%");
    }

    public void visit(MultiplicationNode node, Object... arg) throws Exception {
        emitInfixExpression(node, "*");
    }

    public void visit(NegateNode node, Object... arg) {
        code.emit("-");
        emitLeftParenthesis();
        VisitNode(node.childList.get(0));
        emitRightParenthesis();
    }

    public void visit(NotEqualsNode node, Object... arg) throws Exception {
        if(node.LeftChild.type.equals("text") && node.RightChild.type.equals("text")){
            code.emit("!(");
            VisitNode(node.LeftChild);
            code.emit(".equals(");
            VisitNode(node.RightChild);
            code.emit("))");
        }
        else{
            emitInfixExpression(node, "!=");

        }
    }

    public void visit(NotNode node, Object... arg) {
        code.emit("!(");
        VisitNode(node.Expression);
        code.emit(")");
    }

    public void visit(NumberNode node, Object... arg) {
        code.emit(node.value);
    }

    public void visit(OrNode node, Object... arg) throws Exception {
        emitInfixExpression(node, "||");
    }

    public void visit(PowerNode node, Object... arg) throws Exception {
        code.emit("Math.pow(");
        VisitNode(node.LeftChild);
        code.emit(", ");
        VisitNode(node.RightChild);
        code.emit(") ");
    }

    public void visit(SubtractionNode node, Object... arg) throws Exception {
        emitInfixExpression(node, "-");
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