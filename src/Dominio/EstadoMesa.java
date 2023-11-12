package Dominio;

import java.util.ArrayList;
import java.util.Map;

public abstract class EstadoMesa {

    private boolean jugadoresIngresanMesa;
    private boolean jugadoresAbandonanMesa;
    private boolean jugadoresApuestan;

    public EstadoMesa() {

    }

    public boolean isJugadoresIngresanMesa() {
        return jugadoresIngresanMesa;
    }

    public void setJugadoresIngresanMesa(boolean jugadoresIngresanMesa) {
        this.jugadoresIngresanMesa = jugadoresIngresanMesa;
    }

    public boolean isJugadoresAbandonanMesa() {
        return jugadoresAbandonanMesa;
    }

    public void setJugadoresAbandonanMesa(boolean jugadoresAbandonanMesa) {
        this.jugadoresAbandonanMesa = jugadoresAbandonanMesa;
    }

    public boolean isJugadoresApuestan() {
        return jugadoresApuestan;
    }

    public void setJugadoresApuestan(boolean jugadoresApuestan) {
        this.jugadoresApuestan = jugadoresApuestan;
    }

    protected abstract void accionar(Mesa mesa);

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

    protected void balanceMesa(Mesa mesa, BalanceMesa balance) {
        //seteo el total apostado
        balance.setApuestas(mesa.getRonda().getMontoTotalApostado());
        //la recoleccion queda establecida en el momento del pago: si jugador gana se le paga 
        //la liquidacion se establece al pagarle al jugador
        mesa.getEstadistica().setHistoricoBalance(balance);
    }

    protected void pagarJugadores(Mesa mesa, BalanceMesa balanceMesa) {
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
}
