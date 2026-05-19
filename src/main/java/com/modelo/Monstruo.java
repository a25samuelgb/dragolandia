package com.modelo;

import jakarta.persistence.*;

@Entity
public class Monstruo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int vida;
    private int fuerza;

    @Enumerated(EnumType.STRING)
    private TipoMonstruo tipo;

    public Monstruo(String nombre, int vida, int fuerza, TipoMonstruo tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.tipo = tipo;
    }

    public Monstruo() {}


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public TipoMonstruo getTipo() {
        return tipo;
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

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setTipo(TipoMonstruo tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "Monstruo:" + "\nId=" + id + "\nNombre=" + nombre + "\nVida=" + vida + "\nFuerza=" + fuerza + "\nTipo=" + tipo;
    }
    
    
    public void atacar(Mago m) {
        m.setVida(m.getVida() - fuerza);
    }
}