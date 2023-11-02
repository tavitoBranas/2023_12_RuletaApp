package Logica;

import Dominio.*;
import comun.Observable;
import java.util.ArrayList;

public class ServicioMesa extends Observable {

    private static ServicioMesa instancia;
    private ArrayList<Mesa> listaMesas;
    private ArrayList<TipoApuesta> tiposDeApuesta ;

    public synchronized static ServicioMesa getInstancia() {
        if (instancia == null) {
            instancia = new ServicioMesa();
        }
        return instancia;
    }

    private ServicioMesa() {
        listaMesas = new ArrayList<Mesa>();
        tiposDeApuesta = new ArrayList<TipoApuesta>();
    }

    public ArrayList<Mesa> mesasDisponibles() {
        return listaMesas;
    }

    public void agregarMesa(Mesa mesa) {
        listaMesas.add(mesa);
        avisar(Eventos.MesaAgregada);
    }

    public void eliminarMesa(Mesa mesa) {
        listaMesas.remove(mesa);
    }

    public ArrayList<TipoApuesta> tiposApuestaDisponibles() {
        return tiposDeApuesta;
    }

    public void agregarTipoApuesta(TipoApuesta tipo) {
        tiposDeApuesta.add(tipo);
    }

    public void eliminarTipoApuesta(TipoApuesta tipo) {
        tiposDeApuesta.remove(tipo);
    }

}
