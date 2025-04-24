-- STORED PROCEDURES (4+)
DELIMITER //

-- 1. Inserir novo jogo
CREATE PROCEDURE InserirJogo (
    IN nome_jogo VARCHAR(100),
    IN genero_jogo VARCHAR(50),
    IN data_lanc DATE,
    IN preco_jogo DECIMAL(10,2)
)
BEGIN
    INSERT INTO Jogos (nome, genero, data_lancamento, preco)
    VALUES (nome_jogo, genero_jogo, data_lanc, preco_jogo);
END //

-- 2. Atualizar preço de jogo
CREATE PROCEDURE AtualizarPreco (
    IN id INT,
    IN novo_preco DECIMAL(10,2)
)
BEGIN
    UPDATE Jogos SET preco = novo_preco WHERE id_jogo = id;
END //

-- 3. Criar promoção para jogo
CREATE PROCEDURE CriarPromocao (
    IN jogo_id INT,
    IN desc_promo VARCHAR(255),
    IN desconto_promo DECIMAL(5,2),
    IN inicio_promo DATE,
    IN fim_promo DATE
)
BEGIN
    INSERT INTO Promocoes (id_jogo, descricao, desconto, data_inicio, data_fim)
    VALUES (jogo_id, desc_promo, desconto_promo, inicio_promo, fim_promo);
END //

-- 4. Listar promoções ativas
CREATE PROCEDURE ListarPromocoesAtivas ()
BEGIN
    SELECT j.nome AS jogo, p.desconto, p.descricao, p.data_inicio, p.data_fim
    FROM Promocoes p
    JOIN Jogos j ON p.id_jogo = j.id_jogo
    WHERE CURDATE() BETWEEN p.data_inicio AND p.data_fim;
END //

-- 5. Deletar usuário
CREATE PROCEDURE DeletarUsuario (
    IN uid INT
)
BEGIN
    DELETE FROM Usuarios WHERE id_usuario = uid;
END //

DELIMITER ;


-- FUNCTIONS (2+)

DELIMITER //

-- 1. Calcular média de notas de um jogo
CREATE FUNCTION CalcularMediaNotas(id_jogo INT) RETURNS DECIMAL(4,2)
DETERMINISTIC
BEGIN
    DECLARE media DECIMAL(4,2);
    SELECT AVG(nota) INTO media FROM Avaliacoes WHERE Avaliacoes.id_jogo = id_jogo;
    RETURN media;
END //

-- 2. Verificar se email é único
CREATE FUNCTION VerificarEmailUnico(email_check VARCHAR(100)) RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total FROM Usuarios WHERE email = email_check;
    RETURN total = 0;
END //

-- 3. Calcular preço com desconto
CREATE FUNCTION CalcularPrecoComDesconto(jogo_id INT) RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE preco_original DECIMAL(10,2);
    DECLARE desconto_ativo DECIMAL(5,2);
    DECLARE preco_final DECIMAL(10,2);
    
    SELECT preco INTO preco_original FROM Jogos WHERE id_jogo = jogo_id;
    
    SELECT desconto INTO desconto_ativo FROM Promocoes 
    WHERE id_jogo = jogo_id AND CURDATE() BETWEEN data_inicio AND data_fim
    LIMIT 1;
    
    IF desconto_ativo IS NULL THEN
        SET desconto_ativo = 0;
    END IF;
    
    SET preco_final = preco_original * (1 - (desconto_ativo/100));
    RETURN preco_final;
END //

DELIMITER ;


-- TRIGGERS (5+)

DELIMITER //

-- 1. Validar email antes de inserir usuário
CREATE TRIGGER antes_insert_usuario
BEFORE INSERT ON Usuarios
FOR EACH ROW
BEGIN
    IF NEW.email IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Email é obrigatório!';
    END IF;
END //

-- 2. Definir data atual para avaliação se não informada
CREATE TRIGGER atualizar_data_avaliacao
BEFORE INSERT ON Avaliacoes
FOR EACH ROW
BEGIN
    IF NEW.data_avaliacao IS NULL THEN
        SET NEW.data_avaliacao = CURDATE();
    END IF;
END //

-- 3. Validar nota da avaliação
CREATE TRIGGER impedir_nota_invalida
BEFORE INSERT ON Avaliacoes
FOR EACH ROW
BEGIN
    IF NEW.nota < 1 OR NEW.nota > 10 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Nota inválida. Deve ser entre 1 e 10.';
    END IF;
END //

-- 4. Validar preço não negativo
CREATE TRIGGER atualizar_preco_negativo
BEFORE UPDATE ON Jogos
FOR EACH ROW
BEGIN
    IF NEW.preco < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Preço não pode ser negativo!';
    END IF;
END //

