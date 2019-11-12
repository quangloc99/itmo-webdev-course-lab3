package ru.ifmo.se.s267880.utils;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import static ru.ifmo.se.s267880.utils.Math.eps;

public class Range implements Iterable<Double> {
    private double low;
    private double high;
    private double step;

    public Range(double low, double high, double step) {
        this.low = low;
        this.high = high;
        this.step = step;
    }

    public Range(double low, double high) {
        this(low, high, 1);
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }

    public double getStep() {
        return step;
    }

    public boolean contains(double val) {
        return low -eps < val && val < high + eps;
    }


    @Override
    public Iterator<Double> iterator() {
        if (step <= 0) {
            throw new IllegalArgumentException("step must be positive.");
        }
        return new Iterator<Double>() {
            double cur = low;
            @Override
            public boolean hasNext() {
                return cur < high + eps;
            }

            @Override
            public Double next() {
                double oldVal = cur;
                cur += step;
                return oldVal;
            }
        };
    }

    public String toJSON() {
        return String.format(Locale.US, "{"+
                "\"low\": %f, " +
                "\"high\": %f, " +
                "\"step\": %f" +
                "}", low, high, step);
    }

    /**
     * For the sake of JSTL. It accepts only List, Map, array, Iterator but not Iterable.
     * @return the list representation of the range.
     */
    public List<Double> getListRepresentation() {
        List<Double> res = new LinkedList<>();
        for (double i = low; i <= high + eps; i += step) {
            res.add(i);
        }
        return res;
    }
}