package FIRe;

import FIRe.ContextualAnalysis.RobotHeaderTable;
import FIRe.ContextualAnalysis.ScopeTypeCheckVisitor;
import FIRe.ContextualAnalysis.SymbolTable;
import FIRe.Exceptions.AntlrException;
import FIRe.Exceptions.TypeException;
import FIRe.Nodes.*;
import FIRe.Parser.CFGBaseVisitor;
import FIRe.Parser.CFGLexer;
import FIRe.Parser.CFGParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;
import org.testng.Assert;

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
    public void TestAddition5(){
        AdditionNode node = new AdditionNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestAddition6(){
        AdditionNode node = new AdditionNode();
        node.RightChild = new TextNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestAddition7(){
        AdditionNode node = new AdditionNode();
        node.RightChild = new TextNode();
        node.LeftChild = new NumberNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestAddition8(){
        AdditionNode node = new AdditionNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new TextNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestAddition9(){
        AdditionNode node = new AdditionNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new TextNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestAnd1(){
        AndNode node = new AndNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert true;
        }
        catch (TypeException x){
            assert false;
        }
    }

    @Test
    public void TestAnd2(){
        AndNode node = new AndNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestAnd3(){
        AndNode node = new AndNode();
        node.RightChild = new TextNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestAnd4(){
        AndNode node = new AndNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new NumberNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestAnd5(){
        AndNode node = new AndNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new NumberNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestAnd6(){
        AndNode node = new AndNode();
        node.RightChild = new TextNode();
        node.LeftChild = new NumberNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestAnd7(){
        AndNode node = new AndNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new TextNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }
    @Test
    public void TestAnd8(){
        AndNode node = new AndNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new TextNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }
    @Test
    public void TestAnd9(){
        AndNode node = new AndNode();
        node.RightChild = new TextNode();
        node.LeftChild = new TextNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestBool(){
        BoolNode node = new BoolNode();
        STCV.visit(node);
        assertEquals("bool",node.type);
    }

    @Test
    public void TestDivision1(){
        DivisionNode node = new DivisionNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestDivision2(){
        DivisionNode node = new DivisionNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }
    @Test
    public void TestDivision3(){
        DivisionNode node = new DivisionNode();
        node.RightChild = new TextNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }
    @Test
    public void TestDivision4(){
        DivisionNode node = new DivisionNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new NumberNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestDivision5(){
        DivisionNode node = new DivisionNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new NumberNode();
        try{
            STCV.visit(node);
            assert true;
        }
        catch (TypeException x){
            assert false;
        }
    }
    @Test
    public void TestDivision6(){
        DivisionNode node = new DivisionNode();
        node.RightChild = new TextNode();
        node.LeftChild = new NumberNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestDivision7(){
        DivisionNode node = new DivisionNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new TextNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestDivision8(){
        DivisionNode node = new DivisionNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestDivision9(){
        DivisionNode node = new DivisionNode();
        node.RightChild = new TextNode();
        node.LeftChild = new TextNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestEquals1(){
        EqualsNode node = new EqualsNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert true;
        }
        catch (TypeException x){
            assert false;
        }
    }


    @Test
    public void TestEquals2(){
        EqualsNode node = new EqualsNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }


    @Test
    public void TestEquals3(){
        EqualsNode node = new EqualsNode();
        node.RightChild = new TextNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestEquals4(){
        EqualsNode node = new EqualsNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new NumberNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestEquals5(){
        EqualsNode node = new EqualsNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new NumberNode();
        try{
            STCV.visit(node);
            assert true;
        }
        catch (TypeException x){
            assert false;
        }
    }

    @Test
    public void TestEquals6(){
        EqualsNode node = new EqualsNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new TextNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestEquals7(){
        EqualsNode node = new EqualsNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new TextNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }
    @Test
    public void TestEquals8(){
        EqualsNode node = new EqualsNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new TextNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }
    @Test
    public void TestEquals9(){
        EqualsNode node = new EqualsNode();
        node.RightChild = new TextNode();
        node.LeftChild = new TextNode();
        try{
            STCV.visit(node);
            assert true;
        }
        catch (TypeException x){
            assert false;
        }
    }

    @Test
    public void TestGEQ1(){
        GEQNode node = new GEQNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestGEQ2(){
        GEQNode node = new GEQNode();
        node.RightChild = new NumberNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestGEQ3(){
        GEQNode node = new GEQNode();
        node.RightChild = new TextNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }


    @Test
    public void TestGEQ4(){
        GEQNode node = new GEQNode();
        node.RightChild = new BoolNode();
        node.LeftChild = new BoolNode();
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
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

