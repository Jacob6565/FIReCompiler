package FIRe.Nodes;

import FIRe.ASTVisitor;

public class WhileNode extends ControlStructureNode{
    public ExpressionNode Expression;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : childList)
            node.accept(v, this);
    }
}
