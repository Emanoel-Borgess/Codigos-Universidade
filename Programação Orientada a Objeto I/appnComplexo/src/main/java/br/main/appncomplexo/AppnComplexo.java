/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.appncomplexo;

/**
 *
 * @author dantutu
 */
public class AppnComplexo {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        NComplexo n1 = new NComplexo(1.0,1.0);
        n1.setReal(5.5);
        n1.setImg(5.5);
        n1.printComplexo();
        NComplexo n2 = new NComplexo(1.0,1.0);
        NComplexo soma = new NComplexo();
        soma = n2.soma(n1);
        soma.printComplexo();
        System.out.println("Modulo:"+soma.modulo());
        System.out.println("Argumento:"+soma.argumento());
        
    }
}
