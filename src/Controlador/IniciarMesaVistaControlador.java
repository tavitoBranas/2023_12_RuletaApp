package Controlador;

import Dominio.Crupier;
import Dominio.Mesa;
import Dominio.TipoApuesta;
import Logica.Fachada;
import UI.Interface.IniciarMesaVista;
import java.util.ArrayList;
import java.util.List;

public class IniciarMesaVistaControlador {

    private IniciarMesaVista vista;
    private Fachada fachada;
    private Crupier crupier;

    public IniciarMesaVistaControlador(IniciarMesaVista vista, Crupier crupier) {
        this.vista = vista;
        this.crupier = crupier;
        fachada = Fachada.getInstancia();
        inicializarVista();
    }

    private void inicializarVista() {
        vista.mostrarTiposApuesta(fachada.tipoApuestaDisponibles());
    }

    public void crearMesa(List<String> apuestas) {
        String nombre = crupier.getCedula() + "";
        ArrayList<TipoApuesta> tipoApuestaSeleccionada = new ArrayList<>();

        for (TipoApuesta tipo : fachada.tipoApuestaDisponibles()) {
            for (String dato : apuestas) {
                if (tipo.getNombreTipo().equals(dato)) {
                    tipoApuestaSeleccionada.add(tipo);
                }
            }
        }
        Mesa mesa = new Mesa(nombre, tipoApuestaSeleccionada, crupier);
        //la obligatoriedad de ap directa esta seteada en la mesa
        fachada.crearMesa(mesa);
        vista.ejecutarCasoOperarMesa(mesa);
        vista.cerrarVentana();
    }

    public void desloguearUsuario(Crupier crupier) {
        fachada.desloguearUsuarioCrupier(crupier);
    }
}
