package FIRe;

import java.util.ArrayList;

public class SymbolData {

    SymbolData(AbstractNode nodeRef, ArrayList<String> parameterTypes){
        this(nodeRef);
        this.parameterTypes = parameterTypes;
    }

    SymbolData(AbstractNode nodeRef, String type, ArrayList<String> parameterTypes){
        this(nodeRef, type);
        this.parameterTypes = parameterTypes;
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
    public ArrayList<String> parameterTypes;
}
