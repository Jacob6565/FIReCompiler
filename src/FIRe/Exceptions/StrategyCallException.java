package FIRe.Exceptions;

import FIRe.Main;

public class StrategyCallException extends Exception {
    public StrategyCallException(int lineNumber){
        super("ERROR: Strategies cannot be called within functions. Discrepancy in line " + lineNumber + ".");
        Main.CodeGenerationFlag = true;
    }
}
