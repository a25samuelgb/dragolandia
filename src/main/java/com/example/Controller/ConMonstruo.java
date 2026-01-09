package com.example.Controller;

import org.hibernate.*;

import com.example.Model.*;

public class ConMonstruo {

    static Session sessionFactory = null;

    /**
     * Guarda un monstruo en la base de datos.
     */
    public static <T> void guardar(Monstruo m) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.persist(m);
            tx.commit();
            System.out.println("Monstruo guardado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un monstruo de la base de datos.
     */
    public static <T> void eliminar(Monstruo m) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.remove(m);
            tx.commit();
            System.out.println("Monstruo eliminado correctamente de la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica la vida de un monstruo de la base de datos.
     */
    public static <T> void modificarVida(Monstruo m, int vida) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            m = session.find(Monstruo.class, session);
            m.setVida(vida);
            tx.commit();
            System.out.println("Monstruo modificado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un monstruo de la base de datos.
     */
    public static <T> void mostrar(Monstruo m) {
        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            m = session.find(Monstruo.class, session);
            m.toString();
        } catch (Exception e) {
            System.err.println("Error al mostrar: " + e.getMessage());
        }
    }

}