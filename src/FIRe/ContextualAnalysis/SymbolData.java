package FIRe.ContextualAnalysis;

import FIRe.Nodes.*;
import FIRe.Tuple;
import java.util.ArrayList;

public class SymbolData {
    SymbolData(AbstractNode nodeRef, String type,  ArrayList<Tuple<String,String>> parameters){
        this(nodeRef,type);
        this.parameters = parameters;
    }
    SymbolData(AbstractNode nodeRef, ArrayList<Tuple<String,String>> parameters){
        this.nodeRef = nodeRef;
        this.parameters = parameters;
    }
    SymbolData(AbstractNode nodeRef, String type){
        this.nodeRef = nodeRef;
        this.type = type;
    }

    public AbstractNode nodeRef;
    public String type;
    public ArrayList<Tuple<String,String>> parameters;
}