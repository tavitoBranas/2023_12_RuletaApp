package Dominio;

import Excepciones.MontoInsuficienteException;
import java.util.ArrayList;

public class Jugador extends Usuario {

    private String nombre;
    private int saldo;
    private ArrayList<Apuesta> ultimasApuestas;
    private ArrayList<Mesa> mesas;

    public Jugador(int ced, String password, String nomb, int saldo) {
        super(ced, password);
        nombre = nomb;
        this.saldo = saldo;
        ultimasApuestas = new ArrayList<>();
        mesas = new ArrayList<>();
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

    public ArrayList<Apuesta> getUltimasApuestas() {
        return ultimasApuestas;
    }

    public void setUltimasApuestas(ArrayList<Apuesta> ultimasApuestas) {
        this.ultimasApuestas = ultimasApuestas;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
    public void agregarMesa(Mesa mesa){
        mesas.add(mesa);
    }
    
    public void eliminarMesa(Mesa mesa){
        mesas.remove(mesa);
    }

    public void validaMontoApuesta(int monto) throws MontoInsuficienteException {
        if (this.saldo < monto) {
            throw new MontoInsuficienteException("Saldo insuficiente");
        }
    }

}
