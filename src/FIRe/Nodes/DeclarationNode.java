package FIRe.Nodes;

public abstract class DeclarationNode extends AbstractNode{
    public IdNode Id;
    public ExpressionNode expressionNode;

    public DeclarationNode(IdNode id){
        Id = id;
    }
    public DeclarationNode(){   }
}
