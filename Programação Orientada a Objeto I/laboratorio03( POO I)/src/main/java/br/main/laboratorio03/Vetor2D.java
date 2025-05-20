/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio03;

/**
 *
 * @author Emanoel Borges
 */
public class Vetor2D {

    protected double x;
    protected double y;
    
    public Vetor2D(){
        this.x = 0.0;
        this.y = 0.0;
    }
    
    public Vetor2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
    
}
