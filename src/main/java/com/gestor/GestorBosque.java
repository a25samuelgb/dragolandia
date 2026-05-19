package com.gestor;

import java.util.List;
import org.hibernate.*;
import com.modelo.Bosque;
import com.util.HibernateUtil;

public class GestorBosque {

    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public void crear(Bosque b) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.persist(b);
        tx.commit();
        s.close();
    }

    public List<Bosque> listar() {
        Session s = factory.openSession();
        List<Bosque> lista = s.createQuery("from Bosque", Bosque.class).list();
        s.close();
        return lista;
    }

    public void actualizar(Bosque b) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.merge(b);
        tx.commit();
        s.close();
    }

    public void eliminar(Bosque b) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.remove(b);
        tx.commit();
        s.close();
    }
}