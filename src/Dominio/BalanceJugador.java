package Dominio;

public final class BalanceJugador {

    private int ronda;
    private int totalApostado;
    private final int ganado;
    private int perdido;
    private int balance;

    public BalanceJugador(int ronda, int totalApostado, int ganado) {
        this.ronda = ronda;
        this.totalApostado = totalApostado;
        this.ganado = ganado;
        setPerdido();
    }

    public int getRonda() {
        return ronda;
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalanceInicial(int monto){
        balance = monto;
    }
    
    public void setBalance(int balanceAnterior){
        balance = balanceAnterior + ganado - perdido;
    }
    
    public int getGanado() {
        return ganado;
    }

    public int getPerdido() {
        return perdido;
    }

    public void setPerdido() {
        perdido = ganado - totalApostado;
    }

}
