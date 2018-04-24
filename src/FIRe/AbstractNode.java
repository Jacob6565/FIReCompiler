package FIRe;




import java.beans.Expression;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
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

abstract class ExpressionNode extends AbstractNode
{
    String type;
}

abstract class StatementNode extends  AbstractNode{

}

abstract class DeclarationNode extends AbstractNode{
    public IdNode Id;

    public DeclarationNode(IdNode id){
        Id = id;
    }
    public DeclarationNode(){   }
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
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for (AbstractNode child:childList) {
            if(child != null)
                child.accept(v, this);
        }
    }
    public ExpressionNode Expression;
}

class WhileNode extends ControlStructureNode{
    public ExpressionNode Expression;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : childList)
            node.accept(v, this);
    }
}

class ForNode extends ControlStructureNode{

    public ExpressionNode From;
    public ExpressionNode To;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode child : childList)
        {
            if(child != null)
                child.accept(v, this);
        }
    }
}

class RoutineNode extends ControlStructureNode{
    ExpressionNode repeatCondition;

    public RoutineNode(AbstractNode routineBlock, int lineNumber) {
        repeatCondition = null;
        childList.add(routineBlock);
        LineNumber = lineNumber;
    }

    public RoutineNode(AbstractNode expr, AbstractNode routineBlock, int lineNumber){
        repeatCondition = (ExpressionNode) expr;
        childList.add(routineBlock);
        LineNumber = lineNumber;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : childList)
            node.accept(v, this);
    }
}

//End control-structures - begin RobotProperties

class RobotDclBodyNode extends  AbstractNode{
    String robotType;
    String robotName;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for (AbstractNode child: childList)
        {
            child.accept(v, this);
        }
    }
}

class GunColorNode extends AbstractNode{
    public ColorValNode Color;
    GunColorNode(String color){
        Color = new ColorValNode(color);
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        //bruges ikke
    }
}

class BodyColorNode extends AbstractNode{
    public ColorValNode Color;

    BodyColorNode(String color){
        Color = new ColorValNode(color);
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        //bruges ikke
    }
}

class RadarColorNode extends AbstractNode{
    public ColorValNode Color;

    RadarColorNode(String color){
        Color = new ColorValNode(color);
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        //bruges ikke
    }
}

//end RobotProperties - begin Types

class ValNode extends ExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        //Denne burde ikke blive benyttet
    }
}

class ArrayAccessNode extends ExpressionNode{
    public IdNode Id;
    public ExpressionNode index;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        Id.accept(v, this);
        index.accept(v, this);
    }
}

abstract class ArrayDeclarationNode extends DeclarationNode{
    public IdNode Id;
    public ExpressionNode Size;

    public ArrayDeclarationNode(IdNode id)
    {
        super(id);
    }

    public ArrayDeclarationNode(){
        super();
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception{
        v.visit(this, parent);
        Id.accept(v, this);
        Size.accept(v, this);
    }
}

class NumberArrayDeclarationNode extends ArrayDeclarationNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception{
        v.visit(this, parent);
        Id.accept(v, this);
        Size.accept(v, this);
    }
    public NumberArrayDeclarationNode(IdNode id)
    {
        super(id);
    }

    public NumberArrayDeclarationNode(){
        super();
    }
}

class TextArrayDeclarationNode extends ArrayDeclarationNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception{
        v.visit(this, parent);
        Id.accept(v, this);
        Size.accept(v, this);
    }
    public TextArrayDeclarationNode(IdNode id)
    {
        super(id);
    }

    public TextArrayDeclarationNode(){
        super();
    }
}

class BoolArrayDeclarationNode extends ArrayDeclarationNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception{
        v.visit(this, parent);
        Id.accept(v, this);
        Size.accept(v, this);
    }

    public BoolArrayDeclarationNode(IdNode id)
    {
        super(id);
    }

    public BoolArrayDeclarationNode(){
        super();
    }
}

class TextNode extends ValNode{
    public String Content;

    public TextNode(){}
    public TextNode(String content){
        Content = content;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        v.visit(this, parent);
    }
}

class ColorValNode extends AbstractNode{
    String Color;

    ColorValNode(String Color){
        this.Color = Color;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        //bruges ikke
    }
}

