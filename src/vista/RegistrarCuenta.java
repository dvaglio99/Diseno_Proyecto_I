
package vista;

import dao.ClienteDAO;
import dao.CuentaDAO;


/**
 * Vista del registro del curso
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class RegistrarCuenta extends javax.swing.JFrame {

  public RegistrarCuenta() {
    initComponents();
    agregarEstadoCuenta();
    seleccionarClienteParaLaCuenta();



  }

  public void agregarEstadoCuenta() {
      cbxEstadoCuenta.addItem("Activa");
      cbxEstadoCuenta.addItem("Inactiva");

  }

  public void seleccionarClienteParaLaCuenta(){

    CuentaDAO dao = new CuentaDAO();
    cbxCliente.setModel(dao.llenarComboBoxRegistroCuenta());
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistroCurso = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNombreEscuela = new javax.swing.JLabel();
        lblSegundoApellido = new javax.swing.JLabel();
        lblNombre4 = new javax.swing.JLabel();
        btnRegistrarCuenta = new javax.swing.JButton();
        btnLimpiarCampos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblNombre5 = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        txtFechaCreacion = new javax.swing.JTextField();
        txtSaldoCuenta = new javax.swing.JTextField();
        txtPIN = new javax.swing.JPasswordField();
        cbxCliente = new javax.swing.JComboBox<>();
        cbxEstadoCuenta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRegistroCurso.setBackground(new java.awt.Color(0, 153, 153));

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Registro de una Cuenta a un Cliente");

        lblNombreEscuela.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombreEscuela.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela.setText("Ingrese el PIN");

        lblSegundoApellido.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblSegundoApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblSegundoApellido.setText("Seleccione el cliente a registrar");

        lblNombre4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombre4.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre4.setText("Ingrese la fecha de creacion (dd-MM-yyyy) ");

        btnRegistrarCuenta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnRegistrarCuenta.setText("Registrar");
        btnRegistrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCuentaActionPerformed(evt);
            }
        });

        btnLimpiarCampos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnLimpiarCampos.setText("Limpiar campos");
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblNombre5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombre5.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre5.setText("Ingrese el saldo de la cuenta");

        lblNombre6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombre6.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre6.setText("Seleccione el estado de la cuenta");

        txtFechaCreacion.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        txtSaldoCuenta.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelRegistroCursoLayout = new javax.swing.GroupLayout(panelRegistroCurso);
        panelRegistroCurso.setLayout(panelRegistroCursoLayout);
        panelRegistroCursoLayout.setHorizontalGroup(
            panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSegundoApellido)
                    .addComponent(lblNombre4)
                    .addComponent(lblNombre5)
                    .addComponent(lblNombre6)
                    .addComponent(lblNombreEscuela))
                .addGap(49, 49, 49)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnRegistrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarCampos))
                    .addComponent(txtFechaCreacion)
                    .addComponent(txtSaldoCuenta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPIN)
                    .addComponent(cbxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxEstadoCuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addGap(179, 179, 179)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRegistroCursoLayout.setVerticalGroup(
            panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroCursoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo)
                        .addGap(18, 18, 18)))
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEstadoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRegistroCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRegistroCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCuentaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnRegistrarCuentaActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
                                         
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLimpiarCampos;
    public javax.swing.JButton btnRegistrarCuenta;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> cbxCliente;
    public javax.swing.JComboBox<String> cbxEstadoCuenta;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombreEscuela;
    private javax.swing.JLabel lblSegundoApellido;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelRegistroCurso;
    public javax.swing.JTextField txtFechaCreacion;
    public javax.swing.JPasswordField txtPIN;
    public javax.swing.JTextField txtSaldoCuenta;
    // End of variables declaration//GEN-END:variables
}
