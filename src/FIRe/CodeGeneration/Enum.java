package FIRe.CodeGeneration;

import java.util.ArrayList;

public class Enum extends Indenter{
    Enum(String name){
        this.name = name;
    }

    boolean isThisFirstValue = true;
    String name;
    StringBuilder sb = new StringBuilder();
    ArrayList<String> values = new ArrayList<String>();
    public void addValue(String val){
        if (!isValueDefined(val)){
            values.add(val);
            if (isThisFirstValue){
                sb.append(val);
                isThisFirstValue = false;
            }
            else
                sb.append(", " + val);
        }
    }

    private boolean isValueDefined(String val) {
        if(values.contains(val))
            return true;
        return false;
    }

    @Override
    public String toString(){
        return "public enum " + name + "{\n" +
                "\t" + sb.toString() + "\n}";
    }
}
