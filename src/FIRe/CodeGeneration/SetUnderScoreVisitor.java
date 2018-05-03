package FIRe.CodeGeneration;

import FIRe.ASTVisitor;
import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.SymbolNotFoundException;
import FIRe.Exceptions.TypeException;
import FIRe.ContextualAnalysis.*;
import FIRe.Nodes.*;

import java.util.Map;

public class SetUnderScoreVisitor extends ASTVisitor {
    private SymbolTable _symbolTable;

    public SetUnderScoreVisitor(SymbolTable table) throws Exception {
        _symbolTable = table;
        try {
            //RemoveRoboCodeMethods();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Error in removing Robocode functions");
        }
    }

    @Override
    public void visit(AbstractNode node, Object... arg) {

    }

    @Override
    public void visit(AdditionNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(AndNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(ArrayAccessNode node, Object... arg) throws TypeException, SymbolNotFoundException {
        if (node.Id != null)
            visitNode(node.Id);
        if (node.index != null)
            visitNode(node.index);
    }

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {
        if (node.Id != null)
            visitNode(node.Id);

        if (node.Expression != null)
            visitNode(node.Expression);
    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(BodyColorNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for (AbstractNode child : node.childList)
            visitNode(child);
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
    public void visit(DivisionNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws Exception {
        if (node.Id != null)
            visitNode(node.Id);
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(EqualsNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {

    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) throws Exception {
        for (Map.Entry<IdNode, String> entry : node.parameterMap.entrySet())
            visitNode(entry.getKey());

    }

    @Override
    public void visit(ForNode node, Object... arg) throws TypeException, ReturnException {
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) throws Exception {

        if (!CheckIfRoboCodeMethod(node.Id.Name)) {
            visitNode(node.Id);
        }
        if (node.Aparam != null)
            visitNode(node.Aparam);

    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {
        visitNode(node.Id);
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(GEQNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(GunColorNode node, Object... arg) throws TypeException {

    }

    //Prefixes IDs with _ if it doesnt have it and appends the strategy name to differentiate variables of same
    // name in different strategies (Needed because of how we generate code)
    @Override
    public void visit(IdNode node, Object... arg) throws Exception {
        AbstractNode ancestor = node;
        String firstStr;
        String secondString;
        if (!node.Name.contains(".")) {
            while (ancestor.Parent != null) {
                if (ancestor.Parent instanceof StrategyDeclarationNode && !(node.Parent.Parent instanceof ProgNode) && !(node.Parent instanceof WhenNode) && !(node.Parent instanceof FuncCallNode)) {
                    node.Name = node.Name + ((StrategyDeclarationNode) ancestor.Parent).Id.Name;
                }
                ancestor = ancestor.Parent;
            }
        }

        if (node.Name.charAt(0) != '_')
            node.Name = "_" + node.Name;
    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) throws Exception {
        if (node.Expression != null)
            visitNode(node.Expression);
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(LEQNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(LessThanNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(ModuloNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(NegateNode node, Object... arg) {

    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(NotNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for (AbstractNode child : node.childList)
            visitNode(child);

    }

    @Override
    public void visit(NumberNode node, Object... arg) {

    }

    @Override
    public void visit(OrNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(PowerNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(ProgNode node, Object... arg) throws Exception {
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(RadarColorNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) throws TypeException {
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(RoutineNode node, Object... arg) throws TypeException {
        if (node.repeatCondition != null)
            visit(node.repeatCondition);

        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {
        node.Id.Name = "_" + node.Id.Name;
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws Exception {
        visitNode(node.LeftChild);
        visitNode(node.RightChild);
    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(TextNode node, Object... arg) {

    }

    @Override
    public void visit(ValNode node, Object... arg) {

    }

    @Override
    public void visit(WhenNode node, Object... arg) {
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(WhileNode node, Object... arg) throws TypeException {
        visitNode(node.Expression);
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    @Override
    public void visit(RobotNameNode node, Object... arg) {
        node.RobotName.Name ="FIRe_" + node.RobotName.Name;
    }

    @Override
    public void visit(RobotTypeNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(RobotPropertiesNode node, Object... arg) {
        for (AbstractNode child : node.childList)
            visitNode(child);
    }

    private boolean CheckIfRoboCodeMethod(String str) {
        switch (str) {
            case "ahead":
                return true;
            case "back":
                return true;
            case "fire":
                return true;
            case "doNothing":
                return true;
            case "getBattleFieldHeight":
                return true;
            case "getBattleFieldWidth":
                return true;
            case "getEnergy":
                return true;
            case "getGunHeading":
                return true;
            case "getGunHeat":
                return true;
            case "getHeading":
                return true;
            case "getHeight":
                return true;
            case "getName":
                return true;
            case "getNumRounds":
                return true;
            case "getNumSentries":
                return true;
            case "getOthers":
                return true;
            case "getRadarHeading":
                return true;
            case "getRoundNum":
                return true;
            case "getSentryBorderSize":
                return true;
            case "getTime":
                return true;
            case "getVelocity":
                return true;
            case "getWidth":
                return true;
            case "getX":
                return true;
            case "getY":
                return true;
            case "print":
                return true;
            case "resume":
                return true;
            case "scan":
                return true;
            case "setAdjustGunForRobotTurn":
                return true;
            case "setAdjustRadarForGunTurn":
                return true;
            case "setAdjustRadarForRobotTurn":
                return true;
            case "stop":
                return true;
            case "turnGunLeft":
                return true;
            case "turnGunRight":
                return true;
            case "turnLeft":
                return true;
            case "turnRight":
                return true;
            case "turnRadarLeft":
                return true;
            case "turnRadarRight":
                return true;
            case "BattleEndedEvent":
                return true;
            case "BulletHitBulletEvent":
                return true;
            case "BulletMissedEvent":
                return true;
            case "DeathEvent":
                return true;
            case "HitByBulletEvent":
                return true;
            case "HitWallEvent":
                return true;
            case "MessageEvent":
                return true;
            case "RobotDeathEvent":
                return true;
            case "RoundEndedEvent":
                return true;
            case "ScannedRobotEvent":
                return true;
            case "SkippedTurnEvent":
                return true;
            case "WinEvent":
                return true;
            default:
                return false;
        }
    }
/*
    private void RemoveRoboCodeMethods() throws Exception {
        _symbolTable.Remove("ahead");
        _symbolTable.Remove("back");
        _symbolTable.Remove("doNothing");
        _symbolTable.Remove("fire");
        _symbolTable.Remove("getBattleFieldHeight");
        _symbolTable.Remove("getBattleFieldWidth");
        _symbolTable.Remove("getEnergy");
        _symbolTable.Remove("getGunHeading");
        _symbolTable.Remove("getGunHeat");
        _symbolTable.Remove("getHeading");
        _symbolTable.Remove("getHeight");
        _symbolTable.Remove("getName");
        _symbolTable.Remove("getName");
        _symbolTable.Remove("getNumRounds");
        _symbolTable.Remove("getNumSentries");
        _symbolTable.Remove("getOthers");
        _symbolTable.Remove("getRadarHeading");
        _symbolTable.Remove("getRoundNum");
        _symbolTable.Remove("getSentryBorderSize");
        _symbolTable.Remove("getTime");
        _symbolTable.Remove("getVelocity");
        _symbolTable.Remove("getWidth");
        _symbolTable.Remove("getX");
        _symbolTable.Remove("getY");
        _symbolTable.Remove("print");
        _symbolTable.Remove("resume");
        _symbolTable.Remove("scan");
        _symbolTable.Remove("setAdjustGunForRobotTurn");
        _symbolTable.Remove("setAdjustRadarForGunTurn");
        _symbolTable.Remove("setAdjustRadarForRobotTurn");
        _symbolTable.Remove("stop");
        _symbolTable.Remove("turnGunLeft");
        _symbolTable.Remove("turnGunRight");
        _symbolTable.Remove("turnLeft");
        _symbolTable.Remove("turnRadarLeft");
        _symbolTable.Remove("turnRight");
        _symbolTable.Remove("BattleEndedEvent");
        _symbolTable.Remove("BulletHitBulletEvent");
        _symbolTable.Remove("BulletMissedEvent");
        _symbolTable.Remove("DeathEvent");
        _symbolTable.Remove("HitByBulletEvent");
        _symbolTable.Remove("HitWallEvent");
        _symbolTable.Remove("MessageEvent");
        _symbolTable.Remove("RobotDeathEvent");
        _symbolTable.Remove("RoundEndedEvent");
        _symbolTable.Remove("ScannedRobotEvent");
        _symbolTable.Remove("SkippedTurnEvent");
        _symbolTable.Remove("WinEvent");*/
}