package FIRe;

import FIRe.CodeGeneration.CGTopVisitor;
import FIRe.CodeGeneration.SetUnderScoreVisitor;
import FIRe.ContextualAnalysis.ParentASTVisitor;
import FIRe.Exceptions.*;
import FIRe.Parser.CFGLexer;
import FIRe.Parser.CFGParser;
import org.antlr.v4.runtime.*;
import FIRe.ContextualAnalysis.*;
import FIRe.Nodes.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static boolean CodeGenerationFlag = false; //Set to true, if/when there is an error that prevents code generation
    public static boolean ContextualAnalysisFlag = false; //Set to true, if/when there is an error that prevents the contextual analysis

    public static void main(String[] args) throws Exception {

        //Reads from the example program. (Debug code)
        Scanner in = new Scanner(new FileReader("src\\FIRe\\Kodeeksempler\\KodeEx3.txt"));

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

        try {
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
        } catch (ParseCancellationException ex) {
            System.out.println(ex.getMessage());
            ContextualAnalysisFlag = true; //If there is a mistake in the syntax, disable the Contextual Analysis
        }

        if (!ContextualAnalysisFlag) {//If the syntax is ok.
            //Builds an AST from the CST
            RobotHeaderTable RHT = new RobotHeaderTable();
            ProgNode ast = (ProgNode) new BuildASTVisitor().visitProg(cst);
            ParentASTVisitor PASTV = new ParentASTVisitor();
            try {
                ast.accept(PASTV, null);
            } catch (Exception e) {
                System.out.println("Exception type: " + e.getClass() + "Message: " + e.getMessage());
            }

            //Prints the AST to check whether it has all the correct info. (Debug code)
            PrintTraversal print = new PrintTraversal();
            //print.Print(ast, 0);


            //Creating instance of the symboltable
            SymbolTable symbolTable = new SymbolTable();


            //Collecting typeinformation about: Functions, strategies and events.
            FESVisitor fes = new FESVisitor(symbolTable);
            fes.visit(ast);


            //Filling the symboltable
            ScopeTypeCheckVisitor STV = new ScopeTypeCheckVisitor(symbolTable, RHT);
            STV.visit(ast);


            //We now know all the functions, strategies and events in the program.
            //Therefore checking if the "Default"-strategy exists.
            try {
                symbolTable.Search("Default", 0);
            } catch (SymbolNotFoundException e) {
                //Could not find the strategy with name "Default";
                try {
                    throw new MissingDefaultStrategyException("No strategy with name: \"Default\" was found");
                } catch (MissingDefaultStrategyException f) {
                    System.out.println(f.getMessage());
                }
            }


            //Checking correct use of returns.
            ReturnCheckVisitor returnCheckVisitor = new ReturnCheckVisitor(symbolTable);
            returnCheckVisitor.visit(ast);

            if (!CodeGenerationFlag) { //If no breaking mistakes were found, generate the code.
                SetUnderScoreVisitor underscoreVis = new SetUnderScoreVisitor();

                underscoreVis.visit(ast);

                //Code generation
                CGTopVisitor codeGenerator = new CGTopVisitor(symbolTable);

                try {
                    codeGenerator.visit(ast);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                codeGenerator.generateOutputFile();
            } else { //If the semantics are wrong, print that code generation was not performed
                System.out.println("Contextual errors detected. No code was generated.");
            }
        }
        else {
            System.out.println("Syntactic errors detected. No code was generated.");
        }
    }
}