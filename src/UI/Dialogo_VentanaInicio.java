package UI;

public class Dialogo_VentanaInicio extends javax.swing.JFrame {

    public Dialogo_VentanaInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Seleccione Tipo de Usuario"); 
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mLoginJugador = new javax.swing.JMenuItem();
        mLoginCrupier = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido a Sistema de Agendas");

        jMenu1.setText("Usuario");

        mLoginJugador.setText("Login Jugador");
        mLoginJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoginJugadorActionPerformed(evt);
            }
        });
        jMenu1.add(mLoginJugador);

        mLoginCrupier.setText("Login Crupier");
        mLoginCrupier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoginCrupierActionPerformed(evt);
            }
        });
        jMenu1.add(mLoginCrupier);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mLoginJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoginJugadorActionPerformed
        new Dialogo_LogInJugador(this, false).setVisible(true);
    }//GEN-LAST:event_mLoginJugadorActionPerformed

    private void mLoginCrupierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoginCrupierActionPerformed
        new Dialogo_LogInCrupier(this, false).setVisible(true);
    }//GEN-LAST:event_mLoginCrupierActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mLoginCrupier;
    private javax.swing.JMenuItem mLoginJugador;
    // End of variables declaration//GEN-END:variables

}
