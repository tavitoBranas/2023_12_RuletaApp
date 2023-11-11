package Controlador;

import Dominio.ApuestaDirecta;
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
        ArrayList<TipoApuesta> tipoApuestaSeleccionada = obligatoriedadApuestaDirecta();

        for (TipoApuesta tipo : fachada.tipoApuestaDisponibles()) {
            for (String dato : apuestas) {
                if (tipo.getTipo().equals(dato)) {
                    tipoApuestaSeleccionada.add(tipo);
                }
            }
        }

        //try { NO HAY EXCEPCIONES AL CREAR MESA
        Mesa mesa = new Mesa(nombre, tipoApuestaSeleccionada, crupier);
        fachada.crearMesa(mesa);

        //nuevo panel
        //PanelRuletaJuego panel = new PanelRuletaJuego(mesa);

        vista.ejecutarCasoOperarMesa(mesa);
        vista.cerrarVentana();
        /*} catch (Exception e) {
            vista.mostrarMensajeError(e.getMessage());
        }*/
    }

    public void desloguearUsuario(Crupier crupier) {
        fachada.desloguearUsuarioCrupier(crupier);
    }

    private ArrayList<TipoApuesta> obligatoriedadApuestaDirecta() {

        ArrayList<TipoApuesta> tipoApuestaSeleccionada = new ArrayList<>();
        ArrayList<TipoApuesta> tiposDisponibles = fachada.tipoApuestaDisponibles();

        for (int i = 0; i < tiposDisponibles.size() && tipoApuestaSeleccionada.isEmpty(); i++) {
            if (tiposDisponibles.get(i) instanceof ApuestaDirecta) {
                tipoApuestaSeleccionada.add(tiposDisponibles.get(i));
            }
        }
        return tipoApuestaSeleccionada;
    }
}
