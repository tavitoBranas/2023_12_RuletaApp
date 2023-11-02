package Dominio;

import Excepciones.LoginException;

public abstract class Usuario {

    private int cedula;
    private String password;
    private boolean sesionActiva;

    public Usuario() {
    }

    public Usuario(int ci, String pass) {
        cedula = ci;
        password = pass;
    }

    public int getCedula() {
        return cedula;
    }

    public boolean isSesionActiva() {
        return sesionActiva;
        //el usuario tiene un booleano para que sea mas facil y no tener que recorrer hashmap, esta bien??
    }

    public void setSesionActiva(boolean sesionActiva) {
        this.sesionActiva = sesionActiva;
    }

    public void validarUsuario(String pass) throws LoginException {
        if (!password.equals(pass)) {
            throw new LoginException("Credenciales incorrectas.");
        }
    }

    public void sesionActiva() throws LoginException {
        if (this.isSesionActiva()) {
            throw new LoginException("Acceso denegado. El usuario ya tiene una sesión activa.");
        }
    }

    @Override
    public boolean equals(Object o) {
        Usuario aComparar = (Usuario) o;
        return this.getCedula() == aComparar.getCedula();
    }

}
