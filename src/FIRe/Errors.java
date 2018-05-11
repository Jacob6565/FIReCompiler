package FIRe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Errors {

    public List<String> ErrosAndWarnings = new ArrayList<String>();


    public void addError(String errorMessage){
        ErrosAndWarnings.add(errorMessage);
    }

    public void writeToConsole(){
        for (String string:ErrosAndWarnings){
            System.out.println(string);
        }
    }
}
