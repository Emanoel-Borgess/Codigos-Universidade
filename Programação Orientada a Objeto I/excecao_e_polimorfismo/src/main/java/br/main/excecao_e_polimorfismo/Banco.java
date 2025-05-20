/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package br.main.excecao_e_polimorfismo;

/**
 *
 * @author Emanoel Borges
 */
// Classe base ContaBancaria
// Esta classe é abstrata e contém um método abstrato sacar(), demonstrando polimorfismo
abstract class ContaBancaria {
    protected String titular;
    protected double saldo;

    // Construtor
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método abstrato para saque (será implementado nas subclasses)
    // Aqui ocorre polimorfismo, pois cada classe filha implementará este método de maneira diferente
    public abstract void sacar(double valor) throws SaldoInsuficienteException;

    // Método para depositar dinheiro
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso. Novo saldo: " + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // Método para exibir saldo
    public void exibirSaldo() {
        System.out.println("Titular: " + titular + " | Saldo: " + saldo);
    }
}

// Classe ContaCorrente que herda de ContaBancaria
// Demonstra polimorfismo ao sobrescrever o método sacar
class ContaCorrente extends ContaBancaria {
    private double taxaSaque = 5.0; // Taxa fixa para saque

    // Construtor
    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    // Implementação do método sacar com tratamento de exceção
    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor + taxaSaque > saldo) {
            // Aqui ocorre o tratamento de exceção
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
        saldo -= (valor + taxaSaque);
        System.out.println("Saque realizado com sucesso. Novo saldo: " + saldo);
    }
}

// Classe ContaPoupanca que herda de ContaBancaria
// Também demonstra polimorfismo ao implementar sacar de forma diferente
class ContaPoupanca extends ContaBancaria {
    private double rendimento = 0.02; // 2% de rendimento mensal

    // Construtor
    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    // Implementação do método sacar com tratamento de exceção
    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            // Aqui ocorre o tratamento de exceção
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
        saldo -= valor;
        System.out.println("Saque realizado com sucesso. Novo saldo: " + saldo);
    }

    // Método para aplicar rendimento
    public void aplicarRendimento() {
        saldo += saldo * rendimento;
        System.out.println("Rendimento aplicado. Novo saldo: " + saldo);
    }
}

// Classe de exceção personalizada
// Esta classe representa uma exceção específica para saldo insuficiente
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

// Classe principal para testar o código
public class Banco {
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
