package com.bjut.soft.graph;


/**
 * Created by toy on 29/11/2016.
 */
public interface INode extends Cloneable{
    int getLayer();
    String getTagName();
    int getType();
    void setY1(INode y1);
    void setLayer(int layer);
    void setY2(INode y2);
    INode getY1();
    INode getY2();
    INode copyNode(int layer, INode y1, INode y2);
    INode nil = new NilNode();
}
