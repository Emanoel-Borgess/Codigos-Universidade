<!-- Data: 07/04/2025
Desenvolva um script em PHP que exiba uma lista 
de notas e informe se cada aluno foi Aprovado ou 
Reprovado. As notas dos alunos são fornecidas em 
um array. O critério para aprovação é ter uma nota 
maior ou igual a 60. A saída deve ser uma página 
HTML que apresente os resultados de cada aluno, 
informando a nota e o respectivo status de aprovação.
 Notas: 35, 77, 65, 49, 28 e 95.-->

<?php
// Array de notas dos alunos
$notas = [35, 77, 65, 49, 28, 95];
?>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Exercício 01</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        table {
            border-collapse: collapse;
            width: 400px;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        .aprovado {
            color: green;
            font-weight: bold;
        }
        .reprovado {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>Resultados dos Alunos</h1>

    <table>
        <tr>
            <th>Aluno</th>
            <th>Nota</th>
            <th>Status</th>
        </tr>
        <?php
        // Loop para exibir cada nota com o status
        foreach ($notas as $indice => $nota) {
            $status = ($nota >= 60) ? "Aprovado" : "Reprovado";
            $classe = ($nota >= 60) ? "aprovado" : "reprovado";

            echo "<tr>";
            echo "<td>Aluno " . ($indice + 1) . "</td>";
            echo "<td>$nota</td>";
            echo "<td class='$classe'>$status</td>";
            echo "</tr>";
        }
        ?>
    </table>
</body>
</html>
