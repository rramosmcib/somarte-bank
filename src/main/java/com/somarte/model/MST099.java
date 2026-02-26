package com.somarte.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MST099")
@IdClass(MST099Id.class)
public class MST099 {
    
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "ST99TDOC", nullable = false, precision = 2)
    private Integer st99tdoc;
    
    @Id
    @Column(name = "ST99NDOC", length = 12, nullable = false)
    private String st99ndoc;
    
    @Column(name = "ST99PRC", nullable = false, length = 50)
    private String st99prc;
    
    @Column(name = "ST99DES", length = 100)
    private String st99des;

    public MST099() {}

    // Getters y Setters
    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public Integer getSt99tdoc() {
        return st99tdoc;
    }

    public void setSt99tdoc(Integer st99tdoc) {
        this.st99tdoc = st99tdoc;
    }

    public String getSt99ndoc() {
        return st99ndoc;
    }

    public void setSt99ndoc(String st99ndoc) {
        this.st99ndoc = st99ndoc;
    }

    public String getSt99prc() {
        return st99prc;
    }

    public void setSt99prc(String st99prc) {
        this.st99prc = st99prc;
    }

    public String getSt99des() {
        return st99des;
    }

    public void setSt99des(String st99des) {
        this.st99des = st99des;
    }
}