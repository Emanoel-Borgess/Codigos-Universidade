/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.apppoli;

/**
 *
 * @author sdc.daniel
 */
public class Calculadora {
    
    public double a;
    public double b;
    public String x;
    
    public Calculadora(double a, double b, String x){
        this.a = a;
        this.b = b;
        this.x = x;
    }
    
    public double calcular(){
        double resposta = 0;
        
        if(x.equals("+"))
            resposta =  a + b;
        if(x.equals("-"))
            resposta =  a - b;
        if(x.equals("/"))
            resposta =  a / b;
        if(x.equals("*"))
            resposta = a * b;
        return resposta;       
    }
}
