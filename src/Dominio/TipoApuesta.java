package Dominio;

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
}
