package FIRe.CodeGeneration;

public class RunMethodCodeHolder extends MethodCodeHolder {
    Switch generatedSwitch;
    StringBuilder conditionDeclarations = new StringBuilder();
    RunMethodCodeHolder(String name, String type) {
        super(name, type);
        generatedSwitch  = new Switch(currentStrategyVar, "break");
    }

    public void addToRunMethod(String strategyName, String body) {
        generatedSwitch.addStrategyCase(strategyName, body);
    }

    public void addConditionDeclaration(String code){
        conditionDeclarations.append(code);
    }


    @Override
    public String toString() {
        sb.append(indent(conditionDeclarations.toString(), 1));
        sb.append(indent("while(true){", 1));
        sb.append(indent(generatedSwitch.toString(),2));
        sb.append(indent("}\n", 1));
        sb.append("}\n");
        return "public " + type + " " + name + " (" + parameters + "){ \n" + sb.toString();
    }
}