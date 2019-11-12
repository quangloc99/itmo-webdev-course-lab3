package ru.ifmo.se.s267880.pip.lab3;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;

@ManagedBean("clock")
@Named("clock")
@RequestScoped
public class ClockBean implements Serializable {
    LocalDateTime now = LocalDateTime.now();

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime date) {
        now = date;
    }

    public void updateNow() {
        now = LocalDateTime.now();
    }
}
