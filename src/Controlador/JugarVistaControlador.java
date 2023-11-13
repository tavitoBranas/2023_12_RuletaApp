package Controlador;

import Dominio.Apuesta;
import Dominio.Eventos;
import Dominio.Jugador;
import Dominio.Mesa;
import Excepciones.ApuestaInvalidaException;
import Excepciones.MesaAbandonoException;
import Excepciones.MontoInsuficienteException;
import comun.Observable;
import comun.Observador;
import UI.Interface.JugarVista;
import java.util.ArrayList;
import java.util.Collection;

public class JugarVistaControlador implements Observador {

    private final JugarVista vista;
    private final Jugador jugador;
    private final Mesa modelo;

    public JugarVistaControlador(JugarVista vistaJugar, Mesa mesa, Jugador jugador) {
        this.vista = vistaJugar;
        this.modelo = mesa;
        this.jugador = jugador;
        inicializarVista();
        mesa.agregar(this);
        jugador.agregar(this);
    }

    private void inicializarVista() {
        vista.cargarDatos(modelo, jugador);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.UsuarioAbandonaMesa.equals(evento)) {
            vista.cerrarVentana();
        }
        if (Eventos.Pagar.equals(evento)) {
            vista.ocultarNumeroGanador();
            vista.actualizarEstadisticaYronda(modelo);
            vista.actualizarBalanceJugador(jugador);
            vista.reactivarApuestasYAbandono(modelo.getMensaje());
        }
        if (Eventos.Lanzar.equals(evento)) {
            vista.mostrarNumeroGanador(modelo.getEstadistica().getNumerosSorteados().get(0));
            vista.bloqueoApuestasYAbandono(modelo.getMensaje());
        }
        if (Eventos.ApuestaRealizada.equals(evento) || Eventos.ActualizacionSaldo.equals(evento)) {
            vista.apuestaRealizada(jugador);
        }
        if (Eventos.MesaPorCerrar.equals(evento)) {
            vista.avisarMesaEstaPorCerrar(modelo.getMensaje());
        }
        if (Eventos.CierraMesa.equals(evento)) {
            vista.cerrarVentana();
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

    public void apostar(int numeroApostado, int monto) {
        Apuesta apuesta = new Apuesta(jugador, monto, numeroApostado);
        try {
            modelo.getRonda().apostar(apuesta);
            actualizarApuesta(apuesta.getCasillero());
        } catch (ApuestaInvalidaException | MontoInsuficienteException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

    private void actualizarApuesta(int casillero) {
        int monto = 0;
        Collection<ArrayList<Apuesta>> apuestas = modelo.getRonda().getApuestas().values();
        for (ArrayList<Apuesta> listaApuestas : apuestas) {
            for (Apuesta apuesta : listaApuestas) {
                if (apuesta.getCasillero() == casillero && apuesta.getJugador().equals(jugador)) {
                    monto += apuesta.getMontoApostado();
                }
            }
        }
        vista.aceptarApuesta(monto, casillero);
    }
}
