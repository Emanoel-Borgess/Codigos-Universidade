<?php
$host = "localhost";
$usuario = "root";
$senha = "";
$banco = "empresa";

// Criar conexão
$mysqli = new mysqli($host, $usuario, $senha, $banco);

// Verificar erro
if ($mysqli->connect_error) {
    die("Erro na conexão: " . $mysqli->connect_error);
}
?>
