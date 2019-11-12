package ru.ifmo.se.s267880.pip.lab3;

import ru.ifmo.se.s267880.utils.Range;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("variantData")
@ApplicationScoped
public class VariantData implements Serializable {
    private Range xRange = new Range(-3, 3);
    private Range yRange = new Range(-5, 5, 1);
    private Range rRange = new Range(1, 3);

    public Range getxRange() {
        return xRange;
    }

    public Range getyRange() {
        return yRange;
    }

    public Range getrRange() {
        return rRange;
    }

}
