<!-- Pronta-->
<?php
// Conexão com o banco de dados
$conexao = new mysqli("localhost", "root", "", "criar_conta");
if ($conexao->connect_error) {
  die("Falha na conexão: " . $conexao->connect_error);
}

// Inserção de novos chamados
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["nome"], $_POST["email"], $_POST["mensagem"])) {
  $nome = $conexao->real_escape_string($_POST["nome"]);
  $email = $conexao->real_escape_string($_POST["email"]);
  $mensagem = $conexao->real_escape_string($_POST["mensagem"]);

  $conexao->query("INSERT INTO suporte (nome, email, mensagem) VALUES ('$nome', '$email', '$mensagem')");
}

// Consulta para listar chamados
$result = $conexao->query("SELECT * FROM suporte ORDER BY id DESC");
?>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="shortcut icon"
      href="Imagens/Imagens/launcher-logo.png"
      type="image/x-icon"
    />
    <title>GameStar - Fórum</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css"
    />
    <style>
      body {
        background-color: #121212;
        color: white;
      }
      .feedback-item {
      background-color: rgb(255, 196, 101);
      padding: 15px;
      border-radius: 10px;
      margin-bottom: 15px;
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
      .logo {
        font-size: 24px;
        font-weight: bold;
        color: #ffa500;
        text-decoration: none;
      }
      .btn-laranja {
        background-color: #ffa500;
        color: black;
        font-weight: bold;
      }
      .hero {
        background-image: url("Imagens/Imagens/capasuporte.jpg");
        background-size: cover;
        background-position: center;
        padding: 100px 20px;
      }
      .hero-content {
        background: rgba(0, 0, 0, 0.7);
        padding: 20px;
        border-radius: 10px;
      }
      .color {
        background-color: #ffa500;
        border-radius: 50px;
        padding: 10px;
      }
      .destaque img {
        border-radius: 10px;
      }
      .rodape {
        color: #ffa500;
      }
      .jogo-card:hover {
        transition: transform 0.3s, box-shadow 0.3s;
        border: 1px solid #ffa500;
        background-color: rgb(0, 0, 0);
        transform: translateY(-5px);
        box-shadow: 0 4px 20px rgb(190, 137, 2);
      }
    </style>
  </head>
  <body>
    <!-- Cabeçalho responsivo -->
    <header
      class="container-fluid d-flex flex-wrap justify-content-between align-items-center p-3 bg-black"
    >
      <a href="pagina.php" class="logo">GameStar</a>
      <nav>
        <ul class="nav flex-wrap">
          <li class="nav-item">
            <a class="nav-link text-white" href="jogos.php">Jogos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="videos.php">Vídeos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="downloads_login.php">Downloads</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="feedback_login.php">FeedBack</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="suporte_login.php">Fórum</a>
          </li>
        </ul>
      </nav>
      <div class="d-flex align-items-center gap-3 mt-2 mt-md-2">
        <a href="launcher.php"
          ><button class="btn btn-laranja">Obter Launcher</button></a
        >
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

    <!-- Seção hero -->
    <section class="hero text-center text-white">
      <div class="container hero-content">
        <h1>Ajuda e soluções para você</h1>
        <p>
          Encontre respostas, tire suas dúvidas e interaja com outros jogadores.
        </p>
      </div>
    </section>
    
<div class="container">
      <div class="row">
        <!-- COLUNA DOS FEEDBACKS (à esquerda) -->
        <div class="col-lg-5 mb-5 mt-4">
          <h2 class="text-warning text-center">Últimas Interações</h2>
          <div class="row">
          <?php while($row = $result->fetch_assoc()): ?>
        <div class="p-3 mb-3 feedback_box feedback-item text-black">
          <strong><?= htmlspecialchars($row["nome"]) ?>:</strong>
          <p><?= nl2br(htmlspecialchars($row["mensagem"])) ?></p>
  
          <?php if (!empty($row["resposta"])): ?>
            <div class="bg-light text-dark p-2 border-start ps-3 mt-2">
              <strong>Resposta:</strong><br>
              <?= nl2br(htmlspecialchars($row["resposta"])) ?>
            </div>
          <?php else: ?>
            <em>Aguardando resposta...</em><br>
            <button class="btn btn-primary mt-2" onclick="mostrarFormularioResposta(<?= $row['id'] ?>)">Responder</button>
            <form method="post" action="responder_suporte.php" id="formResposta<?= $row['id'] ?>" style="display:none;" class="mt-3">
              <input type="hidden" name="id" value="<?= $row['id'] ?>">
              <div class="mb-2">
                <textarea name="resposta" class="form-control" rows="3" required placeholder="Digite sua resposta..."></textarea>
              </div>
              <button type="submit" class="btn btn-success">Enviar Resposta</button>
            </form>
          <?php endif; ?>
        </div>
      <?php endwhile; ?>
          </div>
          <script>
      function mostrarFormularioResposta(id) {
        const form = document.getElementById('formResposta' + id);
        form.style.display = form.style.display === "none" ? "block" : "none";
      }
      </script>
      </div>
    
        <!-- COLUNA DO FORMULÁRIO (à direita) -->
        <div class="col-lg-7 mb-3 mt-1">
          <div class="feedback">
          <h2 class="text-center text-black">Solicite o Fórum</h2>
        <form method="post" class="mb-5">
          <div class="mb-3">
            <label for="nome" class="form-label">Nome</label>
            <input type="text" class="form-control" id="nome" name="nome" required />
          </div>
          <div class="mb-3">
            <label for="email" class="form-label">E-mail</label>
            <input type="email" class="form-control" id="email" name="email" required />
          </div>
          <div class="mb-3">
            <label for="mensagem" class="form-label">Mensagem</label>
            <textarea class="form-control" id="mensagem" name="mensagem" rows="4" required></textarea>
          </div>
          <button type="submit" class="btn btn-laranja">Enviar</button>
        </form>
          </div>
        </div>
      </div>
    </div>


    <!-- Rodapé -->
    <footer class="bg-black text-light text-center py-4">
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

    <!-- Script do Bootstrap -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
