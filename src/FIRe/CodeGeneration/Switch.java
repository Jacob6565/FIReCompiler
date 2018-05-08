package FIRe.CodeGeneration;

import java.util.ArrayList;


public class Switch extends Indenter {
    Switch(String valueName, String caseEnder) {
        this.valueName = valueName;
        this.caseEnder = caseEnder;
    }
    Switch(String valueName, Case switchCase){
        this.valueName = valueName;
        switchCases.add(switchCase);
    }
    //Case ender is break by default
    String caseEnder = "break";
    String valueName = new String();
    ArrayList<Case> switchCases = new ArrayList<Case>();

    public void addConditionCase(String condition, String strategyName, String body){
        if (getSwitchCase(condition) != null){
            getSwitchCase(condition).bodySwitch.addStrategyCase(strategyName, body);
        }
        else{
            switchCases.add(new Case(condition, new Switch("currentStrategy_", new Case(strategyName, body,
                                                                                caseEnder)),caseEnder));
        }
    }

    public void addStrategyCase(String switchCase, String body){
        switchCases.add(new Case(switchCase, body, caseEnder));
    }

    private Case getSwitchCase(String caseName){
        for (Case _case: switchCases) {
            if (_case.caseName.equals(caseName))
                return _case;
        }
        return null;
    }

    private String collectCases(ArrayList<Case> cases){
        String result = "";
        for (Case _case: cases) {
            result += _case.toString();
        }
        return result;
    }

    @Override
    public String toString() {
        return "switch (" + valueName + ") { \n" +
                indent(collectCases(switchCases),1) + "\n}";
    }
}