package Controlador;

import Logica.Fachada;
import UI.Dialogo_OperarMesaCrupier;
import UI.Interface.IniciarMesaVista;

public class IniciarMesaVistaControlador {

    private IniciarMesaVista vista;
    private Fachada fachada;

    public IniciarMesaVistaControlador(IniciarMesaVista vista/*, Mesa modelo*/) {

        this.vista = vista;

        //this.modelo = modelo; ES LA FACHADA
        fachada = Fachada.getInstancia();
        //controlador se subscribe a los eventos de la fachada: fachada es observable y controlador observador
        inicializarVista();
    }

    private void inicializarVista() {
        vista.mostrarTiposApuesta(fachada.tipoApuestaDisponibles());
    }

    public void crearMesa(String mensaje) {
        fachada.crearMesa(mensaje);

        vista.cerrarVentana();
        Dialogo_OperarMesaCrupier operarMesa = new Dialogo_OperarMesaCrupier(new javax.swing.JFrame(), true);
        operarMesa.setModal(false);
        operarMesa.setVisible(true);
    }

}
