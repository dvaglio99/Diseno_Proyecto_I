package vista;

import dao.CuentaDAO;


/**
 * Vista para realizar un retiro
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class RealizarRetiroDolares extends javax.swing.JFrame {
  public RealizarRetiroDolares() {
    initComponents();
    llenarCbxCuentas();
  }

  /**
   * Metodo para llenar el ComboBox de cuentas
   */
  public void llenarCbxCuentas() {
    CuentaDAO cuentaDao = new CuentaDAO();
    cbxCuentas.setModel(cuentaDao.llenarComboBox());
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConsulta = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNombreEscuela = new javax.swing.JLabel();
        cbxCuentas = new javax.swing.JComboBox<>();
        btnRetirar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblNombreEscuela2 = new javax.swing.JLabel();
        lblNombreEscuela4 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        txtPropietarioCuenta = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        txtCantidadOperaciones = new javax.swing.JTextField();
        lblNombreEscuela5 = new javax.swing.JLabel();
        lblNumOp = new javax.swing.JLabel();
        lblNombreEscuela6 = new javax.swing.JLabel();
        txtPIN = new javax.swing.JPasswordField();
        btnVerificarPIN = new javax.swing.JButton();
        lblNombreEscuela7 = new javax.swing.JLabel();
        txtPINNoModificable = new javax.swing.JPasswordField();
        lblNombreEscuela8 = new javax.swing.JLabel();
        txtNumeroTelefonicoCliente = new javax.swing.JTextField();
        lblNombreEscuela9 = new javax.swing.JLabel();
        txtPalabraClave = new javax.swing.JTextField();
        lblNombreEscuela10 = new javax.swing.JLabel();
        txtPalabraClaveNoModificable = new javax.swing.JPasswordField();
        btnVerificarPalabraClave = new javax.swing.JButton();
        lblNombreEscuela11 = new javax.swing.JLabel();
        txtSaldoNoModificable = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelConsulta.setBackground(new java.awt.Color(0, 102, 102));

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Realizar Retiro en Dolares");

        lblNombreEscuela.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela.setText("Seleccione un numero de cuenta existente : ");

        cbxCuentas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCuentasActionPerformed(evt);
            }
        });

        btnRetirar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnRetirar.setText("Retirar");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblNombreEscuela2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela2.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela2.setText("Ingrese el monto en dolares a retirar de la cuenta:");

        lblNombreEscuela4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela4.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela4.setText("Propietario de la cuenta:");

        btnBuscarCliente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        lblNombreEscuela5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela5.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela5.setText("Cantidad de operaciones efectuadas por el cliente:");

        lblNumOp.setText("OP: ");

        lblNombreEscuela6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela6.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela6.setText("PIN de la cuenta:");

        btnVerificarPIN.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnVerificarPIN.setText("Verificar PIN");
        btnVerificarPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarPINActionPerformed(evt);
            }
        });

        lblNombreEscuela7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela7.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela7.setText("Ingrese el PIN de la cuenta:");

        lblNombreEscuela8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela8.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela8.setText("Telefono del propietario de la cuenta:");

        lblNombreEscuela9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela9.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela9.setText("Palabra clave enviada por SMS: ");

        lblNombreEscuela10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela10.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela10.setText("Ingrese la palabra clave enviada por SMS: ");

        btnVerificarPalabraClave.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnVerificarPalabraClave.setText("Verificar Palabra Clave");
        btnVerificarPalabraClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarPalabraClaveActionPerformed(evt);
            }
        });

        lblNombreEscuela11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela11.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela11.setText("Saldo de la cuenta:");

        javax.swing.GroupLayout panelConsultaLayout = new javax.swing.GroupLayout(panelConsulta);
        panelConsulta.setLayout(panelConsultaLayout);
        panelConsultaLayout.setHorizontalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultaLayout.createSequentialGroup()
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelConsultaLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreEscuela)
                                    .addComponent(lblNombreEscuela2)
                                    .addComponent(lblNombreEscuela4)
                                    .addComponent(lblNombreEscuela5)
                                    .addComponent(lblNombreEscuela6)
                                    .addComponent(lblNombreEscuela7)
                                    .addComponent(lblNombreEscuela8)
                                    .addComponent(lblNombreEscuela9)
                                    .addComponent(lblNombreEscuela11)))
                            .addGroup(panelConsultaLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(lblNombreEscuela10)))
                        .addGap(31, 31, 31)
                        .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCuentas, 0, 308, Short.MAX_VALUE)
                            .addComponent(txtPropietarioCuenta)
                            .addComponent(txtMonto)
                            .addComponent(txtCantidadOperaciones)
                            .addComponent(txtPIN)
                            .addComponent(txtPINNoModificable)
                            .addComponent(txtNumeroTelefonicoCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPalabraClave)
                            .addComponent(txtPalabraClaveNoModificable)
                            .addComponent(txtSaldoNoModificable, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)
                        .addGap(181, 181, 181)
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscarCliente)
                            .addComponent(btnVerificarPalabraClave)
                            .addComponent(btnVerificarPIN))))
                .addGap(152, 152, 152))
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNumOp, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(btnRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelConsultaLayout.setVerticalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo))
                .addGap(18, 18, 18)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCliente)
                .addGap(8, 8, 8)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPropietarioCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroTelefonicoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldoNoModificable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPINNoModificable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreEscuela7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerificarPIN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPalabraClaveNoModificable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPalabraClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreEscuela10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(btnVerificarPalabraClave)
                .addGap(18, 18, 18)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreEscuela5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreEscuela2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRetirar)
                .addGap(124, 124, 124)
                .addComponent(lblNumOp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCuentasActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetirarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnVerificarPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarPINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerificarPINActionPerformed

    private void btnVerificarPalabraClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarPalabraClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerificarPalabraClaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RealizarRetiroDolares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarRetiroDolares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarRetiroDolares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarRetiroDolares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarRetiroDolares().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarCliente;
    public javax.swing.JButton btnRetirar;
    public javax.swing.JButton btnVerificarPIN;
    public javax.swing.JButton btnVerificarPalabraClave;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> cbxCuentas;
    private javax.swing.JLabel lblNombreEscuela;
    private javax.swing.JLabel lblNombreEscuela10;
    private javax.swing.JLabel lblNombreEscuela11;
    private javax.swing.JLabel lblNombreEscuela2;
    private javax.swing.JLabel lblNombreEscuela4;
    private javax.swing.JLabel lblNombreEscuela5;
    private javax.swing.JLabel lblNombreEscuela6;
    private javax.swing.JLabel lblNombreEscuela7;
    private javax.swing.JLabel lblNombreEscuela8;
    private javax.swing.JLabel lblNombreEscuela9;
    public javax.swing.JLabel lblNumOp;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelConsulta;
    public javax.swing.JTextField txtCantidadOperaciones;
    public javax.swing.JTextField txtMonto;
    public javax.swing.JTextField txtNumeroTelefonicoCliente;
    public javax.swing.JPasswordField txtPIN;
    public javax.swing.JPasswordField txtPINNoModificable;
    public javax.swing.JTextField txtPalabraClave;
    public javax.swing.JPasswordField txtPalabraClaveNoModificable;
    public javax.swing.JTextField txtPropietarioCuenta;
    public javax.swing.JPasswordField txtSaldoNoModificable;
    // End of variables declaration//GEN-END:variables
}
