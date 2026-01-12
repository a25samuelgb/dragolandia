package com.example.controller;

import com.example.model.*;

import jakarta.persistence.*;

public class ConDragon {

    private static EntityManager gestorEntidades;
    private static EntityTransaction gestorTransaction;

    public ConDragon() {
        gestorEntidades = EmFactory.getEntityManager();
        gestorTransaction = gestorEntidades.getTransaction();
    }

    /**
     * Guarda un dragón en la base de datos.
     */
    public static void guardar(Dragon d) {
        try {
            gestorTransaction.begin();
            gestorEntidades.persist(d);
            gestorTransaction.commit();
            System.out.println("Dragón guardado correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un dragón de la base de datos.
     */
    public static void eliminar(Dragon d) {
        try {
            gestorTransaction.begin();
            d = gestorEntidades.find(Dragon.class, d);
            gestorEntidades.remove(d);
            gestorTransaction.commit();
            System.out.println("Dragón eliminado correctamente de la BD.");
        } catch (Exception e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica la vida de un dragón de la base de datos.
     */
    public static void modificarVida(Dragon d, int vida) {
        try {
            gestorTransaction.begin();
            d = gestorEntidades.find(Dragon.class, d);
            d.setVida(vida);
            gestorTransaction.commit();
            System.out.println("Vida del dragón modificada correctamente en la BD.");
        } catch (Exception e) {
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un dragón de la base de datos.
     */
    public static Dragon mostrar(Dragon d) {
        return gestorEntidades.find(Dragon.class, d.getId());
    }

}