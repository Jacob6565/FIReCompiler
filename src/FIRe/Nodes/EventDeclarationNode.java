package FIRe.Nodes;

import FIRe.ASTVisitor;
import FIRe.Tuple;

import java.util.ArrayList;
import java.util.List;

public class EventDeclarationNode extends DeclarationNode{
    public List<Tuple<String, String>> Fields;

    public EventDeclarationNode(){ }
    public EventDeclarationNode(String id, int lineNumber, Tuple<String,String>... fields){
        Id = new IdNode(id);
        Fields = new ArrayList<Tuple<String, String>>();
        for (Tuple<String,String> entry: fields) {
            Fields.add(entry);
        }
        LineNumber = lineNumber;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);

        for(AbstractNode node : childList)
            node.accept(v, this);
    }
}
