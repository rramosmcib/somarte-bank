package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class MST011Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer stcta;
    private Integer stoper;
    private Integer stmda;
    private Integer stmod;
    private Integer sttope;
    private Integer stsbop;

    public MST011Id() {}

    public MST011Id(Integer stemp, Integer stcta, Integer stoper, Integer stmda, 
                    Integer stmod, Integer sttope, Integer stsbop) {
        this.stemp = stemp;
        this.stcta = stcta;
        this.stoper = stoper;
        this.stmda = stmda;
        this.stmod = stmod;
        this.sttope = sttope;
        this.stsbop = stsbop;
    }

    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public Integer getStcta() {
        return stcta;
    }

    public void setStcta(Integer stcta) {
        this.stcta = stcta;
    }

    public Integer getStoper() {
        return stoper;
    }

    public void setStoper(Integer stoper) {
        this.stoper = stoper;
    }

    public Integer getStmda() {
        return stmda;
    }

    public void setStmda(Integer stmda) {
        this.stmda = stmda;
    }

    public Integer getStmod() {
        return stmod;
    }

    public void setStmod(Integer stmod) {
        this.stmod = stmod;
    }

    public Integer getSttope() {
        return sttope;
    }

    public void setSttope(Integer sttope) {
        this.sttope = sttope;
    }

    public Integer getStsbop() {
        return stsbop;
    }

    public void setStsbop(Integer stsbop) {
        this.stsbop = stsbop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MST011Id that = (MST011Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(stcta, that.stcta) &&
               Objects.equals(stoper, that.stoper) &&
               Objects.equals(stmda, that.stmda) &&
               Objects.equals(stmod, that.stmod) &&
               Objects.equals(sttope, that.sttope) &&
               Objects.equals(stsbop, that.stsbop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, stcta, stoper, stmda, stmod, sttope, stsbop);
    }
}