/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appmdi;

import java.util.Scanner;

/**
 *
 * @author sdc.daniel
 */
public class EmpregadoHorista extends Empregado {

    private Integer nHoras;
    private Double precoH;
    
    public EmpregadoHorista(){
        nHoras = 0;
        precoH = 0.0;
    }
    
    public EmpregadoHorista(String no, String end, String cpf2, Integer horas, Double preco){
        nome = no;
        endereco = end;
        cpf = cpf2;
        nHoras = horas;
        precoH = preco;
    }
    
    public Integer getnHoras() {
        return nHoras;
    }

    public void setnHoras(Integer nHoras) {
        this.nHoras = nHoras;
    }

    public Double getPrecoH() {
        return precoH;
    }

    public void setPrecoH(Double precoH) {
        this.precoH = precoH;
    }  
    
    public Double sLH(){
        return nHoras*precoH*0.85;
    }
    
    public void inserirDadosHorista(){
        input = new Scanner(System.in);
        super.inserirDadosEmpregados();
        System.out.println("Digite o preço da hora:");
        precoH = input.nextDouble();
        System.out.println("Digite o numero de horas trabalhada:");
        nHoras = input.nextInt();
    }
}
