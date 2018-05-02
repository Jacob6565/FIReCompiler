package FIRe;

import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.TypeException;

import java.io.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class CGTopVisitor extends ASTVisitor{
    CGTopVisitor(SymbolTable symbolTable){
        bodyVisitor = new CGFunctionVisitor(symbolTable);
    }
    ProgCodeHolder progCode = new ProgCodeHolder();

    int blockIndent = 1;

    CGFunctionVisitor bodyVisitor;

    //Prints the generated code from the CodeHolders into the output file
    public void emitOutputFile(){
        String code = progCode.getCode();
        //This fileName should be the same as the class name/robot name
        printToFile("GeneratedCode\\" + progCode.setup.name + ".java", code);
    }

    //Creates the output file and writes the code in it
    private void printToFile(String fileName, String contents){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"))) {
            writer.write(contents);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
    public void visit(ArrayAccessNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BodyColorNode node, Object... arg) {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {
        progCode.setup.emit(bodyVisitor.GenerateBodyCode(node), blockIndent);
    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {
        progCode.setup.emit(bodyVisitor.GenerateBodyCode(node), blockIndent);
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

    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws Exception {
        EventCodeHolder eventDcl = new EventCodeHolder(node.Id.Name);

        String test = bodyVisitor.GenerateBodyCode(node);
        //Code generation for eventDcl body
        eventDcl.emit(test, blockIndent);

        progCode.runMethod.addConditionDeclaration(eventDcl.getCode());
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

        MethodCodeHolder method;
        String params = null;
        ArrayList<String> ids = new ArrayList<String>();
        ArrayList<String> types = new ArrayList<String>();

        //Creates the string for the parameters of a method
        for (AbstractNode child: node.childList) {
            if (child instanceof FormalParameterNode){
                params = "";
                FormalParameterNode fparam = (FormalParameterNode) child;
                Set<IdNode> idNodeSet = fparam.parameterMap.keySet();
                Collection<String> typeCollection = fparam.parameterMap.values();

                for (Iterator<IdNode> it = idNodeSet.iterator(); it.hasNext();){
                    ids.add(it.next().Name);
                }

                for (Iterator<String> it = typeCollection.iterator(); it.hasNext();){
                    types.add(it.next());
                }

                //We can do this as we know that set size and collection size is equal
                boolean firstParam = true;
                for (int i = 0; i < ids.size(); i++){
                    if (firstParam){
                        params += translateType(types.get(i)) + " " + ids.get(i);
                        firstParam = false;
                    }
                    else
                        params += ", " + translateType(types.get(i)) + " " + ids.get(i);
                }
            }
        }

        if (params != null)
            method= new MethodCodeHolder(node.Id.Name, translateType(node.Type), params);
        else
            method= new MethodCodeHolder(node.Id.Name, translateType(node.Type));

        //Code generation for method body
        method.emit(bodyVisitor.GenerateBodyCode(node), blockIndent);

        progCode.methods.add(method);
    }

    public String translateType(String FIReType){
        switch (FIReType){
            case "bool":
                return "boolean";
            case "number":
                return "double";
            case "text":
                return "String";
            case "void":
                return "void";
            default:
                return null;
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
        progCode.setup.emit(bodyVisitor.GenerateBodyCode(node), blockIndent);
    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {
        progCode.setup.emit(bodyVisitor.GenerateBodyCode(node), blockIndent);
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
    public void visit(ProgNode node, Object... arg) throws Exception {
        for (AbstractNode child : node.childList) {
            visitNode(child);
        }
    }

    @Override
    public void visit(RobotPropertiesNode node, Object... arg) {
        String  bodyColor = null, gunColor = null, radarColor = null;
        for (AbstractNode child: node.childList) {
            if (child instanceof  BodyColorNode){
                BodyColorNode temp = (BodyColorNode) child;
                bodyColor = temp.Color.Color;
            }
            else if(child instanceof GunColorNode){
                GunColorNode temp = (GunColorNode) child;
                gunColor = temp.Color.Color;
            }
            else if(child instanceof  RadarColorNode){
                RadarColorNode temp = (RadarColorNode) child;
                radarColor = temp.Color.Color;
            }
            else
                visitNode(child);
        }
        progCode.runMethod.emit(setColorBuilder(bodyColor, gunColor, radarColor), blockIndent);
    }

    //Help method that constructs the generates the Java setColorBuilder with its' color inputs
    private String setColorBuilder(String bodyColor, String gunColor, String radarColor){
        //If any of the colors are null, then they will correctly insert null in the string, which is valid for the
        // robocode java function SetColors
        return "setColors(" + bodyColor + ", " + gunColor + ", " + radarColor +");";
    }

    @Override
    public void visit(RadarColorNode node, Object... arg) {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) {

    }

    @Override
    public void visit(RoutineNode node, Object... arg) throws TypeException {

        //Parent way : WhenNode -> StrategyDcl
        StrategyDeclarationNode parentStrategy = (StrategyDeclarationNode) node.Parent;
        String strategyName = parentStrategy.Id.Name;

        progCode.runMethod.addToRunMethod(strategyName, bodyVisitor.GenerateBodyCode(node));
    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {

        //Visit the routine and whens of the strategy in this class so their codeHandlers can be prepared
        for (AbstractNode child : node.childList) {
            if ((child instanceof RoutineNode) || (child instanceof WhenNode))
                 visitNode(child);
        }
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {
        progCode.setup.emit(bodyVisitor.GenerateBodyCode(node), blockIndent);
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {
        progCode.setup.emit(bodyVisitor.GenerateBodyCode(node), blockIndent);
    }

    @Override
    public void visit(TextNode node, Object... arg) {

    }

    @Override
    public void visit(ValNode node, Object... arg) {

    }

    @Override
    public void visit(WhenNode node, Object... arg) {
        IdNode eventTypeNode = (IdNode) node.childList.get(0);
        String eventType = eventTypeNode.Name;

        //Parent way : WhenNode -> StrategyDcl
        StrategyDeclarationNode parentStrategy = (StrategyDeclarationNode) node.Parent;
        String strategyName = parentStrategy.Id.Name;

        //This case is for whens handling robocode events
        if(isThisOfficialEvent(eventType)){
            IdNode paramId = (IdNode)node.childList.get(1);

            //ScannedRobotEvent will become ScannedRobot, a when can only have one parameter /KRISTOFFER
            String[] str = eventType.split("Event");
            String fparam = eventType + " " + paramId.Name;

            //Generates an entirely eventHandler "shell" if it does not already exist
            EventHandlerCodeHolder eventHandler = progCode.addEventHandler("on" + str[0], fparam);

            // Adds the strategy specific eventhandler as a case in the switch of the generated eventhandler
            eventHandler.addCase(strategyName, bodyVisitor.GenerateBodyCode(node));
        }
        //This case is for whens handling custom events /KRISTOFFER
        else {
            //Generates an entirely eventHandler "shell" if it does not already exist
            CustomEventHandlerCodeHolder customEventHandler = progCode.addCustomEventHandler ("onCustomEvent",
                    "CustomEvent _e");
            // Adds the strategy specific eventhandler as a case in the switch of the generated eventhandler
            customEventHandler.addCase(eventType, strategyName, bodyVisitor.GenerateBodyCode(node));
        }
    }

    //Help function for visiting a whenNode, the different Event could effectively be excluded to be in something like a file
    //as FESVisitor also uses this list of names
    public boolean isThisOfficialEvent(String event){
        switch (event){
            case "BattleEndedEvent":
            case "BulletHitBulletEvent":
            case "BulletHitEvent":
            case "BulletMissedEvent":
            case "DeathEvent":
            case "HitByBulletEvent":
            case "HitRobotEvent":
            case "HitWallEvent":
            case "MessageEvent":
            case "RobotDeathEvent":
            case "RoundEndedEvent":
            case "ScannedRobotEvent":
            case "SkippedTurnEvent":
            case "WinEvent":
                return  true;
            default:
                return false;
        }
    }

    @Override
    public void visit(WhileNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(RobotNameNode node, Object... arg) {
        progCode.setup.name=node.RobotName.Name;
    }

    @Override
    public void visit(RobotTypeNode node, Object... arg) throws TypeException { progCode.setup.robotType = node.RobotType.Name; }
}