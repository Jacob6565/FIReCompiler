package FIRe;

import java.util.ArrayList;

public class SymbolData {
    SymbolData(AbstractNode nodeRef, String type, ArrayList<String> parameterTypes){
        this.nodeRef = nodeRef;
        this.type = type;
        this.parameterTypes = parameterTypes;
    }
    SymbolData(AbstractNode nodeRef, String type){
        this.nodeRef = nodeRef;
        this.type = type;
        this.parameterTypes = parameterTypes;
    }
    public AbstractNode nodeRef;
    public String type;
    public ArrayList<String> parameterTypes;
}
