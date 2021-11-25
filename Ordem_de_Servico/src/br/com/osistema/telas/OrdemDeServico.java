package br.com.osistema.telas;

import java.sql.*;
import br.com.osistema.dal.ModuloConexao;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class OrdemDeServico extends javax.swing.JInternalFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private String tipo;

    public OrdemDeServico() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void pesquisarClientes() {
        String sql = "SELECT client_id  AS 'ID', nome_cli AS Nome, email_cli AS 'Email', end_cli AS 'Endereço', fone_cli AS 'Telefone' FROM client WHERE nome_cli LIKE ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPesquisa.getText() + "%");
            rs = pst.executeQuery();
            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void pesquisarOS() {
        String numOS = JOptionPane.showInputDialog("Número da Ordem de Serviço: ");
        String sql = "SELECT * FROM ordem_servico WHERE os = " + numOS;
        
        try {
            pst = conexao.prepareStatement(sql);            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                txtOS.setText(rs.getString(1));
                txtDataOS.setText(rs.getString(2)); 
                
                String radioTipo = rs.getString(3);
                if (radioTipo.equals("Ordem de Serviço")) {
                    radioOrdemDeServico.setSelected(true);
                    tipo = "Ordem de Serviço";
                } else {
                    radioOrcamento.setSelected(true);
                    tipo = "Orçamento";
                }
                
                cmbSituacao.setSelectedItem(rs.getString(4));
                txtEquipamento.setText(rs.getString(5));
                txtDefeito.setText(rs.getString(6));
                txtServico.setText(rs.getString(7));
                txtTecnico.setText(rs.getString(8));
                txtValorTotal.setText(rs.getString(9));
                txtID.setText(rs.getString(10));
                
                btnInsert.setEnabled(false);
                txtPesquisa.setEnabled(false);
                tblClientes.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Ordem de serviço indisponível ou não cadastrada.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void setarCampos() {
        int setar = tblClientes.getSelectedRow();

        txtID.setText(tblClientes.getModel().getValueAt(setar, 0).toString());    
    }

    private void emitirOS() {
        String sql = "INSERT INTO `ordem_servico` (`tipo`, `situacao`, `equipamento`, `defeito`, `servico`, `tecnico`, `valor`, `client_id`) VALUES ('', '', '', '', '', '', '', '')";
        
        try {
            pst = conexao.prepareStatement(sql);
           
            pst.setString(1, tipo);
            pst.setString(2, cmbSituacao.getSelectedItem().toString());  
            pst.setString(3, txtEquipamento.getText());    
            pst.setString(4, txtDefeito.getText());       
            pst.setString(5, txtServico.getText());    
            pst.setString(6, txtTecnico.getText());   
            pst.setString(7, txtValorTotal.getText());    
            pst.setString(8, txtID.getText());   
                        
            if (txtEquipamento.getText().isEmpty() || txtDefeito.getText().isEmpty() ||  txtID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Ordem de Serviço adicionada com sucesso");
                    limpar();  
                } 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void limpar() {
        txtPesquisa.setText(null);
        txtID.setText(null);
        txtDefeito.setText(null);
        txtEquipamento.setText(null);
        txtServico.setText(null);
        txtTecnico.setText(null);
        txtValorTotal.setText(null);
        ((DefaultTableModel) tblClientes.getModel()).setRowCount(0);
    }
    
    @SuppressWarnings("unchecked")    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoOrdemOrcamento = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOS = new javax.swing.JTextField();
        txtDataOS = new javax.swing.JTextField();
        radioOrdemDeServico = new javax.swing.JRadioButton();
        radioOrcamento = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        cmbSituacao = new javax.swing.JComboBox<>();
        PainelCliente = new javax.swing.JPanel();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblEquipamento = new javax.swing.JLabel();
        lblDefeito = new javax.swing.JLabel();
        lblServico = new javax.swing.JLabel();
        lblTecnico = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        txtEquipamento = new javax.swing.JTextField();
        txtDefeito = new javax.swing.JTextField();
        txtServico = new javax.swing.JTextField();
        txtTecnico = new javax.swing.JTextField();
        txtValorTotal = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Ordem de Serviç");
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(590, 470));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setAutoscrolls(true);
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(573, 680));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("N.º OS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Data");

        txtOS.setEditable(false);
        txtOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtDataOS.setEditable(false);
        txtDataOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnGrupoOrdemOrcamento.add(radioOrdemDeServico);
        radioOrdemDeServico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioOrdemDeServico.setText("Ordem de Serviço");
        radioOrdemDeServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOrdemDeServicoActionPerformed(evt);
            }
        });

        btnGrupoOrdemOrcamento.add(radioOrcamento);
        radioOrcamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioOrcamento.setText("Orçamento");
        radioOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOrcamentoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Situação");

        cmbSituacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Entregue", "Orçamento Reprovado", "Aguardando Aprovação", "Aguardando Peças", "Abandonado", "Na bancada", "Retornado" }));

        PainelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        txtPesquisa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone"
            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        lblID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblID.setText("ID");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osistema/icones/search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelClienteLayout = new javax.swing.GroupLayout(PainelCliente);
        PainelCliente.setLayout(PainelClienteLayout);
        PainelClienteLayout.setHorizontalGroup(
            PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelClienteLayout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(lblID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        PainelClienteLayout.setVerticalGroup(
            PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelClienteLayout.createSequentialGroup()
                .addGroup(PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelClienteLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblID))))
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEquipamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEquipamento.setText("Equipamento");

        lblDefeito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDefeito.setText("Defeito");

        lblServico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblServico.setText("Serviço");

        lblTecnico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTecnico.setText("Técnico");

        lblValorTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblValorTotal.setText("Valor Total");

        txtEquipamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtDefeito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtServico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtTecnico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtValorTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osistema/icones/create.png"))); // NOI18N
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osistema/icones/read.png"))); // NOI18N
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osistema/icones/update.png"))); // NOI18N

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osistema/icones/delete.png"))); // NOI18N

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/osistema/icones/print.png"))); // NOI18N
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(txtDataOS, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRead)
                        .addGap(10, 10, 10)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(PainelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblEquipamento)
                                .addComponent(lblDefeito)
                                .addComponent(lblServico)
                                .addComponent(lblTecnico))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtTecnico)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblValorTotal)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtEquipamento)
                                .addComponent(txtDefeito)
                                .addComponent(txtServico))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioOrcamento)
                        .addGap(40, 40, 40)
                        .addComponent(radioOrdemDeServico)))
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(btnPrint)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDataOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioOrcamento)
                    .addComponent(radioOrdemDeServico))
                .addGap(32, 32, 32)
                .addComponent(PainelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquipamento)
                    .addComponent(txtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDefeito)
                    .addComponent(txtDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServico)
                    .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTecnico)
                    .addComponent(lblValorTotal)
                    .addComponent(txtTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInsert)
                    .addComponent(btnRead)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrint)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.PAGE_START);

        getAccessibleContext().setAccessibleName("Ordem de Serviço");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        pesquisarClientes();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void radioOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOrcamentoActionPerformed
        tipo = "Orçamento";
    }//GEN-LAST:event_radioOrcamentoActionPerformed

    private void radioOrdemDeServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOrdemDeServicoActionPerformed
        tipo = "Ordem de Serviço";
    }//GEN-LAST:event_radioOrdemDeServicoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        radioOrcamento.setSelected(true);
        tipo = "Orçamento";
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        //imprimirOS();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        emitirOS();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        pesquisarOS();
    }//GEN-LAST:event_btnReadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelCliente;
    private javax.swing.JButton btnDelete;
    private javax.swing.ButtonGroup btnGrupoOrdemOrcamento;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDefeito;
    private javax.swing.JLabel lblEquipamento;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblServico;
    private javax.swing.JLabel lblTecnico;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JRadioButton radioOrcamento;
    private javax.swing.JRadioButton radioOrdemDeServico;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtDataOS;
    private javax.swing.JTextField txtDefeito;
    private javax.swing.JTextField txtEquipamento;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtOS;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtServico;
    private javax.swing.JTextField txtTecnico;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
