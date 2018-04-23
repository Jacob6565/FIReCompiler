package FIRe.Exceptions;

public class ReturnException extends Exception{
    String errStr;
    ReturnException(String errStr, int lineNum){
        super("ERROR: " + errStr + " in line " + lineNum + ".");
    }
}
