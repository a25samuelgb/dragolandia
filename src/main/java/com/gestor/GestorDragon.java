package com.gestor;

import java.util.List;
import org.hibernate.*;
import com.modelo.Dragon;
import com.util.HibernateUtil;

public class GestorDragon {

    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public void crear(Dragon d) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.persist(d);
        tx.commit();
        s.close();
    }

    public List<Dragon> listar() {
        Session s = factory.openSession();
        List<Dragon> lista = s.createQuery("from Dragon", Dragon.class).list();
        s.close();
        return lista;
    }

    public void actualizar(Dragon d) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.merge(d);
        tx.commit();
        s.close();
    }

    public void eliminar(Dragon d) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.remove(d);
        tx.commit();
        s.close();
    }
}