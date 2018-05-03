package FIRe.Nodes;

import FIRe.ASTVisitor;

public class WhenNode extends AbstractNode{
    public WhenNode(AbstractNode eventType, AbstractNode variableName){
        childList.add(eventType);
        childList.add(variableName);
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : childList)
            node.accept(v, this);
    }
}
