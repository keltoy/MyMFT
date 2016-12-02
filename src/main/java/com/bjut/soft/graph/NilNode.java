package com.bjut.soft.graph;

/**
 * Created by toy on 29/11/2016.
 */
public class NilNode implements INode {
    @Override
    public int getLayer() {
        return 0;
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public int getType() {
        return -1;
    }

    @Override
    public void setY1(INode y1) {
    }

    @Override
    public void setLayer(int layer) {

    }

    @Override
    public void setY2(INode y2) {
    }

    @Override
    public INode getY1() {
        return this;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public INode getY2() {
        return this;
    }

    @Override
    public INode copyNode() {
        return Node.nil;
    }

}
