package FIRe.Nodes;

import FIRe.ASTVisitor;

public class FuncCallNode extends ExpressionNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : childList)
            node.accept(v, this);
    }
    public ActualParameterNode Aparam;
    public IdNode Id;

}
