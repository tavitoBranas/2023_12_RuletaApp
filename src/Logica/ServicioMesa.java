package Logica;

import Dominio.*;
import Excepciones.UsuarioEnMesaException;
import comun.Observable;
import java.util.ArrayList;

public class ServicioMesa extends Observable {

    private static ServicioMesa instancia;
    private ArrayList<Mesa> listaMesas;
    private ArrayList<TipoApuesta> tiposDeApuesta;
    private ArrayList<Efecto> efectosDisponibles;

    public synchronized static ServicioMesa getInstancia() {
        if (instancia == null) {
            instancia = new ServicioMesa();
        }
        return instancia;
    }

    private ServicioMesa() {
        listaMesas = new ArrayList<>();
        tiposDeApuesta = new ArrayList<>();
        efectosDisponibles = new ArrayList<>();
    }

    public ArrayList<TipoApuesta> getTiposDeApuesta() {
        return tiposDeApuesta;
    }

    public ArrayList<Efecto> getEfectosDisponibles() {
        return efectosDisponibles;
    }
    
    public void agregarEfecto(Efecto efecto){
        efectosDisponibles.add(efecto);
    }
    
    public ArrayList<Mesa> mesasDisponibles() {
        return listaMesas;
    }

    public void agregarMesa(Mesa mesa) {
        //martillo la directa porque me lo piden
        mesa.apuestaDirectaObligatoria();
        listaMesas.add(mesa);
        avisar(Eventos.MesaAgregada);
    }

    public void eliminarMesa(Mesa mesa) {
        avisar(Eventos.MesaEliminada);
       listaMesas.remove(mesa);
    }

    public ArrayList<TipoApuesta> tiposApuestaDisponibles() {
        return getTiposDeApuesta();
    }

    public void agregarTipoApuesta(TipoApuesta tipo) {
        getTiposDeApuesta().add(tipo);
    }

    public void eliminarTipoApuesta(TipoApuesta tipo) {
        getTiposDeApuesta().remove(tipo);
    }

    public Mesa unirseAmesa(Jugador jugador, String mesa) throws UsuarioEnMesaException {
        //aca el servicio busca que exista la mesa
        Mesa mesaBuscada = traerMesa(mesa);
        //trae la mesa y le otorga la responsabilidad a la mesa a que agregue el jugador
        return mesaBuscada.ingresarAmesa(jugador);
    }

    public Mesa traerMesa(String mesa) {
        Mesa mesaRetorno = null;
        for (int i = 0; i < listaMesas.size() && mesaRetorno == null; i++) {
            if (listaMesas.get(i).getNombre().equals(mesa)) {
                mesaRetorno = listaMesas.get(i);
            }
        }
        return mesaRetorno;
    }

    void desloguearJugadordeMesas(Jugador jugador) {
        //aca el usuario se va de la aplicacion entonces se cierran todas las mesas en las que este
        for(Mesa m: listaMesas){
            if(m.getListaJugadores().stream().anyMatch(lista -> lista.equals(jugador))){
                m.desloguearJugadordeMesa(jugador);
            }
        }
    }
}
