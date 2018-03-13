// Generated from C:/Users/TobiasW/IdeaProjects/FIReCompiler/src/FIRe/Antlr\CFG.g4 by ANTLR 4.7
package FIRe.Parser.FIRe.Antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CFGParser}.
 */
public interface CFGListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CFGParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CFGParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CFGParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#strategydcl}.
	 * @param ctx the parse tree
	 */
	void enterStrategydcl(CFGParser.StrategydclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#strategydcl}.
	 * @param ctx the parse tree
	 */
	void exitStrategydcl(CFGParser.StrategydclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#funcDcl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDcl(CFGParser.FuncDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#funcDcl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDcl(CFGParser.FuncDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(CFGParser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(CFGParser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#funcBody}.
	 * @param ctx the parse tree
	 */
	void enterFuncBody(CFGParser.FuncBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#funcBody}.
	 * @param ctx the parse tree
	 */
	void exitFuncBody(CFGParser.FuncBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#fParamList}.
	 * @param ctx the parse tree
	 */
	void enterFParamList(CFGParser.FParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#fParamList}.
	 * @param ctx the parse tree
	 */
	void exitFParamList(CFGParser.FParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#robotDcl}.
	 * @param ctx the parse tree
	 */
	void enterRobotDcl(CFGParser.RobotDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#robotDcl}.
	 * @param ctx the parse tree
	 */
	void exitRobotDcl(CFGParser.RobotDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#robotDclBody}.
	 * @param ctx the parse tree
	 */
	void enterRobotDclBody(CFGParser.RobotDclBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#robotDclBody}.
	 * @param ctx the parse tree
	 */
	void exitRobotDclBody(CFGParser.RobotDclBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(CFGParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(CFGParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(CFGParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(CFGParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#routine}.
	 * @param ctx the parse tree
	 */
	void enterRoutine(CFGParser.RoutineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#routine}.
	 * @param ctx the parse tree
	 */
	void exitRoutine(CFGParser.RoutineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#when}.
	 * @param ctx the parse tree
	 */
	void enterWhen(CFGParser.WhenContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#when}.
	 * @param ctx the parse tree
	 */
	void exitWhen(CFGParser.WhenContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CFGParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CFGParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(CFGParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(CFGParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(CFGParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(CFGParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#conditionDcl}.
	 * @param ctx the parse tree
	 */
	void enterConditionDcl(CFGParser.ConditionDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#conditionDcl}.
	 * @param ctx the parse tree
	 */
	void exitConditionDcl(CFGParser.ConditionDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#aParamList}.
	 * @param ctx the parse tree
	 */
	void enterAParamList(CFGParser.AParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#aParamList}.
	 * @param ctx the parse tree
	 */
	void exitAParamList(CFGParser.AParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#ctrlStruct}.
	 * @param ctx the parse tree
	 */
	void enterCtrlStruct(CFGParser.CtrlStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#ctrlStruct}.
	 * @param ctx the parse tree
	 */
	void exitCtrlStruct(CFGParser.CtrlStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#aif}.
	 * @param ctx the parse tree
	 */
	void enterAif(CFGParser.AifContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#aif}.
	 * @param ctx the parse tree
	 */
	void exitAif(CFGParser.AifContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#aelseif}.
	 * @param ctx the parse tree
	 */
	void enterAelseif(CFGParser.AelseifContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#aelseif}.
	 * @param ctx the parse tree
	 */
	void exitAelseif(CFGParser.AelseifContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#aelse}.
	 * @param ctx the parse tree
	 */
	void enterAelse(CFGParser.AelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#aelse}.
	 * @param ctx the parse tree
	 */
	void exitAelse(CFGParser.AelseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#eParam}.
	 * @param ctx the parse tree
	 */
	void enterEParam(CFGParser.EParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#eParam}.
	 * @param ctx the parse tree
	 */
	void exitEParam(CFGParser.EParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(CFGParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(CFGParser.IdContext ctx);
}