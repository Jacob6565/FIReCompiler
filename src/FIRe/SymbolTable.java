package FIRe;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class SymbolTable  {

    private FIRe.Stack<Hashtable<AbstractNode, String>> stack = new FIRe.Stack<Hashtable<AbstractNode,String>>();

    public SymbolTable(){
        OpenScope();
    }

    public void Insert(AbstractNode input) throws Exception{
        if(!stack.Peek().contains(input)) {
            stack.Peek().put(input, input.toString());
            return;
        }
        throw new Exception("Variable allerede brugt");
    }

    public void OpenScope(){
        stack.Push(new Hashtable<AbstractNode, String>());
    }

    public void CloseScope(){
        stack.Peek().clear();
        stack.Pop();
    }

    public String Search(AbstractNode key) throws Exception{
        for (int i = 0; i < stack.Size(); i++ ){
            if(stack.Get(i).contains(key)){
                return stack.Get(i).get(key.hashCode());
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
