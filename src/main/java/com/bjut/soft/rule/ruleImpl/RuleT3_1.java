package com.bjut.soft.rule.ruleImpl;

import com.bjut.soft.graph.INode;
import com.bjut.soft.rule.IRule;
import com.bjut.soft.rule.PredRule;
import com.bjut.soft.utils.ListUtils;

import java.util.List;

/**
 * Created by toy on 29/11/2016.
 */
public class RuleT3_1 extends PredRule {
    private RuleT3_1(String name, int y1, int y2, int q1, int q2) {
        super(name, y1, y2, q1, q2);
    }

    public static IRule getRule(String name, int y1, int y2, int q1, int q2) {
        return new RuleT3_1(name, y1, y2, q1, q2);
    }

    @Override
    public void genMatchedNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        INode y2 = node;
        INode y1 = node.getY1();
        INode newNode = q1.productNode(node.getLayer()+1, y1, y2, this.getQ1(), nodes);
        ListUtils.addToList(newNode, nodes);
    }

    @Override
    public void genOtherNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        ListUtils.addToList(node, nodes);
    }

    @Override
    public void genBacktrackNodes(List<INode> nodes, INode node) {
        ListUtils.backtrackToList(node.getY2(), nodes);
    }

}
