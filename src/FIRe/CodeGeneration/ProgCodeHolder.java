package FIRe.CodeGeneration;

import java.util.ArrayList;

public class ProgCodeHolder extends CodeHolder{
    SetupCodeHolder setup = new SetupCodeHolder();
    RunMethodCodeHolder runMethod = new RunMethodCodeHolder("run", "void");
    ArrayList<MethodCodeHolder> methods = new ArrayList<MethodCodeHolder>();
    private ArrayList<EventHandlerCodeHolder> eventHandlers = new ArrayList<EventHandlerCodeHolder>();
    Enum strategyEnum = new Enum(strategyEnumName);
    Enum conditionEnum = new Enum(conditionEnumName);

    int blockIndent = 1;

    public EventHandlerCodeHolder addEventHandler(String methodeName, String fparam){
        if (eventHandlers.size()==0 || getEventHandler(methodeName)== null){
            EventHandlerCodeHolder newEventHandler = new EventHandlerCodeHolder(methodeName, "void", fparam);
            eventHandlers.add(newEventHandler);
            return newEventHandler;
        }
        else{
            return getEventHandler(methodeName);
        }
    }

    public CustomEventHandlerCodeHolder addCustomEventHandler(String methodeName, String fparam){
        if (eventHandlers.size()==0 || getEventHandler(methodeName)== null){
            CustomEventHandlerCodeHolder newEventHandler = new CustomEventHandlerCodeHolder(methodeName, "void", fparam);
            eventHandlers.add(newEventHandler);
            return newEventHandler;
        }
        else{
            return (CustomEventHandlerCodeHolder) getEventHandler(methodeName);
        }
    }

    private EventHandlerCodeHolder getEventHandler(String eventHandlerName){
        for (EventHandlerCodeHolder eventHandler: eventHandlers) {
            if (eventHandler.name.equals(eventHandlerName))
                return eventHandler;
        }
        return null;
    }

    public void addEnumStrategyValue(String strategyValue){
        addEnumValue(strategyEnum, strategyValue);
    }

    public void addEnumConditionValue(String conditionValue){
        addEnumValue(conditionEnum, conditionValue);
    }

    private void addEnumValue(Enum _enum, String enumValue){
        _enum.addValue(enumValue);
    }

    //Merges all the inputted CodeHolders correctly and returns them as one single String
    private String mergeCodeHolders(){
        StringBuilder mergedCode = new StringBuilder();

        setup._enums = strategyEnum.getCode() + "\n" + conditionEnum.getCode() + "\n";
        setup.emit(runMethod.toString(), blockIndent);
        for (MethodCodeHolder method: methods) {
            setup.emit(method.toString(), blockIndent);
        }
        for (EventHandlerCodeHolder eventHandler: eventHandlers) {
            setup.emit(eventHandler.toString(), blockIndent);
        }

        mergedCode.append(setup.toString());

        return mergedCode.toString();
    }

    @Override
    public String toString() {
        return mergeCodeHolders();
    }
}