package FIRe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Errors {

    public List<String> ErrorsAndWarnings = new ArrayList<String>();


    public void addError(String errorMessage){
        ErrorsAndWarnings.add(errorMessage);
    }

    public void writeToConsole(){
        for (String string:ErrorsAndWarnings){
            System.out.println(string);
        }
    }
}
