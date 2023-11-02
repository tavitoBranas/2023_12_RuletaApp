package Controlador;

import Dominio.Eventos;
import Dominio.Mesa;
import Logica.Fachada;
import UI.Interface.Jugar;
import comun.Observable;
import comun.Observador;

public class JugarVistaControlador implements Observador {

    public Jugar vista;
    public Mesa modelo;
    public Fachada fachada;

    public JugarVistaControlador(Jugar vistaJugar, Mesa mesa) {
        this.vista = vistaJugar;
        this.modelo = mesa;

        fachada = Fachada.getInstancia();
        //fachada.agregar(this);
        //controlador se subscribe a los eventos de la fachada: fachada es observable y controlador observador
        inicializarVista();
    }

    private void inicializarVista() {
        // vista.mostrarJugadores(fachada);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.UnirseAmesa.equals(evento)) {
            // vista.mostrarJugadores(fachada.mesasDisponibles());
        }
    }

    public void abandonarMesa(Mesa mesa) {
    }
}
