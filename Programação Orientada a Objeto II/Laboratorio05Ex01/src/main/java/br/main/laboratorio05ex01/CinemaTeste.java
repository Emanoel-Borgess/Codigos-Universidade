/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio05ex01;

/**
 *
 * @author Emanoel Borges
 */
public class CinemaTeste {
    public static void main(String[] args) {
        CinemaFachada cinema = new CinemaFachada();
        cinema.assistirFilme("Senhor dos Anéis");
        System.out.println("\n--- Filme terminou ---\n");
        cinema.fimDoFilme();
    }
}
