package FIRe.Nodes;

import FIRe.ASTVisitor;

public class TextArrayDeclarationNode extends ArrayDeclarationNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception{
        v.visit(this, parent);
        Id.accept(v, this);
        Size.accept(v, this);
    }
    public TextArrayDeclarationNode(IdNode id)
    {
        super(id);
    }

    public TextArrayDeclarationNode(){
        super();
    }

    public TextArrayDeclarationNode(IdNode key, int lineNumber) {
        super(key);
        LineNumber = lineNumber;
    }
}
