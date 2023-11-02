package Logica;

import Dominio.*;
import Excepciones.LoginException;

public class DatosPrueba {

    public static void iniciar() throws LoginException {
        Crupier c1 = new Crupier(101, "aaa");
        Crupier c2 = new Crupier(102, "bbb");
        Crupier c3 = new Crupier(103, "ccc");

        Fachada.getInstancia().agregarCrupier(c1);
        Fachada.getInstancia().agregarCrupier(c2);
        Fachada.getInstancia().agregarCrupier(c3);

        Jugador j1 = new Jugador(201, "aaa", "Jugador 1", 1000);
        Jugador j2 = new Jugador(202, "bbb", "Jugador 2", 500);
        Jugador j3 = new Jugador(203, "ccc", "Jugador 3", 100);
        Jugador j4 = new Jugador(204, "ddd", "Jugador 4", 50);
        Jugador j5 = new Jugador(205, "eee", "Jugador 5", 10);

        Fachada.getInstancia().agregarJugador(j1);
        Fachada.getInstancia().agregarJugador(j2);
        Fachada.getInstancia().agregarJugador(j3);
        Fachada.getInstancia().agregarJugador(j4);
        Fachada.getInstancia().agregarJugador(j5);

        //eliminar estas mesas, son solo de prueba
        Mesa m1 = new Mesa("Mesa 1");
        Mesa m2 = new Mesa("Mesa 2");
        Fachada.getInstancia().agregarMesa(m1);
        Fachada.getInstancia().agregarMesa(m2);

        ApuestaDirecta aDir = new ApuestaDirecta("Apuesta directa");
        ApuestaColor aCol = new ApuestaColor("Apuesta color");
        ApuestaDocena aDoc = new ApuestaDocena("Apuesta de docena");

        Fachada.getInstancia().agregarTipoApuesta(aDir);
        Fachada.getInstancia().agregarTipoApuesta(aCol);
        Fachada.getInstancia().agregarTipoApuesta(aDoc);
    }
}
