package FIRe;




import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

abstract class AbstractNode
{
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
    public abstract void accept(ASTVisitor v);


    public ArrayList<AbstractNode> childList = new ArrayList<>();

@Override
    public String toString() {
        return Type.class.toString();
    }

    public void Print(){
        System.out.print(this);
        for (AbstractNode AN : this.childList) {
            AN.Print();
        }
    }

}

abstract class ExpressionNode extends AbstractNode
{

}

abstract class StatementNode extends  AbstractNode{

}

abstract class DeclarationNode extends AbstractNode{

}

abstract class ControlStructureNode extends AbstractNode{
    public boolean Incremental;
}

abstract class InfixExpressionNode extends ExpressionNode{
    public ExpressionNode LeftChild;

    public ExpressionNode RightChild;
}

//End abstract classes - begin control structures

class IfControlStructureNode extends ControlStructureNode{
    @Override
    public void accept(ASTVisitor v) {

    }
}

class WhileNode extends ControlStructureNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class ForNode extends  ControlStructureNode{
    @Override
    public void accept(ASTVisitor v) {

    }
}

class RoutineNode extends ControlStructureNode{
    String val;

    public RoutineNode(String val, AbstractNode routineBlock){
        this.val = val;
        childList.add(routineBlock);
    }

    public RoutineNode(AbstractNode id, AbstractNode routineBlock){
        childList.add(id);
        childList.add(routineBlock);
    }

    public RoutineNode(AbstractNode routineBlock){
        val = null;
        childList.add(routineBlock);
    }

    @Override
    public void accept(ASTVisitor v) {

    }
}

//End control-structures - begin RobotProperties

class RobotDclBodyNode extends  AbstractNode{
    @Override
    public void accept(ASTVisitor v) {

    }
}

class GunColorNode extends AbstractNode{
    public ColorValNode Color;

    @Override
    public void accept(ASTVisitor v) {

    }
}

class BodyColorNode extends AbstractNode{
    public ColorValNode Color;

    @Override
    public void accept(ASTVisitor v) {

    }
}

class RadarColorNode extends AbstractNode{
    public ColorValNode Color;

    @Override
    public void accept(ASTVisitor v) {

    }
}

//end RobotProperties - begin Types

class ValNode extends ExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class ArrayAccessNode extends ExpressionNode{
    public ExpressionNode id;
    public ExpressionNode index;

    @Override
    public void accept(ASTVisitor v) {

    }
}

class TextNode extends ValNode{
    public String Content;

    public TextNode(){}
    public TextNode(String content){
        Content = content;
    }
}

class ColorValNode extends AbstractNode{
    public Color Color;

    @Override
    public void accept(ASTVisitor v) {

    }
}

class NumberNode extends ValNode{
    public double value;
    public NumberNode(){}
    public NumberNode(double value){
        this.value = value;
    }
}

class BoolNode extends ExpressionNode{
    public boolean value;

    @Override
    public void accept(ASTVisitor v) {

    }
}

//end types - begin expressions

class AdditionNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class SubtractionNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class MultiplicationNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class DivisionNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class PowerNode extends InfixExpressionNode{
    @Override
    public void accept(ASTVisitor v) {

    }
    /* ex 3^4 */
}

class NegateNode extends ExpressionNode{
    @Override
    public void accept(ASTVisitor v) {

    }
    // ex -34;
}

class NotNode extends ExpressionNode{
    public ExpressionNode Expression;

    @Override
    public void accept(ASTVisitor v) {

    }
}

class AndNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class OrNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class ModuloNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class GreaterThanNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class LessThanNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class GEQNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class LEQNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class EqualsNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class NotEqualsNode extends  InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class IdNode extends ExpressionNode{
    public String name;


    @Override
    public void accept(ASTVisitor v) {

    }
}

//end expressions - begin Statements

class AssignNode extends StatementNode{
    public IdNode Id;
    public ExpressionNode Expression;

    @Override
    public void accept(ASTVisitor v) {

    }
}

class FuncCallNode extends StatementNode{
    @Override
    public void accept(ASTVisitor v) {

    }
}

class ActualParameterNode extends AbstractNode{
    @Override
    public void accept(ASTVisitor v) {

    }
}

class ReturnNode extends StatementNode{
    @Override
    public void accept(ASTVisitor v) {

    }
}

//end statements begin declarations

class NumberDeclarationNode extends DeclarationNode{
    @Override
    public void accept(ASTVisitor v) {

    } //Jeg ved ikke om vi skal lave typechecking endnu

}

class TextDeclarationNode extends DeclarationNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class BooleanDeclarationNode extends DeclarationNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

//end declarations - begin Scope nodes

class WhenNode extends AbstractNode{
    public WhenNode(AbstractNode one, AbstractNode two){
        childList.add(one);
        childList.add(two);
    }

    @Override
    public void accept(ASTVisitor v) {

    }
}

class ConditionDeclarationNode extends AbstractNode{
    @Override
    public void accept(ASTVisitor v) {

    }
}

class BlockNode extends AbstractNode{

    @Override
    public void accept(ASTVisitor v) {

    }
}

class FunctionDeclarationNode extends AbstractNode{
    String type;

    @Override
    public void accept(ASTVisitor v) {

    }
}

class FormalParameterNode extends AbstractNode{
    Map<AbstractNode, String> parameterMap = new HashMap<AbstractNode, String>();

    @Override
    public void accept(ASTVisitor v) {

    }
}

class StrategyDeclarationNode extends AbstractNode{
    public IdNode id;

    @Override
    public void accept(ASTVisitor v) {

    }
    //public List<AbstractNode> childList = new ArrayList<>();
}

class ProgNode extends AbstractNode{
    public ArrayList<AbstractNode> _abstractNodesList = new ArrayList<>();

    @Override
    public void accept(ASTVisitor v) {

    }
}