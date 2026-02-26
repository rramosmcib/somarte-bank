package com.somarte.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MST089Id implements Serializable {

    @Column(name = "STEMP")
    private Integer stemp;

    @Column(name = "ST89USER", length = 10)
    private String st89user;

    @Column(name = "ST89TUSE")
    private Integer st89tuse;

    // Getters y Setters
    public Integer getStemp() { return stemp; }
    public void setStemp(Integer stemp) { this.stemp = stemp; }

    public String getSt89user() { return st89user; }
    public void setSt89user(String st89user) { this.st89user = st89user; }

    public Integer getSt89tuse() { return st89tuse; }
    public void setSt89tuse(Integer st89tuse) { this.st89tuse = st89tuse; }

    // equals y hashCode obligatorios
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MST089Id)) return false;
        MST089Id that = (MST089Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(st89user, that.st89user) &&
               Objects.equals(st89tuse, that.st89tuse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, st89user, st89tuse);
    }
}