package com.modelo;

import jakarta.persistence.*;

@Entity
public class Dragon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int intensidadFuego;
    private int resistencia;

    @OneToOne
    private Bosque bosque;

    public Dragon(String nombre, int intensidadFuego, int resistencia, Bosque bosque) {
        this.nombre = nombre;
        this.intensidadFuego = intensidadFuego;
        this.resistencia = resistencia;
        this.bosque = bosque;
    }

    public Dragon() {}


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIntensidadFuego() {
        return intensidadFuego;
    }

    public int getResistencia() {
        return resistencia;
    }

    public Bosque getBosque() {
        return bosque;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIntensidadFuego(int intensidadFuego) {
        this.intensidadFuego = intensidadFuego;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void setBosque(Bosque bosque) {
        this.bosque = bosque;
    }


    @Override
    public String toString() {
        return "Dragon:" + "\nId=" + id + "\nNombre=" + nombre + "\nIntensidad de Fuego=" + intensidadFuego + "\nResistencia=" + resistencia + "\nBosque=" + bosque ;
    }


    public void exhalar(Monstruo m) {
        m.setVida(m.getVida() - intensidadFuego);
    }
}