package com.bjut.soft.graph;

/**
 * Created by toy on 29/11/2016.
 */
public class Node implements INode {
    protected int layer;
    protected String tagName;
    protected int type;
    protected INode y1;
    protected INode y2;

    /*public static final INode nil = new NilNode();*/

    public INode getY1() {
        return y1;
    }

    public void setY1(INode y1) {
        this.y1 = y1;
    }

    public INode getY2() {
        return y2;
    }

    @Override
    public INode copyNode(int layer, INode y1, INode y2) {
        return new Node(tagName, layer, type, y1, y2);
        /*
        try {
            return (INode)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return Node.nil;
        */
    }

    public void setY2(INode y2) {
        this.y2 = y2;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private Node(String name, int layer, int type, INode y1, INode y2) {
        this.layer = layer;
        this.tagName = name;
        this.type = type;
        this.y1 = y1;
        this.y2 = y2;
    }

    public static INode getNode(String tagName, int layer, int type, INode y1, INode y2) {
        return new Node(tagName, layer, type, y1, y2);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        /*return new Node(this.tagName, this.layer, this.type, this, this.y2);*/
        return super.clone();
    }
}
