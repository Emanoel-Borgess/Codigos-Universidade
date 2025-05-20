/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appconta;

import java.util.Scanner;

/**
 *
 * @author Emanoel Borges
 */
public class Conta {
    private String nome;
    private double saldo = 0;
    
    public Conta(){
        nome = "";
        saldo = 0.0;
    }
    
    public Conta(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void Deposita(double valor){
        saldo += valor;
    }
    public void Rendimento(double salario){
        saldo = saldo *(1+0.50);
    }
    public void Saque(double valor){
        if(saldo < 0){
            System.out.println("Saldo Indisponivel!");
        }else{
            saldo -= valor;
            System.out.println("Saque efetuado!");
        }
    }
     public void lerDados(){
        Scanner input;
        input = new Scanner(System.in);
        System.out.print("Digite seu nome:");
        nome = input.next();
        input.nextLine();// Limpa o buffer do scanner
        System.out.print("Digite o valor do seu saldo:");
        saldo = input.nextDouble();
    }
}
