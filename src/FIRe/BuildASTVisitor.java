package FIRe;

import FIRe.Parser.FIRe.Antlr.CFGBaseVisitor;
import FIRe.Parser.FIRe.Antlr.CFGParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;


public class BuildASTVisitor extends CFGBaseVisitor<AbstractNode> {

    //Skal override dem alle, lige som ham på stackoverflow.


    @Override
    public AbstractNode visitProg(CFGParser.ProgContext ctx) {
        //return super.visitProg(ctx);
        ProgNode root = new ProgNode();

        root.childList.add(visitRobotDcl(ctx.robotDcl()));

        for(CFGParser.DclContext n : ctx.dcl()){
            root.childList.add(visitDcl(n));
        }

        for(CFGParser.FuncDclContext n : ctx.funcDcl()){
            root.childList.add(visitFuncDcl(n));
        }

        for(CFGParser.StrategydclContext n : ctx.strategydcl()){
            root.childList.add(visitStrategydcl(n));
        }

        for(CFGParser.ConditionDclContext n : ctx.conditionDcl()){
            root.childList.add(visitConditionDcl(n));
        }

        return root;
    }

    @Override
    public AbstractNode visitStrategydcl(CFGParser.StrategydclContext ctx) {
        return super.visitStrategydcl(ctx);

    }

    @Override
    public AbstractNode visitFuncDcl(CFGParser.FuncDclContext ctx) {
        return super.visitFuncDcl(ctx);
    }

    @Override
    public AbstractNode visitFuncType(CFGParser.FuncTypeContext ctx) {
        return super.visitFuncType(ctx);
    }


    @Override
    public AbstractNode visitFuncBody(CFGParser.FuncBodyContext ctx) {
        return super.visitFuncBody(ctx);
    }

    @Override
    public AbstractNode visitFParamList(CFGParser.FParamListContext ctx) {
        return super.visitFParamList(ctx);
    }

    @Override
    public AbstractNode visitRobotDcl(CFGParser.RobotDclContext ctx) {
        return super.visitRobotDcl(ctx);
    }

    @Override
    public AbstractNode visitRobotDclBody(CFGParser.RobotDclBodyContext ctx) {
        return super.visitRobotDclBody(ctx);
    }

    @Override
    public AbstractNode visitDcl(CFGParser.DclContext ctx) {
        return super.visitDcl(ctx);
    }

    @Override
    public AbstractNode visitStmt(CFGParser.StmtContext ctx) {
        return super.visitStmt(ctx);
    }

    @Override
    public AbstractNode visitRoutine(CFGParser.RoutineContext ctx) {
        //return super.visitRoutine(ctx);
        RoutineNode node = new RoutineNode();

    }

    @Override
    public AbstractNode visitWhen(CFGParser.WhenContext ctx) {
        return super.visitWhen(ctx);
    }

    @Override
    public AbstractNode visitExpr(CFGParser.ExprContext ctx) {
        return super.visitExpr(ctx);

    }

    @Override
    public AbstractNode visitAssignStmt(CFGParser.AssignStmtContext ctx) {
        return super.visitAssignStmt(ctx);
    }

    @Override
    public AbstractNode visitFuncCall(CFGParser.FuncCallContext ctx) {
        return super.visitFuncCall(ctx);
    }

    @Override
    public AbstractNode visitConditionDcl(CFGParser.ConditionDclContext ctx) {
        return super.visitConditionDcl(ctx);
    }

    @Override
    public AbstractNode visitAParamList(CFGParser.AParamListContext ctx) {
        return super.visitAParamList(ctx);
    }

    @Override
    public AbstractNode visitCtrlStruct(CFGParser.CtrlStructContext ctx) {
        return super.visitCtrlStruct(ctx);
    }

    @Override
    public AbstractNode visitAif(CFGParser.AifContext ctx) {
        return super.visitAif(ctx);
    }

    @Override
    public AbstractNode visitAelseif(CFGParser.AelseifContext ctx) {
        return super.visitAelseif(ctx);
    }

    @Override
    public AbstractNode visitAelse(CFGParser.AelseContext ctx) {
        return super.visitAelse(ctx);
    }

    @Override
    public AbstractNode visitEParam(CFGParser.EParamContext ctx) {
        return super.visitEParam(ctx);
    }

    @Override
    public AbstractNode visitId(CFGParser.IdContext ctx) {
        return super.visitId(ctx);
    }
}
