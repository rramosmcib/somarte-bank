package com.somarte.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MST111")
@IdClass(MST111Id.class)
public class MST111 {
    
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "ST111CTA", nullable = false, precision = 9)
    private Integer st111cta;
    
    @Id
    @Column(name = "ST111OPER", nullable = false, precision = 9)
    private Integer st111oper;
    
    @Column(name = "ST111MOD", nullable = false, precision = 3)
    private Integer st111mod;
    
    @Column(name = "ST111TOPE", nullable = false, precision = 3)
    private Integer st111tope;
    
    @Column(name = "ST111SBOP", nullable = false, precision = 3)
    private Integer st111sbop;
    
    @Column(name = "ST111CTAEQ", nullable = false, precision = 12)
    private Integer st111ctaeq;
    
    // Relación muchos a uno con MST012
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "STEMP", referencedColumnName = "STEMP", insertable = false, updatable = false),
        @JoinColumn(name = "ST111MOD", referencedColumnName = "STMOD", insertable = false, updatable = false),
        @JoinColumn(name = "ST111TOPE", referencedColumnName = "STTOPE", insertable = false, updatable = false),
        @JoinColumn(name = "ST111SBOP", referencedColumnName = "STSBOP", insertable = false, updatable = false)
    })
    private MST012 tipoProducto;

    public MST111() {}

    // Getters y Setters
    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public Integer getSt111cta() {
        return st111cta;
    }

    public void setSt111cta(Integer st111cta) {
        this.st111cta = st111cta;
    }

    public Integer getSt111oper() {
        return st111oper;
    }

    public void setSt111oper(Integer st111oper) {
        this.st111oper = st111oper;
    }

    public Integer getSt111mod() {
        return st111mod;
    }

    public void setSt111mod(Integer st111mod) {
        this.st111mod = st111mod;
    }

    public Integer getSt111tope() {
        return st111tope;
    }

    public void setSt111tope(Integer st111tope) {
        this.st111tope = st111tope;
    }

    public Integer getSt111sbop() {
        return st111sbop;
    }

    public void setSt111sbop(Integer st111sbop) {
        this.st111sbop = st111sbop;
    }

    public Integer getSt111ctaeq() {
        return st111ctaeq;
    }

    public void setSt111ctaeq(Integer st111ctaeq) {
        this.st111ctaeq = st111ctaeq;
    }

    public MST012 getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(MST012 tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}