package com.example.Controller;

import org.hibernate.*;

import com.example.Model.*;

public class ConDragon {

    static Session sessionFactory = null;

    /**
     * Guarda un dragón en la base de datos.
     */
    public static <T> void guardar(Dragon d) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.persist(d);
            tx.commit();
            System.out.println("Dragón guardado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un dragón de la base de datos.
     */
    public static <T> void eliminar(Dragon d) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.remove(d);
            tx.commit();
            System.out.println("Dragón eliminado correctamente de la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica la vida de un dragón de la base de datos.
     */
    public static <T> void modificarVida(Dragon d, int vida) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            d = session.find(Dragon.class, session);
            d.setVida(vida);
            tx.commit();
            System.out.println("Dragón modificado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un dragón de la base de datos.
     */
    public static <T> void mostrar(Dragon d) {
        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            d = session.find(Dragon.class, session);
            d.toString();
        } catch (Exception e) {
            System.err.println("Error al mostrar: " + e.getMessage());
        }
    }

}