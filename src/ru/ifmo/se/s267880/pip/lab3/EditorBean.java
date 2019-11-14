package ru.ifmo.se.s267880.pip.lab3;

import java.util.*;
import java.util.stream.Collectors;

public class EditorBean {
    private Double x;
    private Map<Double, Boolean> y = new TreeMap<>();
    private double r;
    private List<CheckingHitQuery> generatedQueries;

    public EditorBean() {}

    public List<CheckingHitQuery> getGeneratedQueries() {
        if (generatedQueries != null) return generatedQueries;
        if (x == null) {
            return generatedQueries = Collections.emptyList();
        }

        return generatedQueries = y.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(entry -> new CheckingHitQuery(x, entry.getKey(), r))
                .collect(Collectors.toList());
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        generatedQueries = null;
        this.x = x;
    }

    public Map<Double, Boolean> getY() {
        generatedQueries = null;
        return y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        generatedQueries = null;
        this.r = r;
    }
}
