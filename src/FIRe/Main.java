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
        //Creates a StringBuilder from the given code file.
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            sb.append(in.next());
            sb.append(" ");
        }
        //We append $ because this is the terminal symbol of the program.
        sb.append("$");
        in.close();
        //Converts the StringBuilder to a string.
        String outString = sb.toString();

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
        //Prints the AST to check whether it has all the correct info. (Debug code)
        PrintTraversal print = new PrintTraversal();
        //print.Print(ast,0);
        //Fills the symbol table
        SymbolTableVisitor STV = new SymbolTableVisitor();
        STV.visit(ast);
    }
}
