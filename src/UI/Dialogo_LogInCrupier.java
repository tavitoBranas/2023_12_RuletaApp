package UI;

import Controlador.LogInCrupierVistaControlador;
import Controlador.LogInVistaControlador;
import Dominio.Crupier;
import Dominio.Usuario;

public class Dialogo_LogInCrupier extends Dialogo_LogIn {

    private LogInCrupierVistaControlador controlador;

    public Dialogo_LogInCrupier(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Ingrese las credenciales del crupier");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void ejecutarCasoInicial(Usuario usuario) {
        Dialogo_IniciarMesaCrupier iniciarMesa = new Dialogo_IniciarMesaCrupier(new javax.swing.JFrame(), true, (Crupier) usuario);
        iniciarMesa.setModal(false);
        iniciarMesa.setVisible(true);
    }

    @Override
    protected LogInVistaControlador crearControlador() {
        return new LogInCrupierVistaControlador(this);
    }
}
