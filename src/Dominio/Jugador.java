package Dominio;

public class Jugador extends Usuario {

    private String nombre;
    private int saldo;

    public Jugador(int ced, String password, String nomb, int saldo) {
        super(ced, password);
        nombre = nomb;
        this.saldo = saldo;
    }

    public Jugador() {
    }

    ;

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
