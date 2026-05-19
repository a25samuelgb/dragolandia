package com.modelo;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Bosque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int nivelPeligro;

    @OneToOne
    private Monstruo monstruoJefe;

    @OneToMany
    private List<Monstruo> monstruos;

    public Bosque(String nombre, int nivelPeligro, Monstruo monstruoJefe, List<Monstruo> monstruos) {
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
        this.monstruoJefe = monstruoJefe;
        this.monstruos = monstruos;
    }

    public Bosque() {}


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelPeligro() {
        return nivelPeligro;
    }

    public Monstruo getMonstruoJefe() {
        return monstruoJefe;
    }

    public List<Monstruo> getMonstruos() {
        return monstruos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    public void setMonstruoJefe(Monstruo monstruoJefe) {
        this.monstruoJefe = monstruoJefe;
    }

    public void setMonstruos(List<Monstruo> monstruos) {
        this.monstruos = monstruos;
    }


    @Override
    public String toString() {
        return "Bosque:" + "\nId=" + id + "\nNombre=" + nombre + "\nNivel de Peligro=" + nivelPeligro + "\nMonstruo Jefe=" + monstruoJefe + "\nMonstruos=" + monstruos;
    }
    

    public void addMonstruo(Monstruo m) {
        monstruos.add(m);
    }

    public void cambiarJefe(Monstruo m) {
        this.monstruoJefe = m;
    }
}