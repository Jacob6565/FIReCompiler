package FIRe;

import java.lang.reflect.Type;
import java.util.Map;
import FIRe.Exceptions.*;
import javafx.beans.binding.When;

@SuppressWarnings("ALL")
public class SymbolTableVisitor extends ASTVisitor {
    SymbolTableVisitor(SymbolTable symbolTable){
        ST = symbolTable;
    }
    private SymbolTable ST;

    @Override
    public void visit(AbstractNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(AdditionNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if (node.LeftChild.type == "bool" && node.RightChild.type == "bool")
            throw new TypeException("number or text","bool",node.LineNumber);
        else if (node.LeftChild.type == "number" && node.RightChild.type == "text")
            throw new TypeException("number", "text", node.LineNumber);
        else if (node.LeftChild.type == "text" && node.RightChild.type == "number")
            throw new TypeException("text", "number", node.LineNumber);
        else if ((node.LeftChild.type == "number" || node.LeftChild.type == "text") && node.RightChild.type != node.LeftChild.type)
            throw new TypeException(node.LeftChild.type, node.RightChild.type, node.LineNumber);
        else if ((node.RightChild.type == "number" || node.RightChild.type == "text") && node.LeftChild.type != node.RightChild.type)
            throw new TypeException(node.RightChild.type, node.LeftChild.type, node.LineNumber);

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(AndNode node, Object... arg) throws TypeException{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if (node.LeftChild.type != "bool")
            throw new TypeException("bool", node.LeftChild.type,node.LineNumber);
        if (node.RightChild.type != "bool")
            throw new TypeException("bool",node.RightChild.type,node.LineNumber);

        node.type = "bool";
    }


    @Override
    public void visit(ArrayAccessNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(AssignNode node, Object... arg) throws TypeException {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        if(node.Id.type != node.Expression.type)
            throw new TypeException(node.Id.type,node.Expression.type, node.LineNumber);

        if (node != null && node.Id != null && node.Expression != null) {
            VisitNode(node.Id);
            VisitNode(node.Expression);
        }
    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {
        ST.OpenScope();
        if (node.Parent instanceof WhenNode){
            WhenNode Whennode = (WhenNode)node.Parent;
            ST.Insert(new EventTypeDeclarationNode((IdNode) Whennode.childList.get(1),Whennode.childList.get(0).toString()));
        }
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        ST.CloseScope();
    }

    @Override
    public void visit(BodyColorNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        node.Id.type = "bool";
    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
        node.Id.type = "bool array";
    }

    @Override
    public void visit(BoolNode node, Object... arg) {
        node.type = "bool";
    }


    @Override
    public void visit(ColorValNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(ControlStructureNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(DeclarationNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(DivisionNode node, Object... arg) throws TypeException {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws Exception {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(EqualsNode node, Object... arg) throws TypeException{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException(node.LeftChild.type,node.RightChild.type,node.LineNumber);

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(ForNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) {
        for (AbstractNode Node: node.childList)
            if (Node != null){
                VisitNode(Node);
        }
        //Something needs to happen here
    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(GEQNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if (node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if (node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if (node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if (node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(GunColorNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(IdNode node, Object... arg){
        try {
             node.type = ST.Search(node.name, node.LineNumber).type;
        }
        catch (SymbolNotFoundException Ex){
            System.out.println(Ex.getMessage());
        }
    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg) throws Exception{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException("","",0); //This method  should never be called, because InfixExpression is abstract

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(LEQNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(LessThanNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(ModuloNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(NegateNode node, Object... arg) {
        //Is not used
    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException(node.LeftChild.type,node.RightChild.type,node.LineNumber);

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(NotNode node, Object... arg) {
        node.type = node.Expression.type;
    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws TypeException,Exception {
        ST.Insert(node);
        node.Id.type = "number";
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        if (node.childList.size() > 1 && ((ExpressionNode)node.childList.get(1)).type != node.Id.type)
            throw new TypeException(node.Id.type,((ExpressionNode) node.childList.get(1)).type,node.LineNumber);

    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
        node.Id.type = "number array";
    }

    @Override
    public void visit(NumberNode node, Object... arg) {
        node.type = "number";
    }

    @Override
    public void visit(OrNode node, Object... arg) throws Exception{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if (node.LeftChild.type != "bool")
            throw new TypeException("bool", node.LeftChild.type,node.LineNumber);
        if (node.RightChild.type != "bool")
            throw new TypeException("bool",node.RightChild.type,node.LineNumber);

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(PowerNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
            VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(ProgNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RadarColorNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(ReturnNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RobotDclBodyNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RoutineNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(StatementNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number")
            throw new TypeException("number",node.LeftChild.type,node.LineNumber);
        if(node.RightChild.type != "number")
            throw new TypeException("number",node.RightChild.type,node.LineNumber);

        node.type = "number";
    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        node.Id.type = "text";
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
        node.Id.type = "text array";
    }

    @Override
    public void visit(TextNode node, Object... arg) {
        node.type = "text";
    }

    @Override
    public void visit(ValNode node, Object... arg) {
        if(node instanceof TextNode)
            node.type = "text";
        else if(node instanceof  NumberNode)
            node.type = "number";
    }

    @Override
    public void visit(WhenNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(WhileNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }
}
