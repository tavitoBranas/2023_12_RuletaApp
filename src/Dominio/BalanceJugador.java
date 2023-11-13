package Dominio;

public final class BalanceJugador {

    private final int ronda;
    private int totalApostado;
    private int ganado;
    private int perdido;
    private int balance;

    public BalanceJugador(int ronda) {
        this.ronda = ronda;
        this.totalApostado = 0;
        this.ganado = 0;
        this.perdido = 0;
        balance = 0;
    }

    public int getRonda() {
        return ronda;
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public void setTotalApostado(int total) {
        totalApostado = total;
    }

    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balanceAnterior) {
        balance = balanceAnterior + ganado - totalApostado;
    }

    public int getGanado() {
        return ganado;
    }

    public void setGanado(int ganado) {
        this.ganado = ganado;
    }

    public int getPerdido() {
        return perdido;
    }

    public void setPerdido(int perdido) {
        this.perdido = perdido;
    }
}
