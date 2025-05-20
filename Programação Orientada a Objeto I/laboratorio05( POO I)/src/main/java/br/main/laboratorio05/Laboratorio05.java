/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio05;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emanoel Borges
 */
public class Laboratorio05 {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        
        funcionarios.add(new Funcionario("Carlos Silva", 1, null, null, null, null));
        funcionarios.add(new Funcionario("Ana Souza", 2, "Escola A", null, null, null));
        funcionarios.add(new Funcionario("Pedro Santos", 3, "Escola B", "Colégio X", null, null));
        funcionarios.add(new Funcionario("Mariana Lima", 4, "Escola C", "Colégio Y", "Universidade Z", "Engenharia"));
        funcionarios.add(new Funcionario("João Costa", 5, "Escola D", null, null, null));
        funcionarios.add(new Funcionario("Fernanda Rocha", 6, "Escola E", "Colégio W", null, null));
        funcionarios.add(new Funcionario("Lucas Oliveira", 7, null, null, null, null));
        funcionarios.add(new Funcionario("Juliana Mendes", 8, "Escola F", "Colégio V", "Universidade X", "Administração"));
        funcionarios.add(new Funcionario("Ricardo Alves", 9, "Escola G", null, null, null));
        funcionarios.add(new Funcionario("Patrícia Duarte", 10, "Escola H", "Colégio U", "Universidade W", "Medicina"));

        double custoTotal = 0;
        double custoSemEscolaridade = 0;
        double custoEnsinoBasico = 0;
        double custoEnsinoMedio = 0;
        double custoGraduacao = 0;

        System.out.println("\nLista de Funcionários:");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
            custoTotal += f.getRendaTotal();
            
            switch (f.getNivelEscolaridade()) {
                case "Sem Escolaridade":
                    custoSemEscolaridade += f.getRendaTotal();
                    break;
                case "Ensino Básico":
                    custoEnsinoBasico += f.getRendaTotal();
                    break;
                case "Ensino Médio":
                    custoEnsinoMedio += f.getRendaTotal();
                    break;
                case "Graduação":
                    custoGraduacao += f.getRendaTotal();
                    break;
            }
        }

        System.out.println("\nCusto total da empresa com salários: R$ " + custoTotal);
        System.out.println("Custo com funcionários sem escolaridade: R$ " + custoSemEscolaridade);
        System.out.println("Custo com funcionários com ensino básico: R$ " + custoEnsinoBasico);
        System.out.println("Custo com funcionários com ensino médio: R$ " + custoEnsinoMedio);
        System.out.println("Custo com funcionários com graduação: R$ " + custoGraduacao);
    }
}
