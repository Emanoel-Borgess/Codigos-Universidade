// model.js - O Modelo (camada de dados)

const tarefas = []; // O "banco de dados" em memória

export const Model = {
    // Retorna todas as tarefas
    getTarefas: () => {
        return tarefas;
    },

    // Adiciona uma nova tarefa
    addTarefa: (descricao) => {
        const novaTarefa = {
            id: tarefas.length + 1,
            descricao: descricao,
            completa: false,
        };
        tarefas.push(novaTarefa);
        return novaTarefa;
    },

    // Alterna o status (completa/incompleta) de uma tarefa
    toggleTarefaCompleta: (id) => {
        const tarefa = tarefas.find(t => t.id === id);
        if (tarefa) {
            tarefa.completa = !tarefa.completa;
            return tarefa;
        }
        return null;
    }
};