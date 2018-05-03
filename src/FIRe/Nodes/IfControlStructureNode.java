package FIRe.Nodes;

import FIRe.ASTVisitor;

public class IfControlStructureNode extends ControlStructureNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for (AbstractNode child:childList) {
            if(child != null)
                child.accept(v, this);
        }
    }
    public ExpressionNode Expression;
}
