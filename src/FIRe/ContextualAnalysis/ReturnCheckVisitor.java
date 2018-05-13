package FIRe.ContextualAnalysis;
import FIRe.ASTVisitor;
import FIRe.Main;
import FIRe.Nodes.*;

import java.util.ArrayList;
import java.util.List;

//Visitor for checking if all branchings can return
public class ReturnCheckVisitor extends ASTVisitor {

    //Variables containing an error message.
    String errorMessageForStrategy = "Can not return in strategy";
    String getErrorMessageForEvent = "Missing return in event";


    public ReturnCheckVisitor(SymbolTable symbolTable){

        //Getting an instance of the symboltable, which has already been modified.
        table = symbolTable;
    }

    private SymbolTable table;

    @Override
    public void visit(AbstractNode node, Object... arg) {

    }

    @Override
    public void visit(AdditionNode node, Object... arg){

    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {

    }

    @Override
    public void visit(AndNode node, Object... arg){

    }

    @Override
    public void visit(ArrayAccessNode node, Object... arg) {

    }

    @Override
    public void visit(AssignNode node, Object... arg){

    }

    //A lot goes on in block node since a constructs has a blocknode
    @Override
    public void visit(BlockNode node, Object... arg) {

        //Ancestor is to check if the current block is from a functiondcl or others
        AbstractNode ancestor = node;
        SymbolData data = null;

        //Finding what node the block belongs to, either: function, strategy or event.
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
                ChecksFunctionWithNonVoidReturnType(node, ancestor, unreachableLines);
            }
            else {
                //If this is executed we know the function has return type 'void'
                ChecksFunctionWithVoidReturnType(node, ancestor);

            }
        }
        else if (ancestor instanceof StrategyDeclarationNode) {
            //So we know that the current block (node) is inside a strategy. Note that a strategy can not have blocks as a direct child
            ChecksStrategy(node);

        }
        else if(ancestor instanceof EventDeclarationNode)
        {
            ChecksEvent(node, ancestor);

        }
    }

    private void ChecksEvent(BlockNode node, AbstractNode ancestor){
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
                visitNode(Node);
            }
        }
        //if no return was found.
        if(!hasReturn)
        {
            addReturnError(getErrorMessageForEvent, ancestor.LineNumber);
        }
    }

    private void ChecksStrategy(BlockNode node){
        for (AbstractNode Node : node.childList){
            //Checking if this block got a return statement.
            if(Node instanceof ReturnNode)
            {
                Main.errors.addReturnError(errorMessageForStrategy, Node.LineNumber);
            }
            //Checking if the nested blocks inside this block contains returns.
            //e.g return inside an if-statement.
            else if(Node instanceof ControlStructureNode){
                visitNode(Node);
            }
        }
    }

    private void ChecksFunctionWithVoidReturnType(BlockNode node, AbstractNode ancestor){
        for (AbstractNode Node : node.childList) {
            if (Node instanceof ReturnNode) {
                Main.errors.addVoidReturnError(ancestor.LineNumber, Node.LineNumber); // we don't allow returns in a void
            }
        }
        //loop investigating a controlstructues where a return can be 'hidden'.
        //Blocks can be nested due to nested constrolstructures.
        for(AbstractNode Node : node.childList){
            if(Node instanceof ControlStructureNode){
                visitNode(Node);
            }
        }
    }

    private void ChecksFunctionWithNonVoidReturnType(BlockNode node, AbstractNode ancestor, List<Integer> unreachableLines){
        boolean hasreturn = false;
        for (AbstractNode Node : node.childList) {
            if (Node instanceof ReturnNode && !hasreturn) {
                hasreturn = true;
                // The block itself contains a return, thus all branches deeper in the scope can inevitably return
                //And are therefore added to unreachable lines.
            }
            //If return has been found, all following lines are unreachable.
            else if(hasreturn){
                unreachableLines.add(Node.LineNumber);
            }
        }

        if(!unreachableLines.isEmpty()){
            addUnreachableCodeError(unreachableLines);
        }

        // if however the block does not have a return, it may be hidden under a controlstructue node
        if (!hasreturn) {
            for (AbstractNode Node : node.childList) {
                if (Node instanceof ControlStructureNode) {
                    visitNode(Node);
                } else
                    Main.errors.addReturnError("You are missing a return in the function", ancestor.LineNumber);
            }
            //if the block does not contain anything;
            if(node.childList.isEmpty()){
                Main.errors.addReturnError("You are missing a return in the function", ancestor.LineNumber);
            }
        }
    }


    @Override
    public void visit(BodyColorNode node, Object... arg) {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg){

    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg){

    }

    @Override
    public void visit(BoolNode node, Object... arg) {

    }

    @Override
    public void visit(ColorValNode node, Object... arg) {

    }

    @Override
    public void visit(ControlStructureNode node, Object... arg) {

        //visiting its children since it can contain blocks and other constrol structures.
        for (AbstractNode Node: node.childList) {
            if (Node instanceof BlockNode) {
                visitNode(Node);
            }
        }
    }

    @Override
    public void visit(DeclarationNode node, Object... arg) {

    }

    @Override
    public void visit(DivisionNode node, Object... arg){

    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg){

        //visiting its children since it can contain blocks and other constrol structures.
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode) {
                visitNode(child);
            }
        }
    }

    @Override
    public void visit(EqualsNode node, Object... arg){

    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {

    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {

    }

    @Override
    public void visit(ForNode node, Object... arg) {
        //visiting its children since it can contain blocks and other constrol structures.
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                visitNode(child);

            }
        }
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) {

    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg){
        //Visit each block node, since you only are allowed to have a return from within a block
        for (AbstractNode Node: node.childList) {
            if (Node instanceof BlockNode) {
                visitNode(Node);
            }
        }
    }

    @Override
    public void visit(GEQNode node, Object... arg){

    }

    @Override
    public void visit(GreaterThanNode node, Object... arg){

    }

    @Override
    public void visit(GunColorNode node, Object... arg) {

    }

    @Override
    public void visit(IdNode node, Object... arg){

    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg){

        //visiting its children since it can contain blocks and other constrol structures.
        for (AbstractNode Node: node.childList) {
            if (Node instanceof BlockNode) {
                visitNode(Node);
            }
        }
    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg){

    }

    @Override
    public void visit(LEQNode node, Object... arg){

    }

    @Override
    public void visit(LessThanNode node, Object... arg){

    }

    @Override
    public void visit(ModuloNode node, Object... arg){

    }

    @Override
    public void visit(MultiplicationNode node, Object... arg){

    }

    @Override
    public void visit(NegateNode node, Object... arg) {

    }

    @Override
    public void visit(NotEqualsNode node, Object... arg){

    }

    @Override
    public void visit(NotNode node, Object... arg) {

    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg){

    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg){

    }

    @Override
    public void visit(NumberNode node, Object... arg) {

    }

    @Override
    public void visit(OrNode node, Object... arg){

    }

    @Override
    public void visit(PowerNode node, Object... arg){

    }

    @Override
    public void visit(ProgNode node, Object... arg) {
        //Stating point. Calling its children i.e FunctionDcl.
        for (AbstractNode Node: node.childList) {
            visitNode(Node);
        }
    }

    @Override
    public void visit(RadarColorNode node, Object... arg) {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) {

        for (AbstractNode Node: node.childList) {
            visitNode(Node);
        }

    }

    @Override
    public void visit(RobotPropertiesNode node, Object...arg){

    }

    @Override
    public void visit(RoutineNode node, Object... arg) {
        //visiting its children since it can contain blocks and other constrol structures.
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                visitNode(child);
            }
        }
    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg){

        for(AbstractNode child : node.childList) {
            //This checks is there is a return in the first scope of a strategy.
            if (child instanceof ReturnNode) {
                Main.errors.addReturnError(errorMessageForStrategy,child.LineNumber);
            }
            //Checking if returns exist in all the nested scopes.
            else if (child instanceof ControlStructureNode || child instanceof WhenNode) {
                visitNode(child);
            }
        }
    }

    @Override
    public void visit(SubtractionNode node, Object... arg){

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg){

    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg){

    }

    @Override
    public void visit(TextNode node, Object... arg) {

    }

    @Override
    public void visit(ValNode node, Object... arg) {

    }

    @Override
    public void visit(WhenNode node, Object... arg) {
        //visiting its children since it can contain blocks and other constrol structures.
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                visitNode(child);
            }
        }
    }

    @Override
    public void visit(WhileNode node, Object... arg) {
        //visiting its children since it can contain blocks and other constrol structures.
        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                visitNode(child);
            }
        }
    }

    @Override
    public void visit(RobotNameNode node, Object... arg) {

    }

    @Override
    public void visit(RobotTypeNode node, Object... arg) {

    }
    private void addReturnError(String errStr, int lineNum){
           Main.errors.addError("ERROR: " + errStr + " in line " + lineNum + ".");
    }
    private void addUnreachableCodeError(List<Integer> values){
        String lines = "";
        for (Integer i : values)
        {
            lines += i.toString() + ", ";
        }
        Main.errors.addError("ERROR: Unreachable code at lines: " + lines);
    }
}