package Controlador;

import Dominio.Usuario;
import Logica.Fachada;
import UI.Interface.LogInVista;

public abstract class LogInVistaControlador {

    protected LogInVista vista;
    protected Fachada fachada;

    protected LogInVistaControlador(LogInVista vista) {
        this.vista = vista;
        fachada = Fachada.getInstancia();
    }

    public void logIn(int ci, String pass) {
        Usuario usuario = logInEspecifico(ci, pass);
        if (usuario == null) {
            vista.mostrarMensajeError("Credenciales incorrectas");
        } else {
            vista.ejecutarCasoInicial(usuario);
            cerrarVentana();
        }
    }
    
    protected abstract Usuario logInEspecifico(int ci, String pass);

    protected void cerrarVentana() {
        vista.cerrarVentana();
    }
    
}
