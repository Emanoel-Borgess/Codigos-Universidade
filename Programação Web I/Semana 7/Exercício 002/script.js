function mostrarMes() {
    let numero = parseInt(document.getElementById("numeroMes").value);
    let resultado = document.getElementById("resultado");
    
    let mes;
    switch (numero) {
        case 1: mes = "Janeiro"; break;
        case 2: mes = "Fevereiro"; break;
        case 3: mes = "Março"; break;
        case 4: mes = "Abril"; break;
        case 5: mes = "Maio"; break;
        case 6: mes = "Junho"; break;
        case 7: mes = "Julho"; break;
        case 8: mes = "Agosto"; break;
        case 9: mes = "Setembro"; break;
        case 10: mes = "Outubro"; break;
        case 11: mes = "Novembro"; break;
        case 12: mes = "Dezembro"; break;
        default: mes = "Número inválido! Digite um número de 1 a 12.";
    }

    resultado.textContent = mes;
}
