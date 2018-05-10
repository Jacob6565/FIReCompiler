package FIRe.Nodes;

import FIRe.ASTVisitor;

public class BoolNode extends ExpressionNode{
    public boolean value;

    public BoolNode(){
        value = false;
    }
    public BoolNode(boolean value){
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        v.visit(this);
    }
}
