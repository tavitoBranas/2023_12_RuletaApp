package Dominio;

import comun.Observable;

public class Mesa extends Observable {

    private String nombre;

    public Mesa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
