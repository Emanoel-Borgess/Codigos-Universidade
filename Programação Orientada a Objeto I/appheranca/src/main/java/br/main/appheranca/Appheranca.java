/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.appheranca;

/**
 *
 * @author Emanoel Borges
 */
public class Appheranca {

    public static void main(String[] args) {
        System.out.println("==== Dados do Aluno ====");
        Aluno aluno = new Aluno("Carlos Lima", "111.222.333-44", "20/05/2002", 12345);
        aluno.imprimirPessoa();
        
        System.out.println("\n==== Dados do Professor ====");
        Professor professor = new Professor("Maria Souza", "987.654.321-00", "15/08/1990", "Matemática", 4000.0);
        professor.imprimirPessoa();
        
        System.out.println("\n==== Dados do Funcionário ====");
        Funcionario funcionario = new Funcionario("João Silva", "123.456.789-00", "10/02/1985", 5000.0, "01/03/2020", "Gerente");
        funcionario.imprimirPessoa();
    }
}