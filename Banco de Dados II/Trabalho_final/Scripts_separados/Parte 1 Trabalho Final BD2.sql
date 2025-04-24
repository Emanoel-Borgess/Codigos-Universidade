CREATE DATABASE IF NOT EXISTS EmpresaJogos;
USE EmpresaJogos;

-- Tabela: Jogos
CREATE TABLE Jogos (
    id_jogo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    data_lancamento DATE,
    preco DECIMAL(10,2) CHECK (preco >= 0)
);

-- Tabela: Desenvolvedores
CREATE TABLE Desenvolvedores (
    id_desenvolvedor INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    pais_origem VARCHAR(50),
    email VARCHAR(100) UNIQUE
);

-- Tabela: Plataformas
CREATE TABLE Plataformas (
    id_plataforma INT PRIMARY KEY AUTO_INCREMENT,
    nome_plataforma VARCHAR(50) NOT NULL,
    fabricante VARCHAR(50)
);

-- Tabela: Usuarios
CREATE TABLE Usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    tipo_usuario ENUM('admin', 'avaliador', 'dev', 'leitor') NOT NULL
);

-- Tabela: Promocoes (NOVA TABELA)
CREATE TABLE Promocoes (
    id_promocao INT PRIMARY KEY AUTO_INCREMENT,
    id_jogo INT NOT NULL,
    desconto DECIMAL(5,2) CHECK (desconto > 0 AND desconto <= 100),
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    descricao VARCHAR(255),
    FOREIGN KEY (id_jogo) REFERENCES Jogos(id_jogo),
    CONSTRAINT chk_datas CHECK (data_fim > data_inicio)
);

-- Tabela: Avaliacoes
CREATE TABLE Avaliacoes (
    id_avaliacao INT PRIMARY KEY AUTO_INCREMENT,
    id_jogo INT,
    id_usuario INT,
    nota INT CHECK(nota BETWEEN 1 AND 10),
    comentario TEXT,
    data_avaliacao DATE,
    FOREIGN KEY (id_jogo) REFERENCES Jogos(id_jogo),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);

-- Tabela Relacional: Jogo_Plataforma (N:N)
CREATE TABLE Jogo_Plataforma (
    id_jogo INT,
    id_plataforma INT,
    PRIMARY KEY (id_jogo, id_plataforma),
    FOREIGN KEY (id_jogo) REFERENCES Jogos(id_jogo),
    FOREIGN KEY (id_plataforma) REFERENCES Plataformas(id_plataforma)
);

-- Tabela Relacional: Jogo_Desenvolvedor (N:N)
CREATE TABLE Jogo_Desenvolvedor (
    id_jogo INT,
    id_desenvolvedor INT,
    funcao VARCHAR(50),
    PRIMARY KEY (id_jogo, id_desenvolvedor),
    FOREIGN KEY (id_jogo) REFERENCES Jogos(id_jogo),
    FOREIGN KEY (id_desenvolvedor) REFERENCES Desenvolvedores(id_desenvolvedor)
);


-- INSERTS PARA JOGOS (20)
INSERT INTO Jogos (nome, genero, data_lancamento, preco) VALUES
('Space Battle', 'Ação', '2022-03-10', 59.99),
('Mystic Quest', 'RPG', '2021-11-05', 39.99),
('City Builder', 'Estratégia', '2020-07-22', 29.99),
('Car Racer X', 'Corrida', '2019-09-15', 49.99),
('Zombie Hunt', 'Terror', '2023-01-01', 44.99),
('Farm Life', 'Simulação', '2021-06-30', 19.99),
('Sky Jump', 'Plataforma', '2018-10-10', 24.99),
('Battle Tactics', 'Tática', '2022-08-14', 34.99),
('Fantasy Realms', 'Aventura', '2020-12-25', 54.99),
('Alien Invasion', 'Ficção Científica', '2017-05-05', 39.99),
('Soccer Kings', 'Esporte', '2023-09-01', 49.99),
('Puzzle World', 'Puzzle', '2022-02-02', 9.99),
('Deep Ocean', 'Exploração', '2021-04-12', 14.99),
('Monster Clash', 'Luta', '2019-03-03', 59.99),
('Drift Arena', 'Corrida', '2020-08-08', 39.99),
('Time Warp', 'Aventura', '2022-11-11', 29.99),
('Tower Defense Pro', 'Estratégia', '2021-01-15', 19.99),
('Guns & Glory', 'Ação', '2018-07-07', 24.99),
('Skyline Wars', 'Tática', '2019-02-20', 34.99),
('The Last Hero', 'RPG', '2020-10-10', 44.99);

