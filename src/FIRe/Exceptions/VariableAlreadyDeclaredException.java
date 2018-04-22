package FIRe.Exceptions;

public class VariableAlreadyDeclaredException extends Exception{
    public VariableAlreadyDeclaredException(String message, String param)
    {
        super("Message: " + message + "Variable: " + param);
    }
    public VariableAlreadyDeclaredException(String message)
    {
        super("Message: " + message);
    }
}
