// server.js - Plataforma de Adoção
const express = require("express");
const sqlite3 = require("sqlite3").verbose();
const path = require("path");
const bcrypt = require("bcryptjs");
const multer = require("multer");

// Configuração do multer (para salvar fotos)
const storage = multer.diskStorage({
  destination: (req, file, cb) => cb(null, "uploads/"),
  filename: (req, file, cb) => cb(null, Date.now() + "-" + file.originalname)
});
const upload = multer({ storage });

const app = express();
const PORT = 3000;

// Configurar para receber JSON e dados de formulários
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Servir arquivos estáticos (HTML, CSS, JS)
app.use(express.static(path.join(__dirname, "public")));
app.use("/uploads", express.static("uploads"));

// Conectar ao banco SQLite
const db = new sqlite3.Database("./database.db", (err) => {
  if (err) console.error("Erro ao conectar ao banco:", err);
  else console.log("Banco de dados conectado com sucesso!");
});

// Criar tabelas se não existirem
db.serialize(() => {
  db.run(`CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    senha TEXT NOT NULL,
    perfil TEXT NOT NULL
  )`);

  db.run(`CREATE TABLE IF NOT EXISTS animals (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    especie TEXT NOT NULL,
    idade INTEGER,
    descricao TEXT,
    foto TEXT,
    status TEXT DEFAULT 'Disponível',
    donoId INTEGER,
    FOREIGN KEY(donoId) REFERENCES users(id)
  )`);

  // Criar admin fixo se não existir
  const adminEmail = "teste@adm.com";
  const adminSenha = "adm123";
  db.get("SELECT * FROM users WHERE email = ?", [adminEmail], async (err, row) => {
    if (!row) {
      const hash = await bcrypt.hash(adminSenha, 10);
      db.run("INSERT INTO users (nome, email, senha, perfil) VALUES (?, ?, ?, ?)",
        ["Admin", adminEmail, hash, "admin"]);
      console.log("Admin fixo criado: teste@adm.com / adm123");
    }
  });
});

// ================= ROTAS =================

// Rota de teste
app.get("/api/teste", (req, res) => res.json({ message: "Servidor funcionando 🚀" }));

// ================= USUÁRIOS =================

// Cadastro de usuário
app.post("/api/register", async (req, res) => {
  try {
    const { nome, email, senha } = req.body;
    if (!nome || !email || !senha) return res.status(400).json({ error: "Todos os campos são obrigatórios" });

    // Bloquear cadastro com email do admin
    if (email === "teste@adm.com") {
      return res.status(400).json({ error: "Este email é reservado para o admin." });
    }

    const hashSenha = await bcrypt.hash(senha, 10);
    const sql = `INSERT INTO users (nome, email, senha, perfil) VALUES (?, ?, ?, ?)`;
    db.run(sql, [nome, email, hashSenha, "user"], function(err) {
      if (err) return res.status(500).json({ error: "Erro ao cadastrar usuário" });
      res.json({ success: true, id: this.lastID });
    });
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: "Erro interno" });
  }
});

// Login
app.post("/api/login", (req, res) => {
  const { email, senha } = req.body;
  if (!email || !senha) return res.status(400).json({ error: "Email e senha são obrigatórios" });

  const sql = `SELECT * FROM users WHERE email = ?`;
  db.get(sql, [email], async (err, user) => {
    if (err) return res.status(500).json({ error: "Erro no login" });
    if (!user) return res.status(400).json({ error: "Usuário não encontrado" });

    const senhaOk = await bcrypt.compare(senha, user.senha);
    if (!senhaOk) return res.status(400).json({ error: "Senha incorreta" });

    res.json({ usuario: { id: user.id, nome: user.nome, email: user.email, perfil: user.perfil } });
  });
});

// ================= ANIMAIS =================

// Listar todos os animais
app.get("/api/animals", (req, res) => {
  db.all("SELECT * FROM animals ORDER BY id DESC", [], (err, rows) => {
    if (err) return res.status(500).json({ error: "Erro ao buscar animais" });
    res.json(rows);
  });
});

app.get("/api/animals/:id", (req, res) => {
  const id = req.params.id;
  db.get("SELECT * FROM animals WHERE id = ?", [id], (err, row) => {
    if (err) return res.status(500).json({ error: "Erro ao buscar animal" });
    if (!row) return res.status(404).json({ error: "Animal não encontrado" });
    res.json(row);
  });
});

// Criar animal
app.post("/api/animals", upload.single("foto"), (req, res) => {
  const { nome, especie, idade, descricao, donoId } = req.body;
  const foto = req.file ? req.file.filename : null;

  if (!donoId) return res.status(400).json({ error: "Usuário não identificado" });

  const sql = `INSERT INTO animals (nome, especie, idade, descricao, foto, donoId) VALUES (?, ?, ?, ?, ?, ?)`;
  db.run(sql, [nome, especie, idade, descricao, foto, donoId], function(err) {
    if (err) return res.status(500).json({ error: "Erro ao cadastrar animal" });
    res.json({ success: true, id: this.lastID });
  });
});

// Editar animal
// Atualizar animal (edição com imagem opcional)
app.put("/api/animals/:id", upload.single("foto"), (req, res) => {
  const id = req.params.id;
  const { nome, especie, idade, descricao } = req.body;
  const foto = req.file ? req.file.filename : null;

  let sql = "UPDATE animals SET nome=?, especie=?, idade=?, descricao=?";
  const params = [nome, especie, idade, descricao];

  if (foto) {
    sql += ", foto=?";
    params.push(foto);
  }

  sql += " WHERE id=?";
  params.push(id);

  db.run(sql, params, function(err) {
    if (err) return res.status(500).json({ error: "Erro ao atualizar animal" });
    if (this.changes === 0) return res.status(404).json({ error: "Animal não encontrado" });
    res.json({ success: true, message: "Animal atualizado com sucesso!" });
  });
});

// Apagar animal
app.delete("/api/animals/:id", (req, res) => {
  const id = req.params.id;
  db.run("DELETE FROM animals WHERE id = ?", [id], function(err) {
    if (err) return res.status(500).json({ error: "Erro ao apagar animal" });
    res.json({ success: true });
  });
});

// Marcar animal como adotado
app.put("/api/animals/:id/adotar", (req, res) => {
  const id = req.params.id;
  db.run("UPDATE animals SET status='Adotado' WHERE id=?", [id], function(err) {
    if (err) return res.status(500).json({ error: "Erro ao adotar animal" });
    if (this.changes === 0) return res.status(404).json({ error: "Animal não encontrado" });
    res.json({ success: true, message: "Animal adotado com sucesso!" });
  });
});

// ================= INICIAR SERVIDOR =================
app.listen(PORT, () => console.log(`Servidor rodando em http://localhost:${PORT}`));