-- INSERTS PARA DESENVOLVEDORES (20)
INSERT INTO Desenvolvedores (nome, pais_origem, email) VALUES
('DevX Studios', 'Brasil', 'devx@exemplo.com'),
('PixelForge', 'EUA', 'pixelforge@exemplo.com'),
('DreamMakers', 'Canadá', 'dream@exemplo.com'),
('IndiePlay', 'Reino Unido', 'indie@exemplo.com'),
('NexusSoft', 'Alemanha', 'nexus@exemplo.com'),
('FireStorm', 'França', 'fire@exemplo.com'),
('GameLab', 'Japão', 'gamelab@exemplo.com'),
('SolarGames', 'Brasil', 'solar@exemplo.com'),
('Oceanic Devs', 'Austrália', 'oceanic@exemplo.com'),
('HighTech Games', 'EUA', 'hightech@exemplo.com'),
('VirtualBox', 'Suécia', 'virtual@exemplo.com'),
('InnoPlay', 'Brasil', 'innoplay@exemplo.com'),
('ShadowCode', 'Coreia do Sul', 'shadow@exemplo.com'),
('Emerald Studios', 'Irlanda', 'emerald@exemplo.com'),
('DigitalWave', 'Itália', 'wave@exemplo.com'),
('Lunar Games', 'Portugal', 'lunar@exemplo.com'),
('RedPhoenix', 'Espanha', 'phoenix@exemplo.com'),
('CosmoSoft', 'Noruega', 'cosmo@exemplo.com'),
('MagicPixel', 'Brasil', 'magic@exemplo.com'),
('Moonlight Devs', 'Canadá', 'moon@exemplo.com');

-- INSERTS PARA PLATAFORMAS (20)
INSERT INTO Plataformas (nome_plataforma, fabricante) VALUES
('PC', 'Diversos'),
('Xbox One', 'Microsoft'),
('PS4', 'Sony'),
('Switch', 'Nintendo'),
('PS5', 'Sony'),
('Xbox Series X', 'Microsoft'),
('SteamDeck', 'Valve'),
('Mobile', 'Diversos'),
('VR Oculus', 'Meta'),
('VR HTC', 'HTC'),
('Mac', 'Apple'),
('Linux', 'Comunidade'),
('Google Stadia', 'Google'),
('Amazon Luna', 'Amazon'),
('NVIDIA Shield', 'NVIDIA'),
('PS Vita', 'Sony'),
('3DS', 'Nintendo'),
('Xbox 360', 'Microsoft'),
('PS3', 'Sony'),
('Wii U', 'Nintendo');

