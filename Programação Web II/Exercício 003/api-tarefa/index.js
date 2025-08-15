// index.js

import express from 'express'; // Importa o módulo express [cite: 30]
import { Tarefas } from './repositorio.js'; // Importa a classe Tarefas [cite: 30]

const app = express();
const port = 3000; // Define a porta do servidor
const repositorio = new Tarefas();

// Middleware para permitir que o Express entenda requisições com corpo em JSON
app.use(express.json());

// Rota para listar todas as tarefas (GET) [cite: 22]
app.get('/tarefas', (req, res) => {
    const tarefas = repositorio.listar();
    res.status(200).json(tarefas);
});

// Rota para inserir uma nova tarefa (POST) [cite: 22]
app.post('/tarefas', (req, res) => {
    const novaTarefa = req.body;
    const tarefaAdicionada = repositorio.inserir(novaTarefa);
    res.status(201).json(tarefaAdicionada);
});

// Rota para atualizar uma tarefa existente (PUT) [cite: 22]
app.put('/tarefas/:id', (req, res) => {
    const id = req.params.id;
    const tarefaAtualizada = req.body;
    const tarefa = repositorio.atualizar(id, tarefaAtualizada);
    res.status(200).json(tarefa);
});

// Rota para apagar uma tarefa (DELETE) [cite: 22]
app.delete('/tarefas/:id', (req, res) => {
    const id = req.params.id;
    repositorio.apagar(id);
    res.status(204).send(); // 204 No Content para sucesso sem corpo de resposta
});

// Inicia o servidor para escutar na porta definida
app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});