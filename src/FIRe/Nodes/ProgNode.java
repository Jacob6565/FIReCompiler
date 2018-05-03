package FIRe.Nodes;

import FIRe.ASTVisitor;

import java.util.ArrayList;

public class ProgNode extends AbstractNode{
    public ArrayList<AbstractNode> _abstractNodesList = new ArrayList<>();

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode child : childList)
            if(child != null)
                child.accept(v, this);
    }
}
