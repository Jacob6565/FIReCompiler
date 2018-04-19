package FIRe;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class SymbolTable  {

    private FIRe.Stack<Hashtable<String, SymbolData>> stack = new FIRe.Stack<Hashtable<String,SymbolData>>();
    //Opens a scope when for the default constructor. This is the global scope.
    public SymbolTable(){
        OpenScope();
    }

    //Checks whether a variable is already declared in the current scope and inserts the current input if it isn't.
    public void Insert(DeclarationNode input) throws Exception {
        if (!stack.Peek().contains(input)) {

            if (input instanceof NumberDeclarationNode)
                stack.Peek().put((input).Id.name, new SymbolData(input, "number"));
            else if (input instanceof BooleanDeclarationNode)
                stack.Peek().put((input).Id.name, new SymbolData(input, "bool"));
            else if (input instanceof TextDeclarationNode)
                stack.Peek().put((input).Id.name, new SymbolData(input, "text"));
            else if (input instanceof NumberArrayDeclarationNode)
                stack.Peek().put((input).Id.name, new SymbolData(input, "number array"));
            else if (input instanceof BoolArrayDeclarationNode)
                stack.Peek().put((input).Id.name, new SymbolData(input, "bool array"));
            else if (input instanceof TextArrayDeclarationNode)
                stack.Peek().put((input).Id.name, new SymbolData(input, "text array"));
            else if(input instanceof FunctionDeclarationNode){
                IdNode idNode = (IdNode) input.Id;
                ArrayList<String> fparams = GetParamTypes(input);
                String returnType;

                //NOT SURE IF THIS IS NECESSARY
                if (((FunctionDeclarationNode) input).type != null)
                    returnType = ((FunctionDeclarationNode) input).type;
                else
                    returnType = "void";

                stack.Peek().put(idNode.name, new SymbolData(input, returnType, fparams));

            }
            else if(input instanceof EventDeclarationNode){
                IdNode idNode = (IdNode) input.Id;

                stack.Peek().put(idNode.name, new SymbolData(input));

            }
            else if(input instanceof StrategyDeclarationNode){
                IdNode idNode = (IdNode) input.Id;
                ArrayList<String> sparams = GetParamTypes(input);
                stack.Peek().put(idNode.name, new SymbolData(input,sparams));
            }
            else
                throw new Exception();

            return;
        }
        throw new Exception("Variable already declared");
    }

    //Help function for Insert. Extracts the parameter types from a FormalParameterNode contained in input's childlist
    private  ArrayList<String> GetParamTypes(DeclarationNode input){
        ArrayList<String> params = new ArrayList<String>();
        for(AbstractNode node : input.childList){
            if(tryParseFormalParameterNode(node)){
                FormalParameterNode fmlNode = (FormalParameterNode) node;

                for(Map.Entry<IdNode, String> entry : fmlNode.parameterMap.entrySet()){
                    params.add(entry.getValue());
                }
            }
        }
        return params;
    }

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

    //Searches through the hashtables (scopes) on the custom stack to see if the used variable is declared.
    /*public String Search(AbstractNode key) throws Exception{
        for (int i = 0; i < stack.Size(); i++ ){
            if(stack.Get(i).contains(key)){
                return stack.Get(i).get(key.hashCode());
            }
        }
        throw new Exception("Variable is not declared");
    }*/

    //Returns true if the custom stack contains a given key.
    public String Search(String name, int lineNumber) throws SymbolNotFoundException{
        for (int i = stack.Size() - 1; i >= 0; --i) {
            for (int j = 0; j < stack.Get(i).size(); ++j)
            {
                if (stack.Get(i).keySet().toArray()[j].equals(name))
                {
                    return (String)stack.Get(i).values().toArray()[j];
                }
            }
        }
        throw new SymbolNotFoundException(name,lineNumber);
    }

    public boolean Contains(String key) {
        for (int i = 0; i < stack.Size(); i++) {
            if (stack.Get(i).contains(key)) {
                return true;
            }
        }
        return false;
    }
}