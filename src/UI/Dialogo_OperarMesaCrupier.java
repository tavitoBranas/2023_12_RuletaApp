package UI;

import Controlador.JugarVistaControlador;
import Controlador.OperarMesaVistaControlador;
import Dominio.Efecto;
import Dominio.Jugador;
import Dominio.Mesa;
import java.util.ArrayList;
import UI.Interface.JugarVista;
import UI.Interface.OperarMesaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Dialogo_OperarMesaCrupier extends Dialogo_GeneralVista implements OperarMesaVista {

    public OperarMesaVistaControlador controlador;

    public Dialogo_OperarMesaCrupier(java.awt.Frame parent, boolean modal, Mesa mesa) {
        super(parent, modal);
        initComponents();
        controlador = new OperarMesaVistaControlador(this, mesa);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lNombreUsuario = new javax.swing.JLabel();
        bCerrarMesa = new javax.swing.JButton();
        tSaldoMesa = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        tMesa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tRonda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lJugadores = new javax.swing.JList();
        cbEfecto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tApuestas = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tMonto = new javax.swing.JLabel();
        bLanzar = new javax.swing.JButton();
        tUltimoNumeroSorteado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tUltimosLanzamientos = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        bPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lNombreUsuario.setText("Balance");

        bCerrarMesa.setText("Cerrar mesa");
        bCerrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarMesaActionPerformed(evt);
            }
        });

        tSaldoMesa.setText("**");

        jLabel2.setText("Mesa:");

        tMesa.setText("**");

        jLabel1.setText("Ronda:");

        tRonda.setText("**");

        jScrollPane1.setViewportView(lJugadores);

        jLabel3.setText("Apuestas");

        tApuestas.setText("0");

        jLabel4.setText("Monto");

        tMonto.setText("0");

        bLanzar.setText("Lanzar");
        bLanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLanzarActionPerformed(evt);
            }
        });

        tUltimoNumeroSorteado.setText("0");

        jLabel5.setText("Ultimos lanzamientos");

        tUltimosLanzamientos.setText("0");

        bPagar.setText("Pagar");
        bPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tSaldoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tRonda, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(bCerrarMesa)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tApuestas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(cbEfecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(bLanzar)
                .addGap(18, 18, 18)
                .addComponent(bPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tUltimoNumeroSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tUltimosLanzamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNombreUsuario)
                    .addComponent(jLabel1)
                    .addComponent(tRonda)
                    .addComponent(tSaldoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tMesa)
                    .addComponent(bCerrarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEfecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tApuestas)
                    .addComponent(jLabel4)
                    .addComponent(tMonto)
                    .addComponent(bLanzar)
                    .addComponent(tUltimoNumeroSorteado)
                    .addComponent(bPagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tUltimosLanzamientos))
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCerrarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarMesaActionPerformed
        controlador.cerrarMesa();
    }//GEN-LAST:event_bCerrarMesaActionPerformed

    private void bLanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLanzarActionPerformed
        // TODO add your handling code here:
        String efectoSeleccionado = (String) cbEfecto.getSelectedItem();
        
        //arrayList de casilleros seleccionados
        ArrayList<Integer> casillerosSeleccionados = new ArrayList<>(Arrays.asList(1, 5, 18, 41, 42));
        
        if (efectoSeleccionado.contains("Efecto")) {
            mostrarMensajeError("Seleccione un efecto para continuar");
        } else {
            controlador.lanzar(efectoSeleccionado,casillerosSeleccionados);
        }
    }//GEN-LAST:event_bLanzarActionPerformed

    private void bPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bPagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrarMesa;
    private javax.swing.JButton bLanzar;
    private javax.swing.JButton bPagar;
    private javax.swing.JComboBox<String> cbEfecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JList lJugadores;
    private javax.swing.JLabel lNombreUsuario;
    private javax.swing.JLabel tApuestas;
    private javax.swing.JLabel tMesa;
    private javax.swing.JLabel tMonto;
    private javax.swing.JLabel tRonda;
    private javax.swing.JLabel tSaldoMesa;
    private javax.swing.JLabel tUltimoNumeroSorteado;
    private javax.swing.JLabel tUltimosLanzamientos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarDatosMesa(Mesa mesa) {
        tMesa.setText(mesa.getNombre());
        tRonda.setText("A DETERMINAR");
    }

    @Override
    public void cargarDatosJugadores(ArrayList<Jugador> jugadores) {

        ArrayList<String> datosAmostrar = new ArrayList<String>();

        for (Jugador jugador : jugadores) {
            datosAmostrar.add(jugador.getNombre() + " -- SALDO: " + jugador.getSaldo());
        }
        lJugadores.setListData(datosAmostrar.toArray());
    }

    @Override
    public void cargarEfectos(ArrayList<Efecto> efectos) {
        cbEfecto.removeAllItems();
        cbEfecto.addItem("<<Efecto>>");
        for (Efecto e : efectos) {
            cbEfecto.addItem(e.getNombre());
        }
        cbEfecto.setSelectedIndex(0);
    }

}
