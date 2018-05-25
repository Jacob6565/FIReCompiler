package FIRe.Nodes;

import FIRe.ASTVisitor;

import java.util.ArrayList;

public class ProgNode extends AbstractNode {
    public void accept(ASTVisitor v, AbstractNode parent) {
        //Calling the visit method for itself.
        v.visit(this, parent);
        for(AbstractNode child : childList)
            if(child != null)
                //Calling its children's accept methods and thereby traversing the AST.
                child.accept(v, this);
    }
}