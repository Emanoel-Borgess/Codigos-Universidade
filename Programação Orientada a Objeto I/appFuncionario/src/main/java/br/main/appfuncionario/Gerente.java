/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appfuncionario;

/**
 *
 * @author sdc.daniel
 */
public class Gerente extends Funcionario {
    private String secretaria;
    
    public Gerente(String secretaria){
        this.secretaria = secretaria;
    }
    
    public Gerente(String nome, Double salario, String secretaria){
        super(nome,salario);
        this.secretaria = secretaria;
    }
    
    public Gerente(String nome,String secretaria){
        super(nome);
        this.secretaria = secretaria;
    }
    
    public Gerente(String nome, String secao, Double salario, String secretaria){
        super(nome,secao,salario);
        this.secretaria = secretaria;
    }
    
    public String getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }
    
    @Override
    public double bonificacao(){
        this.salario = this.salario*(1+0.15);
        return this.salario;
    }
}
