package FIRe;

import FIRe.ContextualAnalysis.RobotHeaderTable;
import FIRe.ContextualAnalysis.ScopeTypeCheckVisitor;
import FIRe.ContextualAnalysis.SymbolData;
import FIRe.ContextualAnalysis.SymbolTable;
import FIRe.Exceptions.AntlrException;
import FIRe.Exceptions.TypeException;
import FIRe.Nodes.*;
import FIRe.Parser.CFGBaseVisitor;
import FIRe.Parser.CFGLexer;
import FIRe.Parser.CFGParser;
import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.nashorn.internal.ir.IfNode;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;
import org.testng.Assert;
import sun.security.krb5.SCDynamicStoreConfig;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Base64;
import java.util.Scanner;

import static org.junit.Assert.*;


public class ScopeTypeCheckVisitorTest{


    BuildASTVisitor BASTV = new BuildASTVisitor();
    CFGParser.ProgContext cst = ContextPrep();
    SymbolTable ST = new SymbolTable();
    RobotHeaderTable RHT = new RobotHeaderTable();
    ScopeTypeCheckVisitor STCV = new ScopeTypeCheckVisitor(ST, RHT);

    @Test
    public void visitProgTest() {
        AbstractNode node = BASTV.visitProg(cst);
        if (node.childList.size() == 4) {
            if (node.childList.get(0) instanceof RobotPropertiesNode && node.childList.get(1) instanceof StrategyDeclarationNode &&
                    node.childList.get(2) instanceof FunctionDeclarationNode && node.childList.get(3) instanceof EventDeclarationNode) {
                assert true;
            }
            else
                assert false;
        }
        else
            assert false;
    }

    @Test
    public void testAddition(){
        AdditionNode node = new AdditionNode();
        node.LeftChild = new NumberNode(0);
        node.RightChild = new NumberNode(2);
        try {
            STCV.visit(node);
            assertEquals("number", node.type);
        }
        catch (TypeException x){
            assert false;
        }
    }

    @Test
    public void TestAddition2(){
        AdditionNode node = new AdditionNode();
        node.LeftChild = new TextNode();
        node.RightChild = new TextNode();
        try{
            STCV.visit(node);
            assertEquals("text",node.type);
        }
        catch (TypeException x){
            assert false;
        }
    }

