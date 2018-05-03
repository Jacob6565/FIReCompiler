package FIRe.Exceptions;

import FIRe.Main;

public class InvalidNumberOfArgumentsException extends Exception {
    public InvalidNumberOfArgumentsException(int expectedNumber,int foundNumber, int lineNumber){
        super("ERROR: Found " + foundNumber + " arguments, but expected " + expectedNumber + " in line " + lineNumber + ".");
        Main.CodeGenerationFlag = true;
    }
}
