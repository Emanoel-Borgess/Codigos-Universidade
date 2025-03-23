function calcularEstatisticas() {
    let entrada = document.getElementById("valores").value;
    let numeros = entrada.split(",").map(num => parseFloat(num.trim())).filter(num => !isNaN(num));

    if (numeros.length === 0) {
        alert("Por favor, insira pelo menos um número válido.");
        return;
    }

    let soma = numeros.reduce((acc, num) => acc + num, 0);
    let media = soma / numeros.length;
    let positivos = numeros.filter(num => num > 0).length;
    let negativos = numeros.filter(num => num < 0).length;
    let total = numeros.length;
    let percentualPositivos = (positivos / total) * 100;
    let percentualNegativos = (negativos / total) * 100;

    document.getElementById("media").textContent = media.toFixed(2);
    document.getElementById("positivos").textContent = positivos;
    document.getElementById("negativos").textContent = negativos;
    document.getElementById("percentualPositivos").textContent = percentualPositivos.toFixed(2);
    document.getElementById("percentualNegativos").textContent = percentualNegativos.toFixed(2);
}
