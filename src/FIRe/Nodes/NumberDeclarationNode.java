package FIRe.Nodes;

import FIRe.ASTVisitor;

public class NumberDeclarationNode extends DeclarationNode{
    public NumberDeclarationNode(IdNode key, int lineNumber) {
        super(key);
        LineNumber = lineNumber;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for (AbstractNode node : this.childList) {
            if(node != null)
                node.accept(v, this);
        }
    }

    public NumberDeclarationNode(IdNode id)
    {
        super(id);
    }

    public NumberDeclarationNode(){
        super();
    }


}
