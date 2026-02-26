package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class LST001Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private Integer l1tdoc;
    private String l1ndoc;

    public LST001Id() {}

    public LST001Id(Integer stemp, Integer l1tdoc, String l1ndoc) {
        this.stemp = stemp;
        this.l1tdoc = l1tdoc;
        this.l1ndoc = l1ndoc;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LST001Id that = (LST001Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(l1tdoc, that.l1tdoc) &&
               Objects.equals(l1ndoc, that.l1ndoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, l1tdoc, l1ndoc);
    }
}