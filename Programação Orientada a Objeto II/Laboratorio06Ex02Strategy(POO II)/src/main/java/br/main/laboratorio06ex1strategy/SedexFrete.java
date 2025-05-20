/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio06ex1strategy;

/**
 *
 * @author Emanoel Borges
 */
public class SedexFrete implements FreteStrategy {
    @Override
    public double calcular(double pesoTotal) {
        return pesoTotal * 10.0; // R$10 por kg
    }
}

