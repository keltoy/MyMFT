package com.bjut.soft.utils;

import com.bjut.soft.graph.INode;
import com.bjut.soft.graph.Node;
import com.bjut.soft.rule.IRule;

import java.util.List;
import java.util.Queue;

/**
 * Created by toy on 01/12/2016.
 */
public class ListUtils {
    public static void addToList(INode node, Queue<INode> list) {
        if (node != null && node != Node.nil) {
            list.add(node);
        }
    }

    public static void backtrackToList(INode node, Queue<INode> list, int layer) {
        if (node.getLayer() == layer-1)
            list.add(node);
    }
}
