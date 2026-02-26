package com.somarte.model;

import java.io.Serializable;
import java.util.Objects;

public class MST001Id implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer stemp;
    private String m1user;
    private Integer m1tdoc;
    private String m1ndoc;

    public MST001Id() {}

    public MST001Id(Integer stemp, String m1user, Integer m1tdoc, String m1ndoc) {
        this.stemp = stemp;
        this.m1user = m1user;
        this.m1tdoc = m1tdoc;
        this.m1ndoc = m1ndoc;
    }

    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public String getM1user() {
        return m1user;
    }

    public void setM1user(String m1user) {
        this.m1user = m1user;
    }

    public Integer getM1tdoc() {
        return m1tdoc;
    }

    public void setM1tdoc(Integer m1tdoc) {
        this.m1tdoc = m1tdoc;
    }

    public String getM1ndoc() {
        return m1ndoc;
    }

    public void setM1ndoc(String m1ndoc) {
        this.m1ndoc = m1ndoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MST001Id that = (MST001Id) o;
        return Objects.equals(stemp, that.stemp) &&
               Objects.equals(m1user, that.m1user) &&
               Objects.equals(m1tdoc, that.m1tdoc) &&
               Objects.equals(m1ndoc, that.m1ndoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stemp, m1user, m1tdoc, m1ndoc);
    }
}