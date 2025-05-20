/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.appconta;

import java.text.DecimalFormat;

/**
 *
 * @author Emanoel Borges
 */
public class AppConta {
    public static void main(String[] args) {
        
        Conta teste01 = new Conta();
        Conta teste02 = new Conta("Emanoel",1400.0);
        
        teste01.setNome("Bianca");
        teste01.setSaldo(1500.0);
        
        imprimirDados(teste01);
        imprimirDados(teste02);
        
        teste01.lerDados();
        imprimirDados(teste01);
    }
        
    public static void imprimirDados(Conta conta){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Nome: " + conta.getNome());
        System.out.println("Saldo: " + df.format(conta.getSaldo()));
    }
}
