package FIRe.Nodes;

import FIRe.ASTVisitor;

public class EventTypeDeclarationNode extends DeclarationNode{
    public String Type;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception { }

    public EventTypeDeclarationNode(IdNode id, String type, int lineNumber) {
        super(id);
        Type = type;
        LineNumber = lineNumber;
    }

    public EventTypeDeclarationNode(){
        super();
    }
}
