/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio05ex02proxy;

/**
 *
 * @author Emanoel Borges
 */
public class ArquivoConfidencial implements Arquivo {
    private String nome;

    public ArquivoConfidencial(String nome) {
        this.nome = nome;
    }

    public void abrir() {
        System.out.println("Abrindo arquivo confidencial: " + nome);
    }
}
