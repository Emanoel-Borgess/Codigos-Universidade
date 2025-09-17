// editar-animal.js
document.addEventListener("DOMContentLoaded", async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const id = urlParams.get("id");

  if (!id) {
    alert("Animal não encontrado.");
    window.location.href = "index.html";
    return;
  }

  const form = document.getElementById("form-editar-animal");

  // Buscar dados atuais do animal
  try {
    const res = await fetch(`/api/animais/${id}`);
    const animal = await res.json();

    if (!res.ok) throw new Error(animal.error || "Erro ao carregar");

    // Preencher campos
    document.getElementById("animal-id").value = animal.id;
    document.getElementById("nome").value = animal.nome;
    document.getElementById("idade").value = animal.idade;
    document.getElementById("descricao").value = animal.descricao;
  } catch (err) {
    console.error(err);
    alert("Erro ao carregar animal");
    window.location.href = "index.html";
  }

  // Quando salvar
  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const nome = document.getElementById("nome").value;
    const idade = document.getElementById("idade").value;
    const descricao = document.getElementById("descricao").value;
    const imagem = document.getElementById("imagem").files[0];

    const formData = new FormData();
    formData.append("nome", nome);
    formData.append("idade", idade);
    formData.append("descricao", descricao);
    if (imagem) formData.append("imagem", imagem);

    try {
      const res = await fetch(`/api/animais/${id}`, {
        method: "PUT",
        body: formData
      });

      const data = await res.json();

      if (res.ok) {
        alert("Animal atualizado com sucesso!");
        window.location.href = "index.html";
      } else {
        alert(data.error || "Erro ao atualizar");
      }
    } catch (err) {
      console.error(err);
      alert("Erro ao salvar alterações");
    }
  });
});
