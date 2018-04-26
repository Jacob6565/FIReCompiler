package FIRe;

public class MethodCodeHolder extends CodeHolder {
    MethodCodeHolder(String name, String type){
        this(name);
        this.type = type;
    }
    MethodCodeHolder(String name){
        super();
        this.name = name;
    }

    String name;
    String type;
    String parameters = "";


    String getCode() {

        return "\tpublic " + type + " " + name + " (" + parameters + "){ \n" + sb.toString() + "\n\t}\n";
    }
}
