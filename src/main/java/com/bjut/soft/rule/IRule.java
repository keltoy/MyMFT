package com.bjut.soft.rule;

import com.bjut.soft.graph.INode;

import java.util.List;
import java.util.Queue;

/**
 * Created by toy on 27/11/2016.
 */
public interface IRule {
    int getY1();
    int getY2();
    void genMatchedNodes(Queue<INode> nodes, INode node, IRule q1, IRule q2, String name);
    void genOtherNodes(Queue<INode> nodes, INode node, IRule q1, IRule q2, String name);
    void genBacktrackNodes(Queue<INode> nodes, INode node);
    int getQ1();
    int getQ2();
    String getName();
    INode productNode(int layer, INode y1, INode y2, int type, Queue<INode> list);

}
