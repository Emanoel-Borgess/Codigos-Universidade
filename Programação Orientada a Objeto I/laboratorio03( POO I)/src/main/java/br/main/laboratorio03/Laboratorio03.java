/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio03;

/**
 *
 * @author Emanoel Borges
 */
public class Laboratorio03 {

public static void main(String[] args) {
        // Criando objetos Vetor2D e Vetor3D
        Vetor2D v2d = new Vetor2D(3.0, 4.0);
        Vetor3D v3d1 = new Vetor3D(1.0, 2.0, 3.0);
        Vetor3D v3d2 = new Vetor3D(4.0, 5.0, 6.0);
        
        // Imprimindo os valores de Vetor2D
        System.out.println("Vetor2D:");
        System.out.println("x: " + v2d.getX() + ", y: " + v2d.getY());
        
        // Imprimindo os valores de Vetor3D
        System.out.println("\nVetor3D:");
        System.out.println("x: " + v3d1.getX() + ", y: " + v3d1.getY() + ", z: " + v3d1.getZ());
        
        // Modulo de um vetor 3D
        System.out.println("\nMódulo do Vetor3D v3d1: " + v3d1.modulo());
        
        // Produto vetorial entre v3d1 e v3d2
        Vetor3D produto = v3d1.produtoVetorial(v3d2);
        System.out.println("\nProduto vetorial de v3d1 e v3d2:");
        System.out.println("x: " + produto.getX() + ", y: " + produto.getY() + ", z: " + produto.getZ());
    }
}
