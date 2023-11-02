package UI.Interface;

import Dominio.TipoApuesta;
import java.util.ArrayList;

public interface IniciarMesaVista extends GeneralVista{
    
    public void mostrarTiposApuesta(ArrayList<TipoApuesta> tipos);
    public void cerrarVentana();
}
