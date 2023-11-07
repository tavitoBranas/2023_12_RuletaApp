package Controlador;

import Dominio.Eventos;
import Dominio.Jugador;
import Dominio.Mesa;
import Excepciones.MesaException;
import Excepciones.UsuarioEnMesaException;
import Logica.Fachada;
import UI.Dialogo_Jugar;
import UI.Dialogo_UnirseAmesaJugador;
import UI.Interface.UnirseMesaVista;
import comun.Observable;
import comun.Observador;
import java.util.ArrayList;

public class UnirseAmesaVistaControlador implements Observador {

    //private Mesa modelo;
    private UnirseMesaVista vista;
    private Fachada fachada;
    private Jugador jugador;
    
    public UnirseAmesaVistaControlador(UnirseMesaVista vista, Jugador jugador) {
        this.vista = vista;
        this.jugador = jugador;
        //this.modelo = modelo; ES LA FACHADA
        fachada = Fachada.getInstancia();
        fachada.agregar(this);
        //controlador se subscribe a los eventos de la fachada: fachada es observable y controlador observador
        inicializarVista();
    }

    //unirseAmesa.mostrarMesasAbiertas();
    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.MesaAgregada.equals(evento) || Eventos.MesaEliminada.equals(evento) ) {
            vista.mostrarMesasAbiertas(fachada.mesasDisponibles());
        }
    }
    
    private void inicializarVista() {
        ArrayList<Mesa> mesasDisponibles = fachada.mesasDisponibles();
        vista.mostrarMesasAbiertas(mesasDisponibles);
        vista.datosJugador(jugador);
    }
    
    public void unirseAmesa(String mesa) {
        try {
            //SI NO EXISTE LA MESA QUE PASA? NO HAY LANZAMIENTO DE EXCEPCIONES
            Mesa retornoMesa = fachada.traerMesa(mesa);
            retornoMesa.ingresarAmesa(jugador);
            vista.ejecutarCasoDeUsoJugar(retornoMesa, jugador);
        } catch (UsuarioEnMesaException e) {
            vista.mostrarMensajeError(e.getMessage());
        }
    }

    public void desloguear() {
        
        //analizar cuando un usuario se deloguea que pasa de las mesas en las que esta
        fachada.desloguearUsuarioJugador(this.jugador);
        vista.cerrarVentana();
    }
}
