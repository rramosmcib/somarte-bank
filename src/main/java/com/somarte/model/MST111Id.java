package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class MST111Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer st111cta;
    private Integer st111oper;

    public MST111Id() {}

    public MST111Id(Integer stemp, Integer st111cta, Integer st111oper) {
        this.stemp = stemp;
        this.st111cta = st111cta;
        this.st111oper = st111oper;
    }

    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public Integer getSt111cta() {
        return st111cta;
    }

    public void setSt111cta(Integer st111cta) {
        this.st111cta = st111cta;
    }

    public Integer getSt111oper() {
        return st111oper;
    }

    public void setSt111oper(Integer st111oper) {
        this.st111oper = st111oper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MST111Id that = (MST111Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(st111cta, that.st111cta) &&
               Objects.equals(st111oper, that.st111oper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, st111cta, st111oper);
    }
}