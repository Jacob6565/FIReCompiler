package FIRe;


import FIRe.Parser.*;


public class BuildASTVisitor extends CFGBaseVisitor<AbstractNode> {

    //Skal override dem alle, lige som ham på stackoverflow.

    //Visitis the very first node of the CST
    @Override
    public AbstractNode visitProg(CFGParser.ProgContext ctx) {
        ProgNode root = new ProgNode();

        root.childList.add(visitRobotDcl(ctx.robotDcl()));

        for(CFGParser.ProgBodyContext progBodyCtx: ctx.progBody()){
            root.childList.add(visitProgBody(progBodyCtx)); //We add all progBodies, since we visit each of them.
        }

        return root;
    }

    //Methods has an if-else for each possible node in the xontext ctx.
    @Override
    public AbstractNode visitProgBody(CFGParser.ProgBodyContext ctx) {
        if(ctx.dcl() != null) //finds the right visitmethod and calls it
            return visitDcl(ctx.dcl());
        else if(ctx.funcDcl() != null)
            return visitFuncDcl(ctx.funcDcl());
        else if(ctx.strategyDcl() != null)
            return visitStrategyDcl(ctx.strategyDcl());
        else if(ctx.eventDcl() != null)
            return visitEventDcl(ctx.eventDcl());
        else
            return null; //Maybe this shouldn't return null?
    }

    //Method creates a new StrategyDeclerationNode adds the Fparamlist, and also visitis it's block and routines and when
    @Override
    public AbstractNode visitStrategyDcl(CFGParser.StrategyDclContext ctx) {
        StrategyDeclarationNode node = new StrategyDeclarationNode();//Makes a new node

        node.id = (IdNode)visitId(ctx.id());
        node.childList.add(visitFParamList(ctx.fParamList())); //Add the fParamList

        if(ctx.blockBody() != null)
            for(CFGParser.BlockBodyContext blockBodyCtx: ctx.blockBody()) {
                node.childList.add(visitBlockBody(blockBodyCtx)); //And the block
            }

        for(CFGParser.StrategyBlockContext strategyBlockCtx : ctx.strategyBlock())
            node.childList.add(visitStrategyBlock(strategyBlockCtx)); //And it's strategy block (routines og whens)

        return node;
    }

    //Determines wheter visitWhen should be called or visitRoutine
    @Override
    public AbstractNode visitStrategyBlock(CFGParser.StrategyBlockContext ctx) {
        if(ctx.when() != null) //Finds the right visit method.
            return(visitWhen(ctx.when()));
        else if(ctx.routine() != null)
            return (visitRoutine(ctx.routine()));
        else
            return null;
    }

    //creates a new FunctionDeclNode, sets the type of it, add the fParamlist and the block
    @Override
    public AbstractNode visitFuncDcl(CFGParser.FuncDclContext ctx) {
        FunctionDeclarationNode node = new FunctionDeclarationNode();

        node.type = ctx.funcType().toString();
        node.childList.add(visitId(ctx.id()));
        if(ctx.fParamList() != null)//fparamlist er optional.
            node.childList.add(visitFParamList(ctx.fParamList()));
        node.childList.add(visitBlock(ctx.block()));

        return node;
    }

    //adds all the blockbodies as children, a blockbody can evaluate to a dcl or a Stmt
    @Override
    public AbstractNode visitBlock(CFGParser.BlockContext ctx) {
        BlockNode blockNode = new BlockNode();
        for(CFGParser.BlockBodyContext blockBodyCtx : ctx.blockBody())
            blockNode.childList.add(visitBlockBody(blockBodyCtx)); //Add all the blockbodies as children

        return blockNode;
    }

    //deteermines wheter a blockbody is a dcl or stmt
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

        while(ctx != null) {
            /* We maå an id to a type in a map (known as a dictionary in C#,
            to easily find the type of an id*/
            node.parameterMap.put(visitId(ctx.id()), ctx.Type().toString());
            //IdNode idnode = (IdNode) visitId(ctx.id());
            //idnode.type = ctx.Type().toString();
            //node.childList.add(idnode);
            ctx = ctx.fParamList();
            //ctx is set to the inner context. the loop iterates until there aren't any more inner contexts.
        }

        return node;
    }

