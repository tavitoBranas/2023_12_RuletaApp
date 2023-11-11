package Controlador;

import Dominio.Eventos;
import Dominio.Jugador;
import Dominio.Mesa;
import Excepciones.MesaAbandonoException;
import Excepciones.MesaNoDisponibleException;
import Logica.Fachada;
import comun.Observable;
import comun.Observador;
import UI.Interface.JugarVista;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JugarVistaControlador implements Observador {

    private JugarVista vista;
    private Jugador jugador;
    private Mesa modelo;

    public Fachada fachada;

    public JugarVistaControlador(JugarVista vistaJugar, Mesa mesa, Jugador jugador) {
        this.vista = vistaJugar;
        this.modelo = mesa;
        this.jugador = jugador;
        inicializarVista();
        mesa.agregar(this);
    }

    private void inicializarVista() {
        vista.cargarDatos(modelo, jugador);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.CierraMesa.equals(evento)) {
            vista.cargarMensajeCierre(modelo.getMensaje());
        }
        if (Eventos.UsuarioAbandonaMesa.equals(evento)) {
            vista.cerrarVentana();
        }
        if (Eventos.Pagar.equals(evento)) {
            ocultarNumeroGanador();
            actualizarEstadisticaYronda(modelo);
            reactivarApuestasYAbandono();
        }
        if (Eventos.Lanzar.equals(evento)) {
            numeroGanador(modelo.getEstadistica().getNumerosSorteados().get(0));
            bloqueoApuestasYAbandono();
        }
    }

    public void abandonarMesa() {
        try {
            modelo.desloguearJugadordeMesa(this.jugador);
            vista.cerrarVentana();
        } catch (MesaAbandonoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

    public void mensajeAceptado() {
        vista.cerrarVentana();
    }

    public void numeroGanador(int numero) {
        vista.mostrarNumeroGanador(numero);
    }

    private void ocultarNumeroGanador() {
        vista.ocultarNumeroGanador();
    }

    private void actualizarEstadisticaYronda(Mesa mesa) {
        vista.actualizarEstadisticaYronda(mesa);
    }

    private void bloqueoApuestasYAbandono() {
        vista.bloqueoApuestasYAbandono(modelo.getMensaje());
    }

    private void reactivarApuestasYAbandono() {
        vista.reactivarApuestasYAbandono(modelo.getMensaje());
    }
}
