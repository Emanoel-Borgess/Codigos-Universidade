/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appmdi;

import java.util.Scanner;

/**
 *
 * @author sdc.daniel
 */
public class Empregado {

    protected String nome;
    protected String endereco;
    protected String cpf;
    protected Scanner input;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
   
    public Empregado(){
        nome = "";
        endereco = "";
        cpf = "";
    }
    
    public void inserirDadosEmpregados(){
        input = new Scanner(System.in);
        System.out.println("Digite o nome:");
        nome = input.next();
        System.out.println("Digite o endereco:");
        endereco = input.next();
        System.out.println("Digite o CPF:");
        cpf = input.next();
    }
}
