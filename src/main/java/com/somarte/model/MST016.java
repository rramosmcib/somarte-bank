package com.somarte.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MST016")
@IdClass(MST016Id.class)
public class MST016 {
    
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "STMOD", nullable = false, precision = 3)
    private Integer stmod;
    
    @Id
    @Column(name = "STTRAN", nullable = false, precision = 3)
    private Integer sttran;
    
    @Id
    @Column(name = "STNREL", nullable = false, precision = 4)
    private Integer stnrel;
    
    @Id
    @Column(name = "STFECH", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date stfech;
    
    @Id
    @Column(name = "STORD", nullable = false, precision = 3)
    private Integer stord;
    
    @Id
    @Column(name = "STSBORD", nullable = false, precision = 3)
    private Integer stsbord;
    
    @Column(name = "ST16IMP", precision = 15, scale = 2)
    private BigDecimal st16imp;
    
    @Column(name = "ST16DBHB", precision = 1)
    private Integer st16dbhb;
    
    @Column(name = "ST16CTA", precision = 9)
    private Integer st16cta;
    
    @Column(name = "ST16OPER", precision = 9)
    private Integer st16oper;
    
    @Column(name = "ST16FECH")
    @Temporal(TemporalType.DATE)
    private Date st16fech;
    
    @Column(name = "ST16USER", length = 10)
    private String st16user;
    
    // Relación muchos a uno con MST015
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "STEMP", referencedColumnName = "STEMP", insertable = false, updatable = false),
        @JoinColumn(name = "STMOD", referencedColumnName = "STMOD", insertable = false, updatable = false),
        @JoinColumn(name = "STTRAN", referencedColumnName = "STTRAN", insertable = false, updatable = false),
        @JoinColumn(name = "STNREL", referencedColumnName = "STNREL", insertable = false, updatable = false)
    })
    private MST015 cabecera;

    public MST016() {}

    // Getters y Setters
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

    public BigDecimal getSt16imp() {
        return st16imp;
    }

    public void setSt16imp(BigDecimal st16imp) {
        this.st16imp = st16imp;
    }

    public Integer getSt16dbhb() {
        return st16dbhb;
    }

    public void setSt16dbhb(Integer st16dbhb) {
        this.st16dbhb = st16dbhb;
    }

    public Integer getSt16cta() {
        return st16cta;
    }

    public void setSt16cta(Integer st16cta) {
        this.st16cta = st16cta;
    }

    public Integer getSt16oper() {
        return st16oper;
    }

    public void setSt16oper(Integer st16oper) {
        this.st16oper = st16oper;
    }

    public Date getSt16fech() {
        return st16fech;
    }

    public void setSt16fech(Date st16fech) {
        this.st16fech = st16fech;
    }

    public String getSt16user() {
        return st16user;
    }

    public void setSt16user(String st16user) {
        this.st16user = st16user;
    }

    public MST015 getCabecera() {
        return cabecera;
    }

    public void setCabecera(MST015 cabecera) {
        this.cabecera = cabecera;
    }
}