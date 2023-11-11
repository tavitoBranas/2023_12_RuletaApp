package Controlador;

import Dominio.Efecto;
import Dominio.EstadoMesaAbiertaPagar;
import Dominio.EstadoMesaCerrar;
import Dominio.EstadoMesaLanzar;
import Dominio.Eventos;
import Dominio.Mesa;
import Excepciones.MesaEstadoException;
import Logica.Fachada;
import UI.Interface.OperarMesaVista;
import comun.Observable;
import comun.Observador;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperarMesaVistaControlador implements Observador {

    private OperarMesaVista vista;
    private Mesa modelo;

    public OperarMesaVistaControlador(OperarMesaVista vista, Mesa mesa) {
        this.vista = vista;
        this.modelo = mesa;
        inicializarVista();
        modelo.agregar(this);
        Fachada.getInstancia().agregar(this);
    }

    private void inicializarVista() {
        estadoBotonLanzar(true);
        vista.cargarDatosMesa(modelo);
        vista.cargarDatosJugadores(modelo.getListaJugadores());
        vista.cargarEfectos(Fachada.getInstancia().efectosDisponibles());
        habilitarCerrarMesa(false);
    }

    public void cerrarMesa() {
        
        try {
            modelo.setEstado(new EstadoMesaCerrar(modelo));
        } catch (MesaEstadoException ex) {
           vista.mostrarMensajeError(ex.getMessage());
        }
        modelo.setMensaje("La mesa se va a cerrar");

        cerrarMesaExpulsarUsuarios();
        eliminarMesaDeDisponibles();
        Fachada.getInstancia().desloguearUsuarioCrupier(modelo.getCrupier());
        Fachada.getInstancia().eliminarMesa(modelo);
        cerrarVentana();
    }

    private void eliminarMesaDeDisponibles() {
        Fachada.getInstancia().eliminarMesa(modelo);
    }

    private void cerrarMesaExpulsarUsuarios() {
        modelo.expulsarJugadores();
    }

    protected void cerrarVentana() {
        vista.cerrarVentana();
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.UsuarioAgregado.equals(evento) || Eventos.UsuarioAbandonaMesa.equals(evento)
                || Eventos.UsuarioDeslogueado.equals(evento)) {
            vista.cargarDatosJugadores(modelo.getListaJugadores());
        }
        if (Eventos.Lanzar.equals(evento)) {
            mostrarNumeroGanador(modelo.getEstadistica().getNumerosSorteados().get(0));
            //habilitarCerrarMesa(true);
        }
        if (Eventos.Pagar.equals(evento)) {
           // actualizarNumerosYronda();
            //habilitarCerrarMesa(false);
        }
        if(Eventos.ApuestaRealizada.equals(evento)){
            vista.apuestaRealizada(modelo);
        }

    }

    public void lanzar(String efectoSeleccionado, ArrayList<Integer> casillerosSeleccionados) {
        //obtengo efecto, lo asocio a la ronda y lanzo
        Efecto efecto = buscarEfecto(efectoSeleccionado);
        modelo.getRonda().setEfecto(efecto);
        modelo.getRonda().setCasillerosSeleccionados(casillerosSeleccionados);

        try {
            //seteo el estado de la mesa, no permite que nadie ingrese o salga o apueste
            modelo.setEstado(new EstadoMesaLanzar());
        } catch (MesaEstadoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
        estadoBotonLanzar(false);
        habilitarCerrarMesa(true);
    }

    private Efecto buscarEfecto(String efectoSeleccionado) {
        return Fachada.getInstancia().buscarEfecto(efectoSeleccionado);
    }

    public void pagar() {
        try {
            modelo.setEstado(new EstadoMesaAbiertaPagar(modelo));
        } catch (MesaEstadoException ex) {
           vista.mostrarMensajeError(ex.getMessage());
        }
        ocultarNumeroGanador();
        actualizarNumerosYronda();
        estadoBotonLanzar(true);
        habilitarCerrarMesa(false);
    }

    private void mostrarNumeroGanador(int numeroGanador) {
        vista.mostrarNumeroGanador(numeroGanador);
    }

    private void ocultarNumeroGanador() {
        vista.ocultarNumeroGanador();
    }

    private void actualizarNumerosYronda() {
        vista.actualizarEstadisticaYronda(modelo);
    }

    private void estadoBotonLanzar(boolean estado) {
        vista.estadoBotonLanzar(estado);
    }

    private void habilitarCerrarMesa(boolean b) {
        vista.habilitarCerrarMesa(b);
    }
}
