package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class MST012Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer stmod;
    private Integer sttope;
    private Integer stsbop;

    public MST012Id() {}

    public MST012Id(Integer stemp, Integer stmod, Integer sttope, Integer stsbop) {
        this.stemp = stemp;
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
        MST012Id that = (MST012Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(stmod, that.stmod) &&
               Objects.equals(sttope, that.sttope) &&
               Objects.equals(stsbop, that.stsbop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, stmod, sttope, stsbop);
    }
}