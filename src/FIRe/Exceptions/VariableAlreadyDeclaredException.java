package FIRe.Exceptions;

import FIRe.Main;

public class VariableAlreadyDeclaredException extends Exception{
    public VariableAlreadyDeclaredException(String message, String param)
    {
        super("ERROR: " + message + "Variable: " + param);
        Main.CodeGenerationFlag = true;
    }
    public VariableAlreadyDeclaredException(String message)
    {
        super("ERROR: " + message);
        Main.CodeGenerationFlag = true;
    }
}
