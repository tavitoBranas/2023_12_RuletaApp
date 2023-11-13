package Logica;

import Dominio.*;
import Excepciones.LoginException;
import Excepciones.MesaAbandonoException;
import Excepciones.MesaNoDisponibleException;
import comun.Observable;
import comun.Observador;
import java.util.ArrayList;

public class Fachada extends Observable implements Observador {

    private static Fachada instancia;
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
        servicioMesa.agregar(this);
        servicioUsuario.agregar(this);
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

    public void desloguearUsuarioCrupier(Crupier crupier) {
        servicioUsuario.desloguearUsuarioCrupier(crupier);
    }

    public void desloguearUsuarioJugador(Jugador jugador) throws MesaNoDisponibleException, MesaAbandonoException {
        servicioUsuario.desloguearUsuarioJugador(jugador);
    }

    public void desloguearJugadordeMesas(Jugador jugador) throws MesaNoDisponibleException, MesaAbandonoException {
        servicioMesa.desloguearJugadordeMesas(jugador);
    }

    public Efecto buscarEfecto(String efectoSeleccionado) {
        ArrayList<Efecto> efectos = servicioMesa.getEfectosDisponibles();
        Efecto retorno = null;
        for (int i = 0; i < efectos.size() && retorno == null; i++) {
            if (efectos.get(i).getNombre().equals(efectoSeleccionado)) {
                retorno = efectos.get(i);
            }
        }
        return retorno;
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.MesaAgregada.equals(evento)) {
            avisar(Eventos.MesaAgregada);
        }
        if (Eventos.UsuarioAgregado.equals(evento)) {
            avisar(Eventos.UsuarioAgregado);
        }
        if (Eventos.UsuarioDeslogueado.equals(evento)) {
            avisar(Eventos.UsuarioDeslogueado);
        }
        if (Eventos.MesaEliminada.equals(evento)) {
            avisar(Eventos.MesaEliminada);
        }
    }
}
