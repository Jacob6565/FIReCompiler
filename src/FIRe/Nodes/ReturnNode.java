package FIRe.Nodes;

import FIRe.ASTVisitor;

public class ReturnNode extends StatementNode {

    public ReturnNode(AbstractNode node,int lineNumber){
        childList.add(node);
        LineNumber = lineNumber;
    }
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        if(childList.get(0) != null)
            childList.get(0).accept(v, this);
    }
}
