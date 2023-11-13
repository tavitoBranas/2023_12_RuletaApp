package UI.Interface;

import Dominio.Mesa;

public interface SeteoInicialMesa extends GeneralVista {
    public void mostrarNumeroGanador(int numeroGanador);
    public void ocultarNumeroGanador();
    public void actualizarEstadisticaYronda(Mesa mesa);
}
