package com.example;

import javax.swing.*;
import java.awt.*;

/**
 * Vista sencilla del juego Dragolandia.
 * @author Samuel.
 */
public class Vista extends JFrame {

    private JTextArea areaTexto;
    private JButton botonIniciar;

    public Vista() {
        setTitle("Dragolandia");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        botonIniciar = new JButton("Iniciar partida");

        add(scroll, BorderLayout.CENTER);
        add(botonIniciar, BorderLayout.SOUTH);

        botonIniciar.addActionListener(e -> iniciarPartida());
    }

    /**
     * Llama al método de Principal que simula la partida
     */
    private void iniciarPartida() {
        String resultado = Principal.simularPartida();
        areaTexto.setText(resultado);
    }
}
