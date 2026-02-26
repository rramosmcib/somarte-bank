package com.somarte.model;

import jakarta.persistence.*;

@Entity
@Table(name = "LST002")
@IdClass(LST002Id.class)
public class LST002 {
    
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "L1TDOC", nullable = false, precision = 2)
    private Integer l1tdoc;
    
    @Id
    @Column(name = "L1NDOC", length = 12, nullable = false)
    private String l1ndoc;
    
    @Id
    @Column(name = "L2CORR", nullable = false, precision = 3)
    private Integer l2corr;
    
    @Column(name = "L2PAIS", length = 20)
    private String l2pais;
    
    @Column(name = "L2DEPA", length = 20)
    private String l2depa;
    
    @Column(name = "L2PROV", length = 20)
    private String l2prov;
    
    @Column(name = "L2DIST", length = 20)
    private String l2dist;
    
    @Column(name = "L2DIREC", length = 50)
    private String l2direc;
    
    // Relación muchos a uno con LST001
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "STEMP", referencedColumnName = "STEMP", insertable = false, updatable = false),
        @JoinColumn(name = "L1TDOC", referencedColumnName = "L1TDOC", insertable = false, updatable = false),
        @JoinColumn(name = "L1NDOC", referencedColumnName = "L1NDOC", insertable = false, updatable = false)
    })
    private LST001 cliente;

    public LST002() {}

    // Getters y Setters
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

    public String getL2pais() {
        return l2pais;
    }

    public void setL2pais(String l2pais) {
        this.l2pais = l2pais;
    }

    public String getL2depa() {
        return l2depa;
    }

    public void setL2depa(String l2depa) {
        this.l2depa = l2depa;
    }

    public String getL2prov() {
        return l2prov;
    }

    public void setL2prov(String l2prov) {
        this.l2prov = l2prov;
    }

    public String getL2dist() {
        return l2dist;
    }

    public void setL2dist(String l2dist) {
        this.l2dist = l2dist;
    }

    public String getL2direc() {
        return l2direc;
    }

    public void setL2direc(String l2direc) {
        this.l2direc = l2direc;
    }

    public LST001 getCliente() {
        return cliente;
    }

    public void setCliente(LST001 cliente) {
        this.cliente = cliente;
    }
}