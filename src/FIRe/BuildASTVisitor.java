package FIRe;


import FIRe.Parser.*;

public class BuildASTVisitor extends CFGBaseVisitor<AbstractNode> {

    //Skal override dem alle, lige som ham på stackoverflow.


    @Override
    public AbstractNode visitProg(CFGParser.ProgContext ctx) {
        ProgNode root = new ProgNode();

        root.childList.add(visitRobotDcl(ctx.robotDcl()));
        for(CFGParser.ProgBodyContext progBodyCtx: ctx.progBody()){
            root.childList.add(visitProgBody(progBodyCtx));
        }

        return root;
    }

    @Override
    public AbstractNode visitProgBody(CFGParser.ProgBodyContext ctx) {
        if(!ctx.dcl().isEmpty())
            return visitDcl(ctx.dcl());
        else if(!ctx.funcDcl().isEmpty())
            return visitFuncDcl(ctx.funcDcl());
        else if(!ctx.strategyDcl().isEmpty())
            return visitStrategyDcl(ctx.strategyDcl());
        else if(!ctx.conditionDcl().isEmpty())
            return visitConditionDcl(ctx.conditionDcl());
        else
            return null;
    }

    @Override
    public AbstractNode visitStrategyDcl(CFGParser.StrategyDclContext ctx) {
        StrategyDeclarationNode node = new StrategyDeclarationNode();

        node.id = (IdNode)visitId(ctx.id());
        node.childList.add(visitFParamList(ctx.fParamList()));

        for(CFGParser.BlockBodyContext blockBodyCtx : ctx.blockBody())
            node.childList.add(visitBlockBody(blockBodyCtx));

        for(CFGParser.StrategyBlockContext strategyBlockCtx : ctx.strategyBlock())
            node.childList.add(visitStrategyBlock(strategyBlockCtx));

        return node;

    }

    @Override
    public AbstractNode visitStrategyBlock(CFGParser.StrategyBlockContext ctx) {
        if(!ctx.when().isEmpty())
            return(new WhenNode(visitEParam(ctx.when().eParam()), visitBlock(ctx.when().block())));
        else if(!ctx.routine().isEmpty()) {
            if(!ctx.routine().id().isEmpty())
                return (new RoutineNode(visitId(ctx.routine().id()), visitBlock(ctx.routine().block())));
            else if(!(ctx.routine().Val().toString().isEmpty()))
                return(new RoutineNode(ctx.routine().Val().toString(), visitBlock(ctx.routine().block())));
            else
                return(new RoutineNode(visitBlock(ctx.routine().block())));
        }
        else
            return null;
    }

    @Override
    public AbstractNode visitFuncDcl(CFGParser.FuncDclContext ctx) {
        FunctionDeclarationNode node = new FunctionDeclarationNode();

        if(!ctx.funcType().isEmpty())
            node.Type = ctx.funcType().toString();
        if(!ctx.id().isEmpty())
            node.childList.add(visitId(ctx.id()));
        if(!ctx.fParamList().isEmpty())
            node.childList.add(visitFParamList(ctx.fParamList()));
        if(!ctx.block().isEmpty())
            node.childList.add(visitBlock(ctx.block()));

        return node;
    }

    /*@Override
    public AbstractNode visitFuncType(CFGParser.FuncTypeContext ctx) {
        return super.visitFuncType(ctx);
    }*/


    @Override
    public AbstractNode visitBlock(CFGParser.BlockContext ctx) {
        BlockNode blockNode = new BlockNode();
        for(CFGParser.BlockBodyContext blockBodyCtx : ctx.blockBody())
            blockNode.childList.add(visitBlockBody(blockBodyCtx));

        return blockNode;

    }

    @Override
    public AbstractNode visitBlockBody(CFGParser.BlockBodyContext ctx) {
        if(!ctx.dcl().isEmpty())
            return visitDcl(ctx.dcl());
        else if(!ctx.stmt().isEmpty())
            return visitStmt(ctx.stmt());
        else
            return null;
    }

    @Override
    public AbstractNode visitFParamList(CFGParser.FParamListContext ctx) {
        FormalParameterNode node = new FormalParameterNode();

        while(!ctx.fParamList().isEmpty()) {
            node.type = ctx.Type().toString();
            node.childList.add(visitId(ctx.id()));
            ctx = ctx.fParamList();
        }

        return node;
    }

//-------------------------------------------------------------------------------
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

        return node;
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
//----------------------------------------------------------------------------
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
