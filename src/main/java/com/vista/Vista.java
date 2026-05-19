package com.vista;

import com.controlador.*;
import com.modelo.*;

public class Vista {

    public void iniciar() {

        System.out.println("DRAGOLANDIA\n");

        MagoController magoCtrl = new MagoController();
        MonstruoController monCtrl = new MonstruoController();
        DragonController dragonCtrl = new DragonController();
        BosqueController bosqueCtrl = new BosqueController();

        Mago m1 = new Mago("Paco", 100, 20, null);
        Mago m2 = new Mago("Alfonso", 100, 25, null);
        magoCtrl.crearMago(m1);
        magoCtrl.crearMago(m2);

        Monstruo mon1 = new Monstruo("Ogro", 80, 15, TipoMonstruo.OGRO);
        Monstruo mon2 = new Monstruo("Troll", 90, 20, TipoMonstruo.TROLL);
        monCtrl.crearMonstruo(mon1);
        monCtrl.crearMonstruo(mon2);

        Bosque bosque = new Bosque("Bosque Oscuro", 10, mon2, null);
        bosqueCtrl.crear(bosque);
        bosqueCtrl.asignarJefe(bosque, mon1);

        Dragon dragon = new Dragon("Samuel", 30, 20, bosque);
        dragonCtrl.crear(dragon);

        System.out.println("\nCOMBATE");

        m1.lanzarHechizo(mon1);
        System.out.println("Paco ataca a Ogro");

        mon1.atacar(m1);
        System.out.println("Ogro contraataca");

        dragon.exhalar(mon1);
        System.out.println("Dragón quema al jefe");

        System.out.println("\nESTADO FINAL");
        System.out.println("Vida Ogro: " + mon1.getVida());
        System.out.println("Vida Paco: " + m1.getVida());
    }
}