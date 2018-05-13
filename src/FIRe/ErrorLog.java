package FIRe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ErrorLog {

    private List<String> ErrorsAndWarnings = new ArrayList<String>();

    public boolean isEmpty(){
        return ErrorsAndWarnings.isEmpty();
    }

    public void addError(String errorMessage){
        ErrorsAndWarnings.add(errorMessage);
    }

    public void writeToConsole(){
        for (String string:ErrorsAndWarnings){
            System.out.println(string);
        }
    }

    public void addNameAlreadyUsedInTheGlobalScopeError(String message, String param){
        Main.errors.addError("ERROR: " + message + " Parameter already used: " + param);
    }
    public void addVariableAlreadyDeclared(String message){
        Main.errors.addError("ERROR: " + message);
    }
    public void addTypeError(String expected, String found, int lineNumber){
        Main.errors.addError("ERROR: Expected type " + expected + ", but found type " + found + " in line "+ lineNumber + ".");
    }
    public void addNotRecognizedTypeError(String type){
        Main.errors.addError("ERROR: Could not recognize type: " + type + ".");
    }
    public void addInvalidNumberOfArgumentsError(int foundNumber, int expectedNumber, int lineNumber){
        Main.errors.addError("ERROR: Found " + foundNumber + " arguments, but expected " + expectedNumber + " in line " + lineNumber + ".");
    }
    public void addStrategyCallError(int lineNumber){
        Main.errors.addError("ERROR: Strategies cannot be called within functions. Discrepancy in line " + lineNumber + ".");
    }
    public void addCustomEventFieldAccessError(int lineNumber){
        Main.errors.addError("ERROR: Cannot access fields of a custom event in line " + lineNumber + ".");
    }
    public void addSymbolNotFoundError(String symbol, int lineNumber){
        Main.errors.addError("ERROR: Symbol \"" + symbol + "\" in line " + lineNumber + " was not found.");
    }
    public void addSymbolNotFoundError(String symbol){
        Main.errors.addError("ERROR: Symbol \"" + symbol + "\" was not found.");
    }
    public void addReturnError(String errStr, int lineNum){
        Main.errors.addError("ERROR: " + errStr + " in line " + lineNum + ".");
    }
    public void addVoidReturnError(int FunctionLineNumber, int ReturnodeLineNumber){
        Main.errors.addError("ERROR: Void functions can not return." + " Function at line: " +  FunctionLineNumber + " returns at line: " + ReturnodeLineNumber);
    }
    public void addMultipleEventHandlerError(String eventName, int lineNumber){
        Main.errors.addError("ERROR: Event " + eventName + " has already been handled by another when construct within this strategy. Discrepancy in line " + lineNumber + ".");
    }
}
