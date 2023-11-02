package Logica;

import Dominio.Crupier;
import Dominio.Jugador;
import Dominio.Mesa;
import Dominio.Sesion;
import Excepciones.LoginException;
import Excepciones.MesaException;
import comun.Observable;
import java.util.ArrayList;

class ServicioUsuario extends Observable{

    private static ServicioUsuario instancia;
    private ArrayList<Jugador> listaJugadores;
    private ArrayList<Crupier> listaCrupiers;
    private ArrayList<Sesion> listaSesiones;

    public ServicioUsuario() {
        listaJugadores = new ArrayList<Jugador>();
        listaCrupiers = new ArrayList<Crupier>();
        listaSesiones = new ArrayList<Sesion>();
    }

    public synchronized static ServicioUsuario getInstancia() {
        if (instancia == null) {
            instancia = new ServicioUsuario();
        }
        return instancia;
    }

    public Jugador logInJugador(int ci, String pass) throws LoginException {
        boolean usuarioEncontrado = false;
        Jugador jugador = null;
        for (int i = 0; i < listaJugadores.size() && !usuarioEncontrado; i++) {
            Jugador enBusqueda = listaJugadores.get(i);
            if (enBusqueda.getCedula() == ci) {
                enBusqueda.validarUsuario(pass);
                jugador = enBusqueda;
                jugador.sesionActiva();
                listaSesiones.add(new Sesion(jugador));
                jugador.setSesionActiva(true);
                usuarioEncontrado = true;
            }
        }
        if (jugador == null) {
            usuarioNoEncontrado();
        }
        return jugador;
    }

    public Crupier logInCrupier(int ci, String pass) throws LoginException {
        boolean usuarioEncontrado = false;
        Crupier crupier = null;
        for (int i = 0; i < listaCrupiers.size() && !usuarioEncontrado; i++) {
            Crupier enBusqueda = listaCrupiers.get(i);
            if (enBusqueda.getCedula() == ci) {
                enBusqueda.validarUsuario(pass);
                crupier = enBusqueda;
                crupier.sesionActiva();
                //listaSesiones.add(new Sesion(crupier));
                crupier.setSesionActiva(true);
                usuarioEncontrado = true;
            }
        }
        if (crupier == null) {
            usuarioNoEncontrado();
        }
        return crupier;
    }

    public void agregarJugador(Jugador j) {
        listaJugadores.add(j);
    }

    public void agregarCrupier(Crupier c) {
        listaCrupiers.add(c);
    }

    private void usuarioNoEncontrado() throws LoginException {
        throw new LoginException("Credenciales incorrectas");
    }

    public void unirseAmesa(Jugador j, Mesa mesa) throws MesaException {
        for (Sesion sesion : listaSesiones) {
            if (sesion.getUsuario().equals(j)) {
                sesion.unirseAmesa(j.getCedula(), mesa);
            }
        }
    }

    public void abandonarMesa(Jugador j, Mesa mesa){
        for (Sesion sesion : listaSesiones) {
            if (sesion.getUsuario().equals(j)) {
                sesion.abandonarMesa(j.getCedula(), mesa);
            }
        }
    }
}
