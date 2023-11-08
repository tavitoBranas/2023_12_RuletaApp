package Controlador;

import Dominio.Efecto;
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
        vista.cargarDatosMesa(modelo);
        vista.cargarDatosJugadores(modelo.getListaJugadores());
        vista.cargarEfectos(Fachada.getInstancia().efectosDisponibles());
    }

    public void cerrarMesa() {
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

    }

    public void lanzar(String efectoSeleccionado, ArrayList<Integer> casillerosSeleccionados) {
        Efecto efecto = buscarEfecto(efectoSeleccionado);
        Ronda nuevaRonda = new Ronda(efecto, casillerosSeleccionados, modelo);
        modelo.setRonda(nuevaRonda);
        efecto.setRonda(nuevaRonda);
        modelo.lanzar();
        modelo.numeroGanador();
        nuevaRonda.getEfecto().getCasillerosGanadores();
        System.out.println(modelo.getEstadistica().getUltimosTresNumerosSorteados());
        System.out.println(modelo.getEstadistica().getHistoricoNegro());
        System.out.println(modelo.getEstadistica().getHistoricoRojo());
        System.out.println(modelo.getEstadistica().getHistoricoPrimeraDocena());
        System.out.println(modelo.getEstadistica().getHistoricoSegundaDocena());
        System.out.println(modelo.getEstadistica().getHistoricoTerceraDocena());

    }

    private Efecto buscarEfecto(String efectoSeleccionado) {
        return Fachada.getInstancia().buscarEfecto(efectoSeleccionado);
    }

}