-- INSERTS PARA PROMOÇÕES (20)
INSERT INTO Promocoes (id_jogo, desconto, data_inicio, data_fim, descricao) VALUES
(1, 20.00, '2023-11-20', '2023-11-30', 'Black Friday'),
(2, 15.00, '2023-12-01', '2023-12-15', 'Natal'),
(3, 10.00, '2023-10-10', '2023-10-20', 'Dia das Crianças'),
(4, 25.00, '2023-09-15', '2023-09-30', 'Aniversário do Jogo'),
(5, 30.00, '2023-11-01', '2023-11-15', 'Halloween'),
(6, 5.00, '2023-07-01', '2023-07-31', 'Férias de Julho'),
(7, 40.00, '2023-08-15', '2023-08-30', 'Liquidação de Verão'),
(8, 12.00, '2023-06-10', '2023-06-20', 'Dia dos Namorados'),
(9, 18.00, '2023-05-01', '2023-05-15', 'Dia do Trabalho'),
(10, 22.00, '2023-04-01', '2023-04-10', 'Páscoa'),
(11, 7.00, '2023-03-01', '2023-03-15', 'Carnaval'),
(12, 35.00, '2023-02-14', '2023-02-28', 'Dia dos Namorados EUA'),
(13, 8.00, '2023-01-10', '2023-01-20', 'Ano Novo'),
(14, 50.00, '2023-12-26', '2024-01-05', 'Pós-Natal'),
(15, 15.00, '2023-11-15', '2023-11-25', 'Semana do Consumidor'),
(16, 10.00, '2023-10-25', '2023-11-05', 'Dia das Bruxas'),
(17, 5.00, '2023-09-05', '2023-09-15', 'Volta às Aulas'),
(18, 20.00, '2023-08-01', '2023-08-10', 'Férias Escolares'),
(19, 25.00, '2023-07-15', '2023-07-25', 'Mid-Year Sale'),
(20, 30.00, '2023-06-01', '2023-06-10', 'Inverno');

-- ========================
-- INSERTS PARA USUÁRIOS (20)
-- ========================
INSERT INTO Usuarios (nome, email, tipo_usuario) VALUES
('Ana Souza', 'ana@exemplo.com', 'admin'),
('Carlos Lima', 'carlos@exemplo.com', 'avaliador'),
('Mariana Torres', 'mariana@exemplo.com', 'avaliador'),
('Lucas Alves', 'lucas@exemplo.com', 'dev'),
('Fernanda Dias', 'fernanda@exemplo.com', 'leitor'),
('Roberto Nunes', 'roberto@exemplo.com', 'avaliador'),
('Patricia Gomes', 'patricia@exemplo.com', 'dev'),
('Bruno Costa', 'bruno@exemplo.com', 'avaliador'),
('Juliana Melo', 'juliana@exemplo.com', 'leitor'),
('Eduardo Pires', 'eduardo@exemplo.com', 'dev'),
('Sofia Rocha', 'sofia@exemplo.com', 'avaliador'),
('Tiago Fernandes', 'tiago@exemplo.com', 'dev'),
('Camila Rezende', 'camila@exemplo.com', 'leitor'),
('Diego Carvalho', 'diego@exemplo.com', 'avaliador'),
('Renata Faria', 'renata@exemplo.com', 'admin'),
('Igor Monteiro', 'igor@exemplo.com', 'leitor'),
('Vanessa Luz', 'vanessa@exemplo.com', 'dev'),
('Felipe Ramos', 'felipe@exemplo.com', 'avaliador'),
('Aline Teixeira', 'aline@exemplo.com', 'leitor'),
('André Silva', 'andre@exemplo.com', 'avaliador');


-- INSERTS PARA AVALIACOES (20 aleatórias)
INSERT INTO Avaliacoes (id_jogo, id_usuario, nota, comentario, data_avaliacao) VALUES
(1, 2, 9, 'Excelente jogo!', '2023-05-01'),
(2, 3, 8, 'Muito bom!', '2023-05-02'),
(3, 4, 7, 'Divertido.', '2023-05-03'),
(4, 5, 6, 'Mediano.', '2023-05-04'),
(5, 6, 9, 'Viciante!', '2023-05-05'),
(6, 7, 10, 'Perfeito!', '2023-05-06'),
(7, 8, 5, 'Poderia ser melhor.', '2023-05-07'),
(8, 9, 4, 'Ruim.', '2023-05-08'),
(9, 10, 7, 'Legal.', '2023-05-09'),
(10, 11, 8, 'Gostei bastante.', '2023-05-10'),
(11, 12, 9, 'Jogo incrível.', '2023-05-11'),
(12, 13, 6, 'Mais ou menos.', '2023-05-12'),
(13, 14, 7, 'Bom passatempo.', '2023-05-13'),
(14, 15, 10, 'Obra prima!', '2023-05-14'),
(15, 16, 9, 'Muito bom.', '2023-05-15'),
(16, 17, 8, 'Recomendo!', '2023-05-16'),
(17, 18, 7, 'Entretenimento puro.', '2023-05-17'),
(18, 19, 6, 'Faltou algo.', '2023-05-18'),
(19, 20, 5, 'Esperava mais.', '2023-05-19'),
(20, 1, 9, 'Muito divertido.', '2023-05-20');




