package FIRe.Exceptions;

public class VoidReturnException extends Exception {
    public VoidReturnException(int FunctionLineNumber,int ReturnodeLineNumber){
        super("ERROR: Void functions can not return." + " Function at line: " +  FunctionLineNumber + " returns at line: " + ReturnodeLineNumber);
    }


}
