package FIRe.Nodes;

import FIRe.ASTVisitor;

public class StrategyDeclarationNode extends DeclarationNode{


    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : this.childList)
            if(node != null)
                node.accept(v, this);
    }
    //public List<AbstractNode> childList = new ArrayList<>();
}
