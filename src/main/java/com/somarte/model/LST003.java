package com.somarte.model;

import jakarta.persistence.*;

@Entity
@Table(name = "LST003")
@IdClass(LST003Id.class)
public class LST003 {
	public LST003(Integer stemp, Integer l1tdoc, String l1ndoc,
            Integer l3corr, String l3tel, String l3mail) {
	  this.stemp = stemp;
	  this.l1tdoc = l1tdoc;
	  this.l1ndoc = l1ndoc;
	  this.l3corr = l3corr;
	  this.l3tel = l3tel;
	  this.l3mail = l3mail;
	}
	
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
    @Column(name = "L3CORR", nullable = false, precision = 3)
    private Integer l3corr;
    
    @Column(name = "L3TEL", length = 16)
    private String l3tel;
    
    @Column(name = "L3MAIL", length = 50)
    private String l3mail;
    
    // Relación muchos a uno con LST001
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "STEMP", referencedColumnName = "STEMP", insertable = false, updatable = false),
        @JoinColumn(name = "L1TDOC", referencedColumnName = "L1TDOC", insertable = false, updatable = false),
        @JoinColumn(name = "L1NDOC", referencedColumnName = "L1NDOC", insertable = false, updatable = false)
    })
    private LST001 cliente;

    public LST003() {}

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

    public Integer getL3corr() {
        return l3corr;
    }

    public void setL3corr(Integer l3corr) {
        this.l3corr = l3corr;
    }

    public String getL3tel() {
        return l3tel;
    }

    public void setL3tel(String l3tel) {
        this.l3tel = l3tel;
    }

    public String getL3mail() {
        return l3mail;
    }

    public void setL3mail(String l3mail) {
        this.l3mail = l3mail;
    }

    public LST001 getCliente() {
        return cliente;
    }

    public void setCliente(LST001 cliente) {
        this.cliente = cliente;
    }
}