package FIRe;

public class SetupCodeHolder extends CodeHolder {
    SetupCodeHolder(){
        super();
    }
    String name = "UnnamedRobot";
    String robotType = "AdvancedRobot";
    String imports = "import java.awt.*;\nimport java.lang.*;\nimport robocode.*;\n";


    @Override
    String getCode() {
        return imports + "public class " + name + " extends " + robotType + "{\n" + "\tprivate String currentStrategy " +
                "= \"Default\";\n" + sb.toString() + "\n}";
    }
}
