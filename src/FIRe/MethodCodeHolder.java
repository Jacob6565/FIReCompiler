package FIRe;

public class MethodCodeHolder extends CodeHolder {
    protected MethodCodeHolder(String name, String type, String parameters){
        this(name, type);
        this.parameters = parameters;
    }
    MethodCodeHolder(String name, String type){
        this.name = name;
        this.type = type;
    }

    protected String name;
    public String type;
    public String parameters = "";

    public String getCode() {
        return "public " + type + " " + name + " (" + parameters + "){ \n" + sb.toString() + "\n}\n";
    }
}
