/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appheranca;

/**
 *
 * @author Emanoel Borges
 */
public class Aluno extends Pessoa {
    private int matricula;
    
 public Aluno() {
        super();
        this.matricula = 0;
    }

    public Aluno(String nome, String cpf, String dataNasc, int matricula) {
        super(nome, cpf, dataNasc);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public void imprimirPessoa() {
        super.imprimirPessoa();
        System.out.println("Matrícula: " + matricula);
    }
}
