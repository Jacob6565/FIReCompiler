package FIRe.CodeGeneration;

public class RunMethodCodeHolder extends MethodCodeHolder {
    Switch generatedSwitch;
    StringBuilder customEvents = new StringBuilder();
    RunMethodCodeHolder(String name, String type) {
        super(name, type);
        generatedSwitch  = new Switch(currentStrategyVar, "break");
    }

    public void addToRunMethod(String strategyName, String body) {
        generatedSwitch.addStrategyCase(strategyName, body);
    }


    public void addCustomEvent(String code){
        customEvents.append(code);
    }


    @Override
    public String toString() {
        emit(customEvents.toString(), 1);
        emit("while(true){", 1);
        emit(generatedSwitch.toString(), 2);
        emit("}\n", 1);
        emit("}\n");
        return "public " + type + " " + name + " (" + parameters + "){ \n" + sb.toString();
    }
}