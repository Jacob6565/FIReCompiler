package FIRe.Exceptions;

public class SymbolNotFoundException extends Exception {

    public SymbolNotFoundException(String symbol, int lineNumber){
        super("ERROR: Symbol \"" + symbol + "\" in line " + lineNumber + " was not found.");
    }
}
