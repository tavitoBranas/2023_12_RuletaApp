package Dominio;

public abstract class TipoApuesta {
    private String tipo;
    
    public TipoApuesta(String tipoApuesta){
        tipo = tipoApuesta;
    }

    public String getTipo() {
        return tipo;
    }
}
