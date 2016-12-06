package com.bjut.soft.rule.ruleImpl;

import com.bjut.soft.graph.INode;
import com.bjut.soft.graph.Node;
import com.bjut.soft.rule.IRule;

import java.util.Queue;

/**
 * Created by toy on 29/11/2016.
 */
public class RuleT2_1 implements IRule {
    private int y1;

    private RuleT2_1(int y1) {
        this.y1 = y1;
    }

    public static IRule getRule(int y1) {
        return new RuleT2_1(y1);
    }

    @Override
    public int getY1() {
        return y1;
    }

    @Override
    public int getY2() {
        return 0;
    }

    @Override
    public void genMatchedNodes(Queue<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        System.out.println("T2-1 MatchedNode should not print");

    }

    @Override
    public void genOtherNodes(Queue<INode> nodes, INode node, IRule q1, IRule q2, String name) {
        System.out.println("T2-1 OtherNode should not print");
    }

    @Override
    public void genBacktrackNodes(Queue<INode> nodes, INode node) {
        System.out.println("T2-1 Backtrack should not print");
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
    public INode productNode(int layer, INode y1, INode y2, int type, Queue<INode> list) {
        //return Node.nil;
        return y1;
    }


}
