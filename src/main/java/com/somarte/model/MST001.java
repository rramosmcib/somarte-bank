package com.somarte.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MST001")
@IdClass(MST001Id.class)
public class MST001 {
    
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "M1USER", length = 10, nullable = false)
    private String m1user;
    
    @Id
    @Column(name = "M1TDOC", nullable = false, precision = 2)
    private Integer m1tdoc;
    
    @Id
    @Column(name = "M1NDOC", length = 12, nullable = false)
    private String m1ndoc;
    
    @Column(name = "M1NOMB", length = 100)
    private String m1nomb;
    
    @Column(name = "M1FCRE")
    @Temporal(TemporalType.DATE)
    private Date m1fcre;
    
    @Column(name = "M1STAT", precision = 1)
    private Integer m1stat;
    
    // ✅ NUEVO CAMPO: contraseña
    @Column(name = "M1PASS", length = 255, nullable = false)
    private String m1pass;

    public MST001() {}

    // Getters y Setters
    public Integer getStemp() {
        return stemp;
    }

    public void setStemp(Integer stemp) {
        this.stemp = stemp;
    }

    public String getM1user() {
        return m1user;
    }

    public void setM1user(String m1user) {
        this.m1user = m1user;
    }

    public Integer getM1tdoc() {
        return m1tdoc;
    }

    public void setM1tdoc(Integer m1tdoc) {
        this.m1tdoc = m1tdoc;
    }

    public String getM1ndoc() {
        return m1ndoc;
    }

    public void setM1ndoc(String m1ndoc) {
        this.m1ndoc = m1ndoc;
    }

    public String getM1nomb() {
        return m1nomb;
    }

    public void setM1nomb(String m1nomb) {
        this.m1nomb = m1nomb;
    }

    public Date getM1fcre() {
        return m1fcre;
    }

    public void setM1fcre(Date m1fcre) {
        this.m1fcre = m1fcre;
    }

    public Integer getM1stat() {
        return m1stat;
    }

    public void setM1stat(Integer m1stat) {
        this.m1stat = m1stat;
    }
    
    // ✅ Getter y Setter para el nuevo campo
    public String getM1pass() {
        return m1pass;
    }

    public void setM1pass(String m1pass) {
        this.m1pass = m1pass;
    }
}