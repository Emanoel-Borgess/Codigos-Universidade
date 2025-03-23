function numeros(){
    let lista = document.getElementById("listaNumeros");//Obtenha a <ul> onde os Números serão exibidos pelo ID
    lista.innerHTML = "";//Antes de adicionar os números, limpamoos a lista para evitar duplicação caso o otão seja clicado várias vezes
     for (let i = 1; i<=10; i++){
        let item = document.createElement("li");//Cria e armazena um novo elemento
        item.textContent = i;//Define o conteúdo <li> como o número atual do loop
        lista.appendChild(item);//Adicionando o <li> dentro da <ul>
     }
}