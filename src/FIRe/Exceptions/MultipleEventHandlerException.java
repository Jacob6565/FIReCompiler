package FIRe.Exceptions;

import FIRe.Main;

public class MultipleEventHandlerException extends Exception {
    public MultipleEventHandlerException(String eventName, int lineNumber){
        super("ERROR: Event " + eventName + " has already been handled by another when construct within this strategy in line " + lineNumber + ".");
    }
}