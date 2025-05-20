/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio01;

/**
 *
 * @author Emanoel Borges
 */
public class Vetor2D {
    
    private double x;
    private double y;

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
    
    public Vetor2D(){
        this.x = 0.0;
        this.y = 0.0;
    }
    public Vetor2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    
     public double produtoEscalar(Vetor2D v) {
        return this.x * v.x + this.y * v.y;
    }

    // Módulo do vetor
    public double modulo() {
        return Math.sqrt(x * x + y * y);
    }

    // Ângulo entre dois vetores em radianos
    public double anguloEntre(Vetor2D v) {
        double produtoEscalar = this.produtoEscalar(v);
        double modulos = this.modulo() * v.modulo();
        if (modulos == 0) return 0; // Evita divisão por zero
        return Math.acos(produtoEscalar / modulos);
    }

    // Projeção do vetor atual sobre o vetor v
    public Vetor2D projecaoSobre(Vetor2D v) {
        double produtoEscalar = this.produtoEscalar(v);
        double moduloQuadrado = v.produtoEscalar(v);
        if (moduloQuadrado == 0) return new Vetor2D(0, 0); // Evita divisão por zero
        double escalar = produtoEscalar / moduloQuadrado;
        return new Vetor2D(escalar * v.x, escalar * v.y);
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}