package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class LST003Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer l1tdoc;
    private String l1ndoc;
    private Integer l3corr;

    public LST003Id() {}

    public LST003Id(Integer stemp, Integer l1tdoc, String l1ndoc, Integer l3corr) {
        this.stemp = stemp;
        this.l1tdoc = l1tdoc;
        this.l1ndoc = l1ndoc;
        this.l3corr = l3corr;
    }

    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public Integer getL1tdoc() {
        return l1tdoc;
    }

    public void setL1tdoc(Integer l1tdoc) {
        this.l1tdoc = l1tdoc;
    }

    public String getL1ndoc() {
        return l1ndoc;
    }

    public void setL1ndoc(String l1ndoc) {
        this.l1ndoc = l1ndoc;
    }

    public Integer getL3corr() {
        return l3corr;
    }

    public void setL3corr(Integer l3corr) {
        this.l3corr = l3corr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LST003Id that = (LST003Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(l1tdoc, that.l1tdoc) &&
               Objects.equals(l1ndoc, that.l1ndoc) &&
               Objects.equals(l3corr, that.l3corr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, l1tdoc, l1ndoc, l3corr);
    }
}