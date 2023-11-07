package UI.Interface;

import Dominio.Jugador;
import Dominio.Mesa;
import Dominio.Usuario;
import java.util.ArrayList;

public interface UnirseMesaVista extends GeneralVista {

    public void mostrarMesasAbiertas(ArrayList<Mesa> mesas);
    public void datosJugador(Jugador jugador);
    public void ejecutarCasoDeUsoJugar(Mesa mesa, Jugador jugador);
}
