package FIRe.Nodes;

import FIRe.ASTVisitor;

public class ArrayAccessNode extends ExpressionNode{
    public IdNode Id;
    public ExpressionNode index;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        Id.accept(v, this);
        index.accept(v, this);
    }
}
