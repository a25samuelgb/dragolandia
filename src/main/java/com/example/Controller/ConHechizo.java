package com.example.controller;

import com.example.model.*;

import jakarta.persistence.*;

public class ConHechizo {

    private static EntityManager gestorEntidades;
    private static EntityTransaction gestorTransaction;

    public ConHechizo() {
        gestorEntidades = EmFactory.getEntityManager();
        gestorTransaction = gestorEntidades.getTransaction();
    }

    /**
     * Guarda un hechizo en la base de datos.
     */
    public static void guardar(Hechizo h) {
        try {
            gestorTransaction.begin();
            gestorEntidades.persist(h);
            gestorTransaction.commit();
            System.out.println("Hechizo guardado correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un hechizo de la base de datos.
     */
    public static void eliminar(Hechizo h) {
        try {
            gestorTransaction.begin();
            gestorEntidades.remove(h);
            gestorTransaction.commit();
            System.out.println("Hechizo eliminado correctamente de la BD.");
        } catch (Exception e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica el daño de un hechizo de la base de datos.
     */
    public static void modificarVida(Hechizo h, int danho) {
        try {
            gestorTransaction.begin();
            h = gestorEntidades.find(Hechizo.class, h.getId());
            h.setDanho(danho);
            gestorTransaction.commit();
            System.out.println("Daño del hechizo modificado correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un hechizo de la base de datos.
     */
    public static Hechizo mostrar(Hechizo h) {
        return gestorEntidades.find(Hechizo.class, h.getId());
    }

}