/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio02;

/**
 *
 * @author Emanoel Borges
 */
public class Laboratorio02 {

    public static void main(String[] args) {
        
        Tempo t1 = new Tempo();
        t1.lerHora();

        Tempo t2 = new Tempo();
        t2.lerHora();
        
        Tempo soma = t1.adicionar(t2);
        System.out.println("Soma: " + soma);

        Tempo diferenca = t1.subtrair(t2);
        System.out.println("Diferença: " + diferenca);
    }
}