<?php include 'conexao.php'; ?>

<?php
// Função para limpar dados
function limpar($valor) {
    return htmlspecialchars(trim($valor));
}

// Inserção de colaborador
if (isset($_POST['inserir'])) {
    $nome = limpar($_POST['nome']);
    $telefone = limpar($_POST['telefone']);
    $endereco = limpar($_POST['endereco']);
    $experiencia = (int)$_POST['experiencia'];
    $salario = (float)$_POST['salario'];

    if ($nome && $experiencia >= 0 && $salario >= 0) {
        $stmt = $mysqli->prepare("INSERT INTO colaboradores (nome, telefone, endereco, experiencia, salario) VALUES (?, ?, ?, ?, ?)");
        $stmt->bind_param("sssii", $nome, $telefone, $endereco, $experiencia, $salario);
        $stmt->execute();
    }
}

// Exclusão
if (isset($_GET['excluir'])) {
    $id = (int)$_GET['excluir'];
    $mysqli->query("DELETE FROM colaboradores WHERE id = $id");
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Colaboradores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="text-center mb-4">Cadastro de Colaboradores</h2>

    <!-- Formulário de cadastro -->
    <form method="POST" class="card p-4 shadow-sm mb-4">
        <div class="row mb-3">
            <div class="col">
                <input type="text" name="nome" class="form-control" placeholder="Nome completo" required>
            </div>
            <div class="col">
                <input type="text" name="telefone" class="form-control" placeholder="Telefone">
            </div>
        </div>
        <div class="mb-3">
            <input type="text" name="endereco" class="form-control" placeholder="Endereço">
        </div>
        <div class="row mb-3">
            <div class="col">
                <input type="number" name="experiencia" class="form-control" placeholder="Anos de experiência" min="0" required>
            </div>
            <div class="col">
                <input type="number" name="salario" class="form-control" placeholder="Salário mensal" min="0" step="0.01" required>
            </div>
        </div>
        <button type="submit" name="inserir" class="btn btn-primary w-100">Cadastrar</button>
    </form>

    <!-- Lista de colaboradores -->
    <h4 class="text-center mb-3">Lista de Colaboradores</h4>
    <table class="table table-bordered table-striped table-hover shadow-sm">
        <thead class="table-dark">
        <tr>
            <th>Nome</th>
            <th>Telefone</th>
            <th>Endereço</th>
            <th>Experiência</th>
            <th>Salário</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <?php
        $resultado = $mysqli->query("SELECT * FROM colaboradores");

        while ($linha = $resultado->fetch_assoc()) {
            echo "<tr>
                    <td>{$linha['nome']}</td>
                    <td>{$linha['telefone']}</td>
                    <td>{$linha['endereco']}</td>
                    <td>{$linha['experiencia']} anos</td>
                    <td>R$ {$linha['salario']}</td>
                    <td>
                        <a href='editar.php?id={$linha['id']}' class='btn btn-sm btn-warning'>Editar</a>
                        <a href='?excluir={$linha['id']}' class='btn btn-sm btn-danger' onclick=\"return confirm('Tem certeza que deseja excluir?')\">Excluir</a>
                    </td>
                </tr>";
        }
        ?>
        </tbody>
    </table>
</div>
</body>
</html>
