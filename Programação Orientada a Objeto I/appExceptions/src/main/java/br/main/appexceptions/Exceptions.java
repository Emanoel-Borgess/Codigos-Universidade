/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appexceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sdc.daniel
 */
public class Exceptions {

    public void exemploExcecao() {
        int numer[] = {4, 8, 16, 32, 65, 128, 256, 512};
        int denom[] = {2, 0, 4, 4, 0, 8};
        for (int i = 0; i < numer.length; i++) {
            try {
                System.out.println(numer[i] + " / " + denom[i]
                        + " é " + numer[i] / denom[i]);
            } catch (ArithmeticException e) {
                System.out.println("Não é possível dividir por zero!");
            } catch (RuntimeException e) {
                System.out.println("Nenhum elemento correspondente "
                        + "foi encontrado!");
            }
        }
    }

    public void throws01() {
        System.out.println("Inicio Método 1");
        try {
            //Chamando o método 02 para gerar encadeamento.
            throws02();
        } catch (Exception ex) {
            Logger.getLogger(Exceptions.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
        System.out.println("Fim Metodo 1");
    }

    public void throws02() throws Exception {
        System.out.println("Inicio Metodo 2");
        Integer idade = 0;
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite"
                + " uma idade:"));
        System.out.println("Idade informada:" + idade);
        System.out.println("Fim Metodo 2");
    }

    public void lerArquivoTXT() {

        BufferedReader reader = null;
        try {
            String file = "fileTest.txt";
            reader = new BufferedReader(new FileReader(file));
            String currentLine = reader.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exceptions.class.getName()
            ).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Exceptions.class.getName()
            ).log(Level.SEVERE, null, ex);
        }finally{
            //Fechando o arquivo
            System.out.println("Fechando o arquivo");
            if(reader!=null)
                try {
                    reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Exceptions.class.getName()
                ).log(Level.SEVERE, null, ex);
            }
        }
    }
}
