const form = document.getElementById("form-cadastro-animal");

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const usuario = JSON.parse(localStorage.getItem("usuario"));
  if (!usuario) {
    alert("Você precisa estar logado para cadastrar um animal!");
    return;
  }

  const formData = new FormData();
  formData.append("nome", document.getElementById("nome").value);
  formData.append("especie", document.getElementById("especie").value);
  formData.append("idade", document.getElementById("idade").value);
  formData.append("descricao", document.getElementById("descricao").value);
  formData.append("donoId", usuario.id);

  const fotoInput = document.getElementById("foto");
  if (fotoInput.files.length > 0) {
    formData.append("foto", fotoInput.files[0]);
  }

  try {
    const res = await fetch("/api/animals", {
      method: "POST",
      body: formData
    });

    const data = await res.json();
    if (data.success) {
      alert("Animal cadastrado com sucesso!");
      window.location.href = "index.html"; // volta para a página principal
    } else {
      alert(data.error || "Erro ao cadastrar animal");
    }

  } catch (err) {
    console.error(err);
    alert("Erro ao cadastrar animal");
  }
});
