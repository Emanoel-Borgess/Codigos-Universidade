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

// Verificar conexão
if ($conexao->connect_error) {
    die("Conexão falhou: " . $conexao->connect_error);
}

// Buscar nome e email do usuário no banco de dados
$nome = "";
$email = "";
$sql = "SELECT nome, email FROM usuarios WHERE email='$logado'";
$result = $conexao->query($sql);
if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
    $nome = $row['nome'];
    $email = $row['email'];
} else {
    echo "Usuário não encontrado!";
}

// Verificar se o formulário foi enviado
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Capturar os dados do formulário
    $nome = $_POST['nome'];
    $email = $_POST['email'];

    // Preparar a consulta UPDATE
    $sql = "UPDATE usuarios SET nome='$nome', email='$email' WHERE email='$logado'";

    // Executar a consulta
    if ($conexao->query($sql) === TRUE) {
        echo "Perfil atualizado com sucesso!";
        $_SESSION['email'] = $email;  // Atualiza a sessão com o novo email
    } else {
        echo "Erro ao atualizar perfil: " . $conexao->error;
    }
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GameStar - Editar Perfil</title>
    <link rel="shortcut icon" href="Imagens/Imagens/launcher-logo.png" type="image/x-icon" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
      background-color:#121212;
      color: white;
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
    .feedback_box{
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
    <div class="container">
      <div class="row">
      <div class="col-lg-7 mb-3 mt-1">
          <div class="feedback">
            <img src="Imagens/Imagens\resume-animate-login.svg" alt="">
          </div>
        </div>
        <!-- COLUNA DOS FEEDBACKS (à esquerda) -->
        <div class="col-lg-5 mb-5 mt-4">
          <div class="row">
          <h2 class="text-warning text-center" >Editar Perfil</h2>
        <form method="POST">
            <div class="mb-3 feedback">
                <label for="nome" class="form-label">Nome</label>
                <input type="text" class="form-control" id="nome" name="nome" value="<?php echo htmlspecialchars($nome); ?>" required>
            </div>
            <div class="mb-3 feedback">
                <label for="email" class="form-label">E-mail</label>
                <input type="email" class="form-control" id="email" name="email" value="<?php echo htmlspecialchars($email); ?>" required>
            </div>
            <button type="submit" class="btn btn-laranja">Salvar alterações</button>
            <a class="btn btn-laranja" href="pagina.php" role="button">Voltar</a>
        </form>
          </div>
        </div>
      </div>
    </div>

    <!-- Rodapé -->
    <footer class="bg-black text-light text-center py-4 mt-auto">
      <div class="container">
        <p class="logo">GameStar</p>
        <p class="mt-2 mb-1">
          <strong
            >Desenvolvedores <br />
            Emanoel Borges e Pedro Vieira</strong
          >
        </p>
        <p class="mb-3">
          <strong>© 2025 GameStar. Todos os direitos reservados.</strong>
        </p>

        <div class="d-flex justify-content-center gap-3">
          <a href="#" class="text-light">
            <i class="bi bi-facebook fs-4"></i>Facebook
          </a>
          <a href="#" class="text-light">
            <i class="bi bi-twitter fs-4"></i>Twitter
          </a>
          <a href="#" class="text-light">
            <i class="bi bi-instagram fs-4"></i>Instagram
          </a>
          <a href="#" class="text-light">
            <i class="bi bi-youtube fs-4"></i>Youtube
          </a>
        </div>
      </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
