// Generated from C:/Users/Magnus/Desktop/FIReCompiler2/src/FIRe/Parser\CFG.g4 by ANTLR 4.7
package FIRe.Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CFGParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CFGVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CFGParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(CFGParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#progBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgBody(CFGParser.ProgBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#strategyDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategyDcl(CFGParser.StrategyDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#strategyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategyBlock(CFGParser.StrategyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#funcDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDcl(CFGParser.FuncDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(CFGParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CFGParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#blockBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockBody(CFGParser.BlockBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#fParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFParamList(CFGParser.FParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#robotDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRobotDcl(CFGParser.RobotDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#robotDclBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRobotDclBody(CFGParser.RobotDclBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(CFGParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(CFGParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#routine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutine(CFGParser.RoutineContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#when}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen(CFGParser.WhenContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(CFGParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(CFGParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(CFGParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#eventDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventDcl(CFGParser.EventDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#aParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAParamList(CFGParser.AParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#ctrlStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtrlStruct(CFGParser.CtrlStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#aif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAif(CFGParser.AifContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#aelseif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAelseif(CFGParser.AelseifContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#aelse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAelse(CFGParser.AelseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(CFGParser.IdContext ctx);
}