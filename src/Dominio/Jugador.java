package Dominio;

import Excepciones.MontoInsuficienteException;
import java.util.ArrayList;

public class Jugador extends Usuario {

    private String nombre;
    private int saldo;
    private ArrayList<Apuesta> ultimasApuestas;
    private ArrayList<Mesa> mesas;
    private ArrayList<BalanceJugador> historicoBalanceJugador;

    public Jugador(int ced, String password, String nomb, int saldo) {
        super(ced, password);
        nombre = nomb;
        this.saldo = saldo;
        ultimasApuestas = new ArrayList<>();
        historicoBalanceJugador = new ArrayList<>();
        mesas = new ArrayList<>();
    }

    public Jugador() {
    }

    ;

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Apuesta> getUltimasApuestas() {
        return ultimasApuestas;
    }

    public void setUltimasApuestas(ArrayList<Apuesta> ultimasApuestas) {
        this.ultimasApuestas = ultimasApuestas;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public void eliminarMesa(Mesa mesa) {
        mesas.remove(mesa);
    }

    public ArrayList<BalanceJugador> getHistoricoBalanceJugador() {
        return historicoBalanceJugador;
    }

    public void setHistoricoBalanceJugador(ArrayList<BalanceJugador> historicoBalanceJugador) {
        this.historicoBalanceJugador = historicoBalanceJugador;
    }

    public void validaMontoApuesta(int monto) throws MontoInsuficienteException {
        if (this.saldo < monto) {
            throw new MontoInsuficienteException("Saldo insuficiente");
        }
    }

    public void setearBalanceAgregarAhistorico(BalanceJugador balanceJugador) {
        if (!historicoBalanceJugador.isEmpty()) {
            balanceJugador.setBalance(getHistoricoBalanceJugador().get(0).getBalance());
        } else {
            int saldoInicial = saldo + balanceJugador.getTotalApostado() - balanceJugador.getGanado();
            balanceJugador.setBalance(saldoInicial);
        }
        getHistoricoBalanceJugador().add(0, balanceJugador);
        avisar(Eventos.ActualizacionSaldo);
    }

    public ArrayList<Apuesta> jugadorApostoColorEnRondaAnterior() {
        ArrayList<Apuesta> retorno = new ArrayList<>();
        ArrayList<Integer> casillerosColores = ListaUniversalCasilleros.getCasillerosApuestaColor();
        for (Integer i : casillerosColores) {
            boolean colorEncontrado = false;

            for (int j = 0; j < ultimasApuestas.size() && !colorEncontrado; j++) {
                if (ultimasApuestas.get(j).getCasillero() == i) {
                    retorno.add(ultimasApuestas.get(j));
                    colorEncontrado = true;
                }
            }
        }
        return retorno;
    }
}
