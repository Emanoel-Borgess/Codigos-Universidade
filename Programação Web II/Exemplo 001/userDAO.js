import sqlite3 from "sqlite3";
import { open } from "sqlite";
import User from "./user.js";

class UserDAO {
  async init() {
    // Abre conexão com o banco
    this.db = await open({
      filename: "./database.sqlite",
      driver: sqlite3.Database
    });

    // Cria a tabela se não existir
    await this.db.exec(`
      CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT,
        email TEXT
      )
    `);
  }

  // CREATE
  async addUser(name, email) {
    const result = await this.db.run(
      "INSERT INTO users (name, email) VALUES (?, ?)",
      [name, email]
    );
    return new User(result.lastID, name, email);
  }

  // READ - todos
  async getAllUsers() {
    const rows = await this.db.all("SELECT * FROM users");
    return rows.map(row => new User(row.id, row.name, row.email));
  }

  // READ - por ID
  async getUserById(id) {
    const row = await this.db.get("SELECT * FROM users WHERE id = ?", [id]);
    if (row) return new User(row.id, row.name, row.email);
    return null;
  }

  // UPDATE
  async updateUser(id, newName, newEmail) {
    await this.db.run(
      "UPDATE users SET name = ?, email = ? WHERE id = ?",
      [newName, newEmail, id]
    );
    return this.getUserById(id);
  }

  // DELETE
  async deleteUser(id) {
    await this.db.run("DELETE FROM users WHERE id = ?", [id]);
    return true;
  }
}

export default UserDAO;
