<!--Pronta-->
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
    <title>GameStar - Downloads</title>
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
      .hero {
        background-image: url("Imagens/Imagens/capadownloads.jpg");
        background-size: cover;
        background-position: center;
        padding: 100px 20px;
      }
      .hero-content {
        background: rgba(0, 0, 0, 0.7);
        padding: 20px;
        border-radius: 10px;
      }
      .destaque img {
        border-radius: 10px;
      }
      .rodape {
        color: #ffa500;
      }
      .color {
        background-color: #ffa500;
        border-radius: 50px;
        padding: 10px;
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
        <h1>Baixe e aproveite ao máximo</h1>
        <p>
          Encontre atualizações, instaladores e conteúdos extras para seus jogos
          favoritos
        </p>
      </div>
    </section>

    <section class="container py-5">
      <div class="row g-4">
        <!-- GTA V -->
        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/gtavdown.jpg"
              class="card-img-top"
              alt="GTA V"
            />
            <div class="card-body">
              <h5 class="card-title text-center">GTA V</h5>
              <p class="card-text text-center">
                Explore Los Santos em alta velocidade e caos total.
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/Grand-Theft-Auto-V.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/Grand-Theft-Auto-V.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/Grand-Theft-Auto-V.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>

        <!-- Minecraft -->
        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/minecraftDow.png"
              class="card-img-top"
              alt="Minecraft"
            />
            <div class="card-body">
              <h5 class="card-title text-center">Minecraft</h5>
              <p class="card-text text-center">
                Crie, explore e sobreviva em mundos infinitos.
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/Minecraft.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/Minecraft.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/Minecraft.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>

        <!-- Red Dead Redemption II -->
        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/reddown.jpg"
              class="card-img-top"
              alt="Red Dead Redemption II"
            />
            <div class="card-body">
              <h5 class="card-title text-center">Red Dead Redemption II</h5>
              <p class="card-text text-center">
                A jornada de um fora da lei no Velho Oeste.
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/Red-Dead-2.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/Red-Dead-2.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/Red-Dead-2.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>

        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/gtaSanDown.png"
              class="card-img-top"
              alt="Red Dead Redemption II"
            />
            <div class="card-body">
              <h5 class="card-title text-center">
                Grand Theft Auto - San Andreas
              </h5>
              <p class="card-text text-center">
                O mundo aberto que trás nostalgia!
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/Grand-Theft-Auto-SA.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/Grand-Theft-Auto-SA.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/Grand-Theft-Auto-SA.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>

        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/CSGODown.jpg"
              class="card-img-top"
              alt="Red Dead Redemption II"
            />
            <div class="card-body">
              <h5 class="card-title text-center">CS:GO</h5>
              <p class="card-text text-center">
                É a adrenalina de desarmar uma bomba, a precisão de uma bala
                certeira, o trabalho em equipe que decide tudo.
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/CS-GO.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/CS-GO.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/CS-GO.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>

        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/GrannyDown.png"
              class="card-img-top"
              alt="Red Dead Redemption II"
            />
            <div class="card-body">
              <h5 class="card-title text-center">Granny</h5>
              <p class="card-text text-center">
                Tu acorda numa casa escura, trancado, e tudo o que ouve... é
                ela. A vovó do capiroto, que te caça sem piedade.
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/GRANNY.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/GRANNY.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/GRANNY.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>

        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/FortniteDow.jpg"
              class="card-img-top"
              alt="Red Dead Redemption II"
            />
            <div class="card-body">
              <h5 class="card-title text-center">Fortnite</h5>
              <p class="card-text text-center">
                É dança no meio do tiroteio, construção em segundos e batalhas
                que viram festa. Cada partida é um palco onde só um sobrevive.
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/FORTNITE.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/FORTNITE.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/FORTNITE.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>

        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/BullyDow.jpg"
              class="card-img-top"
              alt="Red Dead Redemption II"
            />
            <div class="card-body">
              <h5 class="card-title text-center">Bully</h5>
              <p class="card-text text-center">
                É Jimmy Hopkins contra o mundo, enfrentando valentões,
                professores e o caos adolescente com socos e notas medianas.
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/BULLY.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/BULLY.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/BULLY.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>

        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/GodOfWarDow.jpg"
              class="card-img-top"
              alt="Red Dead Redemption II"
            />
            <div class="card-body">
              <h5 class="card-title text-center">God Of War</h5>
              <p class="card-text text-center">
                Kratos, o Fantasma de Esparta, corta os céus com sua dor,
                vingança e redenção. Deus contra deus, pai contra o próprio
                passado.
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/God-Of-War.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/God-Of-War.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/God-Of-War.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>

        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/TheSimsDow.png"
              class="card-img-top"
              alt="Red Dead Redemption II"
            />
            <div class="card-body">
              <h5 class="card-title text-center">The Sims 4</h5>
              <p class="card-text text-center">
                Tu cria, ama, destrói — tudo num clique. É drama, riso e caos
                doméstico, onde o banheiro entupido e o casamento surpresa andam
                lado a lado.
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/THE-SIMS-4.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/THE-SIMS-4.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/THE-SIMS-4.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>

        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/theForestDow.jpg"
              class="card-img-top"
              alt="Red Dead Redemption II"
            />
            <div class="card-body">
              <h5 class="card-title text-center">The Forest</h5>
              <p class="card-text text-center">
                Perdido numa ilha isolada, tu enfrentas monstros, a fome e os
                próprios demônios enquanto constrói teu abrigo e tenta entender
                o que aconteceu.
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/The-Forest.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/The-Forest.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/The-Forest.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>

        <div class="col-md-4">
          <div class="card bg-dark text-white jogo-card h-100">
            <img
              src="Imagens/Imagens/capaDownload/AmongUsDow.png"
              class="card-img-top"
              alt="Red Dead Redemption II"
            />
            <div class="card-body">
              <h5 class="card-title text-center">Among Us</h5>
              <p class="card-text text-center">
                Amigos, mentiras e uma nave cheia de suspeitas: quem é o
                impostor? É um teste de confiança onde qualquer sorriso pode ser
                traição e qualquer silêncio, um veredito.
              </p>
            </div>
            <div class="card-footer d-flex justify-content-around flex-wrap">
              <a
                href="Imagens/Imagens/capaDownload/AMONG-US.txt"
                download
                class="btn btn-laranja mb-2"
                >Windows</a
              >
              <a
                href="Imagens/Imagens/capaDownload/AMONG-US.txt"
                download
                class="btn btn-laranja mb-2"
                >Linux</a
              >
              <a
                href="Imagens/Imagens/capaDownload/AMONG-US.txt"
                download
                class="btn btn-laranja mb-2"
                >Mac</a
              >
            </div>
          </div>
        </div>
      </div>
    </section>

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
