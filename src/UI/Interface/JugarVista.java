package UI.Interface;

import Dominio.Jugador;
import Dominio.Mesa;
import Logica.Fachada;
import java.util.ArrayList;

public interface JugarVista extends GeneralVista {
    public void cargarDatos(Mesa mesa, Jugador jugador);
    public void cargarMensaje(Mesa mesa);
}
