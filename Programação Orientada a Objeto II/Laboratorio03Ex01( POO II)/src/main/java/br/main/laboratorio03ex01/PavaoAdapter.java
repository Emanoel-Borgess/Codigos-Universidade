/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio03ex01;

/**
 *
 * @author Emanoel Borges
 */
public class PavaoAdapter implements Ave {
    private Pavao pavao;
    
    public PavaoAdapter(Pavao pavao) {
        this.pavao = pavao;
    }

    public void voar() {
        System.out.println("O pavao esta pulando para simular voo!");
    }

    public void emitirSom() {
        pavao.emitirSom();
    }
}
