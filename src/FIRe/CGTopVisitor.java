package FIRe;

import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.TypeException;

import java.io.*;

import java.util.ArrayList;

public class CGTopVisitor extends ASTVisitor{
    SetupCodeHolder setup = new SetupCodeHolder();
    RunMethodCodeHolder runMethod = new RunMethodCodeHolder("run", "void");
    ArrayList<MethodCodeHolder> methods = new ArrayList<MethodCodeHolder>();
    ArrayList<EventCodeHolder> events = new ArrayList<EventCodeHolder>();
    //ArrayList<CodeHolder> eventHandlers = new ArrayList<CodeHolder>();

    int insideClassIndent = 1;
    int insideMethodeIndent = 1;

    //Prints the generated code from the CodeHolders into the output file
    public void emitOutputFile(){
        String code = mergeCodeHolders();
        printToFile("GeneratedCode\\GenFile.java", code);
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

    //Merges all the inputted CodeHolders and returns one single CodeHolder with one single string
    private String mergeCodeHolders(){
        StringBuilder mergedCode = new StringBuilder();


        setup.emit(runMethod.getCode(), insideClassIndent);
        for (MethodCodeHolder method: methods) {
            setup.emit(method.getCode(), insideClassIndent);
        }
        for (EventCodeHolder event: events) {
            setup.emit(event.getCode(), insideClassIndent);
        }
        mergedCode.append(setup.getCode());


        return mergedCode.toString();
    }

    private void addEventHandlerCodeHolder(ArrayList<CodeHolder> eventHandlers, CodeHolder eventHandler){
//        boolean matchFound = false;
//        for (CodeHolder codeHolder: eventHandlers) {
//            if (codeHolder.name == eventHandler.name){
//                matchFound = true;
//                codeHolder.emit(eventHandler.sb.toString());
//            }
//        }
//
//        if (!matchFound)
//            eventHandlers.add(eventHandler);
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

        //Generate actual code to put inside the condition body

        events.add(eventDcl);
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
        MethodCodeHolder method = new MethodCodeHolder(node.Id.Name, node.Type);

        //Code generation for method body

        methods.add(method);
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
    public void visit(ProgNode node, Object... arg) throws Exception {
        for (AbstractNode Node : node.childList) {
            VisitNode(Node);
        }
    }


    @Override
    public void visit(RadarColorNode node, Object... arg) {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) {

    }

    private String setColorBuilder(String bodyColor, String gunColor, String radarColor){
        //If any of the colors are null, then they will correctly insert null in the string, which is valid for the java
        //function SetColors
        return "SetColors(" + bodyColor + ", " + gunColor + ", " + radarColor +");";
    }

    @Override
    public void visit(RobotDclBodyNode node, Object... arg) {
        setup.name=node.robotName;
        setup.robotType=node.robotType;
        String  bodyColor = null, gunColor = null, radarColor = null;
        for (AbstractNode abstractNode: node.childList) {
            if (abstractNode instanceof  BodyColorNode){
                BodyColorNode temp = (BodyColorNode) abstractNode;
                bodyColor = temp.Color.Color;
            }
            else if(abstractNode instanceof GunColorNode){
                GunColorNode temp = (GunColorNode) abstractNode;
                gunColor = temp.Color.Color;
            }
            else if(abstractNode instanceof  RadarColorNode){
                RadarColorNode temp = (RadarColorNode) abstractNode;
                radarColor = temp.Color.Color;
            }
        }
        runMethod.emit(setColorBuilder(bodyColor, gunColor, radarColor), insideClassIndent + insideMethodeIndent);
    }

    @Override
    public void visit(RoutineNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {
        CGExpressionVisitor CGE = new CGExpressionVisitor();
        CGStrategyVisitor CGS = new CGStrategyVisitor();
        CGS.VisitNode(node);
        System.out.println(CGS.CH.sb.toString());
        //Generate code equivalent java code for the strategyDecleration

        //Add the body of what is equivalent to the when by calling addEventHandler("eventType", "body");

        //Add the body of what is equivalent to the runMethod by calling runMethod.addToRunMethod("strategyName", "body");
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

    }

    @Override
    public void visit(WhileNode node, Object... arg) throws TypeException {

    }
}
