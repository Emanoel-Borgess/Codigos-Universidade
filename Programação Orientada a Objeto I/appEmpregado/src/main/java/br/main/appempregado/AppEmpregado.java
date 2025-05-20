/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.main.appempregado;

import java.util.Scanner;

/**
 *
 * @author sdc.daniel
 */
public class AppEmpregado {

    //Gerando lista de Empregados
    Empregado empregados[] = new Empregado[10];
    //Objeto para ler os dados dos empregados
    Scanner input = new Scanner(System.in);
    //Variável de controle da estrutura de repetição
    Integer index = 0;
    
    public static void main(String[] args) {
        //Variavel para leitura das opções do menu
        Scanner menuOps = new Scanner(System.in);
        //Criando um objeto da classe Main para acessar os métodos auxiliares
        AppEmpregado operacoes = new AppEmpregado();
        //Variável auxiliar para guardar as opcoes lidas
        Integer opcoes;
        //Criando o menu de opcoes
        do{
            System.out.println("Bem vindo ao Menu de Contabilidade e Recursos Humanos!");
            System.out.println("[1]-Cadastrar Empregado CLT");
            System.out.println("[2]-Cadastrar Empregado Horista");
            System.out.println("[3]-Imprimir a Lista de Empregados");
            System.out.println("[4]-Sair");
            System.out.println("Digite a opção desejada:");
            opcoes = menuOps.nextInt();
            switch (opcoes) {
                case 1:
                    //Cadastrar Empregado CLT;
                    operacoes.inserirCLT();
                    break;
                case 2:
                    //Cadastrar Empregado Horista;
                    operacoes.inserirHorista();
                    break;
                case 3:
                    //Imprimir Lista
                    operacoes.imprimirLista();
                    break;
                case 4:
                    //Sair;
                    System.out.println("Sair");
                    break;                    
                default:
                    System.out.println("Opção Inválida!!!");
                    break;
            }
        }while(opcoes!=4);
    }
    
    public void inserirCLT(){
        //Criando objeto da classe CLT temporario
        EmpregadoCLT temp = new EmpregadoCLT();
        //Chamando o metodo da classe para inserir os dados
        temp.inserirDadosCLT();
        empregados[index]=temp;//Atribuindo o conteudo do objeto a posição da lista
        index++; //Incrementando a variável porque foi inserido um novo elemento 
    }
    
    public void inserirHorista(){
        //Criando objeto da classe Horista temporario
        EmpregadoHorista temp = new EmpregadoHorista();
        //Chamando o metodo da classe para inserir os dados
        temp.inserirDadosHorista();
        empregados[index]=temp;//Atribuindo o conteudo do objeto a posição da lista
        index++; //Incrementando a variável porque foi inserido um novo elemento         
    }
    
    public void imprimirLista(){
        //Estrutura de repetição para imprimir os Empregados
        for(int count =0;count<index;count++)
        {
            //Imprimindo dados gerais de cada empregado
            System.out.println("Nome:"+empregados[count].getNome());
            System.out.println("CPF:"+empregados[count].getCpf());
            System.out.println("Endereço:"+empregados[count].getEndereco());
            //Como as informações não são genéricas temos que verificar qual é o tipo
            //do objeto da lista: CLT ou Horista
            if(empregados[count]instanceof EmpregadoCLT){ //se for EmpregadoCLT então imprime
                //Imprimindo o Salario bruto e o Salario Líquido
                System.out.println("Salário Bruto:");
                EmpregadoCLT temp = (EmpregadoCLT)(empregados[count]); //Cast para deixar os dados compativeis
                System.out.print(temp.getsBrutoCLT());
                System.out.println("Salário Líquido:"+temp.sLCLT());     
            }
            //Verificando se é horista
            if(empregados[count]instanceof EmpregadoHorista){ //se for Horista então imprime
            //Imprimindo o Salario bruto e o Salario Líquido
            EmpregadoHorista temp = (EmpregadoHorista)(empregados[count]); //Cast para deixar os dados compativeis
            System.out.println("Número de Horas:"+temp.getnHoras());
            System.out.println("Preço das Horas:"+temp.getPrecoH()); 
            System.out.println("Salário Líquido:"+temp.sLH());
        }  
        }
    }
    
}
