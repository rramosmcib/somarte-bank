package com.somarte.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MST602")
@IdClass(MST602Id.class)
public class MST602 {
    
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
    
    @Column(name = "ST62TAS1", precision = 10, scale = 6)
    private BigDecimal st62tas1;
    
    @Column(name = "ST62TAS2", precision = 10, scale = 6)
    private BigDecimal st62tas2;
    
    @Column(name = "ST62FECH")
    @Temporal(TemporalType.DATE)
    private Date st62fech;
    
    @Column(name = "ST62USER", length = 10)
    private String st62user;

    public MST602() {}

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

    public BigDecimal getSt62tas1() {
        return st62tas1;
    }

    public void setSt62tas1(BigDecimal st62tas1) {
        this.st62tas1 = st62tas1;
    }

    public BigDecimal getSt62tas2() {
        return st62tas2;
    }

    public void setSt62tas2(BigDecimal st62tas2) {
        this.st62tas2 = st62tas2;
    }

    public Date getSt62fech() {
        return st62fech;
    }

    public void setSt62fech(Date st62fech) {
        this.st62fech = st62fech;
    }

    public String getSt62user() {
        return st62user;
    }

    public void setSt62user(String st62user) {
        this.st62user = st62user;
    }
}