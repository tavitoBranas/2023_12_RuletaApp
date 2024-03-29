package Dominio;

public enum Eventos {
    MesaAgregada, //se agrega mesa por el crupier
    MesaEliminada, //se elimina una mesa, el crupier la cierra
    UsuarioAgregado, //se agrega un usuario a la mesa
    UsuarioAbandonaMesa, //usuario abandona mesa
    UsuarioDeslogueado, //un usuario se desloguea
    CierraMesa, //crupier cierra la mesa 
    NumeroGanador, //se determina el numero ganador
    Pagar, //la mesa entra en estado pagar
    Lanzar, 
    ApuestaRealizada, //se ingresa una apuesta en la ronda
    ActualizacionSaldo, //se actualiza el saldo del jugador
    RondaTerminada, //se termina la ronda y se actualiza saldo del jugador, balance de mesa etc 
    MesaPorCerrar, //se avisa al jugador que la mesa va a cerrar
}
