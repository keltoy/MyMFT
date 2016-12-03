package com.bjut.soft.rule.ruleImpl;

import com.bjut.soft.graph.INode;
import com.bjut.soft.rule.IRule;
import com.bjut.soft.rule.PredRule;
import com.bjut.soft.utils.ListUtils;

import java.util.List;

/**
 * Created by toy on 29/11/2016.
 */
public class RuleT3_2 extends PredRule {
    private RuleT3_2(String name, int y1, int y2, int q1, int q2) {
        super(name, y1, y2, q1, q2);
    }

    public static IRule getRule(String name, int y1, int y2, int q1, int q2) {
        return new RuleT3_2(name, y1, y2, q1, q2);
    }

    @Override
    public void genMatchedNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        INode y2 = node.copyNode();
        y2.setY2(node);
        y2.setLayer(node.getLayer()+1);
        INode y1 = node.getY1();
        INode newNode = q1.productNode(node.getLayer()+1, y1, y2, this.q1, nodes);
        ListUtils.addToList(newNode, nodes);
        ListUtils.addToList(y2, nodes);
    }

    @Override
    public void genOtherNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        INode newNode = node.copyNode();
        newNode.setY2(node);
        newNode.setLayer(node.getLayer()+1);
        ListUtils.addToList(newNode, nodes);
    }

    @Override
    public void genBacktrackNodes(List<INode> nodes, INode node) {
        ListUtils.backtrackToList(node.getY2(), nodes, node.getLayer());
    }

}
