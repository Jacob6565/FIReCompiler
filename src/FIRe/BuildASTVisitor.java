package FIRe;


import FIRe.Parser.*;

import java.util.ArrayList;


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
        if(ctx.dcl() != null)
            return visitDcl(ctx.dcl());
        else if(ctx.funcDcl() != null)
            return visitFuncDcl(ctx.funcDcl());
        else if(ctx.strategyDcl() != null)
            return visitStrategyDcl(ctx.strategyDcl());
        else if(ctx.conditionDcl() != null)
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
        if(ctx.when() != null)
            return(visitWhen(ctx.when()));
        else if(ctx.routine() != null)
            return (visitRoutine(ctx.routine()));
        else
            return null;
    }

    @Override
    public AbstractNode visitFuncDcl(CFGParser.FuncDclContext ctx) {
        FunctionDeclarationNode node = new FunctionDeclarationNode();

        if(ctx.funcType() != null)
            node.type = ctx.funcType().toString();
        if(ctx.id() != null)
            node.childList.add(visitId(ctx.id()));
        if(ctx.fParamList() != null)
            node.childList.add(visitFParamList(ctx.fParamList()));
        if(ctx.block() != null)
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
        if(ctx.dcl() != null)
            return visitDcl(ctx.dcl());
        else if(ctx.stmt() != null)
            return visitStmt(ctx.stmt());
        else
            return null;
    }

    @Override
    public AbstractNode visitFParamList(CFGParser.FParamListContext ctx) {
        FormalParameterNode node = new FormalParameterNode();

        while(ctx.fParamList() != null) {

            node.parameterMap.put(visitId(ctx.id()), ctx.Type().toString());
            //node.childList.add(ctx.Type().toString());
            //node.childList.add(visitId(ctx.id()));
            ctx = ctx.fParamList();
        }

        return node;
    }

