package Controlador;

import Dominio.Eventos;
import Dominio.Jugador;
import Dominio.Mesa;
import Excepciones.MesaAbandonoException;
import Excepciones.MesaNoDisponibleException;
import Excepciones.UsuarioEnMesaException;
import Logica.Fachada;
import UI.Interface.UnirseMesaVista;
import comun.Observable;
import comun.Observador;

public class UnirseAmesaVistaControlador implements Observador {

    private UnirseMesaVista vista;
    private Fachada fachada;
    private Jugador jugador;
    
    public UnirseAmesaVistaControlador(UnirseMesaVista vista, Jugador jugador) {
        this.vista = vista;
        this.jugador = jugador;
        fachada = Fachada.getInstancia();
        fachada.agregar(this);
        inicializarVista();
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.MesaAgregada.equals(evento) || Eventos.MesaEliminada.equals(evento) ) {
            vista.mostrarMesasAbiertas(fachada.mesasDisponibles());
        }
    }
    
    private void inicializarVista() {
        vista.mostrarMesasAbiertas(fachada.mesasDisponibles());
        vista.datosJugador(jugador);
    }
    
    public void unirseAmesa(String mesa) {
        try {
            Mesa retornoMesa = fachada.traerMesa(mesa);
            retornoMesa.ingresarAmesa(jugador);
            vista.ejecutarCasoDeUsoJugar(retornoMesa, jugador);
        } catch (UsuarioEnMesaException | MesaNoDisponibleException e) {
            vista.mostrarMensajeError(e.getMessage());
        }
    }

    public void desloguear() {
        try {
            fachada.desloguearUsuarioJugador(this.jugador);
            vista.cerrarVentana();
        } catch (MesaNoDisponibleException | MesaAbandonoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }
}
