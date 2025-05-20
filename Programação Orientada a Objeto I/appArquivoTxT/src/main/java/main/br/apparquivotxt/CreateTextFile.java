/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.br.apparquivotxt;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leand
 */
public class CreateTextFile {
    private Formatter output;
    
    public void openFile(){
        try {
            output = new Formatter("clientes.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Erro:"+ex);
        } catch (SecurityException ex1){
            System.out.println("Erro:"+ex1);
        }
    }
    
    public void addRecords(){
        //variavel auxiliar
        int counter =0;
        //Criando uma instancia da classe AccountRecord 
        //Para guardar as informacoes
        AccountRecord record = new AccountRecord();
        //Criando uma instancia do JavaScanner para ler os dados
        Scanner input = new Scanner(System.in);
        //Verificando se a conta e valida
        //Se nao for deve informar tudo novamente
        do{
        System.out.println("Digite o numero da conta:");
        record.setAccount(input.nextInt());
        System.out.println("Digite o firstName:");
        record.setFirstName(input.next());
        System.out.println("Digite o lastName:");
        record.setLastName(input.next());
        System.out.println("Digite o balanço:");
        record.setBalance(input.nextDouble());
        if(record.getAccount()<0)
                System.out.println("O numero da conta não pode ser zero! Informe novamente!");
        }while(record.getAccount()<0);
        
        try{
        //Se os dados foram válidos grava os mesmos no arquivo
        output.format("%d %s %s %.2f\n",record.getAccount(),record.getFirstName(),
                record.getLastName(),record.getBalance());
        counter++;
        }catch(FormatterClosedException ex){
            System.out.println("As informações estão erradas!");
        }
    }
    
    
}
