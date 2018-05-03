package FIRe.Nodes;

import FIRe.ASTVisitor;

public class NumberArrayDeclarationNode extends ArrayDeclarationNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception{
        v.visit(this, parent);
        Id.accept(v, this);
        Size.accept(v, this);
    }
    public NumberArrayDeclarationNode(IdNode id)
    {
        super(id);
    }

    public NumberArrayDeclarationNode(){
        super();
    }
    public NumberArrayDeclarationNode(IdNode key, int lineNumber) {
        super(key);
        LineNumber = lineNumber;
    }
}
