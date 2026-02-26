package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class MST015Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer stmod;
    private Integer sttran;
    private Integer stnrel;

    public MST015Id() {}

    public MST015Id(Integer stemp, Integer stmod, Integer sttran, Integer stnrel) {
        this.stemp = stemp;
        this.stmod = stmod;
        this.sttran = sttran;
        this.stnrel = stnrel;
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

    public Integer getSttran() {
        return sttran;
    }

    public void setSttran(Integer sttran) {
        this.sttran = sttran;
    }

    public Integer getStnrel() {
        return stnrel;
    }

    public void setStnrel(Integer stnrel) {
        this.stnrel = stnrel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MST015Id that = (MST015Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(stmod, that.stmod) &&
               Objects.equals(sttran, that.sttran) &&
               Objects.equals(stnrel, that.stnrel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, stmod, sttran, stnrel);
    }
}