package com.example.controller;

import com.example.model.*;

import jakarta.persistence.*;

public class ConConjuro {

    private static EntityManager gestorEntidades;
    private static EntityTransaction gestorTransaction;

    public ConConjuro() {
        gestorEntidades = EmFactory.getEntityManager();
        gestorTransaction = gestorEntidades.getTransaction();
    }

    /**
     * Guarda un conjuro en la base de datos.
     */
    public static void guardar(Conjuro c) {
        try {
            gestorTransaction.begin();
            gestorEntidades.persist(c);
            gestorTransaction.commit();
            System.out.println("Conjuro guardado correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un conjuro de la base de datos.
     */
    public static void eliminar(Conjuro c) {
        try {
            gestorTransaction.begin();
            c = gestorEntidades.find(Conjuro.class, c.getId());
            gestorEntidades.remove(c);
            gestorTransaction.commit();
            System.out.println("Conjuro eliminado correctamente de la BD.");
        } catch (Exception e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica el hechizo de un conjuro de la base de datos.
     */
    public static void modificarHechizo(Conjuro c, Hechizo h) {
        try {
            gestorTransaction.begin();
            c = gestorEntidades.find(Conjuro.class, c.getId());
            c.setHechizo(h);
            gestorTransaction.commit();
            System.out.println("Hechizo del conjuro modificado correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un conjuro de la base de datos.
     */
    public static Bosque mostrar(Bosque b) {
        return gestorEntidades.find(Bosque.class, b.getId());
    }

}