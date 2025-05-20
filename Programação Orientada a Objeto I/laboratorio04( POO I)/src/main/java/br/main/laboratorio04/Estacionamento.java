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
public class Estacionamento {
    private String chapa;
    private String marca;
    private Tempo entrada;
    private Tempo saida;

    public Estacionamento() {
        chapa = "";
        marca = "";
        entrada = new Tempo(0, 0);
        saida = new Tempo(0, 0);
    }

    public void setDadosCarro() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a chapa do carro: ");
        chapa = scanner.nextLine();

        System.out.print("Digite a marca do carro: ");
        marca = scanner.nextLine();

        System.out.print("Digite a hora de entrada (0 a 23h): ");
        int horaEntrada = scanner.nextInt();
        System.out.print("Digite os minutos de entrada (0 a 59min): ");
        int minutoEntrada = scanner.nextInt();
        entrada.setHora(horaEntrada);
        entrada.setMinuto(minutoEntrada);

        System.out.print("Digite a hora de saída (0-23): ");
        int horaSaida = scanner.nextInt();
        System.out.print("Digite os minutos de saída (0-59): ");
        int minutoSaida = scanner.nextInt();
        saida.setHora(horaSaida);
        saida.setMinuto(minutoSaida);
    }

    public void imprimirDados() {
        System.out.println("Chapa: " + chapa);
        System.out.println("Marca: " + marca);
        System.out.println("Hora de entrada: " + entrada.getHora() + ":" + String.format("%02d", entrada.getMinuto()));
        System.out.println("Hora de saída: " + saida.getHora() + ":" + String.format("%02d", saida.getMinuto()));
    }

    public void calcularValor() {
        Tempo tempoUsado = saida.subtrair(entrada);
        int totalHoras = tempoUsado.getHora() + tempoUsado.getMinuto() / 60;
        double valor = totalHoras * 3.0;  // R$ 3,00 por hora
        System.out.printf("Valor cobrado: R$ %.2f\n", valor);
    }
}
