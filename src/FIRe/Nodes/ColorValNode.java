package FIRe.Nodes;

import FIRe.ASTVisitor;

public class ColorValNode extends AbstractNode{
    public String Color;

    public ColorValNode(String Color, int lineNumber){
        this.Color = Color;
        LineNumber = lineNumber;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        for(AbstractNode child : childList)
            if(child != null)
                child.accept(v, this);
    }
}
