package com.somarte.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MST088Id implements Serializable {

    @Column(name = "STEMP")
    private Integer stemp;

    @Column(name = "ST88USER", length = 10)
    private String st88user;

    @Column(name = "ST88CORR")
    private Integer st88corr;

    // Getters y Setters
    public Integer getStemp() { return stemp; }
    public void setStemp(Integer stemp) { this.stemp = stemp; }

    public String getSt88user() { return st88user; }
    public void setSt88user(String st88user) { this.st88user = st88user; }

    public Integer getSt88corr() { return st88corr; }
    public void setSt88corr(Integer st88corr) { this.st88corr = st88corr; }

    // equals y hashCode obligatorios
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MST088Id)) return false;
        MST088Id that = (MST088Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(st88user, that.st88user) &&
               Objects.equals(st88corr, that.st88corr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, st88user, st88corr);
    }
}