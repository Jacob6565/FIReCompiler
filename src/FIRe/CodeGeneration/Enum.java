package FIRe.CodeGeneration;

public class Enum extends Indenter{
    Enum(String name){
        this.name = name;
    }

    boolean isThisFirstValue = true;
    String name;
    StringBuilder sb = new StringBuilder();
    public void addValue(String val){
        if (isThisFirstValue){
            sb.append(val);
            isThisFirstValue = false;
        }
        else
            sb.append(", " + val);
    }
    @Override
    public String toString(){
        return "public enum " + name + "{\n" +
                "\t" + sb.toString() + "\n}";
    }
}
