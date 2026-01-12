package com.example.controller;

import com.example.model.*;

import jakarta.persistence.*;

public class ConMago {

    private static EntityManager gestorEntidades;
    private static EntityTransaction gestorTransaction;

    public ConMago() {
        gestorEntidades = EmFactory.getEntityManager();
        gestorTransaction = gestorEntidades.getTransaction();
    }

    /**
     * Guarda un mago en la base de datos.
     */
    public static void guardar(Mago m) {
        try {
            gestorTransaction.begin();
            gestorEntidades.persist(m);
            gestorTransaction.commit();
            System.out.println("Mago guardado correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un mago de la base de datos.
     */
    public static void eliminar(Mago m) {
        try {
            gestorTransaction.begin();
            gestorEntidades.remove(m);
            gestorTransaction.commit();
            System.out.println("Mago eliminado correctamente de la BD.");
        } catch (Exception e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica la vida de un mago de la base de datos.
     */
    public static void modificarVida(Mago m, int vida) {
        try {
            gestorTransaction.begin();
            m = gestorEntidades.find(Mago.class, m.getId());
            m.setVida(vida);
            gestorTransaction.commit();
            System.out.println("Vida del mago modificada correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un mago de la base de datos.
     */
    public static Mago mostrar(Mago m) {
        return gestorEntidades.find(Mago.class, m.getId());
    }

}