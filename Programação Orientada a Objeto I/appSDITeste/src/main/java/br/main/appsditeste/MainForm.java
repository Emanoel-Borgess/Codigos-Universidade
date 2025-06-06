/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.main.appsditeste;

import Frames.CLT;
import Frames.Horista;
import Frames.Teste;

/**
 *
 * @author sdc.daniel
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMArquivo = new javax.swing.JMenu();
        jMiSair = new javax.swing.JMenuItem();
        jMCadastro = new javax.swing.JMenu();
        jMICLT = new javax.swing.JMenuItem();
        jMIHorista = new javax.swing.JMenuItem();
        jMConsultar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FormPrincipal");
        setAlwaysOnTop(true);

        jMArquivo.setText("Arquivo");
        jMArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMArquivoActionPerformed(evt);
            }
        });

        jMiSair.setText("Sair");
        jMArquivo.add(jMiSair);

        jMenuBar1.add(jMArquivo);

        jMCadastro.setText("Cadastro");

        jMICLT.setText("CLT");
        jMICLT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICLTActionPerformed(evt);
            }
        });
        jMCadastro.add(jMICLT);

        jMIHorista.setText("Horista");
        jMIHorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIHoristaActionPerformed(evt);
            }
        });
        jMCadastro.add(jMIHorista);

        jMenuBar1.add(jMCadastro);

        jMConsultar.setText("Consultar");

        jMenuItem1.setText("Empregados");
        jMConsultar.add(jMenuItem1);

        jMenuBar1.add(jMConsultar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMICLTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICLTActionPerformed
        // TODO add your handling code here:
        Teste frm = new Teste();
        frm.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMICLTActionPerformed

    private void jMIHoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIHoristaActionPerformed
        // TODO add your handling code here:
        Horista frm = new Horista();
    }//GEN-LAST:event_jMIHoristaActionPerformed

    private void jMArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMArquivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMArquivoActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMArquivo;
    private javax.swing.JMenu jMCadastro;
    private javax.swing.JMenu jMConsultar;
    private javax.swing.JMenuItem jMICLT;
    private javax.swing.JMenuItem jMIHorista;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMiSair;
    // End of variables declaration//GEN-END:variables
}
