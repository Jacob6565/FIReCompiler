package FIRe;

import java.util.ArrayList;

public class SymbolData {
    SymbolData(AbstractNode nodeRef, String type,  ArrayList<Tuple<String,String>> parameters){
        this(nodeRef, type);
        this.parameters = parameters;
    }
    SymbolData(AbstractNode nodeRef, ArrayList<Tuple<String,String>> parameters){
        this(nodeRef);
        this.parameters = parameters;
    }
    SymbolData(AbstractNode nodeRef, String type){
        this(nodeRef);
        this.type = type;
    }
    SymbolData(AbstractNode nodeRef){
        this.nodeRef = nodeRef;
    }

    public AbstractNode nodeRef;
    public String type;
    public ArrayList<Tuple<String,String>> parameters;
}
