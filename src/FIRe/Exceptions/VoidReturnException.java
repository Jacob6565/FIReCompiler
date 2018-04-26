package FIRe.Exceptions;

public class VoidReturnException extends Exception {
    public VoidReturnException(String s){
        super("Void functions are not allowed to contain returns!");
    }

    public VoidReturnException() {

    }
}
