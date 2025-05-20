/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio03ex03;

/**
 *
 * @author Emanoel Borges
 */
public class AdaptadorTomada implements TomadaAmericana {
    private TomadaEuropeia tomadaEuropeia;

    public AdaptadorTomada(TomadaEuropeia tomadaEuropeia) {
        this.tomadaEuropeia = tomadaEuropeia;
    }

    public void conectar() {
        System.out.println("Usando adaptador...");
        tomadaEuropeia.conectarEuropeu();
    }
}
