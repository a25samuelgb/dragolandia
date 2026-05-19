package com.modelo;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Mago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int vida;
    private int nivelMagia;

    @ManyToMany
    private List<Hechizo> conjuros;

    public Mago(String nombre, int vida, int nivelMagia, List<Hechizo> conjuros) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivelMagia = nivelMagia;
        this.conjuros = conjuros;
    }

    public Mago() {}


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public List<Hechizo> getConjuros() {
        return conjuros;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

    public void setConjuros(List<Hechizo> conjuros) {
        this.conjuros = conjuros;
    }
    

    @Override
    public String toString() {
        return "Mago:" + "\nId=" + id + "\nNombre=" + nombre + "\nVida=" + vida + "\nNivel de Magia=" + nivelMagia + "\nConjuros=" + conjuros;
    }


    public void lanzarHechizo(Monstruo m) {
        m.setVida(m.getVida() - nivelMagia);
    }

    public void lanzarHechizo(Monstruo m, Hechizo h) {
        if (conjuros.contains(h)) {
            m.setVida(m.getVida() - h.getDanho());
        } else {
            this.vida -= 1;
        }
    }
}