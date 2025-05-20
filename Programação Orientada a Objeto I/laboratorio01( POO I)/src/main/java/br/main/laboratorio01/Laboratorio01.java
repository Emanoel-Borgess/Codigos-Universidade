/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio01;

/**
 *
 * @author Emanoel Borges
 */
public class Laboratorio01 {

    public static void main(String[] args) {
        Vetor2D v1 = new Vetor2D(3, 4);
        Vetor2D v2 = new Vetor2D(1, 2);

        System.out.println("Produto escalar: " + v1.produtoEscalar(v2));
        System.out.println("Módulo v1: " + v1.modulo());
        System.out.println("Módulo v2: " + v2.modulo());
        System.out.println("Ângulo entre v1 e v2: " + Math.toDegrees(v1.anguloEntre(v2)) + " graus");
        System.out.println("Projeção de v1 sobre v2: " + v1.projecaoSobre(v2));
    }
}
