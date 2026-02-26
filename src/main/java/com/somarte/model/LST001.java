package com.somarte.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "LST001")
@IdClass(LST001Id.class)
public class LST001 {
    
	public LST001(Integer  stemp, Integer l1tdoc, String l1ndoc,
	            String l1ape1, String l1ape2,
	            String l1nom1, String l1nom2, String l1nomb) {
	  this.stemp = stemp;
	  this.l1tdoc = l1tdoc;
	  this.l1ndoc = l1ndoc;
	  this.l1ape1 = l1ape1;
	  this.l1ape2 = l1ape2;
	  this.l1nom1 = l1nom1;
	  this.l1nom2 = l1nom2;
	  this.l1nomb = l1nomb;
	}
    @Id
    @Column(name = "STEMP", nullable = false, precision = 3)
    private Integer stemp = 1;
    
    @Id
    @Column(name = "L1TDOC", nullable = false, precision = 2, columnDefinition = "NUMERIC(2)")
    private Integer l1tdoc;
    
    @Id
    @Column(name = "L1NDOC", length = 12, nullable = false)
    private String l1ndoc;
    
    @Column(name = "L1NOM1", length = 50)
    private String l1nom1;
    
    @Column(name = "L1NOM2", length = 50)
    private String l1nom2;
    
    @Column(name = "L1APE1", length = 50)
    private String l1ape1;
    
    @Column(name = "L1APE2", length = 50)
    private String l1ape2;
    
    @Column(name = "L1NOMB", length = 100)
    private String l1nomb;
    
    @Column(name = "L2CORR", precision = 3)
    private Integer l2corr;
    
    @Column(name = "L3CORR", precision = 3)
    private Integer l3corr;
    
    @Column(name = "L4CORR", precision = 3)
    private Integer l4corr;
    
    // Relaciones con otras tablas LST
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<LST002> direcciones;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<LST003> contactos;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<LST004> personasVinculadas;

    public LST001() {}

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

    public String getL1nom1() {
        return l1nom1;
    }

    public void setL1nom1(String l1nom1) {
        this.l1nom1 = l1nom1;
    }

    public String getL1nom2() {
        return l1nom2;
    }

    public void setL1nom2(String l1nom2) {
        this.l1nom2 = l1nom2;
    }

    public String getL1ape1() {
        return l1ape1;
    }

    public void setL1ape1(String l1ape1) {
        this.l1ape1 = l1ape1;
    }

    public String getL1ape2() {
        return l1ape2;
    }

    public void setL1ape2(String l1ape2) {
        this.l1ape2 = l1ape2;
    }

    public String getL1nomb() {
        return l1nomb;
    }

    public void setL1nomb(String l1nomb) {
        this.l1nomb = l1nomb;
    }

    public Integer getL2corr() {
        return l2corr;
    }

    public void setL2corr(Integer l2corr) {
        this.l2corr = l2corr;
    }

    public Integer getL3corr() {
        return l3corr;
    }

    public void setL3corr(Integer l3corr) {
        this.l3corr = l3corr;
    }

    public Integer getL4corr() {
        return l4corr;
    }

    public void setL4corr(Integer l4corr) {
        this.l4corr = l4corr;
    }

    public List<LST002> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<LST002> direcciones) {
        this.direcciones = direcciones;
    }

    public List<LST003> getContactos() {
        return contactos;
    }

    public void setContactos(List<LST003> contactos) {
        this.contactos = contactos;
    }

    public List<LST004> getPersonasVinculadas() {
        return personasVinculadas;
    }

    public void setPersonasVinculadas(List<LST004> personasVinculadas) {
        this.personasVinculadas = personasVinculadas;
    }
}