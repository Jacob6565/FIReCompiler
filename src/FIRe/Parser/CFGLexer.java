// Generated from C:/Users/Magnus/Desktop/FIReCompiler2/src/FIRe/Parser\CFG.g4 by ANTLR 4.7
package FIRe.Parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CFGLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Type=1, RobotProperties=2, When=3, SingleLineComment=4, MultiLineComment=5, 
		WhiteSpace=6, Val=7, AdditiveOp=8, MultiOp=9, Plus=10, Minus=11, Times=12, 
		Divide=13, Modulo=14, BoolVal=15, RelativeOp=16, BoolOp=17, TRUE=18, FALSE=19, 
		Hat=20, Scopel=21, Scoper=22, Comma=23, Colon=24, SemiColon=25, Dot=26, 
		Squarel=27, Squarer=28, Parenl=29, Parenr=30, For=31, Upto=32, Downto=33, 
		While=34, If=35, Elseif=36, Else=37, Strategy=38, Routine=39, Void=40, 
		Assign=41, Return=42, Not=43, Event=44, Name=45, EndOfFile=46;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Type", "RobotProperties", "When", "SingleLineComment", "MultiLineComment", 
		"WhiteSpace", "Val", "AdditiveOp", "MultiOp", "Plus", "Minus", "Times", 
		"Divide", "Modulo", "BoolVal", "RelativeOp", "BoolOp", "TRUE", "FALSE", 
		"Hat", "Scopel", "Scoper", "Comma", "Colon", "SemiColon", "Dot", "Squarel", 
		"Squarer", "Parenl", "Parenr", "For", "Upto", "Downto", "While", "If", 
		"Elseif", "Else", "Strategy", "Routine", "Void", "Assign", "Return", "Not", 
		"Event", "Name", "EndOfFile"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'RobotProperties'", "'when'", null, null, null, null, null, 
		null, "'+'", "'-'", "'*'", "'/'", "'%'", null, null, null, "'true'", "'false'", 
		"'^'", "'{'", "'}'", "','", "':'", "';'", "'.'", "'['", "']'", "'('", 
		"')'", "'for'", "'upto'", "'downto'", "'while'", "'if'", "'else if'", 
		"'else'", "'strategy'", "'routine'", "'void'", "'='", "'return'", "'!'", 
		"'event'", null, "'$'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Type", "RobotProperties", "When", "SingleLineComment", "MultiLineComment", 
		"WhiteSpace", "Val", "AdditiveOp", "MultiOp", "Plus", "Minus", "Times", 
		"Divide", "Modulo", "BoolVal", "RelativeOp", "BoolOp", "TRUE", "FALSE", 
		"Hat", "Scopel", "Scoper", "Comma", "Colon", "SemiColon", "Dot", "Squarel", 
		"Squarer", "Parenl", "Parenr", "For", "Upto", "Downto", "While", "If", 
		"Elseif", "Else", "Strategy", "Routine", "Void", "Assign", "Return", "Not", 
		"Event", "Name", "EndOfFile"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CFGLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CFG.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u0172\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2\u0082\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5"+
		"\u009d\n\5\f\5\16\5\u00a0\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\u00a8\n\6\f"+
		"\6\16\6\u00ab\13\6\3\6\3\6\3\6\3\6\3\6\3\7\6\7\u00b3\n\7\r\7\16\7\u00b4"+
		"\3\7\3\7\3\b\5\b\u00ba\n\b\3\b\6\b\u00bd\n\b\r\b\16\b\u00be\3\b\3\b\6"+
		"\b\u00c3\n\b\r\b\16\b\u00c4\5\b\u00c7\n\b\3\b\3\b\7\b\u00cb\n\b\f\b\16"+
		"\b\u00ce\13\b\3\b\5\b\u00d1\n\b\3\t\3\t\5\t\u00d5\n\t\3\n\3\n\3\n\5\n"+
		"\u00da\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20"+
		"\u00e8\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f3\n"+
		"\21\3\22\3\22\3\22\3\22\3\22\5\22\u00fa\n\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3+\3+"+
		"\3+\3+\3+\3+\3+\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\7.\u016c\n.\f.\16.\u016f"+
		"\13.\3/\3/\2\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60\3\2\13\b\2\"$"+
		"\'\')ACac}\177\177\b\2\3$\'\')ACac}\177\177\5\2\13\f\17\17\"\"\3\2//\3"+
		"\2\62;\4\2\"#%\u0080\4\2>>@@\4\2C\\c|\5\2\62;C\\c|\2\u0189\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3\u0081\3\2\2\2\5\u0083\3\2"+
		"\2\2\7\u0093\3\2\2\2\t\u0098\3\2\2\2\13\u00a3\3\2\2\2\r\u00b2\3\2\2\2"+
		"\17\u00d0\3\2\2\2\21\u00d4\3\2\2\2\23\u00d9\3\2\2\2\25\u00db\3\2\2\2\27"+
		"\u00dd\3\2\2\2\31\u00df\3\2\2\2\33\u00e1\3\2\2\2\35\u00e3\3\2\2\2\37\u00e7"+
		"\3\2\2\2!\u00f2\3\2\2\2#\u00f9\3\2\2\2%\u00fb\3\2\2\2\'\u0100\3\2\2\2"+
		")\u0106\3\2\2\2+\u0108\3\2\2\2-\u010a\3\2\2\2/\u010c\3\2\2\2\61\u010e"+
		"\3\2\2\2\63\u0110\3\2\2\2\65\u0112\3\2\2\2\67\u0114\3\2\2\29\u0116\3\2"+
		"\2\2;\u0118\3\2\2\2=\u011a\3\2\2\2?\u011c\3\2\2\2A\u0120\3\2\2\2C\u0125"+
		"\3\2\2\2E\u012c\3\2\2\2G\u0132\3\2\2\2I\u0135\3\2\2\2K\u013d\3\2\2\2M"+
		"\u0142\3\2\2\2O\u014b\3\2\2\2Q\u0153\3\2\2\2S\u0158\3\2\2\2U\u015a\3\2"+
		"\2\2W\u0161\3\2\2\2Y\u0163\3\2\2\2[\u0169\3\2\2\2]\u0170\3\2\2\2_`\7p"+
		"\2\2`a\7w\2\2ab\7o\2\2bc\7d\2\2cd\7g\2\2d\u0082\7t\2\2ef\7v\2\2fg\7g\2"+
		"\2gh\7z\2\2h\u0082\7v\2\2ij\7d\2\2jk\7q\2\2kl\7q\2\2l\u0082\7n\2\2mn\7"+
		"p\2\2no\7w\2\2op\7o\2\2pq\7d\2\2qr\7g\2\2rs\7t\2\2st\7]\2\2t\u0082\7_"+
		"\2\2uv\7v\2\2vw\7g\2\2wx\7z\2\2xy\7v\2\2yz\7]\2\2z\u0082\7_\2\2{|\7d\2"+
		"\2|}\7q\2\2}~\7q\2\2~\177\7n\2\2\177\u0080\7]\2\2\u0080\u0082\7_\2\2\u0081"+
		"_\3\2\2\2\u0081e\3\2\2\2\u0081i\3\2\2\2\u0081m\3\2\2\2\u0081u\3\2\2\2"+
		"\u0081{\3\2\2\2\u0082\4\3\2\2\2\u0083\u0084\7T\2\2\u0084\u0085\7q\2\2"+
		"\u0085\u0086\7d\2\2\u0086\u0087\7q\2\2\u0087\u0088\7v\2\2\u0088\u0089"+
		"\7R\2\2\u0089\u008a\7t\2\2\u008a\u008b\7q\2\2\u008b\u008c\7r\2\2\u008c"+
		"\u008d\7g\2\2\u008d\u008e\7t\2\2\u008e\u008f\7v\2\2\u008f\u0090\7k\2\2"+
		"\u0090\u0091\7g\2\2\u0091\u0092\7u\2\2\u0092\6\3\2\2\2\u0093\u0094\7y"+
		"\2\2\u0094\u0095\7j\2\2\u0095\u0096\7g\2\2\u0096\u0097\7p\2\2\u0097\b"+
		"\3\2\2\2\u0098\u0099\7\61\2\2\u0099\u009a\7\61\2\2\u009a\u009e\3\2\2\2"+
		"\u009b\u009d\t\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a2\b\5\2\2\u00a2\n\3\2\2\2\u00a3\u00a4\7\61\2\2\u00a4\u00a5\7,\2\2"+
		"\u00a5\u00a9\3\2\2\2\u00a6\u00a8\t\3\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab"+
		"\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ac\u00ad\7,\2\2\u00ad\u00ae\7\61\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00b0\b\6\2\2\u00b0\f\3\2\2\2\u00b1\u00b3\t\4\2\2\u00b2\u00b1"+
		"\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b7\b\7\2\2\u00b7\16\3\2\2\2\u00b8\u00ba\t\5\2"+
		"\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00bd"+
		"\t\6\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c6\3\2\2\2\u00c0\u00c2\7\60\2\2\u00c1\u00c3\t"+
		"\6\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c0\3\2\2\2\u00c6\u00c7\3\2"+
		"\2\2\u00c7\u00d1\3\2\2\2\u00c8\u00cc\7$\2\2\u00c9\u00cb\t\7\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\7$\2\2\u00d0"+
		"\u00b9\3\2\2\2\u00d0\u00c8\3\2\2\2\u00d1\20\3\2\2\2\u00d2\u00d5\5\25\13"+
		"\2\u00d3\u00d5\5\27\f\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5"+
		"\22\3\2\2\2\u00d6\u00da\5\31\r\2\u00d7\u00da\5\33\16\2\u00d8\u00da\5\35"+
		"\17\2\u00d9\u00d6\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da"+
		"\24\3\2\2\2\u00db\u00dc\7-\2\2\u00dc\26\3\2\2\2\u00dd\u00de\7/\2\2\u00de"+
		"\30\3\2\2\2\u00df\u00e0\7,\2\2\u00e0\32\3\2\2\2\u00e1\u00e2\7\61\2\2\u00e2"+
		"\34\3\2\2\2\u00e3\u00e4\7\'\2\2\u00e4\36\3\2\2\2\u00e5\u00e8\5%\23\2\u00e6"+
		"\u00e8\5\'\24\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8 \3\2\2\2"+
		"\u00e9\u00f3\t\b\2\2\u00ea\u00eb\7>\2\2\u00eb\u00f3\7?\2\2\u00ec\u00ed"+
		"\7@\2\2\u00ed\u00f3\7?\2\2\u00ee\u00ef\7#\2\2\u00ef\u00f3\7?\2\2\u00f0"+
		"\u00f1\7?\2\2\u00f1\u00f3\7?\2\2\u00f2\u00e9\3\2\2\2\u00f2\u00ea\3\2\2"+
		"\2\u00f2\u00ec\3\2\2\2\u00f2\u00ee\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\""+
		"\3\2\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7p\2\2\u00f6\u00fa\7f\2\2\u00f7"+
		"\u00f8\7q\2\2\u00f8\u00fa\7t\2\2\u00f9\u00f4\3\2\2\2\u00f9\u00f7\3\2\2"+
		"\2\u00fa$\3\2\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7t\2\2\u00fd\u00fe\7"+
		"w\2\2\u00fe\u00ff\7g\2\2\u00ff&\3\2\2\2\u0100\u0101\7h\2\2\u0101\u0102"+
		"\7c\2\2\u0102\u0103\7n\2\2\u0103\u0104\7u\2\2\u0104\u0105\7g\2\2\u0105"+
		"(\3\2\2\2\u0106\u0107\7`\2\2\u0107*\3\2\2\2\u0108\u0109\7}\2\2\u0109,"+
		"\3\2\2\2\u010a\u010b\7\177\2\2\u010b.\3\2\2\2\u010c\u010d\7.\2\2\u010d"+
		"\60\3\2\2\2\u010e\u010f\7<\2\2\u010f\62\3\2\2\2\u0110\u0111\7=\2\2\u0111"+
		"\64\3\2\2\2\u0112\u0113\7\60\2\2\u0113\66\3\2\2\2\u0114\u0115\7]\2\2\u0115"+
		"8\3\2\2\2\u0116\u0117\7_\2\2\u0117:\3\2\2\2\u0118\u0119\7*\2\2\u0119<"+
		"\3\2\2\2\u011a\u011b\7+\2\2\u011b>\3\2\2\2\u011c\u011d\7h\2\2\u011d\u011e"+
		"\7q\2\2\u011e\u011f\7t\2\2\u011f@\3\2\2\2\u0120\u0121\7w\2\2\u0121\u0122"+
		"\7r\2\2\u0122\u0123\7v\2\2\u0123\u0124\7q\2\2\u0124B\3\2\2\2\u0125\u0126"+
		"\7f\2\2\u0126\u0127\7q\2\2\u0127\u0128\7y\2\2\u0128\u0129\7p\2\2\u0129"+
		"\u012a\7v\2\2\u012a\u012b\7q\2\2\u012bD\3\2\2\2\u012c\u012d\7y\2\2\u012d"+
		"\u012e\7j\2\2\u012e\u012f\7k\2\2\u012f\u0130\7n\2\2\u0130\u0131\7g\2\2"+
		"\u0131F\3\2\2\2\u0132\u0133\7k\2\2\u0133\u0134\7h\2\2\u0134H\3\2\2\2\u0135"+
		"\u0136\7g\2\2\u0136\u0137\7n\2\2\u0137\u0138\7u\2\2\u0138\u0139\7g\2\2"+
		"\u0139\u013a\7\"\2\2\u013a\u013b\7k\2\2\u013b\u013c\7h\2\2\u013cJ\3\2"+
		"\2\2\u013d\u013e\7g\2\2\u013e\u013f\7n\2\2\u013f\u0140\7u\2\2\u0140\u0141"+
		"\7g\2\2\u0141L\3\2\2\2\u0142\u0143\7u\2\2\u0143\u0144\7v\2\2\u0144\u0145"+
		"\7t\2\2\u0145\u0146\7c\2\2\u0146\u0147\7v\2\2\u0147\u0148\7g\2\2\u0148"+
		"\u0149\7i\2\2\u0149\u014a\7{\2\2\u014aN\3\2\2\2\u014b\u014c\7t\2\2\u014c"+
		"\u014d\7q\2\2\u014d\u014e\7w\2\2\u014e\u014f\7v\2\2\u014f\u0150\7k\2\2"+
		"\u0150\u0151\7p\2\2\u0151\u0152\7g\2\2\u0152P\3\2\2\2\u0153\u0154\7x\2"+
		"\2\u0154\u0155\7q\2\2\u0155\u0156\7k\2\2\u0156\u0157\7f\2\2\u0157R\3\2"+
		"\2\2\u0158\u0159\7?\2\2\u0159T\3\2\2\2\u015a\u015b\7t\2\2\u015b\u015c"+
		"\7g\2\2\u015c\u015d\7v\2\2\u015d\u015e\7w\2\2\u015e\u015f\7t\2\2\u015f"+
		"\u0160\7p\2\2\u0160V\3\2\2\2\u0161\u0162\7#\2\2\u0162X\3\2\2\2\u0163\u0164"+
		"\7g\2\2\u0164\u0165\7x\2\2\u0165\u0166\7g\2\2\u0166\u0167\7p\2\2\u0167"+
		"\u0168\7v\2\2\u0168Z\3\2\2\2\u0169\u016d\t\t\2\2\u016a\u016c\t\n\2\2\u016b"+
		"\u016a\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2"+
		"\2\2\u016e\\\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0171\7&\2\2\u0171^\3\2"+
		"\2\2\23\2\u0081\u009e\u00a9\u00b4\u00b9\u00be\u00c4\u00c6\u00cc\u00d0"+
		"\u00d4\u00d9\u00e7\u00f2\u00f9\u016d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}