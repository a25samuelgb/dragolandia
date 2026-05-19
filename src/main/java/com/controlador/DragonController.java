package com.controlador;

import com.gestor.GestorDragon;
import com.modelo.*;

public class DragonController {

    private GestorDragon gestor = new GestorDragon();

    public void crear(Dragon d) {
        gestor.crear(d);
    }

    public void atacar(Dragon d, Monstruo m) {
        d.exhalar(m);
        gestor.actualizar(d);
    }
}