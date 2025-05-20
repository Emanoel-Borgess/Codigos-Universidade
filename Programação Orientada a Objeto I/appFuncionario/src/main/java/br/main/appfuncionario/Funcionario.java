package br.main.appfuncionario;

/**
 *
 * @author sdc-daniel
 */
public class Funcionario {
    
    protected String nome;
    protected String secao;
    protected double salario;
    
    public Funcionario(){
    }
    
    public Funcionario(String nome, String secao, double salario){
    
        this.nome = nome;
        this.secao = secao;
        this.salario = salario;
    }
    
    public Funcionario(String nome, double salario){
    
        this.nome = nome;
        this.salario = salario;
    }
    
    public Funcionario(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public double bonificacao(){
        double valor = 0;
        valor = salario*(1+0.1);
        return valor;
    }
}
