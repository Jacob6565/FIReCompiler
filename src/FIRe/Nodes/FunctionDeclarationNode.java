package FIRe.Nodes;

import FIRe.ASTVisitor;
import FIRe.Tuple;

public class FunctionDeclarationNode extends DeclarationNode{
    public String Type;

    public FunctionDeclarationNode(String name, String type, Tuple<String, String>... parameters){
        Id = new IdNode(name);
        Type = type;
        childList.add(new FormalParameterNode(parameters));
    }
    public FunctionDeclarationNode(){

    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : childList)
            if(node != null)
                node.accept(v, this);
    }
}
