/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.appfuncionario;

/**
 *
 * @author sdc.daniel
 */
public class AppFuncionario {

    public static void main(String[] args) {
        //Funcionario nEmpr = new Funcionario("Daniel","TI",1000);
        //System.out.println("Nome:"+nEmpr.getNome());
        //System.out.println("Departamento:"+nEmpr.getSecao()); 
        //System.out.println("Salário:"+nEmpr.getSalario());
        //System.out.println("Bonificação:"+ nEmpr.bonificacao()); 
        
        Gerente pascoal = new Gerente("Joel",2000.00,"Margot");
        System.out.println("Nome Secretaria:"+pascoal.getSecretaria());
        System.out.println("Bonificação:"+pascoal.bonificacao());
    }
}
