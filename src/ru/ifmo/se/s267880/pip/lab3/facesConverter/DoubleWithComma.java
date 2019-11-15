package ru.ifmo.se.s267880.pip.lab3.facesConverter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DoubleConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter("ru.ifmo.se.s267880.pip.lab3.facesConverter.DoubleWithComma")
public class DoubleWithComma implements Converter {
    private DoubleConverter innerConverter = new DoubleConverter();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return innerConverter.getAsObject(context, component, value.replace(",", "."));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object obj) {
        return innerConverter.getAsString(context, component, obj);
    }
}
