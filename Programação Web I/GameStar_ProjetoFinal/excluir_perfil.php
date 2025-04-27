<?php
session_start();
if ((!isset($_SESSION['email']) == true) and (!isset($_SESSION['senha']) == true)) {
    unset($_SESSION['email']);
    unset($_SESSION['senha']);
    header('location: login.php');
} else {
    $logado = $_SESSION['email'];
}

// Conexão com o banco de dados
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "criar_conta";

$conexao = new mysqli($servername, $username, $password, $dbname);

if ($conexao->connect_error) {
    die("Conexão falhou: " . $conexao->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $sql = "DELETE FROM usuarios WHERE email='$logado'";

    if ($conexao->query($sql) === TRUE) {
        echo "Conta excluída com sucesso!";
        session_destroy();
        header('location: pagina.html');
    } else {
        echo "Erro ao excluir conta: " . $conexao->error;
    }
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>GameStar - Excluir Perfil</title>
  <link rel="shortcut icon" href="Imagens/Imagens/launcher-logo.png" type="image/x-icon" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    html, body {
      height: 100%;
      margin: 0;
      padding: 0;
      display: flex;
      flex-direction: column;
    }

    body {
      background-color: #121212;
      color: white;
    }

    main {
      flex: 1;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }

    .btn-laranja {
      background-color: #ffa500;
      color: black;
      font-weight: bold;
    }

    .feedback {
      max-width: 650px;
      margin: auto;
      background: rgb(255, 196, 101);
      color: black;
      padding: 20px;
      border-radius: 10px;
      margin-top: 30px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }

    .feedback_box {
      background: rgb(255, 196, 101);
      border-radius: 10px;
    }

    .logo {
      font-size: 24px;
      font-weight: bold;
      color: #ffa500;
      text-decoration: none;
    }
  </style>
</head>
<body>
  <main class="container">
    <h2>Excluir Perfil</h2>
    <p>Tem certeza de que deseja excluir sua conta?</p>
    <form method="POST">
      <button type="submit" class="btn btn-danger text-black">Excluir conta</button>
      <a class="btn btn-laranja" href="pagina.php" role="button">Cancelar</a>
    </form>
  </main>

  <!-- Rodapé -->
  <footer class="bg-black text-light text-center py-4 mt-auto">
    <div class="container">
      <p class="logo">GameStar</p>
      <p class="mt-2 mb-1">
        <strong>Emanoel Borges e Pedro Vieira</strong>
      </p>
      <p class="mb-3">
        <strong>© 2025 GameStar. Todos os direitos reservados.</strong>
      </p>

      <div class="d-flex justify-content-center gap-3">
        <a href="#" class="text-light">
          <i class="bi bi-facebook fs-4"></i> Facebook
        </a>
        <a href="#" class="text-light">
          <i class="bi bi-twitter fs-4"></i> Twitter
        </a>
        <a href="#" class="text-light">
          <i class="bi bi-instagram fs-4"></i> Instagram
        </a>
        <a href="#" class="text-light">
          <i class="bi bi-youtube fs-4"></i> Youtube
        </a>
      </div>
    </div>
  </footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
