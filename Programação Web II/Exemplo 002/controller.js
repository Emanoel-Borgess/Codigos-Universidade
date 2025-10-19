import { Model } from './model.js'; // Importa o Modelo

// Seleciona os elementos da Visão
const formAdicionarTarefa = document.getElementById('form-adicionar-tarefa');
const inputTarefa = document.getElementById('input-tarefa');
const listaTarefas = document.getElementById('lista-tarefas');

// A Visão deve ser atualizada para refletir o estado do Modelo
function renderizarTarefas() {
    const tarefas = Model.getTarefas();
    listaTarefas.innerHTML = ''; // Limpa a lista antes de renderizar
    
    tarefas.forEach(tarefa => {
        const li = document.createElement('li');
        li.textContent = tarefa.descricao;
        li.classList.add('tarefa');
        if (tarefa.completa) {
            li.classList.add('completa');
        }
        li.dataset.id = tarefa.id; // Armazena o ID no elemento
        listaTarefas.appendChild(li);
    });
}

// O Controlador escuta os eventos da Visão
formAdicionarTarefa.addEventListener('submit', (evento) => {
    evento.preventDefault(); // Evita o recarregamento da página
    const descricao = inputTarefa.value;
    
    // O Controlador chama o Modelo para atualizar os dados
    Model.addTarefa(descricao);
    
    // O Controlador instrui a Visão a se atualizar
    renderizarTarefas();
    
    inputTarefa.value = ''; // Limpa o campo de input
});

listaTarefas.addEventListener('click', (evento) => {
    if (evento.target.tagName === 'LI') {
        const id = parseInt(evento.target.dataset.id);
        
        // O Controlador chama o Modelo para atualizar os dados
        Model.toggleTarefaCompleta(id);
        
        // O Controlador instrui a Visão a se atualizar
        renderizarTarefas();
    }
});

// A aplicação inicia renderizando a Visão inicial
document.addEventListener('DOMContentLoaded', renderizarTarefas);