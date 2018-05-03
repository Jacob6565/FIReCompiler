package FIRe.Nodes;

import FIRe.ASTVisitor;

public class AssignNode extends StatementNode {
    public IdNode Id;
    public ExpressionNode Expression;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for (AbstractNode child: childList) {
            if(child != null)
                child.accept(v, this);
        }
    }
}
