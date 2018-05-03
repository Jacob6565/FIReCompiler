package FIRe.Nodes;

import FIRe.ASTVisitor;

public class TextDeclarationNode extends DeclarationNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for (AbstractNode node : this.childList) {
            if(node != null)
                node.accept(v, this);
        }
    }
    public TextDeclarationNode(IdNode id)
    {
        super(id);
    }

    public TextDeclarationNode(){
        super();
    }
    public TextDeclarationNode(IdNode key, int lineNumber) {
        super(key);
        LineNumber = lineNumber;
    }
}
