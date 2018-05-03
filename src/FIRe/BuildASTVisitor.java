package FIRe;


import FIRe.Parser.*;
import FIRe.Nodes.*;

public class BuildASTVisitor extends CFGBaseVisitor<AbstractNode> {

    //Skal override dem alle, lige som ham på stackoverflow.

    //Visitis the very first node of the CST
    @Override
    public AbstractNode visitProg(CFGParser.ProgContext ctx){
        ProgNode root = new ProgNode();
        root.childList.add(visitRobotDcl(ctx.robotDcl()));
        root.LineNumber = ctx.start.getLine();
        for(CFGParser.ProgBodyContext progBodyCtx: ctx.progBody()){
            root.childList.add(visitProgBody(progBodyCtx)); //Vi tilføjer alle  progbodies, idet vi visiter dem.
        }

        return root;
    }

    //Methods has an if-else for each possible node in the xontext ctx.
    @Override
    public AbstractNode visitProgBody(CFGParser.ProgBodyContext ctx){
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
    public AbstractNode visitStrategyDcl(CFGParser.StrategyDclContext ctx){
        StrategyDeclarationNode node = new StrategyDeclarationNode();//Makes a new node
        node.LineNumber = ctx.start.getLine();
        //node.childList.add(visitId(ctx.id()));
        node.Id = (IdNode)visitId(ctx.id());
        node.childList.add(visitFParamList(ctx.fParamList())); //Add the fParamList

        if(ctx.blockBody() != null)
            for(CFGParser.BlockBodyContext blockBodyCtx: ctx.blockBody()) {
                node.childList.add(visitBlockBody(blockBodyCtx)); //And the block
            }

        for(CFGParser.StrategyBlockContext strategyBlockCtx : ctx.strategyBlock())
            node.childList.add(visitStrategyBlock(strategyBlockCtx)); //And it's strategy block (routines og whens)
        node.childList.add(node.Id);
        return node;
    }

    //Determines wheter visitWhen should be called or visitRoutine
    @Override
    public AbstractNode visitStrategyBlock(CFGParser.StrategyBlockContext ctx){
        if(ctx.when() != null) //Finds the right visit method.
            return(visitWhen(ctx.when()));
        else if(ctx.routine() != null)
            return (visitRoutine(ctx.routine()));
        else
            return null;
    }

    //creates a new FunctionDeclNode, sets the type of it, add the fParamlist and the block
    @Override
    public AbstractNode visitFuncDcl(CFGParser.FuncDclContext ctx){
        FunctionDeclarationNode node = new FunctionDeclarationNode();
        node.LineNumber = ctx.start.getLine();

        if (ctx.funcType().Type() != null)
            node.Type = ctx.funcType().Type().toString();
        else
            node.Type = ctx.funcType().Void().toString();

        node.Id = (IdNode) visitId(ctx.id());
        if(ctx.fParamList() != null)//fparamlist er optional.
            node.childList.add(visitFParamList(ctx.fParamList()));
        node.childList.add(visitBlock(ctx.block()));
        node.childList.add(node.Id);

        return node;
    }

    //adds all the blockbodies as children, a blockbody can evaluate to a dcl or a Stmt

    @Override
    public AbstractNode visitBlock(CFGParser.BlockContext ctx){

        BlockNode blockNode = new BlockNode();
        blockNode.LineNumber = ctx.start.getLine();

        for(CFGParser.BlockBodyContext blockBodyCtx : ctx.blockBody())
            blockNode.childList.add(visitBlockBody(blockBodyCtx)); //Add all the blockbodies as children

        return blockNode;
    }

    //determines wheter a blockbody is a dcl or stmt
    @Override
    public AbstractNode visitBlockBody(CFGParser.BlockBodyContext ctx){
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
        if (ctx != null)
            node.LineNumber = ctx.start.getLine();
        while(ctx != null) {
            /* We map an id to a type in a map (known as a dictionary in C#,
            to easily find the type of an id*/
            IdNode idNode = (IdNode) visitId(ctx.id());
            node.parameterMap.put(idNode, ctx.Type().toString());

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
        RobotPropertiesNode robotPropertiesNode = new RobotPropertiesNode();

        for (int i = 0; i < ctx.robotDclBody().id().size(); ++i) {
            switch (ctx.robotDclBody().id(i).Name().getText()) {
                case "RobotName":
                    robotPropertiesNode.childList.add(new RobotNameNode(ctx.robotDclBody().id(i + 1).getText(), ctx.robotDclBody().id(i + 1).getStart().getLine()));
                    break;
                case "RobotType":
                    robotPropertiesNode.childList.add(new RobotTypeNode(ctx.robotDclBody().id(i + 1).getText(), ctx.robotDclBody().id(i + 1).getStart().getLine()));
                    break;
                case "BodyColor":
                    robotPropertiesNode.childList.add(new BodyColorNode(ctx.robotDclBody().id(i + 1).getText(), ctx.robotDclBody().id(i + 1).getStart().getLine()));
                    break;
                case "GunColor":
                    robotPropertiesNode.childList.add(new GunColorNode(ctx.robotDclBody().id(i + 1).getText(), ctx.robotDclBody().id(i + 1).getStart().getLine()));
                    break;
                case "RadarColor":
                    robotPropertiesNode.childList.add(new RadarColorNode(ctx.robotDclBody().id(i + 1).getText(), ctx.robotDclBody().id(i + 1).getStart().getLine()));
                    break;
            }
            i++;
        }


        return robotPropertiesNode;
    }

    //This method handles the dcl rule from the cfg, multiple cases exists since we have different types and
    //multiple declerations can be made at once
    @Override
    public AbstractNode visitDcl(CFGParser.DclContext ctx) {
        if (ctx.id().size() == 1) { // If there is an expr we assume the first rule
            if (ctx.children.size() <= 2 || !ctx.children.get(2).getText().equals("[")) { //If it is not an array
                if (ctx.Type().toString().equals("number")) {

                    NumberDeclarationNode numberDeclarationNode = new NumberDeclarationNode();
                    numberDeclarationNode.LineNumber = ctx.start.getLine();
                    numberDeclarationNode.Id = (IdNode) visitId(ctx.id(0));
                    numberDeclarationNode.childList.add(numberDeclarationNode.Id);

                    if (ctx.expr() != null)
                        numberDeclarationNode.childList.add(visitExpr(ctx.expr()));
                    else {
                        numberDeclarationNode.childList.add(new NumberNode(0));
                        System.out.println("WARNING: Unassigned number variable has been indirectly assigned to 0 at line " + numberDeclarationNode.LineNumber);
                    }
                    
                    return numberDeclarationNode;
                } else if (ctx.Type().toString().equals("text")) {

                    TextDeclarationNode textDeclarationNode = new TextDeclarationNode();
                    textDeclarationNode.LineNumber = ctx.start.getLine();
                    textDeclarationNode.Id = (IdNode) visitId(ctx.id(0));
                    textDeclarationNode.childList.add(textDeclarationNode.Id);

                    if (ctx.expr() != null)
                        textDeclarationNode.childList.add(visitExpr(ctx.expr()));
                    else {
                        textDeclarationNode.childList.add(new TextNode(""));
                        System.out.println("WARNING: Unassigned text variable has been indirectly assigned to \"\" at line " + textDeclarationNode.LineNumber);
                    }

                    return textDeclarationNode;
                } else if (ctx.Type().toString().equals("bool")) {

                    BooleanDeclarationNode booleanDeclarationNode = new BooleanDeclarationNode();
                    booleanDeclarationNode.Id =  (IdNode) visitId(ctx.id(0));
                    booleanDeclarationNode.LineNumber = ctx.start.getLine();
                    booleanDeclarationNode.childList.add(booleanDeclarationNode.Id);

                    if (ctx.expr() != null)
                        booleanDeclarationNode.childList.add(visitExpr(ctx.expr()));
                    else {
                        booleanDeclarationNode.childList.add(new BoolNode(false));
                        System.out.println("WARNING: Unassigned boolean variable has been indirectly assigned to false at line " + booleanDeclarationNode.LineNumber);
                    }

                    return booleanDeclarationNode;
                } else
                    return null;
            }
            else if (ctx.id().size() == 1){//If it is an array
                ArrayDeclarationNode ADN;
                if (ctx.Type().toString().equals("number")) {
                    ADN = new NumberArrayDeclarationNode((IdNode) visitId(ctx.id(0)));
                } else if (ctx.Type().toString().equals("bool"))
                    ADN = new BoolArrayDeclarationNode((IdNode) visitId(ctx.id(0)));
                else if (ctx.Type().toString().equals("text"))
                    ADN = new TextArrayDeclarationNode((IdNode) visitId(ctx.id(0)));
                else {
                    System.out.println("Error in arraydeclaration"); //should throw an exception
                    ADN = null;
                }

                ADN.LineNumber = ctx.start.getLine();
                ADN.childList.add(visit(ctx.id(0)));
                ADN.Id = (IdNode) ADN.childList.get(0);
                if (ctx.expr() != null) {
                    ADN.childList.add(visit(ctx.expr()));
                    ADN.Size = (ExpressionNode)ADN.childList.get(1);
                }
                //ADN.childList.add(visit(ctx.expr()));
                /*for (AbstractNode AN : ADN.childList) {
                    if (AN instanceof IdNode)
                        ADN.Id = (IdNode) AN;
                }
                for (AbstractNode AN : ADN.childList) {
                    if (AN instanceof ExpressionNode)
                        ADN.Size = (ExpressionNode) AN;
                }*/
                return ADN;
            }
        }
        else if(ctx.Comma() != null){ //Multiple Declarations
            if (ctx.Type().toString().equals("number")) {
                NumberDeclarationNode numberDeclarationNode = new NumberDeclarationNode();
                numberDeclarationNode.LineNumber = ctx.start.getLine();
                for (CFGParser.IdContext idContext : ctx.id()) {
                    numberDeclarationNode.childList.add(visitId(idContext)); //we add the dcls as children
                }
                return numberDeclarationNode;
            } else if (ctx.Type().toString().equals("text")) {

                TextDeclarationNode textDeclarationNode = new TextDeclarationNode();
                textDeclarationNode.LineNumber = ctx.start.getLine();
                for (CFGParser.IdContext idContext : ctx.id()) {
                    textDeclarationNode.childList.add(visitId(idContext));//We add the dcls as children
                }
                return textDeclarationNode;
            } else if (ctx.Type().toString().equals("bool")) {

                BooleanDeclarationNode booleanDeclarationNode = new BooleanDeclarationNode();
                booleanDeclarationNode.LineNumber = ctx.start.getLine();
                for (CFGParser.IdContext idContext : ctx.id()) {
                    booleanDeclarationNode.childList.add(visitId(idContext));//We add the dcls as children
                }
                return booleanDeclarationNode;
            } else
                return null; //Exception?
        }
        return null;
    }

    // Decides the "type" of statement (according to the CFG) and calls the appropriate method for the specific type, it
    // should never return null
    @Override
    public AbstractNode visitStmt(CFGParser.StmtContext ctx) {
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
            return new ReturnNode(visitExpr(ctx.expr()),ctx.Return().getSymbol().getLine());
        }
        else
            return  null;

    }

    // A routine can exist with or without a condition expression, this method construct the routine node accordingly,
    // by visiting the appropriate visit methods for the input of the RoutineNode constructor.
    @Override
    public AbstractNode visitRoutine(CFGParser.RoutineContext ctx) {
        //Her fremgår de forskellige slags routine-kald. med id, med Val og tom.
        if(ctx.expr() != null)
            return (new RoutineNode(visitExpr(ctx.expr()), visitBlock(ctx.block()),ctx.start.getLine()));
        else
            return(new RoutineNode(visitBlock(ctx.block()),ctx.start.getLine()));
    }

    // Construct the WhenNode by giving the constructor an eventtype and the variable name from the when's parenthesis.
    // It then adds the block to the when childlist.
    @Override
    public AbstractNode visitWhen(CFGParser.WhenContext ctx) {
        WhenNode when = new WhenNode(visitId(ctx.id().get(0)), visitId(ctx.id().get(1)));
        when.childList.add(visitBlock(ctx.block()));
        when.LineNumber = ctx.start.getLine();
        return when;
    }

    // Determines the kind of expression by testing for the expr terminal's different kinds of productions
    @Override
    public AbstractNode visitExpr(CFGParser.ExprContext ctx) {
        AbstractNode node = null;

        //In a production rule with one or zero expr
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
        //In a production rule with two expr
        else {
            if(ctx.Squarel() == null)
                node = CreateInFixExprNode(ctx);
            else if(ctx.Squarel()!= null)
                node = CreateArrayAccessNode(ctx);
        }

        return node;
    }

    // Help function for visitExpr that creates the BoolNode by using the context
    private BoolNode CreateBoolNode(CFGParser.ExprContext ctx){
        BoolNode node = new BoolNode(false);
        if(ctx.BoolVal().toString().equals("true"))
            node.value = true;
        else
            node.value = false;
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    // Help function for visitExpr that creates the ValNode by using the context, here we determine if the value is a
    // number or a text
    private ValNode CreateValNode(CFGParser.ExprContext ctx){
        ValNode node;
        if(tryParseDouble(ctx.Val().toString()))
            node = new NumberNode(Double.parseDouble(ctx.Val().toString()));
        else
            node = new TextNode(ctx.Val().toString());
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    // Help function for visitExpr that creates the NotNode by using the context
    private NotNode CreateNotNode(CFGParser.ExprContext ctx){
        NotNode node = new NotNode();
        node.Expression = (ExpressionNode)visitExpr(ctx.expr().get(0));
        node.LineNumber = ctx.start.getLine();
        node.childList.add(node.Expression);
        return node;
    }

    // Help function for CreateValNode that returns true if the value can be parsed as a double and false otherwise
    private boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Breaks down the InfixExpression by systematically checking what the context contains and then compare it to what
    // we know from the CFG.
    private InfixExpressionNode CreateInFixExprNode(CFGParser.ExprContext ctx){
        InfixExpressionNode node = null;

        //It is a expression with a multiplying operator
        if(ctx.MultiOp() != null){
            if(ctx.MultiOp().toString().equals("*"))
                node = CreateTimesNode(ctx);
            else if(ctx.MultiOp().toString().equals("/"))
                node = CreateDivisionNode(ctx);
            else if(ctx.MultiOp().toString().equals("%"))
                node = CreateModuloNode(ctx);
        }
        //It is a expression with an additive operator
        else if(ctx.AdditiveOp() != null){
            if(ctx.AdditiveOp().toString().equals("+"))
                node = CreatePlusNode(ctx);
            else if(ctx.AdditiveOp().toString().equals("-"))
                node = CreateMinusNode(ctx);
        }
        //It is a expression with a boolean operator
        else if(ctx.BoolOp() != null){
            if(ctx.BoolOp().toString().equals("and"))
                node = CreateAndNode(ctx);
            else if(ctx.BoolOp().toString().equals("or"))
                node = CreateOrNode(ctx);
        }

        //It is a expression with a relative operator
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
        //It is a exponential expresion
        else if(ctx.Hat() != null)
            node = CreateExponentNode(ctx);

        return node;
    }

    //Help function for the CreateInfixExprNode function, that construct the MultiplicationNode and adds its left and
    // right child.
    private MultiplicationNode CreateTimesNode(CFGParser.ExprContext ctx){
        InfixExpressionNode node = new MultiplicationNode();

        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return (MultiplicationNode) node;
    }

    //Help function for the CreateInfixExprNode function, that construct the DivisionNode and adds its left and right
    // child.
    private DivisionNode CreateDivisionNode(CFGParser.ExprContext ctx){
        DivisionNode node = new DivisionNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    //Help function for the CreateInfixExprNode function, that construct the ModuloNode and adds its left and right
    // child.
    private ModuloNode CreateModuloNode(CFGParser.ExprContext ctx){
        ModuloNode node = new ModuloNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    //Help function for the CreateInfixExprNode function, that construct the AdditionNode and adds its left and right
    // child.
    private AdditionNode CreatePlusNode(CFGParser.ExprContext ctx){
        AdditionNode node = new AdditionNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    //Help function for the CreateInfixExprNode function, that construct the MinusNode and adds its left and right
    // child.
    private SubtractionNode CreateMinusNode(CFGParser.ExprContext ctx){
        SubtractionNode node = new SubtractionNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }


    //Creating the AndNode and adding its left and right child.
    private AndNode CreateAndNode(CFGParser.ExprContext ctx){
        AndNode node = new AndNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    //Creating the CreateOrNode and adding its left and right child.
    private OrNode CreateOrNode(CFGParser.ExprContext ctx){
        OrNode node = new OrNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    //Creating the LessThanNode and adding its left and right child.
    private LessThanNode CreateLessThanNode(CFGParser.ExprContext ctx){
        LessThanNode node = new LessThanNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    ////Creating the GreaterThanNode and adding its left and right child.
    private GreaterThanNode CreateGreaterThanNode(CFGParser.ExprContext ctx){
        GreaterThanNode node = new GreaterThanNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    //Creating the EqualNode and adding its left and right child.
    private EqualsNode CreateEqualsNode(CFGParser.ExprContext ctx){
        EqualsNode node = new EqualsNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    //Creating the NotEqualNode and adding its left and right child.
    private NotEqualsNode CreateNotEqualsNode(CFGParser.ExprContext ctx){
        NotEqualsNode node = new NotEqualsNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    //Creating the LEQNode and adding its left and right child.
    private LEQNode CreateLEQNode(CFGParser.ExprContext ctx){
        LEQNode node = new LEQNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    //Creating the GEQNode and adding its left and right child.
    private GEQNode CreateGEQNode(CFGParser.ExprContext ctx){
        GEQNode node = new GEQNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }


    //Creating the PowerNode and adding its left and right child.
    private PowerNode CreateExponentNode(CFGParser.ExprContext ctx){
        PowerNode node = new PowerNode();
        node.LeftChild = (ExpressionNode) visitExpr(ctx.expr().get(0));
        node.RightChild = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();
        return node;
    }


    //Creating ArrayAccessNode which consists of a id followed by index.
    //Both id and index can be an expression, to allow fx f(x)[2+2];
    private ArrayAccessNode CreateArrayAccessNode(CFGParser.ExprContext ctx){
        ArrayAccessNode node = new ArrayAccessNode();
        node.Id = (IdNode) visitExpr(ctx.expr().get(0));
        node.index = (ExpressionNode) visitExpr(ctx.expr().get(1));
        node.LineNumber = ctx.start.getLine();

        node.childList.add(node.Id);
        node.childList.add(node.index);
        return node;
    }



    //Creating AssignNode, whihc consists of a id and the expression to be assigned to the id.
    @Override
    public AbstractNode visitAssignStmt(CFGParser.AssignStmtContext ctx) {
        AssignNode node = new AssignNode();

        node.Id = (IdNode)visitId(ctx.id());
        node.childList.add(node.Id);
        node.LineNumber = ctx.start.getLine();

        if(ctx.expr().size() > 1) {
            node.Id.ArrayIndex = (NumberNode)visitExpr(ctx.expr(0));
            node.Expression = (ExpressionNode)visitExpr(ctx.expr(1));
        }
        else {
            node.Expression = (ExpressionNode) visitExpr(ctx.expr(0));
        }
        node.childList.add(node.Expression);
        return node;
    }


    //Creating FuncCall, which consists of and id(funcname) and the actual parameters.
    @Override
    public AbstractNode visitFuncCall(CFGParser.FuncCallContext ctx) {
        FuncCallNode func = new FuncCallNode();
        func.childList.add(visitId(ctx.id()));
        func.childList.add(visitAParamList(ctx.aParamList()));
        func.LineNumber = ctx.start.getLine();
        func.Id = (IdNode)func.childList.get(0);
        func.Aparam = (ActualParameterNode) func.childList.get(1);
        return func;
    }


    //Creating Event declaration which consists of and id(eventname) and a body.
    @Override
    public AbstractNode visitEventDcl(CFGParser.EventDclContext ctx){
        EventDeclarationNode node = new EventDeclarationNode();

        node.Id = (IdNode) visitId(ctx.id());
        node.childList.add(visitBlock(ctx.block()));
        node.LineNumber = ctx.start.getLine();
        return node;
    }

    //Creating ActualParameterNode, which consists of an arbitrary number of expression.
    @Override
    public AbstractNode visitAParamList(CFGParser.AParamListContext ctx) {
        ActualParameterNode APN = new ActualParameterNode();

        while(ctx != null){
            APN.childList.add(visitExpr(ctx.expr()));//Adding the expressions.
            APN.childList.get(APN.childList.size() - 1).LineNumber = ctx.start.getLine();//Adding Linenumbers to the most recently added child
            ctx = ctx.aParamList();
        }

        return APN;
    }

    @Override
    public AbstractNode visitCtrlStruct(CFGParser.CtrlStructContext ctx){

        //If the constrolstructure is an "if".
        //Then adding all the else-if's.
        if (ctx.aif() != null) {
            IfControlStructureNode IfNode = (IfControlStructureNode)visitAif(ctx.aif());

            if (!ctx.aelseif().isEmpty()) {
                for (CFGParser.AelseifContext CTX : ctx.aelseif()) {
                    IfNode.childList.add(visitExpr(CTX.expr())); //Adding the else-ifs.
                    IfNode.childList.add(visitBlock(CTX.block()));
                }
            }

            if (ctx.aelse() != null) { //Adding the else-block if it exists.
                IfNode.childList.add(visitBlock(ctx.aelse().block()));
            }
            IfNode.LineNumber = ctx.start.getLine();

            return IfNode;
        }

        //If the constrolstructure is a for-loop.
        else if (ctx.For() != null){
            ForNode FN = new ForNode();
            if (ctx.dcl() != null){//Detemine whether the first part of the for-loops is a declaration.
                FN.Dcl = (NumberDeclarationNode) visitDcl(ctx.dcl());
                FN.To = (ExpressionNode)(visitExpr(ctx.expr(0)));
                FN.childList.add(FN.Dcl);
                FN.childList.add(FN.To);
            }
            else if (ctx.expr() != null){ //Adding the expressions (which can be an id as well) to the childList. Max 2.
                FN.From = (ExpressionNode)visitExpr(ctx.expr(0));
                FN.To = (ExpressionNode)visitExpr(ctx.expr(1));
                FN.childList.add(FN.From);
                FN.childList.add(FN.To);
            }
            else
                return null;

            //Setting a flag to determine if the for-loops counts up or down(if "upto" or "downto" is used).
            FN.Incremental = ctx.Downto() == null;

            //Adding the body of the for-loop to its childlist.
            FN.childList.add(visitBlock(ctx.block()));
            FN.LineNumber = ctx.start.getLine();
            return FN;
        }

        //Creating a whilenode, which consists of the expression(evaluation part) and a block
        else if (ctx.While() != null){
            WhileNode node = new WhileNode();
            node.childList.add(visitExpr(ctx.expr(0)));
            node.Expression = (ExpressionNode) node.childList.get(0);
            node.childList.add(visitBlock(ctx.block()));
            node.LineNumber = ctx.start.getLine();
            return node;
        }

        else //Shouldn't happen, returning null to indicate failure.
            return null;
    }



    //Creating a node to indicate a if-statement, which consists of the booleanexpression
    //followed by a block.
    @Override
    public AbstractNode visitAif(CFGParser.AifContext ctx){
        IfControlStructureNode ICSN = new IfControlStructureNode();
        ICSN.childList.add(visitExpr(ctx.expr()));
        ICSN.childList.add(visitBlock(ctx.block()));
        ICSN.LineNumber = ctx.start.getLine();

        return ICSN;
    }

    //Creating an idNode an performing actions acoording
    //to whether or not dot-notation or arrayindexing is used.

    @Override
    public AbstractNode visitId(CFGParser.IdContext ctx) {
        IdNode node = new IdNode();

        //Getting the nodes name
        if  (ctx.Name() != null)
            node.Name = ctx.Name().toString();

        node.LineNumber = ctx.getStart().getLine();

        //When dot-notation is used.
        while(ctx.id() != null){
            node.Name = node.Name + "." + ctx.id().Name().toString();
            ctx = ctx.id();
        }

        //If used to arrays indexing.
        //if(ctx.Squarel() != null){
        //    node.name = node.name + "[" + "]";
        //}

        node.LineNumber = ctx.start.getLine();
        return node;
    }
}
