package ru.ifmo.se.s267880.pip.lab3;

import java.util.HashMap;
import java.util.Map;

public class EditorBean {
    private Double x;
    private Map<Double, Boolean> y = new HashMap<>();
    private double r;

    public EditorBean() {}

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Map<Double, Boolean> getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}
