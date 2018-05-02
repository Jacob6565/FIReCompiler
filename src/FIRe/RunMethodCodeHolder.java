package FIRe;

public class RunMethodCodeHolder extends MethodCodeHolder {
    StringBuilder generatedSwitch = new StringBuilder();
    StringBuilder conditionDeclarations = new StringBuilder();
    RunMethodCodeHolder(String name, String type) {
        super(name, type);
        generatedSwitch.append(indent("while(true){", 1));
        generatedSwitch.append(indent("switch(currentStrategy){\n", 2));
    }

    //THIS MIGHT BE DONE WITH THE USE OF SWITCH AND CASE CLASSES /KRISTOFFER
    public void addToRunMethod(String strategyName, String body) {
        generatedSwitch.append(indent("case " + "\"" + strategyName + "\":", 3));
        generatedSwitch.append(indent(body + "break;", 4));
    }

    public void addConditionDeclaration(String code){
        conditionDeclarations.append(code);
    }


    @Override
    public String getCode() {
        sb.append(indent(conditionDeclarations.toString(), 1));
        generatedSwitch.append(indent("}\n", 2));
        generatedSwitch.append(indent("}\n", 1));
        generatedSwitch.append("}\n");
        sb.append(generatedSwitch.toString());
        return "public " + type + " " + name + " (" + parameters + "){ \n" + sb.toString();
    }
}
