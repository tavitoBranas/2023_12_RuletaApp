package Controlador;

import Dominio.Crupier;
import Dominio.Usuario;
import Excepciones.LoginException;
import Logica.Fachada;
import UI.Dialogo_IniciarMesaCrupier;
import UI.Interface.LogInVista;

public class LogInCrupierVistaControlador extends LogInVistaControlador {

    public LogInCrupierVistaControlador(LogInVista vista) {
        super(vista);
    }

    @Override
    public Usuario logInEspecifico(int ci, String pass) {

        Crupier crupier = null;
        try {
            crupier = fachada.loginCrupier(ci, pass);
            vista.cerrarVentana();
            
        } catch (LoginException e) {
            vista.mostrarMensajeError(e.getMessage());
        }
        return crupier;
    }
}
