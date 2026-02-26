package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class LST002Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer l1tdoc;
    private String l1ndoc;
    private Integer l2corr;

    public LST002Id() {}

    public LST002Id(Integer stemp, Integer l1tdoc, String l1ndoc, Integer l2corr) {
        this.stemp = stemp;
        this.l1tdoc = l1tdoc;
        this.l1ndoc = l1ndoc;
        this.l2corr = l2corr;
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

    public Integer getL2corr() {
        return l2corr;
    }

    public void setL2corr(Integer l2corr) {
        this.l2corr = l2corr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LST002Id that = (LST002Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(l1tdoc, that.l1tdoc) &&
               Objects.equals(l1ndoc, that.l1ndoc) &&
               Objects.equals(l2corr, that.l2corr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, l1tdoc, l1ndoc, l2corr);
    }
}