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
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public List<TerminalNode> SemiColon() { return getTokens(CFGParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(CFGParser.SemiColon, i);
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
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Type) {
				{
				{
				setState(75);
				dcl();
				setState(76);
				match(SemiColon);
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==When || _la==Routine) {
				{
				{
				setState(83);
				strategyBlock();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
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
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Routine:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				routine();
				}
				break;
			case When:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
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
			setState(95);
			funcType();
			setState(96);
			id();
			setState(97);
			match(Parenl);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(98);
				fParamList();
				}
			}

			setState(101);
			match(Parenr);
			setState(102);
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
			setState(104);
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
			setState(106);
			match(Scopel);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type) | (1L << For) | (1L << While) | (1L << If) | (1L << Return) | (1L << Name))) != 0)) {
				{
				{
				setState(107);
				blockBody();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
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
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Type:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				dcl();
				setState(116);
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
				setState(118);
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
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(Type);
				setState(122);
				id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(Type);
				setState(124);
				id();
				setState(125);
				match(Comma);
				setState(126);
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
			setState(130);
			match(RobotProperties);
			setState(131);
			match(Scopel);
			setState(132);
			robotDclBody();
			setState(133);
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
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Name) {
				{
				{
				setState(135);
				id();
				setState(136);
				match(Colon);
				setState(137);
				id();
				setState(138);
				match(SemiColon);
				}
				}
				setState(144);
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
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(Type);
				setState(146);
				id();
				setState(147);
				match(Assign);
				setState(148);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(Type);
				setState(151);
				id();
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(152);
					match(Comma);
					setState(153);
					id();
					}
					}
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				match(Type);
				setState(160);
				id();
				setState(161);
				match(Squarel);
				setState(162);
				expr(0);
				setState(163);
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
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				assignStmt();
				setState(168);
				match(SemiColon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				funcCall();
				setState(171);
				match(SemiColon);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				ctrlStruct();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				match(Return);
				setState(175);
				expr(0);
				setState(176);
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
			setState(180);
			match(Routine);
			setState(181);
			match(Parenl);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Val) | (1L << BoolVal) | (1L << Parenl) | (1L << Not) | (1L << Name))) != 0)) {
				{
				setState(182);
				expr(0);
				}
			}

			setState(185);
			match(Parenr);
			setState(186);
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
			setState(188);
			match(When);
			setState(189);
			match(Parenl);
			{
			setState(190);
			id();
			setState(191);
			id();
			}
			setState(193);
			match(Parenr);
			setState(194);
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
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(197);
				match(Parenl);
				setState(198);
				expr(0);
				setState(199);
				match(Parenr);
				}
				break;
			case 2:
				{
				setState(201);
				match(Not);
				setState(202);
				expr(10);
				}
				break;
			case 3:
				{
				setState(203);
				match(Val);
				}
				break;
			case 4:
				{
				setState(204);
				match(BoolVal);
				}
				break;
			case 5:
				{
				setState(205);
				id();
				}
				break;
			case 6:
				{
				setState(206);
				funcCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(229);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(210);
						match(Hat);
						setState(211);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(212);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(213);
						match(MultiOp);
						setState(214);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(216);
						match(AdditiveOp);
						setState(217);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(218);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(219);
						match(RelativeOp);
						setState(220);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(221);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(222);
						match(BoolOp);
						setState(223);
						expr(6);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(225);
						match(Squarel);
						setState(226);
						expr(0);
						setState(227);
						match(Squarer);
						}
						break;
					}
					} 
				}
				setState(233);
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
			setState(234);
			id();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Squarel) {
				{
				setState(235);
				match(Squarel);
				setState(236);
				expr(0);
				setState(237);
				match(Squarer);
				}
			}

			setState(241);
			match(Assign);
			setState(242);
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
			setState(244);
			id();
			setState(245);
			match(Parenl);
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Val) | (1L << BoolVal) | (1L << Parenl) | (1L << Not) | (1L << Name))) != 0)) {
				{
				setState(246);
				aParamList();
				}
			}

			setState(249);
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
			setState(251);
			match(Event);
			setState(252);
			id();
			setState(253);
			match(Parenl);
			setState(254);
			match(Parenr);
			setState(255);
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
			setState(257);
			expr(0);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(258);
				match(Comma);
				setState(259);
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
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				aif();
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Elseif) {
					{
					{
					setState(263);
					aelseif();
					}
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Else) {
					{
					setState(269);
					aelse();
					}
				}

				}
				break;
			case For:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(For);
				setState(273);
				match(Parenl);
				setState(276);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Type:
					{
					setState(274);
					dcl();
					}
					break;
				case Val:
				case BoolVal:
				case Parenl:
				case Not:
				case Name:
					{
					setState(275);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(278);
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
				setState(279);
				expr(0);
				}
				setState(280);
				match(Parenr);
				setState(281);
				block();
				}
				break;
			case While:
				enterOuterAlt(_localctx, 3);
				{
				setState(283);
				match(While);
				setState(284);
				match(Parenl);
				setState(285);
				expr(0);
				setState(286);
				match(Parenr);
				setState(287);
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
			setState(291);
			match(If);
			setState(292);
			match(Parenl);
			setState(293);
			expr(0);
			setState(294);
			match(Parenr);
			setState(295);
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
			setState(297);
			match(Elseif);
			setState(298);
			match(Parenl);
			setState(299);
			expr(0);
			setState(300);
			match(Parenr);
			setState(301);
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
			setState(303);
			match(Else);
			setState(304);
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
			setState(306);
			match(Name);
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(307);
				match(Dot);
				setState(308);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u013a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3D\n\3\3\4\3\4\3\4\3\4\5\4J\n\4\3\4\3\4\3\4\3\4\3\4\7\4Q\n\4"+
		"\f\4\16\4T\13\4\3\4\7\4W\n\4\f\4\16\4Z\13\4\3\4\3\4\3\5\3\5\5\5`\n\5\3"+
		"\6\3\6\3\6\3\6\5\6f\n\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\7\bo\n\b\f\b\16\b"+
		"r\13\b\3\b\3\b\3\t\3\t\3\t\3\t\5\tz\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\n\u0083\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u008f\n"+
		"\f\f\f\16\f\u0092\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u009d\n"+
		"\r\f\r\16\r\u00a0\13\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a8\n\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b5\n\16\3\17\3\17"+
		"\3\17\5\17\u00ba\n\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00d2"+
		"\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00e8\n\21\f\21\16\21\u00eb\13"+
		"\21\3\22\3\22\3\22\3\22\3\22\5\22\u00f2\n\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\5\23\u00fa\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\5\25\u0107\n\25\3\26\3\26\7\26\u010b\n\26\f\26\16\26\u010e\13\26"+
		"\3\26\5\26\u0111\n\26\3\26\3\26\3\26\3\26\5\26\u0117\n\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0124\n\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\5\32\u0138\n\32\3\32\2\3 \33\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\2\4\4\2\3\3))\3\2!\"\2\u0148\2\64\3\2\2\2\4C"+
		"\3\2\2\2\6E\3\2\2\2\b_\3\2\2\2\na\3\2\2\2\fj\3\2\2\2\16l\3\2\2\2\20y\3"+
		"\2\2\2\22\u0082\3\2\2\2\24\u0084\3\2\2\2\26\u0090\3\2\2\2\30\u00a7\3\2"+
		"\2\2\32\u00b4\3\2\2\2\34\u00b6\3\2\2\2\36\u00be\3\2\2\2 \u00d1\3\2\2\2"+
		"\"\u00ec\3\2\2\2$\u00f6\3\2\2\2&\u00fd\3\2\2\2(\u0103\3\2\2\2*\u0123\3"+
		"\2\2\2,\u0125\3\2\2\2.\u012b\3\2\2\2\60\u0131\3\2\2\2\62\u0134\3\2\2\2"+
		"\648\5\24\13\2\65\67\5\4\3\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3"+
		"\2\2\29;\3\2\2\2:8\3\2\2\2;<\7/\2\2<\3\3\2\2\2=>\5\30\r\2>?\7\32\2\2?"+
		"D\3\2\2\2@D\5\n\6\2AD\5\6\4\2BD\5&\24\2C=\3\2\2\2C@\3\2\2\2CA\3\2\2\2"+
		"CB\3\2\2\2D\5\3\2\2\2EF\7\'\2\2FG\5\62\32\2GI\7\36\2\2HJ\5\22\n\2IH\3"+
		"\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\37\2\2LR\7\26\2\2MN\5\30\r\2NO\7\32\2\2"+
		"OQ\3\2\2\2PM\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SX\3\2\2\2TR\3\2\2\2"+
		"UW\5\b\5\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2"+
		"[\\\7\27\2\2\\\7\3\2\2\2]`\5\34\17\2^`\5\36\20\2_]\3\2\2\2_^\3\2\2\2`"+
		"\t\3\2\2\2ab\5\f\7\2bc\5\62\32\2ce\7\36\2\2df\5\22\n\2ed\3\2\2\2ef\3\2"+
		"\2\2fg\3\2\2\2gh\7\37\2\2hi\5\16\b\2i\13\3\2\2\2jk\t\2\2\2k\r\3\2\2\2"+
		"lp\7\26\2\2mo\5\20\t\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2"+
		"\2rp\3\2\2\2st\7\27\2\2t\17\3\2\2\2uv\5\30\r\2vw\7\32\2\2wz\3\2\2\2xz"+
		"\5\32\16\2yu\3\2\2\2yx\3\2\2\2z\21\3\2\2\2{|\7\3\2\2|\u0083\5\62\32\2"+
		"}~\7\3\2\2~\177\5\62\32\2\177\u0080\7\30\2\2\u0080\u0081\5\22\n\2\u0081"+
		"\u0083\3\2\2\2\u0082{\3\2\2\2\u0082}\3\2\2\2\u0083\23\3\2\2\2\u0084\u0085"+
		"\7\4\2\2\u0085\u0086\7\26\2\2\u0086\u0087\5\26\f\2\u0087\u0088\7\27\2"+
		"\2\u0088\25\3\2\2\2\u0089\u008a\5\62\32\2\u008a\u008b\7\31\2\2\u008b\u008c"+
		"\5\62\32\2\u008c\u008d\7\32\2\2\u008d\u008f\3\2\2\2\u008e\u0089\3\2\2"+
		"\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\27"+
		"\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7\3\2\2\u0094\u0095\5\62\32\2"+
		"\u0095\u0096\7*\2\2\u0096\u0097\5 \21\2\u0097\u00a8\3\2\2\2\u0098\u0099"+
		"\7\3\2\2\u0099\u009e\5\62\32\2\u009a\u009b\7\30\2\2\u009b\u009d\5\62\32"+
		"\2\u009c\u009a\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f"+
		"\3\2\2\2\u009f\u00a8\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7\3\2\2\u00a2"+
		"\u00a3\5\62\32\2\u00a3\u00a4\7\34\2\2\u00a4\u00a5\5 \21\2\u00a5\u00a6"+
		"\7\35\2\2\u00a6\u00a8\3\2\2\2\u00a7\u0093\3\2\2\2\u00a7\u0098\3\2\2\2"+
		"\u00a7\u00a1\3\2\2\2\u00a8\31\3\2\2\2\u00a9\u00aa\5\"\22\2\u00aa\u00ab"+
		"\7\32\2\2\u00ab\u00b5\3\2\2\2\u00ac\u00ad\5$\23\2\u00ad\u00ae\7\32\2\2"+
		"\u00ae\u00b5\3\2\2\2\u00af\u00b5\5*\26\2\u00b0\u00b1\7+\2\2\u00b1\u00b2"+
		"\5 \21\2\u00b2\u00b3\7\32\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00a9\3\2\2\2"+
		"\u00b4\u00ac\3\2\2\2\u00b4\u00af\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b5\33"+
		"\3\2\2\2\u00b6\u00b7\7(\2\2\u00b7\u00b9\7\36\2\2\u00b8\u00ba\5 \21\2\u00b9"+
		"\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\37"+
		"\2\2\u00bc\u00bd\5\16\b\2\u00bd\35\3\2\2\2\u00be\u00bf\7\5\2\2\u00bf\u00c0"+
		"\7\36\2\2\u00c0\u00c1\5\62\32\2\u00c1\u00c2\5\62\32\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c4\7\37\2\2\u00c4\u00c5\5\16\b\2\u00c5\37\3\2\2\2\u00c6"+
		"\u00c7\b\21\1\2\u00c7\u00c8\7\36\2\2\u00c8\u00c9\5 \21\2\u00c9\u00ca\7"+
		"\37\2\2\u00ca\u00d2\3\2\2\2\u00cb\u00cc\7,\2\2\u00cc\u00d2\5 \21\f\u00cd"+
		"\u00d2\7\b\2\2\u00ce\u00d2\7\20\2\2\u00cf\u00d2\5\62\32\2\u00d0\u00d2"+
		"\5$\23\2\u00d1\u00c6\3\2\2\2\u00d1\u00cb\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d1"+
		"\u00ce\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00e9\3\2"+
		"\2\2\u00d3\u00d4\f\13\2\2\u00d4\u00d5\7\25\2\2\u00d5\u00e8\5 \21\13\u00d6"+
		"\u00d7\f\n\2\2\u00d7\u00d8\7\n\2\2\u00d8\u00e8\5 \21\13\u00d9\u00da\f"+
		"\t\2\2\u00da\u00db\7\t\2\2\u00db\u00e8\5 \21\n\u00dc\u00dd\f\b\2\2\u00dd"+
		"\u00de\7\21\2\2\u00de\u00e8\5 \21\t\u00df\u00e0\f\7\2\2\u00e0\u00e1\7"+
		"\22\2\2\u00e1\u00e8\5 \21\b\u00e2\u00e3\f\r\2\2\u00e3\u00e4\7\34\2\2\u00e4"+
		"\u00e5\5 \21\2\u00e5\u00e6\7\35\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00d3\3"+
		"\2\2\2\u00e7\u00d6\3\2\2\2\u00e7\u00d9\3\2\2\2\u00e7\u00dc\3\2\2\2\u00e7"+
		"\u00df\3\2\2\2\u00e7\u00e2\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea!\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00f1"+
		"\5\62\32\2\u00ed\u00ee\7\34\2\2\u00ee\u00ef\5 \21\2\u00ef\u00f0\7\35\2"+
		"\2\u00f0\u00f2\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3"+
		"\3\2\2\2\u00f3\u00f4\7*\2\2\u00f4\u00f5\5 \21\2\u00f5#\3\2\2\2\u00f6\u00f7"+
		"\5\62\32\2\u00f7\u00f9\7\36\2\2\u00f8\u00fa\5(\25\2\u00f9\u00f8\3\2\2"+
		"\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\7\37\2\2\u00fc"+
		"%\3\2\2\2\u00fd\u00fe\7-\2\2\u00fe\u00ff\5\62\32\2\u00ff\u0100\7\36\2"+
		"\2\u0100\u0101\7\37\2\2\u0101\u0102\5\16\b\2\u0102\'\3\2\2\2\u0103\u0106"+
		"\5 \21\2\u0104\u0105\7\30\2\2\u0105\u0107\5(\25\2\u0106\u0104\3\2\2\2"+
		"\u0106\u0107\3\2\2\2\u0107)\3\2\2\2\u0108\u010c\5,\27\2\u0109\u010b\5"+
		".\30\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0111\5\60"+
		"\31\2\u0110\u010f\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0124\3\2\2\2\u0112"+
		"\u0113\7 \2\2\u0113\u0116\7\36\2\2\u0114\u0117\5\30\r\2\u0115\u0117\5"+
		" \21\2\u0116\u0114\3\2\2\2\u0116\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u0119\t\3\2\2\u0119\u011a\5 \21\2\u011a\u011b\7\37\2\2\u011b\u011c\5"+
		"\16\b\2\u011c\u0124\3\2\2\2\u011d\u011e\7#\2\2\u011e\u011f\7\36\2\2\u011f"+
		"\u0120\5 \21\2\u0120\u0121\7\37\2\2\u0121\u0122\5\16\b\2\u0122\u0124\3"+
		"\2\2\2\u0123\u0108\3\2\2\2\u0123\u0112\3\2\2\2\u0123\u011d\3\2\2\2\u0124"+
		"+\3\2\2\2\u0125\u0126\7$\2\2\u0126\u0127\7\36\2\2\u0127\u0128\5 \21\2"+
		"\u0128\u0129\7\37\2\2\u0129\u012a\5\16\b\2\u012a-\3\2\2\2\u012b\u012c"+
		"\7%\2\2\u012c\u012d\7\36\2\2\u012d\u012e\5 \21\2\u012e\u012f\7\37\2\2"+
		"\u012f\u0130\5\16\b\2\u0130/\3\2\2\2\u0131\u0132\7&\2\2\u0132\u0133\5"+
		"\16\b\2\u0133\61\3\2\2\2\u0134\u0137\7.\2\2\u0135\u0136\7\33\2\2\u0136"+
		"\u0138\5\62\32\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\63\3\2"+
		"\2\2\348CIRX_epy\u0082\u0090\u009e\u00a7\u00b4\u00b9\u00d1\u00e7\u00e9"+
		"\u00f1\u00f9\u0106\u010c\u0110\u0116\u0123\u0137";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}