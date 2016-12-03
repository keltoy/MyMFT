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
public class RuleT1_3 extends PathRule {
    private RuleT1_3(String name, int y1, int q1, int q2) {
        super(name, y1, q1, q2);
    }

    public static IRule getRule(String name, int y1, int q1, int q2) {
        return new RuleT1_3(name, y1, q1, q2);
    }

    @Override
    public void genMatchedNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        INode y2 = node;
        INode y1 = q2.productNode(node.getLayer()+1, node, Node.nil, this.q2, nodes);
        INode newNode = q1.productNode(node.getLayer()+1, y1, y2, this.q1, nodes);
        ListUtils.addToList(newNode, nodes);
        ListUtils.addToList(y1, nodes);
    }

    @Override
    public void genOtherNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        ListUtils.addToList(node, nodes);
    }

    @Override
    public void genBacktrackNodes(List<INode> nodes, INode node) {
        ListUtils.backtrackToList(node.getY1(), nodes, node.getLayer());
    }

}
