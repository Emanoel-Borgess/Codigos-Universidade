<!-- Data: 07/04/2025
 Crie um array associativo em PHP que contenha 
informações de três produtos (nome, preço e 
quantidade). Em uma página HTML, exiba esses 
produtos em formato de tabela (<table>), usando PHP 
para iterar sobre o array.-->

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Exercício 03</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #333;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #eee;
        }
    </style>
</head>
<body>
    <h1>Produtos em Estoque</h1>

    <?php
        // Array associativo com 3 produtos
        $produtos = [
            [
                "nome" => "Teclado Mecânico",
                "preco" => 250.00,
                "quantidade" => 10
            ],
            [
                "nome" => "Mouse Gamer",
                "preco" => 150.00,
                "quantidade" => 20
            ],
            [
                "nome" => "Monitor 24''",
                "preco" => 1200.00,
                "quantidade" => 5
            ]
        ];
    ?>

    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Preço (R$)</th>
                <th>Quantidade</th>
            </tr>
        </thead>
        <tbody>
            <?php
                // Loop para exibir cada produto na tabela
                foreach ($produtos as $produto) {
                    echo "<tr>";
                    echo "<td>" . $produto["nome"] . "</td>";
                    echo "<td>" . number_format($produto["preco"], 2, ',', '.') . "</td>";
                    echo "<td>" . $produto["quantidade"] . "</td>";
                    echo "</tr>";
                }
            ?>
        </tbody>
    </table>
</body>
</html>
