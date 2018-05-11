package FIRe.Exceptions;

import FIRe.Main;

public class NameAlreadyUsedInGlobalScopeException extends Exception{
    public NameAlreadyUsedInGlobalScopeException(String message){
        super(message);
    }
    public NameAlreadyUsedInGlobalScopeException(String message, String param){
        super("ERROR: " + message + " Parameter already used: " + param);
    }
}
