package com.example;

import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.example.controller.*;
import com.example.model.*;
import com.example.view.VistaDragolandia;

/**
 * Clase principal del proyecto Dragolandia.
 * @author Samuel.
 */
public class Principal {

    static Session sessionFactory = null;

    /** 
     * @param args
     */
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            SwingUtilities.invokeLater(() -> {
                VistaDragolandia vista = new VistaDragolandia();
                vista.setVisible(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Simula la partida de Dragolandia.
     */
    public static String simularPartida() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== COMIENZA LA PARTIDA ===\n\n");

        Mago mago = new Mago("Merlín", 100, 25);
        Monstruo ogro = new Monstruo("Manolo", 80, Monstruo.Tipo.OGRO);
        Hechizo bolaFuego = new Hechizo("Bola de fuego", 10);

        sb.append(mago.toString()).append("\n");

        mago.lanzarHechizo(ogro, bolaFuego);
        sb.append("El mago lanza Bola de fuego.\n");
        sb.append("Vida del ogro: ").append(ogro.getVida()).append("\n\n");

        ogro.atacar(mago);
        sb.append("El ogro ataca al mago.\n");
        sb.append("Vida del mago: ").append(mago.getVida()).append("\n\n");

        ConMago.guardar(mago);
        ConMonstruo.guardar(ogro);

        sb.append("Datos guardados en la base de datos.\n");
        sb.append("=== FIN DE LA PARTIDA ===\n");

        return sb.toString();
    }
}
