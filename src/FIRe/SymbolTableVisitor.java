package FIRe;

@SuppressWarnings("ALL")
public class SymbolTableVisitor extends ASTVisitor {

    public SymbolTable ST = new SymbolTable();

    @Override
    public void visit(AbstractNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(AdditionNode node) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type || node.LeftChild.type == "bool")
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ActualParameterNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(AndNode node) throws Exception{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "bool" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }


    @Override
    public void visit(ArrayAccessNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(AssignNode node) throws Exception {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        if (node != null && node.Id != null && node.Expression != null) {
            VisitNode(node.Id);
            VisitNode(node.Expression);
        }
        if(node.Id.type != node.Expression.type)
            throw new TypeException();
    }

    @Override
    public void visit(BlockNode node) {
        ST.OpenScope();
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        ST.CloseScope();
    }

    @Override
    public void visit(BodyColorNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(BooleanDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(BoolArrayDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(BoolNode node) {
        node.type = "bool";
    }

    @Override
    public void visit(Color node) {

    }

    @Override
    public void visit(ColorValNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(ControlStructureNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(DeclarationNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(DivisionNode node) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(EventDeclarationNode node) throws Exception {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(EqualsNode node) throws Exception{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ExpressionNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(FormalParameterNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(ForNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(FuncCallNode node) {
        for (AbstractNode Node: node.childList)
            if (Node != null){
            VisitNode(Node);
        }
    }

    @Override
    public void visit(FunctionDeclarationNode node) throws Exception {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(GEQNode node) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type == "text" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(GreaterThanNode node) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(GunColorNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(IdNode node){
        try {
             node.type = ST.Search(node.name);
        }
        catch(Exception ex){}
    }

    @Override
    public void visit(IfControlStructureNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(InfixExpressionNode node) throws Exception{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(LEQNode node) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(LessThanNode node) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type == "text" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ModuloNode node) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(MultiplicationNode node) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(NegateNode node) {
        //Is not used
    }

    @Override
    public void visit(NotEqualsNode node) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(NotNode node) {
        node.type = node.Expression.type;
    }

    @Override
    public void visit(NumberDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(NumberArrayDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(NumberNode node) {
        node.type = "number";

    }

    @Override
    public void visit(OrNode node) throws Exception{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "bool" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(PowerNode node) throws Exception {
        if (node.LeftChild != null)
            VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ProgNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RadarColorNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(ReturnNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RobotDclBodyNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RoutineNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(StatementNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(StrategyDeclarationNode node) throws Exception {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(SubtractionNode node) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(TextDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(TextArrayDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(TextNode node) {
        node.type = "text";
    }

    @Override
    public void visit(ValNode node) {
        if(node instanceof TextNode)
            node.type = "text";
        else if(node instanceof  NumberNode)
            node.type = "number";
    }

    @Override
    public void visit(WhenNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    public void visit(ArrayDeclarationNode node){
        for (AbstractNode Node: node.childList){
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(WhileNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

}
