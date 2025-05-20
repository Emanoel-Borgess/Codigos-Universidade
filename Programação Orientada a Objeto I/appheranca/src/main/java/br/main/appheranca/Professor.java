/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appheranca;

/**
 *
 * @author Emanoel Borges
 */
public class Professor extends Pessoa {

    private String disciplina;
    private double salario;
    
    public Professor() {
        super();
        disciplina = "";
        salario = 0.0;
    }
    
    public Professor(String nome, String  cpf, String dataNasc, String disciplina, double salario) {
       super(nome,cpf,dataNasc);
       this.disciplina = disciplina;
       this.salario = salario;
    }
    
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
 
    @Override
    public void imprimirPessoa() {
        super.imprimirPessoa();
        System.out.println("Disciplina: " + disciplina);
        System.out.println("Salário: R$" + salario);
    }
    
}
