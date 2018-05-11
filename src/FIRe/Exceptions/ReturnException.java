package FIRe.Exceptions;

import FIRe.Main;

public class ReturnException extends Exception{
    public ReturnException(String errStr, int lineNum){
        super("ERROR: " + errStr + " in line " + lineNum + ".");
    }
}
