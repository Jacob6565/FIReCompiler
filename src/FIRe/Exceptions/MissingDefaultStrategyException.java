package FIRe.Exceptions;

import FIRe.Main;

public class MissingDefaultStrategyException extends Exception {
    public MissingDefaultStrategyException (String msg){
        super("ERROR: " + msg);
        Main.CodeGenerationFlag = true;
    }
}
