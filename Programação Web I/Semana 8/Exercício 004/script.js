let temperaturas = [];

function adicionarTemperatura() {
    let temp = parseFloat(document.getElementById("temperatura").value);

    if (isNaN(temp)) {
        alert("Por favor, insira um valor válido.");
        return;
    }

    if (temperaturas.length < 10) {
        temperaturas.push(temp);
        document.getElementById("lista").innerHTML += `<li>${temp.toFixed(1)}°C</li>`;
        document.getElementById("temperatura").value = "";
    } else {
        alert("Você já inseriu 10 temperaturas.");
    }
}

function calcularEstatisticas() {
    if (temperaturas.length < 10) {
        alert("Por favor, insira 10 temperaturas antes de calcular.");
        return;
    }

    let menor = Math.min(...temperaturas);
    let maior = Math.max(...temperaturas);
    let media = temperaturas.reduce((acc, t) => acc + t, 0) / temperaturas.length;

    document.getElementById("resultado").innerHTML = `
        <p>Menor Temperatura: ${menor.toFixed(1)}°C</p>
        <p>Maior Temperatura: ${maior.toFixed(1)}°C</p>
        <p>Média das Temperaturas: ${media.toFixed(1)}°C</p>
    `;
}
