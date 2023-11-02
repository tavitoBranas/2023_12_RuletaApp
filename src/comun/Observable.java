package comun;

import java.util.ArrayList;

public class Observable {

    private ArrayList<Observador> observadores;

    public Observable(){
        observadores = new ArrayList<Observador>();
    }
    
    public void agregar(Observador observador) {
        getObservadores().add(observador);
    }

    public void remover(Observador observador) {
        getObservadores().remove(observador);
    }

    public void avisar(Object evento) {
        for(Observador observador: getObservadores()){
            observador.actualizar(this,evento);
        }
    }

    public ArrayList<Observador> getObservadores() {
        return observadores;
    }

}
