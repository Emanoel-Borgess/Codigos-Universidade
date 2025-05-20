<?php
 
    $dbHost = 'localhost'; //host do banco de dados
    $dbUsername = 'root'; // usuario do banco de dados
    $dbPassoword = ''; //senha do banco de dados
    $dbName = 'criar_conta'; //Nome do banco de dados

    $conexao = new mysqli($dbHost, $dbUsername, $dbPassoword, $dbName); //conexão com o banco de dados

    /*if ($conexao->connect_error) { //verifica se houve erro na conexão
        die("Erro de conexão: " . $conexao->connect_error); //caso tenha erro, exibe a mensagem de erro
    } else {
    echo "Conexão bem-sucedida"; //caso não tenha erro, exibe a mensagem de sucesso
   }*/
 

?>