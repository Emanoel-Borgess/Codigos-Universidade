// register.js

const form = document.getElementById("form-register");
const msg = document.getElementById("msg");

form.addEventListener("submit", async (e) => {
  e.preventDefault(); // evitar reload da página

  // Pegar dados do formulário
  const nome = form.nome.value.trim();
  const email = form.email.value.trim();
  const senha = form.senha.value;
  const perfil = form.perfil.value;

  // Verificação simples
  if (!nome || !email || !senha || !perfil) {
    msg.textContent = "Preencha todos os campos!";
    msg.style.color = "red";
    return;
  }

  try {
    // Enviar dados para o backend
    const response = await fetch("/api/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ nome, email, senha, perfil })
    });

    const data = await response.json();

    if (response.ok) {
      msg.textContent = "Cadastro realizado com sucesso! Você já pode fazer login.";
      msg.style.color = "green";
      form.reset(); // limpar formulário
    } else {
      msg.textContent = data.error || "Erro ao cadastrar usuário";
      msg.style.color = "red";
    }
  } catch (err) {
    console.error(err);
    msg.textContent = "Erro ao conectar com o servidor";
    msg.style.color = "red";
  }
});
