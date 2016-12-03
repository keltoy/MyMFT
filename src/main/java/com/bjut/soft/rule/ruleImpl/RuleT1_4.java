package com.bjut.soft.rule.ruleImpl;

import com.bjut.soft.graph.INode;
import com.bjut.soft.graph.Node;
import com.bjut.soft.rule.IRule;
import com.bjut.soft.rule.PathRule;
import com.bjut.soft.utils.ListUtils;

import java.util.List;

/**
 * Created by toy on 29/11/2016.
 */
public class RuleT1_4 extends PathRule {
    private RuleT1_4(String name, int y1, int q1, int q2) {
        super(name, y1, q1, q2);
    }

    @Override
    public void genMatchedNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        INode y2 = node.copyNode();
        y2.setY1(node);
        y2.setLayer(node.getLayer()+1);
        INode y1 = q2.productNode(node.getLayer()+1, y2, Node.nil, this.getQ2(), nodes);
        INode newNode = q1.productNode(node.getLayer()+1, y1, y2, q1.getQ1(), nodes);

        ListUtils.addToList(newNode, nodes);
        ListUtils.addToList(y1, nodes);
        ListUtils.addToList(y2, nodes);
    }

    @Override
    public void genOtherNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        INode newNode = node.copyNode();
        newNode.setY1(node);
        newNode.setLayer(node.getLayer()+1);
        ListUtils.addToList(newNode, nodes);
    }

    @Override
    public void genBacktrackNodes(List<INode> nodes, INode node) {
        ListUtils.backtrackToList(node.getY1(), nodes, node.getLayer());
    }

    public static IRule getRule(String name, int y1, int q1, int q2) {
        return new RuleT1_4(name, y1, q1, q2);
    }

}
