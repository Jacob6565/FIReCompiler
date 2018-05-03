package FIRe.CodeGeneration;

import java.util.ArrayList;

public class ProgCodeHolder extends CodeHolder{
    SetupCodeHolder setup = new SetupCodeHolder();
    RunMethodCodeHolder runMethod = new RunMethodCodeHolder("run", "void");
    ArrayList<MethodCodeHolder> methods = new ArrayList<MethodCodeHolder>();
    private ArrayList<EventHandlerCodeHolder> eventHandlers = new ArrayList<EventHandlerCodeHolder>();

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

    //Merges all the inputted CodeHolders correctly and returns them as one single String
    private String mergeCodeHolders(){
        StringBuilder mergedCode = new StringBuilder();

        setup.emit(runMethod.getCode(), blockIndent);
        for (MethodCodeHolder method: methods) {
            setup.emit(method.getCode(), blockIndent);
        }
        for (EventHandlerCodeHolder eventHandler: eventHandlers) {
            setup.emit(eventHandler.getCode(), blockIndent);
        }

        mergedCode.append(setup.getCode());

        return mergedCode.toString();
    }

    @Override
    public String getCode() {
        return mergeCodeHolders();
    }
}