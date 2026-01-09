package com.example.Controller;

import org.hibernate.*;

import com.example.Model.*;

public class ConMago {

    static Session sessionFactory = null;

    /**
     * Guarda un mago en la base de datos.
     */
    public static <T> void guardar(Mago m) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.persist(m);
            tx.commit();
            System.out.println("Mago guardado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Elimina un mago de la base de datos.
     */
    public static <T> void eliminar(Mago m) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            session.remove(m);
            tx.commit();
            System.out.println("Mago eliminado correctamente de la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Modifica la vida de un mago de la base de datos.
     */
    public static <T> void modificarVida(Mago m, int vida) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            tx = session.beginTransaction();
            m = session.find(Mago.class, session);
            m.setVida(vida);
            tx.commit();
            System.out.println("Mago modificado correctamente en la BD.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al modificar: " + e.getMessage());
        }
    }

    /**
     * Muestra un mago de la base de datos.
     */
    public static <T> void mostrar(Mago m) {
        try (Session session = ((SessionFactory) sessionFactory).openSession()) {
            m = session.find(Mago.class, session);
            m.toString();
        } catch (Exception e) {
            System.err.println("Error al mostrar: " + e.getMessage());
        }
    }

}