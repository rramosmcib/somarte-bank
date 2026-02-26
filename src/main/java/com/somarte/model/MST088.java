package com.somarte.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MST088")
public class MST088 implements Serializable {

    @EmbeddedId
    private MST088Id id;

    @Column(name = "ST88USAS", length = 10)
    private String st88usas;

    // Getters y Setters
    public MST088Id getId() { return id; }
    public void setId(MST088Id id) { this.id = id; }

    public String getSt88usas() { return st88usas; }
    public void setSt88usas(String st88usas) { this.st88usas = st88usas; }
}