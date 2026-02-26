package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class MST098Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer st98mod;
    private Integer st98tran;
    private Integer st98corr;

    public MST098Id() {}

    public MST098Id(Integer stemp, Integer st98mod, Integer st98tran, Integer st98corr) {
        this.stemp = stemp;
        this.st98mod = st98mod;
        this.st98tran = st98tran;
        this.st98corr = st98corr;
    }

    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public Integer getSt98mod() {
        return st98mod;
    }

    public void setSt98mod(Integer st98mod) {
        this.st98mod = st98mod;
    }

    public Integer getSt98tran() {
        return st98tran;
    }

    public void setSt98tran(Integer st98tran) {
        this.st98tran = st98tran;
    }

    public Integer getSt98corr() {
        return st98corr;
    }

    public void setSt98corr(Integer st98corr) {
        this.st98corr = st98corr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MST098Id that = (MST098Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(st98mod, that.st98mod) &&
               Objects.equals(st98tran, that.st98tran) &&
               Objects.equals(st98corr, that.st98corr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, st98mod, st98tran, st98corr);
    }
}