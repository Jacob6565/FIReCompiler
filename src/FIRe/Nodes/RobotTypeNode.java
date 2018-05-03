package FIRe.Nodes;

import FIRe.ASTVisitor;

public class RobotTypeNode extends AbstractNode{
    public IdNode RobotType;

    public RobotTypeNode(String type, int lineNumber){
        RobotType = new IdNode(type);
        childList.add(RobotType);
        LineNumber = lineNumber;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode child : childList)
            if(child != null)
                child.accept(v, this);}
}
