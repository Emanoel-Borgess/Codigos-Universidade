/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio04;
import java.util.Scanner;

/**
 *
 * @author Emanoel Borges
 */
public class Tempo {
     private int hora;
    private int minuto;

    public Tempo(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public Tempo subtrair(Tempo outro) {
        int totalMinutos1 = this.hora * 60 + this.minuto;
        int totalMinutos2 = outro.hora * 60 + outro.minuto;
        int diffMinutos = totalMinutos1 - totalMinutos2;
        
        int horas = diffMinutos / 60;
        int minutos = diffMinutos % 60;
        
        return new Tempo(horas, minutos);
    }
}
