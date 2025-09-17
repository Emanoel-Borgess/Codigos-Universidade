// script.js

const container = document.getElementById("animais-container");

// Atualiza o menu conforme o usuário logado
function atualizarMenu() {
  const usuario = JSON.parse(localStorage.getItem("usuario"));
  const nav = document.querySelector("header nav");
  
  if (usuario) {
    nav.innerHTML = `
      <span>Olá, ${usuario.nome}</span>
      <button onclick="abrirCadastroAnimal()">Cadastrar Animal</button>
      <button onclick="logout()">Logout</button>
    `;
  } else {
    nav.innerHTML = `
      <button onclick="abrirLogin()">Login</button>
      <button onclick="abrirCadastro()">Cadastro</button>
    `;
  }
}

// Logout
function logout() {
  localStorage.removeItem("usuario");
  atualizarMenu();
  carregarAnimais();
}

// Redireciona para login
function abrirLogin() {
  window.location.href = 'login.html';
}

// Redireciona para cadastro
function abrirCadastro() {
  window.location.href = 'register.html';
}

// Função para armazenar usuário no localStorage após login
function salvarUsuario(usuario) {
  localStorage.setItem("usuario", JSON.stringify(usuario));
  atualizarMenu();
}

// Carrega todos os animais do backend
async function carregarAnimais() {
  container.innerHTML = "<p>Carregando animais...</p>";
  const usuario = JSON.parse(localStorage.getItem("usuario"));

  try {
    const res = await fetch("/api/animals");
    const animais = await res.json();

    if (!animais || animais.length === 0) {
      container.innerHTML = "<p>Nenhum animal disponível ainda.</p>";
      return;
    }

    container.innerHTML = ""; // limpa container

    animais.forEach(animal => {
      const card = document.createElement("div");
      card.className = "animal-card";

      const podeEditar = usuario && (usuario.perfil === "admin" || usuario.id === animal.donoId);

      card.innerHTML = `
    <div class="card-image-container">
        ${animal.foto ? `<img src="/uploads/${animal.foto}" alt="${animal.nome}">` : ""}
    </div>
    <div class="card-info">
        <h3>${animal.nome}</h3>
        <p><b>Espécie:</b> ${animal.especie}</p>
        <p><b>Idade:</b> ${animal.idade || "Não informada"} anos</p>
        <p>${animal.descricao || ""}</p>
        <p><b>Status:</b> ${animal.status}</p>
        <div class="card-buttons">
            <button onclick="adotar(${animal.id})" ${animal.status === 'Adotado' ? 'disabled' : ''} class="btn-adotar-card">
                ${animal.status === 'Adotado' ? 'Adotado' : 'Adotar'}
            </button>
            ${podeEditar ? `<button onclick="abrirEditarAnimal(${animal.id})" class="btn-editar-card">Editar</button>
                            <button onclick="apagarAnimal(${animal.id})" class="btn-apagar-card">Apagar</button>` : ""}
        </div>
    </div>
`;
      container.appendChild(card);
    });

  } catch (err) {
    container.innerHTML = "<p>Erro ao carregar animais.</p>";
    console.error(err);
  }
}

function abrirEditarAnimal(id) {
  window.location.href = `editar-animal.html?id=${id}`;
}

// Cadastrar animal (para usuários logados)
function abrirCadastroAnimal() {
  window.location.href = "cadastro-animal.html";
}


// Adotar animal
async function adotar(id) {
  const usuario = JSON.parse(localStorage.getItem("usuario"));
  if (!usuario) {
    alert("Você precisa estar logado para adotar um animal!");
    return;
  }

  try {
    const res = await fetch(`/api/animals/${id}/adotar`, { method: "PUT" });
    const data = await res.json();
    if (res.ok) {
      alert("Informações de adoção enviadas para seu e-mail cadastrado!");
      carregarAnimais();
    } else {
      alert(data.error || "Erro ao adotar animal");
    }
  } catch (err) {
    console.error(err);
    alert("Erro de conexão ao tentar adotar animal");
  }
}


// Apagar animal
async function apagarAnimal(id) {
  if (!confirm("Tem certeza que deseja apagar este animal?")) return;

  try {
    const res = await fetch(`/api/animals/${id}`, { method: "DELETE" });
    const data = await res.json();
    if (res.ok) {
      alert("Animal apagado com sucesso!");
      carregarAnimais();
    } else {
      alert(data.error || "Erro ao apagar animal");
    }
  } catch (err) {
    console.error(err);
    alert("Erro ao apagar animal");
  }
}


// Carregar tudo ao abrir a página
window.onload = () => {
  atualizarMenu();
  carregarAnimais();
};
