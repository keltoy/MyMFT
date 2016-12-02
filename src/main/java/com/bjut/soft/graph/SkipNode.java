package com.bjut.soft.graph;

/**
 * Created by toy on 29/11/2016.
 */
public class SkipNode implements INode {
    private String tagName;
    private int layer;
    private INode y1;

    public String getTagName() {
        return tagName;
    }

    @Override
    public int getType() {
        return -3;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public INode getY1() {
        return y1;
    }

    @Override
    public INode getY2() {
        return y1;
    }

    @Override
    public INode copyNode() {
        return this;
    }

    public void setY1(INode y1) {
        this.y1 = y1;
    }

    @Override
    public void setY2(INode y2) {

    }

    private SkipNode(String name, int layer, INode y1) {
        this.tagName = name;
        this.layer = layer;
        this.y1 = y1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static INode getNode(String name, int layer, INode y1) {
        return new SkipNode(name, layer, y1);
    }
}
