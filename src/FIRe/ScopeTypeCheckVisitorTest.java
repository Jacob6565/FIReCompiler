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
            assertEquals(Main.NUMBER, node.type);
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
            assertEquals(Main.TEXT,node.type);
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
        whileNode.childList.add(textNode);
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
        idNode.type = Main.NUMBER;
        idNode.Name = "n";
        numberDeclarationNode.Id = idNode;
        numberDeclarationNode.childList.add(idNode);
        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;
        numberDeclarationNode.childList.add(numberNode);
        forNode.Dcl = numberDeclarationNode;
        forNode.To = numberNode;
        forNode.childList.add(numberDeclarationNode);
        forNode.childList.add(numberNode);

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
        idNode.type = Main.TEXT;
        idNode.Name = "n";

        textDeclarationNode.Id = idNode;
        textDeclarationNode.childList.add(idNode);

        TextNode textNode = new TextNode();
        textNode.Content = "String";

        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;

        textDeclarationNode.childList.add(textNode);

        forNode.Dcl = textDeclarationNode;
        forNode.To = numberNode;

        forNode.childList.add(textDeclarationNode);
        forNode.childList.add(numberNode);
        BlockNode blockNode = new BlockNode();
        blockNode.Parent = forNode;
        forNode.childList.add(blockNode);
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
        idNode.type = Main.BOOL;
        idNode.Name = "n";
        booleanDeclarationNode.Id = idNode;
        booleanDeclarationNode.childList.add(idNode);
        BoolNode boolNode = new BoolNode(true);
        booleanDeclarationNode.childList.add(boolNode);
        NumberNode numberNode = new NumberNode();
        numberNode.value = 2;
        forNode.Dcl = booleanDeclarationNode;
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
        idNode.type = Main.NUMBER;
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
        idNode.type = Main.TEXT;
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
        idNode.type = Main.BOOL;
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
        assertEquals(Main.BOOL,node.type);
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
    public void TestGEQ5(){
        GEQNode node = new GEQNode();
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
    public void TestGEQ6(){
        GEQNode node = new GEQNode();
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
    public void TestGEQ7(){
        GEQNode node = new GEQNode();
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
    public void TestGEQ8(){
        GEQNode node = new GEQNode();
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
    public void TestGEQ9(){
        GEQNode node = new GEQNode();
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
    public void TestGreater1(){
        GreaterThanNode node = new GreaterThanNode();
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
    public void TestGreater2(){
        GreaterThanNode node = new GreaterThanNode();
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
    public void TestGreater3(){
        GreaterThanNode node = new GreaterThanNode();
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
    public void TestGreater4(){
        GreaterThanNode node = new GreaterThanNode();
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
    public void TestGreater5(){
        GreaterThanNode node = new GreaterThanNode();
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
    public void TestGreater6(){
        GreaterThanNode node = new GreaterThanNode();
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
    public void TestGreater7(){
        GreaterThanNode node = new GreaterThanNode();
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
    public void TestGreater8(){
        GreaterThanNode node = new GreaterThanNode();
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
    public void TestGreater9(){
        GreaterThanNode node = new GreaterThanNode();
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
    public void TestLEQ1(){
        LEQNode node = new LEQNode();
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
    public void TestLEQ2(){
        LEQNode node = new LEQNode();
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
    public void TestLEQ3(){
        LEQNode node = new LEQNode();
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
    public void TestLEQ4(){
        LEQNode node = new LEQNode();
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
    public void TestLEQ5(){
        LEQNode node = new LEQNode();
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
    public void TestLEQ6(){
        LEQNode node = new LEQNode();
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
    public void TestLEQ7(){
        LEQNode node = new LEQNode();
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
    public void TestLEQ8(){
        LEQNode node = new LEQNode();
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
    public void TestLEQ9(){
        LEQNode node = new LEQNode();
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
    public void TestLess1(){
        LessThanNode node = new LessThanNode();
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
    public void TestLess2(){
        LessThanNode node = new LessThanNode();
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
    public void TestLess3(){
        LessThanNode node = new LessThanNode();
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
    public void TestLess4(){
        LessThanNode node = new LessThanNode();
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
    public void TestLess5(){
        LessThanNode node = new LessThanNode();
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
    public void TestLess6(){
        LessThanNode node = new LessThanNode();
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
    public void TestLess7(){
        LessThanNode node = new LessThanNode();
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
    public void TestLess8(){
        LessThanNode node = new LessThanNode();
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
    public void TestLess9(){
        LessThanNode node = new LessThanNode();
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
    public void TestModulo1(){
        ModuloNode node = new ModuloNode();
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
    public void TestModulo2(){
        ModuloNode node = new ModuloNode();
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
    public void TestModulo3(){
        ModuloNode node = new ModuloNode();
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
    public void TestModulo4(){
        ModuloNode node = new ModuloNode();
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
    public void TestModulo5(){
        ModuloNode node = new ModuloNode();
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
    public void TestModulo6(){
        ModuloNode node = new ModuloNode();
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
    public void TestModulo7(){
        ModuloNode node = new ModuloNode();
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
    public void TestModulo8(){
        ModuloNode node = new ModuloNode();
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
    public void TestModulo9(){
        ModuloNode node = new ModuloNode();
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
    public void TestMultiplication1(){
        MultiplicationNode node = new MultiplicationNode();
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
    public void TestMultiplication2(){
        MultiplicationNode node = new MultiplicationNode();
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
    public void TestMultiplication3(){
        MultiplicationNode node = new MultiplicationNode();
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
    public void TestMultiplication4(){
        MultiplicationNode node = new MultiplicationNode();
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
    public void TestMultiplication5(){
        MultiplicationNode node = new MultiplicationNode();
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
    public void TestMultiplication6(){
        MultiplicationNode node = new MultiplicationNode();
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
    public void TestMultiplication7(){
        MultiplicationNode node = new MultiplicationNode();
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
    public void TestMultiplication8(){
        MultiplicationNode node = new MultiplicationNode();
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
    public void TestMultiplication9(){
        MultiplicationNode node = new MultiplicationNode();
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
    public void TestNot1(){
        NotNode node = new NotNode();
        node.Expression = new BoolNode();
        try{
            STCV.visit(node);
            assert true;
        }
        catch (TypeException x){
            assert false;
        }
    }

    @Test
    public void TestNot2(){
        NotNode node = new NotNode();
        node.Expression = new NumberNode();
        node.childList.add(node.Expression);
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestNot3(){
        NotNode node = new NotNode();
        node.Expression = new TextNode();
        node.childList.add(node.Expression);
        try{
            STCV.visit(node);
            assert false;
        }
        catch (TypeException x){
            assert true;
        }
    }

    @Test
    public void TestNotEquals1(){
        NotEqualsNode node = new NotEqualsNode();
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
    public void TestNotEquals2(){
        NotEqualsNode node = new NotEqualsNode();
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
    public void TestNotEquals3(){
        NotEqualsNode node = new NotEqualsNode();
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
    public void TestNotEquals4(){
        NotEqualsNode node = new NotEqualsNode();
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
    public void TestNotEquals5(){
        NotEqualsNode node = new NotEqualsNode();
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
    public void TestNotEquals6(){
        NotEqualsNode node = new NotEqualsNode();
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
    public void TestNotEquals7(){
        NotEqualsNode node = new NotEqualsNode();
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
    public void TestNotEquals8(){
        NotEqualsNode node = new NotEqualsNode();
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
    public void TestNotEquals9(){
        NotEqualsNode node = new NotEqualsNode();
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
    public void TestNumber(){
        NumberNode node = new NumberNode();
        STCV.visit(node);
        assertEquals(Main.NUMBER,node.type);
    }
    @Test
    public void TestOr1(){
        OrNode node = new OrNode();
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
    public void TestOr2(){
        OrNode node = new OrNode();
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
    public void TestOr3(){
        OrNode node = new OrNode();
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
    public void TestOr4(){
        OrNode node = new OrNode();
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
    public void TestOr5(){
        OrNode node = new OrNode();
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
    public void TestOr6(){
        OrNode node = new OrNode();
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
    public void TestOr7(){
        OrNode node = new OrNode();
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
    public void TestOr8(){
        OrNode node = new OrNode();
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
    public void TestOr9(){
        OrNode node = new OrNode();
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
    public void TestPower1(){
        PowerNode node = new PowerNode();
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
    public void TestPower2(){
        PowerNode node = new PowerNode();
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
    public void TestPower3(){
        PowerNode node = new PowerNode();
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
    public void TestPower4(){
        PowerNode node = new PowerNode();
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
    public void TestPower5(){
        PowerNode node = new PowerNode();
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
    public void TestPower6(){
        PowerNode node = new PowerNode();
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
    public void TestPower7(){
        PowerNode node = new PowerNode();
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
    public void TestPower8(){
        PowerNode node = new PowerNode();
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
    public void TestPower9(){
        PowerNode node = new PowerNode();
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
    public void TestSubtraction1(){
        SubtractionNode node = new SubtractionNode();
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
    public void TestSubtraction2(){
        SubtractionNode node = new SubtractionNode();
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
    public void TestSubtraction3(){
        SubtractionNode node = new SubtractionNode();
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
    public void TestSubtraction4(){
        SubtractionNode node = new SubtractionNode();
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
    public void TestSubtraction5(){
        SubtractionNode node = new SubtractionNode();
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
    public void TestSubtraction6(){
        SubtractionNode node = new SubtractionNode();
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
    public void TestSubtraction7(){
        SubtractionNode node = new SubtractionNode();
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
    public void TestSubtraction8(){
        SubtractionNode node = new SubtractionNode();
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
    public void TestSubtraction9(){
        SubtractionNode node = new SubtractionNode();
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
    public void TestText(){
        TextNode node = new TextNode();
        STCV.visit(node);
        assertEquals(Main.TEXT,node.type);
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
        AntlrException antlrException = new AntlrException();
        CFGLexer lexer = new CFGLexer(CharStreams.fromString(outString));
        lexer.removeErrorListeners();
        lexer.addErrorListener(antlrException);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(antlrException);
        //Performs lexical analysis and builds a CST.
        cst = parser.prog();
        //cst.children.add(parser.dcl());

      return cst;
    }
}