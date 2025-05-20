/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.apppoli;

/**
 *
 * @author sdc.daniel
 */
public class AppPoli {

    public static void main(String[] args) {
        //Testando a classe calculadora: sem herança e polimorfismo
        Calculadora calc = new Calculadora(5.5,5.5,"-");
        System.out.println("Resultado:"+calc.calcular());
    }
}
