/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio05ex02fachada;

/**
 *
 * @author Emanoel Borges
 */
public class CarroTeste {
    public static void main(String[] args) {
        CarroFachada carro = new CarroFachada();
        carro.dirigir("Rock FM 101.1");
        System.out.println("\n--- Corrida Finalizada ---\n");
        carro.pararCarro();
    }
}
