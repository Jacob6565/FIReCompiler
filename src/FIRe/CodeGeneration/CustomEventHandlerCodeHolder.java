package FIRe.CodeGeneration;

import java.util.ArrayList;
import java.util.List;

public class CustomEventHandlerCodeHolder extends EventHandlerCodeHolder{
    CustomEventHandlerCodeHolder(String name, String type, String parameters) {
        super(name, type, parameters);
        String[] splittedParameters = parameters.split(" ");
        sb.append(indent("String " + valueName + " = " + splittedParameters[1] + ".getCondition().getName();\n",1));
    }

    String valueName = "condition";
    Switch bodySwitch = new Switch(valueName);

    public void addCase(String condition, String strategyName, String body){
        bodySwitch.addConditionCase(condition, strategyName, body);
    }

    public String getCode() {
        sb.append(indent(bodySwitch.getCode(),1));
        return "public " + type + " " + name + " (" + parameters + "){ \n" + sb.toString() + "\n}\n";
    }
}