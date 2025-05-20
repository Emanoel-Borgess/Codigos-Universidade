/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appfileserializado;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdc.daniel
 */
public class CreateRandomFile {
    private static final int NUMBER_RECORDS = 100;
    
    //Criar um arquivo em branco
    public void createFile(){
        //Tipo de objeto utilizado para trabalhar com arquivo serializado
        RandomAccessFile file = null;
        
        try {
            //Abrindo o arquivo serializado para ler e escrever
            file = new RandomAccessFile("clients.dat", "rw");
            //Criando um objeto da Classe RandomAccessAccountRecord
            RandomAccessAccountRecord blankRecord = new RandomAccessAccountRecord();
            
            //grava 100 registros em branco
            for(int count =0;count<NUMBER_RECORDS;count++)
                blankRecord.write(file);
            
            //Exibe mensage de arquivo criado
            System.out.println("Arquivo clients.dat criado com sucesso!");
            
            //Saindo do evento de criação de arquivo
            //System.exit(0);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao gravar o arquivo!");           
        } catch (IOException ex) {
            System.out.println("Erro ao processar o arquivo");
            System.exit(1); //sai do programa
        }
        finally{ //Sempre vai executar esta ação caso funcione ou não
            if(file!=null)
                try {
                    file.close();//fecha o arquivo aberto
            } catch (IOException ex) {
                    System.out.println("Erro ao fechar o arquivo");
                    System.exit(1);
            }
        }
        
    }
    
}
