<?php
$conexao = new mysqli("localhost", "root", "", "criar_conta");
if ($conexao->connect_error) {
  die("Erro na conexão: " . $conexao->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["id"], $_POST["resposta"])) {
  $id = (int)$_POST["id"];
  $resposta = $conexao->real_escape_string($_POST["resposta"]);

  $conexao->query("UPDATE suporte SET resposta = '$resposta' WHERE id = $id");
}

header("Location: suporte_login.php");
exit;
