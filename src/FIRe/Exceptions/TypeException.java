package FIRe.Exceptions;

public class TypeException extends Exception{

    public TypeException(String expectedType, String foundType, int lineNumber){
        super("ERROR: Expected type " + expectedType + ", but found type " + foundType + " in line "+ lineNumber + ".");
    }

    public TypeException(String s) {
        super("ERROR: " + s);
    }
}
