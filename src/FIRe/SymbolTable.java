package FIRe;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class SymbolTable  {

    private Stack<Hashtable<String, String>> stack = new Stack<Hashtable<String, String>>();

    public SymbolTable(){
        OpenScope();
    }

    public void Insert(String input) throws Exception{
        if(!stack.firstElement().contains(input)) {
            stack.firstElement().put((String.valueOf(input.hashCode())), input);
            return;
        }
        throw new Exception("Variable allerede brugt");
    }

    public void OpenScope(){
        stack.push(new Hashtable<String, String>());
    }

    public void CloseScope(){
        stack.pop();
    }

    public String Search(String key) throws Exception{
        for (int i = stack.size()-1; i >= 0; i-- ){
            if(stack.get(i).contains(key)){
                return stack.elementAt(i).get(String.valueOf(key.hashCode()));
            }
        }
        throw new Exception("Variabel kunne ikke findes");
    }

    public boolean Contains(String key){
        for (int i = stack.size()-1; i >= 0; i-- ){
            if(stack.get(i).contains(key)){
                return true;
            }
        }
        return false;
    }





}
