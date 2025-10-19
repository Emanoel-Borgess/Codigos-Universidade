// index.js
const UserDAO = require("./UserDAO");
const UserController = require("./UserController");
const UserView = require("./UserView");

// Criar DAO, Controller e View
const userDAO = new UserDAO();
const userView = new UserView();
const userController = new UserController(userDAO, userView);

// Criar alguns usuários
userController.addUser("João", "joao@example.com");
userController.addUser("Maria", "maria@example.com");

// Listar usuários
userController.listUsers();