package Dominio;

import Excepciones.EfectoException;
import java.util.Random;

public abstract class Efecto {

    private final String nombre;
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

    protected void setearNumeroGanador(int numero) {
        numeroGanador = numero;
    }

    public int getNumeroGanador() {
        return numeroGanador;
    }

    protected abstract void lanzar(Ronda ronda) throws EfectoException;

}
