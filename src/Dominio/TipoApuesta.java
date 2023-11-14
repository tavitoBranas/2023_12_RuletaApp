package Dominio;

import Excepciones.ApuestaInvalidaException;
import java.util.Objects;

public abstract class TipoApuesta {

    private String tipo;
    private int factorDePago;

    protected TipoApuesta(String nombre, int factor) {
        factorDePago = factor;
        tipo = nombre;
    }
    
    protected TipoApuesta(){
        
    }

    public String getNombreTipo() {
        return tipo;
    }

    public int getFactorDePago() {
        return factorDePago;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.tipo);
        hash = 53 * hash + this.factorDePago;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoApuesta other = (TipoApuesta) obj;
        return Objects.equals(this.tipo, other.tipo);
    }
    
    protected void validacionCantidadApuestasDocena(Apuesta apuesta, Ronda ronda) throws ApuestaInvalidaException{}
    protected void validacionConUltimaJugada(Apuesta apuesta, Estadistica estadistica) throws ApuestaInvalidaException {}
}
