package com.bjut.soft.rule;

/**
 * Created by toy on 29/11/2016.
 */
public abstract class PredRule extends PathRule {
    protected int y2;

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public PredRule(String name, int y1, int y2, int q1, int q2) {
        super(name, y1, q1, q2);
        this.y2 = y2;
    }
}
