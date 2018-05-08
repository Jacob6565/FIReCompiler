package FIRe.CodeGeneration;

public class EventCodeHolder extends CodeHolder{
    EventCodeHolder(String eventName){
        super();
        this.eventName = eventName;
    }

    String eventName;

    @Override
    public String toString() {
        return "addCustomEvent(\n" +
                "\tnew Condition(\"" + eventName + "\") {\n" +
                "\t\tpublic boolean test() {\n" +
                "\t\t\t"+sb.toString() + "\n" +
                "\t\t}; \n" +
                "\t}\n" +
                ");";
    }
}