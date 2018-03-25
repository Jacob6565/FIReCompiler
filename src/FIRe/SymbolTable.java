package FIRe;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class SymbolTable  {

    private FIRe.Stack<Hashtable<String, String>> stack = new FIRe.Stack<Hashtable<String, String>>();

    public SymbolTable(){
        OpenScope();
    }

    public void Insert(String input) throws Exception{
        if(!stack.Peek().contains(input)) {
            stack.Peek().put((String.valueOf(input.hashCode())), input);
            return;
        }
        throw new Exception("Variable allerede brugt");
    }

    public void OpenScope(){
        stack.Push(new Hashtable<String, String>());
    }

    public void CloseScope(){
        stack.Peek().clear();
        stack.Pop();
    }

    public String Search(String key) throws Exception{
        for (int i = 0; i < stack.Size(); i++ ){
            if(stack.Get(i).contains(key)){
                return stack.Get(i).get(String.valueOf(key.hashCode()));
            }
        }
        throw new Exception("Variabel kunne ikke findes");
    }

    public boolean Contains(String key){
        for (int i = 0; i < stack.Size(); i++ ){
            if(stack.Get(i).contains(key)){
                return true;
            }
        }
        return false;
    }





}
