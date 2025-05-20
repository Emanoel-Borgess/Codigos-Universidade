/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio05ex02fachada;

/**
 *
 * @author Emanoel Borges
 */
public class Radio {
    public void ligar() {
        System.out.println("Rádio ligado.");
    }
    public void desligar() {
        System.out.println("Rádio desligado.");
    }
    public void sintonizar(String estacao) {
        System.out.println("Sintonizado na estação: " + estacao);
    }
}
