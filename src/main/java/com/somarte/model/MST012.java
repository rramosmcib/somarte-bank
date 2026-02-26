package com.somarte.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "MST012")
@IdClass(MST012Id.class)
public class MST012 {
    
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "STMOD", nullable = false, precision = 3)
    private Integer stmod;
    
    @Id
    @Column(name = "STTOPE", nullable = false, precision = 3)
    private Integer sttope;
    
    @Id
    @Column(name = "STSBOP", nullable = false, precision = 3)
    private Integer stsbop;
    
    @Column(name = "ST15DESC", length = 50)
    private String st15desc;
    
    @Column(name = "ST15ESTD", precision = 1)
    private Integer st15estd;
    
    // Relación con MST011
    @OneToMany(mappedBy = "tipoProducto", fetch = FetchType.LAZY)
    private List<MST011> saldos;

    public MST012() {}

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

    public String getSt15desc() {
        return st15desc;
    }

    public void setSt15desc(String st15desc) {
        this.st15desc = st15desc;
    }

    public Integer getSt15estd() {
        return st15estd;
    }

    public void setSt15estd(Integer st15estd) {
        this.st15estd = st15estd;
    }

    public List<MST011> getSaldos() {
        return saldos;
    }

    public void setSaldos(List<MST011> saldos) {
        this.saldos = saldos;
    }
}