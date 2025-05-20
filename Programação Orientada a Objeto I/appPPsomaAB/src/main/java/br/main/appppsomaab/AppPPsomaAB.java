/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.appppsomaab;

/**
 *
 * @author Emanoel Borges
 */
//Paradigma Procedural(Procedimental)
public class AppPPsomaAB {
    
    private static double soma(double X, double Y){
        return X + Y;
    }
    public static void main(String[] args){
        double A,B,X;
        A = 1.5;
        B = 2.5;
        X = A + B;
        System.out.println("A soma de A + B e:"+soma(A,B));
        System.out.println("A soma 2 de A + B e:"+ X);
    }
}

















//Uma classe é uma abstração de algo real ou imaginario.
//atributos caracteristica e metodos ações.
//Paradigmas procedural estruturado em torno de funcoes e procedimentos. Orientado a objeto estruturado em torno de objetos e suas interações, dados são encapsulados e acessados por metodos.
//Construtores são metodos especiais que inicializam instâncias de objetos, podem ter parametros ou não
//Getters e Setters são metodos que recuperam(Getters) ou atualizam (Setters) as informações de um atributo  especificos.
//Exceções em java representam erros que podem ocorrer durante a execução de um programa.
//O trata mento de exceção permite lidar com erros sem interromper o programa utilizando as palavras:
//try: bloco de codigo onde exceções podem ocorrer,
//catch: bloco que trata exceções especificas,
//throw: lanca manualmente uma exceção,
//throws: declara que um método pode lançar exceções,
//finally: bloco de código executado sempre, independente de exceções.