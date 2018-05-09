package FIRe;

import FIRe.Exceptions.AntlrException;
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
import java.util.Base64;
import java.util.Scanner;

import static org.junit.Assert.*;


public class ScopeTypeCheckVisitorTest{
    
    BuildASTVisitor BASTV = new BuildASTVisitor();
    CFGParser.ProgContext cst = ContextPrep();

    public CFGParser.ProgContext ContextPrep() {

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

