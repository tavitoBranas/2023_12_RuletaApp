package Dominio;

public class BalanceMesa {

    private int ronda;
    private int balanceAnterior;
    private int apuestas;  //total apostado
    private int recoleccion; // apuestas perdidas --> lo que se lleva la casa
    private int liquidacion; //apuestas pagadas MONTO TOTAL segun la jugada
    private int balancePosterior;

    public BalanceMesa(int ronda) {
        this.ronda = ronda;
        this.apuestas = 0;
        this.recoleccion = 0;
        this.liquidacion = 0;
        balanceAnterior = 0;
        balancePosterior = 0;
    }

    public int getRonda() {
        return ronda;
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
        this.setBalancePosterior(apuestas - liquidacion + balanceAnterior);
    }

    public void setApuestas(int apuestas) {
        this.apuestas = apuestas;
    }

    public void setRecoleccion(int recoleccion) {
        this.recoleccion = recoleccion;
    }

    public void setLiquidacion(int liquidacion) {
        this.liquidacion = liquidacion;
    }

    public void setBalancePosterior(int balancePosterior) {
        this.balancePosterior = balancePosterior;
    }
}
