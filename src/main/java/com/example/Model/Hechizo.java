package com.example.model;

import java.io.Serializable;

import jakarta.persistence.*;

/**
 * Clase Hechizo.
 * @author Samuel.
 */
@Entity
@Table(name = "hechizo")
public class Hechizo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String nombre;
    public int danho;
    
    public Hechizo() {}

    public Hechizo(String nombre, int danho) {
        this.nombre = nombre;
        this.danho = danho;
    }

    /**
     * @return int
     */
    public int getId() {
        return id;
    }

    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /** 
     * @return int
     */
    public int getDanho() {
        return danho;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** 
     * @param danho
     */
    public void setDanho(int danho) {
        this.danho = danho;
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Hechizo: " + getNombre() + ".\nDaño: " + getDanho() + ".";
    }
}