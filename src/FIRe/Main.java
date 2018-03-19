package FIRe;

import FIRe.Parser.CFGLexer;
import FIRe.Parser.CFGParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new FileReader("src\\FIRe\\KodeEx.txt"));

        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        String outString = sb.toString();

        InputStream inputStream = new ByteArrayInputStream(outString.getBytes());
        CharStream charStream = new UnbufferedCharStream(inputStream);
        CFGLexer lexer = new CFGLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);

        CFGParser.ProgContext cst = parser.prog();
        ProgNode ast = (ProgNode) new BuildASTVisitor().visitProg(cst);

        ast.Print();
    }
}
