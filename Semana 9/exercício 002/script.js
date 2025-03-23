function lista(){
    const frutas = ["Manga","Melão","Banana","Morango"];
    let lista = document.getElementById ("frutas");
    lista.innerHTML = "";

    for (let i = 0; i < frutas.length; i++){//Usando frutas.length, o código funciona para qualquer tamanho de array, pois length sempre retorna o número correto de elementos.
        let item = document.createElement("li");
        item.textContent = frutas[i];
        lista.appendChild(item);
    }
}