/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio03ex01;

/**
 *
 * @author Emanoel Borges
 */
public class Main {
    public static void main(String[] args) {
        Ave pato = new Pato();
        Ave pavao = new Pavao();
        Ave pavaoAdaptado = new PavaoAdapter(new Pavao());

        System.out.println("Pato:");
        pato.voar();
        pato.emitirSom();

        System.out.println("\nPavao:");
        pavao.voar();
        pavao.emitirSom();

        System.out.println("\nPavao Adaptado:");
        pavaoAdaptado.voar();
        pavaoAdaptado.emitirSom();
    }
}
