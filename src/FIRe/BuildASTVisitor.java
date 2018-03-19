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
        AbstractNode node;

        if(!ctx.BoolVal().toString().isEmpty())
            node = CreateBoolNode(ctx);
        else if(!ctx.Val().toString().isEmpty())
            node = CreateValNode(ctx);
        else if(!ctx.id().Name().toString().isEmpty())
            node = visitId(ctx.id());
        else if(!ctx.funcCall().id().Name().toString().isEmpty())
            node = visitFuncCall(ctx.funcCall());
        else if(!ctx.Not().toString().isEmpty())
            node = CreateNotNode(ctx);
        else if(!ctx.Squarel().toString().isEmpty())
            node = CreateArrayAccessNode(ctx);
        else node = null;

        /*
        else if(!ctx.Hat().toString().isEmpty())
            node = CreateInFixExprNode(ctx);
        else if(!ctx.MultiOp().toString().isEmpty()){
            node = CreateInFixExprNode(ctx);
        }
        else if(!ctx.AdditiveOp().toString().isEmpty()){
            node = CreateInFixExprNode(ctx);
        }
        else if(!ctx.BoolOp().toString().isEmpty()){
            node = CreateInFixExprNode(ctx);
        }
        else if(!ctx.RelativeOp().toString().isEmpty()){
            node = CreateInFixExprNode(ctx);
        }
        */
        if(ctx.expr().size() > 1 && ctx.Squarel().toString().isEmpty())
            CreateInFixExprNode(ctx);

        return node;
    }

    BoolNode CreateBoolNode(CFGParser.ExprContext ctx){
        BoolNode node = new BoolNode();
        if(ctx.BoolVal().toString().equals("true"))
            node.value = true;
        else
            node.value = false;
        return node;
    }

    ValNode CreateValNode(CFGParser.ExprContext ctx){
        ValNode node;
        if(tryParseDouble(ctx.Val().toString()))
            node = new NumberNode(Double.parseDouble(ctx.Val().toString()));
        else
            node = new TextNode(ctx.Val().toString());
        return node;
    }

    NotNode CreateNotNode(CFGParser.ExprContext ctx){
        NotNode node = new NotNode();
        node.Expression = (ExpressionNode)visitExpr(ctx.expr().get(0));
        return node;
    }



    boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    InfixExpressionNode CreateInFixExprNode(CFGParser.ExprContext ctx){
        InfixExpressionNode node = null;

        if(!ctx.MultiOp().toString().isEmpty()){
            if(ctx.MultiOp().toString().equals("*"))
                node = CreateTimesNode(ctx);
            else if(ctx.MultiOp().toString().equals("/"))
                node = CreateDivisionNode(ctx);
            else if(ctx.MultiOp().toString().equals("%"))
                node = CreateModuloNode(ctx);
        }
        else if(!ctx.AdditiveOp().toString().isEmpty()){
            if(ctx.AdditiveOp().toString().equals("+"))
                node = CreatePlusNode(ctx);
            else if(ctx.AdditiveOp().toString().equals("-"))
                node = CreateMinusNode(ctx);
        }
        else if(!ctx.BoolOp().toString().isEmpty()){
            if(ctx.BoolOp().toString().equals("and"))
                node = CreateAndNode(ctx);
            else if(ctx.BoolOp().toString().equals("or"))
                node = CreateOrNode(ctx);
        }

        else if(!ctx.RelativeOp().toString().isEmpty()){
            if(ctx.RelativeOp().toString().equals("<"))
                node = CreateLessThanNode(ctx);
            else if(ctx.RelativeOp().toString().equals(">"))
                node = CreateGreaterThanNode(ctx);
            else if(ctx.RelativeOp().toString().equals("=="))
                node = CreateEqualsNode(ctx);
            else if(ctx.RelativeOp().toString().equals("!="))
                node = CreateNotEqualsNode(ctx);
            else if(ctx.RelativeOp().toString().equals("<="))
                node = CreateLEQNode(ctx);
            else if(ctx.RelativeOp().toString().equals(">="))
                node = CreateGEQNode(ctx);
        }
        else if(!ctx.Hat().toString().isEmpty())
            node = CreateExponentNode(ctx);

        return node;
    }

    MultiplicationNode CreateTimesNode(CFGParser.ExprContext ctx){
        MultiplicationNode node = new MultiplicationNode();

        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    DivisionNode CreateDivisionNode(CFGParser.ExprContext ctx){
        DivisionNode node = new DivisionNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    ModuloNode CreateModuloNode(CFGParser.ExprContext ctx){
        ModuloNode node = new ModuloNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    AdditionNode CreatePlusNode(CFGParser.ExprContext ctx){
        AdditionNode node = new AdditionNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    SubtractionNode CreateMinusNode(CFGParser.ExprContext ctx){
        SubtractionNode node = new SubtractionNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    AndNode CreateAndNode(CFGParser.ExprContext ctx){
        AndNode node = new AndNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    OrNode CreateOrNode(CFGParser.ExprContext ctx){
        OrNode node = new OrNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    LessThanNode CreateLessThanNode(CFGParser.ExprContext ctx){
        LessThanNode node = new LessThanNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    GreaterThanNode CreateGreaterThanNode(CFGParser.ExprContext ctx){
        GreaterThanNode node = new GreaterThanNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    EqualsNode CreateEqualsNode(CFGParser.ExprContext ctx){
        EqualsNode node = new EqualsNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    NotEqualsNode CreateNotEqualsNode(CFGParser.ExprContext ctx){
        NotEqualsNode node = new NotEqualsNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    LEQNode CreateLEQNode(CFGParser.ExprContext ctx){
        LEQNode node = new LEQNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    GEQNode CreateGEQNode(CFGParser.ExprContext ctx){
        GEQNode node = new GEQNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    PowerNode CreateExponentNode(CFGParser.ExprContext ctx){
        PowerNode node = new PowerNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
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
        IdNode node = new IdNode();

        node.name = ctx.Name().toString();

        while(ctx.id() != null){
            node.name = node.name + "." + ctx.id().Name().toString();
            ctx = ctx.id();
        }
        if(!ctx.Val().toString().isEmpty()){
            node.name = node.name + "[" + ctx.Val().toString() + "]";
        }

        return node;
    }
}
