package com.example;

import jakarta.persistence.*;

/**
 * Clase Mago.
 * @author Samuel.
 */
@Entity
@Table(name = "mago")
public class Mago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nombre;
    public int vida;
    public int nivelMagia;
    public Hechizo[] conjuros = {
        new Hechizo("Bola de fuego", 10),
        new Hechizo("Rayo", 15),
        new Hechizo("Bola de nieve", 0),
        new Hechizo("Carga de energía", 5)
    };
    
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
        this.vida = vida;
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
    }

    /** 
     * Método avanzado para que el mago lance un hechizo.
     * @param m
     * @param h
     */
    public void lanzarHechizo(Monstruo m, Hechizo h){
        boolean restar = true;

        for (int i = 0; i < conjuros.length; i++) {
            if (h.getNombre().equals(conjuros[i].getNombre())) {

                if (h.getNombre().equals("Bola de nieve")) {
                    m.vida = 0;
                }else if (h.getNombre().equals("Bola de fuego")) {
                    for (Monstruo monstruo : Bosque.monstruos) {
                        monstruo.vida -= h.getDanho();
                    }
                }else{
                    m.vida -= h.getDanho();
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