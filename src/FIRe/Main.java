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

import java.awt.*;
import java.io.*;
import java.util.Scanner;
//********************************************************************************
// HOW TO RUN THE PROGRAM WITHOUT INTELLIJ:
//Navigate to: FIReCompiler\out\artifacts\FIReCompiler_jar in the commando prompt
//Then write java -jar FIReCompiler.jar
//********************************************************************************
public class Main {
    public static ErrorLog errors = new ErrorLog();

    public final static String BOOL = "bool";
    public final static String NUMBER = "number";
    public final static String TEXT = "text";
    public final static String BOOLARRAY = "bool array";
    public final static String NUMBERARRAY = "number array";
    public final static String TEXTARRAY = "text array";

    public static void main(String[] args){

        //Creating instance of the symboltable
        SymbolTable ST = new SymbolTable();
        RobotHeaderTable RHT = new RobotHeaderTable();
        ProgNode AST = null;

        boolean debug = true;
        //Reads from the example program. (Debug code)
        Tuple<String, String> pathAndFileName = null;
        String sourceFile;
        if(!debug)
        {
            pathAndFileName = readUserInput();
            sourceFile = readSourceFile(pathAndFileName.x, pathAndFileName.y);
        }
        else
        {
            sourceFile = readSourceFile();
        }


        if(!errors.hasErrors()) {
            AST = lexicalAnalysis(sourceFile);
        }

        if(!errors.hasErrors())
        {
            contextualAnalysis(AST, ST, RHT);
        }
        else
        {
            errors.addError("Errors while reading the source file.");
        }


        if(!errors.hasErrors())
        {
            if(!debug)
            {
                codeGeneration(AST, ST, pathAndFileName.x);
            }
            else
            {
                codeGeneration(AST, ST);
            }

        }
         else {
            //If the semantics are wrong, print that code generation was not performed
            errors.addError("Contextual errors detected. No code was generated.");
        }

        errors.writeToConsole();
    }


    private static String readSourceFile(String path, String fileName)
    {
        Scanner in = null;
        try {
            in = new Scanner(new FileReader(path + fileName));
        } catch (FileNotFoundException e) {
            errors.addError("File could not be read.");
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
        return outString;
    }

    private static String readSourceFile() {
       return readSourceFile("src\\FIRe\\Kodeeksempler\\", "KodeEx3.txt");
    }

    private static ProgNode lexicalAnalysis(String outString) {

        //Setup to perform lexical analysis on the input string.
        CFGLexer lexer = new CFGLexer(CharStreams.fromString(outString));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new AntlrException());
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(new AntlrException());

        //Performs lexical analysis and builds a CST.
        CFGParser.ProgContext CST = parser.prog();
        //cst.children.add(parser.dcl());

        //Builds an AST from the CST
        ProgNode AST = (ProgNode) new BuildASTVisitor().visitProg(CST);

        return  AST;
    }


    private static void contextualAnalysis(ProgNode AST, SymbolTable ST, RobotHeaderTable RHT) {

        ParentASTVisitor PASTV = new ParentASTVisitor();
        try {
            AST.accept(PASTV, null);
        } catch (Exception e) {
            errors.addError("Exception type: " + e.getClass() + "Message: " + e.getMessage());
        }

        //Prints the AST to check whether it has all the correct info. (Debug code)
        PrintTraversal print = new PrintTraversal();
        //print.Print(ast, 0);

        //Collecting typeinformation about: Functions, strategies and events.
        FESVisitor fes = new FESVisitor(ST);
        fes.visit(AST);


        //Filling the symboltable
        ScopeTypeCheckVisitor STV = new ScopeTypeCheckVisitor(ST, RHT);
        STV.visit(AST);


        //We now know all the functions, strategies and events in the program.
        //Therefore checking if the "Default"-strategy exists.
        if (!ST.Contains("Default"))
            errors.addError("No strategy with name: \"Default\" was found");

        //Checking correct use of returns.
        ReturnCheckVisitor returnCheckVisitor = new ReturnCheckVisitor(ST);
        returnCheckVisitor.visit(AST);
    }


    private static void codeGeneration(ProgNode AST, SymbolTable ST)
    {
        codeGeneration(AST, ST, "GeneratedCode\\");
    }
    private static void codeGeneration(ProgNode AST, SymbolTable ST, String path)  {
        SetUnderScoreVisitor underscoreVis = new SetUnderScoreVisitor();

        //Code generation
        CGTopVisitor codeGenerator = new CGTopVisitor(ST);

        try {
            underscoreVis.visit(AST);
            codeGenerator.visit(AST);
        } catch (Exception e) {
            errors.addError(e.getMessage());
        }

        codeGenerator.generateOutputFile(path);
    }



    private static Tuple<String, String> readUserInput()
    {
        Scanner userInput = new Scanner(System.in);
        String path;
        String fileName;
        System.out.println("> Write the full path for your FIRe program excluding the file name fx C:\\Desktop: ");
        System.out.print("> ");
        path = userInput.nextLine();
        path +="\\";
        System.out.println("\n> Write the name of the file including file extension fx Robot.txt:");
        System.out.print("> ");
        fileName =  userInput.nextLine();

        System.out.println("\nThe compiled file will be made in the same path.");
        Tuple<String, String> pathAndFileName = new Tuple<String, String>(path, fileName);

        return pathAndFileName;
    }
}