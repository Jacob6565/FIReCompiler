package FIRe.Nodes;

import FIRe.ASTVisitor;

public class NegateNode extends ExpressionNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        //Tror ikke denne bliver benyttet
    }
    // ex -34;
}
