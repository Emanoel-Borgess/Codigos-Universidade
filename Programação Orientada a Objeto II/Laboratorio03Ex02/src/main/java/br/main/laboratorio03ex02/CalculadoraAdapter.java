/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio03ex02;

/**
 *
 * @author Emanoel Borges
 */
public class CalculadoraAdapter {
    private CalculadoraBinaria calculadoraBinaria = new CalculadoraBinaria();

    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public String somarBinario(String a, String b) {
        return calculadoraBinaria.somar(a, b);
    }

    public String subtrairBinario(String a, String b) {
        return calculadoraBinaria.subtrair(a, b);
    }
}
