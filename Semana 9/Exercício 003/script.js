// Criando o objeto carro
const carro = {
    marca: "Toyota",
    modelo: "Corolla",
    ano: 2022,
    getInfo: function() {
    // O método retorna uma string contendo as propriedades do objeto carro
    return "Marca: " + this.marca + ", Modelo: " + this.modelo + ", Ano: " + this.ano;
}
};

// Função para exibir informações do carro
function exibirCarro() {
    document.getElementById("info").textContent = carro.getInfo();
}