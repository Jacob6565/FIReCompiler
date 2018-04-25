package FIRe;
import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.VoidReturnException;
import FIRe.Exceptions.TypeException;
import javafx.beans.binding.When;


public class ReturnCheckVisitor extends ASTVisitor {

    String errorMessageForStrategy = "Can not return in strategy";
    String getErrorMessageForEvent = "Missing return in event";
    public ReturnCheckVisitor(SymbolTable symbolTable){

        table = symbolTable;
    }

    private SymbolTable table;

    @Override
    public void visit(AbstractNode node, Object... arg) {

    }

    @Override
    public void visit(AdditionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {

    }

    @Override
    public void visit(AndNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ArrayAccessNode node, Object... arg) {

    }

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {

        AbstractNode ancestor = node;
        SymbolData data = null;

        //Finding what node the block belongs to.
        while (!(ancestor.Parent instanceof ProgNode)) {
            ancestor = ancestor.Parent;
        }

        if (ancestor instanceof FunctionDeclarationNode) {
            IdNode functionid = ((FunctionDeclarationNode) ancestor).Id;
            data = table.Search(functionid.name, 0);


            //If the returntype isn't void
            if (!data.type.equals("void")) {
                boolean hasreturn = false;
                for (AbstractNode Node : node.childList) {
                    if (Node instanceof ReturnNode) {
                        hasreturn = true; // The block itself contains a return, thus all the branches can inevitably return

                    }
                }

                if (!hasreturn) { // if however the block does not have a return, it may be hidden under an if-node
                    for (AbstractNode Node : node.childList) {
                        if (Node instanceof ControlStructureNode) {
                            VisitNode(Node);
                        } else
                            throw new ReturnException("You are missing a return in the function", ancestor.LineNumber);
                    }
                }
            } else {
                for (AbstractNode Node : node.childList) {
                    if (Node instanceof ReturnNode) {
                        throw new VoidReturnException();
                    }
                }
                for(AbstractNode Node : node.childList){
                    if(Node instanceof ControlStructureNode){
                        VisitNode(Node);
                    }
                }
            }
        } else if (ancestor instanceof StrategyDeclarationNode) {

            //So we know that the current block (node) is inside a strategy.
            for (AbstractNode Node : node.childList){
                //Checking if this block got a return statement.
                if(Node instanceof ReturnNode)
                {
                    throw new ReturnException(errorMessageForStrategy, Node.LineNumber);
                }
                //Checking if the nested blocks inside this block contains returns.
                else if(Node instanceof ControlStructureNode){
                    VisitNode(Node);
                }
            }
        }
        else if(ancestor instanceof EventDeclarationNode)
        {
            boolean hasReturn = false;
            for(AbstractNode Node : node.childList)
            {
                if(Node instanceof ReturnNode)
                {
                    hasReturn = true;
                }
                else if(Node instanceof ControlStructureNode){

                    VisitNode(Node);
                }
            }

            if(hasReturn == false)
            {
                throw new ReturnException(getErrorMessageForEvent, ancestor.LineNumber);
            }
        }
    }

    @Override
    public void visit(BodyColorNode node, Object... arg) {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BoolNode node, Object... arg) {

    }

    @Override
    public void visit(ColorValNode node, Object... arg) {

    }

    @Override
    public void visit(ControlStructureNode node, Object... arg) {

        for (AbstractNode Node: node.childList) {
            if (Node instanceof BlockNode) {
                VisitNode(Node);
            }
        }
    }

    @Override
    public void visit(DeclarationNode node, Object... arg) {

    }

    @Override
    public void visit(DivisionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws Exception {
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {
                VisitNode(child);
            }
        }
    }

    @Override
    public void visit(EqualsNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {

    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {

    }

    @Override
    public void visit(ForNode node, Object... arg) throws ReturnException {
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                VisitNode(child);

            }
        }
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) {

    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {
        //Visit each block node, since you only are allowed to have a return from within a block
        for (AbstractNode Node: node.childList) {
            if (Node instanceof BlockNode) {
                VisitNode(Node);
            }
        }
    }

    @Override
    public void visit(GEQNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GunColorNode node, Object... arg) {

    }

    @Override
    public void visit(IdNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) throws Exception{

        //Checking each block of a controlstructure.
        /*Breaking since, when breaking you will call another method
         which calls this again and therefore no need to check rest of the children*/
        for (AbstractNode Node: node.childList) {
            if (Node instanceof BlockNode) {
                VisitNode(Node);
            }
        }
    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(LEQNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(LessThanNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ModuloNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NegateNode node, Object... arg) {

    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NotNode node, Object... arg) {

    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NumberNode node, Object... arg) {

    }

    @Override
    public void visit(OrNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(PowerNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ProgNode node, Object... arg) throws ReturnException {
        //Stating point. Calling its children i.e FunctionDcl.
        for (AbstractNode Node: node.childList) {
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RadarColorNode node, Object... arg) {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            VisitNode(Node);
        }

    }

    @Override
    public void visit(RobotDclBodyNode node, Object... arg) {

    }

    @Override
    public void visit(RoutineNode node, Object... arg) {
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                VisitNode(child);
            }
        }
    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {

        for(AbstractNode child : node.childList) {
            //This checks is there is a return in the first scope of a strategy.
            if (child instanceof ReturnNode) {
                throw new ReturnException(errorMessageForStrategy, child.LineNumber);
            }
            //Checking if returns exist in all the nested scopes.
            else if (child instanceof ControlStructureNode || child instanceof WhenNode) {
                VisitNode(child);
            }
        }
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextNode node, Object... arg) {

    }

    @Override
    public void visit(ValNode node, Object... arg) {

    }

    @Override
    public void visit(WhenNode node, Object... arg) {
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                VisitNode(child);
            }
        }
    }

    @Override
    public void visit(WhileNode node, Object... arg) {
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                VisitNode(child);
            }
        }
    }
}
/*
    public ReturnCheckVisitor(SymbolTable symbolTable){

        table = symbolTable;
    }

    private SymbolTable table;

    @Override
    public void visit(AbstractNode node, Object... arg) {

    }

    @Override
    public void visit(AdditionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {

    }

    @Override
    public void visit(AndNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ArrayAccessNode node, Object... arg) {

    }

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {

        AbstractNode parentFunction = node;
        SymbolData data = null;

        while (!(parentFunction.Parent instanceof ProgNode)) {
            parentFunction = parentFunction.Parent;
        }

        if (parentFunction instanceof FunctionDeclarationNode) {
            data = table.Search(parentFunction.Parent.toString(), 0);

            if (!data.type.equals("void")) {
                boolean hasreturn = false;
                for (AbstractNode Node : node.childList) {
                    if (Node instanceof ReturnNode) {
                        hasreturn = true; // The block itself contains a return, thus all the branches can inevitably return
                        //Her skal man se om det så er det rigtige der bliver returneret
                    }
                }

                if (!hasreturn) { // if however the block does not have a return, it may be hidden under an if-node
                    for (AbstractNode Node : node.childList) {
                        if (Node instanceof ControlStructureNode) {
                            VisitNode(Node);
                        } else
                            throw new ReturnException("You are missing a return", Node.LineNumber);
                    }
                }
            } else {
                for (AbstractNode Node : node.childList) {
                    if (Node instanceof ReturnNode) {
                        throw new VoidReturnException();
                    }
                }
                for(AbstractNode Node : node.childList){
                    if(Node instanceof ControlStructureNode){
                        VisitNode(Node);
                    }
                }
            }
        } else if (parentFunction instanceof StrategyDeclarationNode) {*/
