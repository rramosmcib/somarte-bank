package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class MST8Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private String stndoc;
    private Integer stncta;

    public MST8Id() {}

    public MST8Id(Integer stemp, String stndoc, Integer stncta) {
        this.stemp = stemp;
        this.stndoc = stndoc;
        this.stncta = stncta;
    }

    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public String getStndoc() {
        return stndoc;
    }

    public void setStndoc(String stndoc) {
        this.stndoc = stndoc;
    }

    public Integer getStncta() {
        return stncta;
    }

    public void setStncta(Integer stncta) {
        this.stncta = stncta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MST8Id that = (MST8Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(stndoc, that.stndoc) &&
               Objects.equals(stncta, that.stncta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, stndoc, stncta);
    }
}