package FIRe.Exceptions;

public class TypeException extends Exception{
    String message = "";
    public TypeException(String expectedType, String foundType, int lineNumber){
        if ((expectedType != null && !expectedType.equals("null")) && (foundType != null && !foundType.equals("null")))
            message = "ERROR: Expected type " + expectedType + ", but found type " + foundType + " in line "+ lineNumber + ".";
        else
            message = "ERROR: Expected type " + (expectedType == null ? foundType : expectedType) + ", but found an undeclared variable in line " + lineNumber + ".";
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public TypeException(String s) {
        super("ERROR: " + s);
    }
}
