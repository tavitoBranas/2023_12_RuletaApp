package Dominio;

class Apuesta {
    private Jugador jugador;
    private int montoApostado;
    private int casillero;

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getMontoApostado() {
        return montoApostado;
    }

    public void setMontoApostado(int montoApostado) {
        this.montoApostado = montoApostado;
    }

    public int getCasillero() {
        return casillero;
    }

    public void setCasillero(int casillero) {
        this.casillero = casillero;
    }
    
    
}
