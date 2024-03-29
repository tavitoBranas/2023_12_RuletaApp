package Logica;

import Dominio.Crupier;
import Dominio.Eventos;
import Dominio.Jugador;
import Dominio.Sesion;
import Dominio.Usuario;
import Excepciones.LoginException;
import Excepciones.MesaAbandonoException;
import Excepciones.MesaNoDisponibleException;
import comun.Observable;
import java.util.ArrayList;

class ServicioUsuario extends Observable {

    private static ServicioUsuario instancia;
    private final ArrayList<Usuario> listaJugadores;
    private final ArrayList<Usuario> listaCrupiers;
    private final ArrayList<Sesion> listaSesionJugadores;
    private final ArrayList<Sesion> listaSesionCrupiers;

    public ServicioUsuario() {
        listaJugadores = new ArrayList<>();
        listaCrupiers = new ArrayList<>();
        listaSesionJugadores = new ArrayList<>();
        listaSesionCrupiers = new ArrayList<>();
    }

    public synchronized static ServicioUsuario getInstancia() {
        if (instancia == null) {
            instancia = new ServicioUsuario();
        }
        return instancia;
    }

    private Usuario traerUsuario(int ci, String pass, ArrayList<Usuario> listaUsuario) throws LoginException {
        boolean usuarioEncontrado = false;
        Usuario usuario = null;
        for (int i = 0; i < listaUsuario.size() && !usuarioEncontrado; i++) {
            Usuario enBusqueda = listaUsuario.get(i);
            if (enBusqueda.getCedula() == ci) {
                enBusqueda.validarUsuario(pass);
                usuario = enBusqueda;
                usuarioEncontrado = true;
            }
        }
        if (usuario == null) {
            usuarioNoEncontrado();
        }
        return usuario;
    }

    public Jugador logInJugador(int ci, String pass) throws LoginException {
        Jugador jugador = (Jugador) traerUsuario(ci, pass, listaJugadores);
        if (!sesionDelJugador(jugador)) {
            listaSesionJugadores.add(new Sesion(jugador));
        } else {
            usuarioSesionActiva();
        }
        return jugador;
    }

    public Crupier logInCrupier(int ci, String pass) throws LoginException {
        Crupier crupier = (Crupier) traerUsuario(ci, pass, listaCrupiers);
        if (!sesionDelCrupier(crupier)) {
            listaSesionCrupiers.add(new Sesion(crupier));
        } else {
            usuarioSesionActiva();
        }
        return crupier;
    }

    public void agregarJugador(Jugador j) {
        listaJugadores.add(j);
    }

    public void agregarCrupier(Crupier c) {
        listaCrupiers.add(c);
    }

    private void usuarioSesionActiva() throws LoginException {
        throw new LoginException("Acceso denegado. El usuario ya tiene una sesión activa.");
    }

    private void usuarioNoEncontrado() throws LoginException {
        throw new LoginException("Credenciales incorrectas");
    }

    private boolean sesionDelJugador(Usuario jugador) {
        boolean usuarioEncontrado = false;
        for (int i = 0; i < listaSesionJugadores.size() && !usuarioEncontrado; i++) {
            if (listaSesionJugadores.get(i).getUsuario().equals(jugador)) {
                usuarioEncontrado = true;
            }
        }
        return usuarioEncontrado;
    }

    private boolean sesionDelCrupier(Usuario crupier) {
        boolean usuarioEncontrado = false;
        for (int i = 0; i < listaSesionCrupiers.size() && !usuarioEncontrado; i++) {
            if (listaSesionCrupiers.get(i).getUsuario().equals(crupier)) {
                usuarioEncontrado = true;
            }
        }
        return usuarioEncontrado;
    }

    void desloguearUsuarioJugador(Jugador jugador) throws MesaNoDisponibleException, MesaAbandonoException {
        boolean encontrado = false;
        if (listaJugadores.contains(jugador)) {
            for (int i = 0; i < listaSesionJugadores.size() && !encontrado; i++) {
                if (listaSesionJugadores.get(i).getUsuario().equals(jugador)) {
                    //elimino de la lista de mesas si existe
                    Fachada.getInstancia().desloguearJugadordeMesas(jugador); //aca tira excepciones si no me deja abandonar
                    //elimino de la lista de sesiones
                    listaSesionJugadores.remove(listaSesionJugadores.get(i));
                    encontrado = true;
                    avisar(Eventos.UsuarioDeslogueado);
                }
            }
        }
    }

    void desloguearUsuarioCrupier(Crupier crupier) {
        if (listaCrupiers.contains(crupier)) {
            for (int i = 0; i < listaSesionCrupiers.size(); i++) {
                if (listaSesionCrupiers.get(i).getUsuario().equals(crupier)) {
                    listaSesionCrupiers.remove(listaSesionCrupiers.get(i));
                }
            }
        }
    }
}