-- 5. Impedir exclusão de administradores
CREATE TRIGGER impedir_exclusao_admin
BEFORE DELETE ON Usuarios
FOR EACH ROW
BEGIN
    IF OLD.tipo_usuario = 'admin' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Admins não podem ser excluídos!';
    END IF;
END //

-- 6. Verificar datas válidas para promoção
CREATE TRIGGER validar_datas_promocao
BEFORE INSERT ON Promocoes
FOR EACH ROW
BEGIN
    IF NEW.data_fim <= NEW.data_inicio THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Data fim deve ser posterior à data início.';
    END IF;
END //

DELIMITER ;


-- VIEWS (3+)

-- 1. Média de avaliações por jogo
CREATE VIEW View_MediaAvaliacoes AS
SELECT j.nome, CalcularMediaNotas(j.id_jogo) AS media
FROM Jogos j;

-- 2. Jogos e suas plataformas
CREATE VIEW View_Jogos_Plataformas AS
SELECT j.nome AS jogo, p.nome_plataforma AS plataforma
FROM Jogos j
JOIN Jogo_Plataforma jp ON j.id_jogo = jp.id_jogo
JOIN Plataformas p ON p.id_plataforma = jp.id_plataforma;

-- 3. Usuários avaliadores
CREATE VIEW View_Usuarios_Avaliadores AS
SELECT nome, email FROM Usuarios WHERE tipo_usuario = 'avaliador';

-- 4. Promoções ativas com preço promocional
CREATE VIEW View_PromocoesAtivas AS
SELECT 
    j.nome AS jogo,
    j.preco AS preco_original,
    p.desconto,
    CalcularPrecoComDesconto(j.id_jogo) AS preco_promocional,
    p.data_inicio,
    p.data_fim,
    p.descricao
FROM Promocoes p
JOIN Jogos j ON p.id_jogo = j.id_jogo
WHERE CURDATE() BETWEEN p.data_inicio AND p.data_fim;

-- 5. Jogos mais bem avaliados
CREATE VIEW View_TopJogos AS
SELECT 
    j.nome,
    CalcularMediaNotas(j.id_jogo) AS media_nota,
    COUNT(a.id_avaliacao) AS total_avaliacoes
FROM Jogos j
LEFT JOIN Avaliacoes a ON j.id_jogo = a.id_jogo
GROUP BY j.id_jogo
ORDER BY media_nota DESC
LIMIT 10;


-- USUÁRIOS DO BANCO (para cada aluno)

-- Administrador (todos os privilégios)
CREATE USER 'admin1'@'localhost' IDENTIFIED BY 'senha123';
GRANT ALL PRIVILEGES ON EmpresaJogos.* TO 'admin1'@'localhost';

-- Desenvolvedor (pode inserir/atualizar dados)
CREATE USER 'dev1'@'localhost' IDENTIFIED BY 'senha123';
GRANT SELECT, INSERT, UPDATE ON EmpresaJogos.* TO 'dev1'@'localhost';
GRANT EXECUTE ON PROCEDURE EmpresaJogos.InserirJogo TO 'dev1'@'localhost';
GRANT EXECUTE ON PROCEDURE EmpresaJogos.AtualizarPreco TO 'dev1'@'localhost';
GRANT EXECUTE ON PROCEDURE EmpresaJogos.CriarPromocao TO 'dev1'@'localhost';

-- Avaliador (pode inserir avaliações)
CREATE USER 'avaliador1'@'localhost' IDENTIFIED BY 'senha123';
GRANT SELECT ON EmpresaJogos.* TO 'avaliador1'@'localhost';
GRANT INSERT ON EmpresaJogos.Avaliacoes TO 'avaliador1'@'localhost';
GRANT SELECT ON EmpresaJogos.View_MediaAvaliacoes TO 'avaliador1'@'localhost';
GRANT SELECT ON EmpresaJogos.View_TopJogos TO 'avaliador1'@'localhost';

-- Leitor (apenas consultas)
CREATE USER 'leitor1'@'localhost' IDENTIFIED BY 'senha123';
GRANT SELECT ON EmpresaJogos.View_MediaAvaliacoes TO 'leitor1'@'localhost';
GRANT SELECT ON EmpresaJogos.View_Jogos_Plataformas TO 'leitor1'@'localhost';
GRANT SELECT ON EmpresaJogos.View_PromocoesAtivas TO 'leitor1'@'localhost';
GRANT SELECT ON EmpresaJogos.View_TopJogos TO 'leitor1'@'localhost';

-- Usuário para relatórios
CREATE USER 'relatorios'@'localhost' IDENTIFIED BY 'senha123';
GRANT SELECT ON EmpresaJogos.* TO 'relatorios'@'localhost';
GRANT EXECUTE ON FUNCTION EmpresaJogos.CalcularMediaNotas TO 'relatorios'@'localhost';
GRANT EXECUTE ON FUNCTION EmpresaJogos.CalcularPrecoComDesconto TO 'relatorios'@'localhost';