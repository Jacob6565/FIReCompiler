package FIRe.Exceptions;

import FIRe.Main;

public class SymbolNotFoundException extends Exception {

    public SymbolNotFoundException(String symbol, int lineNumber){
        super("ERROR: Symbol \"" + symbol + "\" in line " + lineNumber + " was not found.");
        Main.CodeGenerationFlag = true;
    }
}
