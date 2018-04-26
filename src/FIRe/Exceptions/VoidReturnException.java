package FIRe.Exceptions;

public class VoidReturnException extends Exception {
    public VoidReturnException(int ReturnodeLineNumber, int FunctionLineNumber){
        super("ERROR: Void functions can not return " + "Function at line: " +  FunctionLineNumber + " Return at Line: " + ReturnodeLineNumber);
    }


}
