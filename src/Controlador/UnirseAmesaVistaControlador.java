package Controlador;

import Dominio.Eventos;
import Dominio.Jugador;
import Dominio.Mesa;
import Excepciones.MesaException;
import Logica.Fachada;
import UI.Dialogo_Jugar;
import UI.Dialogo_UnirseAmesaJugador;
import UI.Interface.UnirseMesaVista;
import comun.Observable;
import comun.Observador;
import java.util.ArrayList;

public class UnirseAmesaVistaControlador implements Observador {

    //private Mesa modelo;
    private UnirseMesaVista vistaMesa;
    private Fachada fachada;
    private Jugador jugador;

    public UnirseAmesaVistaControlador(UnirseMesaVista vista, Jugador jugador/*, Mesa modelo*/) {
        vistaMesa = vista;
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
        if (Eventos.MesaAgregada.equals(evento)) {
            vistaMesa.mostrarMesasAbiertas(fachada.mesasDisponibles());
        }
    }

    private void inicializarVista() {
        vistaMesa.mostrarMesasAbiertas(fachada.mesasDisponibles());
        vistaMesa.datosJugador(jugador);
    }
    
    public void unirseAmesa(String mesa){
        try{
            Mesa retornoMesa = null;
            ArrayList<Mesa> mesas = fachada.mesasDisponibles();
            for(int i=0; i<mesas.size() && retornoMesa == null; i++){
                if(mesas.get(i).getNombre().equals(mesa)){
                    retornoMesa = mesas.get(i);
                }
            }
            fachada.unirseAmesa(jugador, retornoMesa);
            Dialogo_Jugar jugarAmesa = new Dialogo_Jugar(new javax.swing.JFrame(), true, retornoMesa);
            jugarAmesa.setModal(false);
            jugarAmesa.setVisible(true);
        }catch(MesaException e){
            vistaMesa.mostrarMensajeError(e.getMessage());
        }
    }
}
