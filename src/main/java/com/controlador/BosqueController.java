package com.controlador;

import com.gestor.GestorBosque;
import com.modelo.*;

public class BosqueController {

    private GestorBosque gestor = new GestorBosque();

    public void crear(Bosque b) {
        gestor.crear(b);
    }

    public void asignarJefe(Bosque b, Monstruo m) {
        b.setMonstruoJefe(m);
        gestor.actualizar(b);
    }
}