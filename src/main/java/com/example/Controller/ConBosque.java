package com.example.Controller;

import org.hibernate.*;

import com.example.Model.*;

public class ConBosque {

    static Session sessionFactory = null;

    /**
     * Guarda un bosque en la base de datos.
     */
    public static <T> void guardar(Bosque b) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.persist(b);
            tx.commit();
            System.out.println("Objeto guardado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un bosque de la base de datos.
     */
    public static <T> void eliminar(Bosque b) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.remove(b);
            tx.commit();
            System.out.println("Objeto eliminado correctamente de la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica un el monstruo jefe de un bosque de la base de datos.
     */
    public static <T> void modificarJefe(Bosque b, Monstruo m) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            b = session.find(Bosque.class, session);
            b.setMonstruoJefe(m);
            tx.commit();
            System.out.println("Objeto modificado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un bosque de la base de datos.
     */
    public static <T> void mostrar(Bosque b) {
        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            b = session.find(Bosque.class, session);
            b.toString();
        } catch (Exception e) {
            System.err.println("Error al mostrar: " + e.getMessage());
        }
    }

}