class NumberNode extends ValNode{
    public double value;
    public NumberNode(){}
    public NumberNode(double value){
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        v.visit(this);
    }
}

class BoolNode extends ExpressionNode{
    public boolean value;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        v.visit(this);
    }
}

//end types - begin expressions

class AdditionNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class SubtractionNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class MultiplicationNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class DivisionNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class PowerNode extends InfixExpressionNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
    /* ex 3^4 */
}

class NegateNode extends ExpressionNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        //Tror ikke denne bliver benyttet
    }
    // ex -34;
}

class NotNode extends ExpressionNode{
    public ExpressionNode Expression;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.Expression.accept(v, this);
    }
}

class AndNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class OrNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class ModuloNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class GreaterThanNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class LessThanNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class GEQNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class LEQNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class EqualsNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class NotEqualsNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
}

class IdNode extends ExpressionNode {
    public String name;
    //public String type;
    public NumberNode ArrayIndex;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
    }
}

//end expressions - begin Statements

class AssignNode extends StatementNode{
    public IdNode Id;
    public ExpressionNode Expression;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for (AbstractNode child: childList) {
            if(child != null)
                child.accept(v, this);
        }
    }
}

class FuncCallNode extends ExpressionNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : childList)
            node.accept(v, this);
    }
    public ActualParameterNode Aparam;
    public IdNode Id;

}

class ActualParameterNode extends AbstractNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode child : childList)
        {
            if(child != null)
                child.accept(v, this);
        }
    }
}

class ReturnNode extends StatementNode{

    public ReturnNode(AbstractNode node,int lineNumber){
        childList.add(node);
        LineNumber = lineNumber;
    }
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        if(childList.get(0) != null)
            childList.get(0).accept(v, this);
    }
}

//end statements begin declarations

class NumberDeclarationNode extends DeclarationNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for (AbstractNode node : this.childList) {
            if(node != null)
                node.accept(v, this);
        }
    }

    public NumberDeclarationNode(IdNode id)
    {
        super(id);
    }

    public NumberDeclarationNode(){
        super();
    }


}

class TextDeclarationNode extends DeclarationNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for (AbstractNode node : this.childList) {
            if(node != null)
                node.accept(v, this);
        }
    }
    public TextDeclarationNode(IdNode id)
    {
        super(id);
    }

    public TextDeclarationNode(){
        super();
    }
}

class BooleanDeclarationNode extends DeclarationNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for (AbstractNode node : this.childList) {
            if(node != null)
                node.accept(v, this);
        }
    }
    public BooleanDeclarationNode(IdNode id)
    {
        super(id);
    }

    public BooleanDeclarationNode(){
        super();
    }
}

//end declarations - begin Scope nodes

class WhenNode extends AbstractNode{
    public WhenNode(AbstractNode one, AbstractNode two){
        childList.add(one);
        childList.add(two);
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : childList)
            node.accept(v, this);
    }
}

class EventDeclarationNode extends DeclarationNode{
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);

        for(AbstractNode node : childList)
            node.accept(v, this);
    }
}

class BlockNode extends AbstractNode{

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : this.childList)
            if(node != null)
                node.accept(v, this);
    }
}

class FunctionDeclarationNode extends DeclarationNode{
    String type;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : childList)
            if(node != null)
                node.accept(v, this);
    }
}

class FormalParameterNode extends AbstractNode{
    Map<IdNode, String> parameterMap = new HashMap<IdNode, String>();

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) {
        //Hvor man inde i denne visit metode så printer elementerne i mappen.
        v.visit(this, parent);
    }
}

class StrategyDeclarationNode extends DeclarationNode{


    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : this.childList)
            if(node != null)
                node.accept(v, this);
    }
    //public List<AbstractNode> childList = new ArrayList<>();
}

class ProgNode extends AbstractNode{
    public ArrayList<AbstractNode> _abstractNodesList = new ArrayList<>();

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode child : childList)
            if(child != null)
                child.accept(v, this);
    }
}

class EventTypeDeclarationNode extends DeclarationNode{
    public String Type;

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception { }

    public EventTypeDeclarationNode(IdNode id, String type)
    {
        super(id);
        Type = type;
    }

    public EventTypeDeclarationNode(){
        super();
    }
}