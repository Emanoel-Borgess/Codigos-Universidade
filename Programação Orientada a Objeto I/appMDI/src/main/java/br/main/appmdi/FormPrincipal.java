/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.main.appmdi;

import Formularios.CLT;
import Formularios.Empregados;
import Formularios.Horista;
import java.util.Scanner;

/**
 *
 * @author sdc.daniel
 */
public class FormPrincipal extends javax.swing.JFrame {

    static Empregado empregados[] = new Empregado[10];
    //Variável de controle da estrutura de repetição
    static Integer index = 0;

    public static Empregado[] getEmpregados() {
        return empregados;
    }

    public static void setEmpregados(Empregado[] empregados) {
        FormPrincipal.empregados = empregados;
    }

    public static Integer getIndex() {
        return index;
    }

    public static void setIndex(Integer index) {
        FormPrincipal.index = index;
    }
    
    
     
    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
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

        jDesktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMSair = new javax.swing.JMenu();
        jMISair = new javax.swing.JMenuItem();
        jMCadastrar = new javax.swing.JMenu();
        jMCLT = new javax.swing.JMenuItem();
        jMHorista = new javax.swing.JMenuItem();
        jMConsultar = new javax.swing.JMenu();
        jMEmpregados = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jMSair.setText("Arquivo");

        jMISair.setText("Sair");
        jMISair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISairActionPerformed(evt);
            }
        });
        jMSair.add(jMISair);

        jMenuBar1.add(jMSair);

        jMCadastrar.setText("Cadastrar");

        jMCLT.setText("CLT");
        jMCLT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCLTActionPerformed(evt);
            }
        });
        jMCadastrar.add(jMCLT);

        jMHorista.setText("Horista");
        jMHorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMHoristaActionPerformed(evt);
            }
        });
        jMCadastrar.add(jMHorista);

        jMenuBar1.add(jMCadastrar);

        jMConsultar.setText("Consultar");

        jMEmpregados.setText("Empregados");
        jMEmpregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEmpregadosActionPerformed(evt);
            }
        });
        jMConsultar.add(jMEmpregados);

        jMenuBar1.add(jMConsultar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMISairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISairActionPerformed
        // TODO add your handling code here:
        //Para fechar a aplicacao
        System.exit(0);
    }//GEN-LAST:event_jMISairActionPerformed

    private void jMEmpregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMEmpregadosActionPerformed
        // TODO add your handling code here:
        Empregados form = new Empregados();
        jDesktop.add(form);
        form.show();
    }//GEN-LAST:event_jMEmpregadosActionPerformed

    private void jMCLTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCLTActionPerformed
        // TODO add your handling code here:
        //Para abrir o formulário
        CLT form = new CLT();
        //Vincular o objeto ao DesktopPanel
        jDesktop.add(form);
        //Exibir o form
        form.show();
    }//GEN-LAST:event_jMCLTActionPerformed

    private void jMHoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMHoristaActionPerformed
        // TODO add your handling code here:
        Horista form = new Horista();
        jDesktop.add(form);
        form.show();
    }//GEN-LAST:event_jMHoristaActionPerformed

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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }
    
        public void inserirCLT(String nome, String endereco, String cpf, Double salario){
        //Criando objeto da classe CLT temporario
        System.out.println("Numero de registro:"+index);
        EmpregadoCLT temp = new EmpregadoCLT(nome,endereco,cpf,salario);
        //Exibindo dados na console
        System.out.println("Nome:"+temp.getNome());
        System.out.println("Endereco:"+temp.getEndereco());
        System.out.println("CPF:"+temp.getCpf());
        System.out.println("Salario:"+temp.getsBrutoCLT());
        empregados[index]=temp;//Atribuindo o conteudo do objeto a posição da lista
        index++; //Incrementando a variável porque foi inserido um novo elemento 
        System.out.println("Numero de registro:"+index);
    }
    
    public void inserirHorista(String nome, String endereco, String cpf, Integer n, Double valor){
        //Criando objeto da classe Horista temporario
        System.out.println("Numero de registro:"+index);
        EmpregadoHorista temp = new EmpregadoHorista(nome,endereco,cpf,n,valor);
        empregados[index]=temp;//Atribuindo o conteudo do objeto a posição da lista
        System.out.println("Nome:"+temp.getNome());
        System.out.println("Endereco:"+temp.getEndereco());
        System.out.println("CPF:"+temp.getCpf());
        System.out.println("Numero de Horas:"+temp.getnHoras());
        System.out.println("Valor:"+temp.getPrecoH());        
        index++; //Incrementando a variável porque foi inserido um novo elemento
        System.out.println("Numero de registro:"+index);

    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktop;
    private javax.swing.JMenuItem jMCLT;
    private javax.swing.JMenu jMCadastrar;
    private javax.swing.JMenu jMConsultar;
    private javax.swing.JMenuItem jMEmpregados;
    private javax.swing.JMenuItem jMHorista;
    private javax.swing.JMenuItem jMISair;
    private javax.swing.JMenu jMSair;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
