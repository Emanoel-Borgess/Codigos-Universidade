/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abstracao;

/**
 *
 * @author sdc.daniel
 */
public abstract class Calculador {
    protected double a;
    protected double b;
    
    public Calculador(double a, double b){
        this.a=a;
        this.b=b;
    }
    //Toda classe abstrata deve ter pelo menos um método abstrato
    public abstract double calcular();
    
}
