/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio06ex1strategy;

/**
 *
 * @author Emanoel Borges
 */
public class FreteNormal implements FreteStrategy {
    @Override
    public double calcular(double pesoTotal) {
        return pesoTotal * 5.0; // R$5 por kg
    }
}

