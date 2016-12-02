package com.bjut.soft.rule;

import com.bjut.soft.graph.INode;
import com.bjut.soft.graph.Node;

import java.util.List;

/**
 * Created by toy on 28/11/2016.
 */
public abstract class PathRule implements IRule{
    protected String name;
    protected int y1;
    protected int q1;
    protected int q2;

    public int getQ1() {
        return q1;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    public int getQ2() {
        return q2;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    public int getY2() {return -1;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }


    public PathRule(String name, int y1, int q1, int q2) {
        this.y1 = y1;
        this.name = name;
        this.q1 = q1;
        this.q2 = q2;
    }

    @Override
    public INode productNode(int layer, INode y1, INode y2, int type, List<INode> list) {
        return Node.getNode(name, layer, type, y1, y2);
    }

}
