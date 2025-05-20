/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.prjaula02;

/**
 *
 * @author Emanoel Borges
 */
public class PrjAula02 {

    public static void main(String[] args) {
      //  Cachorro Rex = new Cachorro();
      //  Rex.latir();
       // Cachorro Rex = new Cachorro("Latino");
        //Rex.latir();
        Cachorro Rex = new Cachorro("Carniço",25);
        System.out.println("Nome:"+Rex.getNome());
        System.out.println("Peso:"+Rex.getPeso());
        Rex.setNome("Sadan");
        Rex.setPeso(50);
        Rex.comer();
    }
}
