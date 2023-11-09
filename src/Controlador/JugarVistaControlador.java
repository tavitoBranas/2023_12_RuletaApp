package Controlador;

import Dominio.Estadistica;
import Dominio.Eventos;
import Dominio.Jugador;
import Dominio.Mesa;
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
            vista.cargarMensaje(modelo);
        }
        if (Eventos.UsuarioAbandonaMesa.equals(evento)) {
            vista.cerrarVentana();
        }
        if (Eventos.NumeroGanador.equals(evento)) {
            numeroGanador(modelo.getEstadistica().getNumerosSorteados().get(0));
        }
        if (Eventos.Pagar.equals(evento)) {
            ocultarNumeroGanador();
            actualizarNumerosYronda(modelo.getEstadistica());
        }
    }

    public void abandonarMesa() {
        modelo.desloguearJugadordeMesa(this.jugador);
        vista.cerrarVentana();
    }

    public void mensajeAceptado() {
        //aca ver que se espera antes de ejecutar 
        //que este todo pronto para cerrar digamos
        vista.cerrarVentana();
    }

    public void numeroGanador(int numero) {
        vista.mostrarNumeroGanador(numero);
    }

    private void ocultarNumeroGanador() {
        vista.ocultarNumeroGanador();
    }

    private void actualizarNumerosYronda(Estadistica estadistica) {
        vista.actualizarNumerosYronda(estadistica);
    }
}
