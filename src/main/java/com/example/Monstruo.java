package com.example;

import jakarta.persistence.*;

/**
 * Clase Monstruo.
 * @author Samuel.
 */
@Entity
@Table(name = "monstruo")
public class Monstruo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nombre;
    public int vida;
    public enum Tipo{
        OGRO,
        TROLL,
        ESPECTRO
    }
    public Tipo tipo;
    public int fuerza;

    public Monstruo() {}

    public Monstruo(String nombre, int vida, Tipo tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.tipo = tipo;
        switch (tipo) {
            case OGRO:
                fuerza = 30;
                break;
            case TROLL:
                fuerza = 15;
                break;
            case ESPECTRO:
                fuerza = 20;
                break;
            default:
                fuerza = 0;
                break;
        }
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
    public int getVida() {
        return vida;
    }

    /** 
     * @return Tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /** 
     * @return int
     */
    public int getFuerza() {
        return fuerza;
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
     * @param vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /** 
     * @param tipo
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /** 
     * @param fuerza
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Monstruo " + getId() + ".\nNombre: " + getNombre() + ".\nTipo: " + getTipo()
            + ".\nPuntos de vida: " + getVida() + ".\nPuntos de fuerza: " + getFuerza() + ".";
    }


    /** 
     * Método para que el monstruo ataque.
     * @param m
     */
    public void atacar(Mago m) {
        m.vida -= getFuerza();
    }
}