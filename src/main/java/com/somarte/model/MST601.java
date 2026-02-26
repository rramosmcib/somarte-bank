package com.somarte.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MST601")
@IdClass(MST601Id.class)
public class MST601 {
    
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "STMOD", nullable = false, precision = 3)
    private Integer stmod;
    
    @Id
    @Column(name = "STCTA", nullable = false, precision = 9)
    private Integer stcta;
    
    @Id
    @Column(name = "STOPER", nullable = false, precision = 9)
    private Integer stoper;
    
    @Id
    @Column(name = "STTOPE", nullable = false, precision = 3)
    private Integer sttope;
    
    @Id
    @Column(name = "STSBOP", nullable = false, precision = 3)
    private Integer stsbop;
    
    @Id
    @Column(name = "STMDA", nullable = false, precision = 4)
    private Integer stmda;
    
    @Id
    @Column(name = "STNRO", nullable = false, precision = 4)
    private Integer stnro;
    
    @Column(name = "ST61IMP1", precision = 15, scale = 2)
    private BigDecimal st61imp1;
    
    @Column(name = "ST61IMP2", precision = 15, scale = 2)
    private BigDecimal st61imp2;
    
    @Column(name = "ST61ESTD", length = 1)
    private String st61estd;
    
    @Column(name = "ST61FECH")
    @Temporal(TemporalType.DATE)
    private Date st61fech;
    
    @Column(name = "ST61USER", length = 10)
    private String st61user;

    public MST601() {}

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

    public Integer getStcta() {
        return stcta;
    }

    public void setStcta(Integer stcta) {
        this.stcta = stcta;
    }

    public Integer getStoper() {
        return stoper;
    }

    public void setStoper(Integer stoper) {
        this.stoper = stoper;
    }

    public Integer getSttope() {
        return sttope;
    }

    public void setSttope(Integer sttope) {
        this.sttope = sttope;
    }

    public Integer getStsbop() {
        return stsbop;
    }

    public void setStsbop(Integer stsbop) {
        this.stsbop = stsbop;
    }

    public Integer getStmda() {
        return stmda;
    }

    public void setStmda(Integer stmda) {
        this.stmda = stmda;
    }

    public Integer getStnro() {
        return stnro;
    }

    public void setStnro(Integer stnro) {
        this.stnro = stnro;
    }

    public BigDecimal getSt61imp1() {
        return st61imp1;
    }

    public void setSt61imp1(BigDecimal st61imp1) {
        this.st61imp1 = st61imp1;
    }

    public BigDecimal getSt61imp2() {
        return st61imp2;
    }

    public void setSt61imp2(BigDecimal st61imp2) {
        this.st61imp2 = st61imp2;
    }

    public String getSt61estd() {
        return st61estd;
    }

    public void setSt61estd(String st61estd) {
        this.st61estd = st61estd;
    }

    public Date getSt61fech() {
        return st61fech;
    }

    public void setSt61fech(Date st61fech) {
        this.st61fech = st61fech;
    }

    public String getSt61user() {
        return st61user;
    }

    public void setSt61user(String st61user) {
        this.st61user = st61user;
    }
}