package FIRe.Nodes;

import FIRe.ASTVisitor;

public class BodyColorNode extends AbstractNode{
    public ColorValNode Color;

    public BodyColorNode(String color, int lineNumber){
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
