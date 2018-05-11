package FIRe.Exceptions;

import FIRe.Main;

public class NotRecognizedTypeException extends Exception {
    public NotRecognizedTypeException(String type){
        super("ERROR: Could not recognize type: " + type + ".");
    }
}
