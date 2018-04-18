package FIRe;

@SuppressWarnings("ALL")
public class SymbolTableVisitor extends ASTVisitor {

    public SymbolTable ST = new SymbolTable();

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

    private void VisitNode(AbstractNode node) {
        try {
            if (node instanceof ProgNode)
                visit((ProgNode) node);
            else if (node instanceof ActualParameterNode)
                visit((ActualParameterNode) node);
            else if (node instanceof AdditionNode)
                visit((AdditionNode) node);
            else if (node instanceof AndNode)
                visit((AndNode) node);
            else if (node instanceof ArrayAccessNode)
                visit((ArrayAccessNode) node);
            else if (node instanceof AssignNode)
                visit((AssignNode) node);
            else if (node instanceof BlockNode)
                visit((BlockNode) node);
            else if (node instanceof BodyColorNode)
                visit((BodyColorNode) node);
            else if (node instanceof BooleanDeclarationNode)
                visit((BooleanDeclarationNode) node);
            else if (node instanceof BoolNode)
                visit((BoolNode) node);
            else if (node instanceof ColorValNode)
                visit((ColorValNode) node);
            else if (node instanceof DivisionNode)
                visit((DivisionNode) node);
            else if (node instanceof EventDeclarationNode)
                visit((EventDeclarationNode) node);
            else if (node instanceof EqualsNode)
                visit((EqualsNode) node);
            else if (node instanceof FormalParameterNode)
                visit((FormalParameterNode) node);
            else if (node instanceof ForNode)
                visit((ForNode) node);
            else if (node instanceof FuncCallNode)
                visit((FuncCallNode) node);
            else if (node instanceof FunctionDeclarationNode)
                visit((FunctionDeclarationNode) node);
            else if (node instanceof GEQNode)
                visit((GEQNode) node);
            else if (node instanceof GreaterThanNode)
                visit((GreaterThanNode) node);
            else if (node instanceof GunColorNode)
                visit((GunColorNode) node);
            else if (node instanceof IdNode)
                visit((IdNode) node);
            else if (node instanceof IfControlStructureNode)
                visit((IfControlStructureNode) node);
            else if (node instanceof LEQNode)
                visit((LEQNode) node);
            else if (node instanceof LessThanNode)
                visit((LessThanNode) node);
            else if (node instanceof ModuloNode)
                visit((ModuloNode) node);
            else if (node instanceof MultiplicationNode)
                visit((MultiplicationNode) node);
            else if (node instanceof NegateNode)
                visit((NegateNode) node);
            else if (node instanceof NotEqualsNode)
                visit((NotEqualsNode) node);
            else if (node instanceof NotNode)
                visit((NotNode) node);
            else if (node instanceof NumberDeclarationNode)
                visit((NumberDeclarationNode) node);
            else if (node instanceof NumberNode)
                visit((NumberNode) node);
            else if (node instanceof OrNode)
                visit((OrNode) node);
            else if (node instanceof PowerNode)
                visit((PowerNode) node);
            else if (node instanceof RadarColorNode)
                visit((RadarColorNode) node);
            else if (node instanceof ReturnNode)
                visit((ReturnNode) node);
            else if (node instanceof RobotDclBodyNode)
                visit((RobotDclBodyNode) node);
            else if (node instanceof RoutineNode)
                visit((RoutineNode) node);
            else if (node instanceof StrategyDeclarationNode)
                visit((StrategyDeclarationNode) node);
            else if (node instanceof SubtractionNode)
                visit((SubtractionNode) node);
            else if (node instanceof TextDeclarationNode)
                visit((TextDeclarationNode) node);
            else if (node instanceof TextNode)
                visit((TextNode) node);
            else if (node instanceof ValNode)
                visit((ValNode) node);
            else if (node instanceof WhenNode)
                visit((WhenNode) node);
            else if (node instanceof WhileNode)
                visit((WhileNode) node);
            else if (node instanceof NumberArrayDeclarationNode)
                visit ((NumberArrayDeclarationNode) node);
            else if (node instanceof BoolArrayDeclarationNode)
                visit ((BoolArrayDeclarationNode) node);
            else if (node instanceof TextArrayDeclarationNode)
                visit ((TextArrayDeclarationNode) node);
            else
                System.out.println("Symbol table visitor Error");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
