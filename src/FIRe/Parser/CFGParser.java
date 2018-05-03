// Generated from C:/Users/Magnus/Desktop/FIReCompiler2/src/FIRe/Parser\CFG.g4 by ANTLR 4.7
package FIRe.Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CFGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Type=1, RobotProperties=2, When=3, SingleLineComment=4, WhiteSpace=5, 
		Val=6, AdditiveOp=7, MultiOp=8, Plus=9, Minus=10, Times=11, Divide=12, 
		Modulo=13, BoolVal=14, RelativeOp=15, BoolOp=16, TRUE=17, FALSE=18, Hat=19, 
		Scopel=20, Scoper=21, Comma=22, Colon=23, SemiColon=24, Dot=25, Squarel=26, 
		Squarer=27, Parenl=28, Parenr=29, For=30, Upto=31, Downto=32, While=33, 
		If=34, Elseif=35, Else=36, Strategy=37, Routine=38, Void=39, Assign=40, 
		Return=41, Not=42, Event=43, Name=44, EndOfFile=45;
	public static final int
		RULE_prog = 0, RULE_progBody = 1, RULE_strategyDcl = 2, RULE_strategyBlock = 3, 
		RULE_funcDcl = 4, RULE_funcType = 5, RULE_block = 6, RULE_blockBody = 7, 
		RULE_fParamList = 8, RULE_robotDcl = 9, RULE_robotDclBody = 10, RULE_dcl = 11, 
		RULE_stmt = 12, RULE_routine = 13, RULE_when = 14, RULE_expr = 15, RULE_assignStmt = 16, 
		RULE_funcCall = 17, RULE_eventDcl = 18, RULE_aParamList = 19, RULE_ctrlStruct = 20, 
		RULE_aif = 21, RULE_aelseif = 22, RULE_aelse = 23, RULE_id = 24;
	public static final String[] ruleNames = {
		"prog", "progBody", "strategyDcl", "strategyBlock", "funcDcl", "funcType", 
		"block", "blockBody", "fParamList", "robotDcl", "robotDclBody", "dcl", 
		"stmt", "routine", "when", "expr", "assignStmt", "funcCall", "eventDcl", 
		"aParamList", "ctrlStruct", "aif", "aelseif", "aelse", "id"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'RobotProperties'", "'when'", null, null, null, null, null, 
		"'+'", "'-'", "'*'", "'/'", "'%'", null, null, null, "'true'", "'false'", 
		"'^'", "'{'", "'}'", "','", "':'", "';'", "'.'", "'['", "']'", "'('", 
		"')'", "'for'", "'upto'", "'downto'", "'while'", "'if'", "'else if'", 
		"'else'", "'strategy'", "'routine'", "'void'", "'='", "'return'", "'!'", 
		"'event'", null, "'$'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Type", "RobotProperties", "When", "SingleLineComment", "WhiteSpace", 
		"Val", "AdditiveOp", "MultiOp", "Plus", "Minus", "Times", "Divide", "Modulo", 
		"BoolVal", "RelativeOp", "BoolOp", "TRUE", "FALSE", "Hat", "Scopel", "Scoper", 
		"Comma", "Colon", "SemiColon", "Dot", "Squarel", "Squarer", "Parenl", 
		"Parenr", "For", "Upto", "Downto", "While", "If", "Elseif", "Else", "Strategy", 
		"Routine", "Void", "Assign", "Return", "Not", "Event", "Name", "EndOfFile"
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

	@Override
	public String getGrammarFileName() { return "CFG.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CFGParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public RobotDclContext robotDcl() {
			return getRuleContext(RobotDclContext.class,0);
		}
		public TerminalNode EndOfFile() { return getToken(CFGParser.EndOfFile, 0); }
		public List<ProgBodyContext> progBody() {
			return getRuleContexts(ProgBodyContext.class);
		}
		public ProgBodyContext progBody(int i) {
			return getRuleContext(ProgBodyContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			robotDcl();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type) | (1L << Strategy) | (1L << Void) | (1L << Event))) != 0)) {
				{
				{
				setState(51);
				progBody();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(EndOfFile);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgBodyContext extends ParserRuleContext {
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public FuncDclContext funcDcl() {
			return getRuleContext(FuncDclContext.class,0);
		}
		public StrategyDclContext strategyDcl() {
			return getRuleContext(StrategyDclContext.class,0);
		}
		public EventDclContext eventDcl() {
			return getRuleContext(EventDclContext.class,0);
		}
		public ProgBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterProgBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitProgBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitProgBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgBodyContext progBody() throws RecognitionException {
		ProgBodyContext _localctx = new ProgBodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_progBody);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				dcl();
				setState(60);
				match(SemiColon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				funcDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				strategyDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				eventDcl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrategyDclContext extends ParserRuleContext {
		public TerminalNode Strategy() { return getToken(CFGParser.Strategy, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public TerminalNode Scopel() { return getToken(CFGParser.Scopel, 0); }
		public TerminalNode Scoper() { return getToken(CFGParser.Scoper, 0); }
		public FParamListContext fParamList() {
			return getRuleContext(FParamListContext.class,0);
		}
		public List<BlockBodyContext> blockBody() {
			return getRuleContexts(BlockBodyContext.class);
		}
		public BlockBodyContext blockBody(int i) {
			return getRuleContext(BlockBodyContext.class,i);
		}
		public List<StrategyBlockContext> strategyBlock() {
			return getRuleContexts(StrategyBlockContext.class);
		}
		public StrategyBlockContext strategyBlock(int i) {
			return getRuleContext(StrategyBlockContext.class,i);
		}
		public StrategyDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategyDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterStrategyDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitStrategyDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitStrategyDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategyDclContext strategyDcl() throws RecognitionException {
		StrategyDclContext _localctx = new StrategyDclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_strategyDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(Strategy);
			setState(68);
			id();
			setState(69);
			match(Parenl);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(70);
				fParamList();
				}
			}

			setState(73);
			match(Parenr);
			setState(74);
			match(Scopel);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type) | (1L << For) | (1L << While) | (1L << If) | (1L << Return) | (1L << Name))) != 0)) {
				{
				{
				setState(75);
				blockBody();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==When || _la==Routine) {
				{
				{
				setState(81);
				strategyBlock();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(Scoper);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrategyBlockContext extends ParserRuleContext {
		public RoutineContext routine() {
			return getRuleContext(RoutineContext.class,0);
		}
		public WhenContext when() {
			return getRuleContext(WhenContext.class,0);
		}
		public StrategyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategyBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterStrategyBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitStrategyBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitStrategyBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategyBlockContext strategyBlock() throws RecognitionException {
		StrategyBlockContext _localctx = new StrategyBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_strategyBlock);
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Routine:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				routine();
				}
				break;
			case When:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				when();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDclContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FParamListContext fParamList() {
			return getRuleContext(FParamListContext.class,0);
		}
		public FuncDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterFuncDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitFuncDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitFuncDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDclContext funcDcl() throws RecognitionException {
		FuncDclContext _localctx = new FuncDclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			funcType();
			setState(94);
			id();
			setState(95);
			match(Parenl);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(96);
				fParamList();
				}
			}

			setState(99);
			match(Parenr);
			setState(100);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncTypeContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(CFGParser.Void, 0); }
		public TerminalNode Type() { return getToken(CFGParser.Type, 0); }
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterFuncType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitFuncType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitFuncType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !(_la==Type || _la==Void) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode Scopel() { return getToken(CFGParser.Scopel, 0); }
		public TerminalNode Scoper() { return getToken(CFGParser.Scoper, 0); }
		public List<BlockBodyContext> blockBody() {
			return getRuleContexts(BlockBodyContext.class);
		}
		public BlockBodyContext blockBody(int i) {
			return getRuleContext(BlockBodyContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(Scopel);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type) | (1L << For) | (1L << While) | (1L << If) | (1L << Return) | (1L << Name))) != 0)) {
				{
				{
				setState(105);
				blockBody();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			match(Scoper);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockBodyContext extends ParserRuleContext {
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterBlockBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitBlockBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitBlockBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockBodyContext blockBody() throws RecognitionException {
		BlockBodyContext _localctx = new BlockBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_blockBody);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Type:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				dcl();
				setState(114);
				match(SemiColon);
				}
				break;
			case For:
			case While:
			case If:
			case Return:
			case Name:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FParamListContext extends ParserRuleContext {
		public TerminalNode Type() { return getToken(CFGParser.Type, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CFGParser.Comma, 0); }
		public FParamListContext fParamList() {
			return getRuleContext(FParamListContext.class,0);
		}
		public FParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fParamList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterFParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitFParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitFParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FParamListContext fParamList() throws RecognitionException {
		FParamListContext _localctx = new FParamListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fParamList);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(Type);
				setState(120);
				id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(Type);
				setState(122);
				id();
				setState(123);
				match(Comma);
				setState(124);
				fParamList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RobotDclContext extends ParserRuleContext {
		public TerminalNode RobotProperties() { return getToken(CFGParser.RobotProperties, 0); }
		public TerminalNode Scopel() { return getToken(CFGParser.Scopel, 0); }
		public RobotDclBodyContext robotDclBody() {
			return getRuleContext(RobotDclBodyContext.class,0);
		}
		public TerminalNode Scoper() { return getToken(CFGParser.Scoper, 0); }
		public RobotDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_robotDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterRobotDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitRobotDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitRobotDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RobotDclContext robotDcl() throws RecognitionException {
		RobotDclContext _localctx = new RobotDclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_robotDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(RobotProperties);
			setState(129);
			match(Scopel);
			setState(130);
			robotDclBody();
			setState(131);
			match(Scoper);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RobotDclBodyContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public List<TerminalNode> Colon() { return getTokens(CFGParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(CFGParser.Colon, i);
		}
		public List<TerminalNode> SemiColon() { return getTokens(CFGParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(CFGParser.SemiColon, i);
		}
		public RobotDclBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_robotDclBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterRobotDclBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitRobotDclBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitRobotDclBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RobotDclBodyContext robotDclBody() throws RecognitionException {
		RobotDclBodyContext _localctx = new RobotDclBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_robotDclBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Name) {
				{
				{
				setState(133);
				id();
				setState(134);
				match(Colon);
				setState(135);
				id();
				setState(136);
				match(SemiColon);
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DclContext extends ParserRuleContext {
		public TerminalNode Type() { return getToken(CFGParser.Type, 0); }
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public TerminalNode Assign() { return getToken(CFGParser.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> Comma() { return getTokens(CFGParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CFGParser.Comma, i);
		}
		public TerminalNode Squarel() { return getToken(CFGParser.Squarel, 0); }
		public TerminalNode Squarer() { return getToken(CFGParser.Squarer, 0); }
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dcl);
		int _la;
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(Type);
				setState(144);
				id();
				setState(145);
				match(Assign);
				setState(146);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(Type);
				setState(149);
				id();
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(150);
					match(Comma);
					setState(151);
					id();
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(Type);
				setState(158);
				id();
				setState(159);
				match(Squarel);
				setState(160);
				expr(0);
				setState(161);
				match(Squarer);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public CtrlStructContext ctrlStruct() {
			return getRuleContext(CtrlStructContext.class,0);
		}
		public TerminalNode Return() { return getToken(CFGParser.Return, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmt);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				assignStmt();
				setState(166);
				match(SemiColon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				funcCall();
				setState(169);
				match(SemiColon);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				ctrlStruct();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				match(Return);
				setState(173);
				expr(0);
				setState(174);
				match(SemiColon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RoutineContext extends ParserRuleContext {
		public TerminalNode Routine() { return getToken(CFGParser.Routine, 0); }
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RoutineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterRoutine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitRoutine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitRoutine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutineContext routine() throws RecognitionException {
		RoutineContext _localctx = new RoutineContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_routine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(Routine);
			setState(179);
			match(Parenl);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Val) | (1L << BoolVal) | (1L << Parenl) | (1L << Not) | (1L << Name))) != 0)) {
				{
				setState(180);
				expr(0);
				}
			}

			setState(183);
			match(Parenr);
			setState(184);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenContext extends ParserRuleContext {
		public TerminalNode When() { return getToken(CFGParser.When, 0); }
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public WhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_when; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterWhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitWhen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitWhen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenContext when() throws RecognitionException {
		WhenContext _localctx = new WhenContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_when);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(When);
			setState(187);
			match(Parenl);
			{
			setState(188);
			id();
			setState(189);
			id();
			}
			setState(191);
			match(Parenr);
			setState(192);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public TerminalNode Not() { return getToken(CFGParser.Not, 0); }
		public TerminalNode Val() { return getToken(CFGParser.Val, 0); }
		public TerminalNode BoolVal() { return getToken(CFGParser.BoolVal, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public TerminalNode Hat() { return getToken(CFGParser.Hat, 0); }
		public TerminalNode MultiOp() { return getToken(CFGParser.MultiOp, 0); }
		public TerminalNode AdditiveOp() { return getToken(CFGParser.AdditiveOp, 0); }
		public TerminalNode RelativeOp() { return getToken(CFGParser.RelativeOp, 0); }
		public TerminalNode BoolOp() { return getToken(CFGParser.BoolOp, 0); }
		public TerminalNode Squarel() { return getToken(CFGParser.Squarel, 0); }
		public TerminalNode Squarer() { return getToken(CFGParser.Squarer, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(195);
				match(Parenl);
				setState(196);
				expr(0);
				setState(197);
				match(Parenr);
				}
				break;
			case 2:
				{
				setState(199);
				match(Not);
				setState(200);
				expr(10);
				}
				break;
			case 3:
				{
				setState(201);
				match(Val);
				}
				break;
			case 4:
				{
				setState(202);
				match(BoolVal);
				}
				break;
			case 5:
				{
				setState(203);
				id();
				}
				break;
			case 6:
				{
				setState(204);
				funcCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(227);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(207);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(208);
						match(Hat);
						setState(209);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(210);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(211);
						match(MultiOp);
						setState(212);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(213);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(214);
						match(AdditiveOp);
						setState(215);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(216);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(217);
						match(RelativeOp);
						setState(218);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(219);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(220);
						match(BoolOp);
						setState(221);
						expr(6);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(222);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(223);
						match(Squarel);
						setState(224);
						expr(0);
						setState(225);
						match(Squarer);
						}
						break;
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignStmtContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CFGParser.Assign, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Squarel() { return getToken(CFGParser.Squarel, 0); }
		public TerminalNode Squarer() { return getToken(CFGParser.Squarer, 0); }
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_assignStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			id();
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Squarel) {
				{
				setState(233);
				match(Squarel);
				setState(234);
				expr(0);
				setState(235);
				match(Squarer);
				}
			}

			setState(239);
			match(Assign);
			setState(240);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public AParamListContext aParamList() {
			return getRuleContext(AParamListContext.class,0);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			id();
			setState(243);
			match(Parenl);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Val) | (1L << BoolVal) | (1L << Parenl) | (1L << Not) | (1L << Name))) != 0)) {
				{
				setState(244);
				aParamList();
				}
			}

			setState(247);
			match(Parenr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventDclContext extends ParserRuleContext {
		public TerminalNode Event() { return getToken(CFGParser.Event, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public EventDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterEventDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitEventDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitEventDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventDclContext eventDcl() throws RecognitionException {
		EventDclContext _localctx = new EventDclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_eventDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(Event);
			setState(250);
			id();
			setState(251);
			match(Parenl);
			setState(252);
			match(Parenr);
			setState(253);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AParamListContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CFGParser.Comma, 0); }
		public AParamListContext aParamList() {
			return getRuleContext(AParamListContext.class,0);
		}
		public AParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aParamList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterAParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitAParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitAParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AParamListContext aParamList() throws RecognitionException {
		AParamListContext _localctx = new AParamListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_aParamList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			expr(0);
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(256);
				match(Comma);
				setState(257);
				aParamList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtrlStructContext extends ParserRuleContext {
		public AifContext aif() {
			return getRuleContext(AifContext.class,0);
		}
		public List<AelseifContext> aelseif() {
			return getRuleContexts(AelseifContext.class);
		}
		public AelseifContext aelseif(int i) {
			return getRuleContext(AelseifContext.class,i);
		}
		public AelseContext aelse() {
			return getRuleContext(AelseContext.class,0);
		}
		public TerminalNode For() { return getToken(CFGParser.For, 0); }
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Upto() { return getToken(CFGParser.Upto, 0); }
		public TerminalNode Downto() { return getToken(CFGParser.Downto, 0); }
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode While() { return getToken(CFGParser.While, 0); }
		public CtrlStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctrlStruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterCtrlStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitCtrlStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitCtrlStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtrlStructContext ctrlStruct() throws RecognitionException {
		CtrlStructContext _localctx = new CtrlStructContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ctrlStruct);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				aif();
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Elseif) {
					{
					{
					setState(261);
					aelseif();
					}
					}
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Else) {
					{
					setState(267);
					aelse();
					}
				}

				}
				break;
			case For:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				match(For);
				setState(271);
				match(Parenl);
				setState(274);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Type:
					{
					setState(272);
					dcl();
					}
					break;
				case Val:
				case BoolVal:
				case Parenl:
				case Not:
				case Name:
					{
					setState(273);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(276);
				_la = _input.LA(1);
				if ( !(_la==Upto || _la==Downto) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				{
				setState(277);
				expr(0);
				}
				setState(278);
				match(Parenr);
				setState(279);
				block();
				}
				break;
			case While:
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				match(While);
				setState(282);
				match(Parenl);
				setState(283);
				expr(0);
				setState(284);
				match(Parenr);
				setState(285);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AifContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(CFGParser.If, 0); }
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterAif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitAif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitAif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AifContext aif() throws RecognitionException {
		AifContext _localctx = new AifContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_aif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(If);
			setState(290);
			match(Parenl);
			setState(291);
			expr(0);
			setState(292);
			match(Parenr);
			setState(293);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AelseifContext extends ParserRuleContext {
		public TerminalNode Elseif() { return getToken(CFGParser.Elseif, 0); }
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AelseifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aelseif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterAelseif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitAelseif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitAelseif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AelseifContext aelseif() throws RecognitionException {
		AelseifContext _localctx = new AelseifContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_aelseif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(Elseif);
			setState(296);
			match(Parenl);
			setState(297);
			expr(0);
			setState(298);
			match(Parenr);
			setState(299);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AelseContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(CFGParser.Else, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aelse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterAelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitAelse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitAelse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AelseContext aelse() throws RecognitionException {
		AelseContext _localctx = new AelseContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_aelse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(Else);
			setState(302);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(CFGParser.Name, 0); }
		public TerminalNode Dot() { return getToken(CFGParser.Dot, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(Name);
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(305);
				match(Dot);
				setState(306);
				id();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0138\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3D\n\3\3\4\3\4\3\4\3\4\5\4J\n\4\3\4\3\4\3\4\7\4O\n\4\f\4\16\4"+
		"R\13\4\3\4\7\4U\n\4\f\4\16\4X\13\4\3\4\3\4\3\5\3\5\5\5^\n\5\3\6\3\6\3"+
		"\6\3\6\5\6d\n\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\7\bm\n\b\f\b\16\bp\13\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\5\tx\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0081"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u008d\n\f\f\f\16"+
		"\f\u0090\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u009b\n\r\f\r\16"+
		"\r\u009e\13\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a6\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b3\n\16\3\17\3\17\3\17\5\17"+
		"\u00b8\n\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00d0\n\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\7\21\u00e6\n\21\f\21\16\21\u00e9\13\21\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00f0\n\22\3\22\3\22\3\22\3\23\3\23\3\23\5\23"+
		"\u00f8\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\5\25"+
		"\u0105\n\25\3\26\3\26\7\26\u0109\n\26\f\26\16\26\u010c\13\26\3\26\5\26"+
		"\u010f\n\26\3\26\3\26\3\26\3\26\5\26\u0115\n\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0122\n\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\5\32\u0136\n\32\3\32\2\3 \33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 "+
		"\"$&(*,.\60\62\2\4\4\2\3\3))\3\2!\"\2\u0146\2\64\3\2\2\2\4C\3\2\2\2\6"+
		"E\3\2\2\2\b]\3\2\2\2\n_\3\2\2\2\fh\3\2\2\2\16j\3\2\2\2\20w\3\2\2\2\22"+
		"\u0080\3\2\2\2\24\u0082\3\2\2\2\26\u008e\3\2\2\2\30\u00a5\3\2\2\2\32\u00b2"+
		"\3\2\2\2\34\u00b4\3\2\2\2\36\u00bc\3\2\2\2 \u00cf\3\2\2\2\"\u00ea\3\2"+
		"\2\2$\u00f4\3\2\2\2&\u00fb\3\2\2\2(\u0101\3\2\2\2*\u0121\3\2\2\2,\u0123"+
		"\3\2\2\2.\u0129\3\2\2\2\60\u012f\3\2\2\2\62\u0132\3\2\2\2\648\5\24\13"+
		"\2\65\67\5\4\3\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2"+
		"\2\2:8\3\2\2\2;<\7/\2\2<\3\3\2\2\2=>\5\30\r\2>?\7\32\2\2?D\3\2\2\2@D\5"+
		"\n\6\2AD\5\6\4\2BD\5&\24\2C=\3\2\2\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2D\5"+
		"\3\2\2\2EF\7\'\2\2FG\5\62\32\2GI\7\36\2\2HJ\5\22\n\2IH\3\2\2\2IJ\3\2\2"+
		"\2JK\3\2\2\2KL\7\37\2\2LP\7\26\2\2MO\5\20\t\2NM\3\2\2\2OR\3\2\2\2PN\3"+
		"\2\2\2PQ\3\2\2\2QV\3\2\2\2RP\3\2\2\2SU\5\b\5\2TS\3\2\2\2UX\3\2\2\2VT\3"+
		"\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7\27\2\2Z\7\3\2\2\2[^\5\34\17\2"+
		"\\^\5\36\20\2][\3\2\2\2]\\\3\2\2\2^\t\3\2\2\2_`\5\f\7\2`a\5\62\32\2ac"+
		"\7\36\2\2bd\5\22\n\2cb\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7\37\2\2fg\5\16\b"+
		"\2g\13\3\2\2\2hi\t\2\2\2i\r\3\2\2\2jn\7\26\2\2km\5\20\t\2lk\3\2\2\2mp"+
		"\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7\27\2\2r\17\3\2\2"+
		"\2st\5\30\r\2tu\7\32\2\2ux\3\2\2\2vx\5\32\16\2ws\3\2\2\2wv\3\2\2\2x\21"+
		"\3\2\2\2yz\7\3\2\2z\u0081\5\62\32\2{|\7\3\2\2|}\5\62\32\2}~\7\30\2\2~"+
		"\177\5\22\n\2\177\u0081\3\2\2\2\u0080y\3\2\2\2\u0080{\3\2\2\2\u0081\23"+
		"\3\2\2\2\u0082\u0083\7\4\2\2\u0083\u0084\7\26\2\2\u0084\u0085\5\26\f\2"+
		"\u0085\u0086\7\27\2\2\u0086\25\3\2\2\2\u0087\u0088\5\62\32\2\u0088\u0089"+
		"\7\31\2\2\u0089\u008a\5\62\32\2\u008a\u008b\7\32\2\2\u008b\u008d\3\2\2"+
		"\2\u008c\u0087\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\27\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7\3\2\2\u0092"+
		"\u0093\5\62\32\2\u0093\u0094\7*\2\2\u0094\u0095\5 \21\2\u0095\u00a6\3"+
		"\2\2\2\u0096\u0097\7\3\2\2\u0097\u009c\5\62\32\2\u0098\u0099\7\30\2\2"+
		"\u0099\u009b\5\62\32\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a6\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a0\7\3\2\2\u00a0\u00a1\5\62\32\2\u00a1\u00a2\7\34\2\2\u00a2\u00a3"+
		"\5 \21\2\u00a3\u00a4\7\35\2\2\u00a4\u00a6\3\2\2\2\u00a5\u0091\3\2\2\2"+
		"\u00a5\u0096\3\2\2\2\u00a5\u009f\3\2\2\2\u00a6\31\3\2\2\2\u00a7\u00a8"+
		"\5\"\22\2\u00a8\u00a9\7\32\2\2\u00a9\u00b3\3\2\2\2\u00aa\u00ab\5$\23\2"+
		"\u00ab\u00ac\7\32\2\2\u00ac\u00b3\3\2\2\2\u00ad\u00b3\5*\26\2\u00ae\u00af"+
		"\7+\2\2\u00af\u00b0\5 \21\2\u00b0\u00b1\7\32\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u00a7\3\2\2\2\u00b2\u00aa\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b2\u00ae\3\2"+
		"\2\2\u00b3\33\3\2\2\2\u00b4\u00b5\7(\2\2\u00b5\u00b7\7\36\2\2\u00b6\u00b8"+
		"\5 \21\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\7\37\2\2\u00ba\u00bb\5\16\b\2\u00bb\35\3\2\2\2\u00bc\u00bd\7\5"+
		"\2\2\u00bd\u00be\7\36\2\2\u00be\u00bf\5\62\32\2\u00bf\u00c0\5\62\32\2"+
		"\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\37\2\2\u00c2\u00c3\5\16\b\2\u00c3\37"+
		"\3\2\2\2\u00c4\u00c5\b\21\1\2\u00c5\u00c6\7\36\2\2\u00c6\u00c7\5 \21\2"+
		"\u00c7\u00c8\7\37\2\2\u00c8\u00d0\3\2\2\2\u00c9\u00ca\7,\2\2\u00ca\u00d0"+
		"\5 \21\f\u00cb\u00d0\7\b\2\2\u00cc\u00d0\7\20\2\2\u00cd\u00d0\5\62\32"+
		"\2\u00ce\u00d0\5$\23\2\u00cf\u00c4\3\2\2\2\u00cf\u00c9\3\2\2\2\u00cf\u00cb"+
		"\3\2\2\2\u00cf\u00cc\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0"+
		"\u00e7\3\2\2\2\u00d1\u00d2\f\13\2\2\u00d2\u00d3\7\25\2\2\u00d3\u00e6\5"+
		" \21\13\u00d4\u00d5\f\n\2\2\u00d5\u00d6\7\n\2\2\u00d6\u00e6\5 \21\13\u00d7"+
		"\u00d8\f\t\2\2\u00d8\u00d9\7\t\2\2\u00d9\u00e6\5 \21\n\u00da\u00db\f\b"+
		"\2\2\u00db\u00dc\7\21\2\2\u00dc\u00e6\5 \21\t\u00dd\u00de\f\7\2\2\u00de"+
		"\u00df\7\22\2\2\u00df\u00e6\5 \21\b\u00e0\u00e1\f\r\2\2\u00e1\u00e2\7"+
		"\34\2\2\u00e2\u00e3\5 \21\2\u00e3\u00e4\7\35\2\2\u00e4\u00e6\3\2\2\2\u00e5"+
		"\u00d1\3\2\2\2\u00e5\u00d4\3\2\2\2\u00e5\u00d7\3\2\2\2\u00e5\u00da\3\2"+
		"\2\2\u00e5\u00dd\3\2\2\2\u00e5\u00e0\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8!\3\2\2\2\u00e9\u00e7\3\2\2\2"+
		"\u00ea\u00ef\5\62\32\2\u00eb\u00ec\7\34\2\2\u00ec\u00ed\5 \21\2\u00ed"+
		"\u00ee\7\35\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00eb\3\2\2\2\u00ef\u00f0\3"+
		"\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\7*\2\2\u00f2\u00f3\5 \21\2\u00f3"+
		"#\3\2\2\2\u00f4\u00f5\5\62\32\2\u00f5\u00f7\7\36\2\2\u00f6\u00f8\5(\25"+
		"\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa"+
		"\7\37\2\2\u00fa%\3\2\2\2\u00fb\u00fc\7-\2\2\u00fc\u00fd\5\62\32\2\u00fd"+
		"\u00fe\7\36\2\2\u00fe\u00ff\7\37\2\2\u00ff\u0100\5\16\b\2\u0100\'\3\2"+
		"\2\2\u0101\u0104\5 \21\2\u0102\u0103\7\30\2\2\u0103\u0105\5(\25\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105)\3\2\2\2\u0106\u010a\5,\27\2"+
		"\u0107\u0109\5.\30\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108"+
		"\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010d"+
		"\u010f\5\60\31\2\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0122\3"+
		"\2\2\2\u0110\u0111\7 \2\2\u0111\u0114\7\36\2\2\u0112\u0115\5\30\r\2\u0113"+
		"\u0115\5 \21\2\u0114\u0112\3\2\2\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0117\t\3\2\2\u0117\u0118\5 \21\2\u0118\u0119\7\37\2\2\u0119"+
		"\u011a\5\16\b\2\u011a\u0122\3\2\2\2\u011b\u011c\7#\2\2\u011c\u011d\7\36"+
		"\2\2\u011d\u011e\5 \21\2\u011e\u011f\7\37\2\2\u011f\u0120\5\16\b\2\u0120"+
		"\u0122\3\2\2\2\u0121\u0106\3\2\2\2\u0121\u0110\3\2\2\2\u0121\u011b\3\2"+
		"\2\2\u0122+\3\2\2\2\u0123\u0124\7$\2\2\u0124\u0125\7\36\2\2\u0125\u0126"+
		"\5 \21\2\u0126\u0127\7\37\2\2\u0127\u0128\5\16\b\2\u0128-\3\2\2\2\u0129"+
		"\u012a\7%\2\2\u012a\u012b\7\36\2\2\u012b\u012c\5 \21\2\u012c\u012d\7\37"+
		"\2\2\u012d\u012e\5\16\b\2\u012e/\3\2\2\2\u012f\u0130\7&\2\2\u0130\u0131"+
		"\5\16\b\2\u0131\61\3\2\2\2\u0132\u0135\7.\2\2\u0133\u0134\7\33\2\2\u0134"+
		"\u0136\5\62\32\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\63\3\2"+
		"\2\2\348CIPV]cnw\u0080\u008e\u009c\u00a5\u00b2\u00b7\u00cf\u00e5\u00e7"+
		"\u00ef\u00f7\u0104\u010a\u010e\u0114\u0121\u0135";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}