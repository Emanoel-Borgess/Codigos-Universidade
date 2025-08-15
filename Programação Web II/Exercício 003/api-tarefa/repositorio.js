// repositorio.js

import better_sqlite3 from 'better-sqlite3';

// Exporta a classe Tarefas para ser utilizada em outros módulos [cite: 33]
export class Tarefas {
    constructor() {
        // Define o arquivo onde o banco de dados será armazenado [cite: 37]
        this.db = new better_sqlite3('tarefas.db');
        // Cria a tabela 'tarefas' caso ela não exista [cite: 34]
        this.db.exec(`
            CREATE TABLE IF NOT EXISTS tarefas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                descricao TEXT NOT NULL,
                concluida BOOLEAN NOT NULL CHECK (concluida IN (0, 1))
            );
        `);
    }

    // Método para listar todas as tarefas
    listar() {
        // Prepara e executa a query, retornando todos os resultados
        const stmt = this.db.prepare('SELECT * FROM tarefas');
        return stmt.all();
    }

    // Método para inserir uma nova tarefa
    inserir(tarefa) {
        const stmt = this.db.prepare(
            'INSERT INTO tarefas (descricao, concluida) VALUES (?, ?)'
        );
        // O método run retorna um objeto 'info' com detalhes da execução
        const info = stmt.run(tarefa.descricao, tarefa.concluida ? 1 : 0);

        // Retorna o objeto da tarefa recém-criada com o ID gerado
        return {
            id: info.lastInsertRowid,
            descricao: tarefa.descricao,
            concluida: tarefa.concluida ? 1 : 0
        };
    }

    // Método para atualizar uma tarefa existente
    atualizar(id, tarefa) {
        const stmt = this.db.prepare(
            'UPDATE tarefas SET descricao = ?, concluida = ? WHERE id = ?'
        );
        stmt.run(tarefa.descricao, tarefa.concluida ? 1 : 0, id);

        // Retorna o objeto da tarefa atualizada
        return {
            id: parseInt(id),
            descricao: tarefa.descricao,
            concluida: tarefa.concluida ? 1 : 0
        };
    }

    // Método para apagar uma tarefa
    apagar(id) {
        const stmt = this.db.prepare('DELETE FROM tarefas WHERE id = ?');
        stmt.run(id);
    }
}