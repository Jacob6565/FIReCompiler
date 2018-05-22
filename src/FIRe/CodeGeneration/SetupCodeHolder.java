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
    public String toString() {
        return _package + imports + "public class " + name + " extends " + robotType + "{\n" +
                indent(_enums, 1) +
                indent( strategyEnumName + " " + currentStrategyVar + " = Strategy_._Default;\nboolean _stratChange = false; \n", 1) + sb.toString()
                                                                                                            + "\n}";
    }
}