package FIRe;

public class RunMethodCodeHolder extends MethodCodeHolder {
    int caseNumber = 0;
    StringBuilder generatedSwitch = new StringBuilder();

    RunMethodCodeHolder(String name, String type) {
        super(name, type);
        generatedSwitch.append(indent("while(true){", 1));
        generatedSwitch.append(indent("switch(currentStrategy){\n", 2));
    }

    public void addToRunMethod(String strategyName, String body) {
        generatedSwitch.append(indent("case " + "\"" + strategyName + "\"", 3));
        generatedSwitch.append(indent(body + "\n break;", 4));
    }

    @Override
    String getCode() {
        generatedSwitch.append(indent("}\n", 2));
        generatedSwitch.append(indent("}\n", 1));
        generatedSwitch.append("}\n");
        sb.append(generatedSwitch.toString());
        return "public " + type + " " + name + " (" + parameters + "){ \n" + sb.toString() + "\n}\n";
    }
}
