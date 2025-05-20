/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.prjaula02;

/**
 *
 * @author Emanoel Borges
 */
public class Cachorro {
    private Integer idade; //Atributo ou Característica
    private Integer peso;
    private String cor;
    private String nome;

    //Getters e setters
    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    //Definição dos construtores
    public Cachorro(){
        //Construtor nulo
    }
    
    public Cachorro(String nome){//Construtor com parâmetro
        this.nome = nome;
    }
    
    public Cachorro(String nome, Integer peso){//Construtor com 2 parâmetros
        this.nome = nome;
        this.peso = peso;
    }
    
    //Definição de métodos ou ações
    public void latir(){ //Método ou ação
        //linhas de código que representa o latir
        System.out.println("Nome:"+nome);
        System.out.println("Au au au");
    }
    public void comer(){
        System.out.println("Nome:"+nome);
        System.out.println("Peso:"+peso);
    }
    public void dormir(){
        
    }
}
