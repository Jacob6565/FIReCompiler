// Generated from C:/Users/TobiasW/IdeaProjects/FIReCompiler/src/FIRe/Antlr\CFG.g4 by ANTLR 4.7
package FIRe.Parser.FIRe.Antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CFGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RobotProperty=1, RobotTypeVal=2, ColorVal=3, Type=4, RobotProperties=5, 
		RobotName=6, RobotType=7, When=8, EType=9, SingleLineComment=10, MultiLineComment=11, 
		WhiteSpace=12, Val=13, AdditiveOp=14, MultiOp=15, Plus=16, Minus=17, Times=18, 
		Divide=19, Modulo=20, BoolVal=21, RelativeOp=22, BoolOp=23, TRUE=24, FALSE=25, 
		Hat=26, Scopel=27, Scoper=28, Comma=29, Colon=30, SemiColon=31, Dot=32, 
		Squarel=33, Squarer=34, Parenl=35, Parenr=36, For=37, Upto=38, Downto=39, 
		While=40, If=41, Elseif=42, Else=43, Strategy=44, Routine=45, Void=46, 
		Assign=47, Return=48, Not=49, Condition=50, Name=51;
	public static final int
		RULE_prog = 0, RULE_strategydcl = 1, RULE_funcDcl = 2, RULE_funcType = 3, 
		RULE_funcBody = 4, RULE_fParamList = 5, RULE_robotDcl = 6, RULE_robotDclBody = 7, 
		RULE_dcl = 8, RULE_stmt = 9, RULE_routine = 10, RULE_when = 11, RULE_expr = 12, 
		RULE_assignStmt = 13, RULE_funcCall = 14, RULE_conditionDcl = 15, RULE_aParamList = 16, 
		RULE_ctrlStruct = 17, RULE_aif = 18, RULE_aelseif = 19, RULE_aelse = 20, 
		RULE_eParam = 21, RULE_id = 22;
	public static final String[] ruleNames = {
		"prog", "strategydcl", "funcDcl", "funcType", "funcBody", "fParamList", 
		"robotDcl", "robotDclBody", "dcl", "stmt", "routine", "when", "expr", 
		"assignStmt", "funcCall", "conditionDcl", "aParamList", "ctrlStruct", 
		"aif", "aelseif", "aelse", "eParam", "id"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'RobotProperties'", "'RobotName'", "'RobotType'", 
		"'when'", null, null, null, null, null, null, null, "'+'", "'-'", "'*'", 
		"'/'", "'%'", null, null, null, "'true'", "'false'", "'^'", "'{'", "'}'", 
		"','", "':'", "';'", "'.'", "'['", "']'", "'('", "')'", "'for'", "'upto'", 
		"'downto'", "'while'", "'if'", "'else if'", "'else'", "'strategy'", "'routine'", 
		"'void'", "'='", "'return'", "'!'", "'condition'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "RobotProperty", "RobotTypeVal", "ColorVal", "Type", "RobotProperties", 
		"RobotName", "RobotType", "When", "EType", "SingleLineComment", "MultiLineComment", 
		"WhiteSpace", "Val", "AdditiveOp", "MultiOp", "Plus", "Minus", "Times", 
		"Divide", "Modulo", "BoolVal", "RelativeOp", "BoolOp", "TRUE", "FALSE", 
		"Hat", "Scopel", "Scoper", "Comma", "Colon", "SemiColon", "Dot", "Squarel", 
		"Squarer", "Parenl", "Parenr", "For", "Upto", "Downto", "While", "If", 
		"Elseif", "Else", "Strategy", "Routine", "Void", "Assign", "Return", "Not", 
		"Condition", "Name"
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
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public List<FuncDclContext> funcDcl() {
			return getRuleContexts(FuncDclContext.class);
		}
		public FuncDclContext funcDcl(int i) {
			return getRuleContext(FuncDclContext.class,i);
		}
		public List<StrategydclContext> strategydcl() {
			return getRuleContexts(StrategydclContext.class);
		}
		public StrategydclContext strategydcl(int i) {
			return getRuleContext(StrategydclContext.class,i);
		}
		public List<ConditionDclContext> conditionDcl() {
			return getRuleContexts(ConditionDclContext.class);
		}
		public ConditionDclContext conditionDcl(int i) {
			return getRuleContext(ConditionDclContext.class,i);
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
			setState(46);
			robotDcl();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type) | (1L << Strategy) | (1L << Void) | (1L << Condition))) != 0)) {
				{
				setState(51);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(47);
					dcl();
					}
					break;
				case 2:
					{
					setState(48);
					funcDcl();
					}
					break;
				case 3:
					{
					setState(49);
					strategydcl();
					}
					break;
				case 4:
					{
					setState(50);
					conditionDcl();
					}
					break;
				}
				}
				setState(55);
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

	public static class StrategydclContext extends ParserRuleContext {
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
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<RoutineContext> routine() {
			return getRuleContexts(RoutineContext.class);
		}
		public RoutineContext routine(int i) {
			return getRuleContext(RoutineContext.class,i);
		}
		public List<WhenContext> when() {
			return getRuleContexts(WhenContext.class);
		}
		public WhenContext when(int i) {
			return getRuleContext(WhenContext.class,i);
		}
		public StrategydclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategydcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterStrategydcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitStrategydcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitStrategydcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategydclContext strategydcl() throws RecognitionException {
		StrategydclContext _localctx = new StrategydclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_strategydcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(Strategy);
			setState(57);
			id();
			setState(58);
			match(Parenl);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(59);
				fParamList();
				}
			}

			setState(62);
			match(Parenr);
			setState(63);
			match(Scopel);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type) | (1L << When) | (1L << For) | (1L << While) | (1L << If) | (1L << Routine) | (1L << Return) | (1L << Name))) != 0)) {
				{
				setState(68);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(64);
					dcl();
					}
					break;
				case 2:
					{
					setState(65);
					stmt();
					}
					break;
				case 3:
					{
					setState(66);
					routine();
					}
					break;
				case 4:
					{
					setState(67);
					when();
					}
					break;
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
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

	public static class FuncDclContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
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
		enterRule(_localctx, 4, RULE_funcDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			funcType();
			setState(76);
			id();
			setState(77);
			match(Parenl);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(78);
				fParamList();
				}
			}

			setState(81);
			match(Parenr);
			setState(82);
			funcBody();
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
		enterRule(_localctx, 6, RULE_funcType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
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

	public static class FuncBodyContext extends ParserRuleContext {
		public TerminalNode Scopel() { return getToken(CFGParser.Scopel, 0); }
		public TerminalNode Scoper() { return getToken(CFGParser.Scoper, 0); }
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public FuncBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterFuncBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitFuncBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitFuncBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncBodyContext funcBody() throws RecognitionException {
		FuncBodyContext _localctx = new FuncBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(Scopel);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type) | (1L << For) | (1L << While) | (1L << If) | (1L << Routine) | (1L << Return) | (1L << Name))) != 0)) {
				{
				setState(89);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Type:
					{
					setState(87);
					dcl();
					}
					break;
				case For:
				case While:
				case If:
				case Routine:
				case Return:
				case Name:
					{
					setState(88);
					stmt();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
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
		enterRule(_localctx, 10, RULE_fParamList);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(Type);
				setState(97);
				id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(Type);
				setState(99);
				id();
				setState(100);
				match(Comma);
				setState(101);
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
		enterRule(_localctx, 12, RULE_robotDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(RobotProperties);
			setState(106);
			match(Scopel);
			setState(107);
			robotDclBody();
			setState(108);
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
		public TerminalNode RobotName() { return getToken(CFGParser.RobotName, 0); }
		public List<TerminalNode> Colon() { return getTokens(CFGParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(CFGParser.Colon, i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<TerminalNode> SemiColon() { return getTokens(CFGParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(CFGParser.SemiColon, i);
		}
		public TerminalNode RobotType() { return getToken(CFGParser.RobotType, 0); }
		public TerminalNode RobotTypeVal() { return getToken(CFGParser.RobotTypeVal, 0); }
		public List<TerminalNode> RobotProperty() { return getTokens(CFGParser.RobotProperty); }
		public TerminalNode RobotProperty(int i) {
			return getToken(CFGParser.RobotProperty, i);
		}
		public List<TerminalNode> ColorVal() { return getTokens(CFGParser.ColorVal); }
		public TerminalNode ColorVal(int i) {
			return getToken(CFGParser.ColorVal, i);
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
		enterRule(_localctx, 14, RULE_robotDclBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(RobotName);
			setState(111);
			match(Colon);
			setState(112);
			id();
			setState(113);
			match(SemiColon);
			setState(114);
			match(RobotType);
			setState(115);
			match(Colon);
			setState(116);
			match(RobotTypeVal);
			setState(117);
			match(SemiColon);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RobotProperty) {
				{
				{
				setState(118);
				match(RobotProperty);
				setState(119);
				match(Colon);
				setState(120);
				match(ColorVal);
				setState(121);
				match(SemiColon);
				}
				}
				setState(126);
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
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public List<TerminalNode> Comma() { return getTokens(CFGParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CFGParser.Comma, i);
		}
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
		enterRule(_localctx, 16, RULE_dcl);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(Type);
				setState(128);
				id();
				setState(129);
				match(Assign);
				setState(130);
				expr(0);
				setState(131);
				match(SemiColon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(Type);
				setState(134);
				id();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(135);
					match(Comma);
					setState(136);
					id();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(142);
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
		enterRule(_localctx, 18, RULE_stmt);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				assignStmt();
				setState(147);
				match(SemiColon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				funcCall();
				setState(150);
				match(SemiColon);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				ctrlStruct();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				match(Return);
				setState(154);
				expr(0);
				setState(155);
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
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public TerminalNode Val() { return getToken(CFGParser.Val, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
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
		enterRule(_localctx, 20, RULE_routine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(Routine);
			setState(160);
			match(Parenl);
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Val:
				{
				setState(161);
				match(Val);
				}
				break;
			case Name:
				{
				setState(162);
				id();
				}
				break;
			case Parenr:
				break;
			default:
				break;
			}
			setState(165);
			match(Parenr);
			setState(166);
			funcBody();
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
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public EParamContext eParam() {
			return getRuleContext(EParamContext.class,0);
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
		enterRule(_localctx, 22, RULE_when);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(When);
			setState(169);
			match(Parenl);
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EType:
				{
				setState(170);
				eParam();
				}
				break;
			case Name:
				{
				setState(171);
				id();
				setState(172);
				id();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(176);
			match(Parenr);
			setState(177);
			funcBody();
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(180);
				match(Parenl);
				setState(181);
				expr(0);
				setState(182);
				match(Parenr);
				}
				break;
			case 2:
				{
				setState(184);
				match(Not);
				setState(185);
				expr(10);
				}
				break;
			case 3:
				{
				setState(186);
				match(Val);
				}
				break;
			case 4:
				{
				setState(187);
				match(BoolVal);
				}
				break;
			case 5:
				{
				setState(188);
				id();
				}
				break;
			case 6:
				{
				setState(189);
				funcCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(207);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(192);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(193);
						match(Hat);
						setState(194);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(195);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(196);
						match(MultiOp);
						setState(197);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(199);
						match(AdditiveOp);
						setState(200);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(202);
						match(RelativeOp);
						setState(203);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(204);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(205);
						match(BoolOp);
						setState(206);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(211);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			id();
			setState(213);
			match(Assign);
			setState(214);
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
		enterRule(_localctx, 28, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			id();
			setState(217);
			match(Parenl);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Val) | (1L << BoolVal) | (1L << Parenl) | (1L << Not) | (1L << Name))) != 0)) {
				{
				setState(218);
				aParamList();
				}
			}

			setState(221);
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

	public static class ConditionDclContext extends ParserRuleContext {
		public TerminalNode Condition() { return getToken(CFGParser.Condition, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode Parenl() { return getToken(CFGParser.Parenl, 0); }
		public TerminalNode Parenr() { return getToken(CFGParser.Parenr, 0); }
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public FParamListContext fParamList() {
			return getRuleContext(FParamListContext.class,0);
		}
		public ConditionDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterConditionDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitConditionDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitConditionDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionDclContext conditionDcl() throws RecognitionException {
		ConditionDclContext _localctx = new ConditionDclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conditionDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(Condition);
			setState(224);
			id();
			setState(225);
			match(Parenl);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(226);
				fParamList();
				}
			}

			setState(229);
			match(Parenr);
			setState(230);
			funcBody();
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
		enterRule(_localctx, 32, RULE_aParamList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			expr(0);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(233);
				match(Comma);
				setState(234);
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
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public TerminalNode Upto() { return getToken(CFGParser.Upto, 0); }
		public TerminalNode Downto() { return getToken(CFGParser.Downto, 0); }
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public List<TerminalNode> Val() { return getTokens(CFGParser.Val); }
		public TerminalNode Val(int i) {
			return getToken(CFGParser.Val, i);
		}
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public TerminalNode While() { return getToken(CFGParser.While, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RoutineContext routine() {
			return getRuleContext(RoutineContext.class,0);
		}
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
		enterRule(_localctx, 34, RULE_ctrlStruct);
		int _la;
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				aif();
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Elseif) {
					{
					{
					setState(238);
					aelseif();
					}
					}
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Else) {
					{
					setState(244);
					aelse();
					}
				}

				}
				break;
			case For:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(For);
				setState(248);
				match(Parenl);
				setState(252);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Type:
					{
					setState(249);
					dcl();
					}
					break;
				case Val:
					{
					setState(250);
					match(Val);
					}
					break;
				case Name:
					{
					setState(251);
					id();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(254);
				_la = _input.LA(1);
				if ( !(_la==Upto || _la==Downto) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(257);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Val:
					{
					setState(255);
					match(Val);
					}
					break;
				case Name:
					{
					setState(256);
					id();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(259);
				match(Parenr);
				setState(260);
				funcBody();
				}
				break;
			case While:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				match(While);
				setState(262);
				match(Parenl);
				setState(263);
				expr(0);
				setState(264);
				match(Parenr);
				setState(265);
				funcBody();
				}
				break;
			case Routine:
				enterOuterAlt(_localctx, 4);
				{
				setState(267);
				routine();
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
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
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
		enterRule(_localctx, 36, RULE_aif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(If);
			setState(271);
			match(Parenl);
			setState(272);
			expr(0);
			setState(273);
			match(Parenr);
			setState(274);
			funcBody();
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
		public List<TerminalNode> Parenl() { return getTokens(CFGParser.Parenl); }
		public TerminalNode Parenl(int i) {
			return getToken(CFGParser.Parenl, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
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
		enterRule(_localctx, 38, RULE_aelseif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(Elseif);
			setState(277);
			match(Parenl);
			setState(278);
			expr(0);
			setState(279);
			match(Parenl);
			setState(280);
			funcBody();
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
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
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
		enterRule(_localctx, 40, RULE_aelse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(Else);
			setState(283);
			funcBody();
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

	public static class EParamContext extends ParserRuleContext {
		public TerminalNode EType() { return getToken(CFGParser.EType, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public EParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterEParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitEParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitEParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EParamContext eParam() throws RecognitionException {
		EParamContext _localctx = new EParamContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_eParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(EType);
			setState(286);
			id();
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
		public TerminalNode Squarel() { return getToken(CFGParser.Squarel, 0); }
		public TerminalNode Val() { return getToken(CFGParser.Val, 0); }
		public TerminalNode Squarer() { return getToken(CFGParser.Squarer, 0); }
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
		enterRule(_localctx, 44, RULE_id);
		try {
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(Name);
				setState(291);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(289);
					match(Dot);
					setState(290);
					id();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				match(Name);
				setState(294);
				match(Squarel);
				setState(295);
				match(Val);
				setState(296);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u012e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\3\2\7\2\66\n\2\f\2\16\29\13\2\3\3\3\3\3\3\3\3\5\3?\n\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\7\3G\n\3\f\3\16\3J\13\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4R"+
		"\n\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6\\\n\6\f\6\16\6_\13\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7j\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t}\n\t\f\t\16\t\u0080\13\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u008c\n\n\f\n\16\n\u008f\13\n"+
		"\3\n\3\n\5\n\u0093\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u00a0\n\13\3\f\3\f\3\f\3\f\5\f\u00a6\n\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u00b1\n\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c1\n\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00d2\n\16\f\16"+
		"\16\16\u00d5\13\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u00de\n\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00e6\n\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\5\22\u00ee\n\22\3\23\3\23\7\23\u00f2\n\23\f\23\16\23\u00f5\13\23"+
		"\3\23\5\23\u00f8\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u00ff\n\23\3\23\3"+
		"\23\3\23\5\23\u0104\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u010f\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\5\30\u0126\n\30\3\30"+
		"\3\30\3\30\3\30\5\30\u012c\n\30\3\30\2\3\32\31\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\2\4\4\2\6\6\60\60\3\2()\2\u0143\2\60\3\2\2\2"+
		"\4:\3\2\2\2\6M\3\2\2\2\bV\3\2\2\2\nX\3\2\2\2\fi\3\2\2\2\16k\3\2\2\2\20"+
		"p\3\2\2\2\22\u0092\3\2\2\2\24\u009f\3\2\2\2\26\u00a1\3\2\2\2\30\u00aa"+
		"\3\2\2\2\32\u00c0\3\2\2\2\34\u00d6\3\2\2\2\36\u00da\3\2\2\2 \u00e1\3\2"+
		"\2\2\"\u00ea\3\2\2\2$\u010e\3\2\2\2&\u0110\3\2\2\2(\u0116\3\2\2\2*\u011c"+
		"\3\2\2\2,\u011f\3\2\2\2.\u012b\3\2\2\2\60\67\5\16\b\2\61\66\5\22\n\2\62"+
		"\66\5\6\4\2\63\66\5\4\3\2\64\66\5 \21\2\65\61\3\2\2\2\65\62\3\2\2\2\65"+
		"\63\3\2\2\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\3\3\2"+
		"\2\29\67\3\2\2\2:;\7.\2\2;<\5.\30\2<>\7%\2\2=?\5\f\7\2>=\3\2\2\2>?\3\2"+
		"\2\2?@\3\2\2\2@A\7&\2\2AH\7\35\2\2BG\5\22\n\2CG\5\24\13\2DG\5\26\f\2E"+
		"G\5\30\r\2FB\3\2\2\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2"+
		"HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\7\36\2\2L\5\3\2\2\2MN\5\b\5\2NO\5.\30"+
		"\2OQ\7%\2\2PR\5\f\7\2QP\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7&\2\2TU\5\n\6\2"+
		"U\7\3\2\2\2VW\t\2\2\2W\t\3\2\2\2X]\7\35\2\2Y\\\5\22\n\2Z\\\5\24\13\2["+
		"Y\3\2\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2"+
		"`a\7\36\2\2a\13\3\2\2\2bc\7\6\2\2cj\5.\30\2de\7\6\2\2ef\5.\30\2fg\7\37"+
		"\2\2gh\5\f\7\2hj\3\2\2\2ib\3\2\2\2id\3\2\2\2j\r\3\2\2\2kl\7\7\2\2lm\7"+
		"\35\2\2mn\5\20\t\2no\7\36\2\2o\17\3\2\2\2pq\7\b\2\2qr\7 \2\2rs\5.\30\2"+
		"st\7!\2\2tu\7\t\2\2uv\7 \2\2vw\7\4\2\2w~\7!\2\2xy\7\3\2\2yz\7 \2\2z{\7"+
		"\5\2\2{}\7!\2\2|x\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\21"+
		"\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\6\2\2\u0082\u0083\5.\30\2\u0083"+
		"\u0084\7\61\2\2\u0084\u0085\5\32\16\2\u0085\u0086\7!\2\2\u0086\u0093\3"+
		"\2\2\2\u0087\u0088\7\6\2\2\u0088\u008d\5.\30\2\u0089\u008a\7\37\2\2\u008a"+
		"\u008c\5.\30\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0091\7!\2\2\u0091\u0093\3\2\2\2\u0092\u0081\3\2\2\2\u0092\u0087\3\2"+
		"\2\2\u0093\23\3\2\2\2\u0094\u0095\5\34\17\2\u0095\u0096\7!\2\2\u0096\u00a0"+
		"\3\2\2\2\u0097\u0098\5\36\20\2\u0098\u0099\7!\2\2\u0099\u00a0\3\2\2\2"+
		"\u009a\u00a0\5$\23\2\u009b\u009c\7\62\2\2\u009c\u009d\5\32\16\2\u009d"+
		"\u009e\7!\2\2\u009e\u00a0\3\2\2\2\u009f\u0094\3\2\2\2\u009f\u0097\3\2"+
		"\2\2\u009f\u009a\3\2\2\2\u009f\u009b\3\2\2\2\u00a0\25\3\2\2\2\u00a1\u00a2"+
		"\7/\2\2\u00a2\u00a5\7%\2\2\u00a3\u00a6\7\17\2\2\u00a4\u00a6\5.\30\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00a8\7&\2\2\u00a8\u00a9\5\n\6\2\u00a9\27\3\2\2\2\u00aa\u00ab"+
		"\7\n\2\2\u00ab\u00b0\7%\2\2\u00ac\u00b1\5,\27\2\u00ad\u00ae\5.\30\2\u00ae"+
		"\u00af\5.\30\2\u00af\u00b1\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b0\u00ad\3\2"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7&\2\2\u00b3\u00b4\5\n\6\2\u00b4"+
		"\31\3\2\2\2\u00b5\u00b6\b\16\1\2\u00b6\u00b7\7%\2\2\u00b7\u00b8\5\32\16"+
		"\2\u00b8\u00b9\7&\2\2\u00b9\u00c1\3\2\2\2\u00ba\u00bb\7\63\2\2\u00bb\u00c1"+
		"\5\32\16\f\u00bc\u00c1\7\17\2\2\u00bd\u00c1\7\27\2\2\u00be\u00c1\5.\30"+
		"\2\u00bf\u00c1\5\36\20\2\u00c0\u00b5\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c0"+
		"\u00bc\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2"+
		"\2\2\u00c1\u00d3\3\2\2\2\u00c2\u00c3\f\13\2\2\u00c3\u00c4\7\34\2\2\u00c4"+
		"\u00d2\5\32\16\13\u00c5\u00c6\f\n\2\2\u00c6\u00c7\7\21\2\2\u00c7\u00d2"+
		"\5\32\16\13\u00c8\u00c9\f\t\2\2\u00c9\u00ca\7\20\2\2\u00ca\u00d2\5\32"+
		"\16\n\u00cb\u00cc\f\b\2\2\u00cc\u00cd\7\30\2\2\u00cd\u00d2\5\32\16\t\u00ce"+
		"\u00cf\f\7\2\2\u00cf\u00d0\7\31\2\2\u00d0\u00d2\5\32\16\b\u00d1\u00c2"+
		"\3\2\2\2\u00d1\u00c5\3\2\2\2\u00d1\u00c8\3\2\2\2\u00d1\u00cb\3\2\2\2\u00d1"+
		"\u00ce\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4\33\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\5.\30\2\u00d7\u00d8"+
		"\7\61\2\2\u00d8\u00d9\5\32\16\2\u00d9\35\3\2\2\2\u00da\u00db\5.\30\2\u00db"+
		"\u00dd\7%\2\2\u00dc\u00de\5\"\22\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\7&\2\2\u00e0\37\3\2\2\2\u00e1\u00e2"+
		"\7\64\2\2\u00e2\u00e3\5.\30\2\u00e3\u00e5\7%\2\2\u00e4\u00e6\5\f\7\2\u00e5"+
		"\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7&"+
		"\2\2\u00e8\u00e9\5\n\6\2\u00e9!\3\2\2\2\u00ea\u00ed\5\32\16\2\u00eb\u00ec"+
		"\7\37\2\2\u00ec\u00ee\5\"\22\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2"+
		"\u00ee#\3\2\2\2\u00ef\u00f3\5&\24\2\u00f0\u00f2\5(\25\2\u00f1\u00f0\3"+
		"\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f8\5*\26\2\u00f7\u00f6\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\u010f\3\2\2\2\u00f9\u00fa\7\'\2\2\u00fa"+
		"\u00fe\7%\2\2\u00fb\u00ff\5\22\n\2\u00fc\u00ff\7\17\2\2\u00fd\u00ff\5"+
		".\30\2\u00fe\u00fb\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0103\t\3\2\2\u0101\u0104\7\17\2\2\u0102\u0104\5"+
		".\30\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0106\7&\2\2\u0106\u010f\5\n\6\2\u0107\u0108\7*\2\2\u0108\u0109\7%\2"+
		"\2\u0109\u010a\5\32\16\2\u010a\u010b\7&\2\2\u010b\u010c\5\n\6\2\u010c"+
		"\u010f\3\2\2\2\u010d\u010f\5\26\f\2\u010e\u00ef\3\2\2\2\u010e\u00f9\3"+
		"\2\2\2\u010e\u0107\3\2\2\2\u010e\u010d\3\2\2\2\u010f%\3\2\2\2\u0110\u0111"+
		"\7+\2\2\u0111\u0112\7%\2\2\u0112\u0113\5\32\16\2\u0113\u0114\7&\2\2\u0114"+
		"\u0115\5\n\6\2\u0115\'\3\2\2\2\u0116\u0117\7,\2\2\u0117\u0118\7%\2\2\u0118"+
		"\u0119\5\32\16\2\u0119\u011a\7%\2\2\u011a\u011b\5\n\6\2\u011b)\3\2\2\2"+
		"\u011c\u011d\7-\2\2\u011d\u011e\5\n\6\2\u011e+\3\2\2\2\u011f\u0120\7\13"+
		"\2\2\u0120\u0121\5.\30\2\u0121-\3\2\2\2\u0122\u0125\7\65\2\2\u0123\u0124"+
		"\7\"\2\2\u0124\u0126\5.\30\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126"+
		"\u012c\3\2\2\2\u0127\u0128\7\65\2\2\u0128\u0129\7#\2\2\u0129\u012a\7\17"+
		"\2\2\u012a\u012c\7$\2\2\u012b\u0122\3\2\2\2\u012b\u0127\3\2\2\2\u012c"+
		"/\3\2\2\2\36\65\67>FHQ[]i~\u008d\u0092\u009f\u00a5\u00b0\u00c0\u00d1\u00d3"+
		"\u00dd\u00e5\u00ed\u00f3\u00f7\u00fe\u0103\u010e\u0125\u012b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}