//-------------------------------------------------------------------------------
    @Override
    public AbstractNode visitRobotDcl(CFGParser.RobotDclContext ctx) {

        return visitRobotDclBody(ctx.robotDclBody());
    }

    @Override
    public AbstractNode visitRobotDclBody(CFGParser.RobotDclBodyContext ctx) {

        RobotDclBodyNode robotDclBodyNode = new RobotDclBodyNode();
        for (CFGParser.IdContext idContext: ctx.id())
        {
            robotDclBodyNode.childList.add(visitId(idContext));
        }

        return robotDclBodyNode;
    }

    @Override
    public AbstractNode visitDcl(CFGParser.DclContext ctx) {

        if(ctx.expr() != null){
            if(ctx.Type().toString().equals("number")){ //måske det her ikke virker som vi lige tænkte

                NumberDeclarationNode numberDeclarationNode = new NumberDeclarationNode();
                numberDeclarationNode.childList.add(visitId(ctx.id(0))); //0 fordi vi tror der er tale om det første og eneste element i listen som vi vil tilføje

                numberDeclarationNode.childList.add(visitExpr(ctx.expr()));
                return numberDeclarationNode;
            }

            else if(ctx.Type().toString().equals("text")){

                TextDeclarationNode textDeclarationNode = new TextDeclarationNode();
                textDeclarationNode.childList.add(visitId(ctx.id(0))); //0 fordi vi tror der er tale om det første og eneste element i listen som vi vil tilføje

                textDeclarationNode.childList.add(visitExpr(ctx.expr()));
                return textDeclarationNode;

            }

            else if(ctx.Type().toString().equals("bool")){

                BooleanDeclarationNode booleanDeclarationNode = new BooleanDeclarationNode();
                booleanDeclarationNode.childList.add(visitId(ctx.id(0))); //0 fordi vi tror der er tale om det første og eneste element i listen som vi vil tilføje

                booleanDeclarationNode.childList.add(visitExpr(ctx.expr()));
                return booleanDeclarationNode;
            }
            else
                return null;

        }
        else {

            if(ctx.Type().toString().equals("number")){

                NumberDeclarationNode numberDeclarationNode = new NumberDeclarationNode();

                for (CFGParser.IdContext idContext:ctx.id()) {
                    numberDeclarationNode.childList.add(visitId(idContext));
                }
                return numberDeclarationNode;

            }

            else if (ctx.Type().toString().equals("text")) {

                TextDeclarationNode textDeclarationNode = new TextDeclarationNode();

                for (CFGParser.IdContext idContext : ctx.id()) {
                    textDeclarationNode.childList.add(visitId(idContext));
                }
                return textDeclarationNode;
            }

            else if (ctx.Type().toString().equals("bool")) {

                BooleanDeclarationNode booleanDeclarationNode = new BooleanDeclarationNode();

                for (CFGParser.IdContext idContext : ctx.id()) {
                    booleanDeclarationNode.childList.add(visitId(idContext));
                }
                return booleanDeclarationNode;
            }
            else
                return null;
        }
    }

    @Override
    public AbstractNode visitStmt(CFGParser.StmtContext ctx) {
        return super.visitStmt(ctx);
    }

    @Override
    public AbstractNode visitRoutine(CFGParser.RoutineContext ctx) {
        if(ctx.id() != null)
            return (new RoutineNode(visitId(ctx.id()), visitBlock(ctx.block())));
        else if(!ctx.Val().toString().isEmpty())
            return(new RoutineNode(ctx.Val().toString(), visitBlock(ctx.block())));
        else
            return(new RoutineNode(visitBlock(ctx.block())));
    }

    @Override
    public AbstractNode visitWhen(CFGParser.WhenContext ctx) {

       return(new WhenNode(visitId(ctx.id().get(0)), visitId(ctx.id().get(1))));
    }

    @Override
    public AbstractNode visitExpr(CFGParser.ExprContext ctx) {
        return super.visitExpr(ctx);

    }

    @Override
    public AbstractNode visitAssignStmt(CFGParser.AssignStmtContext ctx) {
        AssignNode node = new AssignNode();

        node.childList.add(visitId(ctx.id()));
        node.childList.add(visitExpr(ctx.expr()));

        return node;
    }

    @Override
    public AbstractNode visitFuncCall(CFGParser.FuncCallContext ctx) {
        FuncCallNode func = new FuncCallNode();
        func.childList.add(visitId(ctx.id()));
        func.childList.add(visitAParamList(ctx.aParamList()));

        return func;
    }

    @Override
    public AbstractNode visitConditionDcl(CFGParser.ConditionDclContext ctx) {
        ConditionDeclarationNode CDN = new ConditionDeclarationNode();
        CDN.childList.add(visitId(ctx.id()));
        if (!ctx.fParamList().isEmpty())
            CDN.childList.add(visitFParamList(ctx.fParamList())); //Vi tilføjer den ikke, hvis den ikke findes.
        CDN.childList.add(visitBlock(ctx.block()));

        return CDN;
    }

    @Override
    public AbstractNode visitAParamList(CFGParser.AParamListContext ctx) {
        ActualParameterNode APN = new ActualParameterNode();

        while(ctx != null){
            APN.childList.add(visitExpr(ctx.expr()));
            ctx = ctx.aParamList();
        }

        return APN;
    }

    @Override
    public AbstractNode visitCtrlStruct(CFGParser.CtrlStructContext ctx) {
        if (ctx.aif() != null) {
            IfControlStructureNode IfNode = new IfControlStructureNode();
            IfNode.childList.add(visitAif(ctx.aif()));

            if (!ctx.aelseif().isEmpty()) {
                for (CFGParser.AelseifContext CTX : ctx.aelseif()) {
                    IfNode.childList.add(visitAelseif(CTX));
                }
            }
            if (ctx.aelse() != null) {
                IfNode.childList.add(visitAelse(ctx.aelse()));
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
        ICSN.childList.add(visitBlock(ctx.block()));
        ICSN.childList.add(visitExpr(ctx.expr()));

        return ICSN;
    }

    @Override
    public AbstractNode visitAelseif(CFGParser.AelseifContext ctx) {
        return null;
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
