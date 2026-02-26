package com.somarte.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MST015")
@IdClass(MST015Id.class)
public class MST015 {
    
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
    
    @Column(name = "ST15FECH")
    @Temporal(TemporalType.DATE)
    private Date st15fech;
    
    @Column(name = "ST15USER", length = 10)
    private String st15user;
    
    @Column(name = "ST15ESTD", length = 1)
    private String st15estd;
    
    // Relación con MST016 (uno a muchos)
    @OneToMany(mappedBy = "cabecera", fetch = FetchType.LAZY)
    private List<MST016> detalles;

    public MST015() {}

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

    public Date getSt15fech() {
        return st15fech;
    }

    public void setSt15fech(Date st15fech) {
        this.st15fech = st15fech;
    }

    public String getSt15user() {
        return st15user;
    }

    public void setSt15user(String st15user) {
        this.st15user = st15user;
    }

    public String getSt15estd() {
        return st15estd;
    }

    public void setSt15estd(String st15estd) {
        this.st15estd = st15estd;
    }

    public List<MST016> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<MST016> detalles) {
        this.detalles = detalles;
    }
}