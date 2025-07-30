const fetchButton = document.getElementById("fetchButton");
const resultDiv = document.getElementById("result");

fetchButton.addEventListener("click", async () => {
  await buscarGatinho();
});

const buscarGatinho = async () => {
  try {
    const resposta = await fetch("https://api.thecatapi.com/v1/images/search", {
      headers: {
        "x-api-key": "ylX4blBYT9FaoVd6OhvR"
      }
    });

    if (!resposta.ok) {
      throw new Error("Erro ao buscar imagem de gatinho.");
    }

    const [gatinho] = await resposta.json(); // desestruturação
    const imagem = gatinho?.url ?? "";

    resultDiv.innerHTML = imagem
      ? `<img src="${imagem}" alt="Gatinho fofo" />`
      : "Nenhuma imagem encontrada.";
  } catch (erro) {
    resultDiv.innerHTML = `<p style="color: red;">Erro: ${erro.message}</p>`;
  }
};
