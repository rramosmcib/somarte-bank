package com.somarte.model;

import jakarta.persistence.*;

@Entity
@Table(name = "LST004")
@IdClass(LST004Id.class)
public class LST004 {

	public LST004(Integer stemp, Integer l1tdoc, String l1ndoc,
            Integer l4corr, Integer l4tip, Integer l4tdoc, String l4ndoc, String l5nomb) {
	  this.stemp = stemp;
	  this.l1tdoc = l1tdoc;
	  this.l1ndoc = l1ndoc;
	  this.l4corr = l4corr;
	  this.l4tip = l4tip;
	  this.l4tdoc = l4tdoc;
	  this.l4ndoc = l4ndoc;
	  this.l5nomb = l5nomb;
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
    @Column(name = "L4CORR", nullable = false, precision = 3)
    private Integer l4corr;
    
    @Id
    @Column(name = "L4TIP", nullable = false, precision = 1)
    private Integer l4tip;
    
    @Column(name = "L4TDOC", precision = 2)
    private Integer l4tdoc;
    
    @Column(name = "L4NDOC", length = 12)
    private String l4ndoc;
    
    @Column(name = "L5NOMB", length = 50)
    private String l5nomb;
    
    // Relación muchos a uno con LST001
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "STEMP", referencedColumnName = "STEMP", insertable = false, updatable = false),
        @JoinColumn(name = "L1TDOC", referencedColumnName = "L1TDOC", insertable = false, updatable = false),
        @JoinColumn(name = "L1NDOC", referencedColumnName = "L1NDOC", insertable = false, updatable = false)
    })
    private LST001 cliente;

    public LST004() {}

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

    public Integer getL4corr() {
        return l4corr;
    }

    public void setL4corr(Integer l4corr) {
        this.l4corr = l4corr;
    }

    public Integer getL4tip() {
        return l4tip;
    }

    public void setL4tip(Integer l4tip) {
        this.l4tip = l4tip;
    }

    public Integer getL4tdoc() {
        return l4tdoc;
    }

    public void setL4tdoc(Integer l4tdoc) {
        this.l4tdoc = l4tdoc;
    }

    public String getL4ndoc() {
        return l4ndoc;
    }

    public void setL4ndoc(String l4ndoc) {
        this.l4ndoc = l4ndoc;
    }

    public String getL5nomb() {
        return l5nomb;
    }

    public void setL5nomb(String l5nomb) {
        this.l5nomb = l5nomb;
    }

    public LST001 getCliente() {
        return cliente;
    }

    public void setCliente(LST001 cliente) {
        this.cliente = cliente;
    }
}