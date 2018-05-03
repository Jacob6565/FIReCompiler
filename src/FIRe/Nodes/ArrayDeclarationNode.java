package FIRe.Nodes;

import FIRe.ASTVisitor;

public abstract class ArrayDeclarationNode extends DeclarationNode {
    public IdNode Id;
    public ExpressionNode Size;

    public ArrayDeclarationNode(IdNode id)
    {
        super(id);
    }

    public ArrayDeclarationNode(){
        super();
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception{
        v.visit(this, parent);
        Id.accept(v, this);
        Size.accept(v, this);
    }
}
