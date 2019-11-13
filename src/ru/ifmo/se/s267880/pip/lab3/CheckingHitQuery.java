package ru.ifmo.se.s267880.pip.lab3;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class CheckingHitQuery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double x;
    private double y;
    private double r;
    @Transient
    private Boolean hit = null;

    public CheckingHitQuery() {
    }

    public CheckingHitQuery(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    boolean isHit() {
        if (hit != null) return hit;

        // TODO check the result
        return false;
    }

    @Override
    public String toString() {
        return "CheckingHitQuery{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }

    public Long getId() {
        return id;
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
