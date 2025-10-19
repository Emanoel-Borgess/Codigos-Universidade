// UserView.js
class UserView {
    showUserCreated(user) {
        console.log("✅ Usuário criado com sucesso!");
        console.log(`ID: ${user.id}, Nome: ${user.name}, Email: ${user.email}`);
    }

    showUserList(users) {
        console.log("📋 Lista de usuários cadastrados:");
        users.forEach(u => {
            console.log(`- [${u.id}] ${u.name} <${u.email}>`);
        });
    }
}

module.exports = UserView;