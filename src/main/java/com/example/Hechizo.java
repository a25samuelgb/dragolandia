package com.example;

import jakarta.persistence.*;

/**
 * Clase Hechizo.
 * @author Samuel.
 */
@Entity
@Table(name = "hechizo")
public class Hechizo {

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