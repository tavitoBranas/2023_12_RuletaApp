package Dominio;

import Excepciones.ApuestaInvalidaException;
import Excepciones.EfectoException;
import Excepciones.MesaAbandonoException;
import Excepciones.MontoInsuficienteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ronda {

    private final Mesa mesa;
    private Efecto efecto;
    private ArrayList<Integer> casillerosSeleccionados;
    private final Map<Jugador, ArrayList<Apuesta>> apuestas;
    private int cantidadApuestas;
    private int montoTotalApostado;

    public Ronda(Mesa mesa) {
        this.mesa = mesa;
        mesa.setRonda(this);
        casillerosSeleccionados = new ArrayList<>();
        apuestas = new HashMap<>();
        cantidadApuestas = 0;
        montoTotalApostado = 0;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Efecto getEfecto() {
        return efecto;
    }

    public Map<Jugador, ArrayList<Apuesta>> getApuestas() {
        return apuestas;
    }

    public ArrayList<Integer> getCasillerosSeleccionados() {
        return casillerosSeleccionados;
    }

    public void setCasillerosSeleccionados() {
        this.casillerosSeleccionados = casillerosApostados();
    }

    public void lanzar() throws EfectoException {
        this.getEfecto().lanzar(this);
    }

    public void setEfecto(Efecto efecto) {
        this.efecto = efecto;
    }

    public int getCantidadApuestas() {
        return cantidadApuestas;
    }

    public int getMontoTotalApostado() {
        return montoTotalApostado;
    }

    public ArrayList<Integer> apuestaDerecta() {
        ArrayList<Integer> retorno = new ArrayList<>();

        for (int a : getCasillerosSeleccionados()) {
            if (ListaUniversalCasilleros.getCasillerosApuestaDirecta().stream().anyMatch(casillero -> casillero == a)
                    && !retorno.contains(a)) {
                retorno.add(a);
            }
        }
        return retorno;
    }

    public void apostar(Apuesta apuesta) throws ApuestaInvalidaException, MontoInsuficienteException {
        //el monto de la apuesta tiene que ser mayor a cero
        apuesta.validarMonto();
        //1er valido si jugador puede apostar
        apuesta.getJugador().validaMontoApuesta(apuesta.getMontoApostado());
        //2er se valida apuesta a nivel de la mesa
        mesa.validarApuesta(apuesta);
        //se ingresa al hasmap de apuestas de la ronda
        ingresoApuestasARonda(apuesta);
        //se actualiza saldo del jugador
        int nuevoSaldo = apuesta.getJugador().getSaldo() - apuesta.getMontoApostado();
        apuesta.getJugador().setSaldo(nuevoSaldo);
        //se actualiza monto total apostado y cantidad apuestas de la ronda
        this.cantidadApuestas += 1;
        this.montoTotalApostado += apuesta.getMontoApostado();
        apuesta.getJugador().avisar(Eventos.ApuestaRealizada);
    }

    private ArrayList<Integer> casillerosApostados() {
        ArrayList<Integer> casillerosApostados = new ArrayList<>();
        for (ArrayList<Apuesta> listaApuestas : getApuestas().values()) {
            for (Apuesta apuesta : listaApuestas) {
                if (!casillerosApostados.contains(apuesta.getCasillero())) {
                    casillerosApostados.add(apuesta.getCasillero());
                }
            }
        }
        return casillerosApostados;
    }

    private void ingresoApuestasARonda(Apuesta apuesta) {
        Jugador jugador = apuesta.getJugador();
        ArrayList<Apuesta> apuestasJugador = getApuestas().getOrDefault(jugador, new ArrayList<>());
        //veo si ya existe una apuesta anterior al mismo casillero
        if (apuestasJugador.stream().anyMatch(a -> a.getCasillero() == apuesta.getCasillero())) {
            //si existe actualizo la apuesta anterior con el monto actual
            boolean encontrado = false;
            for (int i = 0; i < apuestasJugador.size() && !encontrado; i++) {
                if (apuestasJugador.get(i).getCasillero() == apuesta.getCasillero()) {
                    int nuevoMonto = apuesta.getMontoApostado() + apuestasJugador.get(i).getMontoApostado();
                    apuestasJugador.get(i).setMontoApostado(nuevoMonto);
                    encontrado = true;
                }
            }
        } else {
            apuestasJugador.add(apuesta);
            apuestas.put(jugador, apuestasJugador);
        }
    }

    public void habilitadoAbandono(Jugador jugador) throws MesaAbandonoException {
        if (getApuestas().containsKey(jugador)) {
            throw new MesaAbandonoException("No puede abandonar hasta completar la ronda");
        }
    }

    public BalanceJugador setearMontoTotalApostado(int numeroDeRonda, Jugador jugador) {
        BalanceJugador balanceJugador = new BalanceJugador(numeroDeRonda);
        int montoTotalApostado = 0;

        ArrayList<Apuesta> apuestasJugador = apuestas.get(jugador);

        for (Apuesta apuesta : apuestasJugador) {
            montoTotalApostado += apuesta.getMontoApostado();
        }
        balanceJugador.setTotalApostado(montoTotalApostado);
        return balanceJugador;
    }
}
