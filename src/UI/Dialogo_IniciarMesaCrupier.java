package UI;

import Controlador.IniciarMesaVistaControlador;
import Dominio.Crupier;
import Dominio.Mesa;
import Dominio.TipoApuesta;
import UI.Interface.IniciarMesaVista;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class Dialogo_IniciarMesaCrupier extends Dialogo_GeneralVista implements IniciarMesaVista {

    private IniciarMesaVistaControlador controlador;

    public Dialogo_IniciarMesaCrupier(java.awt.Frame parent, boolean modal, Crupier crupier) {
        super(parent, modal);
        initComponents();
        controlador = new IniciarMesaVistaControlador(this, crupier);
        this.setTitle("Aplicacion Crupier: Iniciar mesa");

        //AVISO QUE LA VENTANA SE CERRO
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                desloguearUsuario(crupier);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        bIniciarMesa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlTiposApuesta = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        bIniciarMesa.setText("Iniciar Mesa");
        bIniciarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarMesaActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione Tipos de apuesta para iniciar una mesa");

        jlTiposApuesta.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Apuesta Directa" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jlTiposApuesta);

        jLabel3.setText("Actualmente la Apuesta Directa es obligatoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bIniciarMesa)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bIniciarMesa)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bIniciarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarMesaActionPerformed
        // TODO add your handling code here:
        controlador.crearMesa(jlTiposApuesta.getSelectedValuesList());
    }//GEN-LAST:event_bIniciarMesaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bIniciarMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList jlTiposApuesta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarTiposApuesta(ArrayList<TipoApuesta> tipos) {
        ArrayList<String> tiposApuestas = new ArrayList<>();
        for (TipoApuesta tipo : tipos) {
            tiposApuestas.add(tipo.getTipo());
        }
        jlTiposApuesta.setListData(tiposApuestas.toArray());
    }

    @Override
    public void ejecutarCasoOperarMesa(Mesa mesa) {
        Dialogo_OperarMesaCrupier operarMesa = new Dialogo_OperarMesaCrupier(new javax.swing.JFrame(), true, mesa);
        operarMesa.setModal(false);
        operarMesa.setVisible(true);
    }

    private void desloguearUsuario(Crupier crupier) {
        controlador.desloguearUsuario(crupier);
    }
}
