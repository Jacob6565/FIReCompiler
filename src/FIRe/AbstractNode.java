package FIRe;


import java.util.ArrayList;
import java.util.List;

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
    public void traverseAST()
    {

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

}

abstract class InfixExpressionNode extends ExpressionNode{
    public ExpressionNode LeftChild;

    public ExpressionNode RightChild;
}

//End abstract classes - begin control structures

class IfControlStructureNode extends ControlStructureNode{

}

class WhileNode extends ControlStructureNode{

}

class ForNode extends  ControlStructureNode{

}

class RoutineNode extends ControlStructureNode{

}

//End control-structures - begin RobotProperties

class RobotPropertiesNode extends AbstractNode{
    public TextNode Name;
    public TextNode RobotType;
    public GunColorNode GunColor;
    public BodyColorNode BodyColor;
    public RadarColorNode RadarColor;
}

class GunColorNode extends AbstractNode{
    public ColorValNode Color;
}

class BodyColorNode extends AbstractNode{
    public ColorValNode Color;
}

class RadarColorNode extends AbstractNode{
    public ColorValNode Color;
}

//end RobotProperties - begin Types

class TextNode extends AbstractNode{
    public String Content;
}

class ColorValNode extends AbstractNode{
    public Color Color;
}

class NumberNode extends ExpressionNode{
    public double Value;
}

class BoolNode extends ExpressionNode{
    public boolean Value;
}

//end types - begin expressions

class AdditionNode extends InfixExpressionNode{

}

class SubtractionNode extends InfixExpressionNode{

}

class MultiplicationNode extends InfixExpressionNode{

}

class DivisionNode extends InfixExpressionNode{

}

class PowerNode extends InfixExpressionNode{
    /* ex 3^4 */
}

class NegateNode extends ExpressionNode{
    // ex -34;
}

class NotNode extends ExpressionNode{
    public ExpressionNode Expression;
}

class AndNode extends InfixExpressionNode{

}

class OrNode extends InfixExpressionNode{

}

class ModuloNode extends InfixExpressionNode{

}

class TypeFuncCallNode extends ExpressionNode{

}

class IdNode extends ExpressionNode{
    public String Value;
}

//end expressions - begin Statements

class AssignNode extends StatementNode{
    public IdNode Id;
    public ExpressionNode Expression;
}

class VoidFuncCallNode extends StatementNode{

}

class ReturnNode extends StatementNode{

}

//end statements begin declarations

class NumberDeclarationNode extends DeclarationNode{ //Jeg ved ikke om vi skal lave typechecking endnu

}

class TextDeclarationNode extends DeclarationNode{

}

class BooleanDeclarationNode extends DeclarationNode{

}

//end declarations - begin Scope nodes

class WhenNode extends AbstractNode{

}

class ConditionDeclarationNode extends AbstractNode{

}

class FunctionDeclarationNode extends AbstractNode{

}

class StrategyDeclarationNode extends AbstractNode{

}

class ProgNode extends AbstractNode{
    public List<AbstractNode> childList = new ArrayList<>();
    //public RobotPropertiesNode robotProperties = new RobotPropertiesNode();
}