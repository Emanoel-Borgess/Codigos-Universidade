/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio02;
import java.util.Scanner;
/**
 *
 * @author Emanoel Borges
 */

public class Tempo {
    
    private int hora;
    private int min;
    private int seg;

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }
    
    public Tempo() {
        this.hora = 0;
        this.min = 0;
        this.seg = 0;
    }

    public Tempo(int hora, int min, int seg) {
        this.hora = hora;
        this.min = min;
        this.seg = seg;
    }
    
    public void lerHora() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a hora: ");
        this.hora = scanner.nextInt();
        System.out.print("Digite os minutos: ");
        this.min = scanner.nextInt();
        System.out.print("Digite os segundos: ");
        this.seg = scanner.nextInt();
        System.out.println("Hora registrada");
    }
    
    public void imprimir() {
        System.out.println(hora+":"+min+":"+seg);
    }

    public Tempo adicionar(Tempo t3) {
        int totalSegundos = this.emSegundos() + t3.emSegundos();
        return deSegundos(totalSegundos);
    }

    public Tempo subtrair(Tempo t3) {
        int totalSegundos = this.emSegundos() - t3.emSegundos();
        if (totalSegundos < 0) {
            totalSegundos = -totalSegundos; //serve para não ter segundos negativos
        }
        return deSegundos(totalSegundos);
    }

    private int emSegundos() {
        return this.hora * 3600 + this.min * 60 + this.seg;
    }

    private static Tempo deSegundos(int totalSegundos) {
        int horas = totalSegundos / 3600;
        int minutos = (totalSegundos % 3600) / 60;
        int segundos = totalSegundos % 60;
        return new Tempo(horas, minutos, segundos);
    }
    
     public String toString() {
        return String.format("%02d:%02d:%02d", hora, min, seg);
    }
}