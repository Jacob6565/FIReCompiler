package FIRe.Exceptions;

import FIRe.Main;

public class SymbolNotFoundException extends Exception {

    public SymbolNotFoundException(String symbol, int lineNumber){
        super("ERROR: Symbol \"" + symbol + "\" in line " + lineNumber + " was not found.");
    }
    public SymbolNotFoundException(String symbol){
        super("ERROR: Symbol \"" + symbol + " was not found.");
    }
}
