package com.example.controller;

import jakarta.persistence.*;

public class EmFactory {

    private static final EntityManagerFactory xestorEntidades = Persistence
            .createEntityManagerFactory("dragolandiaServizo");

    /**
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        return xestorEntidades.createEntityManager();
    }

    public static void close() {
        if (xestorEntidades.isOpen()) {
            xestorEntidades.close();
        }
    }
}