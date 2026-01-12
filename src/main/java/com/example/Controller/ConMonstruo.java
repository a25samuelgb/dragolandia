package com.example.controller;

import com.example.model.*;

import jakarta.persistence.*;

public class ConMonstruo {

    private static EntityManager gestorEntidades;
    private static EntityTransaction gestorTransaction;

    public ConMonstruo() {
        gestorEntidades = EmFactory.getEntityManager();
        gestorTransaction = gestorEntidades.getTransaction();
    }

    /**
     * Guarda un monstruo en la base de datos.
     */
    public static void guardar(Monstruo m) {
        try {
            gestorTransaction.begin();
            gestorEntidades.persist(m);
            gestorTransaction.commit();
            System.out.println("Monstruo guardado correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un monstruo de la base de datos.
     */
    public static <T> void eliminar(Monstruo m) {
        try {
            gestorTransaction.begin();
            gestorEntidades.persist(m);
            gestorTransaction.commit();
            System.out.println("Monstruo eliminado correctamente de la BD.");
        } catch (Exception e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica la vida de un monstruo de la base de datos.
     */
    public static <T> void modificarVida(Monstruo m, int vida) {
        try {
            gestorTransaction.begin();
            m = gestorEntidades.find(Monstruo.class, m.getId());
            m.setVida(vida);
            gestorTransaction.commit();
            System.out.println("Vida del monstruo modificada correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un monstruo de la base de datos.
     */
    public static Monstruo mostrar(Monstruo m) {
        return gestorEntidades.find(Monstruo.class, m.getId());
    }

}