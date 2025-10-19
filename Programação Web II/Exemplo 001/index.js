import UserDAO from "./userDAO.js";

async function main() {
  //cria uma instância do UserDAO.
  const userDAO = new UserDAO();
  // inicia a conexão com o banco de dados.
  await userDAO.init();

  // Criar dois usuários
  const u1 = await userDAO.addUser("João", "joao@email.com");
  const u2 = await userDAO.addUser("Maria", "maria@email.com");

  console.log("Todos os usuários:", await userDAO.getAllUsers(),"\n");

  console.log("Usuário com o ID 1:", await userDAO.getUserById(1),"\n");

  await userDAO.updateUser(1, "João Silva", "joaosilva@email.com");
  console.log("Usuário atualizado:", await userDAO.getUserById(1),"\n");

  await userDAO.deleteUser(2);
  console.log("Usuários após a exclusão:", await userDAO.getAllUsers(),"\n");
}

main().catch(err => {
  console.error("Erro no app:", err);
  process.exit(1);
});
