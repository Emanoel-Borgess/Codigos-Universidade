<!-- Pronta-->
<?php
session_start();

// Verifica se o usuário está logado
if ((!isset($_SESSION['email']) == true) and (!isset($_SESSION['senha']) == true)) {
    unset($_SESSION['email']);
    unset($_SESSION['senha']);
    header('location: login.php');
    exit(); // importante para parar o script após o redirecionamento
} else {
    $logado = $_SESSION['email'];

    // Conectar ao banco de dados
    $servidor = "localhost"; // ou seu servidor
    $usuario = "root"; // ou seu usuário do banco
    $senha = ""; // sua senha do banco
    $dbname = "criar_conta"; // coloque o nome do seu banco de dados

    $conexao = new mysqli($servidor, $usuario, $senha, $dbname);

    // Verificar conexão
    if ($conexao->connect_error) {
        die("Falha na conexão: " . $conexao->connect_error);
    }

    // Buscar o nome do usuário no banco
    $sql = "SELECT nome FROM usuarios WHERE email = '$logado' LIMIT 1";
    $result = $conexao->query($sql);

    if ($result->num_rows > 0) {
        $user_data = $result->fetch_assoc();
        $nome_usuario = $user_data['nome'];
    } else {
        $nome_usuario = "Usuário"; // Nome padrão caso não encontre
    }
}
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
    <title>GameStar - Home</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css"
    />
    <style>
      body {
        background-color: #121212;
        color: white;
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

      .carousel-inner img {
        object-fit: cover;
        height: 100%;
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
      <div
        id="carouselExample"
        class="carousel slide"
        data-bs-ride="carousel"
        style="height: 400px; overflow: hidden"
      >
        <div class="carousel-indicators">
          <button
            type="button"
            data-bs-target="#carouselExample"
            data-bs-slide-to="0"
            class="active"
            aria-current="true"
            aria-label="Slide 1"
          ></button>
          <button
            type="button"
            data-bs-target="#carouselExample"
            data-bs-slide-to="1"
            aria-label="Slide 2"
          ></button>
          <button
            type="button"
            data-bs-target="#carouselExample"
            data-bs-slide-to="2"
            aria-label="Slide 3"
          ></button>
        </div>

        <div class="carousel-inner" style="height: 400px">
          <div class="carousel-item active">
            <img
              src="Imagens/Imagens/background.png"
              class="d-block w-100"
              alt="Downloads"
            />
          </div>
          <div class="carousel-item">
            <img
              src="Imagens/Imagens/capavideos.jpeg"
              class="d-block w-100"
              alt="Boletim"
            />
          </div>
          <div class="carousel-item">
            <img
              src="Imagens/Imagens/fundojogos.png"
              class="d-block w-100"
              alt="Suporte"
            />
          </div>
        </div>

        <button
          class="carousel-control-prev"
          type="button"
          data-bs-target="#carouselExample"
          data-bs-slide="prev"
        >
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Anterior</span>
        </button>
        <button
          class="carousel-control-next"
          type="button"
          data-bs-target="#carouselExample"
          data-bs-slide="next"
        >
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Próximo</span>
        </button>

        <div
          class="container hero-content position-absolute top-50 start-50 translate-middle text-center"
        >
          <h1>
            Junte-se a mais de 200 milhões de jogadores na plataforma GameStar
          </h1>
          <p>
            Aprimore sua experiência de jogo com nossa plataforma oficial de
            jogos
          </p>
          <div class="d-grid gap-2 d-md-flex justify-content-center">
            <?php
              echo "<h3>Bem-vindo, $nome_usuario!</h3>";
              ?>
          </div>
        </div>
      </div>
    </section>

    
    <section class="container my-5">
        <h2 class="text-center mb-3 text-warning">ÚLTIMAS ATUALIZAÇÕES</h2>
        
        <!-- Atualizações de Jogos -->
        <div class="row g-4 mb-5">
          <!-- Fortnite -->
          <div class="col-md-4">
            <div class="jogo-card p-3 rounded h-100">
              <img src="Imagens/Imagens/fort01.jpg" alt="Fortnite" class="img-fluid rounded mb-3" style="height: 200px; width: 100%; object-fit: cover;">
              <h3>Fortnite</h3>
              <p>Atualização do Capítulo 5 - Novas skins, armas e mecânicas de jogo!</p>
             
            </div>
          </div>
          
          <!-- GTA V -->
          <div class="col-md-4">
            <div class="jogo-card p-3 rounded h-100">
              <img src="Imagens/Imagens/GTA01.jpg" alt="GTA V" class="img-fluid rounded mb-3" style="height: 200px; width: 100%; object-fit: cover;">
              <h3>GTA V</h3>
              <p>Nova DLC "Los Santos Underground" disponível agora com novas missões e veículos.</p>
         
            </div>
          </div>
          
          <!-- Outro Jogo -->
          <div class="col-md-4">
            <div class="jogo-card p-3 rounded h-100">
              <img src="Imagens/Imagens/mine01.png" alt="Minecraft" class="img-fluid rounded mb-3" style="height: 200px; width: 100%; object-fit: cover;">
              <h3>Minecraft</h3>
              <p>Atualização 1.20 traz novos biomas, criaturas e itens para explorar.</p>
            </div>
          </div>
        </div>
        
        <!-- Destaque GTA VI -->
        <div class="row mb-5">
          <div class="col-12">
            <div class="jogo-card p-0 rounded overflow-hidden">
              <div class="row g-0">
                <div class="col-md-6">
                  <img src="Imagens/Imagens/GTADIV.jpeg" alt="GTA VI" class="img-fluid" style="height: 100%; width: 100%; object-fit: cover;">
                </div>
                <div class="col-md-6 p-4 d-flex flex-column">
                  <h2 class="text-warning">PRÓXIMO LANÇAMENTO</h2>
                  <h3>GTA VI - Em Breve</h3>
                  <p>O aguardado novo capítulo da franquia Grand Theft Auto está chegando! Explore Vice City como nunca antes em uma experiência de mundo aberto revolucionária.</p>
                  <div class="mt-auto">
                    <a href="videos.php"><button class="btn btn-laranja">Saiba mais</button></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Vídeos do YouTube -->
        <h2 class="text-center mb-4 text-warning">VÍDEOS EM DESTAQUE</h2>
        <div class="row g-4 mb-5">
          <div class="col-md-4">
            <div class="ratio ratio-16x9">
              <iframe src="https://www.youtube.com/embed/QdBZY2fkU-0" allowfullscreen></iframe>
            </div>
            <h4 class="mt-2">GTA VI - Trailer oficial</h4>
          </div>
          <div class="col-md-4">
            <div class="ratio ratio-16x9">
            <iframe
              src="https://www.youtube.com/embed/Wjij-OX9RKI?si=kD4QCYgkPWe6jvSb"
              title="Fortnite"
              allowfullscreen
            ></iframe>
            </div>
            <h4 class="mt-2">Novidades Fortnite Capítulo 5</h4>
          </div>
          <div class="col-md-4">
            <div class="ratio ratio-16x9">
            <iframe
              src="https://www.youtube.com/embed/8Ou2HQOxSHU?si=l3gDVKG8N0YasyLQ"
              title="Minecraft"
              allowfullscreen
            ></iframe>
            </div>
            <h4 class="mt-2">Review Minecraft 1.20</h4>
          </div>
        </div>
        
        <!-- Sobre a GameStar -->
        <div class="row jogo-card p-4 rounded mb-4 bg-black">
          <div class="col-md-6">
            <h2 class="text-warning">SOBRE A GAMESTAR</h2>
            <p>A GameStar é a plataforma definitiva para gamers, oferecendo os melhores jogos, atualizações e conteúdo exclusivo para você.</p>
            <p>Nossa missão é proporcionar a melhor experiência de jogo possível, com suporte técnico especializado, uma comunidade vibrante e lançamentos antecipados.</p>
            <p>Junte-se a mais de 200 milhões de jogadores em nossa plataforma!<br>Se tiver dúvidas ou precisar de ajuda, entre em contato com nossa equipe de suporte.</p>
            <a href="suporte_login.php" class="btn btn-laranja">Dúvidas</a>
          </div>
          <div class="col-md-6">
            <img src="Imagens/Imagens/equipe.png" alt="Equipe GameStar" class="img-fluid rounded" style="height: 300px; width: 100%; object-fit: cover;">
          </div>
        </div>

        <div class="row g-4 mb-5">
          <!-- Fortnite -->
          <div class="col-md-4">
            <div class="jogo-card p-3 rounded h-100">
              <img src="Imagens/Imagens/capavideos.jpeg" alt="Fortnite" class="img-fluid rounded mb-3" style="height: 200px; width: 100%; object-fit: cover;">
              <h3>Fortnite</h3>
              <p>Você está pronto para essa experiência caótica?</p>
             
            </div>
          </div>
          
          <!-- GTA V -->
          <div class="col-md-4">
            <div class="jogo-card p-3 rounded h-100">
              <img src="Imagens/Imagens/capadownloads.jpg" alt="GTA V" class="img-fluid rounded mb-3" style="height: 200px; width: 100%; object-fit: cover;">
              <h3>The Forest</h3>
              <p>Correção de bugs e novos pacotes de som instalados!</p>
         
            </div>
          </div>
          
          <!-- Outro Jogo -->
          <div class="col-md-4">
            <div class="jogo-card p-3 rounded h-100">
              <img src="Imagens/Imagens/capafeed.png" alt="Minecraft" class="img-fluid rounded mb-3" style="height: 200px; width: 100%; object-fit: cover;">
              <h3>CS:GO</h3>
              <p>Os novos mapas chegaram, atualize e se divirta!</p>
            </div>
          </div>
        </div>

      </section>




    <!-- Seção de destaque -->
    <section class="destaque container mt-5">
      <div class="row text-center">
        <div class="col-md-4 mb-4">
          <img
            src="Imagens/Imagens/launcher-logo.png"
            alt="GameStar Launcher"
            width="130"
          />
          <h2>GameStar Launcher</h2>
          <p>Baixe e jogue os títulos mais recentes da GameStar no seu PC.</p>
        </div>
        <div class="col-md-4 mb-4">
          <img src="Imagens/Imagens/GTAV.PNG" alt="GTA V" width="130" />
          <h2>GTA V</h2>
          <p>Disponível agora no GameStar Launcher.</p>
        </div>
        <div class="col-md-4 mb-4">
          <img
            src="Imagens/Imagens/red-dead-2.jpg"
            alt="Red Dead Redemption 2"
            width="130"
          />
          <h2>Red Dead Redemption 2</h2>
          <p>Disponível agora no GameStar Launcher.</p>
        </div>
      </div>
    </section>


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
          <a href="#" class="text-light"
            ><i class="bi bi-facebook fs-4"></i>Facebook</a
          >
          <a href="#" class="text-light"
            ><i class="bi bi-twitter fs-4"></i>Twitter</a
          >
          <a href="#" class="text-light"
            ><i class="bi bi-instagram fs-4"></i>Instagram</a
          >
          <a href="#" class="text-light"
            ><i class="bi bi-youtube fs-4"></i>Youtube</a
          >
        </div>
      </div>
    </footer>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
