package com.somarte.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MST8")
@IdClass(MST8Id.class)
public class MST8 {
    
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "STNDOC", length = 12, nullable = false)
    private String stndoc;
    
    @Id
    @Column(name = "STNCTA", nullable = false, precision = 9)
    private Integer stncta;
    
    @Column(name = "STTDOC", nullable = false, precision = 2)
    private Integer sttdoc;
    
    @Column(name = "STUSER", length = 10)
    private String stuser;

    public MST8() {}

    // Getters y Setters
    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public String getStndoc() {
        return stndoc;
    }

    public void setStndoc(String stndoc) {
        this.stndoc = stndoc;
    }

    public Integer getStncta() {
        return stncta;
    }

    public void setStncta(Integer stncta) {
        this.stncta = stncta;
    }

    public Integer getSttdoc() {
        return sttdoc;
    }

    public void setSttdoc(Integer sttdoc) {
        this.sttdoc = sttdoc;
    }

    public String getStuser() {
        return stuser;
    }

    public void setStuser(String stuser) {
        this.stuser = stuser;
    }
}