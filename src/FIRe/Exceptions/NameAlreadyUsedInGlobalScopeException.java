package FIRe.Exceptions;

public class NameAlreadyUsedInGlobalScopeException extends Exception{
    public NameAlreadyUsedInGlobalScopeException(String message){
        super(message);
    }
    public NameAlreadyUsedInGlobalScopeException(String message, String param){
        super("Message: " + message + " Parameter already used: " + param);
    }

}
