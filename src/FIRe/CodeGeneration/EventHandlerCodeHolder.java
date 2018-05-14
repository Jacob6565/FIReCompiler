package FIRe.CodeGeneration;

public class EventHandlerCodeHolder extends MethodCodeHolder {
    Switch generatedSwitch;
    EventHandlerCodeHolder(String name, String type, String parameters) {
        super(name, type, parameters);
        generatedSwitch = new Switch(currentStrategyVar);
    }

    //Noget af det her kode gentager sig i RunMethodCodeHolder /KRISTOFFER
    public void addCase(String strategyName, String body){
        generatedSwitch.addStrategyCase(strategyName, body);
    }

    @Override
    public String toString() {
        emit(generatedSwitch.toString(),1);
        return super.toString();
    }
}