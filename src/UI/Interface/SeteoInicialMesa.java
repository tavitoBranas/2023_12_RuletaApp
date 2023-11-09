package UI.Interface;

import Dominio.Estadistica;
import java.util.ArrayList;

public interface SeteoInicialMesa extends GeneralVista {

    public void inhabilitarApuestasEspecificas(ArrayList<String> apuestas);

    public void mostrarNumeroGanador(int numeroGanador);

    public void ocultarNumeroGanador();

    public void actualizarNumerosYronda(Estadistica estadistica);
}
