package FIRe.Exceptions;

public class MissingDefaultStrategyException extends Exception {
    public MissingDefaultStrategyException (String msg){
        super("ERROR: " + msg);
    }

}
