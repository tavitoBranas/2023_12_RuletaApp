package Controlador;

import Dominio.*;
import Excepciones.EfectoException;
import Excepciones.MesaEstadoException;
import Logica.Fachada;
import UI.Interface.OperarMesaVista;
import comun.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperarMesaVistaControlador implements Observador {

    private final OperarMesaVista vista;
    private final Mesa modelo;

    public OperarMesaVistaControlador(OperarMesaVista vista, Mesa mesa) {
        this.vista = vista;
        this.modelo = mesa;
        inicializarVista();
        modelo.agregar(this);
        Fachada.getInstancia().agregar(this);
    }

    private void inicializarVista() {
        estadoBotonLanzar(true);
        habilitarCerrarMesa(false);
        vista.cargarDatosMesa(modelo);
        vista.cargarDatosJugadores(modelo.getListaJugadores());
        vista.cargarEfectos(Fachada.getInstancia().efectosDisponibles());
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.UsuarioAgregado.equals(evento) || Eventos.UsuarioAbandonaMesa.equals(evento)
                || Eventos.UsuarioDeslogueado.equals(evento)) {
            vista.cargarDatosJugadores(modelo.getListaJugadores());
        }
        if (Eventos.Lanzar.equals(evento)) {
            vista.mostrarNumeroGanador(modelo.getEstadistica().getNumerosSorteados().get(0));
        }
        if (Eventos.Pagar.equals(evento)) {
            vista.actualizarEstadisticaYronda(modelo);
            vista.resetearApuestasMonto();
        }
        if (Eventos.ActualizacionSaldo.equals(evento)) {
            vista.apuestaRealizada(modelo);
        }
        if (Eventos.ApuestaRealizada.equals(evento)) {
            vista.apuestaRealizada(modelo);
            vista.mostrarApuesta(mostrarApuestas());
        }
    }

    public void lanzar(String efectoSeleccionado) {
        //obtengo efecto, lo asocio a la ronda y lanzo
        Efecto efecto = buscarEfecto(efectoSeleccionado);
        modelo.getRonda().setEfecto(efecto);
        modelo.getRonda().setCasillerosSeleccionados();
        try {
            modelo.lanzar();
            estadoBotonLanzar(false);
            habilitarCerrarMesa(true);
        } catch (EfectoException | MesaEstadoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

    public void pagar() {
        try {
            modelo.pagar();
            vista.ocultarNumeroGanador();
            vista.actualizarEstadisticaYronda(modelo);
            estadoBotonLanzar(true);
            habilitarCerrarMesa(false);
        } catch (MesaEstadoException ex) {
           vista.mostrarMensajeError(ex.getMessage());
        }
    }

    public void cerrarMesa() {
        try {
            modelo.cerrar();
            vista.cerrarVentana();
        } catch (MesaEstadoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

    private void estadoBotonLanzar(boolean estado) {
        vista.estadoBotonLanzar(estado);
    }

    private void habilitarCerrarMesa(boolean b) {
        vista.habilitarCerrarMesa(b);
    }

    private Efecto buscarEfecto(String efectoSeleccionado) {
        return Fachada.getInstancia().buscarEfecto(efectoSeleccionado);
    }

    private Map<Integer, Integer> mostrarApuestas() {
        Map<Integer, Integer> resumenApuestas = new HashMap<>();
        ArrayList<Integer> universalCellCodes = ListaUniversalCasilleros.casillerosDisponibles();
        Collection<ArrayList<Apuesta>> apuestas = modelo.getRonda().getApuestas().values();
        for (Integer code : universalCellCodes) {
            int monto = 0;
            for (ArrayList<Apuesta> listaApuestas : apuestas) {
                for (Apuesta apuesta : listaApuestas) {
                    if (apuesta.getCasillero() == code) {
                        monto += apuesta.getMontoApostado();
                    }
                }
            }
            resumenApuestas.put(code, monto);
        }
        return resumenApuestas;
    }
}
