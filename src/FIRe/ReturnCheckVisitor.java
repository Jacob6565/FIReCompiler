package FIRe;
import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.VoidReturnException;
import FIRe.Exceptions.TypeException;
import javafx.beans.binding.When;

import java.util.ArrayList;
import java.util.List;

//Visitor for checking if all branchings can return
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

    //A lot goes on in block node since a constructs has a blocknode
    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {

        //Ancestor is to check if the current block is from a functiondcl or others
        AbstractNode ancestor = node;
        SymbolData data = null;

        //Finding what node the block belongs to.
        while (!(ancestor.Parent instanceof ProgNode)) {
            ancestor = ancestor.Parent;
        }

        if (ancestor instanceof FunctionDeclarationNode) {
            //The current block must be a successor of a functiondcl thus we search for the function in the symboltable
            IdNode functionid = ((FunctionDeclarationNode) ancestor).Id;
            data = table.Search(functionid.Name, 0);
            List<Integer> unreachableLines = new ArrayList<Integer>();

            //If the returntype isn't void we check for returns
            if (!data.type.equals("void")) {
               boolean hasreturn = false;
                for (AbstractNode Node : node.childList) {
                    if (Node instanceof ReturnNode) {
                        hasreturn = true; // The block itself contains a return, thus all branches deeper in the scope can inevitably return
                    }

                    if(hasreturn){
                        unreachableLines.add(Node.LineNumber);
                    }
                }

                if(!unreachableLines.isEmpty()){
                    throw new UnreachableCodeException(unreachableLines);
                }

                if (!hasreturn) { // if however the block does not have a return, it may be hidden under a controlstructue node
                    for (AbstractNode Node : node.childList) {
                        if (Node instanceof ControlStructureNode) {
                            VisitNode(Node);
                        } else
                            throw new ReturnException("You are missing a return in the function", ancestor.LineNumber);
                    }
                }
            }
            else {
                //If this is executed we know the function has return type 'void'
                for (AbstractNode Node : node.childList) {
                    if (Node instanceof ReturnNode) {
                        throw new VoidReturnException(); // we don't allow returns in a void
                    }
                }//loop investigating a controlstructues where a return can be 'hidden'
                for(AbstractNode Node : node.childList){
                    if(Node instanceof ControlStructureNode){
                        VisitNode(Node);
                    }
                }
            }
        } else if (ancestor instanceof StrategyDeclarationNode) {
            //So we know that the current block (node) is inside a strategy. Note that a strategy can not have blocks as a direct child
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
            //Checking the current blocknode "node" which is inside an eventdeclaration.
            for(AbstractNode Node : node.childList)
            {
                //If the block got a return.
                if(Node instanceof ReturnNode)
                {
                    hasReturn = true;
                    break;
                }
                //If it do not have a return node, it may contain other
                // control structures which can contain returns.
                else if(Node instanceof ControlStructureNode){
                    VisitNode(Node);
                }
            }
            //if no return was found.
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