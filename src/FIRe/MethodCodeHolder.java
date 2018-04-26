package FIRe;

public class MethodCodeHolder extends CodeHolder {
    MethodCodeHolder(String name, String type, String parameters){
        this(name, type);
        this.parameters = parameters;
    }
    MethodCodeHolder(String name, String type){
        this.name = name;
        this.type = type;
    }

    String name;
    String type;
    String parameters = "";


    String getCode() {

        return "public " + type + " " + name + " (" + parameters + "){ \n" + sb.toString() + "\n}\n";
    }
}
