function verificarNota() {
    let nota = document.getElementById("nota").value;
    let mensagem;
    if (nota < 0 || nota > 100) {
        mensagem = "Sua nota é menor que 0 ou maior que 100. Isso não é permitido"
    }else{
        if (nota >= 90) {
        mensagem = "Excelente";
        } else if (nota >= 60) {
        mensagem = "Bom";
        } else {
        mensagem = "Precisa Melhorar";
        }
    }
    document.getElementById("desempenho").innerText = mensagem;
    }
   