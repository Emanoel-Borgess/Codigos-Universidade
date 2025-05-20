/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.laboratorio05ex02proxy;

/**
 *
 * @author Emanoel Borges
 */
public class ProxyArquivo implements Arquivo {
     private ArquivoConfidencial arquivoReal;
    private String usuario;

    public ProxyArquivo(String nome, String usuario) {
        this.arquivoReal = new ArquivoConfidencial(nome);
        this.usuario = usuario;
    }

    private boolean temPermissao() {
        // Simula uma verificação de permissão (poderia consultar um banco de dados, etc)
        return usuario.equals("admin");
    }

    public void abrir() {
        if (temPermissao()) {
            arquivoReal.abrir();
        } else {
            System.out.println("Acesso negado ao arquivo confidencial para o usuário: " + usuario);
        }
    }
}
