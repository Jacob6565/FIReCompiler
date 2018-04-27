package FIRe.Exceptions;

public class VariableAlreadyDeclaredException extends Exception{
    public VariableAlreadyDeclaredException(String message, String param)
    {
        super("ERROR: " + message + "Variable: " + param);
    }
    public VariableAlreadyDeclaredException(String message)
    {
        super("ERROR: " + message);
    }
}
