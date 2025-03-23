/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio03ex02;

/**
 *
 * @author Emanoel Borges
 */
public class Main {
    public static void main(String[] args) {
        CalculadoraAdapter calc = new CalculadoraAdapter();

        System.out.println("Soma decimal: " + calc.somar(5, 3));
        System.out.println("Subtracao decimal: " + calc.subtrair(10, 4));
        System.out.println("Multiplicacao decimal: " + calc.multiplicar(2, 6));

        System.out.println("Soma binaria: " + calc.somarBinario("101", "011"));
        System.out.println("Subtracao binaria: " + calc.subtrairBinario("1010", "0011"));
    }
}