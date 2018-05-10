package FIRe.Nodes;

import FIRe.ASTVisitor;
import FIRe.Tuple;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FormalParameterNode extends AbstractNode{
    public Map<IdNode, String> parameterMap = new LinkedHashMap<>();
    public FormalParameterNode(){    }
    public FormalParameterNode(Tuple<String,String>[] parameters){
        for (Tuple <String,String> tuple: parameters) {
            parameterMap.put(new IdNode(tuple.getKey()),tuple.getValue());
        }
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        //Hvor man inde i denne visit metode så printer elementerne i mappen.
        v.visit(this, parent);
    }
}
