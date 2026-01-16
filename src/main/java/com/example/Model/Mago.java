package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.controller.ConMonstruo;

import jakarta.persistence.*;

/**
 * Clase Mago.
 * @author Samuel.
 */
@Entity
@Table(name = "mago")
public class Mago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nombre;
    public int vida;
    public int nivelMagia;
    public ArrayList<Hechizo> conjuros;
    
    public Mago() {}

    public Mago(String nombre, int vida, int nivelMagia) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivelMagia = nivelMagia;
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
     * @return int
     */
    public int getNivelMagia() {
        return nivelMagia;
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
        if (vida < 0) {
            this.vida = 0;
        }else{
            this.vida = vida;
        }
    }

    /** 
     * @param nivelMagia
     */
    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Mago " + getId() + ".\nNombre: " + getNombre() + ".\nVida: " + getVida() 
            + ".\nNivel: " + getNivelMagia() + ".";
    }


    /** 
     * Método básico para que el mago lance un hechizo.
     * @param m
     */
    public void lanzarHechizo(Monstruo m){
        m.vida -= getNivelMagia();
        ConMonstruo.modificarVida(m, m.vida);
    }

    /** 
     * Método avanzado para que el mago lance un hechizo.
     * @param m
     * @param h
     */
    public void lanzarHechizo(Monstruo m, Hechizo h){
        boolean restar = true;

        for (Hechizo hech : conjuros) {
            if (h.getNombre().equals(hech.getNombre())) {
                if (h.getNombre().equals("Bola de nieve")) {
                    m.vida = 0;
                    ConMonstruo.modificarVida(m, m.vida);
                }else if (h.getNombre().equals("Bola de fuego")) {
                    for (Monstruo monstruo : Bosque.monstruos) {
                        monstruo.vida -= h.getDanho();
                        ConMonstruo.modificarVida(monstruo, monstruo.vida);
                    }
                }else{
                    m.vida -= h.getDanho();
                    ConMonstruo.modificarVida(m, m.vida);
                }

                System.out.println(getNombre() + " atacó a " + m.getNombre() + " con " + h.getNombre().toLowerCase() + ".");
                restar = false;
            }
        }

        if (restar) {
            setVida(vida-1);
            System.out.println(getNombre() + " no conoce este hechizo, perdió 1 punto de vida.");
        }
    }
}