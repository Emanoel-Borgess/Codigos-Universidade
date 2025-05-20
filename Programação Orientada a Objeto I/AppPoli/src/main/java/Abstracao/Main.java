/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Abstracao;

/**
 *
 * @author sdc.daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculador calc = new Soma(0.5,0.5);
        System.out.println("Valor:"+calc.calcular());
    }
    
}
