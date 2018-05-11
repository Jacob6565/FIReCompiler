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
}
