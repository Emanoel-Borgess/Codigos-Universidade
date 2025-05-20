/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appposomaab;

import java.util.Scanner;

/**
 *
 * @author Emanoel Borges
 */
public class Operacao {
    //Definindo os atributos da classe
    private double A;
    private double B;

    //Definindo um construtor nulo
    public Operacao(){
        A = 0.0;
        B = 0.0;
    }
    //Definindo construtor com valores
    public Operacao(double X, double Y){
        this.A = X;
        this.B = Y;
    }
    //Getters e Setters
    public void setA(double A) {
        this.A = A;
    }

    public void setB(double B) {
        this.B = B;
    }

    public double getA() {
        return A;
    }

    public double getB() {
        return B;
    }
    //Definindo o conjunto de ações ou tambem chamado de métodos
    public double somaAB(){
        return A + B;
    }
    
    public void lerDados(){
        //Buffer para leitura de dados
        Scanner input;
        //Instanciando o objeto input
        input = new Scanner(System.in);
        //Lendo os valores de A e B
        System.out.print("Digite o valor de A:");
        A = input.nextDouble();
        System.out.print("Digite o valor de B:");
        B = input.nextDouble();
    }
}

