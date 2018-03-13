// Generated from C:/Users/TobiasW/IdeaProjects/FIReCompiler/src/FIRe/Antlr\CFG.g4 by ANTLR 4.7
package FIRe.Antlr;
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
	 * Visit a parse tree produced by {@link CFGParser#strategydcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategydcl(CFGParser.StrategydclContext ctx);
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
	 * Visit a parse tree produced by {@link CFGParser#funcBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncBody(CFGParser.FuncBodyContext ctx);
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
	 * Visit a parse tree produced by {@link CFGParser#conditionDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionDcl(CFGParser.ConditionDclContext ctx);
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
	 * Visit a parse tree produced by {@link CFGParser#eParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEParam(CFGParser.EParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(CFGParser.IdContext ctx);
}