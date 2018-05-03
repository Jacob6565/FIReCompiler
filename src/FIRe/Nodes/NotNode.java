package FIRe.Nodes;

import FIRe.ASTVisitor;

public class NotNode extends ExpressionNode{
    public ExpressionNode Expression;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.Expression.accept(v, this);
    }
}
