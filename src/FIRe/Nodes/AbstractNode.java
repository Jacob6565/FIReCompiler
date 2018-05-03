package FIRe.Nodes;
import FIRe.ASTVisitor;

import java.lang.reflect.Type;
import java.util.*;

//begin enums
enum Color{
    red,
    blue,
    yellow,
    green,
    black,
    white
}
//end enums - begin abstract classes

public abstract class AbstractNode
{
    public AbstractNode Parent;
    public AbstractNode LeftMostSibling;
    public AbstractNode LeftMostChild;
    public AbstractNode RightSibling;
    public int LineNumber;

    //Should contain management functions.
    public void connectSibling()
    {

    }
    public void adoptChildren()
    {

    }

    /*Each class needs this in order to accept a
    * visit from a visitor. Then each nodes has to call
    * its childrens accept-methods.*/
    public abstract void accept(ASTVisitor v, AbstractNode parent) throws Exception;

    public ArrayList<AbstractNode> childList = new ArrayList<>();

    @Override
    public String toString() {
        return Type.class.toString();
    }

    private void Print(){
        System.out.print(this);
        for (AbstractNode AN : this.childList) {
            AN.Print();
        }
    }

}
