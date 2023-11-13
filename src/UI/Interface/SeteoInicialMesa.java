package UI.Interface;

import Dominio.Apuesta;
import Dominio.Jugador;
import Dominio.Mesa;
import java.util.ArrayList;

public interface SeteoInicialMesa extends GeneralVista {

    public void mostrarNumeroGanador(int numeroGanador);

    public void ocultarNumeroGanador();

    public void actualizarEstadisticaYronda(Mesa mesa);

}
