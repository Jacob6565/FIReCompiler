package FIRe.Nodes;

import FIRe.ASTVisitor;

public class BlockNode extends AbstractNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : this.childList)
            if(node != null)
                node.accept(v, this);
    }
}
