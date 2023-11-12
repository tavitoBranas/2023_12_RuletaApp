package Dominio;

import java.util.ArrayList;
import java.util.Map;

public final class EstadoMesaAbiertaPagar extends EstadoMesa {

    public EstadoMesaAbiertaPagar(Mesa mesa) {
        super();
        this.setJugadoresAbandonanMesa(true);
        this.setJugadoresApuestan(true);
        this.setJugadoresIngresanMesa(true);
        mesa.setMensaje("La mesa esta disponible para jugar");
    }

    @Override
    protected void accionar(Mesa mesa) {
        mesa.setMensaje("La mesa esta disponible para jugar");
        BalanceMesa balance = new BalanceMesa(mesa.getEstadistica().getNumeroDeRonda());
        pagarJugadores(mesa, balance);
        //ya establece la recoleccion de la mesa al ver que perdieron
        //setea la liquidacion al pagar al jugador
        //setea ganancias y perdidas de jugador a nivel de su balance
        balanceMesa(mesa, balance);  //setea monto total
        actualizarUltimaJugadaJugadores(mesa);
        generacionNuevaRonda(mesa);
        mesa.getEstadistica().setNumeroDeRonda();
    }

    private void generacionNuevaRonda(Mesa mesa) {
        Ronda nuevaronda = new Ronda(mesa);
        mesa.setRonda(nuevaronda);
    }
/*
    private void pagarJugadores(Mesa mesa, BalanceMesa balanceMesa) {
        int numeroGanador = mesa.getEstadistica().getNumerosSorteados().get(0);
        int colorGanador = 0;
        int docenaGanadora = 0;

        if (numeroGanador != 0) {
            colorGanador = ListaUniversalCasilleros.colorCasillero(numeroGanador);
            docenaGanadora = ListaUniversalCasilleros.docenaCasillero(numeroGanador);
        }

        Map<Jugador, ArrayList<Apuesta>> apuestas = mesa.getRonda().getApuestas();

        for (Map.Entry<Jugador, ArrayList<Apuesta>> elemento : apuestas.entrySet()) {
            //obtengo para cada jugador sus apuestas
            Jugador jugador = elemento.getKey();
            ArrayList<Apuesta> listaApuestas = elemento.getValue();
            //genero balance jugador para setear si gana o pierde          
            //seteo monto total apostado
            BalanceJugador balanceJugador = jugador.setearMontoTotalApostado(mesa.getEstadistica().getNumeroDeRonda(), listaApuestas);

            //analizo cada apuesta si se paga o si no va a recoleccion
            for (Apuesta apuesta : listaApuestas) {
                int numeroApostado = apuesta.getCasillero();

                for (TipoApuesta ap : mesa.getTipoApuesta()) {
                    if (ap instanceof ApuestaDirecta
                            && ListaUniversalCasilleros.getCasillerosApuestaDirecta().stream().anyMatch(a -> a == numeroApostado)) {
                        if (numeroApostado == numeroGanador) {
                            pagarAlJugadorApuestaLiquidacionMesa(jugador, apuesta, ap, balanceMesa, balanceJugador);
                        } else {
                            actualizarPeridasJugadorGananciaMesa(apuesta, balanceMesa, balanceJugador);
                        }
                    }
                    if (numeroGanador != 0) {
                        if (ap instanceof ApuestaColor
                                && ListaUniversalCasilleros.getCasillerosApuestaColor().stream().anyMatch(a -> a == numeroApostado)) {
                            if (numeroApostado == colorGanador) {
                                pagarAlJugadorApuestaLiquidacionMesa(jugador, apuesta, ap, balanceMesa, balanceJugador);
                            } else {
                                actualizarPeridasJugadorGananciaMesa(apuesta, balanceMesa, balanceJugador);
                            }
                        }
                        if (ap instanceof ApuestaDocena
                                && ListaUniversalCasilleros.getCasillerosApuestaDocena().stream().anyMatch(a -> a == numeroApostado)) {
                            if (numeroApostado == docenaGanadora) {
                                pagarAlJugadorApuestaLiquidacionMesa(jugador, apuesta, ap, balanceMesa, balanceJugador);
                            } else {
                                actualizarPeridasJugadorGananciaMesa(apuesta, balanceMesa, balanceJugador);
                            }
                        }
                    }
                }
            }
            jugador.setearBalanceAgregarAhistorico(balanceJugador);
        }
    }

    private void balanceMesa(Mesa mesa, BalanceMesa balance) {
        //seteo el total apostado
        balance.setApuestas(mesa.getRonda().getMontoTotalApostado());
        //la recoleccion queda establecida en el momento del pago: si jugador gana se le paga 
        //la liquidacion se establece al pagarle al jugador
        mesa.getEstadistica().setHistoricoBalance(balance);
    }
*/
    private void actualizarUltimaJugadaJugadores(Mesa mesa) {

        Map<Jugador, ArrayList<Apuesta>> apuestas = mesa.getRonda().getApuestas();

        for (Map.Entry<Jugador, ArrayList<Apuesta>> elemento : apuestas.entrySet()) {
            //obtengo para cada jugador sus apuestas
            Jugador jugador = elemento.getKey();
            ArrayList<Apuesta> listaApuestas = elemento.getValue();
            //la seteo como la ultima apuesta del jugador
            jugador.setUltimasApuestas(listaApuestas);
        }
    }
/*
    private void pagarAlJugadorApuestaLiquidacionMesa(Jugador jugador, Apuesta apuesta, TipoApuesta tipo,
            BalanceMesa balanceMesa, BalanceJugador balanceJugador) {
        int saldoAnterior = jugador.getSaldo();
        int ganancia = apuesta.getMontoApostado() * tipo.getFactorDePago();
        jugador.setSaldo(saldoAnterior + ganancia);
        int gananciaJugador = balanceJugador.getGanado();
        balanceJugador.setGanado(gananciaJugador + ganancia);

        //seteo en el balance de la mesa ese camnbio
        int liquidacion = balanceMesa.getLiquidacion();
        balanceMesa.setLiquidacion(liquidacion + ganancia);
    }

    private void actualizarPeridasJugadorGananciaMesa(Apuesta apuesta, BalanceMesa balanceMesa, BalanceJugador balanceJugador) {
        int recoleccion = balanceMesa.getRecoleccion();
        balanceMesa.setRecoleccion(recoleccion + apuesta.getMontoApostado());
        int perdido = balanceJugador.getPerdido();
        balanceJugador.setPerdido(perdido + apuesta.getMontoApostado());
    }
*/
}
