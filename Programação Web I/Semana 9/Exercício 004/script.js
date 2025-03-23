class Pessoa {
    constructor(nome, idade) {
        this.nome = nome;
        this.idade = idade;
    }

    exibirMensagem() {
        // Aqui usamos 'this' para acessar as propriedades do objeto
        return "Meu nome é " + this.nome + " e tenho " + this.idade + " anos.";
    }
}

function criarPessoa() {
    const nome = document.getElementById('nome').value;
    const idade = document.getElementById('idade').value;
    
    if (nome === "" || idade === "") {
        document.getElementById('mensagem').innerText = "Por favor, preencha todos os campos.";
        return;
    }
    
    const pessoa = new Pessoa(nome, idade);
    // Agora, chamamos a função exibirMensagem() corretamente
    document.getElementById('mensagem').innerText = pessoa.exibirMensagem();
}
