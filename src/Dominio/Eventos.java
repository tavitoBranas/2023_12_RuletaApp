package Dominio;

public enum Eventos {
    MesaAgregada, //se agrega mesa por el crupier
    MesaEliminada, //se elimina una mesa, el crupier la cierra
    UnirseAmesa, //se une usuario a una mesa
    AbandonarMesa, //un usuario abandona la mesa
    UsuarioAgregado, //se agrega un usuario a la mesa??
    UsuarioAbandonaMesa, //usuario abandona mesa??
    UsuarioDeslogueado, //un usuario se desloguea
    CierraMesa, //crupier cierra la mesa ??
    NumeroGanador, //se determina el numero ganador
    Pagar, //la mesa engtra en estado pagar
    Lanzar,
}
