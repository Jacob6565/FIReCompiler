package FIRe.Exceptions;

import FIRe.Main;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class AntlrException extends BaseErrorListener {

    public static final AntlrException INSTANCE = new AntlrException();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
            throws ParseCancellationException {
        Main.CodeGenerationFlag = true;
        Main.ContextualAnalysisFlag = true;
        throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }
}