/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio06ex1strategy;

/**
 *
 * @author Emanoel Borges
 */
import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Item> itens = new ArrayList<>();

    public void adicionaItem(Item item) {
        itens.add(item);
        System.out.println("Item adicionado: " + item.getNome() + " - R$" + item.getPreco());
    }

    public void removeItem(Item item) {
        itens.remove(item);
        System.out.println("Item removido: " + item.getNome());
    }

    public double calculaTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public double calculaPesoTotal() {
        double peso = 0;
        for (Item item : itens) {
            peso += item.getPeso();
        }
        return peso;
    }

    public double calculaFrete(FreteStrategy estrategiaFrete) {
        double pesoTotal = calculaPesoTotal();
        return estrategiaFrete.calcular(pesoTotal);
    }

    public void realizaPagamento(PagamentoStrategy estrategiaPagamento, double frete) {
        double valor = calculaTotal() + frete;
        estrategiaPagamento.pagar(valor);
    }
}
