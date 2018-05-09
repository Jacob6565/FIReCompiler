package FIRe.CodeGeneration;

public class Case extends Indenter{
    Case(String caseName, String body, String caseEnder){
        this.caseName = caseName;
        this.body = body;
        this.caseEnder = caseEnder;
    }
    Case(String caseName, Switch bodySwitch, String caseEnder){
        this.bodySwitch = bodySwitch;
        this.caseName = caseName;
        this.caseEnder = caseEnder;
    }
    //caseEnder is by default break
    private String caseEnder;
    public String caseName = new String();
    public String body = new String();

    //A case can contain a switch, this is used when generating a custom eventhandler
    public Switch bodySwitch = null;

    @Override
    public String toString() {
        if (bodySwitch != null)
            body = bodySwitch.toString();
        return "case " + caseName + ":\n" +
                indent(body + "\n" + caseEnder + ";",1);
    }
}
