<!-- Data: 07/04/2025
 Usando PHP, gere uma lista HTML (<ul>) que exiba 
os números de 1 até 30, utilizando o loop for.-->

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Exercício 02</title>
</head>
<body>
    <h1>Números de 1 a 30</h1>
    <ul>
        <?php
            // Loop que vai de 1 até 30
            for ($i = 1; $i <= 30; $i++) {
                echo "<li>$i</li>";
            }
        ?>
    </ul>
</body>
</html>
