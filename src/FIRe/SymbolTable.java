package FIRe;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class SymbolTable  {

    private FIRe.Stack<Hashtable<String, String>> stack = new FIRe.Stack<Hashtable<String,String>>();
    //Opens a scope when for the default constructor. This is the global scope.
    public SymbolTable(){
        OpenScope();
    }

    //Checks whether a variable is already declared in the current scope and inserts the current input if it isn't.
    public void Insert(DeclarationNode input) throws Exception {
        if (!stack.Peek().contains(input)) {

            if (input instanceof NumberDeclarationNode)
                stack.Peek().put((input).Id.name, "number");
            else if (input instanceof BooleanDeclarationNode)
                stack.Peek().put((input).Id.name, "bool");
            else if (input instanceof TextDeclarationNode)
                stack.Peek().put((input).Id.name, "text");
            else if (input instanceof NumberArrayDeclarationNode)
                stack.Peek().put((input).Id.name, "number array");
            else if (input instanceof BoolArrayDeclarationNode)
                stack.Peek().put((input).Id.name, "bool array");
            else if (input instanceof TextArrayDeclarationNode)
                stack.Peek().put((input).Id.name, "text array");
            else
                throw new Exception();
            return;
        }
        throw new Exception("Variable already declared");
    }

    //Pushes a new scope in the form of a hashtable to our custom stack.
    public void OpenScope(){
        stack.Push(new Hashtable<String, String>());
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
    public String Search(String name) throws Exception{
        for (int i = 0; i < stack.Size(); ++i) {
            for (int j = 0; j < stack.Get(i).size(); ++j)
            {
                if (stack.Get(i).keySet().toArray()[j].equals(name))
                {
                    return (String)stack.Get(i).values().toArray()[j];
                }
            }
        }
        throw new Exception("The element was not found");
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