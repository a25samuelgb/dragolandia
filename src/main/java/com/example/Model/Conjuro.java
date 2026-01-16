package com.example.model;

import java.io.Serializable;

import jakarta.persistence.*;

/**
 * Clase Bosque.
 * @author Samuel
 */
@Entity
@Table(name = "conjuro")
public class Conjuro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public Mago mago;
    public Hechizo hechizo;

    public Conjuro() {}

    public Conjuro(int id, Mago mago, Hechizo hechizo) {
        this.id = id;
        this.mago = mago;
        this.hechizo = hechizo;
    }

    public int getId() {
        return id;
    }

    public Mago getMago() {
        return mago;
    }

    public Hechizo getHechizo() {
        return hechizo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMago(Mago mago) {
        this.mago = mago;
    }

    public void setHechizo(Hechizo hechizo) {
        this.hechizo = hechizo;
    }

    @Override
    public String toString() {
        return "Hechizo: " + hechizo.getNombre() + ".\nConjurado por: " + mago.getNombre() + ".";
    }

}