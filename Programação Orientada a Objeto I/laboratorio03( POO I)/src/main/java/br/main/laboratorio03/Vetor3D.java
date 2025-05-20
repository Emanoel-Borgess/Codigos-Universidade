/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio03;

/**
 *
 * @author Emanoel Borges
 */
public class Vetor3D extends Vetor2D {

    private double z;
    
    public Vetor3D(){
        super();
        this.z = 0.0;
    }
    
    public Vetor3D(double x, double y, double z){
        super(x, y);
        this.z = z;
    }
    
    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
    public Vetor3D produtoVetorial(Vetor3D v){
        return new Vetor3D(
            this.y * v.z - this.z * v.y,
            this.z * v.x - this.x * v.z,
            this.x * v.y - this.y * v.x
        );
    }
    
    public double modulo(){
        return Math.sqrt(x * x + y * y + z * z);
    }
    
}
