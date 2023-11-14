package Dominio;

import Excepciones.EfectoException;
import Excepciones.MesaEstadoException;

public final class EstadoMesaAbierta extends EstadoMesa {

    public EstadoMesaAbierta(Mesa mesa) {
        super(mesa);
    }

    @Override
    protected void lanzar() throws EfectoException, MesaEstadoException {
        mesa.setEstado(new EstadoMesaLanzar(mesa));
        mesa.lanzar();
    }

    @Override
    protected void cerrar() throws MesaEstadoException {
        throw new MesaEstadoException("No se puede CERRAR. Para ello la mesa debe de haber lanzado ");
    }

    @Override
    protected void pagar() throws MesaEstadoException {
        throw new MesaEstadoException("No se puede PAGAR. Para ello la mesa debe de haber "
                + "lanzado");
    }

    @Override
    protected void habilitadoIngreso() {
    }

    @Override
    protected void habilitadoAvandono() {
    }

}
