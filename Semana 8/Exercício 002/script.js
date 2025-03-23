let pessoas = [];

function adicionarPessoa() {
    let idade = document.getElementById("idade").value;
    let peso = document.getElementById("peso").value;

    if (idade && peso) {
        pessoas.push({ idade: parseInt(idade), peso: parseFloat(peso) });
        document.getElementById("lista").innerHTML += `<li>Idade: ${idade}, Peso: ${peso} kg</li>`;
        document.getElementById("idade").value = "";
        document.getElementById("peso").value = "";
    } else {
        alert("Por favor, preencha todos os campos.");
    }
}

function calcularMedias() {
    let faixas = {
        "1-10": [],
        "11-20": [],
        "21-30": [],
        "30+": []
    };

    // Classificar pessoas nas faixas etárias
    pessoas.forEach(pessoa => {
        if (pessoa.idade >= 1 && pessoa.idade <= 10) {
            faixas["1-10"].push(pessoa.peso);
        } else if (pessoa.idade >= 11 && pessoa.idade <= 20) {
            faixas["11-20"].push(pessoa.peso);
        } else if (pessoa.idade >= 21 && pessoa.idade <= 30) {
            faixas["21-30"].push(pessoa.peso);
        } else {
            faixas["30+"].push(pessoa.peso);
        }
    });

    let resultadoHTML = "";

    // Calcular média dos pesos por faixa etária
    for (let faixa in faixas) {
        let pesos = faixas[faixa];
        let media = pesos.length > 0 ? (pesos.reduce((a, b) => a + b, 0) / pesos.length).toFixed(2) : "Sem dados";
        resultadoHTML += `<p>Faixa ${faixa} anos: Média de Peso = ${media} kg</p>`;
    }

    document.getElementById("resultado").innerHTML = resultadoHTML;
}
