package FIRe;

public class Case extends Indenter{
    Case(String caseName, Switch bodySwitch){
        this.bodySwitch = bodySwitch;
        this.caseName = caseName;
    }
    Case(String caseName, String body){
        this.body = body;
        this.caseName = caseName;
    }
    public String caseName = new String();
    public String body = new String();
    public Switch bodySwitch = null;

    public String getCode() {
        if (bodySwitch != null)
            body = bodySwitch.getCode();
        return "case " + caseName + ":\n" +
                indent(body + "break;",1);
    }
}
