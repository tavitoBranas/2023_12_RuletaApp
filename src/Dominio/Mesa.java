package Dominio;

import Excepciones.UsuarioEnMesaException;
import Logica.Fachada;
import comun.Observable;
import comun.Observador;
import java.util.ArrayList;

public class Mesa extends Observable implements Observador {

    private String nombre;
    private ArrayList<TipoApuesta> tipoApuesta;
    private ArrayList<Jugador> listaJugadores;
    private Ronda ronda;
    private Estadistica estadistica;
    private Crupier crupier;
    private String mensaje;
    private EstadoMesa estado;

    public Mesa(String nombre, ArrayList<TipoApuesta> tipo, Crupier crupier) {
        this.nombre = nombre;
        tipoApuesta = tipo;
        this.crupier = crupier;
        ronda = new Ronda(this);
        listaJugadores = new ArrayList<Jugador>();
        this.mensaje = "";
        estadistica = new Estadistica();
        estadistica.agregar(this);
        estado = new EstadoMesaAbierta();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<TipoApuesta> getTipoApuesta() {
        return tipoApuesta;
    }

    public void setTipoApuesta(ArrayList<TipoApuesta> tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }

    public Crupier getCrupier() {
        return crupier;
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
        if(estado instanceof EstadoMesaAbierta){
            avisar(Eventos.Pagar);
        }
    }

    public Mesa ingresarAmesa(Jugador jugador) throws UsuarioEnMesaException {
        for (Jugador jugadorEnLista : listaJugadores) {
            if (jugadorEnLista.equals(jugador)) {
                throw new UsuarioEnMesaException("El jugador ya participa de esta mesa");
            }
        }
        listaJugadores.add(jugador);
        avisar(Eventos.UsuarioAgregado);
        return this;
    }

    public void desloguearJugadordeMesa(Jugador jugador) {
        listaJugadores.remove(jugador);
        avisar(Eventos.UsuarioAbandonaMesa);
    }

    public void expulsarJugadores() {
        listaJugadores.clear();
        avisar(Eventos.CierraMesa);
    }

    public void apuestaDirectaObligatoria() {
        boolean poseeApuestaDirecta = false;
        TipoApuesta directa = null;
        ArrayList<TipoApuesta> tipoApuestaDisponibles = Fachada.getInstancia().tipoApuestaDisponibles();

        //busco en la lista generada por el controlador si existe la directa 
        for (int i = 0; i < this.getTipoApuesta().size() && !poseeApuestaDirecta; i++) {
            //comparo con la lista de tipo de apuesta disponibles
            for (int j = 0; j < tipoApuestaDisponibles.size() && !poseeApuestaDirecta; j++) {
                if (tipoApuestaDisponibles.get(j).getTipo().equals("Apuesta Directa")) {
                    if (this.getTipoApuesta().get(i).equals(tipoApuestaDisponibles.get(j))) {
                        poseeApuestaDirecta = true;
                    }
                    directa = tipoApuestaDisponibles.get(j);
                }
            }
        }
        if (!poseeApuestaDirecta) {
            this.getTipoApuesta().add(directa);
        }
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public int numeroGanador() {
        int i = -1;
        if (!estadistica.getNumerosSorteados().isEmpty()) {
            i = estadistica.getNumerosSorteados().get(0);
        }
        return i;
    }

    public void lanzar() {
        ronda.lanzar();
    }

    public void setRonda(Ronda nuevaRonda) {
        this.ronda = nuevaRonda;
    }

    public Ronda getRonda() {
        return ronda;
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.NumeroGanador.equals(evento)) {
            avisar(Eventos.NumeroGanador);
        }
    }

}
