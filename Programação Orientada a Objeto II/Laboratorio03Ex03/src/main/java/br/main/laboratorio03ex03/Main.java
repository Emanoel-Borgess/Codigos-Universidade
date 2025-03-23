/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio03ex03;

/**
 *
 * @author Emanoel Borges
 */
//Problema Escolhido: Conversor de Tomadas

public class Main {
    public static void main(String[] args) {
        TomadaEuropeia tomadaEuropeia = new TomadaEuropeia();
        TomadaAmericana adaptador = new AdaptadorTomada(tomadaEuropeia);

        System.out.println("Tentando conectar em tomada americana:");
        adaptador.conectar();
    }
}
