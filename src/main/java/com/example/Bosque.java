package com.example;

import java.util.ArrayList;
import jakarta.persistence.*;

/**
 * Clase Bosque.
 * @author Samuel
 */
@Entity
@Table(name = "bosque")
public class Bosque {

    @Id
    public int id;
    public String nombre;
    public int nivelPeligro;
    public Monstruo monstruoJefe;
    public ArrayList<Monstruo> monstruos;
    
    public Bosque(int id, String nombre, int nivelPeligro, Monstruo monstruoJefe) {
        this.id = id;
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
        this.monstruoJefe = monstruoJefe;
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
    public int getNivelPeligro() {
        return nivelPeligro;
    }

    /** 
     * @return Monstruo
     */
    public Monstruo getMonstruoJefe() {
        return monstruoJefe;
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
     * @param nivelPeligro
     */
    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    /** 
     * @param monstruoJefe
     */
    public void setMonstruoJefe(Monstruo monstruoJefe) {
        this.monstruoJefe = monstruoJefe;
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Bosque " + getId() + ".\nNombre: " + getNombre() + ".\nNivel de peligro: " + getNivelPeligro()
            + ".\nJefe: " + monstruoJefe.getNombre();
    }


    /**
     * Método que muestra el jefe del bosque.
     */
    public void mostrarJefe() {
        monstruoJefe.toString();
    }

    /** 
     * Método para cambiar el jefe del bosque.
     * @param m
     */
    public void cambiarJefe(Monstruo m) {
        setMonstruoJefe(m);
    }

    /** 
     * Método par añadir un monstruo al bosque.
     * @param m
     */
    public void addMonstruo(Monstruo m) {
        monstruos.add(m);
    }


    @OneToMany
    private Monstruo monstruo;
}