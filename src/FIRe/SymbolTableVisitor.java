package FIRe;

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
    public void visit(AdditionNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type || node.LeftChild.type == "bool")
            throw new TypeException();

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
    public void visit(AndNode node, Object... arg) throws Exception{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "bool" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }


    @Override
    public void visit(ArrayAccessNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {
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
    public void visit(BlockNode node, Object... arg) {
        ST.OpenScope();
        if (node.Parent instanceof FunctionDeclarationNode)
        {
            for (AbstractNode AN: node.Parent.childList) {
                if (AN instanceof FormalParameterNode){
                    System.out.println("");

                }
            }
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
    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
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
    public void visit(DivisionNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

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
    public void visit(EqualsNode node, Object... arg) throws Exception{
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

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

        if(node.LeftChild.type == "text" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
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
             node.type = ST.Search(node.name, node.LineNumber);
        }
        catch(SymbolNotFoundException ex){
            System.out.println(ex.getMessage());
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
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(LEQNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(LessThanNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type == "text" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ModuloNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
        VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
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
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(NotNode node, Object... arg) {
        node.type = node.Expression.type;
    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
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

        if(node.LeftChild.type != "bool" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(PowerNode node, Object... arg) throws Exception {
        if (node.LeftChild != null)
            VisitNode(node.LeftChild);
        if (node.RightChild != null)
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
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

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
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
