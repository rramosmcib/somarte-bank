package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class MST099Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer st99tdoc;
    private String st99ndoc;

    public MST099Id() {}

    public MST099Id(Integer stemp, Integer st99tdoc, String st99ndoc) {
        this.stemp = stemp;
        this.st99tdoc = st99tdoc;
        this.st99ndoc = st99ndoc;
    }

    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public Integer getSt99tdoc() {
        return st99tdoc;
    }

    public void setSt99tdoc(Integer st99tdoc) {
        this.st99tdoc = st99tdoc;
    }

    public String getSt99ndoc() {
        return st99ndoc;
    }

    public void setSt99ndoc(String st99ndoc) {
        this.st99ndoc = st99ndoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MST099Id that = (MST099Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(st99tdoc, that.st99tdoc) &&
               Objects.equals(st99ndoc, that.st99ndoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, st99tdoc, st99ndoc);
    }
}