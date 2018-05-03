package FIRe.Nodes;

import FIRe.ASTVisitor;

public class RobotPropertiesNode extends AbstractNode{
    public RobotPropertiesNode(){}

    @Override
    public void accept(ASTVisitor v, AbstractNode Parent) throws Exception {
        v.visit(this, Parent);
        for(AbstractNode child : childList)
            if(child != null)
                child.accept(v, this);
    }
}
