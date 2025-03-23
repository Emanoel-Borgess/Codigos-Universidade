function verificarPessoa() {
    let nome = document.getElementById("nome").value;
    let idade = parseInt(document.getElementById("idade").value);
    let altura = parseFloat(document.getElementById("altura").value);
    
    if (!nome || isNaN(idade) || isNaN(altura)) {
        alert("Por favor, preencha todos os campos corretamente.");
        return;
    }

    let resultado = (idade >= 18 && idade <= 35 && altura > 1.86) 
        ? `Nome: ${nome}` 
        : `Idade: ${idade}, Altura: ${altura.toFixed(2)}m`;

    document.getElementById("resultado").innerHTML = resultado;
}
