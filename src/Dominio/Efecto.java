package Dominio;

import java.util.Random;

public abstract class Efecto {

    private final String nombre;
    private Ronda ronda;
    private int numeroGanador;

    public Efecto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    protected int numeroGanador() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(37);
        return numeroAleatorio;
    }

    protected Ronda getRonda() {
        return ronda;
    }

     protected void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    protected void setearNumeroGanador(int numero){
        numeroGanador = numero;
    }
    
    protected abstract void lanzar();

}
