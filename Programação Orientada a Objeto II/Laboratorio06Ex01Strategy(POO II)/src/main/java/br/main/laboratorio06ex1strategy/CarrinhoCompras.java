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

    public void realizaPagamento(PagamentoStrategy estrategia) {
        double valor = calculaTotal();
        estrategia.pagar(valor);
    }
}

