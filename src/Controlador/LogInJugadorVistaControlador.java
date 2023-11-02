package Controlador;

import Dominio.Jugador;
import Dominio.Usuario;
import Excepciones.LoginException;
import UI.Dialogo_UnirseAmesaJugador;
import UI.Interface.LogInVista;

public class LogInJugadorVistaControlador extends LogInVistaControlador {

    public LogInJugadorVistaControlador(LogInVista vista) {
        super(vista);
    }

    @Override
    public Usuario logInEspecifico(int ci, String pass) {

        Jugador jugador = null;
        try {
            jugador = fachada.loginJugador(ci, pass);
            vista.cerrarVentana();
        } catch (LoginException e) {
            vista.mostrarMensajeError(e.getMessage());
        }
        return jugador;
    }

}
