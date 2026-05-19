package com.gestor;

import java.util.List;
import org.hibernate.*;
import com.modelo.Mago;
import com.util.HibernateUtil;

public class GestorMago {

    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public void crear(Mago mago) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.persist(mago);
        tx.commit();
        s.close();
    }

    public Mago obtener(int id) {
        Session s = factory.openSession();
        Mago m = s.get(Mago.class, id);
        s.close();
        return m;
    }

    public List<Mago> listar() {
        Session s = factory.openSession();
        List<Mago> lista = s.createQuery("from Mago", Mago.class).list();
        s.close();
        return lista;
    }

    public void actualizar(Mago mago) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.merge(mago);
        tx.commit();
        s.close();
    }

    public void eliminar(Mago mago) {
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.remove(mago);
        tx.commit();
        s.close();
    }
}