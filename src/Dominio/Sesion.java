package Dominio;

import Excepciones.MesaException;
import java.util.ArrayList;
import java.util.HashMap;

public class Sesion {

    private Usuario usuario;
    private HashMap mesasJuegoJugador;

    public Sesion(Usuario u) {
        usuario = u;
        mesasJuegoJugador = new HashMap<>();
        mesasJuegoJugador.put(u.getCedula(), new ArrayList<Mesa>());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void unirseAmesa(int ci, Mesa mesa) throws MesaException {
        ArrayList<Mesa> mesas = (ArrayList<Mesa>) mesasJuegoJugador.get(ci);
        if (mesas != null) {
            for (Mesa mesaBuscada : mesas) {
                if (mesaBuscada.equals(mesa)) {
                    throw new MesaException("El jugador ya participa de esta mesa.");
                }
            }
        }else{
            mesas = new ArrayList<Mesa>();
        }
        mesas.add(mesa);
        mesasJuegoJugador.put(ci, mesas);
    }

    public void abandonarMesa(int ci, Mesa mesa) {
        ArrayList<Mesa> mesas = (ArrayList) mesasJuegoJugador.get(ci);
        mesas.remove(mesa);
    }

}
