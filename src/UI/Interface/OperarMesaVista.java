package UI.Interface;

import Dominio.Efecto;
import Dominio.Jugador;
import Dominio.Mesa;
import java.util.ArrayList;

public interface OperarMesaVista extends GeneralVista {

    public void cargarDatosMesa(Mesa mesa);
    public void cargarDatosJugadores(ArrayList<Jugador> listaJugadores);
    public void cargarEfectos(ArrayList<Efecto> efectos);

}
