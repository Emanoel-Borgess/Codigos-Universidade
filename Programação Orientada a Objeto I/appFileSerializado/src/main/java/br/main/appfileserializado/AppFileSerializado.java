/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.appfileserializado;

import java.util.Scanner;

/**
 *
 * @author sdc.daniel
 */
public class AppFileSerializado {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer opcao = null;
        //Implementação do menu de opção
        do{
            System.out.println("1-Abrir/Criar arquivo");
            System.out.println("2-Inserir registro");
            System.out.println("3-Ler Registros");
            System.out.println("4-Sair");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    CreateRandomFile appCreate = new CreateRandomFile();
                    appCreate.createFile();
                    break;
                case 2:
                    WriteRandomFile appWrite = new WriteRandomFile();
                    appWrite.openFile();
                    appWrite.addRecords();
                    appWrite.closeFile();
                    break;
                case 3:
                    ReadRandomFile appRead = new ReadRandomFile();
                    appRead.openFile();
                    appRead.readRecords();
                    appRead.closeFile();
                    break;
                case 4:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Por favor digite "
                            + "uma opcao válida!");
                    break;
            }
        }while(opcao!=4);
    }
}
