/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio04;
import java.util.Scanner;

/**
 *
 * @author Emanoel Borges
 */
public class Laboratorio04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastro do 1º carro
        System.out.println("Cadastro do 1º carro:");
        Estacionamento carro1 = new Estacionamento();
        carro1.setDadosCarro();
        System.out.println();

        // Cadastro do 2º carro
        System.out.println("Cadastro do 2º carro:");
        Estacionamento carro2 = new Estacionamento();
        carro2.setDadosCarro();
        System.out.println();

        // Cadastro do 3º carro
        System.out.println("Cadastro do 3º carro:");
        Estacionamento carro3 = new Estacionamento();
        carro3.setDadosCarro();
        System.out.println();

        // Cadastro do 4º carro
        System.out.println("Cadastro do 4º carro:");
        Estacionamento carro4 = new Estacionamento();
        carro4.setDadosCarro();
        System.out.println();

        // Cadastro do 5º carro
        System.out.println("Cadastro do 5º carro:");
        Estacionamento carro5 = new Estacionamento();
        carro5.setDadosCarro();
        System.out.println();

        // Imprimir o relatório
        System.out.println("Relatório do Estacionamento:");
        carro1.imprimirDados();
        carro1.calcularValor();
        System.out.println();

        carro2.imprimirDados();
        carro2.calcularValor();
        System.out.println();

        carro3.imprimirDados();
        carro3.calcularValor();
        System.out.println();

        carro4.imprimirDados();
        carro4.calcularValor();
        System.out.println();

        carro5.imprimirDados();
        carro5.calcularValor();
        System.out.println();

        scanner.close();
    }
}
