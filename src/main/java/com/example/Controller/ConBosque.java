package com.example.controller;

import com.example.model.*;

import jakarta.persistence.*;

public class ConBosque {

    private static EntityManager gestorEntidades;
    private static EntityTransaction gestorTransaction;

    public ConBosque() {
        gestorEntidades = EmFactory.getEntityManager();
        gestorTransaction = gestorEntidades.getTransaction();
    }

    /**
     * Guarda un bosque en la base de datos.
     */
    public static void guardar(Bosque b) {
        try {
            gestorTransaction.begin();
            gestorEntidades.persist(b);
            gestorTransaction.commit();
            System.out.println("Bosque guardado correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un bosque de la base de datos.
     */
    public static void eliminar(Bosque b) {
        try {
            gestorTransaction.begin();
            b = gestorEntidades.find(Bosque.class, b.getId());
            gestorEntidades.remove(b);
            gestorTransaction.commit();
            System.out.println("Bosque eliminado correctamente de la BD.");
        } catch (Exception e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica un el monstruo jefe de un bosque de la base de datos.
     */
    public static void modificarJefe(Bosque b, Monstruo m) {
        try {
            gestorTransaction.begin();
            b = gestorEntidades.find(Bosque.class, b.getId());
            b.setMonstruoJefe(m);
            gestorTransaction.commit();
            System.out.println("Monstruo jefe del bosque modificado correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un bosque de la base de datos.
     */
    public static Bosque mostrar(Bosque b) {
        return gestorEntidades.find(Bosque.class, b.getId());
    }

}