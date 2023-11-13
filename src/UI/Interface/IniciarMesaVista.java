package UI.Interface;

import Dominio.Mesa;
import Dominio.TipoApuesta;
import java.util.ArrayList;

public interface IniciarMesaVista extends GeneralVista{
    public void mostrarTiposApuesta(ArrayList<TipoApuesta> tipos);
    public void ejecutarCasoOperarMesa(Mesa mesa);
}
