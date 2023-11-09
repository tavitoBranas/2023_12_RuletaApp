
package Dominio;

public abstract class EstadoMesa {
    private boolean jugadoresIngresanMesa;
    private boolean jugadoresAbandonanMesa;
    private boolean jugadoresApuestan;
    
    public EstadoMesa(){
        
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
}
