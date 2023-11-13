package Controlador;

import Dominio.Apuesta;
import Dominio.Eventos;
import Dominio.Jugador;
import Dominio.Mesa;
import Excepciones.ApuestaInvalidaException;
import Excepciones.MesaAbandonoException;
import Excepciones.MontoInsuficienteException;
import Logica.Fachada;
import comun.Observable;
import comun.Observador;
import UI.Interface.JugarVista;
import java.util.ArrayList;
import java.util.Collection;

public class JugarVistaControlador implements Observador {

    private final JugarVista vista;
    private final Jugador jugador;
    private final Mesa modelo;

    public Fachada fachada;

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
            ocultarNumeroGanador();
            actualizarEstadisticaYronda(modelo);
            actualizarBalanceJugador(jugador);
            reactivarApuestasYAbandono();
        }
        if (Eventos.Lanzar.equals(evento)) {
            numeroGanador(modelo.getEstadistica().getNumerosSorteados().get(0));
            bloqueoApuestasYAbandono();
        }
        if (Eventos.ApuestaRealizada.equals(evento) || Eventos.ActualizacionSaldo.equals(evento)) {
            apuestaRealizada(jugador);
        }
        if (Eventos.MesaPorCerrar.equals(evento)) {
            avisarMesaEstaPorCerrar();
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

    public void apostar(int numeroApostado, int monto) {
        Apuesta apuesta = new Apuesta(jugador, monto, numeroApostado);
        try {
            modelo.getRonda().apostar(apuesta);
            actualizarApuesta(apuesta.getCasillero());
        } catch (ApuestaInvalidaException | MontoInsuficienteException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

    /*public void eliminar() {
        ArrayList<Apuesta> color = new ArrayList<>();
        color.add(new Apuesta(jugador, 100, 43));
        color.add(new Apuesta(jugador, 100, 44));
        modelo.getEstadistica().getNumerosSorteados().add(0);

        jugador.setUltimasApuestas(color);
    }*/
    private void apuestaRealizada(Jugador jugador) {
        vista.apuestaRealizada(jugador);
    }

    private void actualizarBalanceJugador(Jugador jugador) {
        vista.actualizarBalanceJugador(jugador);
    }

    private void avisarMesaEstaPorCerrar() {
        vista.avisarMesaEstaPorCerrar(modelo.getMensaje());
    }

    public void montoAapostar(int apuesta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void casillero(int universalCellCode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
