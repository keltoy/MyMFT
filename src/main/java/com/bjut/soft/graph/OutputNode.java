package com.bjut.soft.graph;

import com.bjut.soft.utils.TagUtils;

/**
 * Created by toy on 29/11/2016.
 */
public class OutputNode implements INode {
    private String tagName;
    private int layer;
    private INode y1;

    public String getTagName() {
        return tagName;
    }

    @Override
    public int getType() {
        return -2;
    }

    public int getLayer() {
        return layer;
    }

    public INode getY1() {
        return y1;
    }

    @Override
    public INode getY2() {
        return y1;
    }

    @Override
    public INode copyNode(int layer, INode y1, INode y2) {
        return this;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public void setY1(INode y1) {
        this.y1 = y1;
    }

    @Override
    public void setY2(INode y2) {

    }

    public OutputNode(String name, int layer, INode y1) {
        this.tagName = name;
        this.layer = layer;
        this.y1 = y1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static INode getNode(String name, int layer, INode y1) {
        /*
        TagUtils path = TagUtils.getPath();
        String tmp = path.toString();
        return new OutputNode(tmp, layer, y1);
        */
        return new OutputNode(name, layer, y1);
    }
}