//-------------------------------------------------------------------------------
    @Override
    public AbstractNode visitRobotDcl(CFGParser.RobotDclContext ctx) {

        return visitRobotDclBody(ctx.robotDclBody());
    }

    //for each idContext we add et as a child to the  robotDclBodyNde
    @Override
    public AbstractNode visitRobotDclBody(CFGParser.RobotDclBodyContext ctx) {

        RobotDclBodyNode robotDclBodyNode = new RobotDclBodyNode();
        for (CFGParser.IdContext idContext: ctx.id())
        {
            robotDclBodyNode.childList.add(visitId(idContext));
        }

        return robotDclBodyNode;
    }

    //THis method handles the dcl rule from the cfg, multiple cases exists since we have different types and
    //multiple declerations can be made at once
    @Override
    public AbstractNode visitDcl(CFGParser.DclContext ctx) {

        if(ctx.expr() != null){ // If there is an expr we assume the first rule.
            if(ctx.Type().toString().equals("number")){

                NumberDeclarationNode numberDeclarationNode = new NumberDeclarationNode();
                numberDeclarationNode.childList.add(visitId(ctx.id(0))); //0 beacuse we want to add the first and only element from the list

                numberDeclarationNode.childList.add(visitExpr(ctx.expr()));
                return numberDeclarationNode;
            }

            else if(ctx.Type().toString().equals("text")){

                TextDeclarationNode textDeclarationNode = new TextDeclarationNode();
                textDeclarationNode.childList.add(visitId(ctx.id(0))); //0 beacuse we want to add the first and only element from the list

                textDeclarationNode.childList.add(visitExpr(ctx.expr()));
                return textDeclarationNode;

            }

            else if(ctx.Type().toString().equals("bool")){

                BooleanDeclarationNode booleanDeclarationNode = new BooleanDeclarationNode();
                booleanDeclarationNode.childList.add(visitId(ctx.id(0))); //0 beacuse we want to add the first and only element from the list

                booleanDeclarationNode.childList.add(visitExpr(ctx.expr()));
                return booleanDeclarationNode;
            }
            else
                return null;

        }
        else {//This else handles the case where multiple declerations are made.

            if(ctx.Type().toString().equals("number")){

                NumberDeclarationNode numberDeclarationNode = new NumberDeclarationNode();

                for (CFGParser.IdContext idContext:ctx.id()) {
                    numberDeclarationNode.childList.add(visitId(idContext)); //we add the dcls as children
                }
                return numberDeclarationNode;

            }

            else if (ctx.Type().toString().equals("text")) {

                TextDeclarationNode textDeclarationNode = new TextDeclarationNode();

                for (CFGParser.IdContext idContext : ctx.id()) {
                    textDeclarationNode.childList.add(visitId(idContext));//We add the dcls as children
                }
                return textDeclarationNode;
            }

            else if (ctx.Type().toString().equals("bool")) {

                BooleanDeclarationNode booleanDeclarationNode = new BooleanDeclarationNode();

                for (CFGParser.IdContext idContext : ctx.id()) {
                    booleanDeclarationNode.childList.add(visitId(idContext));//We add the dcls as children
                }
                return booleanDeclarationNode;
            }
            else
                return null;
        }
    }

    @Override
    public AbstractNode visitStmt(CFGParser.StmtContext ctx) {
        //Her afgør vi, hvilken slags statement vi har fat i og kalder den korrekte metode.
        if(ctx.assignStmt() != null){
            return visitAssignStmt(ctx.assignStmt());
        }
        else if (ctx.funcCall() != null){
            return visitFuncCall(ctx.funcCall());
        }
        else if (ctx.ctrlStruct() != null){
            return visitCtrlStruct(ctx.ctrlStruct());
        }
        else if(ctx.expr() != null){
            return new ReturnNode(visitExpr(ctx.expr()));
        }
        else
            return  null;

    }

    @Override
    public AbstractNode visitRoutine(CFGParser.RoutineContext ctx) {
        //Her fremgår de forskellige slags routine-kald. med id, med Val og tom.
        if(ctx.expr() != null)
            return (new RoutineNode(visitExpr(ctx.expr()), visitBlock(ctx.block())));
        else
            return(new RoutineNode(visitBlock(ctx.block())));
    }

    @Override
    public AbstractNode visitWhen(CFGParser.WhenContext ctx) {
        WhenNode when = new WhenNode(visitId(ctx.id().get(0)), visitId(ctx.id().get(1)));
        when.childList.add(visitBlock(ctx.block()));
        return when;
    }

    @Override
    public AbstractNode visitExpr(CFGParser.ExprContext ctx) {
        AbstractNode node = null;

        if(ctx.expr().size() <= 1) {
            if (ctx.BoolVal() != null)
                node = CreateBoolNode(ctx);
            else if (ctx.Val() != null)
                node = CreateValNode(ctx);
            else if (ctx.id() != null)
                node = visitId(ctx.id());
            else if (ctx.funcCall() != null)
                node = visitFuncCall(ctx.funcCall());
            else if (ctx.Not() != null)
                node = CreateNotNode(ctx);
            else if (ctx.Parenl() != null)
                node = visitExpr(ctx.expr().get(0));
        }
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
        if(ctx.expr().size() > 1 && ctx.Squarel() == null)
            node = CreateInFixExprNode(ctx);
        else if(ctx.expr().size() > 1 && ctx.Squarel()!= null)
            node = CreateArrayAccessNode(ctx);

        return node;
    }

    private BoolNode CreateBoolNode(CFGParser.ExprContext ctx){
        BoolNode node = new BoolNode();
        if(ctx.BoolVal().toString().equals("true"))
            node.value = true;
        else
            node.value = false;
        return node;
    }

    private ValNode CreateValNode(CFGParser.ExprContext ctx){
        ValNode node;
        if(tryParseDouble(ctx.Val().toString()))
            node = new NumberNode(Double.parseDouble(ctx.Val().toString()));
        else
            node = new TextNode(ctx.Val().toString());
        return node;
    }

    private NotNode CreateNotNode(CFGParser.ExprContext ctx){
        NotNode node = new NotNode();
        node.Expression = (ExpressionNode)visitExpr(ctx.expr().get(0));
        return node;
    }

    private boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private InfixExpressionNode CreateInFixExprNode(CFGParser.ExprContext ctx){
        InfixExpressionNode node = null;

        if(ctx.MultiOp() != null){
            if(ctx.MultiOp().toString().equals("*"))
                node = CreateTimesNode(ctx);
            else if(ctx.MultiOp().toString().equals("/"))
                node = CreateDivisionNode(ctx);
            else if(ctx.MultiOp().toString().equals("%"))
                node = CreateModuloNode(ctx);
        }
        else if(ctx.AdditiveOp() != null){
            if(ctx.AdditiveOp().toString().equals("+"))
                node = CreatePlusNode(ctx);
            else if(ctx.AdditiveOp().toString().equals("-"))
                node = CreateMinusNode(ctx);
        }
        else if(ctx.BoolOp() != null){
            if(ctx.BoolOp().toString().equals("and"))
                node = CreateAndNode(ctx);
            else if(ctx.BoolOp().toString().equals("or"))
                node = CreateOrNode(ctx);
        }

        else if(ctx.RelativeOp() != null){
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
        else if(ctx.Hat() != null)
            node = CreateExponentNode(ctx);

        return node;
    }

    private MultiplicationNode CreateTimesNode(CFGParser.ExprContext ctx){
        InfixExpressionNode node = new MultiplicationNode();

        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return (MultiplicationNode) node;
    }

    private DivisionNode CreateDivisionNode(CFGParser.ExprContext ctx){
        DivisionNode node = new DivisionNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private ModuloNode CreateModuloNode(CFGParser.ExprContext ctx){
        ModuloNode node = new ModuloNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private AdditionNode CreatePlusNode(CFGParser.ExprContext ctx){
        AdditionNode node = new AdditionNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private SubtractionNode CreateMinusNode(CFGParser.ExprContext ctx){
        SubtractionNode node = new SubtractionNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private AndNode CreateAndNode(CFGParser.ExprContext ctx){
        AndNode node = new AndNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private OrNode CreateOrNode(CFGParser.ExprContext ctx){
        OrNode node = new OrNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private LessThanNode CreateLessThanNode(CFGParser.ExprContext ctx){
        LessThanNode node = new LessThanNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private GreaterThanNode CreateGreaterThanNode(CFGParser.ExprContext ctx){
        GreaterThanNode node = new GreaterThanNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private EqualsNode CreateEqualsNode(CFGParser.ExprContext ctx){
        EqualsNode node = new EqualsNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private NotEqualsNode CreateNotEqualsNode(CFGParser.ExprContext ctx){
        NotEqualsNode node = new NotEqualsNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private LEQNode CreateLEQNode(CFGParser.ExprContext ctx){
        LEQNode node = new LEQNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private GEQNode CreateGEQNode(CFGParser.ExprContext ctx){
        GEQNode node = new GEQNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private PowerNode CreateExponentNode(CFGParser.ExprContext ctx){
        PowerNode node = new PowerNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));

        return node;
    }

    private ArrayAccessNode CreateArrayAccessNode(CFGParser.ExprContext ctx){
        ArrayAccessNode node = new ArrayAccessNode();
        node.id = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.index = (ExpressionNode) visitExpr(ctx.expr().get(1));

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
        FuncCallNode func = new FuncCallNode();
        func.childList.add(visitId(ctx.id()));
        func.childList.add(visitAParamList(ctx.aParamList()));

        return func;
    }

    @Override
    public AbstractNode visitEventDcl(CFGParser.EventDclContext ctx) {
        EventDeclarationNode CDN = new EventDeclarationNode();
        CDN.childList.add(visitId(ctx.id()));
        CDN.childList.add(visitBlock(ctx.block()));

        return CDN;
    }

    @Override
    public AbstractNode visitAParamList(CFGParser.AParamListContext ctx) {
        ActualParameterNode APN = new ActualParameterNode();

        while(ctx != null){
            APN.childList.add(visitExpr(ctx.expr()));//vi smider alle expr's med som children
            ctx = ctx.aParamList();
        }

        return APN;
    }

    @Override
    public AbstractNode visitCtrlStruct(CFGParser.CtrlStructContext ctx) {

        if (ctx.aif() != null) {//hvis det er en if. "if if" med andre ord.
            IfControlStructureNode IfNode = (IfControlStructureNode)visitAif(ctx.aif());

            if (!ctx.aelseif().isEmpty()) {
                for (CFGParser.AelseifContext CTX : ctx.aelseif()) {
                    IfNode.childList.add(visitExpr(CTX.expr())); //vi tilføjer alle else-if'erne
                    IfNode.childList.add(visitBlock(CTX.block()));
                }
            }

            if (ctx.aelse() != null) { //Og en else, hvis der er en.
                IfNode.childList.add(visitBlock(ctx.aelse().block()));
            }

            return IfNode;
        }

        else if (ctx.For() != null){//Hvis det er en for
            ForNode FN = new ForNode();
            if (ctx.dcl() != null){//I denne if-kæde afgør vi om det første led i for-løkken er en dcl
                FN.childList.add(visitDcl(ctx.dcl()));
            }
            else if (ctx.expr() != null){ //Nu vil vi gerne tilføje alle expressions (som også kan være id) til childlisten. Der kan max være 2.
                for (CFGParser.ExprContext exprContext: ctx.expr()) {
                    FN.childList.add(visitExpr(exprContext));
                }
            }
            else
                return null;

            //Vi sætter en bool, der afgør om løkken kører op eller ned.
            //Incremental == kører opad.
            FN.Incremental = ctx.Downto() == null;

            FN.childList.add(visitBlock(ctx.block())); //Her er blokken af koden, der skal udføres.

            return FN;
        }

        else if (ctx.While() != null){ //While-noden får en expression og en block.
            WhileNode node = new WhileNode();
            node.childList.add(visitExpr(ctx.expr(0))); //En while controlstruct kan kun have en expression
            node.childList.add(visitBlock(ctx.block()));
            return node;
        }

        else //Burde ikke ske. Vi returnere null, hvis det går helt galt.
            return null;
    }

    @Override
    public AbstractNode visitAif(CFGParser.AifContext ctx) {
        IfControlStructureNode ICSN = new IfControlStructureNode(); //Vi smider if'ens egen expr og block ind i blokken.
        ICSN.childList.add(visitExpr(ctx.expr()));
        ICSN.childList.add(visitBlock(ctx.block()));


        return ICSN;
    }

    @Override
    public AbstractNode visitId(CFGParser.IdContext ctx) {
        IdNode node = new IdNode();

        node.name = ctx.Name().toString();

        while(ctx.id() != null){
            node.name = node.name + "." + ctx.id().Name().toString();
            ctx = ctx.id();
        }
        if(ctx.Squarel() != null){
            node.name = node.name + "[" + "]";
        }

        return node;
    }
}
