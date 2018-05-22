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
import java.util.*;

import static org.junit.Assert.*;


public class ScopeTypeCheckVisitorTest{

    SymbolTable ST = new SymbolTable();
    RobotHeaderTable RHT = new RobotHeaderTable();
    ScopeTypeCheckVisitor STCV = new ScopeTypeCheckVisitor(ST, RHT);

    private boolean ArithInfixCheck(InfixExpressionNode node){
        return node.LeftChild.type.equals(Main.NUMBER) && node.RightChild.type.equals(Main.NUMBER) && node.type.equals(Main.NUMBER);
    }
    private boolean RelationalInfixCheck(InfixExpressionNode node){
        return node.LeftChild.type.equals(Main.NUMBER) && node.RightChild.type.equals(Main.NUMBER) && node.type.equals(Main.BOOL);
    }
    private boolean textInfixCheck(InfixExpressionNode node){
        return node.RightChild.type.equals(Main.TEXT) && node.LeftChild.type.equals(Main.TEXT) && node.type.equals(Main.BOOL);
    }
    private boolean textConcatCheck(AdditionNode node){
        return node.RightChild.type.equals(Main.TEXT) && node.LeftChild.type.equals(Main.TEXT) && node.type.equals(Main.TEXT);
    }

    private boolean Contains(int[] indices, int value){
        for (int i = 0; i < indices.length; ++i){
            if (indices[i] == value)
                return true;
        }
        return false;
    }

    private boolean trueList(ArrayList<Boolean> list, int... falseIndices){
        boolean value = true;
        for (int i = 0; i < list.size(); i++){
            if (!(list.get(i) && !Contains(falseIndices,i) || (!list.get(i) && Contains(falseIndices,i)))) {
                value = false;
                break;
            }
        }
        return value;
    }

    private ArrayList<Tuple<String, String>> MakeTypeTable(){
        ArrayList<Tuple<String, String>> tuple = new ArrayList<>();

        tuple.add( new Tuple<>(Main.NUMBER, Main.NUMBER));
        tuple.add( new Tuple<>(Main.NUMBER, Main.BOOL));
        tuple.add(new Tuple<>(Main.NUMBER, Main.TEXT));
        tuple.add( new Tuple<>(Main.BOOL, Main.NUMBER));
        tuple.add(new Tuple<>(Main.BOOL, Main.BOOL));
        tuple.add(new Tuple<>(Main.BOOL, Main.TEXT));
        tuple.add( new Tuple<>(Main.TEXT, Main.NUMBER));
        tuple.add( new Tuple<>(Main.TEXT, Main.BOOL));
        tuple.add( new Tuple<>(Main.TEXT, Main.TEXT));

        return tuple;
    }

    private boolean testIndividualArithInfix(InfixExpressionNode node){
        ArrayList<Tuple<String, String>> TypeTable = MakeTypeTable();
        node.LeftChild = new ValNode();
        node.RightChild = new ValNode();
        ArrayList<Boolean> determineTruthOfList = new ArrayList<>();
        for (int i = 0; i < 9; ++i){
            node.LeftChild.type = TypeTable.get(i).getKey();
            node.RightChild.type = TypeTable.get(i).getValue();
            STCV.visitNode(node);
            determineTruthOfList.add(ArithInfixCheck(node));
        }
        return(trueList(determineTruthOfList,1,2,3,4,5,6,7,8));
    }
    private boolean testIndividualRelationalInfix(InfixExpressionNode node){
        ArrayList<Tuple<String, String>> TypeTable = MakeTypeTable();
        node.LeftChild = new ValNode();
        node.RightChild = new ValNode();
        ArrayList<Boolean> determineTruthOfList = new ArrayList<>();
        for (int i = 0; i < 9; ++i){
            node.LeftChild.type = TypeTable.get(i).getKey();
            node.RightChild.type = TypeTable.get(i).getValue();
            STCV.visitNode(node);
            determineTruthOfList.add(RelationalInfixCheck(node));
        }
        return(trueList(determineTruthOfList,1,2,3,4,5,6,7,8));
    }
    private boolean testIndividualTextInfix(InfixExpressionNode node){
        ArrayList<Tuple<String, String>> TypeTable = MakeTypeTable();
        node.LeftChild = new ValNode();
        node.RightChild = new ValNode();
        ArrayList<Boolean> determineTruthOfList = new ArrayList<>();
        for (int i = 0; i < 9; ++i){
            node.LeftChild.type = TypeTable.get(i).getKey();
            node.RightChild.type = TypeTable.get(i).getValue();
            STCV.visitNode(node);
            determineTruthOfList.add(textInfixCheck(node));
        }
        return(trueList(determineTruthOfList,0,1,2,3,4,5,6,7));
    }
    private boolean testIndividualTextConcat(AdditionNode node){
        ArrayList<Tuple<String, String>> TypeTable = MakeTypeTable();
        node.LeftChild = new ValNode();
        node.RightChild = new ValNode();
        ArrayList<Boolean> determineTruthOfList = new ArrayList<>();
        for (int i = 0; i < 9; ++i){
            node.LeftChild.type = TypeTable.get(i).getKey();
            node.RightChild.type = TypeTable.get(i).getValue();
            STCV.visitNode(node);
            determineTruthOfList.add(textConcatCheck(node));
        }
        return(trueList(determineTruthOfList,0,1,2,3,4,5,6,7));
    }

    @Test
    public void testAllArithInfix(){
        ArrayList<Boolean> results = new ArrayList<>();
        results.add(testIndividualArithInfix(new DivisionNode()));
        results.add(testIndividualArithInfix(new AdditionNode()));
        results.add(testIndividualArithInfix(new MultiplicationNode()));
        results.add(testIndividualArithInfix(new SubtractionNode()));
        results.add(testIndividualArithInfix(new ModuloNode()));
        results.add(testIndividualArithInfix(new PowerNode()));
        assert trueList(results);
    }

    @Test
    public void TestAllRelationalInfix(){
        ArrayList<Boolean> results = new ArrayList<>();
        results.add(testIndividualRelationalInfix(new GreaterThanNode()));
        results.add(testIndividualRelationalInfix(new GEQNode()));
        results.add(testIndividualRelationalInfix(new EqualsNode()));
        results.add(testIndividualRelationalInfix(new NotEqualsNode()));
        results.add(testIndividualRelationalInfix(new LEQNode()));
        results.add(testIndividualRelationalInfix(new LessThanNode()));
        assert trueList(results);
    }

    @Test
    public void TestAllTextInfix(){
        ArrayList<Boolean> results = new ArrayList<>();
        results.add(testIndividualTextInfix(new EqualsNode()));
        results.add(testIndividualTextInfix(new NotEqualsNode()));
        results.add(testIndividualTextConcat(new AdditionNode()));
        assert trueList(results);
    }

}