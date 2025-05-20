/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.excecao_e_polimorfismo;

public class Excecao_e_polimorfismo{
     public static void main(String[] args) {
        // Criando uma conta corrente
        ContaBancaria conta1 = new ContaCorrente("João", 1000);
        // Criando uma conta poupança
        ContaBancaria conta2 = new ContaPoupanca("Maria", 2000);

        // Testando operações com tratamento de exceção
        try {
            conta1.sacar(500); // Saque válido
            conta1.sacar(600); // Saque inválido (saldo insuficiente) -> Gera exceção
        } catch (SaldoInsuficienteException e) {
            // Captura e trata a exceção lançada
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            conta2.sacar(1500); // Saque válido
            conta2.sacar(600);  // Saque inválido (saldo insuficiente) -> Gera exceção
        } catch (SaldoInsuficienteException e) {
            // Captura e trata a exceção lançada
            System.out.println("Erro: " + e.getMessage());
        }

        // Aplicando rendimento à conta poupança
        ((ContaPoupanca) conta2).aplicarRendimento();
    }
}