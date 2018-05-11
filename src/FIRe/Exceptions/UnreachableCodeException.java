package FIRe.Exceptions;

import FIRe.Main;

import java.util.List;

public class UnreachableCodeException extends Exception{
    String lines = "";
    public UnreachableCodeException(List<Integer> values)
    {
        lines = "";
        for (Integer i : values)
        {
            lines += i.toString() + " ";
        }
    }

    @Override
    public String getMessage() {
        return "ERROR: Unreachable code at lines: " + lines;
    }
}
