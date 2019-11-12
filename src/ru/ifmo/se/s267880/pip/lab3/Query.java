package ru.ifmo.se.s267880.pip.lab3;

import java.io.Serializable;

public class Query implements Serializable {
    private double x;
    private double y;
    private double r;
    private Boolean result = null;

    public Query(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    boolean getResult() {
        if (result != null) return result;

        // TODO check the result
        return false;
    }

    @Override
    public String toString() {
        return "Query{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }
}
