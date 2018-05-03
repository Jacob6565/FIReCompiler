package FIRe.Nodes;

import FIRe.ASTVisitor;

public class BoolArrayDeclarationNode extends ArrayDeclarationNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception{
        v.visit(this, parent);
        Id.accept(v, this);
        Size.accept(v, this);
    }

    public BoolArrayDeclarationNode(IdNode id)
    {
        super(id);
    }

    public BoolArrayDeclarationNode(){
        super();
    }
    public BoolArrayDeclarationNode(IdNode key, int lineNumber) {
        super(key);
        LineNumber = lineNumber;
    }
}
