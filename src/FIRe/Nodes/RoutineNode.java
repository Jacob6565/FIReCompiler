package FIRe.Nodes;

import FIRe.ASTVisitor;

public class RoutineNode extends ControlStructureNode{
    public ExpressionNode repeatCondition;

    public RoutineNode(AbstractNode routineBlock, int lineNumber) {
        repeatCondition = null;
        childList.add(routineBlock);
        LineNumber = lineNumber;
    }

    public RoutineNode(AbstractNode expr, AbstractNode routineBlock, int lineNumber){
        repeatCondition = (ExpressionNode) expr;
        childList.add(repeatCondition);
        childList.add(routineBlock);
        LineNumber = lineNumber;
    }

    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        for(AbstractNode node : childList)
            node.accept(v, this);
    }
}
