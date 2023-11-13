package Dominio;

import Excepciones.LoginException;
import comun.Observable;

public abstract class Usuario extends Observable {

    private int cedula;
    private String password;

    public Usuario() {
    }

    public Usuario(int ci, String pass) {
        cedula = ci;
        password = pass;
    }

    public int getCedula() {
        return cedula;
    }

    public void validarUsuario(String pass) throws LoginException {
        if (!password.equals(pass)) {
            throw new LoginException("Credenciales incorrectas.");
        }
    }

    @Override
    public boolean equals(Object o) {
        Usuario aComparar = (Usuario) o;
        return this.getCedula() == aComparar.getCedula();
    }  
}
