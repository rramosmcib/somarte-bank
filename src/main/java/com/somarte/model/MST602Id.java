package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class MST602Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer stmod;
    private Integer stcta;
    private Integer stoper;
    private Integer sttope;
    private Integer stsbop;
    private Integer stmda;

    public MST602Id() {}

    public MST602Id(Integer stemp, Integer stmod, Integer stcta, Integer stoper, 
                    Integer sttope, Integer stsbop, Integer stmda) {
        this.stemp = stemp;
        this.stmod = stmod;
        this.stcta = stcta;
        this.stoper = stoper;
        this.sttope = sttope;
        this.stsbop = stsbop;
        this.stmda = stmda;
    }

    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public Integer getStmod() {
        return stmod;
    }

    public void setStmod(Integer stmod) {
        this.stmod = stmod;
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

    public Integer getStmda() {
        return stmda;
    }

    public void setStmda(Integer stmda) {
        this.stmda = stmda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MST602Id that = (MST602Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(stmod, that.stmod) &&
               Objects.equals(stcta, that.stcta) &&
               Objects.equals(stoper, that.stoper) &&
               Objects.equals(sttope, that.sttope) &&
               Objects.equals(stsbop, that.stsbop) &&
               Objects.equals(stmda, that.stmda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, stmod, stcta, stoper, sttope, stsbop, stmda);
    }
}