-- Jogos com Desenvolvedores
INSERT INTO Jogo_Desenvolvedor (id_jogo, id_desenvolvedor, funcao) VALUES
(1, 1, 'Produtor'),
(2, 2, 'Designer'),
(3, 3, 'Programador'),
(4, 4, 'Tester'),
(5, 5, 'Designer'),
(6, 6, 'Programador'),
(7, 7, 'Produtor'),
(8, 8, 'Programador'),
(9, 9, 'Designer'),
(10, 10, 'Produtor'),
(11, 11, 'Designer'),
(12, 12, 'Programador'),
(13, 13, 'Produtor'),
(14, 14, 'Designer'),
(15, 15, 'Programador'),
(16, 16, 'Produtor'),
(17, 17, 'Designer'),
(18, 18, 'Programador'),
(19, 19, 'Produtor'),
(20, 20, 'Designer');

-- Jogos com Plataformas
INSERT INTO Jogo_Plataforma (id_jogo, id_plataforma) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 1),
(3, 5),
(4, 2),
(5, 1),
(6, 3),
(7, 4),
(8, 5),
(9, 6),
(10, 7),
(11, 8),
(12, 9),
(13, 10),
(14, 11),
(15, 12),
(16, 13),
(17, 14),
(18, 15),
(19, 16),
(20, 17);

-- DELETE's
-- 1. Deletar promoção que acabou no passado e teve pouco desconto
DELETE FROM Promocoes
WHERE desconto < 10 AND data_fim < CURDATE();

-- 2. Remover um jogo antigo de baixo custo e pouco impacto
DELETE FROM Jogos
WHERE nome = 'Deep Ocean';

-- 3. Excluir um desenvolvedor que nunca associou nenhum jogo (dependendo das constraints e uso posterior)
DELETE FROM Desenvolvedores
WHERE nome = 'Moonlight Devs';

-- 4. Apagar plataforma obsoleta
DELETE FROM Plataformas
WHERE nome_plataforma = 'Google Stadia';

-- 5. Deletar avaliação com nota mínima (representando desinteresse total)
DELETE FROM Avaliacoes
WHERE nota = 1;

-- UPDATE's 
-- 1. Atualizar preço de um jogo após análise de mercado
UPDATE Jogos
SET preco = preco * 0.85
WHERE nome = 'Tower Defense Pro';

-- 2. Corrigir país de origem de um dev (coisas acontecem, né?)
UPDATE Desenvolvedores
SET pais_origem = 'Estados Unidos'
WHERE nome = 'FireStorm';

-- 3. Atualizar tipo de usuário para promover um leitor a avaliador
UPDATE Usuarios
SET tipo_usuario = 'avaliador'
WHERE nome = 'João Gamer';

-- 4. Aumentar desconto de uma promoção de Halloween
UPDATE Promocoes
SET desconto = 35.00
WHERE descricao = 'Halloween';

-- 5. Editar nome de plataforma para refletir nova marca
UPDATE Plataformas
SET nome_plataforma = 'Meta Quest'
WHERE nome_plataforma = 'VR Oculus';

-- SELECT's 
-- Lista dos jogos em promoção com desconto acima de 20%
SELECT j.nome AS NomeDoJogo, p.desconto, p.descricao
FROM Jogos j
JOIN Promocoes p ON j.id_jogo = p.id_jogo
WHERE p.desconto > 20;

-- Desenvolvedores brasileiros e seus e-mails
SELECT nome, email
FROM Desenvolvedores
WHERE pais_origem = 'Brasil';

-- Jogos lançados depois de 2021 com preço abaixo de R$ 40
SELECT nome, data_lancamento, preco
FROM Jogos
WHERE data_lancamento > '2021-01-01' AND preco < 40;