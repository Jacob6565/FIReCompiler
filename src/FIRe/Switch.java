package FIRe;

import java.util.ArrayList;


public class Switch extends Indenter {
    Switch(String valueName, Case switchCase){
        this(valueName);
        switchCases.add(switchCase);
    }
    Switch(String valueName){
        this.valueName = valueName;
    }
    String valueName = new String();
    ArrayList<Case> switchCases = new ArrayList<Case>();

    public void addConditionCase(String condition, String strategyName, String body){
        if (getSwitchCases(condition) != null){
            getSwitchCases(condition).bodySwitch.addStrategyCase(strategyName, body);
        }
        else{
            switchCases.add(new Case(condition, new Switch("_currentStrategy", new Case(strategyName, body))));
        }
    }

    private void addStrategyCase(String switchCase, String body){
        switchCases.add(new Case(switchCase, body));
    }

    private Case getSwitchCases(String caseName){
        for (Case _case: switchCases) {
            if (_case.caseName.equals(caseName))
                return _case;
        }
        return null;
    }

    private String collectCases(ArrayList<Case> cases){
        String result = "";
        for (Case _case: cases) {
            result += _case.getCode();
        }
        return result;
    }

    public String getCode() {
        return "switch (" + valueName + ") { \n" +
                indent(collectCases(switchCases),1);
    }
}
