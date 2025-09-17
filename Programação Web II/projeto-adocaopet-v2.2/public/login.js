// login.js

const form = document.getElementById("form-login");
const msg = document.getElementById("msg");



form.addEventListener("submit", async (e) => {
  e.preventDefault(); // Evitar recarregar a página

  // Pegar dados do formulário
  const email = form.email.value.trim();
  const senha = form.senha.value;

  if (!email || !senha) {
    msg.textContent = "Preencha todos os campos!";
    msg.style.color = "red";
    return;
  }

  try {
    // Enviar dados para o backend
    const response = await fetch("/api/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email, senha })
    });

    const data = await response.json();

    if (response.ok) {
      msg.textContent = "Login realizado com sucesso!";
      msg.style.color = "green";

      // Aqui você pode salvar os dados do usuário no localStorage ou sessionStorage
      localStorage.setItem("usuario", JSON.stringify(data.usuario));

      // Redirecionar para index ou dashboard
      setTimeout(() => {
        window.location.href = "index.html";
      }, 1000);
    } else {
      msg.textContent = data.error || "Erro no login";
      msg.style.color = "red";
    }
  } catch (err) {
    console.error(err);
    msg.textContent = "Erro ao conectar com o servidor";
    msg.style.color = "red";
  }
});

document.addEventListener("DOMContentLoaded", () => {
  document.getElementById("form-login").reset(); // limpa os campos
});
