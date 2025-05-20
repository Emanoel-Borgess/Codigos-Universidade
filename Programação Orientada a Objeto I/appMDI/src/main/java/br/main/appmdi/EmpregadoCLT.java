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
public class EmpregadoCLT extends Empregado {

    private Double sBrutoCLT;
    
    public EmpregadoCLT(){
        sBrutoCLT = 0.0;
    }
    
    public EmpregadoCLT(String n, String end, String cpf2, Double sBruto){
        nome = n;
        endereco = end;
        cpf = cpf2;
        sBrutoCLT = sBruto;
    }

    public Double getsBrutoCLT() {
        return sBrutoCLT;
    }

    public void setsBrutoCLT(Double sBrutoCLT) {
        this.sBrutoCLT = sBrutoCLT;
    }
    
    public Double sLCLT(){
        if(sBrutoCLT<=5000.0)
            sBrutoCLT = sBrutoCLT*0.85;
        else
            sBrutoCLT = sBrutoCLT*0.725;
        return sBrutoCLT;
    }
    
    public void inserirDadosCLT(){
        input = new Scanner(System.in);
        super.inserirDadosEmpregados();
        System.out.println("Digite o salario bruto:");
        sBrutoCLT = input.nextDouble();
    }
    
}
