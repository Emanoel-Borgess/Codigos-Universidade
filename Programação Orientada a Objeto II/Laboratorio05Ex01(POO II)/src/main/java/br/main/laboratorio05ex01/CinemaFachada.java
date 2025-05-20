/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio05ex01;

/**
 *
 * @author Emanoel Borges
 */
public class CinemaFachada {
    private Amplificador amp;
    private Luzes luzes;
    private MaquinaDePipoca pipoca;
    private Projetor projetor;
    private PlayerStreaming player;
    private Telao telao;

    public CinemaFachada() {
        amp = new Amplificador();
        luzes = new Luzes();
        pipoca = new MaquinaDePipoca();
        projetor = new Projetor();
        player = new PlayerStreaming();
        telao = new Telao();
    }

    public void assistirFilme(String filme) {
        pipoca.ligar();
        pipoca.rebentarPipoca();
        luzes.desligar();
        telao.abaixar();
        projetor.ligar();
        amp.ligar();
        amp.ajustarVolume(10);
        player.ligar();
        player.play(filme);
    }

    public void fimDoFilme() {
        System.out.println("Encerrando sessão...");
        player.desligar();
        amp.ajustarVolume(0);
        projetor.desligar();
        telao.subir();
        luzes.ligar();
        pipoca.desligar();
    }
}
