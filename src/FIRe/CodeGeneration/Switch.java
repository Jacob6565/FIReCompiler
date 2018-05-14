package FIRe.CodeGeneration;

import java.util.ArrayList;


public class Switch extends Indenter {
    Switch(String valueName) {
        this.valueName = valueName;
    }
    Switch(String valueName, Case switchCase){
        this.valueName = valueName;
        switchCases.add(switchCase);
    }
    //Case ender is always break by default
    String caseEnder = "break";
    String valueName = new String();
    ArrayList<Case> switchCases = new ArrayList<Case>();

    //For when we want to add a condition case to the event handler for a custom event
    public void addConditionCase(String condition, String strategyName, String body){
        //This case is for when a condition (custom event) case is already made, and we simply need to add a strategy
        //specific case in the condition's case's switch
        if (getSwitchCase(condition) != null){
            getSwitchCase(condition).bodySwitch.addStrategyCase(strategyName, body);
        }
        //This case is for when a condition (custom event) case doesn't already exist, here we add an entire switch with
        //a case for this specific strategy
        else{
            switchCases.add(new Case(condition, new Switch("currentStrategy_", new Case(strategyName, body,
                                                                                caseEnder)),caseEnder));
        }
    }

    //For when we simply want to add a strategy case to a switch
    public void addStrategyCase(String switchCase, String body){
        switchCases.add(new Case(switchCase, body, caseEnder));
    }

    //Retrieves the case if it exists if not it returns null
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