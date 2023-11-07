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
                if (tipo.getTipo().equals(dato)) {
                    tipoApuestaSeleccionada.add(tipo);
                }
            }
        }
        //try { NO HAY EXCEPCIONES AL CREAR MESA
        Mesa mesa = new Mesa(nombre, tipoApuestaSeleccionada, crupier);
        fachada.crearMesa(mesa);
        vista.ejecutarCasoOperarMesa(mesa);
        vista.cerrarVentana();
        /*} catch (Exception e) {
            vista.mostrarMensajeError(e.getMessage());
        }*/
    }

    public void desloguearUsuario(Crupier crupier) {
        fachada.desloguearUsuarioCrupier(crupier);
    }

}
