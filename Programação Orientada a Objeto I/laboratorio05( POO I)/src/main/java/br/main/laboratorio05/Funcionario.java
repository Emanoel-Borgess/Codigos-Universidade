/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio05;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Emanoel Borges
 */
public class Funcionario {

    private String nome;
    private int codigoFuncional;
    private String escolaBasica;
    private String escolaMedia;
    private String universidade;
    private String curso;
    private final double RENDA_BASICA = 1000.0;
    private double rendaTotal;

    public Funcionario(String nome, int codigoFuncional, String escolaBasica, String escolaMedia, String universidade, String curso) {
        this.nome = nome;
        this.codigoFuncional = codigoFuncional;
        this.escolaBasica = escolaBasica;
        this.escolaMedia = escolaMedia;
        this.universidade = universidade;
        this.curso = curso;
        calcularRenda();
    }

    private void calcularRenda() {
        if (universidade != null) {
            rendaTotal = RENDA_BASICA * 2; // 100% a mais
        } else if (escolaMedia != null) {
            rendaTotal = RENDA_BASICA * 1.5; // 50% a mais
        } else if (escolaBasica != null) {
            rendaTotal = RENDA_BASICA * 1.1; // 10% a mais
        } else {
            rendaTotal = RENDA_BASICA;
        }
    }

    public double getRendaTotal() {
        return rendaTotal;
    }

    public String getNivelEscolaridade() {
        if (universidade != null) return "Graduação";
        if (escolaMedia != null) return "Ensino Médio";
        if (escolaBasica != null) return "Ensino Básico";
        return "Sem Escolaridade";
    }

    @Override
    public String toString() {
        return "Código: " + codigoFuncional + ", Nome: " + nome + ", Escolaridade: " + getNivelEscolaridade() + ", Salário: R$ " + rendaTotal;
    }
}