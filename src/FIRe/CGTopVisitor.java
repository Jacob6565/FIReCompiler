package FIRe;

import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.TypeException;

import java.io.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

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
                for (int i = 0; i < ids.size(); i++){
                    params += translateType(types.get(i)) + " " + ids.get(i) + ", ";
                }
            }
        }

        if (params != null)
            method= new MethodCodeHolder(node.Id.Name, node.Type, params);
        else
            method= new MethodCodeHolder(node.Id.Name, node.Type);

        //Code generation for method body

        methods.add(method);
    }

    public String translateType(String FIReType){
        switch (FIReType){
            case "bool":
                return "boolean";
            case "number":
                return "double";
            case "text":
                return "String";
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
        for (AbstractNode child : node.childList) {
            VisitNode(child);
        }
    }

    @Override
    public void visit(RobotPropertiesNode node, Object... arg) {
        String  bodyColor = null, gunColor = null, radarColor = null;
        for (AbstractNode child: node.childList) {
            if (child instanceof  RobotNameNode){
                RobotNameNode robotNameNode = (RobotNameNode) child;
                setup.name=robotNameNode.RobotName.Name;
            }
            else if(child instanceof RobotTypeNode){
                RobotTypeNode robotTypeNode = (RobotTypeNode) child;
                setup.name = robotTypeNode.RobotType.Name;
            }
            else if (child instanceof  BodyColorNode){
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
        }
        runMethod.emit(setColorBuilder(bodyColor, gunColor, radarColor), insideMethodeIndent);
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
    public void visit(RoutineNode node, Object... arg) throws TypeException {

    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {
        //Generate code equivalent java code for the strategyDecleration
        RunMethodCodeHolder RMCH = new RunMethodCodeHolder("test", "ts");
        CGStrategyVisitor CGS = new CGStrategyVisitor(RMCH);
        CGS.VisitNode(node);

        //Temporary for printing the generated code
        System.out.println(CGS.CH.sb.toString());
        runMethod.addToRunMethod("bitch","bitch();\n");

        //Add the body of what is equivalent to the when by calling addEventHandler("eventType", "body");
        //This may be done inside CSGStrategyVisitor

        //Add the body of what is equivalent to the runMethod by calling runMethod.addToRunMethod("strategyName", "body");
        //This may be done inside CSGStrategyVisitor
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

    @Override
    public void visit(RobotNameNode node, Object... arg) {

    }

    @Override
    public void visit(RobotTypeNode node, Object... arg) throws TypeException {

    }
}
