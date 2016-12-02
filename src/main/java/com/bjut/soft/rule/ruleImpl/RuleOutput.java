package com.bjut.soft.rule.ruleImpl;

import com.bjut.soft.graph.INode;
import com.bjut.soft.graph.Node;
import com.bjut.soft.rule.IRule;
import com.bjut.soft.utils.ListUtils;

import java.util.List;

/**
 * Created by toy on 02/12/2016.
 */
public class RuleOutput implements IRule {

    private static final IRule instance = new RuleOutput();

    @Override
    public int getY1() {
        return 0;
    }

    @Override
    public int getY2() {
        return 0;
    }

    @Override
    public void genMatchedNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        ListUtils.addToList(node, nodes);
    }

    @Override
    public void genOtherNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        ListUtils.addToList(node, nodes);

    }

    @Override
    public void genBacktrackNodes(List<INode> nodes, INode node) {
        System.out.println(node.getTagName());
    }

    @Override
    public int getQ1() {
        return 0;
    }

    @Override
    public int getQ2() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public INode productNode(int layer, INode y1, INode y2, int type, List<INode> list) {
        return Node.nil;
    }

    public static IRule getRule() {
        return instance;
    }
}
