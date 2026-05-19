package com.modelo;

import jakarta.persistence.*;

@Entity
public class Hechizo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int danho;
    
    public Hechizo(String nombre, int danho) {
        this.nombre = nombre;
        this.danho = danho;
    }

    public Hechizo() {}


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDanho() {
        return danho;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDanho(int danho) {
        this.danho = danho;
    }

    @Override
    public String toString() {
        return "Hechizo:" + "\nId=" + id + "\nNombre=" + nombre + "\nDaño=" + danho;
    }
}