package FIRe.Nodes;

import FIRe.ASTVisitor;

public class ForNode extends ControlStructureNode {

    public NumberDeclarationNode Dcl;
    public ExpressionNode From;
    public ExpressionNode To;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode child : childList)
        {
            if(child != null)
                child.accept(v, this);
        }
    }
}
