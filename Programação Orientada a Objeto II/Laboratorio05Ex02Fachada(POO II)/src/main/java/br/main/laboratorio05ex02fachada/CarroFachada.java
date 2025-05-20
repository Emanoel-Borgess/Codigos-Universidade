/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio05ex02fachada;

/**
 *
 * @author Emanoel Borges
 */
public class CarroFachada {
    private Motor motor;
    private Cinto cinto;
    private Porta porta;
    private Farol farol;
    private Radio radio;

    public CarroFachada() {
        motor = new Motor();
        cinto = new Cinto();
        porta = new Porta();
        farol = new Farol();
        radio = new Radio();
    }

    public void dirigir(String estacao) {
        motor.ligar();
        porta.trancar();
        cinto.travar();
        farol.acender();
        radio.ligar();
        radio.sintonizar(estacao);
    }

    public void pararCarro() {
        motor.desligar();
        porta.destrancar();
        cinto.destravar();
        farol.apagar();
        radio.desligar();
    }
}
