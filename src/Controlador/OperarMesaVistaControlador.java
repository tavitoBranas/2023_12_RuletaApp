package Controlador;

import Dominio.Efecto;
import Dominio.EstadoMesaAbierta;
import Dominio.EstadoMesaCerrar;
import Dominio.EstadoMesaLanzar;
import Dominio.Eventos;
import Dominio.Mesa;
import Dominio.Ronda;
import Logica.Fachada;
import UI.Interface.OperarMesaVista;
import comun.Observable;
import comun.Observador;
import java.util.ArrayList;

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
    }

    public void cerrarMesa() {
        modelo.setEstado(new EstadoMesaCerrar(modelo));
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
        if (Eventos.NumeroGanador.equals(evento)) {
            mostrarNumeroGanador(modelo.getEstadistica().getNumerosSorteados().get(0));
        }

    }

    public void lanzar(String efectoSeleccionado, ArrayList<Integer> casillerosSeleccionados) {
        //seteo el estado de la mesa, no permite que nadie ingrese o salga o apueste
        modelo.setEstado(new EstadoMesaLanzar());
        //obtengo efecto, lo asocio a la ronda y lanzo
        Efecto efecto = buscarEfecto(efectoSeleccionado);
        modelo.getRonda().setEfecto(efecto);
        modelo.getRonda().setCasillerosSeleccionados(casillerosSeleccionados);
        modelo.lanzar();
        estadoBotonLanzar(false);
    }

    private Efecto buscarEfecto(String efectoSeleccionado) {
        return Fachada.getInstancia().buscarEfecto(efectoSeleccionado);
    }

    public void pagar() {
        generacionNuevaRonda();
        modelo.setEstado(new EstadoMesaAbierta(modelo));
        ocultarNumeroGanador();
        actualizarNumerosYronda();
        estadoBotonLanzar(true);
    }

    private void generacionNuevaRonda() {
        new Ronda(modelo);
    }

    private void mostrarNumeroGanador(int numeroGanador) {
        vista.mostrarNumeroGanador(numeroGanador);
    }

    private void ocultarNumeroGanador() {
        vista.ocultarNumeroGanador();
    }

    private void actualizarNumerosYronda() {
        vista.actualizarNumerosYronda(modelo.getEstadistica());
    }

    private void estadoBotonLanzar(boolean estado) {
        vista.estadoBotonLanzar(estado);
    }
}
