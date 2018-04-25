package FIRe;

import FIRe.Parser.CFGLexer;
import FIRe.Parser.CFGParser;
import org.antlr.v4.runtime.*;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Reads from the example program. (Debug code)
        Scanner in = new Scanner(new FileReader("src\\FIRe\\KodeEx.txt"));

        //We use this delimiter, to chop the code into bits. We split by the backslash character \n
        in.useDelimiter("\n");

        //Creates a StringBuilder from the given code file.
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            sb.append(in.next() + "\n");
        }
        //We append $ because this is the terminal symbol of the program.
        sb.append("$");
        in.close();
        //Converts the StringBuilder to a string.
        String outString = sb.toString();
        RobotHeaderTable RHT = new RobotHeaderTable();

        //InputStream inputStream = new ByteArrayInputStream(outString.getBytes());
        //CharStream charStream = new ANTLRInputStream(outString);

        //https://stackoverflow.com/questions/18110180/processing-a-string-with-antlr4
        //Setup to perform lexical analysis on the input string.
        CFGLexer lexer = new CFGLexer(CharStreams.fromString(outString));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);
        //Performs lexical analysis and builds a CST.
        CFGParser.ProgContext cst = parser.prog();
        //cst.children.add(parser.dcl());
        //Builds an AST from the CST
        ProgNode ast = (ProgNode) new BuildASTVisitor().visitProg(cst);
        ParentASTVisitor PASTV = new ParentASTVisitor();
        try {
            ast.accept(PASTV, null);
        }
        catch (Exception e)
        {
            System.out.println("Exception triggered");
            System.out.println("Exception type: " + e.getClass() + "Message: " + e.getMessage());
        }
        //Prints the AST to check whether it has all the correct info. (Debug code)
        PrintTraversal print = new PrintTraversal();
        print.Print(ast,0);
        //Fills the symbol table
        SymbolTable symbolTable = new SymbolTable();
        FESVisitor fes = new FESVisitor(symbolTable);
        fes.visit(ast);

        SymbolTableVisitor STV = new SymbolTableVisitor(symbolTable,RHT);
        STV.visit(ast);/*
        try {
            ReturnCheckVisitor returnCheckVisitor = new ReturnCheckVisitor(symbolTable);
            returnCheckVisitor.visit(ast);
        }
        catch(Exception e){
            System.out.println("Return fejl");
        }*/

        //STV.visit(ast);
    }
}
