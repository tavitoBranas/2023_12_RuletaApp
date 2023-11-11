package Dominio;

import Excepciones.ApuestaInvalidaException;
import comun.Observable;
import java.util.ArrayList;
import java.util.HashMap;

public class Ronda {

    private final Mesa mesa;
    private Efecto efecto;
    private ArrayList<Integer> casillerosSeleccionados;
    private final HashMap<Jugador, ArrayList<Apuesta>> apuestas;
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

    public ArrayList<Integer> apuestaDerecta() {
        ArrayList<Integer> retorno = new ArrayList<>();

        for (int a : getCasillerosSeleccionados()) {
            if (a >= 0 && a <= 36 && !retorno.contains(a)) {
                retorno.add(a);
            }
        }
        return retorno;
    }

    public Efecto getEfecto() {
        return efecto;
    }

    public HashMap<Jugador, ArrayList<Apuesta>> getApuestas() {
        return apuestas;
    }

    public ArrayList<Integer> getCasillerosSeleccionados() {
        return casillerosSeleccionados;
    }

    public void setCasillerosSeleccionados(ArrayList<Integer> casillerosSeleccionados) {
        this.casillerosSeleccionados = casillerosSeleccionados;
    }

    public void lanzar() {
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

    public void apostar(Apuesta apuesta) throws ApuestaInvalidaException {
        //1er se valida apuesta
        mesa.validarApuesta(apuesta);

        //se actualiza saldo del jugador
        int nuevoSaldo = apuesta.getJugador().getSaldo() - apuesta.getMontoApostado();
        apuesta.getJugador().setSaldo(nuevoSaldo);

        //se ingresa al hasmap de apuestas de la ronda
        Jugador jugador = apuesta.getJugador();
        ArrayList<Apuesta> apuestasJugador = apuestas.getOrDefault(jugador, new ArrayList<>());
        //veo si ya existe una apuesta anterior al mismo casillero
        if (apuestasJugador.stream().anyMatch(a -> a.getCasillero() == apuesta.getCasillero())) {
            boolean encontrado = false;
            //actualizo la apuesta anterior con el monto actual
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

        //se actualiza monto total apostado y cantidad apuestas de la ronda
        this.cantidadApuestas += 1;
        this.montoTotalApostado += apuesta.getMontoApostado();
        apuesta.getJugador().avisar(Eventos.ApuestaRealizada);
    }

}
