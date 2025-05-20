/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio06ex1strategy;

/**
 *
 * @author Emanoel Borges
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarrinhoCompras carrinho = new CarrinhoCompras();
        
        carrinho.adicionaItem(new Item("Camisa", 79.90));
        carrinho.adicionaItem(new Item("Tênis", 199.90));
        carrinho.adicionaItem(new Item("Calça", 149.90));

        System.out.println("Total: R$" + carrinho.calculaTotal());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o método de pagamento: 1-PIX | 2-Cartão | 3-Boleto");
        int opcao = scanner.nextInt();

        PagamentoStrategy pagamento = null;

        switch (opcao) {
            case 1:
                pagamento = new PixPagamento();
                break;
            case 2:
                pagamento = new CartaoPagamento();
                break;
            case 3:
                pagamento = new BoletoPagamento();
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        carrinho.realizaPagamento(pagamento);
    }
}

