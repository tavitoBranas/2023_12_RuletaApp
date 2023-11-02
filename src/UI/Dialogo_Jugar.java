package UI;

import Controlador.JugarVistaControlador;
import Dominio.Jugador;
import Dominio.Mesa;
import UI.Interface.Jugar;
import java.util.ArrayList;


public class Dialogo_Jugar extends Dialogo_GeneralVista implements Jugar{

    public JugarVistaControlador controlador;

    public Dialogo_Jugar(java.awt.Frame parent, boolean modal, Mesa mesa) {
        super(parent, modal);
        initComponents();
        controlador = new JugarVistaControlador(this, mesa);
        this.setTitle("Aplicacion jugador");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lNombreUsuario = new javax.swing.JLabel();
        tNombreJugador = new javax.swing.JLabel();
        bAbandonar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lNombreUsuario.setText("Usuario");

        tNombreJugador.setText("tNombreJugador");

        bAbandonar.setText("Abandonar");
        bAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAbandonarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(lNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(tNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAbandonar)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNombreUsuario)
                    .addComponent(tNombreJugador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                .addComponent(bAbandonar)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAbandonarActionPerformed
        // TODO add your handling code here:
       // controlador.abandonarMesa(Mesa mesa);
    }//GEN-LAST:event_bAbandonarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAbandonar;
    private javax.swing.JLabel lNombreUsuario;
    private javax.swing.JLabel tNombreJugador;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarJugadores(ArrayList<Jugador> jugadores) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
