package FIRe;

import FIRe.MethodCodeHolder;

public class EventHandlerCodeHolder extends MethodCodeHolder {
    StringBuilder generatedSwitch = new StringBuilder();
    EventHandlerCodeHolder(String name, String type, String parameters) {
        super(name, type, parameters);
        generatedSwitch.append(indent("switch(currentStrategy){\n", 1));
    }

    //Noget af det her kode gentager sig i RunMethodCodeHolder /KRISTOFFER
    public void addCase(String strategyName, String body){
        generatedSwitch.append(indent("case " + "\"" + strategyName + "\"", 2));
        generatedSwitch.append(indent(body + "break;", 3));
    }

    @Override
    public String getCode() {
        generatedSwitch.append(indent("}\n", 1));
        sb.append(generatedSwitch.toString());
        return super.getCode();
    }
}
