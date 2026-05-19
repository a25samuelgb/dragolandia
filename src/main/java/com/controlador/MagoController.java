package com.controlador;

import java.util.List;
import com.gestor.GestorMago;
import com.modelo.*;

public class MagoController {

    private GestorMago gestor = new GestorMago();

    public void crearMago(Mago m) {
        if (m.getVida() < 0) m.setVida(0);
        gestor.crear(m);
    }

    public List<Mago> listarMagos() {
        return gestor.listar();
    }

    public void lanzarHechizo(Mago m, Monstruo mon) {
        m.lanzarHechizo(mon);
        gestor.actualizar(m);
    }
}
