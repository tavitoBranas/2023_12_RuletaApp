package Dominio;

public class BalanceMesa {

    private int ronda;
    private int balanceAnterior;
    private final int apuestas;  //total apostado
    private final int recoleccion; // apuestas perdidas --> lo que se lleva la casa
    private final int liquidacion; //apuestas pagadas MONTO TOTAL segun la jugada
    private int balancePosterior;

    public BalanceMesa(int apuestas, int recoleccion, int liquidacion) {
        this.apuestas = apuestas;
        this.recoleccion = recoleccion;
        this.liquidacion = liquidacion;
        balanceAnterior = 0;
        balancePosterior = apuestas + recoleccion - liquidacion;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public int getBalanceAnterior() {
        return balanceAnterior;
    }

    public void setBalanceAnterior(int balanceAnterior) {
        this.balanceAnterior = balanceAnterior;
    }

    public int getApuestas() {
        return apuestas;
    }

    public int getRecoleccion() {
        return recoleccion;
    }

    public int getLiquidacion() {
        return liquidacion;
    }

    public int getBalancePosterior() {
        return balancePosterior;
    }

    public void setBalancePosterior() {
        this.balancePosterior = apuestas + recoleccion - liquidacion + balanceAnterior;
    }

}
