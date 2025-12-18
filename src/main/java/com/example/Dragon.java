package com.example;

import jakarta.persistence.*;

/**
 * Clase Dragón.
 * @author Samuel.
 */
@Entity
@Table (name = "dragon")
public class Dragon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nombre;
    public int intensidadFuego;
    public int vida;

    @ManyToOne
    private Bosque bosque;
    
    public Dragon() {}

    public Dragon(String nombre, int intensidadFuego, int vida) {
        this.nombre = nombre;
        this.intensidadFuego = intensidadFuego;
        this.vida = vida;
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
    public int getIntensidadFuego() {
        return intensidadFuego;
    }

    /** 
     * @return int
     */
    public int getVida() {
        return vida;
    }

    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** 
     * @param intensidadFuego
     */
    public void setIntensidadFuego(int intensidadFuego) {
        this.intensidadFuego = intensidadFuego;
    }

    /** 
     * @param vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Dragón: " + getNombre() + ".\nIntensidad del fuego: " + getIntensidadFuego() + ".\nVida: " + getVida() + ".";
    }


    /** 
     * Método para que el dragón ataque.
     * @param m
     */
    public void exhalar(Monstruo m){
        m.vida -= getIntensidadFuego();
    }
}