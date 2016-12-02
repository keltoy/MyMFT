package com.bjut.soft.rule.ruleImpl;

import com.bjut.soft.graph.INode;
import com.bjut.soft.rule.IRule;
import com.bjut.soft.rule.RuleFactory;
import com.bjut.soft.utils.ListUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by toy on 29/11/2016.
 */
public class RuleT2_2 implements IRule {
    private String name;
    private int y1;
    private int y2;
    private int q1;
    private int q2;

    private RuleT2_2(String name, int y1, int y2, int q1, int q2) {
        this.name = name;
        this.y1 = y1;
        this.y2 = y2;
        this.q1 = q1;
        this.q2 = q2;
    }

    public static IRule getRule(String name, int y1, int y2, int q1, int q2) {
        return new RuleT2_2(name, y1, y2, q1, q2);
    }

    @Override
    public int getY1() {
        return y1;
    }

    @Override
    public int getY2() {
        return y2;
    }

    @Override
    public void genMatchedNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {

    }

    @Override
    public void genOtherNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name) {

    }

    @Override
    public void genBacktrackNodes(List<INode> nodes, INode node) {

    }

    @Override
    public int getQ1() {
        return q1;
    }

    @Override
    public int getQ2() {
        return q2;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public INode productNode(int layer, INode y1, INode y2, int type, List<INode> list) {
        Map<Integer, IRule> rules = RuleFactory.getRules();
        IRule ruleQ1 = rules.get(getQ1());
        IRule ruleQ2 = rules.get(getQ2());
        INode nodeQ2 = ruleQ2.productNode(layer, y1, y2, this.getQ2(), list);
        INode nodeQ1 = ruleQ1.productNode(layer, nodeQ2, y2, this.getQ1(), list);
        ListUtils.addToList(nodeQ2, list);
        return nodeQ1;
    }


}
