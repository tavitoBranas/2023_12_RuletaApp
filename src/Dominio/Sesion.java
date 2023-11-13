package Dominio;

public class Sesion {

    private Usuario usuario;

    public Sesion(Usuario u) {
        usuario = u;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
