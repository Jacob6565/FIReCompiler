package FIRe.Nodes;

import FIRe.ASTVisitor;

public class GunColorNode extends AbstractNode{
    public ColorValNode Color;
    public GunColorNode(String color, int lineNumber){
        Color = new ColorValNode(color, lineNumber);
        LineNumber = lineNumber;
        childList.add(Color);
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
    }
}
