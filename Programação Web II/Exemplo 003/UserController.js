// UserController.js
const User = require("./User"); // Corrigido o caminho do arquivo

class UserController {
    constructor(userDAO, userView) {
        this.userDAO = userDAO;
        this.userView = userView;
    }

    addUser(name, email) {
        const user = new User(null, name, email);
        const savedUser = this.userDAO.create(user);
        this.userView.showUserCreated(savedUser);
    }

    listUsers() {
        const users = this.userDAO.findAll();
        this.userView.showUserList(users);
    }
}

module.exports = UserController;