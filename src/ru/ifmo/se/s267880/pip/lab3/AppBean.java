package ru.ifmo.se.s267880.pip.lab3;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("app")
@ApplicationScoped
public class AppBean implements Serializable {
    private EditorBean editor = new EditorBean();
    public AppBean() {}

    public EditorBean getEditor() {
        return editor;
    }

    public Object ok() {
        System.out.println("nice, ok");
        return "ok";
    }
}
