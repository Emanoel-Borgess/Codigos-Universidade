/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Heranca;

/**
 *
 * @author sdc.daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Testando polimorfismo com herança
        //Testando as classes
        //Testando a classe Pai
//        Calculador calc01 = new Calculador(0.5,0.5);
//        System.out.println("Valor:"+calc01.calcular());
//        
//        //Testando a classe Divisao
//        Divisao calc02 = new Divisao(0.5,0.5);
//        System.out.println("Valor:"+calc02.calcular());
//        
//        //Testando a classe Multiplicacao
//        Multiplicacao calc03 = new Multiplicacao(0.5,0.5);
//        System.out.println("Valor:"+calc03.calcular());    
//        
//        //Testando a classe Soma
//        Soma calc04 = new Soma(0.5,0.5);
//        System.out.println("Valor:"+calc04.calcular()); 
//        
//        //Testando a classe Subtracao
//        Substracao calc05 = new Substracao(0.5,0.5);
//        System.out.println("Valor:"+calc05.calcular());           
        
            //Testar usando polimorfismo
            Calculador calc = new Substracao(0.5,0.5);
            System.out.println("Valor:"+calc.calcular());           
            
    }
    
}
