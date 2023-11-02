package UI;

import Controlador.UnirseAmesaVistaControlador;
import Dominio.Jugador;
import Dominio.Mesa;
import Excepciones.MesaException;
import UI.Interface.UnirseMesaVista;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Dialogo_UnirseAmesaJugador extends Dialogo_GeneralVista implements UnirseMesaVista {

    private final UnirseAmesaVistaControlador controlador;

    public Dialogo_UnirseAmesaJugador(java.awt.Frame parent, boolean modal, Jugador jugador) {
        super(parent, modal);
        initComponents();
        controlador = new UnirseAmesaVistaControlador(this, jugador);
        this.setTitle("Aplicacion jugador: Unirse a mesa");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lUnirseAmesa = new javax.swing.JLabel();
        lJugador = new javax.swing.JLabel();
        cbMesasDisponibles = new javax.swing.JComboBox<>();
        tNombreJugador = new javax.swing.JLabel();
        bUnirseYjugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lUnirseAmesa.setText("Unirse a la mesa");

        lJugador.setText("Jugador:");

        tNombreJugador.setText("tNombreJugador");

        bUnirseYjugar.setText("Unirse y jugar");
        bUnirseYjugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUnirseYjugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lUnirseAmesa, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMesasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(bUnirseYjugar)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lJugador)
                    .addComponent(tNombreJugador))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUnirseAmesa)
                    .addComponent(cbMesasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(bUnirseYjugar)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bUnirseYjugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUnirseYjugarActionPerformed
        // TODO add your handling code here:
         String mesaSeleccionada = (String) cbMesasDisponibles.getSelectedItem();
        controlador.unirseAmesa(mesaSeleccionada);
    }//GEN-LAST:event_bUnirseYjugarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bUnirseYjugar;
    private javax.swing.JComboBox<String> cbMesasDisponibles;
    private javax.swing.JLabel lJugador;
    private javax.swing.JLabel lUnirseAmesa;
    private javax.swing.JLabel tNombreJugador;
    // End of variables declaration//GEN-END:variables

    public void mostrarMesasAbiertas(ArrayList<Mesa> mesas) {
        cbMesasDisponibles.removeAllItems();
        for (Mesa mesa : mesas) {
            cbMesasDisponibles.addItem(mesa.getNombre());
        }
    }

    public void datosJugador(Jugador jugador) {
        tNombreJugador.setText(jugador.getNombre());
    }

}
