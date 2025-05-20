/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Heranca;

/**
 *
 * @author sdc.daniel
 */
public class Soma extends Calculador{
    
    public Soma(double a, double b) {
        super(a, b);
    }
    
    @Override
    public double calcular(){
       return a+b; 
    }
    
}
