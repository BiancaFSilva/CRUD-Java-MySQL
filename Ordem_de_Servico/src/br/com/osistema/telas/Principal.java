package br.com.osistema.telas;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Desktop = new javax.swing.JDesktopPane();
        lblUser = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        opCliente = new javax.swing.JMenuItem();
        opOS = new javax.swing.JMenuItem();
        opUsers = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        opServicos = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        opSobre = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        opSair = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUser.setText("Usuário");

        lblData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblData.setText("Data");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osistema/icones/x.png"))); // NOI18N

        jMenu2.setText("Cadastro");

        opCliente.setText("Cliente");
        jMenu2.add(opCliente);

        opOS.setText("OS");
        opOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opOSActionPerformed(evt);
            }
        });
        jMenu2.add(opOS);

        opUsers.setText("Usuários");
        jMenu2.add(opUsers);

        Menu.add(jMenu2);

        jMenu3.setText("Relatórios");

        opServicos.setText("Serviços");
        jMenu3.add(opServicos);

        Menu.add(jMenu3);

        jMenu4.setText("Ajuda");

        opSobre.setText("Sobre");
        opSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opSobreActionPerformed(evt);
            }
        });
        jMenu4.add(opSobre);

        Menu.add(jMenu4);

        jMenu5.setText("Opções");

        opSair.setText("Sair");
        opSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opSairActionPerformed(evt);
            }
        });
        jMenu5.add(opSair);

        Menu.add(jMenu5);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser)
                            .addComponent(lblData))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(lblUser)
                .addGap(18, 18, 18)
                .addComponent(lblData)
                .addGap(118, 118, 118)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opOSActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        // lblData.setText(data.toString());
        lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void opSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza de que quer sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_opSairActionPerformed

    private void opSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opSobreActionPerformed
        Sobre sobre = new Sobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_opSobreActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblUser;
    private javax.swing.JMenuItem opCliente;
    private javax.swing.JMenuItem opOS;
    private javax.swing.JMenuItem opSair;
    private javax.swing.JMenuItem opServicos;
    private javax.swing.JMenuItem opSobre;
    private javax.swing.JMenuItem opUsers;
    // End of variables declaration//GEN-END:variables

}
