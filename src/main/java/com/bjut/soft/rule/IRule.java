package com.bjut.soft.rule;

import com.bjut.soft.graph.INode;

import java.util.List;

/**
 * Created by toy on 27/11/2016.
 */
public interface IRule {
    int getY1();
    int getY2();
    void genMatchedNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name);
    void genOtherNodes(List<INode> nodes, INode node, IRule q1, IRule q2, String name);
    void genBacktrackNodes(List<INode> nodes, INode node);
    int getQ1();
    int getQ2();
    String getName();
    INode productNode(int layer, INode y1, INode y2, int type, List<INode> list);

}
