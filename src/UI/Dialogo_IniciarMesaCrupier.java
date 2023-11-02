package UI;

import Controlador.IniciarMesaVistaControlador;
import Controlador.UnirseAmesaVistaControlador;
import Dominio.TipoApuesta;
import UI.Interface.IniciarMesaVista;
import java.util.ArrayList;

public class Dialogo_IniciarMesaCrupier extends Dialogo_GeneralVista implements IniciarMesaVista{

    private IniciarMesaVistaControlador controlador;
    
    public Dialogo_IniciarMesaCrupier(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controlador = new IniciarMesaVistaControlador(this);
        this.setTitle("Aplicacion Crupier: Iniciar mesa");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ckApuestaColor = new javax.swing.JCheckBox();
        ckApuestaDocena = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTipos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        bIniciarMesa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Seleccione Tipos de apuesta para iniciar una mesa");

        ckApuestaColor.setText("Apuesta de color");
        ckApuestaColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckApuestaColorActionPerformed(evt);
            }
        });

        ckApuestaDocena.setText("Apuesta docena");

        jScrollPane1.setViewportView(listaTipos);

        jLabel2.setText("Apuesta directa");

        bIniciarMesa.setText("Iniciar Mesa");
        bIniciarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ckApuestaColor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(bIniciarMesa)
                                        .addComponent(ckApuestaDocena)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ckApuestaColor)
                        .addGap(18, 18, 18)
                        .addComponent(ckApuestaDocena))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(bIniciarMesa)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ckApuestaColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckApuestaColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckApuestaColorActionPerformed

    private void bIniciarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarMesaActionPerformed
        // TODO add your handling code here:
        controlador.crearMesa("Mesa prueba");
    }//GEN-LAST:event_bIniciarMesaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bIniciarMesa;
    private javax.swing.JCheckBox ckApuestaColor;
    private javax.swing.JCheckBox ckApuestaDocena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaTipos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarTiposApuesta(ArrayList<TipoApuesta> tipos) {
        //aca deberia cargar los tipos de apuesta que existan, como lo cargo en un selector??
    }
}
