package UI.Interface;

import Dominio.Apuesta;
import Dominio.Efecto;
import Dominio.Jugador;
import Dominio.Mesa;
import java.util.ArrayList;
import java.util.Collection;

public interface OperarMesaVista extends SeteoInicialMesa {

    public void cargarDatosMesa(Mesa mesa);
    public void cargarDatosJugadores(ArrayList<Jugador> listaJugadores);
    public void cargarEfectos(ArrayList<Efecto> efectos);
    public void estadoBotonLanzar(boolean estado);

    public void habilitarCerrarMesa(boolean b);
    public void apuestaRealizada(Mesa mesa);

    public void resetearApuestasMonto();

    public void mostrarApuesta(Collection<ArrayList<Apuesta>> values);

}
