<!--Pronto-->
<?php
// Conexão com o banco de dados
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "criar_conta";

$conexao = new mysqli($servername, $username, $password, $dbname);

if ($conexao->connect_error) {
    die("Falha na conexão: " . $conexao->connect_error);
}

// Apagar cookie para permitir novo feedback
if (isset($_GET['novamente']) && $_GET['novamente'] == '1') {
    setcookie("feedback_enviado", "", time() - 3600);
    header("Location: feedback_login.php");
    exit;
}

$feedback_enviado = isset($_COOKIE["feedback_enviado"]);

if ($_SERVER["REQUEST_METHOD"] == "POST" && !$feedback_enviado) {
    $nome = $conexao->real_escape_string($_POST["nome"]);
    $mensagem = $conexao->real_escape_string($_POST["feedback"]);

    if (!empty($nome) && !empty($mensagem)) {
        $sql = "INSERT INTO feedbacks (nome, mensagem) VALUES ('$nome', '$mensagem')";
        if ($conexao->query($sql)) {
            setcookie("feedback_enviado", "1", time() + 3600);
            $feedback_enviado = true;
        }
    }
}

// Fechar a conexão após o processo de envio
$conexao->close();
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>GameStar - FeedBack</title>
  <link rel="shortcut icon" href="Imagens/Imagens/launcher-logo.png" type="image/x-icon" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" />
  <style>
    body {
      background-color:#121212;
      color: white;
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
    }
    h2 {
      text-align: center;
    }
    textarea, input[type="text"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border-radius: 5px;
      border: 1px solid #ccc;
    }
    input[type="submit"] {
      background-color: #ffa500;
      color: white;
      border: none;
      padding: 10px 20px;
      cursor: pointer;
      border-radius: 5px;
    }
    input[type="submit"]:hover {
      background-color: #e69500;
    }
    .btn-laranja {
      background-color: #ffa500;
      color: rgb(0, 0, 0);
      font-weight: bold;
    }
    .hero {
      background-image: url("Imagens/Imagens/capafeed.png");
      background-size: cover;
      background-position: center;
      padding: 100px 20px;
      text-align: center;
    }
    .hero-content {
      background-color: rgba(0, 0, 0, 0.7);
      padding: 20px;
      border-radius: 10px;
      color: white;
    }
    .logo {
      font-size: 24px;
      font-weight: bold;
      color: #ffa500;
      text-decoration: none;
    }
    .logo2{
      font-size: 30px;
      font-weight: bold;
      color: #ffa500;
      text-decoration: none;
    }
    .nav-link {
      color: white !important;
    }
    footer {
      margin-top: 40px;
    }
    /* Estilo para os feedbacks lado a lado */
    .feedback-item {
      background-color: rgb(255, 196, 101);
      padding: 15px;
      border-radius: 10px;
      margin-bottom: 15px;
    }
    .img-container {
      background-color: rgb(255, 196, 101); /* Fundo claro para a imagem */
      padding: 20px;
      border-radius: 250px;
    }
  </style>
</head>
<body>

<!-- Cabeçalho -->
<header class="container-fluid d-flex flex-wrap justify-content-between align-items-center p-3 bg-black">
  <a href="pagina.php" class="logo">GameStar</a>
  <nav>
    <ul class="nav flex-wrap">
      <li class="nav-item"><a class="nav-link" href="jogos.php">Jogos</a></li>
      <li class="nav-item"><a class="nav-link" href="videos.php">Vídeos</a></li>
      <li class="nav-item"><a class="nav-link" href="downloads_login.php">Downloads</a></li>
      <li class="nav-item"><a class="nav-link" href="feedback_login.php">FeedBack</a></li>
      <li class="nav-item"><a class="nav-link" href="suporte_login.php">Fórum</a></li>
    </ul>
  </nav>
  <div class="d-flex align-items-center gap-3 mt-2 mt-md-2">
    <a href="launcher.php"><button class="btn btn-laranja">Obter Launcher</button></a>
    <div class="dropdown">
            <button class="btn btn-laranja dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                Usuário
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <li><a class="dropdown-item" href="editar_perfil.php">Editar perfil</a></li>
                <li><a class="dropdown-item" href="excluir_perfil.php">Excluir perfil</a></li>
                <li><a class="dropdown-item" href="sair.php">Sair</a></li>
            </ul>
        </div>
  </div>
</header>

<!-- Hero--> 
<section class="hero text-center text-white">
  <div class="container hero-content">
    <h1>Sua opinião é muito importante</h1>
    <p>Envie sugestões, avaliações e ajude a melhorar nossos jogos e serviços</p>
  </div>
  </section>

  <div class="container">
  <div class="row">
    <!-- COLUNA DOS FEEDBACKS (à esquerda) -->
    <div class="col-lg-5 mb-5 mt-4">
      <h2 class="logo2">Se liga nesses feedbacks!</h2>
      <div class="row">
        <?php
        // Reabrindo conexão para buscar feedbacks recentes
        $conexao = new mysqli("localhost", "root", "", "criar_conta");
        if ($conexao->connect_error) {
            die("Erro ao conectar para buscar feedbacks: " . $conexao->connect_error);
        }

        $sql = "SELECT nome, mensagem FROM feedbacks ORDER BY id DESC LIMIT 6";
        $result = $conexao->query($sql);

        if ($result->num_rows > 0):
          while($row = $result->fetch_assoc()):
        ?>
        <div class="col-md-12 mb-3">
          <div class="feedback-item text-black p-3 rounded feedback_box">
            <strong><?= htmlspecialchars($row["nome"]) ?></strong>
            <p><?= nl2br(htmlspecialchars($row["mensagem"])) ?></p>
          </div>
        </div>
        <?php endwhile; endif; $conexao->close(); ?>
      </div>
    </div>

    <!-- COLUNA DO FORMULÁRIO (à direita) -->
    <div class="col-lg-7 mb-3 mt-1">
      <div class="feedback">
        <h2 class="text-center"><strong>Deixe seu Feedback</strong></h2>
        <h4 class="text-center">Ele é muito importante para nós!</h4>

        <?php if ($feedback_enviado): ?>
          <div class="alert alert-success mt-4 text-black">
            <strong>Obrigado pelo seu feedback!</strong><br><br>
            <a href="?novamente=1">
              <button class="btn btn-laranja">Enviar outro feedback?</button>
            </a>
          </div><!--O botao esta saindo d pagina quando pede para enviar um feedback novamente-->
        <?php else: ?>
          <form method="post" action="">
            <label for="nome" class="text-black"><strong>Seu nome</strong></label>
            <input type="text" id="nome" name="nome" required class="form-control mb-2">

            <label for="feedback" class="text-black"><strong>Seu feedback</strong></label>
            <textarea id="feedback" name="feedback" rows="3" required class="form-control mb-3"></textarea>

            <input class="btn btn-laranja text-black" type="submit" value="Enviar">
          </form>
        <?php endif; ?>
      </div>
    </div>
  </div>
</div>


<!-- Rodapé -->
<footer class="bg-black text-light text-center py-4">
  <div class="container">
    <p class="logo">GameStar</p>
    <p class="mt-2 mb-1">
      <strong>Desenvolvedores <br />Emanoel Borges e Pedro Vieira</strong>
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

<!-- Scripts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>