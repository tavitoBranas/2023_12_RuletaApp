package UI;

import Controlador.JugarVistaControlador;
import Dominio.ApuestaColor;
import Dominio.ApuestaDocena;
import Dominio.BalanceJugador;
import Dominio.Jugador;
import Dominio.Mesa;
import UI.Interface.JugarVista;
import componente.PanelRuleta;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
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
        lNombreUsuario1 = new javax.swing.JLabel();
        tNumeroSorteado = new javax.swing.JLabel();
        panelRuleta2 = new componente.PanelRuleta();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEstadistica = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResumenJugador = new javax.swing.JTable();
        tMensajeMesa = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

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

        tblEstadistica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Valor", "Ocurrencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblEstadistica);

        tblResumenJugador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ronda", "Apostado", "Ganado", "Perdido", "Balance"
            }
        ));
        jScrollPane1.setViewportView(tblResumenJugador);

        tMensajeMesa.setText("**");

        jTextField1.setText("50");

        jCheckBox2.setText("Apostar en seleccion");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(tMensajeMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bAbandonar)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(panelRuleta2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lNombreUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tNumeroSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(214, 214, 214))))
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
                .addGap(18, 18, 18)
                .addComponent(panelRuleta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAbandonar)
                    .addComponent(tMensajeMesa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tMensaje)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAbandonarActionPerformed
        controlador.abandonarMesa();
    }//GEN-LAST:event_bAbandonarActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            panelRuleta2.agregar(new PanelRuleta.Escuchador() {
                @Override
                public void celdaSeleccionada(int universalCellCode) {
                    int apuesta = Integer.valueOf(jTextField1.getText());
                    System.out.println("Id de celda seleccionada: " + universalCellCode + ". Apuesta anterior: " + panelRuleta2.getApuesta(universalCellCode) + ". Apuesta nueva:" + apuesta);
                    controlador.apostar(universalCellCode, apuesta);
                    //panelRuleta2.setApuesta(universalCellCode, apuesta);
                }
            });
        } else {
            panelRuleta2.eliminarEscuchadores();
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAbandonar;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lNombreUsuario;
    private javax.swing.JLabel lNombreUsuario1;
    private componente.PanelRuleta panelRuleta2;
    private javax.swing.JLabel tMensaje;
    private javax.swing.JLabel tMensajeMesa;
    private javax.swing.JLabel tMesa;
    private javax.swing.JLabel tNombreJugador;
    private javax.swing.JLabel tNumeroSorteado;
    private javax.swing.JLabel tRonda;
    private javax.swing.JLabel tSaldo;
    private javax.swing.JTable tblEstadistica;
    private javax.swing.JTable tblResumenJugador;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarDatos(Mesa mesa, Jugador jugador) {
        tNombreJugador.setText(jugador.getNombre());
        tSaldo.setText(jugador.getSaldo() + "");
        tMesa.setText(mesa.getNombre());
        tMensajeMesa.setText("");
        tRonda.setText(mesa.getEstadistica().getNumeroDeRonda() + "");
        actualizarApuestas(mesa);
        actualizarEstadisticaYronda(mesa);
    }

    @Override
    public void cargarMensaje(String mensaje) {
        tMensajeMesa.setText("");
        tMensajeMesa.setText(mensaje);
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
    public void actualizarEstadisticaYronda(Mesa mesa) {
        actualizarEstadistica(mesa.getEstadistica().estadisticasDeLaMesa());
    }

    private void actualizarApuestas(Mesa mesa) {
        if (mesa.getTipoApuesta().stream().anyMatch(apuesta -> apuesta instanceof ApuestaColor)) {
            panelRuleta2.setVisible(PanelRuleta.NEGRO, true);
            panelRuleta2.setVisible(PanelRuleta.ROJO, true);
        }
        if (mesa.getTipoApuesta().stream().anyMatch(apuesta -> apuesta instanceof ApuestaDocena)) {
            panelRuleta2.setVisible(PanelRuleta.PRIMERA_DOCENA, true);
            panelRuleta2.setVisible(PanelRuleta.SEGUNDA_DOCENA, true);
            panelRuleta2.setVisible(PanelRuleta.TERCERA_DOCENA, true);
        }
    }

    private void actualizarEstadistica(Map<String, Integer> estadisticasDeLaMesa) {
        DefaultTableModel estadisticas = new DefaultTableModel();
        estadisticas.addColumn("Valor");
        estadisticas.addColumn("Ocurrencia");
        estadisticas.setRowCount(estadisticasDeLaMesa.size());
        int fila = 0;
        for (Map.Entry<String, Integer> inicio : estadisticasDeLaMesa.entrySet()) {
            String clave = inicio.getKey();
            Integer valor = inicio.getValue();

            estadisticas.setValueAt(clave, fila, 0);
            estadisticas.setValueAt(valor, fila, 1);
            fila++;
        }
        tblEstadistica.setModel(estadisticas);
    }

    @Override
    public void bloqueoApuestasYAbandono(String mensaje) {
        panelRuleta2.pausar();
        bAbandonar.setEnabled(false);
        cargarMensaje(mensaje);
    }

    @Override
    public void reactivarApuestasYAbandono(String mensaje) {
        panelRuleta2.limpiar();
        panelRuleta2.reanudar();
        bAbandonar.setEnabled(true);
        cargarMensaje(mensaje);
    }

    @Override
    public void apuestaRealizada(Jugador jugador) {
        tSaldo.setText(jugador.getSaldo() + "");
    }

    @Override
    public void actualizarBalanceJugador(Jugador jugador) {
        DefaultTableModel estadisticas = new DefaultTableModel();
        estadisticas.addColumn("Ronda");
        estadisticas.addColumn("Total apostado");
        estadisticas.addColumn("Ganado");
        estadisticas.addColumn("Perdido");
        estadisticas.addColumn("Balance");
        estadisticas.setRowCount(jugador.getHistoricoBalanceJugador().size());
        int fila = 0;
        for (BalanceJugador balance : jugador.getHistoricoBalanceJugador()) {
            estadisticas.setValueAt(balance.getRonda(), fila, 0);
            estadisticas.setValueAt(balance.getTotalApostado(), fila, 1);
            estadisticas.setValueAt(balance.getGanado(), fila, 2);
            estadisticas.setValueAt(balance.getPerdido(), fila, 3);
            estadisticas.setValueAt(balance.getBalance(), fila, 4);
            fila++;
        }
        tblResumenJugador.setModel(estadisticas);
    }

    @Override
    public void avisarMesaEstaPorCerrar(String mensaje) {
        cargarMensaje(mensaje);
        //TODO ver que este mensaje no bloquee acciones
        JOptionPane.showMessageDialog(this, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
        controlador.mensajeAceptado();
    }

    @Override
    public void aceptarApuesta(int monto, int casillero) {
        panelRuleta2.setApuesta(casillero, monto);
    }
}
