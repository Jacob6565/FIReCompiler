package FIRe.CodeGeneration;

public class SetupCodeHolder extends CodeHolder {
    SetupCodeHolder(){
        super();
    }
    String name = "UnnamedRobot";
    String robotType = "AdvancedRobot";
    private String _package = "package FIReRobots;\n";
    private String imports = "import java.awt.*;\nimport java.lang.*;\nimport robocode.*;\n";
    public String _enums = "";


    @Override
    public String getCode() {
        return _package + imports + _enums + "public class " + name + " extends " + robotType + "{\n" +
                indent( strategyEnumName + " " + currentStrategyName + " = \"_Default\";\n", 1) + sb.toString()
                                                                                                            + "\n}";
    }
}