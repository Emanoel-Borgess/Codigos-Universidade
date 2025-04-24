<?php
include 'conexao.php';

$id = (int)$_GET['id'];

if (isset($_POST['atualizar'])) {
    $nome = $_POST['nome'];
    $telefone = $_POST['telefone'];
    $endereco = $_POST['endereco'];
    $experiencia = (int)$_POST['experiencia'];
    $salario = (float)$_POST['salario'];

    $stmt = $mysqli->prepare("UPDATE colaboradores SET nome=?, telefone=?, endereco=?, experiencia=?, salario=? WHERE id=?");
    $stmt->bind_param("sssidi", $nome, $telefone, $endereco, $experiencia, $salario, $id);
    $stmt->execute();

    header("Location: index.php");
    exit;
}

$dados = $mysqli->query("SELECT * FROM colaboradores WHERE id = $id")->fetch_assoc();
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar Colaborador</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="mb-4 text-center">Editar Colaborador</h2>
    <form method="POST" class="card p-4 shadow-sm">
        <input type="text" name="nome" class="form-control mb-3" value="<?= $dados['nome'] ?>" required>
        <input type="text" name="telefone" class="form-control mb-3" value="<?= $dados['telefone'] ?>">
        <input type="text" name="endereco" class="form-control mb-3" value="<?= $dados['endereco'] ?>">
        <input type="number" name="experiencia" class="form-control mb-3" value="<?= $dados['experiencia'] ?>" required>
        <input type="number" name="salario" class="form-control mb-3" value="<?= $dados['salario'] ?>" step="0.01" required>
        <button type="submit" name="atualizar" class="btn btn-success w-100">Salvar Alterações</button>
    </form>
</div>
</body>
</html>
