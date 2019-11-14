package ru.ifmo.se.s267880.pip.lab3;

import java.util.*;
import java.util.stream.Collectors;

public class EditorBean {
    private Double x;
    private Map<Double, Boolean> y = new TreeMap<>();
    private double r;

    public EditorBean() {}

    public List<CheckingHitQuery> generateQueries() {
        if (x == null) {
            return Collections.emptyList();
        }

        return y.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(entry -> new CheckingHitQuery(x, entry.getKey(), r))
                .collect(Collectors.toList());
    }

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
