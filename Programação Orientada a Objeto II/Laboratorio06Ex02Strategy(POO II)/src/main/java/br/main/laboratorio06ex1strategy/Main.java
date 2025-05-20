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

        carrinho.adicionaItem(new Item("Camisa", 79.90, 0.3));
        carrinho.adicionaItem(new Item("Tênis", 199.90, 1.0));
        carrinho.adicionaItem(new Item("Calça", 149.90, 0.8));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o frete: 1-Sedex | 2-Normal");
        int opcaoFrete = scanner.nextInt();

        FreteStrategy frete = null;
        switch (opcaoFrete) {
            case 1:
                frete = new SedexFrete();
                break;
            case 2:
                frete = new FreteNormal();
                break;
            default:
                System.out.println("Frete inválido.");
                return;
        }

        double valorFrete = carrinho.calculaFrete(frete);
        System.out.printf("Valor do frete: R$%.2f\n", valorFrete);
        System.out.printf("Total com frete: R$%.2f\n", carrinho.calculaTotal() + valorFrete);

        System.out.println("Escolha o método de pagamento: 1-PIX | 2-Cartão | 3-Boleto");
        int opcaoPagamento = scanner.nextInt();

        PagamentoStrategy pagamento = null;
        switch (opcaoPagamento) {
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
                System.out.println("Pagamento inválido.");
                return;
        }

        carrinho.realizaPagamento(pagamento, valorFrete);
    }
}
