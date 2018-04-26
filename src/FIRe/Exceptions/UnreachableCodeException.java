package FIRe.Exceptions;

import java.util.List;

public class UnreachableCodeException extends Exception{
    String lines = "";
    public UnreachableCodeException(List<Integer> values)
    {
        lines = "";
        for (Integer i : values)
        {
            lines += i.toString();
        }
    }

    @Override
    public String getMessage() {
        return "Unreachable code at lines: " + lines;
    }
}
