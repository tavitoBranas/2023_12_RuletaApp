package UI;

import Excepciones.LoginException;
import Logica.DatosPrueba;

public class Inicio {

    public static void main(String args[]) throws LoginException {

        DatosPrueba.iniciar();
        new Dialogo_VentanaInicio().setVisible(true);
    }
}
