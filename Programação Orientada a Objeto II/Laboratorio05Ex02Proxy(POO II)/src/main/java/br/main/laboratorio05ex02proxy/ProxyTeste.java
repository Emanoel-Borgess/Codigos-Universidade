/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.laboratorio05ex02proxy;

/**
 *
 * @author Emanoel Borges
 */
public class ProxyTeste {
    public static void main(String[] args) {
        Arquivo arquivo1 = new ProxyArquivo("dados_seguros.txt", "admin");
        arquivo1.abrir();

        System.out.println();

        Arquivo arquivo2 = new ProxyArquivo("dados_seguros.txt", "convidado");
        arquivo2.abrir();
    }
}
