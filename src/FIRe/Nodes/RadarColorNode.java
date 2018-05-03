package FIRe.Nodes;

import FIRe.ASTVisitor;

public class RadarColorNode extends AbstractNode{
    public ColorValNode Color;

    public RadarColorNode(String color, int lineNumber){
        Color = new ColorValNode(color, lineNumber);
        LineNumber = lineNumber;
        childList.add(Color);
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        for(AbstractNode child : childList)
            if(child != null)
                child.accept(v, this);
    }
}
