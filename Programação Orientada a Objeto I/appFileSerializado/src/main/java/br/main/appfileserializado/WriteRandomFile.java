/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appfileserializado;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdc.daniel
 */
public class WriteRandomFile {
    private static final int NUMBER_RECORDS=100; //Constante com n. de regs.
    private RandomAccessFile output; //Objeto para escrever dados no arquivo
    
    //método para abrir o arquivo
    public void openFile(){
        try {
            output = new RandomAccessFile("clients.dat","rw");
        } catch (IOException ex) {
            System.out.println("Erro ao abrir o arquivo "
                    + "ou arquivo inexistente!");
        }
    }
    
    //método para fechar o arquivo
    public void closeFile(){
        try {
                if(output!=null)  
                    output.close();
        } catch (IOException ex) {
                System.out.println("Erro ao fechar o arquivo!");
                System.exit(1);
        }
    }
    
    //metodo para escrever no arquivo
    public void addRecords(){
        try {
            //Criar um atributo da classe RandomAccessAccountRecord
            RandomAccessAccountRecord registro = new
                RandomAccessAccountRecord();
            //Criando o objeto JavaScanner
            Scanner input = new Scanner(System.in);
            //Variáveis auxiliar para recuperar os dados
            Integer account;
            String fName,lName;
            Double bal;
            System.out.printf("%-10s%-15s%-15s%10s\n","Entre com: "
                    + "Account(1-100)","FirstName","LastName",
                    "Balance");
            account = input.nextInt();
            fName = input.next();
            lName = input.next();
            bal = input.nextDouble();
            //verficar se o numero da conta é valido
            if(account > 0 && account <= NUMBER_RECORDS){
                registro.setAccount(account);
                registro.setFirstName(fName);
                registro.setLastName(lName);
                registro.setBalance(bal);
                //verifica posição correta do registro no arquivo
                output.seek((account-1)*RandomAccessAccountRecord.SIZE);
                // gravando o registro lido
                registro.write(output);
            }else
                System.out.println("O número da conta deve "
                        + "estar em 1 e 100!");
        } catch (IOException ex) {
            System.out.println("Erro o gravar o registro!");
            return;
        }catch(NoSuchElementException ex){
            System.out.println("Entrada inválida! Por favor"
                    + "informe os dados corretos!");
        }
    }
}
