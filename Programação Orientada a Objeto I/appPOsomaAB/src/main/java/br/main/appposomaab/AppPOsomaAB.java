/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.appposomaab;

/**
 *
 * @author Emanoel Borges
 */
public class AppPOsomaAB {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //Definindo o primeiro e o segundo objeto da classe para teste
        Operacao teste01 = new Operacao();
        Operacao teste02 = new Operacao(1.0,2.0);
        //Setando o valor de A e B
        teste01.setA(1.5);
        teste01.setB(2.0);
        //Recuperando o valor de A e B
        teste01.getA();
        teste01.getB();
        //Printando os atributos com os valores modificados
        System.out.println("Valor de A: "+teste01.getA());
        System.out.println("Valor de B: "+teste01.getB());
        teste01.lerDados();
        //Printando a soma dos valores
        System.out.println("Resultado da soma teste01: "+teste01.somaAB());
        System.out.println("Resultado da soma teste02: "+teste02.somaAB());
        
    }
}
