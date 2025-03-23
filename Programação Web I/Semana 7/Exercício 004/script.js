function calcularImposto() {
    let salario = parseFloat(document.getElementById("salario").value);
    let aliquota;

    if (salario < 1903.99) {
        aliquota = "Isento";
    } else if (salario < 2826.66) {
        aliquota = "7,5% do salário bruto";
    } else if (salario < 3751.06) {
        aliquota = "15% do salário bruto";
    } else if (salario < 4664.69) {
        aliquota = "22,5% do salário bruto";
    } else {
        aliquota = "27,5% do salário bruto";
    }

    document.getElementById("resultado").textContent = "Alíquota: " + aliquota;
}
