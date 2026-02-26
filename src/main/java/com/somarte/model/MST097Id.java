package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class MST097Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer st97tdoc;
    private String st97ndoc;

    public MST097Id() {}

    public MST097Id(Integer stemp, Integer st97tdoc, String st97ndoc) {
        this.stemp = stemp;
        this.st97tdoc = st97tdoc;
        this.st97ndoc = st97ndoc;
    }

    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public Integer getSt97tdoc() {
        return st97tdoc;
    }

    public void setSt97tdoc(Integer st97tdoc) {
        this.st97tdoc = st97tdoc;
    }

    public String getSt97ndoc() {
        return st97ndoc;
    }

    public void setSt97ndoc(String st97ndoc) {
        this.st97ndoc = st97ndoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MST097Id that = (MST097Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(st97tdoc, that.st97tdoc) &&
               Objects.equals(st97ndoc, that.st97ndoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, st97tdoc, st97ndoc);
    }
}