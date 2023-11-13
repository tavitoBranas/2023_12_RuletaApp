package UI;

import Controlador.LogInJugadorVistaControlador;
import Controlador.LogInVistaControlador;
import Dominio.Jugador;
import Dominio.Usuario;

public class Dialogo_LogInJugador extends Dialogo_LogIn {

    private LogInJugadorVistaControlador controlador;

    public Dialogo_LogInJugador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Ingrese las credenciales del jugador");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected LogInVistaControlador crearControlador() {
        return new LogInJugadorVistaControlador(this);
    }

    @Override
    public void ejecutarCasoInicial(Usuario jugador) {
        Dialogo_UnirseAmesaJugador unirseAmesa = new Dialogo_UnirseAmesaJugador(new javax.swing.JFrame(), true, (Jugador) jugador);
        unirseAmesa.setModal(false);
        unirseAmesa.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