    @Test
    public void TestAddition3(){
        AdditionNode node = new AdditionNode();
        node.RightChild = new BoolNode(true);
        node.LeftChild = new NumberNode(2);
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestAddition4(){
        AdditionNode node = new AdditionNode();
        node.LeftChild = new BoolNode(true);
        node.RightChild = new BoolNode(true);
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }


    @Test
    public void TestIfWithNumber()
    {
        IfControlStructureNode ifNode = new IfControlStructureNode();
        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;
        ifNode.childList.add(numberNode);
        ifNode.childList.add(new BlockNode());

        try
        {
            STCV.visit(ifNode);
            assert false;
        }
        catch (TypeException e)
        {
            assert true;
        }
    }
    @Test
    public void TestIfWithText()
    {
        IfControlStructureNode ifNode = new IfControlStructureNode();
        TextNode textNode = new TextNode();
        textNode.Content = "RandomString";
        ifNode.childList.add(textNode);
        ifNode.childList.add(new BlockNode());

        try
        {
            STCV.visit(ifNode);
            assert false;
        }
        catch (TypeException e)
        {
            assert true;
        }
    }

    @Test
    public void TestIfWithBool()
    {
        IfControlStructureNode ifNode = new IfControlStructureNode();
        BoolNode boolNode = new BoolNode(true);
        ifNode.childList.add(boolNode);
        ifNode.childList.add(new BlockNode());

        try
        {
            STCV.visit(ifNode);
            assert true;
        }
        catch (TypeException e)
        {
            assert false;
        }
    }


    @Test
    public void TestWhileWithNumber()
    {
        WhileNode whileNode = new WhileNode();
        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;
        whileNode.childList.add(numberNode);
        whileNode.Expression = numberNode;
        whileNode.childList.add(new BlockNode());

        try
        {
            STCV.visit(whileNode);
            assert false;
        }
        catch (TypeException e)
        {
            assert true;
        }
    }
    @Test
    public void TestWhileWithText()
    {
        WhileNode whileNode = new WhileNode();
        TextNode textNode = new TextNode();
        textNode.Content = "RandomString";
        whileNode.childList.add(whileNode);
        whileNode.Expression = textNode;
        whileNode.childList.add(new BlockNode());

        try
        {
            STCV.visit(whileNode);
            assert false;
        }
        catch (TypeException e)
        {
            assert true;
        }
    }

    @Test
    public void TestWhileWithBool()
    {
        WhileNode whileNode = new WhileNode();
        BoolNode boolNode = new BoolNode(true);
        whileNode.childList.add(boolNode);
        whileNode.Expression = boolNode;
        whileNode.childList.add(new BlockNode());

        try
        {
            STCV.visit(whileNode);
            assert true;
        }
        catch (TypeException e)
        {
            assert false;
        }
    }


    @Test
    public void TestForWithNumberDeclaration()
    {
        ForNode forNode = new ForNode();
        NumberDeclarationNode numberDeclarationNode = new NumberDeclarationNode();
        IdNode idNode = new IdNode();
        idNode.type = "number";
        idNode.Name = "n";
        numberDeclarationNode.Id = idNode;
        numberDeclarationNode.childList.add(idNode);
        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;
        numberDeclarationNode.childList.add(numberNode);
        forNode.Dcl = numberDeclarationNode;
        forNode.To = numberNode;
        try
        {
            STCV.visit(forNode);
            assert true;
        }
        catch (TypeException e)
        {
            assert false;
        }

    }
    @Test
    public void TestForWithTextDeclaration()
    {
        ForNode forNode = new ForNode();
        TextDeclarationNode textDeclarationNode = new TextDeclarationNode();
        IdNode idNode = new IdNode();
        idNode.type = "text";
        idNode.Name = "n";
        textDeclarationNode.Id = idNode;
        textDeclarationNode.childList.add(idNode);
        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;
        textDeclarationNode.childList.add(numberNode);
        //forNode.Dcl = textDeclarationNode;
        forNode.To = numberNode;
        try
        {
            STCV.visit(forNode);
            assert false;
        }
        catch (TypeException e)
        {
            assert true;
        }
    }

    @Test
    public void TestForWithBoolDeclaration()
    {
        ForNode forNode = new ForNode();
        BooleanDeclarationNode booleanDeclarationNode = new BooleanDeclarationNode();
        IdNode idNode = new IdNode();
        idNode.type = "bool";
        idNode.Name = "n";
        booleanDeclarationNode.Id = idNode;
        booleanDeclarationNode.childList.add(idNode);
        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;
        booleanDeclarationNode.childList.add(numberNode);
       // forNode.Dcl = booleanDeclarationNode;
        forNode.To = numberNode;
        try
        {
            STCV.visit(forNode);
            assert false;
        }
        catch (TypeException e)
        {
            assert true;
        }
    }

    @Test
    public void TestForWithBool()
    {
        ForNode forNode = new ForNode();
        BoolNode boolNode = new BoolNode(true);
        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;
        forNode.From = boolNode;
        forNode.To = numberNode;
        forNode.childList.add(boolNode);
        forNode.childList.add(numberNode);
        try
        {
            STCV.visit(forNode);
            assert false;
        }
        catch (TypeException e)
        {
            assert true;
        }
    }

    @Test
    public void TestForWithNumber()
    {
        ForNode forNode = new ForNode();
        NumberNode numberNode = new NumberNode();
        numberNode.value = 1;
        NumberNode numberNode1 = new NumberNode();
        numberNode1.value = 2;
        forNode.From = numberNode;
        forNode.To = numberNode1;
        forNode.childList.add(numberNode);
        forNode.childList.add(numberNode1);
        try
        {
            STCV.visit(forNode);
            assert true;
        }
        catch (TypeException e)
        {
            assert false;
        }
    }


    @Test
    public void TestForWithText()
    {
        ForNode forNode = new ForNode();
        TextNode textNode = new TextNode();
        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;
        textNode.Content = "String";
        forNode.From = textNode;
        forNode.To = numberNode;
        forNode.childList.add(textNode);
        forNode.childList.add(numberNode);
        try
        {
            STCV.visit(forNode);
            assert false;
        }
        catch (TypeException e)
        {
            assert true;
        }
    }

    @Test
    public void TestRoutineWithNumber()
    {

        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;
        BlockNode blockNode = new BlockNode();
        RoutineNode routineNode = new RoutineNode(numberNode, blockNode, 0);

        try
        {
            STCV.visit(routineNode);
            assert true;
        }
        catch (TypeException e)
        {
            assert false;
        }
    }

    @Test
    public void TestRoutineWithNothing()
    {

        BlockNode blockNode = new BlockNode();
        RoutineNode routineNode = new RoutineNode(blockNode, 0);

        try
        {
            STCV.visit(routineNode);
            assert true;
        }
        catch (TypeException e)
        {
            assert false;
        }
    }
    @Test
    public void TestRoutineWithBool()
    {

        BoolNode boolNode = new BoolNode(true);
        BlockNode blockNode = new BlockNode();
        RoutineNode routineNode = new RoutineNode(boolNode, blockNode, 0);

        try
        {
            STCV.visit(routineNode);
            assert false;
        }
        catch (TypeException e)
        {
            assert true;
        }
    }
    @Test
    public void TestRoutineWithText()
    {

        TextNode textNode = new TextNode();
        textNode.Content = "String";
        BlockNode blockNode = new BlockNode();
        RoutineNode routineNode = new RoutineNode(textNode, blockNode, 0);

        try
        {
            STCV.visit(routineNode);
            assert false;
        }
        catch (TypeException e)
        {
            assert true;
        }
    }

    @Test
    public void TestNumberDeclaration()
    {
        NumberDeclarationNode numberDeclarationNode = new NumberDeclarationNode();
        IdNode idNode = new IdNode();
        idNode.type = "number";
        idNode.Name = "n";
        numberDeclarationNode.Id = idNode;
        numberDeclarationNode.childList.add(idNode);
        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;
        numberDeclarationNode.childList.add(numberNode);
        SymbolData data = null;
        try
        {
            STCV.visit(numberDeclarationNode);
            data = ST.Search(numberDeclarationNode.Id.Name);
            assertEquals(numberDeclarationNode.Id.type, data.type);
        }
        catch (Exception e)
        {
            assert false;
        }


    }
    @Test
    public void TestTextDeclaration()
    {
        TextDeclarationNode textDeclarationNode = new TextDeclarationNode();
        IdNode idNode = new IdNode();
        idNode.type = "text";
        idNode.Name = "n";
        textDeclarationNode.Id = idNode;
        textDeclarationNode.childList.add(idNode);
        TextNode textNode = new TextNode();
        textNode.Content = "String";
        textDeclarationNode.childList.add(textNode);
        SymbolData data = null;
        try
        {
            STCV.visit(textDeclarationNode);
            data = ST.Search(textDeclarationNode.Id.Name);
            assertEquals(textDeclarationNode.Id.type, data.type);
        }
        catch (Exception e)
        {
            assert false;
        }
    }

    @Test
    public void TestBoolDeclaration()
    {
        BooleanDeclarationNode booleanDeclarationNode = new BooleanDeclarationNode();
        IdNode idNode = new IdNode();
        idNode.type = "bool";
        idNode.Name = "n";
        booleanDeclarationNode.Id = idNode;
        booleanDeclarationNode.childList.add(idNode);
        BoolNode boolNode = new BoolNode(true);
        booleanDeclarationNode.childList.add(boolNode);
        SymbolData data = null;
        try
        {
            STCV.visit(booleanDeclarationNode);
            data = ST.Search(booleanDeclarationNode.Id.Name);
            assertEquals(booleanDeclarationNode.Id.type, data.type);
        }
        catch (Exception e)
        {
            assert false;
        }
    }


    @Test
    public void visitStrategyDcl() {

    }

    @org.junit.Test
    public void visitStrategyBlock() {
    }

    @org.junit.Test
    public void visitFuncDcl() {
    }

    @org.junit.Test
    public void visitBlock() {
    }

    @org.junit.Test
    public void visitBlockBody() {
    }

    @org.junit.Test
    public void visitFParamList() {
    }

    @org.junit.Test
    public void visitRobotDcl() {
    }

    @org.junit.Test
    public void visitDcl() {
    }

    @org.junit.Test
    public void visitStmt() {
    }

    @org.junit.Test
    public void visitRoutine() {
    }

    @org.junit.Test
    public void visitWhen() {
    }

    @org.junit.Test
    public void visitExpr() {
    }

    @org.junit.Test
    public void visitAssignStmt() {
    }

    @org.junit.Test
    public void visitFuncCall() {
    }

    @org.junit.Test
    public void visitEventDcl() {
    }

    @org.junit.Test
    public void visitAParamList() {
    }

    @org.junit.Test
    public void visitCtrlStruct() {
    }

    @org.junit.Test
    public void visitAif() {
    }

    @org.junit.Test
    public void visitId() {
    }

    public CFGParser.ProgContext ContextPrep(){

        //Reads from the example program. (Debug code)
        Scanner in = null;
        try {
            in = new Scanner(new FileReader("src\\FIRe\\Kodeeksempler\\TestEksempel.txt"));
        } catch (FileNotFoundException e) {
        }

        //We use this delimiter, to chop the code into bits. We split by the backslash character "\n"
        in.useDelimiter("\n");

        //Creates a StringBuilder from the given code file.
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            sb.append(in.next() + "\n");
        }

        CFGParser.ProgContext cst = null;

        //We append $ because this is the terminal symbol of the program.
        sb.append("$");
        in.close();

        //Converts the StringBuilder to a string.
        String outString = sb.toString();

        //https://stackoverflow.com/questions/18110180/processing-a-string-with-antlr4
        //Setup to perform lexical analysis on the input string.
        CFGLexer lexer = new CFGLexer(CharStreams.fromString(outString));
        lexer.removeErrorListeners();
        lexer.addErrorListener(AntlrException.INSTANCE);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(AntlrException.INSTANCE);
        //Performs lexical analysis and builds a CST.
        cst = parser.prog();
        //cst.children.add(parser.dcl());

      return cst;
    }
}

