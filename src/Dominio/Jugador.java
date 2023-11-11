package Dominio;

import Excepciones.MontoInsuficienteException;
import Logica.Fachada;
import java.util.ArrayList;

public class Jugador extends Usuario{

    private String nombre;
    private int saldo;
    private ArrayList<Apuesta> ultimasApuestas;

    public Jugador(int ced, String password, String nomb, int saldo) {
        super(ced, password);
        nombre = nomb;
        this.saldo = saldo;
        ultimasApuestas = new ArrayList<>();
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

    public void validaMontoApuesta(int monto) throws MontoInsuficienteException {
       if(this.saldo < monto){
           throw new MontoInsuficienteException("El saldo del jugador no es suficiente para apostar");
       }
    }

    public void avisarAmesasDeApuesta() {
       for(Mesa mesa:Fachada.getInstancia().mesasDisponibles()){
           boolean encontrado = false;
           for(int i=0; i< mesa.getListaJugadores().size() && !encontrado; i++){
               if(mesa.getListaJugadores().get(i).equals(this)){
                   mesa.jugadorAvisaDeApuestaRealizada();
                   encontrado = true;
               }
           }
       }
    }

}
