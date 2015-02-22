/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDialogLogin.java
 *
 * Created on 21/04/2011, 16:46:04
 */

package siscadfj.view;

import javax.swing.JOptionPane;
import siscadfj.model.Usuario;
import siscadfj.controller.UsuarioBD;

/**
 *
 * @author stevao
 */
public class JDialogLogin extends javax.swing.JDialog {

    /** Creates new form JDialogLogin */
    public JDialogLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciar();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonOk = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelSenha = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelSenha.setText("Senha:");

        jLabelUsuario.setText("Usuario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsuario)
                            .addComponent(jLabelSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButtonOk, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar)
                        .addGap(15, 15, 15)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelSenha))
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-359)/2, (screenSize.height-186)/2, 359, 186);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // TODO add your handling code here:

        getDadosDialogLogin(); //Pegou usuario e senha

        UsuarioBD instancia = new UsuarioBD();

        Usuario usuario = new Usuario("","");

        usuario = instancia.getUserPass();

        if(usuario.getUser().equals(jTextFieldUsuario.getText()) &&
                usuario.getPass().equals(jPasswordFieldSenha.getText())){
            //Fechar frame de login e abrir frame principal.
            this.setVisible(false);
            JFramePrinciapal frame =new JFramePrinciapal();
            frame.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(this, "Usuario ou Senha incorretos!", "Alerta", JOptionPane.WARNING_MESSAGE);




    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:

        //Metodo para sair
        int i = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Fechar", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_NO_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogLogin dialog = new JDialogLogin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

    private Usuario getDadosDialogLogin(){
        Usuario usuario = new Usuario(null, null);
        usuario.setUser((this.jTextFieldUsuario.getText()));
        usuario.setPass((this.jPasswordFieldSenha.getText()));

        return usuario;
    }

    private void iniciar(){
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setModal(true);
        this.setResizable(false);
    }
}
