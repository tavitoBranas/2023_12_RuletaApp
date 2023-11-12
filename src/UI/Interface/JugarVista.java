package UI.Interface;

import Dominio.Jugador;
import Dominio.Mesa;
import Logica.Fachada;
import java.util.ArrayList;

public interface JugarVista extends SeteoInicialMesa {

    public void cargarDatos(Mesa mesa, Jugador jugador);

    public void cargarMensaje(String mensaje);

    public void bloqueoApuestasYAbandono(String mensaje);

    public void reactivarApuestasYAbandono(String mensaje);

    public void apuestaRealizada(Jugador jugador);

    public void actualizarBalanceJugador(Jugador jugador);

    public void avisarMesaEstaPorCerrar(String la_mesa_esta_por_cerrar);
}
