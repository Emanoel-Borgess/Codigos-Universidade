// UserDAO.js
const Database = require("better-sqlite3");
const User = require("./User"); // Corrigido o caminho do arquivo

class UserDAO {
    constructor() {
        this.db = new Database("database.db");
        this.db.prepare(`
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                email TEXT
            )
        `).run();
    }

    create(user) {
        const stmt = this.db.prepare("INSERT INTO users (name, email) VALUES (?, ?)");
        const result = stmt.run(user.name, user.email);
        user.id = result.lastInsertRowid;
        return user;
    }

    findAll() {
        return this.db.prepare("SELECT * FROM users").all()
            .map(row => new User(row.id, row.name, row.email));
    }
}

module.exports = UserDAO;