package com.controlador;

import java.util.List;
import com.gestor.GestorMonstruo;
import com.modelo.Monstruo;

public class MonstruoController {

    private GestorMonstruo gestor = new GestorMonstruo();

    public void crearMonstruo(Monstruo m) {
        if (m.getVida() < 0) m.setVida(0);
        gestor.crear(m);
    }

    public List<Monstruo> listar() {
        return gestor.listar();
    }
}