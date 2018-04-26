package FIRe;

public class RunMethodCodeHolder extends MethodCodeHolder {
    int caseNumber = 0;
    StringBuilder generatedSwitch = new StringBuilder();

    RunMethodCodeHolder(String name, String type) {
        super(name, type);
        generatedSwitch.append(indent("switch(currentStrategy){", 1));
    }

    public void addToRunMethod(String strategyName, String body) {
        generatedSwitch.append(indent("case " + "\"" + strategyName + "\"", 2));
        generatedSwitch.append(indent(body + "\n break;", 3));
    }

    @Override
    String getCode() {
        sb.append(generatedSwitch.toString());
        sb.append(indent("}\n", 1));
        return "public " + type + " " + name + " (" + parameters + "){ \n" + sb.toString() + "\n}\n";
    }
}
