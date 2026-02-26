package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class LST004Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer l1tdoc;
    private String l1ndoc;
    private Integer l4corr;
    private Integer l4tip;

    public LST004Id() {}

    public LST004Id(Integer stemp, Integer l1tdoc, String l1ndoc, Integer l4corr, Integer l4tip) {
        this.stemp = stemp;
        this.l1tdoc = l1tdoc;
        this.l1ndoc = l1ndoc;
        this.l4corr = l4corr;
        this.l4tip = l4tip;
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

    public Integer getL4corr() {
        return l4corr;
    }

    public void setL4corr(Integer l4corr) {
        this.l4corr = l4corr;
    }

    public Integer getL4tip() {
        return l4tip;
    }

    public void setL4tip(Integer l4tip) {
        this.l4tip = l4tip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LST004Id that = (LST004Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(l1tdoc, that.l1tdoc) &&
               Objects.equals(l1ndoc, that.l1ndoc) &&
               Objects.equals(l4corr, that.l4corr) &&
               Objects.equals(l4tip, that.l4tip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, l1tdoc, l1ndoc, l4corr, l4tip);
    }
}