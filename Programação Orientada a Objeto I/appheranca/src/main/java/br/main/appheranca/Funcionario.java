/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appheranca;

/**
 *
 * @author Emanoel Borges
 */
public class Funcionario extends Pessoa {

    private double salario;
    private String dataAdmissao;
    private String cargo;
    
    public Funcionario(){
        super();
        salario = 0.0;
        dataAdmissao = "";
        cargo = "";
    }
    
    public Funcionario(String nome, String  cpf, String dataNasc, double salario, String dataAdmissao, String cargo){
        super(nome, cpf, dataNasc);
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
    }
    
        public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public void imprimirPessoa() {
        System.out.println("Nome: " + getNome()); // Supondo que tenha getNome() na classe Pessoa
        System.out.println("CPF: " + getCpf());   // Supondo que tenha getCpf() na classe Pessoa
        System.out.println("Data de Nascimento: " + getDataNasc()); // Supondo que tenha getDataNasc() na classe Pessoa
        System.out.println("Salário: " + salario);
        System.out.println("Data da admissão: " + dataAdmissao);
        System.out.println("Cargo: " + cargo);
    }
    
}
