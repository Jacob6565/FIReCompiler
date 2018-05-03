package FIRe.Nodes;

import FIRe.ASTVisitor;

public class BooleanDeclarationNode extends DeclarationNode {

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for (AbstractNode node : this.childList) {
            if(node != null)
                node.accept(v, this);
        }
    }
    public BooleanDeclarationNode(IdNode id)
    {
        super(id);
    }

    public BooleanDeclarationNode(){
        super();
    }
    public BooleanDeclarationNode(IdNode key, int lineNumber) {
        super(key);
        LineNumber = lineNumber;
    }
}
