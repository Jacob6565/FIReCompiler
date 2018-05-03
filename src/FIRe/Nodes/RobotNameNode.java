package FIRe.Nodes;

import FIRe.ASTVisitor;

public class RobotNameNode extends AbstractNode{
    public IdNode RobotName;

    public RobotNameNode(String name, int lineNumber){
        RobotName = new IdNode(name);
        childList.add(RobotName);
        LineNumber = lineNumber;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this,parent);
        for(AbstractNode child : childList)
            if(child != null)
                child.accept(v, this);
    }
}
