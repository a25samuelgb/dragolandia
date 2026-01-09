package com.example.Controller;

import org.hibernate.*;

import com.example.Model.*;

public class ConConjuro {

    static Session sessionFactory = null;

    /**
     * Guarda un conjuro en la base de datos.
     */
    public static <T> void guardar(Conjuro c) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.persist(c);
            tx.commit();
            System.out.println("Conjuro guardado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un conjuro de la base de datos.
     */
    public static <T> void eliminar(Conjuro c) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.remove(c);
            tx.commit();
            System.out.println("Conjuro eliminado correctamente de la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica el hechizo de un conjuro de la base de datos.
     */
    public static <T> void modificarHechizo(Conjuro c, Hechizo h) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            c = session.find(Conjuro.class, session);
            c.setHechizo(h);
            tx.commit();
            System.out.println("Objeto modificado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un conjuro de la base de datos.
     */
    public static <T> void mostrar(Conjuro c) {
        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            c = session.find(Conjuro.class, session);
            c.toString();
        } catch (Exception e) {
            System.err.println("Error al mostrar: " + e.getMessage());
        }
    }

}