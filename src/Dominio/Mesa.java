package Dominio;

import Excepciones.MesaAbandonoException;
import Excepciones.MesaEstadoException;
import Excepciones.MesaNoDisponibleException;
import Excepciones.UsuarioEnMesaException;
import comun.Observable;
import java.util.ArrayList;

public class Mesa extends Observable {

    private String nombre;
    private ArrayList<TipoApuesta> tipoApuesta;
    private ArrayList<Jugador> listaJugadores;
    private Ronda ronda;
    private Estadistica estadistica;
    private Crupier crupier;
    private String mensaje;
    private EstadoMesa estado;
    //private PanelRuleta panel;

    public Mesa(String nombre, ArrayList<TipoApuesta> tipo, Crupier crupier) {
        this.nombre = nombre;
        tipoApuesta = tipo;
        this.crupier = crupier;
        ronda = new Ronda(this);
        listaJugadores = new ArrayList<Jugador>();
        this.mensaje = "";
        estadistica = new Estadistica(this);
        estado = new EstadoMesaAbiertaPagar(this);

    }

    /*
    public PanelRuleta getPanel() {
        return panel;
    }

    public void setPanel(PanelRuleta panel) {
        this.panel = panel;
    }
     */
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

    public void setEstado(EstadoMesa estado) throws MesaEstadoException {
        //evaluo si la  mesa puede cerrarse
        habilitadoCierreDeMesa(estado);
        this.estado = estado;
        if (estado instanceof EstadoMesaAbiertaPagar) {
            pagar();
        }
        if (estado instanceof EstadoMesaLanzar) {
            lanzar();
        }

    }

    public Mesa ingresarAmesa(Jugador jugador) throws UsuarioEnMesaException, MesaNoDisponibleException {
        habilitadoIngreso();
        for (Jugador jugadorEnLista : listaJugadores) {
            if (jugadorEnLista.equals(jugador)) {
                throw new UsuarioEnMesaException("El jugador ya participa de esta mesa");
            }
        }
        listaJugadores.add(jugador);
        avisar(Eventos.UsuarioAgregado);
        return this;
    }

    public void desloguearJugadordeMesa(Jugador jugador) throws MesaAbandonoException {
        habilitadoAvandono();
        listaJugadores.remove(jugador);
        avisar(Eventos.UsuarioAbandonaMesa);
    }

    public void expulsarJugadores() {
        listaJugadores.clear();
        avisar(Eventos.CierraMesa);
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void lanzar() {
        estado.accionar(this);
        avisar(Eventos.Lanzar);
    }

    private void pagar() {
        estado.accionar(this);
        avisar(Eventos.Pagar);
    }

    public void setRonda(Ronda nuevaRonda) {
        this.ronda = nuevaRonda;
    }

    public Ronda getRonda() {
        return ronda;
    }

    private void habilitadoIngreso() throws MesaNoDisponibleException {
        if (this.estado instanceof EstadoMesaLanzar) {
            throw new MesaNoDisponibleException("Esta mesa se encuentra pagando. Intente nuevamente en unos segundos");
        }
        if (this.estado instanceof EstadoMesaCerrar) {
            throw new MesaNoDisponibleException("Esta mesa esta cerrando. No es posible su acceso");
        }
    }

    private void habilitadoAvandono() throws MesaAbandonoException {
        if (this.estado instanceof EstadoMesaLanzar) {
            throw new MesaAbandonoException("No se puede avandonar mesa. La misma esta pagando");
        }
        if (this.estado instanceof EstadoMesaCerrar) {
            throw new MesaAbandonoException("No se puede avandonar mesa. La misma esta pagando");
        }
    }

    private void habilitadoCierreDeMesa(EstadoMesa estado) throws MesaEstadoException {
        if (this.estado instanceof EstadoMesaAbiertaPagar
                && estado instanceof EstadoMesaCerrar) {
            throw new MesaEstadoException("No se puede cerrar la mesa. Para ello la misma debe de estar "
                    + "bloqueada");
        }
    }

}
