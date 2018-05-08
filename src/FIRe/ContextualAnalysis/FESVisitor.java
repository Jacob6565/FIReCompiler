package FIRe.ContextualAnalysis;

import FIRe.ASTVisitor;

import javax.xml.soap.Text;

import FIRe.Exceptions.MultipleEventHandlerException;
import FIRe.Nodes.*;
import FIRe.Tuple;

import java.util.ArrayList;
import java.util.List;

//Visitor used to check the declerations of functions, events and strategies
public class FESVisitor extends ASTVisitor {
    public FESVisitor(SymbolTable symbolTable){
        this.symbolTable = symbolTable;
    }

    private SymbolTable symbolTable;



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
    public void visit(AssignNode node, Object... arg) {

    }

    @Override
    public void visit(BlockNode node, Object... arg) {

    }

    @Override
    public void visit(BodyColorNode node, Object... arg) {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {
        symbolTable.Insert(node);
    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
        symbolTable.Insert(node);
    }

    @Override
    public void visit(BoolNode node, Object... arg) {

    }

    @Override
    public void visit(ColorValNode node, Object... arg) {

    }

    @Override
    public void visit(ControlStructureNode node, Object... arg) {

    }

    @Override
    public void visit(DeclarationNode node, Object... arg) {

    }

    @Override
    public void visit(DivisionNode node, Object... arg) {

    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws Exception {
        symbolTable.Insert(node);
    }

    @Override
    public void visit(EqualsNode node, Object... arg) {

    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {

    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {

    }

    @Override
    public void visit(ForNode node, Object... arg) {

    }

    @Override
    public void visit(FuncCallNode node, Object... arg) {

    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {
        symbolTable.Insert(node);
    }

    @Override
    public void visit(GEQNode node, Object... arg) {

    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) {

    }

    @Override
    public void visit(GunColorNode node, Object... arg) {

    }

    @Override
    public void visit(IdNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) {

    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg) {

    }

    @Override
    public void visit(LEQNode node, Object... arg) {

    }

    @Override
    public void visit(LessThanNode node, Object... arg) {

    }

    @Override
    public void visit(ModuloNode node, Object... arg) {

    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) {

    }

    @Override
    public void visit(NegateNode node, Object... arg) {

    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) {

    }

    @Override
    public void visit(NotNode node, Object... arg) {

    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws Exception {
        symbolTable.Insert(node);

    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {
        symbolTable.Insert(node);
    }

    @Override
    public void visit(NumberNode node, Object... arg) {

    }

    @Override
    public void visit(OrNode node, Object... arg) {

    }

    @Override
    public void visit(PowerNode node, Object... arg) {

    }

    @Override
    public void visit(ProgNode node, Object... arg) {
        try {
            ImportRoboCodeMethods();
        }
        catch (Exception Ex){
            System.out.println(Ex.getMessage() + "Error in importing Robocode functions");
        }
        for (AbstractNode Node : node.childList) {
            //Adding all the global declarations by visiting the individual nodes.
            if(Node != null && Node instanceof FunctionDeclarationNode)
                visitNode(Node);
            else if(Node != null && Node instanceof EventDeclarationNode)
                visitNode(Node);
            else if(Node != null && Node instanceof StrategyDeclarationNode)
                visitNode(Node);
            else if(Node != null && Node instanceof NumberArrayDeclarationNode)
                visitNode(Node);
            else if(Node != null && Node instanceof TextArrayDeclarationNode)
                visitNode(Node);
            else if(Node != null && Node instanceof BoolArrayDeclarationNode)
                visitNode(Node);
            else if(Node != null && Node instanceof NumberDeclarationNode)
                visitNode(Node);
            else if(Node != null && Node instanceof TextDeclarationNode)
                visitNode(Node);
            else if(Node != null && Node instanceof BooleanDeclarationNode)
                visitNode(Node);
        }
    }



    @Override
    public void visit(RadarColorNode node, Object... arg) {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) {
    }

    @Override
    public void visit(RobotPropertiesNode node, Object...arg){

    }

    @Override
    public void visit(RoutineNode node, Object... arg) {

    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {
        ArrayList<String> handledEvents = new ArrayList<>();
        node.Id.Name += "()";
        for (AbstractNode Node: node.childList){
            if (Node instanceof WhenNode){
                if(handledEvents.contains(((IdNode)Node.childList.get(0)).Name)){
                    throw new MultipleEventHandlerException(((IdNode)node.childList.get(0)).Name,Node.LineNumber);
                }
                else
                    handledEvents.add(((IdNode)Node.childList.get(0)).Name);
            }
        }
        symbolTable.Insert(node);
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) {

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {
        symbolTable.Insert(node);
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        symbolTable.Insert(node);
    }

    @Override
    public void visit(TextNode node, Object... arg) {

    }

    @Override
    public void visit(ValNode node, Object... arg) {

    }

    @Override
    public void visit(WhenNode node, Object... arg) {

    }

    @Override
    public void visit(WhileNode node, Object... arg) {

    }

    @Override
    public void visit(RobotNameNode node, Object... arg) {

    }
    @Override
    public void visit(RobotTypeNode node, Object... arg) {

    }

    private void ImportRoboCodeMethods() throws Exception {
        symbolTable.Insert(new FunctionDeclarationNode("ahead","void", new Tuple<>("distance", "number")));
        symbolTable.Insert(new FunctionDeclarationNode("back", "void", new Tuple<>("distance", "number")));
        symbolTable.Insert(new FunctionDeclarationNode("doNothing()", "void"));
        symbolTable.Insert(new FunctionDeclarationNode("fire","void", new Tuple<>("power", "number")));
        symbolTable.Insert(new FunctionDeclarationNode("getBattleFieldHeight()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getBattleFieldWidth()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getEnergy()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getGunHeading()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getGunHeat()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getHeading()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getHeight()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getName()", "text"));
        symbolTable.Insert(new FunctionDeclarationNode("getNumRounds()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getNumSentries()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getOthers()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getRadarHeading()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getRoundNum()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getSentryBorderSize()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getTime()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getVelocity()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getWidth()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("getX()", "number"));
        symbolTable.Insert(new FunctionDeclarationNode("getY()","number"));
        symbolTable.Insert(new FunctionDeclarationNode("print","void", new Tuple<>("line", "text")));
        symbolTable.Insert(new FunctionDeclarationNode("resume()","void"));
        symbolTable.Insert(new FunctionDeclarationNode("scan()","void"));
        symbolTable.Insert(new FunctionDeclarationNode("setAdjustGunForRobotTurn","void",new Tuple<>("independent","bool")));
        symbolTable.Insert(new FunctionDeclarationNode("setAdjustRadarForGunTurn","void", new Tuple<>("independent","bool")));
        symbolTable.Insert(new FunctionDeclarationNode("setAdjustRadarForRobotTurn","void", new Tuple<>("independent", "bool")));
        symbolTable.Insert(new FunctionDeclarationNode("stop()","void"));
        symbolTable.Insert(new FunctionDeclarationNode("turnGunLeft","void", new Tuple<>("degrees", "number")));
        symbolTable.Insert(new FunctionDeclarationNode("turnGunRight", "void", new Tuple<>("degrees", "number")));
        symbolTable.Insert(new FunctionDeclarationNode("turnLeft","void", new Tuple<>("degrees", "number")));
        symbolTable.Insert(new FunctionDeclarationNode("turnRadarLeft","void", new Tuple<>("degrees", "number")));
        symbolTable.Insert(new FunctionDeclarationNode("turnRadarRight","void", new Tuple<>("degrees", "number")));
        symbolTable.Insert(new FunctionDeclarationNode("turnRight", "void", new Tuple<>("degrees", "number")));
        symbolTable.Insert(new EventDeclarationNode("BattleEndedEvent",0,new Tuple<>("getPriority", "number"), new Tuple<>("isAborted()","bool")));
        symbolTable.Insert(new EventDeclarationNode("BulletHitBulletEvent",0));
        symbolTable.Insert(new EventDeclarationNode("BulletHitEvent",0, new Tuple<String,String>("getEnergy","number"),new Tuple<>("getName()","text")));
        symbolTable.Insert(new EventDeclarationNode("BulletMissedEvent",0));
        symbolTable.Insert(new EventDeclarationNode("DeathEvent",0, new Tuple<>("getPriority()", "number")));
        symbolTable.Insert(new EventDeclarationNode("HitByBulletEvent",0, new Tuple<>("getBearing()", "number"),new Tuple<>("getBearingRadians()","number"),new Tuple<>("getHeading()", "number"), new Tuple<>("getHeadingRadians()","number"),new Tuple<>("getName()", "text"),new Tuple<>("getPower()","number"),new Tuple<>("getVelocity()","number")));
        symbolTable.Insert(new EventDeclarationNode("HitRobotEvent",0,new Tuple<>("getBearing()", "number"),new Tuple<>("getBearingRadians()","number"), new Tuple<>("getEnergy()","number"), new Tuple<>("getName()", "text"),new Tuple<>("isMyFault()", "bool")));
        symbolTable.Insert(new EventDeclarationNode("HitWallEvent",0, new Tuple<>("getBearing()", "number"), new Tuple<>("getBearingRadians","number")));
        symbolTable.Insert(new EventDeclarationNode("MessageEvent",0, new Tuple<>("getSender()", "text")));
        symbolTable.Insert(new EventDeclarationNode("RobotDeathEvent",0, new Tuple<>("getName()","text")));
        symbolTable.Insert(new EventDeclarationNode("RoundEndedEvent",0, new Tuple<>("getPriority()", "number"), new Tuple<>("getRound()", "number"), new Tuple<>("getTotalTurns()","number"),new Tuple<>("getTurns()","number")));
        symbolTable.Insert(new EventDeclarationNode("ScannedRobotEvent",0, new Tuple<>("getBearing()", "number"), new Tuple<>("getBearingRadians()","number"), new Tuple<>("getDistance()","number"),new Tuple<>("getEnergy()","number"),new Tuple<>("getHeading()","number"),new Tuple<>("getHeadingRadians()","number"),new Tuple<>("getName()","text"),new Tuple<>("getVelocity()","number"), new Tuple<>("isSentryRobot()", "bool")));
        symbolTable.Insert(new EventDeclarationNode("SkippedTurnEvent",0, new Tuple<>("getPriority()","number"), new Tuple<>("getSkippedTurn()","number")));
        symbolTable.Insert(new EventDeclarationNode("WinEvent",0,new Tuple<>("getPriority()","number")));
    }
}