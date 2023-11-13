package Logica;

import Dominio.*;
import Excepciones.LoginException;

public class DatosPrueba {

    public static void iniciar() throws LoginException {
        Crupier c1 = new Crupier(101, "aaa");
        Crupier c2 = new Crupier(102, "bbb");
        Crupier c3 = new Crupier(103, "ccc");
        Crupier c4 = new Crupier(104, "ddd");
        Crupier c5 = new Crupier(105, "eee");
        Crupier c6 = new Crupier(106, "fff");

        Fachada.getInstancia().agregarCrupier(c1);
        Fachada.getInstancia().agregarCrupier(c2);
        Fachada.getInstancia().agregarCrupier(c3);
        Fachada.getInstancia().agregarCrupier(c4);
        Fachada.getInstancia().agregarCrupier(c5);
        Fachada.getInstancia().agregarCrupier(c6);

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

        ApuestaDirecta aDir = new ApuestaDirecta(36);
        ApuestaColor aCol = new ApuestaColor(2);
        ApuestaDocena aDoc = new ApuestaDocena(3);

        Fachada.getInstancia().agregarTipoApuesta(aDir);
        Fachada.getInstancia().agregarTipoApuesta(aCol);
        Fachada.getInstancia().agregarTipoApuesta(aDoc);
       
        Efecto efectoAleatorio = new EfectoAleatorio();
        Efecto efectoAleatorioParcial = new EfectoAleatorioParcial();
        Efecto efectoSimulador = new EfectoSimulador();

        Fachada.getInstancia().agregarEfecto(efectoAleatorio);
        Fachada.getInstancia().agregarEfecto(efectoAleatorioParcial);
        Fachada.getInstancia().agregarEfecto(efectoSimulador);
    }
}
