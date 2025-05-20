/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.main.appfileserializado;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author sdc.daniel
 */
public class RandomAccessAccountRecord extends AccountRecord{
    //Classe base para inserção dos dados
    //um inteiro int (4 bytes);
    //um string 15 caracteres tem 30 bytes: 2 string 60 bytes;
    //um double tem 8 bytes;
    //Total de bytes do nosso registro é: 72 bytes
    public static final int SIZE = 72;
    
    //Construtor nulo para atribuição dos valores dos atributos da classe
    public RandomAccessAccountRecord(){
        super(0,"","",0.0);
    }
    
    //Construtor com todos os parâmetros
    public RandomAccessAccountRecord(Integer account,String firstName, String lastName, Double balance){
        super(account,firstName,lastName,balance);
    }
    
    //Método para ler as informações do arquivo e atualizar nos atributos da classe
    public void read(RandomAccessFile file) throws IOException{
        setAccount(file.readInt());
        setFirstName(readName(file));
        setLastName(readName(file));
        setBalance(file.readDouble());
    }
    
    //Definição do método para ler string do arquivo
    public String readName(RandomAccessFile file) throws IOException{
     char name[] = new char[15], temp;
     //definindo a estrutura de repetição para leitura correta da string
     for(int count=0;count<name.length;count++){
         temp = file.readChar();
         name[count] = temp;
     }
        return new String(name).replace('\0', ' ');
    }
    
    //Método para gravar um registro RandomFileAccess especificado
    public void write(RandomAccessFile file) throws IOException{
        file.writeInt(getAccount());
        writeName(file,getFirstName());
        writeName(file,getLastName());
        file.writeDouble(getBalance());
    }
    
    //Método para escrever cada conjunto de caracter no registro
    public void writeName(RandomAccessFile file, String name) throws IOException{
        StringBuffer buffer = null;
        if(name!=null)
            buffer = new StringBuffer(name);
        else
            buffer = new StringBuffer(15);
        
        buffer.setLength(15);
        file.writeChars(buffer.toString());
    }
}
