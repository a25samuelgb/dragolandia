package com.example.Controller;

import org.hibernate.*;

import com.example.Model.*;

public class ConHechizo {

    static Session sessionFactory = null;

    /**
     * Guarda un hechizo en la base de datos.
     */
    public static <T> void guardar(Hechizo h) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.persist(h);
            tx.commit();
            System.out.println("Hechizo guardado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un hechizo de la base de datos.
     */
    public static <T> void eliminar(Hechizo h) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.remove(h);
            tx.commit();
            System.out.println("Hechizo eliminado correctamente de la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica el daño de un hechizo de la base de datos.
     */
    public static <T> void modificarVida(Hechizo h, int danho) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            h = session.find(Hechizo.class, session);
            h.setDanho(danho);
            tx.commit();
            System.out.println("Dragón modificado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un hechizo de la base de datos.
     */
    public static <T> void mostrar(Hechizo h) {
        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            h = session.find(Hechizo.class, session);
            h.toString();
        } catch (Exception e) {
            System.err.println("Error al mostrar: " + e.getMessage());
        }
    }

}