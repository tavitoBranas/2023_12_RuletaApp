package UI;

import Controlador.JugarVistaControlador;
import Dominio.Estadistica;
import Dominio.Jugador;
import Dominio.Mesa;
import java.util.ArrayList;
import UI.Interface.JugarVista;
import componente.PanelRuleta;
import javax.swing.JOptionPane;

public class Dialogo_Jugar extends Dialogo_GeneralVista implements JugarVista {

    public JugarVistaControlador controlador;

    public Dialogo_Jugar(java.awt.Frame parent, boolean modal, Mesa mesa, Jugador jugador) {
        super(parent, modal);
        initComponents();
        controlador = new JugarVistaControlador(this, mesa, jugador);
        this.setTitle("Aplicacion jugador");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lNombreUsuario = new javax.swing.JLabel();
        tNombreJugador = new javax.swing.JLabel();
        bAbandonar = new javax.swing.JButton();
        tSaldo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        tMesa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tRonda = new javax.swing.JLabel();
        tMensaje = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        r = new componente.PanelRuleta();
        lNombreUsuario1 = new javax.swing.JLabel();
        tNumeroSorteado = new javax.swing.JLabel();
        tPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lNombreUsuario.setText("Saldo:");

        tNombreJugador.setText("**");

        bAbandonar.setText("Abandonar");
        bAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAbandonarActionPerformed(evt);
            }
        });

        tSaldo.setText("**");

        jLabel2.setText("Mesa:");

        tMesa.setText("**");

        jLabel1.setText("Ronda:");

        tRonda.setText("**");

        lNombreUsuario1.setText("Numero sorteado");

        javax.swing.GroupLayout tPanelLayout = new javax.swing.GroupLayout(tPanel);
        tPanel.setLayout(tPanelLayout);
        tPanelLayout.setHorizontalGroup(
            tPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );
        tPanelLayout.setVerticalGroup(
            tPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tRonda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(91, 91, 91)
                .addComponent(tNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(tMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(583, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lNombreUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tNumeroSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bAbandonar))))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNombreUsuario)
                    .addComponent(tNombreJugador)
                    .addComponent(jLabel2)
                    .addComponent(tMesa)
                    .addComponent(jLabel1)
                    .addComponent(tRonda)
                    .addComponent(tSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNombreUsuario1)
                    .addComponent(tNumeroSorteado))
                .addGap(9, 9, 9)
                .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(tPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAbandonar)
                .addGap(1, 1, 1)
                .addComponent(tMensaje)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAbandonarActionPerformed
        controlador.abandonarMesa();
    }//GEN-LAST:event_bAbandonarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAbandonar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lNombreUsuario;
    private javax.swing.JLabel lNombreUsuario1;
    private componente.PanelRuleta r;
    private javax.swing.JLabel tMensaje;
    private javax.swing.JLabel tMesa;
    private javax.swing.JLabel tNombreJugador;
    private javax.swing.JLabel tNumeroSorteado;
    private javax.swing.JPanel tPanel;
    private javax.swing.JLabel tRonda;
    private javax.swing.JLabel tSaldo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarDatos(Mesa mesa, Jugador jugador) {
        tNombreJugador.setText(jugador.getNombre());
        tSaldo.setText("$ " + jugador.getSaldo() + "");
        tMesa.setText(mesa.getNombre());
        tRonda.setText(mesa.getEstadistica().getNumeroDeRonda() + "");
    }

    @Override
    public void cargarMensaje(Mesa mesa) {
        tMensaje.setText(mesa.getMensaje());
        JOptionPane.showMessageDialog(null, "ATENCION: " + mesa.getMensaje(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        controlador.mensajeAceptado();
    }

    @Override
    public void inhabilitarApuestasEspecificas(ArrayList<String> apuestas) {

        //seteo todo en false
        r.setVisible(PanelRuleta.ROJO, false);
        r.setVisible(PanelRuleta.NEGRO, false);
        r.setVisible(PanelRuleta.PRIMERA_DOCENA, false);
        r.setVisible(PanelRuleta.SEGUNDA_DOCENA, false);
        r.setVisible(PanelRuleta.TERCERA_DOCENA, false);

        if (apuestas.contains("Color")) {
            r.setVisible(PanelRuleta.ROJO, true);
            r.setVisible(PanelRuleta.NEGRO, true);
        }
        if (apuestas.contains("Docena")) {
            r.setVisible(PanelRuleta.PRIMERA_DOCENA, true);
            r.setVisible(PanelRuleta.SEGUNDA_DOCENA, true);
            r.setVisible(PanelRuleta.TERCERA_DOCENA, true);
        }
    }

    @Override
    public void mostrarNumeroGanador(int numeroGanador) {
        tNumeroSorteado.setText(numeroGanador + "");
    }

    @Override
    public void ocultarNumeroGanador() {
        tNumeroSorteado.setText("");
    }

    @Override
    public void actualizarNumerosYronda(Estadistica estadistica) {
        tRonda.setText(estadistica.getNumeroDeRonda() + "");
    }
}
