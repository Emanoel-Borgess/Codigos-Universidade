/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appfileserializado;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdc.daniel
 */
public class ReadRandomFile { //classe para leitura do arquivo
    private RandomAccessFile input;
    
    //Método para abertura do arquivo
    public void openFile(){
        try {
            input = new RandomAccessFile("clients.dat", "r"); //abrindo o arquivo somente leitura;
        } catch (IOException ex) {
            System.out.println("O arquivo não existe!");
        }
    }
    
    //método para ler os registros
    public void readRecords(){
        
        //Criando um objeto para lermos os registros e atualizar os atributos da classe com os dados
        RandomAccessAccountRecord registro = new RandomAccessAccountRecord();
        //Imprimindo mensagem para leitura dos dados
        System.out.printf("%-10s%-15s%-15s%10s\n","Account"
                ,"FirstName","LastName","Balance");
        
        //Definindo a estrutura de repetição para ler o registro
        try{//lê o registro e exibir
            while(true){
                do{
                    registro.read(input);
                }while(registro.getAccount()==0);
                //Exibe o registro lido
                System.out.printf("%-10s%-15s%-15s%10s\n",
                        registro.getAccount(),registro.getFirstName(),
                        registro.getLastName(),
                registro.getBalance());
            }//saiu do while
        }catch(EOFException ex01){ //Fechar o arquivo
            return; //retorna que chegou ao fim do arquivo
        }catch(IOException ex02){
            System.out.println("Erro ao ler/acessar o arquivo!");
            System.exit(1);//Caso aconteça o erro sai do programa
        }
    }
    
    public void closeFile(){
        //verficar se o arquivo está aberto
            try {
              if(input!=null)
                input.close();
        } catch (IOException ex) {
                System.out.println("Erro ao fechar o arquivo!");
                System.exit(1); //sair do programa
        }
    }
}
