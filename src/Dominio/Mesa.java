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
        listaJugadores = new ArrayList<>();
        this.mensaje = "";
        estadistica = new Estadistica(this);
        estado = new EstadoMesaAbiertaPagar(this);
        obligatoriedadApuestaDirecta();
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
        this.ronda = nuevaRonda;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setEstado(EstadoMesa estado) throws MesaEstadoException, EfectoException {
        //evaluo si la  mesa puede cerrarse

        if (estado instanceof EstadoMesaAbiertaPagar) {
            this.estado = estado;
            pagar();
        }
        if (estado instanceof EstadoMesaLanzar) {

            this.estado = estado;
            lanzar();
        }
        if (estado instanceof EstadoMesaCerrar) {
            habilitadoCierreDeMesa(estado);
            this.estado = estado;
            cerrar();

        }

        //ver cuando se cierre la mesa que se hace
    }

    public Mesa ingresarAmesa(Jugador jugador) throws UsuarioEnMesaException, MesaNoDisponibleException {
        habilitadoIngreso();
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

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void lanzar() throws EfectoException {
        try {
            estado.lanzar(this);
        } catch (EfectoException ex) {
            estado = new EstadoMesaAbiertaPagar(this);
            throw ex;
        }
        avisar(Eventos.Lanzar);
    }

    private void pagar() {
        estado.pagar(this);
        avisar(Eventos.Pagar);
    }

    private void cerrar() {
        estado.cerrar(this);
        avisar(Eventos.CierraMesa);
    }

    private void habilitadoIngreso() throws MesaNoDisponibleException {
        if (this.estado instanceof EstadoMesaLanzar) {
            throw new MesaNoDisponibleException("Esta mesa se encuentra pagando. Intente nuevamente en unos segundos");
        }
        if (this.estado instanceof EstadoMesaCerrar) {
            throw new MesaNoDisponibleException("Esta mesa esta cerrando. No es posible su acceso");
        }
    }

    private void habilitadoAvandono(Jugador jugador) throws MesaAbandonoException {
        if (this.estado instanceof EstadoMesaLanzar) {
            throw new MesaAbandonoException("No se puede avandonar mesa. La misma esta pagando");
        }
        if (this.estado instanceof EstadoMesaCerrar) {
            throw new MesaAbandonoException("No se puede avandonar mesa. La misma esta pagando");
        }
        if (ronda.getApuestas().containsKey(jugador)) {
            throw new MesaAbandonoException("No puede abandonar hasta completar la ronda");
        }
    }

    private void habilitadoCierreDeMesa(EstadoMesa estado) throws MesaEstadoException {
        if (this.estado instanceof EstadoMesaAbiertaPagar
                && estado instanceof EstadoMesaCerrar) {
            throw new MesaEstadoException("No se puede cerrar la mesa. Para ello la misma debe de estar "
                    + "bloqueada");
        }
    }

    void validarApuesta(Apuesta apuesta) throws ApuestaInvalidaException {
        //valido que e; casillero sea aceptado para apostar
        validacionDeCasillero(apuesta.getCasillero());
        //valido que la jugada anterior permita apuesta de color
        if (tipoApuesta.stream().anyMatch(tipo -> tipo instanceof ApuestaColor)
                && ListaUniversalCasilleros.apuestaInvolucraColor(apuesta.getCasillero())) {
            validacionConUltimaJugada(apuesta.getJugador(), apuesta);
        }
        //valido que solo se permita una sola apuesta a docena
        if (tipoApuesta.stream().anyMatch(tipo -> tipo instanceof ApuestaDocena)
                && ListaUniversalCasilleros.apuestaInvolucraDocena(apuesta.getCasillero())) {
            validacionCantidadApuestasDocena(apuesta.getJugador(), apuesta);
        }
    }

    private void validacionDeCasillero(int casillero) throws ApuestaInvalidaException {
        if (!this.tipoApuesta.stream().anyMatch(tipo -> tipo instanceof ApuestaDirecta)) {
            if (ListaUniversalCasilleros.getCasillerosApuestaDirecta().stream().anyMatch(c -> c == casillero)) {
                throw new ApuestaInvalidaException("La apuesta no fue aceptada: la apuesta directa no esta disponible");
            }
        }
        if (!this.tipoApuesta.stream().anyMatch(tipo -> tipo instanceof ApuestaColor)) {
            if (ListaUniversalCasilleros.getCasillerosApuestaColor().stream().anyMatch(c -> c == casillero)) {
                throw new ApuestaInvalidaException("La apuesta no fue aceptada: el casillero color no esta disponible");
            }
        }
        if (!this.tipoApuesta.stream().anyMatch(tipo -> tipo instanceof ApuestaDocena)) {
            if (ListaUniversalCasilleros.getCasillerosApuestaDocena().stream().anyMatch(c -> c == casillero)) {
                throw new ApuestaInvalidaException("La apuesta no fue aceptada: el casillero docena no esta disponible");
            }
        }
    }

    private void validacionCantidadApuestasDocena(Jugador jugador, Apuesta apuesta) throws ApuestaInvalidaException {
        if (ronda.getApuestas().containsKey(jugador)) {
            ArrayList<Apuesta> apuestasJugador = ronda.getApuestas().get(jugador);

            for (int k = 0; k < apuestasJugador.size(); k++) {
                for (int t = 0; t < ListaUniversalCasilleros.getCasillerosApuestaDocena().size(); t++) {
                    if (apuestasJugador.get(k).getCasillero()
                            == ListaUniversalCasilleros.getCasillerosApuestaDocena().get(t)
                            && apuesta.getCasillero() != apuestasJugador.get(k).getCasillero()) {
                        throw new ApuestaInvalidaException("No se puede apostar a mas de una docena por ronda");
                    }
                }
            }
        }

    }

    private void validacionConUltimaJugada(Jugador jugador, Apuesta apuesta) throws ApuestaInvalidaException {
        //averiguo si el jugador aposto a color en la ronda anterior y obtengo los casilleros apostados y su monto
        ArrayList<Apuesta> apuestasAanalizar = jugadorApostoColorEnRondaAnterior(jugador.getUltimasApuestas());

        //consigo el ultimo casillero ganador
        if (!estadistica.getNumerosSorteados().isEmpty()) {
            int ultimoGanador = estadistica.getNumerosSorteados().get(0);
            //analizo restricciones basado en el ultimo ganador
            if (!apuestasAanalizar.isEmpty()) {
                if (ultimoGanador != 0) {
                    int colorBuscado = ListaUniversalCasilleros.colorDelCasillero(ultimoGanador);
                    //el color que se aposto anteriormente no gano?
                    if (apuestasAanalizar.size() == 1 && apuestasAanalizar.get(0).getCasillero() != colorBuscado) {
                        //la apuesta es al mismo color que se aposto anteriormente Y apuesto por un monto mayor
                        if (apuestasAanalizar.get(0).getMontoApostado() < apuesta.getMontoApostado()
                                && apuesta.getCasillero() == apuestasAanalizar.get(0).getCasillero()) {
                            throw new ApuestaInvalidaException("No esta permitido en este caso apostar un monto mayor al color"
                                    + " que no gano la jugada anterior");
                        }
                    }
                    //salio el cero, entonces se perdio. No se puede apostar un monto mayor al anterior
                } else {
                    if (apuestasAanalizar.size() == 2) {
                        for (Apuesta apuestaHistorico : apuestasAanalizar) {
                            if (apuestaHistorico.getCasillero() == apuesta.getCasillero()
                                    && apuestaHistorico.getMontoApostado() < apuesta.getMontoApostado()) {
                                throw new ApuestaInvalidaException("No esta permitido en este caso apostar un monto mayor al color"
                                        + " que no gano la jugada anterior");
                            }
                        }
                    }
                }
            }
        }
    }

    /*
    private int colorCasillero(int ultimoGanador) {
        int retorno;
        if (ListaUniversalCasilleros.numerosRojos().stream().anyMatch(l -> l == ultimoGanador)) {
            retorno = ListaUniversalCasilleros.casilleroRojo();
        } else {
            retorno = ListaUniversalCasilleros.casilleroNegro();
        }
        return retorno;
    }

    private boolean apuestaInvolucraColor(Apuesta apuesta) {
        return ListaUniversalCasilleros.getCasillerosApuestaColor().stream().anyMatch(a -> a == apuesta.getCasillero());
    }
     */
    private ArrayList<Apuesta> jugadorApostoColorEnRondaAnterior(ArrayList<Apuesta> apuestas) {
        ArrayList<Apuesta> retorno = new ArrayList<>();
        ArrayList<Integer> casillerosColores = ListaUniversalCasilleros.getCasillerosApuestaColor();
        for (Integer i : casillerosColores) {
            boolean colorEncontrado = false;

            for (int j = 0; j < apuestas.size() && !colorEncontrado; j++) {
                if (apuestas.get(j).getCasillero() == i) {
                    retorno.add(apuestas.get(j));
                    colorEncontrado = true;
                }
            }
        }
        return retorno;
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

    private void obligatoriedadApuestaDirecta() {
        boolean poseeApuestaDirecta = false;
        ApuestaDirecta apuestaDirecta = new ApuestaDirecta();
        for (TipoApuesta tipo : tipoApuesta) {
            if (tipo instanceof ApuestaDirecta) {
                apuestaDirecta = (ApuestaDirecta) tipo;
            }
            if (tipo instanceof ApuestaDirecta) {
                poseeApuestaDirecta = true;
            }
        }
        if (!poseeApuestaDirecta) {
            tipoApuesta.add(apuestaDirecta);
        }
    }
}
