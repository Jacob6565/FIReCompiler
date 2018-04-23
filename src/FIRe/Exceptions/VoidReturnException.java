package FIRe.Exceptions;

public class VoidReturnException extends Exception {
    public VoidReturnException(){
        super("Void functions are not allowed to contain returns!");
    }
}
