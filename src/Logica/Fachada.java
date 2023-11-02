package Logica;

import Dominio.*;
import Excepciones.LoginException;
import Excepciones.MesaException;
import comun.Observable;
import comun.Observador;
import java.util.ArrayList;

public class Fachada extends Observable implements Observador {

    private static Fachada instancia;  //singleton
    private ServicioUsuario servicioUsuario;
    private ServicioMesa servicioMesa;

    public static synchronized Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    private Fachada() {
        servicioUsuario = ServicioUsuario.getInstancia();
        servicioMesa = ServicioMesa.getInstancia();
        servicioMesa.agregar(this); //observable servicioMesa, observador Fachada 
        servicioUsuario.agregar(this); //observable servicioUsuario, observador Fachada 
    }

    public Jugador loginJugador(int ci, String pass) throws LoginException {
        return servicioUsuario.logInJugador(ci, pass);
    }

    public Crupier loginCrupier(int ci, String pass) throws LoginException {
        return servicioUsuario.logInCrupier(ci, pass);
    }

    public void agregarJugador(Jugador j) {
        servicioUsuario.agregarJugador(j);
    }

    public void agregarCrupier(Crupier c) {
        servicioUsuario.agregarCrupier(c);
    }

    public void agregarMesa(Mesa mesa) {
        servicioMesa.agregarMesa(mesa);
    }

    public void eliminarMesa(Mesa mesa) {
        servicioMesa.eliminarMesa(mesa);
    }

    public ArrayList<Mesa> mesasDisponibles() {
        return servicioMesa.mesasDisponibles();
    }

    public void agregarTipoApuesta(TipoApuesta tipo) {
        servicioMesa.agregarTipoApuesta(tipo);
    }

    public ArrayList<TipoApuesta> tipoApuestaDisponibles() {
        return servicioMesa.tiposApuestaDisponibles();
    }

    public void crearMesa(String mensaje) {
        servicioMesa.agregarMesa(new Mesa(mensaje));
    }

    public void unirseAmesa(Jugador j, Mesa mesa) throws MesaException {
        servicioUsuario.unirseAmesa(j, mesa);
    }

    public void abandonarAmesa(Jugador j, Mesa mesa) {
        servicioUsuario.abandonarMesa(j, mesa);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.MesaAgregada.equals(evento)) {
            avisar(Eventos.MesaAgregada);
        }
        if (Eventos.UnirseAmesa.equals(evento)) {
            avisar(Eventos.UnirseAmesa);
        }
    }
}
