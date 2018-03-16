package FIRe;


import FIRe.Parser.*;


public class BuildASTVisitor extends CFGBaseVisitor<AbstractNode> {

    //Skal override dem alle, lige som ham på stackoverflow.


    @Override
    public AbstractNode visitProg(CFGParser.ProgContext ctx) {
        //return super.visitProg(ctx);
        ProgNode root = new ProgNode();

        root.childList.add(visitRobotDcl(ctx.robotDcl()));
        for(CFGParser.ProgBodyContext progBodyCtx: ctx.progBody()){
            root.childList.add(visitProgBody(progBodyCtx));
        }
        return root;
    }

    @Override
    public AbstractNode visitProgBody(CFGParser.ProgBodyContext ctx) {


        return super.visitProgBody(ctx);
    }

    @Override
    public AbstractNode visitStrategyDcl(CFGParser.StrategyDclContext ctx) {
        StrategyDeclarationNode node = new StrategyDeclarationNode();

        node.id=new IdNode(){};
        node.id.Value = ctx.Strategy().getSymbol().getText();

        //for(CFGParser.StrategydclContext

        return node;

    }

    @Override
    public AbstractNode visitStrategyBlock(CFGParser.StrategyBlockContext ctx) {
        return super.visitStrategyBlock(ctx);
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
    public AbstractNode visitBlock(CFGParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override
    public AbstractNode visitBlockBody(CFGParser.BlockBodyContext ctx) {
        return super.visitBlockBody(ctx);
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

    @Override
    public AbstractNode visitFuncCall(CFGParser.FuncCallContext ctx) {
        FuncCallNode Func = new FuncCallNode();
        Func.Id = visitId(ctx.id());
        Func.AparamList = visitAParamList(ctx.aParamList());

        return Func;
    }

    @Override
    public AbstractNode visitConditionDcl(CFGParser.ConditionDclContext ctx) {
        ConditionDeclarationNode CDN = new ConditionDeclarationNode();
        CDN.Id = visitId(ctx.id());
        if (!ctx.fParamList().isEmpty())
            CDN.FParamList = visitFParamList(ctx.fParamList()); //Vi tilføjer den ikke, hvis den ikke findes.
        CDN.Block = visitBlock(ctx.block());

        return CDN;
    }

    @Override
    public AbstractNode visitAParamList(CFGParser.AParamListContext ctx) {
        ActualParameterNode APN = new ActualParameterNode();

        while(ctx.expr() != null){
            APN.Arguments.add(visitExpr(ctx.expr()));
            ctx = ctx.aParamList();
        }

        return APN;
    }

    @Override
    public AbstractNode visitCtrlStruct(CFGParser.CtrlStructContext ctx) {
        if (ctx.aif() != null) {
            visitAif(ctx.aif());

            if (!ctx.aelseif().isEmpty()) {
                for (CFGParser.AelseifContext CTX : ctx.aelseif()) {
                    visitAelseif(CTX);
                }
            }
            if (ctx.aelse() != null) {
                visitAelse(ctx.aelse());
            }
        }

        else if (ctx.For() != null){
            ForNode FN = new ForNode();
            FN.Block = visitBlock(ctx.block());
            if (ctx.dcl() != null){
                FN.Declaration = visitDcl(ctx.dcl());
            }

            else if (!ctx.Val().isEmpty()){
                //Vi ved ikke hvad man gør, hvis man har én Val og én Id :(
            }
        }

        return super.visitCtrlStruct(ctx);
    }

    @Override
    public AbstractNode visitAif(CFGParser.AifContext ctx) {
        IfControlStructureNode ICSN = new IfControlStructureNode();
        ICSN.IfBlock = visitBlock(ctx.block());
        ICSN.Expression = visitExpr(ctx.expr());

        return ICSN;
    }


    public Tuple<AbstractNode,AbstractNode> visitElseif(CFGParser.AelseifContext ctx) {
        return new Tuple<AbstractNode, AbstractNode>(visitExpr(ctx.expr()),visitBlock(ctx.block()));
    }

    @Override
    public AbstractNode visitAelse(CFGParser.AelseContext ctx) {
        return visitBlock(ctx.block());
    }


    @Override
    public AbstractNode visitId(CFGParser.IdContext ctx) {
        IdNode IN = new IdNode();
        while(ctx.Val() != null){


        }

        return IN;
    }
}
