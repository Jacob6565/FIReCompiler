package FIRe.Nodes;

import FIRe.ASTVisitor;

public class NumberNode extends ValNode{
    public double value;
    public NumberNode(){}
    public NumberNode(double value){
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        v.visit(this);
    }
}
