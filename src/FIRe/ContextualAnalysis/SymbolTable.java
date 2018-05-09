package FIRe.ContextualAnalysis;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

import FIRe.Exceptions.*;
import FIRe.Nodes.*;
import FIRe.Tuple;

public class SymbolTable  {

    private FIRe.ContextualAnalysis.Stack<Hashtable<String, SymbolData>> stack = new FIRe.ContextualAnalysis.Stack<Hashtable<String,SymbolData>>();
    //Opens a scope when for the default constructor. This is the global scope.
    public SymbolTable(){
        OpenScope();
    }

    //Checks whether a variable is already declared in the current scope and inserts the current input if it isn't.
    public void Insert(DeclarationNode input) throws NameAlreadyUsedInGlobalScopeException, Exception {
        if (!Contains(input.Id.Name)) {

            if (input instanceof NumberDeclarationNode)
                stack.Peek().put((input).Id.Name, new SymbolData(input, "number"));
            else if (input instanceof BooleanDeclarationNode)
                stack.Peek().put((input).Id.Name, new SymbolData(input, "bool"));
            else if (input instanceof TextDeclarationNode)
                stack.Peek().put((input).Id.Name, new SymbolData(input, "text"));
            else if (input instanceof NumberArrayDeclarationNode)
                stack.Peek().put((input).Id.Name, new SymbolData(input, "number array"));
            else if (input instanceof BoolArrayDeclarationNode)
                stack.Peek().put((input).Id.Name, new SymbolData(input, "bool array"));
            else if (input instanceof TextArrayDeclarationNode)
                stack.Peek().put((input).Id.Name, new SymbolData(input, "text array"));
            else if (input instanceof EventTypeDeclarationNode)
                stack.Peek().put((input).Id.Name, new SymbolData(input, ((EventTypeDeclarationNode) input).Type));
            else if(input instanceof FunctionDeclarationNode){
                IdNode idNode = input.Id;
                ArrayList<Tuple<String,String>> fparams = GetParams(input);
                String returnType;

                //NOT SURE IF THIS IS NECESSARY
                if (((FunctionDeclarationNode) input).Type != null)
                    returnType = ((FunctionDeclarationNode) input).Type;
                else
                    returnType = "void";

                for (Tuple<String, String> param: fparams) {
                    //Here we can use peek, because we know a function declaration will only appear at the global scope.
                    if(stack.Peek().containsKey(param.x))
                        throw new NameAlreadyUsedInGlobalScopeException("Variable name in function parameter already used in global scope", param.x);
                }
                stack.Peek().put(idNode.Name, new SymbolData(input, returnType, fparams));

            }
            else if(input instanceof EventDeclarationNode){
                IdNode idNode = input.Id;
                //Saving the name of the event, and a SymbolData instance containing the EventDclNode and its fields.
                stack.Peek().put(idNode.Name, new SymbolData(input, (ArrayList<Tuple<String, String>>) ((EventDeclarationNode)input).Fields));

            }
            else if(input instanceof StrategyDeclarationNode){
                IdNode idNode = input.Id;
                ArrayList<Tuple<String,String>> sparams = GetParams(input);
                for (Tuple<String, String> param: sparams) {
                    //Here we can use peek, because we know a strategy declaration will only appear at the global scope
                    if(stack.Peek().containsKey(param.x))
                        throw new NameAlreadyUsedInGlobalScopeException("Variable name in function parameter already used in global scope", param.x);
                }
                stack.Peek().put(idNode.Name, new SymbolData(input,sparams));
            }
            else
                throw new Exception("This shouldn't happen i think");

            return;
        }
        throw new VariableAlreadyDeclaredException("Variable already declared: " + input.Id.Name + " in line " + input.LineNumber);
    }

    //Help function for Insert. Extracts the parameter types from a FormalParameterNode contained in input's childlist
    private  ArrayList<Tuple<String,String>> GetParams(DeclarationNode input){
        ArrayList<Tuple<String,String>> params = new ArrayList<Tuple<String,String>>();
        for(AbstractNode node : input.childList){
            if(tryParseFormalParameterNode(node)){
                FormalParameterNode fmlNode = (FormalParameterNode) node;

                //Saves the id and type of each variable in the formal parameter
                for(Map.Entry<IdNode, String> entry : fmlNode.parameterMap.entrySet()){
                    params.add(new Tuple<String, String>(entry.getKey().Name,entry.getValue()));
                }
            }
        }
        return params;
    }

    //Use to check if the given node is a FormalParameterNode
    private boolean tryParseFormalParameterNode(AbstractNode node) {
        try {
            FormalParameterNode fmlNode = (FormalParameterNode) node;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Pushes a new scope in the form of a hashtable to our custom stack.
    public void OpenScope(){
        stack.Push(new Hashtable<String, SymbolData>());
    }

    //Closes the scope that is the topmost element of the custom stack. This is done by removing (popping) the topmost element.
    public void CloseScope(){
        stack.Peek().clear();
        stack.Pop();
    }


    //Returns the SymbolData if the name exists in the symbolTable
    public SymbolData Search(String name, int lineNumber) throws SymbolNotFoundException{
        for (int i = 0; i < stack.Size(); i++){
            if(stack.Get(i).containsKey(name)){
                return stack.Get(i).get(name);
            }
        }
        throw new SymbolNotFoundException(name,lineNumber);
    }

    //Returns the SymbolData if the name exists in the symbolTable or null if it doesn't.
    public SymbolData Search(String name) throws IDNotFoundException {
        for (int i = 0; i < stack.Size(); i++){
            if(stack.Get(i).containsKey(name)){
                return stack.Get(i).get(name);
            }
        }
        throw new IDNotFoundException(name);
    }

    //Checks if the current key already exists in the
    public boolean Contains(String key) {
        for (int i = stack.Size() - 1; i >= 0; i--) {
            if(stack.Get(i).keySet().contains(key)){
                return true;
            }
        }
        return false;
    }
    //If the key exist it is then removed
    public void Remove(String key) {
        if (stack.Peek().containsKey(key))
            stack.Peek().remove(key);
    }
}