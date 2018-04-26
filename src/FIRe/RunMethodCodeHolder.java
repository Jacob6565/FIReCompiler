package FIRe;

public class RunMethodCodeHolder extends MethodCodeHolder {
    int caseNumber = 0;

    RunMethodCodeHolder(String name, String type) {
        super(name, type);
        this.emitNL("switch(currentStrategy){", 1);
    }

    public void addToRunMethod(String strategyName, String body) {
        this.emitNL("case " + "\"" + strategyName + "\"", 2);
        this.emitNL(body + "\n break;", 3);
    }
}
