package FIRe.CodeGeneration;

import FIRe.ASTVisitor;
import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.SymbolNotFoundException;
import FIRe.Exceptions.TypeException;
import FIRe.Nodes.*;

public class CGStrategyVisitor extends ASTVisitor {

    public CGStrategyVisitor(RunMethodCodeHolder RMCH){
        CH = RMCH;
    }

    RunMethodCodeHolder CH;

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
    public void visit(ArrayAccessNode node, Object... arg) throws TypeException, SymbolNotFoundException {

        CGExpressionVisitor CGE = new CGExpressionVisitor();
        CGE.GenerateExprCode(CH, node);
    }

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {
        CGExpressionVisitor CGE = new CGExpressionVisitor();

        for (AbstractNode Node: node.childList) {
            if(Node instanceof IdNode){
                if(((IdNode) Node).ArrayIndex == null){
                    visitNode(Node);
                }
                else{
                    visitNode(Node);
                    CH.emit("[");
                    ExpressionNode temp =  ((IdNode) Node).ArrayIndex;
                    CGE.GenerateExprCode(CH, temp);
                    CH.emit("] = ");
                }
            }
            if(Node instanceof InfixExpressionNode){
                visitNode(Node);

            }

            if(Node instanceof NumberNode){
                NumberNode temp = (NumberNode)Node;
                CGE.GenerateExprCode(CH, temp);
            }
            if(Node instanceof AdditionNode){
                AdditionNode temp = (AdditionNode)Node;
                CH.emit(" = ");
                CGE.GenerateExprCode(CH, temp);
            }
        }
        CH.emitNL(";");

    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BodyColorNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {

        CGExpressionVisitor CGE = new CGExpressionVisitor();

        int idCounter = 0;
        boolean exprFlag = false;

        for(AbstractNode id : node.childList){
            if(id instanceof IdNode)
                idCounter++;
            else if(id instanceof ExpressionNode)
                exprFlag = true;
        }

        CH.emit("boolean ");

        for(AbstractNode id : node.childList){
            if(id instanceof IdNode && idCounter > 1){
                CH.emit(((IdNode) id).Name + ", ");
                idCounter--;
            }

            else if(id instanceof IdNode && exprFlag){
                CH.emit(((IdNode) id).Name + " = ");
            }

            else if(id instanceof IdNode){
                CH.emitNL(((IdNode) id).Name + ";");
            }

            else if(id instanceof ExpressionNode){
                CH.emitNL(CGE.GenerateExprCode(CH, (ExpressionNode) id) + ";");
            }
        }
    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
        CH.emit("boolean");
        for(AbstractNode Node: node.childList) {
            visitNode(Node);
        }
    }

    @Override
    public void visit(BoolNode node, Object... arg) {
        CGExpressionVisitor CGE = new CGExpressionVisitor();
        CGE.GenerateExprCode(CH,node);
    }

    @Override
    public void visit(ColorValNode node, Object... arg) {

    }

    @Override
    public void visit(ControlStructureNode node, Object... arg) {

    }

    @Override
    public void visit(DeclarationNode node, Object... arg) {
        for (AbstractNode Node:node.childList) {
            visitNode(Node);
        }

    }

    @Override
    public void visit(DivisionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws Exception {

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
    public void visit(ForNode node, Object... arg) throws TypeException, ReturnException {

    }

    @Override
    public void visit(FuncCallNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GEQNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GunColorNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(IdNode node, Object... arg) throws Exception {
        CH.emit(node.Name);
    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) throws Exception {

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
        CH.emit("double ");
        for (AbstractNode Node: node.childList) {
            if(Node instanceof IdNode){
                IdNode temp = (IdNode)Node;
                visit(temp);
            }
        }
        CH.emit(" = ");
        for (AbstractNode Node: node.childList) {
            if(Node instanceof NumberNode){
                visitNode(Node);
            }
        }
        CH.emitNL(";");
    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {
        CH.emit("double "); // we know we need to write a double

        CGExpressionVisitor CGE = new CGExpressionVisitor();

        for(AbstractNode Node : node.childList){
            if(Node instanceof IdNode){
                visitNode(Node);
                CH.emit("[]"); // After we have visited the ID we know we shoould emit this
            }
        }
        CH.emit(" = new double["); // In java you need to allocate a new array on the heap.
        for(AbstractNode Node: node.childList){
            if(Node instanceof NumberNode) {
                CH.emit("(int)"); // Necessary since we need to write it as an int
                CGE.GenerateExprCode(CH, (NumberNode)Node);
                CH.emit("]");
            }
        }

        CH.emitNL(";");
    }

    @Override
    public void visit(NumberNode node, Object... arg) {
        CH.emit(node.value);
    }

    @Override
    public void visit(OrNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(PowerNode node, Object... arg) throws Exception {
        CGExpressionVisitor CGE = new CGExpressionVisitor();
        CGE.GenerateExprCode(CH, node);
    }

    @Override
    public void visit(ProgNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(RadarColorNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) throws TypeException {

    }


    @Override
    public void visit(RoutineNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {
        for (AbstractNode Node: node.childList) {
            visitNode(Node);
        }
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {
        CH.emit("String ");
        for(AbstractNode Node: node.childList) {
            if(Node instanceof IdNode) {
                visitNode(Node);
            }
            if(Node instanceof TextNode){
                CH.emit(" = ");
                visitNode(Node);
                CH.emitNL(";");
            }
        }
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        CH.emit("text");
        for(AbstractNode Node: node.childList) {
            visitNode(Node);
        }
    }

    @Override
    public void visit(TextNode node, Object... arg) {

        CGExpressionVisitor CGE = new CGExpressionVisitor();
        CGE.GenerateExprCode(CH, node);
    }

    @Override
    public void visit(ValNode node, Object... arg) {


    }

    @Override
    public void visit(WhenNode node, Object... arg) {

    }

    @Override
    public void visit(WhileNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(RobotNameNode node, Object... arg) {

    }

    @Override
    public void visit(RobotTypeNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(RobotPropertiesNode node, Object... arg) {

    }
}