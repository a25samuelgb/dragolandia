package com.gestor;

import java.util.List;
import org.hibernate.*;
import com.modelo.Hechizo;
import com.util.HibernateUtil;

public class GestorHechizo {

    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public void crear(Hechizo h) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.persist(h);
        tx.commit();
        s.close();
    }

    public List<Hechizo> listar() {
        Session s = factory.openSession();
        List<Hechizo> lista = s.createQuery("from Hechizo", Hechizo.class).list();
        s.close();
        return lista;
    }

    public void actualizar(Hechizo h) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.merge(h);
        tx.commit();
        s.close();
    }

    public void eliminar(Hechizo h) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.remove(h);
        tx.commit();
        s.close();
    }
}