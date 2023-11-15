package Dominio;

import Excepciones.ApuestaInvalidaException;
import Excepciones.EfectoException;
import Excepciones.MesaAbandonoException;
import Excepciones.MesaEstadoException;
import Excepciones.MesaNoDisponibleException;
import Excepciones.UsuarioEnMesaException;
import comun.Observable;
import comun.Observador;
import java.util.ArrayList;

public class Mesa extends Observable implements Observador {

    private String nombre;
    private ArrayList<TipoApuesta> tipoApuesta;
    private ArrayList<Jugador> listaJugadores;
    private Ronda rondaActiva;
    private final Estadistica estadistica;
    private final Crupier crupier;
    private String mensaje;
    private EstadoMesa estado;

    public Mesa(String nombre, ArrayList<TipoApuesta> tipo, Crupier crupier) {
        this.nombre = nombre;
        tipoApuesta = tipo;
        this.crupier = crupier;
        rondaActiva = new Ronda(this);
        listaJugadores = new ArrayList<>();
        this.mensaje = "";
        estadistica = new Estadistica(this);
        estado = new EstadoMesaAbierta(this);
        obligatoriedadApuestaDirecta();
    }

    private void obligatoriedadApuestaDirecta() {
        ApuestaDirecta apuestaDirecta = new ApuestaDirecta(36);
        if (!tipoApuesta.contains(apuestaDirecta)) {
            tipoApuesta.add(apuestaDirecta);
        }
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

    public void setRonda(Ronda nuevaRonda) {
        this.rondaActiva = nuevaRonda;
    }

    public Ronda getRonda() {
        return rondaActiva;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    private void habilitadoAvandono(Jugador jugador) throws MesaAbandonoException {
        estado.habilitadoAvandono();
        rondaActiva.habilitadoAbandono(jugador);
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }

    public void pagar() throws MesaEstadoException {
        estado.pagar();
    }

    public void lanzar() throws EfectoException, MesaEstadoException {
        estado.lanzar();
    }

    public void cerrar() throws MesaEstadoException {
        estado.cerrar();
    }

    public Mesa ingresarAmesa(Jugador jugador) throws UsuarioEnMesaException, MesaNoDisponibleException {
        estado.habilitadoIngreso();
        for (Jugador jugadorEnLista : listaJugadores) {
            if (jugadorEnLista.equals(jugador)) {
                throw new UsuarioEnMesaException("El jugador ya participa de esta mesa");
            }
        }
        listaJugadores.add(jugador);
        jugador.agregarMesa(this);
        jugador.agregar(this);
        avisar(Eventos.UsuarioAgregado);
        return this;
    }

    public void desloguearJugadordeMesa(Jugador jugador) throws MesaAbandonoException {
        habilitadoAvandono(jugador);
        listaJugadores.remove(jugador);
        jugador.remover(this);
        jugador.eliminarMesa(this);
        avisar(Eventos.UsuarioAbandonaMesa);
    }

    public void expulsarJugadores() {
        for (Jugador j : listaJugadores) {
            j.eliminarMesa(this);
            j.remover(this);
        }
        listaJugadores.clear();
    }

    public void validarApuesta(Apuesta apuesta) throws ApuestaInvalidaException {
        
        //valido que el casillero sea aceptado para apostar
        casilleroAptoParaApostar(apuesta.getCasillero());
        //valido condiciones del tipo de apuesta
        tipoApuestaAdmiteCasillero(apuesta);
    }

    private void casilleroAptoParaApostar(int casillero) throws ApuestaInvalidaException {
        if (!tipoApuesta.stream().anyMatch(ap -> ap instanceof ApuestaDirecta)
                && ListaUniversalCasilleros.apuestaInvolucraDirecta(casillero)) {
            throw new ApuestaInvalidaException("La apuesta no fue aceptada: la apuesta directa no esta disponible");
        }
        if (!tipoApuesta.stream().anyMatch(ap -> ap instanceof ApuestaColor)
                && ListaUniversalCasilleros.apuestaInvolucraColor(casillero)) {
            throw new ApuestaInvalidaException("La apuesta no fue aceptada: el casillero color no esta disponible");
        }
        if (!tipoApuesta.stream().anyMatch(ap -> ap instanceof ApuestaDocena)
                && ListaUniversalCasilleros.apuestaInvolucraDocena(casillero)) {
            throw new ApuestaInvalidaException("La apuesta no fue aceptada: el casillero docena no esta disponible");
        }
    }

    private void tipoApuestaAdmiteCasillero(Apuesta apuesta) throws ApuestaInvalidaException {
        for (TipoApuesta tipo : tipoApuesta) {
            if (tipo instanceof ApuestaColor && ListaUniversalCasilleros.apuestaInvolucraColor(apuesta.getCasillero())) {
                //valido condiciones de apuesta a color
                tipo.validacionConUltimaJugada(apuesta, estadistica);
            }
            if (tipo instanceof ApuestaDocena
                    && ListaUniversalCasilleros.apuestaInvolucraDocena(apuesta.getCasillero())) {
                //valido condiciones de apuesta a docena
                tipo.validacionCantidadApuestasDocena(apuesta, rondaActiva);
            }
        }
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.ApuestaRealizada.equals(evento)) {
            avisar(Eventos.ApuestaRealizada);
        }
        if (Eventos.ActualizacionSaldo.equals(evento)) {
            avisar(Eventos.ActualizacionSaldo);
        }
    }
}
