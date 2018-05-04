package FIRe.CodeGeneration;

public class SetupCodeHolder extends CodeHolder {
    SetupCodeHolder(){
        super();
    }
    String name = "UnnamedRobot";
    String robotType = "AdvancedRobot";
    private String _package = "package roboCodeRobot;\n";
    private String imports = "import java.awt.*;\nimport java.lang.*;\nimport robocode.*;\n";


    @Override
    public String getCode() {
        return _package + imports + "public class " + name + " extends " + robotType + "{\n" +
                indent("String currentStrategy_ = \"_Default\";\n", 1) + sb.toString() + "\n}";
    }
}