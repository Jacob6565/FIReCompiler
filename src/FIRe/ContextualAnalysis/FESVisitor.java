package FIRe.ContextualAnalysis;

import FIRe.ASTVisitor;
import FIRe.Main;
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
    public void visit(AdditionNode node, Object... arg) {

    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {

    }

    @Override
    public void visit(AndNode node, Object... arg) {

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
    public void visit(BooleanDeclarationNode node, Object... arg) {
        symbolTable.Insert(node);
        if(subTreeContainsId(node.childList.get(1),node.Id.Name)){
            Main.errors.addError("Could not find symbol " + node.Id.Name + " on line " + node.LineNumber + ".");
        }
    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) {
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
    public void visit(EventDeclarationNode node, Object... arg) {
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
    public void visit(FunctionDeclarationNode node, Object... arg) {
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
    public void visit(IdNode node, Object... arg) {

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
    public void visit(NumberDeclarationNode node, Object... arg) {
        //The Id is null, if it is a multidcl à la "number a, b"
        if (node.Id == null) {
            node.Id = new IdNode();
            node.Id.LineNumber = node.LineNumber;
            for (int i = 0; i < node.childList.size(); ++i) {
                //Insert all the IdNodes in the childlist
                AbstractNode child = node.childList.get(i);
                if (child instanceof IdNode) {
                    symbolTable.Insert(new NumberDeclarationNode((IdNode) child));
                    ((IdNode) child).type = "number";
                    //Add to the mother Node's name
                    if (i == 0) {
                        node.Id.Name = ((IdNode) child).Name;
                        continue;
                    }
                    node.Id.Name += ", " + ((IdNode) child).Name;
                }
            }
            Main.errors.addError("WARNING: " + node.Id.Name + " has been implicitly assigned a value of 0.");
        }
        //Otherwise just insert it normally
        else if(subTreeContainsId(node.childList.get(1), node.Id.Name)) {
            Main.errors.addError("Could not find symbol " + node.Id.Name + " on line " + node.LineNumber + ".");
            } else
                symbolTable.Insert(node);
    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) {
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
        ImportRoboCodeMethods();
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
    public void visit(StrategyDeclarationNode node, Object... arg) {
        ArrayList<String> handledEvents = new ArrayList<>();
        for (AbstractNode Node: node.childList){
            if (Node instanceof WhenNode){
                if(handledEvents.contains(((IdNode)Node.childList.get(0)).Name)){
                    Main.errors.addMultipleEventHandlerError(((IdNode)node.childList.get(0)).Name,node.LineNumber);
                }
                else
                    handledEvents.add(((IdNode)Node.childList.get(0)).Name);
            }
        }
        symbolTable.Insert(node);
        node.Id.type = "strategy";
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) {

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) {
        symbolTable.Insert(node);
        if(subTreeContainsId(node.childList.get(1),node.Id.Name)){
            Main.errors.addError("Could not find symbol " + node.Id.Name + " on line " + node.LineNumber + ".");
        }
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) {
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

    private void ImportRoboCodeMethods(){
        // basic robot movement and interaction
        symbolTable.Insert(new FunctionDeclarationNode("ahead","void", new Tuple<>("distance", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("back", "void", new Tuple<>("distance", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("doNothing", "void"));
        symbolTable.Insert(new FunctionDeclarationNode("fire","void", new Tuple<>("power", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("getBattleFieldHeight",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getBattleFieldWidth",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getEnergy",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getGunHeading",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getGunHeat",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getHeading",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getHeight",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getName", Main.TEXT));
        symbolTable.Insert(new FunctionDeclarationNode("getNumRounds",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getNumSentries",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getOthers",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getRadarHeading",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getRoundNum",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getSentryBorderSize",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getTime",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getVelocity",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getWidth",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getX", Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("getY",Main.NUMBER));
        symbolTable.Insert(new FunctionDeclarationNode("print","void", new Tuple<>("line", Main.TEXT)));
        symbolTable.Insert(new FunctionDeclarationNode("resume","void"));
        symbolTable.Insert(new FunctionDeclarationNode("scan","void"));
        symbolTable.Insert(new FunctionDeclarationNode("setAdjustGunForRobotTurn","void",new Tuple<>("independent",Main.BOOL)));
        symbolTable.Insert(new FunctionDeclarationNode("setAdjustRadarForGunTurn","void", new Tuple<>("independent",Main.BOOL)));
        symbolTable.Insert(new FunctionDeclarationNode("setAdjustRadarForRobotTurn","void", new Tuple<>("independent", Main.BOOL)));
        symbolTable.Insert(new FunctionDeclarationNode("stop","void"));
        // robot movement
        symbolTable.Insert(new FunctionDeclarationNode("turnGunLeft","void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("turnGunRight", "void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("turnLeft","void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("turnRight", "void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("turnRadarLeft","void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("turnRadarRight","void", new Tuple<>("degrees", Main.NUMBER)));
        // Robocode events for when structure
        symbolTable.Insert(new EventDeclarationNode("BattleEndedEvent",0,new Tuple<>("getPriority", Main.NUMBER), new Tuple<>("isAborted",Main.BOOL)));
        symbolTable.Insert(new EventDeclarationNode("BulletHitBulletEvent",0));
        symbolTable.Insert(new EventDeclarationNode("BulletHitEvent",0, new Tuple<>("getEnergy",Main.NUMBER),new Tuple<>("getName",Main.TEXT)));
        symbolTable.Insert(new EventDeclarationNode("BulletMissedEvent",0));
        symbolTable.Insert(new EventDeclarationNode("DeathEvent",0, new Tuple<>("getPriority", Main.NUMBER)));
        symbolTable.Insert(new EventDeclarationNode("HitByBulletEvent",0, new Tuple<>("getBearing", Main.NUMBER),new Tuple<>("getBearingRadians",Main.NUMBER),new Tuple<>("getHeading", Main.NUMBER), new Tuple<>("getHeadingRadians",Main.NUMBER),new Tuple<>("getName", Main.TEXT),new Tuple<>("getPower",Main.NUMBER),new Tuple<>("getVelocity",Main.NUMBER)));
        symbolTable.Insert(new EventDeclarationNode("HitRobotEvent",0,new Tuple<>("getBearing", Main.NUMBER),new Tuple<>("getBearingRadians",Main.NUMBER), new Tuple<>("getEnergy",Main.NUMBER), new Tuple<>("getName", Main.TEXT),new Tuple<>("isMyFault", Main.BOOL)));
        symbolTable.Insert(new EventDeclarationNode("HitWallEvent",0, new Tuple<>("getBearing", Main.NUMBER), new Tuple<>("getBearingRadians",Main.NUMBER)));
        symbolTable.Insert(new EventDeclarationNode("MessageEvent",0, new Tuple<>("getSender", Main.TEXT)));
        symbolTable.Insert(new EventDeclarationNode("RobotDeathEvent",0, new Tuple<>("getName",Main.TEXT)));
        symbolTable.Insert(new EventDeclarationNode("RoundEndedEvent",0, new Tuple<>("getPriority", Main.NUMBER), new Tuple<>("getRound", Main.NUMBER), new Tuple<>("getTotalTurns",Main.NUMBER),new Tuple<>("getTurns",Main.NUMBER)));
        symbolTable.Insert(new EventDeclarationNode("ScannedRobotEvent",0, new Tuple<>("getBearing", Main.NUMBER), new Tuple<>("getBearingRadians",Main.NUMBER), new Tuple<>("getDistance",Main.NUMBER),new Tuple<>("getEnergy",Main.NUMBER),new Tuple<>("getHeading",Main.NUMBER),new Tuple<>("getHeadingRadians",Main.NUMBER),new Tuple<>("getName",Main.TEXT),new Tuple<>("getVelocity",Main.NUMBER), new Tuple<>("isSentryRobot", Main.BOOL)));
        symbolTable.Insert(new EventDeclarationNode("SkippedTurnEvent",0, new Tuple<>("getPriority",Main.NUMBER), new Tuple<>("getSkippedTurn",Main.NUMBER)));
        symbolTable.Insert(new EventDeclarationNode("WinEvent",0,new Tuple<>("getPriority",Main.NUMBER)));
        //Advanced robot functionality using execute and set movement
        symbolTable.Insert(new FunctionDeclarationNode("setAhead","void",new Tuple<>("Distance",Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setBack","void",new Tuple<>("Distance",Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setTurnGunLeft","void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setTurnGunRight", "void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setTurnLeft","void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setTurnRight", "void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setTurnRadarLeft","void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setTurnRadarRight","void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setFire","void", new Tuple<>("power", Main.NUMBER)));
        // radian variant
        symbolTable.Insert(new FunctionDeclarationNode("setTurnRadarLeftRadians","void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setTurnRadarRightRadians","void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setTurnGunLeftRadians","void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setTurnGunRightRadians", "void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setTurnLeftRadians","void", new Tuple<>("degrees", Main.NUMBER)));
        symbolTable.Insert(new FunctionDeclarationNode("setTurnRightRadians", "void", new Tuple<>("degrees", Main.NUMBER)));
        // execute advanced movement
        symbolTable.Insert(new FunctionDeclarationNode("execute","void"));
    }

    private boolean subTreeContainsId(AbstractNode root, String id) {
        if (root instanceof IdNode && ((IdNode) root).Name.equals(id))
            return true;
        else {
            for (int i = 0; i < root.childList.size(); ++i) {
                if (subTreeContainsId(root.childList.get(i), id))
                    return true;
            }
            return false;
        }
    }
}