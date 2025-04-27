<!-- Pronta -->

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
    <title>GameStar - Login</title>
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
        font-size: 24px;
        font-weight: bold;
        color: #ffa500;
        text-decoration: none;
      }

      .color {
        background-color: #ffa500;
        border-radius: 50px;
        padding: 10px;
      }

      .btn-laranja {
        background-color: #ffa500;
        color: black;
        font-weight: bold;
      }

      .qrcode-img {
        width: 170px;
        height: 150px;
      }
    </style>
  </head>
  <body>
    <!-- Cabeçalho -->
    <header
      class="container-fluid d-flex flex-wrap justify-content-between align-items-center p-3 bg-black"
    >
      <a href="pagina.html" class="logo">GameStar</a>
    </header>

    <!-- BLOCO DE LOGIN COM IMAGEM À ESQUERDA -->
    <div class="py-2 ms-2">
        <a class="btn btn-dark text-white" href="pagina.html" role="button">Voltar</a>
        </div>
    <div class="container-fluid py-5">
      <div class="row justify-content-center align-items-center">
        <!-- IMAGEM À ESQUERDA -->
        <div class="col-lg-6 mb-5 mb-lg-3">
          <img
            src="Imagens/Imagens/login-animate.svg"
            alt="Login"
            class="img-fluid"
            style="max-height: 590px"
          />
        </div>

        <!-- FORMULÁRIO À DIREITA -->
        <div class="col-lg-4">
          <div
            class="card bg-warning text-black p-5 shadow-lg"
            style="min-height: 500px"
          >
            <h2 class="text-center mb-4">Faça seu login</h2>
            <form action="teste_login.php" method="POST">
              <div class="mb-4">
                <label for="email" class="form-label">E-mail</label>
                <input
                  type="text"
                  class="form-control form-control-lg"
                  id="email"
                  name="email"
                  placeholder="Digite seu e-mail"
                />
              </div>
              <div class="mb-4">
                <label for="senha" class="form-label">Senha</label>
                <input
                  type="password"
                  class="form-control form-control-lg"
                  id="senha"
                  name="senha"
                  placeholder="Digite sua senha"
                />
              </div>
              <input class="btn btn-dark btn-lg w-100"type="submit" name="submit" value="Entrar">
              </form>
              <div class="text-center mt-3">
                <a href="criar_login.php" class="btn btn-dark btn-lg w-10">
                  Criar conta
                </a>
              </div>
          </div>
        </div>
      </div>
    </div>
  <!-- Rodapé -->
    <footer class="bg-black text-light text-center py-1 mt-5">
      <div class="container">
        <p class="logo">GameStar</p>
        <p class="mt-md-2">
          <strong>Desenvolvedores <br />Emanoel Borges e Pedro Vieira</strong>
        </p>
        <p class="mb-1">
          <strong>© 2025 GameStar. Todos os direitos reservados.</strong>
        </p>
        <div class="d-flex justify-content-center gap-3">
          <a href="#" class="text-light"
            ><i class="bi bi-facebook fs-4"></i> Facebook</a
          >
          <a href="#" class="text-light"
            ><i class="bi bi-twitter fs-4"></i> Twitter</a
          >
          <a href="#" class="text-light"
            ><i class="bi bi-instagram fs-4"></i> Instagram</a
          >
          <a href="#" class="text-light"
            ><i class="bi bi-youtube fs-4"></i> Youtube</a
          >
        </div>
      </div>
    </footer>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
