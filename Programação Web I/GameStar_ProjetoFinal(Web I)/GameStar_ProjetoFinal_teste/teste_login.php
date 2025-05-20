<?php
session_start();
    //Parametros que vem do login
    //print_r($_REQUEST);

    //Verifica se foi submitado o formulário de login
    if(isset($_POST['submit']) && !empty($_POST['email']) && !empty($_POST['senha'])){
        //Acessa o sitema 
        include_once('configuracao.php');
        $email = $_POST['email'];
        $senha = $_POST['senha'];

        //print_r('Email: ' . $email);
        //print_r('<br>');
        //print_r('Senha: ' . $senha);

        $sql = "SELECT * FROM usuarios WHERE email = '$email' AND senha = '$senha'";

        $result = $conexao->query($sql);
        //print_r($_result);
        //print_r($_sql);

        if(mysqli_num_rows($result) < 1){

            unset($_SESSION['email']);
            unset($_SESSION['senha']);
            print_r('Email ou senha incorretos!');
            header("location: login.php");
        }else{

            $_SESSION['email'] = $email;
            $_SESSION['senha'] = $senha;
            print_r('Login realizado com sucesso!');
            header("location: pagina.php");
        }

    }else{
        //Não acessa e retorna para o login
        header("loction: login.php");
    }



?>