package UI;

import Controlador.OperarMesaVistaControlador;
import Dominio.Efecto;
import Dominio.Estadistica;
import Dominio.Jugador;
import Dominio.Mesa;
import java.util.ArrayList;
import UI.Interface.OperarMesaVista;
import componente.PanelRuleta;

import java.util.Arrays;

public class Dialogo_OperarMesaCrupier extends Dialogo_GeneralVista implements OperarMesaVista {

    public OperarMesaVistaControlador controlador;

    public Dialogo_OperarMesaCrupier(java.awt.Frame parent, boolean modal, Mesa mesa) {
        super(parent, modal);
        initComponents();
        controlador = new OperarMesaVistaControlador(this, mesa);
        tUltimosLanzamientos.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        r = new componente.PanelRuleta();
        lNombreUsuario1 = new javax.swing.JLabel();
        tNumeroSorteado = new javax.swing.JLabel();
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
        jLabel5 = new javax.swing.JLabel();
        tUltimosLanzamientos = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        bPagar = new javax.swing.JButton();
        r1 = new componente.PanelRuleta();
        lNombreUsuario2 = new javax.swing.JLabel();
        tNumeroSorteado1 = new javax.swing.JLabel();

        lNombreUsuario1.setText("Numero sorteado");

        tNumeroSorteado.setText("**");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lNombreUsuario.setText("Balance");

        bCerrarMesa.setText("Cerrar mesa");
        bCerrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarMesaActionPerformed(evt);
            }
        });

        tSaldoMesa.setText("$ 0");

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

        jLabel5.setText("Ultimos lanzamientos");

        tUltimosLanzamientos.setText("0");

        bPagar.setText("Pagar");
        bPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPagarActionPerformed(evt);
            }
        });

        lNombreUsuario2.setText("Numero sorteado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tSaldoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tRonda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(lNombreUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tNumeroSorteado1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tUltimosLanzamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(r1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbEfecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(tApuestas)
                        .addComponent(jLabel4)
                        .addComponent(tMonto)
                        .addComponent(bLanzar)
                        .addComponent(bPagar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lNombreUsuario2)
                        .addComponent(tNumeroSorteado1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tUltimosLanzamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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
            controlador.lanzar(efectoSeleccionado, casillerosSeleccionados);
        }
    }//GEN-LAST:event_bLanzarActionPerformed

    private void bPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPagarActionPerformed
        // TODO add your handling code here:
        controlador.pagar();

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
    private javax.swing.JLabel lNombreUsuario1;
    private javax.swing.JLabel lNombreUsuario2;
    private componente.PanelRuleta r;
    private componente.PanelRuleta r1;
    private javax.swing.JLabel tApuestas;
    private javax.swing.JLabel tMesa;
    private javax.swing.JLabel tMonto;
    private javax.swing.JLabel tNumeroSorteado;
    private javax.swing.JLabel tNumeroSorteado1;
    private javax.swing.JLabel tRonda;
    private javax.swing.JLabel tSaldoMesa;
    private javax.swing.JLabel tUltimosLanzamientos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarDatosMesa(Mesa mesa) {
        tMesa.setText(mesa.getNombre());
        tRonda.setText(mesa.getEstadistica().getNumeroDeRonda() + "");
    }

    @Override
    public void cargarDatosJugadores(ArrayList<Jugador> jugadores) {

        ArrayList<String> datosAmostrar = new ArrayList<>();

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
        tNumeroSorteado1.setText(numeroGanador + "");
    }

    @Override
    public void ocultarNumeroGanador() {
        tNumeroSorteado1.setText("");
    }

    @Override
    public void actualizarNumerosYronda(Estadistica estadistica) {
        tRonda.setText(estadistica.getNumeroDeRonda() + "");

        String numerosSorteados = "";
        // se muestran los ultimos 15 numeros
        for (int i = 0; i < estadistica.getNumerosSorteados().size() && i < 15; i++) {
            numerosSorteados += estadistica.getNumerosSorteados().get(i) + "   ";
        }
        tUltimosLanzamientos.setText(numerosSorteados);
    }

    @Override
    public void estadoBotonLanzar(boolean estado) {
        
        bLanzar.setEnabled(estado);
        bPagar.setEnabled(!estado);
    }
}
