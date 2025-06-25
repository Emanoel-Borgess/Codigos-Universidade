function adicionar(tipoConvidado) {
    // Seleciona a lista UL correta
    const lista = document.getElementById(`${tipoConvidado}-lista`);

    // Cria um item para a lista
    const item = document.createElement('li');
    item.className = 'linha';

    // Cria o campo de texto
    const input = document.createElement('input');
    input.type = 'text';
    input.placeholder = 'Nome do convidado';

    // Cria o botão X
    const botao = document.createElement('button');
    botao.textContent = 'X';

    // Define a ação de remover o item
    botao.onclick = () => {
        lista.removeChild(item);
    };

    // Monta o item
    item.appendChild(input);
    item.appendChild(botao);

    // Adiciona o item à lista
    lista.appendChild(item);
}

function confirmar() {
    // Seleciona todos os inputs dos adultos e crianças
    const adultos = document.querySelectorAll('#adultos-lista input');
    const criancas = document.querySelectorAll('#criancas-lista input');

    let nomes = [];

    // Pega os nomes preenchidos dos adultos
    adultos.forEach(input => {
        if (input.value.trim() !== '') {
            nomes.push(input.value.trim());
        }
    });

    // Pega os nomes preenchidos das crianças
    criancas.forEach(input => {
        if (input.value.trim() !== '') {
            nomes.push(input.value.trim());
        }
    });

    // Se nenhum nome foi preenchido
    if (nomes.length === 0) {
        alert("Você não preencheu os nomes das pessoas que irão no aniversário. Tente novamente.");
    } else {
        // Monta a lista dos nomes em linhas
        const listaNomes = nomes.map(nome => `- ${nome}`).join('\n');
        confirm(`Você confirma a presença dos seguintes convidados?\n${listaNomes}`);
    }
}
