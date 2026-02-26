package com.somarte.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class MST016Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer stmod;
    private Integer sttran;
    private Integer stnrel;
    private Date stfech;
    private Integer stord;
    private Integer stsbord;

    public MST016Id() {}

    public MST016Id(Integer stemp, Integer stmod, Integer sttran, Integer stnrel, 
                    Date stfech, Integer stord, Integer stsbord) {
        this.stemp = stemp;
        this.stmod = stmod;
        this.sttran = sttran;
        this.stnrel = stnrel;
        this.stfech = stfech;
        this.stord = stord;
        this.stsbord = stsbord;
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

    public Date getStfech() {
        return stfech;
    }

    public void setStfech(Date stfech) {
        this.stfech = stfech;
    }

    public Integer getStord() {
        return stord;
    }

    public void setStord(Integer stord) {
        this.stord = stord;
    }

    public Integer getStsbord() {
        return stsbord;
    }

    public void setStsbord(Integer stsbord) {
        this.stsbord = stsbord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MST016Id that = (MST016Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(stmod, that.stmod) &&
               Objects.equals(sttran, that.sttran) &&
               Objects.equals(stnrel, that.stnrel) &&
               Objects.equals(stfech, that.stfech) &&
               Objects.equals(stord, that.stord) &&
               Objects.equals(stsbord, that.stsbord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, stmod, sttran, stnrel, stfech, stord, stsbord);
    }
}