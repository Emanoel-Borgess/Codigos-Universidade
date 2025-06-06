<!--Pronta -->

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
    <title>GameStar - Launcher</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css"
    />
    <style>
      body {
        background-color: #ffffff;
        color: white;
        position: relative;
        overflow-x: hidden;
      }

      .logo {
        font-size: 29px;
        font-weight: bold;
        color: #961ccb;
        text-decoration: none;
      }

      .coresBotao {
        background-color: #961ccb;
        border-radius: 50px;
        padding: 20px;
        font-family: Verdana, Geneva, Tahoma, sans-serif;
      }
      .corescard {
        background-color: #f1d8fc;
      }

      .color {
        background-color: #961ccb;
        border-radius: 50px;
        padding: 10px;
      }

      .btn-laranja {
        background-color: #961ccb;
        color: black;
        font-weight: bold;
      }

      .font {
        color: black;
        font-family: Verdana, Geneva, Tahoma, sans-serif;
      }

      .qrcode-img {
        width: 170px;
        height: 150px;
      }

      @media (max-width: 768px) {
        .qrcode-img {
          width: 120px;
          height: 110px;
        }
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

    <!-- Seção Principal com imagem e conteúdo -->
    <div class="container-fluid py-3">
      <div class="row justify-content-center align-items-center">
        <!-- Imagem -->
        <div class="col-lg-6 mb-4">
          <img
            src="Imagens/Imagens/download-animate (1).svg"
            alt="Launcher Imagem"
            class="img-fluid"
            style="max-height: 850px"
          />
        </div>

        <!-- Texto e botão -->
        <div class="col-lg-4">
          <div class="card corescard text-black p-4 shadow-lg">
            <div class="font">
              <h1 class="text-black text-center mb-3">
                <strong>GAMESTAR<br />GAME<br />LAUNCHER</strong>
              </h1>
              <p class="logo mt-3 text-center">
                Baixe agora o GameStar Launcher e aproveite seus jogos, títulos
                e muito mais direto no seu PC.
              </p>
              <button
                type="button"
                class="btn btn-laranja mt-3 w-100 text-black"
                onclick="baixarPdfEIr()"
              >
                <strong>Download para Windows</strong>
              </button>
              <div class="container mt-4">
                <div
                  class="d-flex align-items-center justify-content-center flex-wrap gap-4"
                >
                  <div>
                    <p class="container coresBotao text-center m-0 font">
                      <strong
                        >Escaneie o QR Code e tenha<br />
                        uma surpresa!</strong
                      >
                    </p>
                  </div>
                  <div>
                    <img
                      src="Imagens/Imagens/qrcode_docs.google.com.png"
                      alt="QR Code"
                      class="qrcode-img"
                    />
                  </div>
                </div>
              </div>
              <script>
                function baixarPdfEIr() {
                  const link = document.createElement("a");
                  link.href = "arquivos/GameStar_Launcher.txt";
                  link.download = "GameLauncher.exe";
                  document.body.appendChild(link);
                  link.click();
                  document.body.removeChild(link);
                  setTimeout(() => {
                    window.location.href = "botoes_de_dowloads.php";
                  }, 1000);
                }
              </script>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Rodapé -->
    <footer class="bg-black text-light text-center py-4 mt-5">
      <div class="container">
        <p class="logo">GameStar</p>
        <p class="mt-2 mb-1">
          <strong>Desenvolvedores <br />Emanoel Borges e Pedro Vieira</strong>
        </p>
        <p class="mb-3">
          <strong>© 2025 GameStar. Todos os direitos reservados.</strong>
        </p>

        <div class="d-flex justify-content-center gap-3">
          <a href="#" class="text-light">Facebook</a>
          <a href="#" class="text-light">Twitter</a>
          <a href="#" class="text-light">Instagram</a>
          <a href="#" class="text-light">Youtube</a>
        </div>
      </div>
    </footer>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
