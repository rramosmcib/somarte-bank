package com.somarte.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MST098")
@IdClass(MST098Id.class)
public class MST098 {
    
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "ST98MOD", nullable = false, precision = 3)
    private Integer st98mod;
    
    @Id
    @Column(name = "ST98TRAN", nullable = false, precision = 3)
    private Integer st98tran;
    
    @Id
    @Column(name = "ST98CORR", nullable = false, precision = 4)
    private Integer st98corr;
    
    @Column(name = "ST98PRC", nullable = false, length = 50)
    private String st98prc;
    
    @Column(name = "ST98DES", length = 100)
    private String st98des;

    public MST098() {}

    // Getters y Setters
    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public Integer getSt98mod() {
        return st98mod;
    }

    public void setSt98mod(Integer st98mod) {
        this.st98mod = st98mod;
    }

    public Integer getSt98tran() {
        return st98tran;
    }

    public void setSt98tran(Integer st98tran) {
        this.st98tran = st98tran;
    }

    public Integer getSt98corr() {
        return st98corr;
    }

    public void setSt98corr(Integer st98corr) {
        this.st98corr = st98corr;
    }

    public String getSt98prc() {
        return st98prc;
    }

    public void setSt98prc(String st98prc) {
        this.st98prc = st98prc;
    }

    public String getSt98des() {
        return st98des;
    }

    public void setSt98des(String st98des) {
        this.st98des = st98des;
    }
}