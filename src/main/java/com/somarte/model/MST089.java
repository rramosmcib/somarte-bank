package com.somarte.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MST089")
public class MST089 implements Serializable {

    @EmbeddedId
    private MST089Id id;

    @Column(name = "ST89RUTA", length = 200)
    private String st89ruta;

    // Getters y Setters
    public MST089Id getId() { return id; }
    public void setId(MST089Id id) { this.id = id; }

    public String getSt89ruta() { return st89ruta; }
    public void setSt89ruta(String st89ruta) { this.st89ruta = st89ruta; }
}