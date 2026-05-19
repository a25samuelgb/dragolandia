package com.gestor;

import java.util.List;
import org.hibernate.*;
import com.modelo.Monstruo;
import com.util.HibernateUtil;

public class GestorMonstruo {

    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public void crear(Monstruo m) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.persist(m);
        tx.commit();
        s.close();
    }

    public List<Monstruo> listar() {
        Session s = factory.openSession();
        List<Monstruo> lista = s.createQuery("from Monstruo", Monstruo.class).list();
        s.close();
        return lista;
    }

    public void actualizar(Monstruo m) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.merge(m);
        tx.commit();
        s.close();
    }

    public void eliminar(Monstruo m) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.remove(m);
        tx.commit();
        s.close();
    }
}