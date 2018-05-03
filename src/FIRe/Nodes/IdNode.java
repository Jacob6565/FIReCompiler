package FIRe.Nodes;

import FIRe.ASTVisitor;

public class IdNode extends ExpressionNode {
    public String Name;
    public ExpressionNode ArrayIndex;

    public IdNode(String name){
        Name = name;
    }
    public IdNode(){

    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
    }
}
