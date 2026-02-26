package com.somarte.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MST097")
@IdClass(MST097Id.class)
public class MST097 {
    
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "ST97TDOC", nullable = false, precision = 2)
    private Integer st97tdoc;
    
    @Id
    @Column(name = "ST97NDOC", length = 12, nullable = false)
    private String st97ndoc;
    
    @Column(name = "ST97CALI", length = 3, nullable = false)
    private String st97cali;

    public MST097() {}

    // Getters y Setters
    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public Integer getSt97tdoc() {
        return st97tdoc;
    }

    public void setSt97tdoc(Integer st97tdoc) {
        this.st97tdoc = st97tdoc;
    }

    public String getSt97ndoc() {
        return st97ndoc;
    }

    public void setSt97ndoc(String st97ndoc) {
        this.st97ndoc = st97ndoc;
    }

    public String getSt97cali() {
        return st97cali;
    }

    public void setSt97cali(String st97cali) {
        this.st97cali = st97cali;
    }
}