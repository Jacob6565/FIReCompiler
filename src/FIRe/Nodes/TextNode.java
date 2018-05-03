package FIRe.Nodes;

import FIRe.ASTVisitor;

public class TextNode extends ValNode{
    public String Content;

    public TextNode(){}
    public TextNode(String content){
        Content = content;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        v.visit(this, parent);
    }
}