/*            for (AbstractNode Node : parentFunction.childList) {
                if(Node instanceof ReturnNode){
                    throw new ReturnException("Stragies must not return", Node.LineNumber);
                }
            }*/
/*
            for (AbstractNode Node : parentFunction.childList){
                if(Node instanceof ControlStructureNode){
                    VisitNode(Node);
                }
            }
        }
    }

    @Override
    public void visit(BodyColorNode node, Object... arg) {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BoolNode node, Object... arg) {

    }

    @Override
    public void visit(ColorValNode node, Object... arg) {

    }

    @Override
    public void visit(ControlStructureNode node, Object... arg) {

        for (AbstractNode Node: node.childList) {
            if (Node instanceof BlockNode) {
                VisitNode(Node);
            }
        }
    }

    @Override
    public void visit(DeclarationNode node, Object... arg) {

    }

    @Override
    public void visit(DivisionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws Exception {
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {
                VisitNode(child);
            }
        }
    }

    @Override
    public void visit(EqualsNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {

    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {

    }

    @Override
    public void visit(ForNode node, Object... arg) throws ReturnException {
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                VisitNode(child);
                break;
            }
        }
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) {

    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {
        for (AbstractNode Node: node.childList) {
            if(Node instanceof BlockNode){
                VisitNode(Node);  //Visit each block node, since you only are allowed to have a return from within a block
            }
        }
    }

    @Override
    public void visit(GEQNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GunColorNode node, Object... arg) {

    }

    @Override
    public void visit(IdNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) {

        AbstractNode parentFunction = node;

        while (!(parentFunction.Parent instanceof ProgNode)) {
            parentFunction = parentFunction.Parent;
        }

        if(parentFunction instanceof StrategyDeclarationNode){
            for (AbstractNode Node : node.childList) {

            }
        }

        for (AbstractNode Node: node.childList) {
            if (Node instanceof BlockNode) {
                VisitNode(Node);
            }
        }
    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(LEQNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(LessThanNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ModuloNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NegateNode node, Object... arg) {

    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NotNode node, Object... arg) {

    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NumberNode node, Object... arg) {

    }

    @Override
    public void visit(OrNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(PowerNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ProgNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RadarColorNode node, Object... arg) {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            VisitNode(Node);
        }

    }

    @Override
    public void visit(RobotDclBodyNode node, Object... arg) {

    }

    @Override
    public void visit(RoutineNode node, Object... arg) {
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                VisitNode(child);
                break;
            }
        }
    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {

        for(AbstractNode child : node.childList){
            if(child instanceof ReturnNode){
                throw new ReturnException("Strategies cannot contain return", child.LineNumber);
            }
        }
        for(AbstractNode child : node.childList){
            if(child instanceof ControlStructureNode || child instanceof WhenNode)
                VisitNode(child);
        }
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextNode node, Object... arg) {

    }

    @Override
    public void visit(ValNode node, Object... arg) {

    }

    @Override
    public void visit(WhenNode node, Object... arg) {
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                VisitNode(child);
                break;
            }
        }
    }

    @Override
    public void visit(WhileNode node, Object... arg) {
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                VisitNode(child);
                break;
            }
        }
    }*/

