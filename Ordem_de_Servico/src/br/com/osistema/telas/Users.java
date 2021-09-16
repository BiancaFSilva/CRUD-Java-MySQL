package br.com.osistema.telas;
import java.sql.*;
import br.com.osistema.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class Users extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
            
    public Users() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void consultar() {
        String sql = "SELECT * FROM users WHERE user_id=?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtID.getText());
            rs = pst.executeQuery();
            
            if (rs.next()) {
                txtNome.setText(rs.getString(2));
                txtLogin.setText(rs.getString(3));
                txtSenha.setText(rs.getString(4));
                txtFone.setText(rs.getString(5));
                comboPerfil.setSelectedItem(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
                txtNome.setText(null);
                txtLogin.setText(null);
                txtSenha.setText(null);
                txtFone.setText(null);
                comboPerfil.setSelectedItem(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void adicionar() {
        String sql = "INSERT INTO users (user_id, user, login, senha, fone, perfil) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, txtID.getText());
            pst.setString(2, txtNome.getText());
            pst.setString(3, txtLogin.getText());
            String pega_senha = new String(txtSenha.getText()); 
            pst.setString(4, pega_senha);
            pst.setString(5, txtFone.getText());
            pst.setString(6, comboPerfil.getSelectedItem().toString());
                        
            if (txtID.getText().isEmpty() || txtNome.getText().isEmpty() || txtLogin.getText().isEmpty() || 
            txtSenha.getText().isEmpty() || txtFone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
                    txtNome.setText(null);
                    txtLogin.setText(null);
                    txtSenha.setText(null);
                    txtFone.setText(null);
                    comboPerfil.setSelectedItem(null);
                } 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
  
    private void excluir() {
        int excluir = JOptionPane.showConfirmDialog(null, "Tem certeza de que quer excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        
        if (excluir == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM users WHERE user_id=?";
        
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtID.getText());
                int apaga = pst.executeUpdate();

                if (apaga > 0) {                
                    JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso");
                    txtNome.setText(null);
                    txtLogin.setText(null);
                    txtSenha.setText(null);
                    txtFone.setText(null);
                    comboPerfil.setSelectedItem(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    private void editar() {
        String sql = "UPDATE users SET user=?, login=?, senha=?, fone=?, perfil=? WHERE user_id=?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtID.getText());
            pst.setString(2, txtNome.getText());
            pst.setString(3, txtLogin.getText());
            String pega_senha = new String(txtSenha.getText()); 
            pst.setString(4, pega_senha);
            pst.setString(5, txtFone.getText());
            pst.setString(6, comboPerfil.getSelectedItem().toString());

            if (txtID.getText().isEmpty() || txtNome.getText().isEmpty() || txtLogin.getText().isEmpty() || 
            txtSenha.getText().isEmpty() || txtFone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falha! Preencha todos os campos.");
            } else {        
                int atualiza = pst.executeUpdate();
                if (atualiza > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso");
                    txtNome.setText(rs.getString(2));
                    txtLogin.setText(rs.getString(3));
                    txtSenha.setText(rs.getString(4));
                    txtFone.setText(rs.getString(5));
                    comboPerfil.setSelectedItem(rs.getString(6));
                }                 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreate = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        lblFone = new javax.swing.JLabel();
        txtFone = new javax.swing.JTextField();
        lblPerfil = new javax.swing.JLabel();
        comboPerfil = new javax.swing.JComboBox<>();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(590, 470));
        setVisible(true);

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osistema/icones/create.png"))); // NOI18N
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osistema/icones/read.png"))); // NOI18N
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osistema/icones/update.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osistema/icones/delete.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblID.setLabelFor(txtID);
        lblID.setText("ID");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNome.setLabelFor(txtNome);
        lblNome.setText("Nome");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblLogin.setLabelFor(txtLogin);
        lblLogin.setText("Login");

        txtLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSenha.setLabelFor(txtSenha);
        lblSenha.setText("Senha");

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblFone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblFone.setLabelFor(txtFone);
        lblFone.setText("Fone");

        txtFone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblPerfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPerfil.setLabelFor(comboPerfil);
        lblPerfil.setText("Perfil");

        comboPerfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblID)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(lblNome)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogin)
                            .addComponent(lblFone, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFone, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtLogin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSenha)
                                    .addComponent(lblPerfil))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUpdate)
                                    .addComponent(btnCreate))
                                .addGap(42, 42, 42)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRead)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSenha)
                                .addComponent(comboPerfil, 0, 186, Short.MAX_VALUE))
                            .addComponent(btnDelete))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLogin)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSenha)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFone)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPerfil)
                    .addComponent(comboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreate)
                    .addComponent(btnRead))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        consultar();
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        adicionar();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        editar();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        excluir();
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboPerfil;
    private javax.swing.JLabel lblFone;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
