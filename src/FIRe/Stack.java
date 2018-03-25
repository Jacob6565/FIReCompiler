package FIRe;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private List<T> list;

    public Stack(){
        list = new ArrayList<>();
    }

    public T Peek(){
        return list.get(list.size()-1);
    }

    public void Push(T element){
        list.add(element);
    }

    public T Pop(){
        T element = Peek();
        list.remove(Peek());
        return element;
    }

    public int Size(){
        return list.size();
    }

    public T Get(int index){
        return list.get(index);
    }
}
