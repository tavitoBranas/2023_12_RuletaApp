package Logica;

import Dominio.*;
import Excepciones.LoginException;
import Excepciones.MesaException;
import Excepciones.UsuarioEnMesaException;
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

    public ArrayList<Efecto> efectosDisponibles() {
        return servicioMesa.getEfectosDisponibles();
    }

    public void agregarEfecto(Efecto efecto) {
        servicioMesa.agregarEfecto(efecto);
    }

    public void crearMesa(Mesa mesa) {
        //la mesa no tiene excepciones?
        servicioMesa.agregarMesa(mesa);
    }

    public Mesa traerMesa(String mesa) {
        return servicioMesa.traerMesa(mesa);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.MesaAgregada.equals(evento)) {
            avisar(Eventos.MesaAgregada);
        }
        if (Eventos.UnirseAmesa.equals(evento)) {
            avisar(Eventos.UnirseAmesa);
        }
        if (Eventos.UsuarioDeslogueado.equals(evento)) {
            avisar(Eventos.UsuarioDeslogueado);
        }
        if (Eventos.MesaEliminada.equals(evento)) {
            avisar(Eventos.MesaEliminada);
        }
    }

    public void desloguearUsuarioCrupier(Crupier crupier) {
        servicioUsuario.desloguearUsuarioCrupier(crupier);
    }

    public void desloguearUsuarioJugador(Jugador jugador) {
        servicioUsuario.desloguearUsuarioJugador(jugador);
    }

    public void desloguearJugadordeMesas(Jugador jugador) {
        servicioMesa.desloguearJugadordeMesas(jugador);
    }

}
