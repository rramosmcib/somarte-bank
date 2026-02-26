package com.somarte.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MST011")
@IdClass(MST011Id.class)
public class MST011 {
    
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "STCTA", nullable = false, precision = 9)
    private Integer stcta;
    
    @Id
    @Column(name = "STOPER", nullable = false, precision = 9)
    private Integer stoper;
    
    @Id
    @Column(name = "STMDA", nullable = false, precision = 4)
    private Integer stmda;
    
    @Id
    @Column(name = "STMOD", nullable = false, precision = 3)
    private Integer stmod;
    
    @Id
    @Column(name = "STTOPE", nullable = false, precision = 3)
    private Integer sttope;
    
    @Id
    @Column(name = "STSBOP", nullable = false, precision = 3)
    private Integer stsbop;
    
    @Column(name = "STFCRE")
    @Temporal(TemporalType.DATE)
    private Date stfcre;
    
    @Column(name = "STSDO", precision = 15, scale = 2)
    private BigDecimal stsdo;
    
    @Column(name = "STESTD", precision = 1)
    private Integer stestd;
    
    @Column(name = "STUSER", length = 10)
    private String stuser;
    
    // Relación muchos a uno con MST012
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "STEMP", referencedColumnName = "STEMP", insertable = false, updatable = false),
        @JoinColumn(name = "STMOD", referencedColumnName = "STMOD", insertable = false, updatable = false),
        @JoinColumn(name = "STTOPE", referencedColumnName = "STTOPE", insertable = false, updatable = false),
        @JoinColumn(name = "STSBOP", referencedColumnName = "STSBOP", insertable = false, updatable = false)
    })
    private MST012 tipoProducto;

    public MST011() {}

    // Getters y Setters
    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
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

    public Integer getStmda() {
        return stmda;
    }

    public void setStmda(Integer stmda) {
        this.stmda = stmda;
    }

    public Integer getStmod() {
        return stmod;
    }

    public void setStmod(Integer stmod) {
        this.stmod = stmod;
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

    public Date getStfcre() {
        return stfcre;
    }

    public void setStfcre(Date stfcre) {
        this.stfcre = stfcre;
    }

    public BigDecimal getStsdo() {
        return stsdo;
    }

    public void setStsdo(BigDecimal stsdo) {
        this.stsdo = stsdo;
    }

    public Integer getStestd() {
        return stestd;
    }

    public void setStestd(Integer stestd) {
        this.stestd = stestd;
    }

    public String getStuser() {
        return stuser;
    }

    public void setStuser(String stuser) {
        this.stuser = stuser;
    }

    public MST012 getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(MST012 tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}