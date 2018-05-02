package FIRe;

import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.SymbolNotFoundException;
import FIRe.Exceptions.TypeException;

import java.util.Map;

public class SetUnderScoreVisitor extends ASTVisitor {
    SymbolTable symbolTable;
    SetUnderScoreVisitor(SymbolTable table) throws Exception {
        symbolTable = table;
        try {
            RemoveRoboCodeMethods();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Error in removing Robocode functions");
        }
    }
    @Override
    public void visit(AbstractNode node, Object... arg) {

    }

    @Override
    public void visit(AdditionNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(AndNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(ArrayAccessNode node, Object... arg) throws TypeException, SymbolNotFoundException {
        if(node.Id != null)
            VisitNode(node.Id);
        if(node.index != null)
            VisitNode(node.index);
    }

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {
        if(node.Id != null)
            VisitNode(node.Id);

        if(node.Expression != null)
            VisitNode(node.Expression);
    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(BodyColorNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for(AbstractNode child : node.childList)
            VisitNode(child);
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
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws Exception {
        if(node.Id != null)
            VisitNode(node.Id);
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(EqualsNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {

    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) throws Exception {
        for(Map.Entry<IdNode, String> entry : node.parameterMap.entrySet())
            VisitNode(entry.getKey());

    }

    @Override
    public void visit(ForNode node, Object... arg) throws TypeException, ReturnException {
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) throws Exception {

        if(symbolTable.Contains(node.Id.Name)) {
            VisitNode(node.Id);

            if (node.Aparam != null)
                VisitNode(node.Aparam);
        }
    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {
        VisitNode(node.Id);
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(GEQNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(GunColorNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(IdNode node, Object... arg) throws Exception {
        node.Name = "_" + node.Name;
    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) throws Exception {
        if(node.Expression != null)
            VisitNode(node.Expression);
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(LEQNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(LessThanNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(ModuloNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(NegateNode node, Object... arg) {

    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(NotNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for(AbstractNode child : node.childList)
            VisitNode(child);

    }

    @Override
    public void visit(NumberNode node, Object... arg) {

    }

    @Override
    public void visit(OrNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(PowerNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(ProgNode node, Object... arg) throws Exception {
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(RadarColorNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) throws TypeException {
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(RoutineNode node, Object... arg) throws TypeException {
        if(node.repeatCondition != null)
            visit(node.repeatCondition);

        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {
        node.Id.Name = "_" + node.Id.Name;
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);
    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        //VisitNode(node.Id);
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(TextNode node, Object... arg) {

    }

    @Override
    public void visit(ValNode node, Object... arg) {

    }

    @Override
    public void visit(WhenNode node, Object... arg) {
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(WhileNode node, Object... arg) throws TypeException {
        VisitNode(node.Expression);
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    @Override
    public void visit(RobotNameNode node, Object... arg) {
        VisitNode(node.RobotName);
    }

    @Override
    public void visit(RobotTypeNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(RobotPropertiesNode node, Object... arg) {
        for(AbstractNode child : node.childList)
            VisitNode(child);
    }

    private void RemoveRoboCodeMethods() throws Exception {
        symbolTable.Remove("ahead");
        symbolTable.Remove("back");
        symbolTable.Remove("doNothing");
        symbolTable.Remove("fire");
        symbolTable.Remove("getBattleFieldHeight");
        symbolTable.Remove("getBattleFieldWidth");
        symbolTable.Remove("getEnergy");
        symbolTable.Remove("getGunHeading");
        symbolTable.Remove("getGunHeat");
        symbolTable.Remove("getHeading");
        symbolTable.Remove("getHeight");
        symbolTable.Remove("getName");
        symbolTable.Remove("getName");
        symbolTable.Remove("getNumRounds");
        symbolTable.Remove("getNumSentries");
        symbolTable.Remove("getOthers");
        symbolTable.Remove("getRadarHeading");
        symbolTable.Remove("getRoundNum");
        symbolTable.Remove("getSentryBorderSize");
        symbolTable.Remove("getTime");
        symbolTable.Remove("getVelocity");
        symbolTable.Remove("getWidth");
        symbolTable.Remove("getX");
        symbolTable.Remove("getY");
        symbolTable.Remove("print");
        symbolTable.Remove("resume");
        symbolTable.Remove("scan");
        symbolTable.Remove("setAdjustGunForRobotTurn");
        symbolTable.Remove("setAdjustRadarForGunTurn");
        symbolTable.Remove("setAdjustRadarForRobotTurn");
        symbolTable.Remove("stop");
        symbolTable.Remove("turnGunLeft");
        symbolTable.Remove("turnGunRight");
        symbolTable.Remove("turnLeft");
        symbolTable.Remove("turnRadarLeft");
        symbolTable.Remove("turnRight");
        symbolTable.Remove("BattleEndedEvent");
        symbolTable.Remove("BulletHitBulletEvent");
        symbolTable.Remove("BulletMissedEvent");
        symbolTable.Remove("DeathEvent");
        symbolTable.Remove("HitByBulletEvent");
        symbolTable.Remove("HitWallEvent");
        symbolTable.Remove("MessageEvent");
        symbolTable.Remove("RobotDeathEvent");
        symbolTable.Remove("RoundEndedEvent");
        symbolTable.Remove("ScannedRobotEvent");
        symbolTable.Remove("SkippedTurnEvent");
        symbolTable.Remove("WinEvent");
    }
}
