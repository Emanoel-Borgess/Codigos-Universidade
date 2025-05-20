-- =============================================
-- Criação do Banco de Dados
-- =============================================

-- Remove o banco de dados 'Exemplo' se ele já existir para evitar conflitos
DROP DATABASE IF EXISTS Exemplo;

-- Cria um novo banco de dados chamado 'Exemplo'
CREATE DATABASE Exemplo;

-- Seleciona o banco de dados 'Exemplo' para uso
USE Exemplo;

-- =============================================
-- 1. Tabelas Básicas (sem dependências de outras tabelas)
-- =============================================

-- Tabela que armazena os tipos de endereço (residencial, comercial, etc.)
CREATE TABLE TipoEnd (
    Cod_TipoEnd INT AUTO_INCREMENT NOT NULL,  -- Código auto-incrementado como chave primária
    Nome_TipoEnd VARCHAR(30) NOT NULL,       -- Nome do tipo de endereço
    CONSTRAINT PK_TipoEnd PRIMARY KEY(Cod_TipoEnd),  -- Define chave primária
    CONSTRAINT UQ_TipoEnd UNIQUE(Nome_TipoEnd)      -- Garante que nomes sejam únicos
) ENGINE=InnoDB;  -- Usa engine InnoDB para suporte a transações

-- Tabela de estados (UF)
CREATE TABLE Estado (
    Sigla_Est CHAR(2) NOT NULL,              -- Sigla de 2 caracteres (SP, RJ, etc.)
    Nome_Est VARCHAR(100) NOT NULL,          -- Nome completo do estado
    CONSTRAINT PK_Est PRIMARY KEY(Sigla_Est), -- Sigla como chave primária
    CONSTRAINT UQ_Est UNIQUE(Nome_Est)        -- Nome do estado deve ser único
) ENGINE=InnoDB;

-- Tabela de tipos de cliente (categorias: ouro, prata, etc.)
CREATE TABLE TipoCli (
    Cod_TipoCli INT AUTO_INCREMENT NOT NULL,  -- Código auto-incrementado
    Nome_TipoCli VARCHAR(100) NOT NULL,      -- Nome da categoria
    CONSTRAINT PK_TipoCli PRIMARY KEY(Cod_TipoCli),  -- Chave primária
    CONSTRAINT UQ_TipoCli UNIQUE(Nome_TipoCli)      -- Nome único
) ENGINE=InnoDB;

-- Tabela de status de pedidos (aberto, fechado, etc.)
CREATE TABLE StatusPedido (
    Cod_Sta SMALLINT AUTO_INCREMENT NOT NULL, -- Código pequeno para status
    Sta_Ped VARCHAR(100) NOT NULL,            -- Descrição do status
    CONSTRAINT PK_StatusPed PRIMARY KEY(Cod_Sta),  -- Chave primária
    CONSTRAINT UQ_StatusPed UNIQUE(Sta_Ped)        -- Status único
) ENGINE=InnoDB;

-- Tabela de tipos de produtos (eletrônicos, móveis, etc.)
CREATE TABLE TipoProd (
    Cod_TipoProd INT AUTO_INCREMENT NOT NULL,  -- Código auto-incrementado
    Nome_TipoProd VARCHAR(100) NOT NULL,      -- Nome do tipo
    CONSTRAINT PK_TipoProd PRIMARY KEY(Cod_TipoProd),  -- Chave primária
    CONSTRAINT UQ_TipoProd UNIQUE(Nome_TipoProd)      -- Nome único
) ENGINE=InnoDB;

-- =============================================
-- 2. Tabelas com dependências de nível 1 (dependem das básicas)
-- =============================================

-- Tabela de cidades (depende de Estado)
CREATE TABLE Cidade (
    Cod_Cid INT AUTO_INCREMENT NOT NULL,      -- Código auto-incrementado
    Sigla_Est CHAR(2) NOT NULL,              -- Sigla do estado (FK)
    Nome_Cid VARCHAR(100) NOT NULL,          -- Nome da cidade
    CONSTRAINT PK_Cid PRIMARY KEY(Cod_Cid),   -- Chave primária
    CONSTRAINT FK_Cid FOREIGN KEY(Sigla_Est) REFERENCES Estado(Sigla_Est),  -- FK para Estado
    CONSTRAINT UQ_Cid UNIQUE(Sigla_Est, Nome_Cid)  -- Cidade única por estado
) ENGINE=InnoDB;

-- Tabela de funcionários (não tem FKs, mas será referenciada depois)
CREATE TABLE Funcionario (
    Cod_Func INT AUTO_INCREMENT NOT NULL,    -- Código auto-incrementado
    Nome_Func VARCHAR(100) NOT NULL,         -- Nome do funcionário
    Data_CadFunc DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Data de cadastro automática
    Sexo_Func CHAR(1) NOT NULL DEFAULT 'F',  -- Sexo (F ou M, padrão F)
    Sal_Func DECIMAL(10,2) NOT NULL DEFAULT 200,  -- Salário com padrão 200
    End_Func VARCHAR(100) NOT NULL,          -- Endereço do funcionário
    CONSTRAINT PK_Func PRIMARY KEY(Cod_Func), -- Chave primária
    CONSTRAINT CH_Func2 CHECK(Sexo_Func IN ('F','M'),  -- Valida sexo
    CONSTRAINT CH_Func3 CHECK(Sal_Func >= 0)  -- Salário não pode ser negativo
) ENGINE=InnoDB;

-- =============================================
-- 3. Tabelas com dependências de nível 2
-- =============================================

-- Tabela de clientes (depende de TipoCli)
CREATE TABLE Cliente (
    Cod_Cli INT AUTO_INCREMENT NOT NULL,      -- Código auto-incrementado
    Cod_TipoCli INT NOT NULL,                -- Tipo do cliente (FK)
    Nome_Cli VARCHAR(100) NOT NULL,          -- Nome do cliente
    Data_CadCli DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Data de cadastro
    Renda_Cli DECIMAL(10,2) NOT NULL DEFAULT 0,  -- Renda com padrão 0
    Sexo_Cli CHAR(1) NOT NULL DEFAULT 'F',   -- Sexo (padrão F)
    CONSTRAINT PK_Cli PRIMARY KEY(Cod_Cli),   -- Chave primária
    CONSTRAINT FK_Cli FOREIGN KEY(Cod_TipoCli) REFERENCES TipoCli(Cod_TipoCli),  -- FK para TipoCli
    CONSTRAINT CH_Cli1 CHECK(Renda_Cli >= 0), -- Renda não negativa
    CONSTRAINT CH_Cli2 CHECK(Sexo_Cli IN('F','M'))  -- Valida sexo
) ENGINE=InnoDB;

-- Tabela de produtos (depende de TipoProd)
CREATE TABLE Produto (
    Cod_Prod INT AUTO_INCREMENT NOT NULL,    -- Código auto-incrementado
    Cod_TipoProd INT NOT NULL,              -- Tipo do produto (FK)
    Nome_Prod VARCHAR(100) NOT NULL,        -- Nome do produto
    Qtd_EstqProd INT NOT NULL DEFAULT 0,    -- Estoque (padrão 0)
    Val_UnitProd DECIMAL(10,2) NOT NULL,    -- Valor unitário
    Val_Total DECIMAL(10,2) AS (Qtd_EstqProd * Val_UnitProd),  -- Valor total calculado
    CONSTRAINT PK_Prod PRIMARY KEY(Cod_Prod),  -- Chave primária
    CONSTRAINT FK_Prod FOREIGN KEY(Cod_TipoProd) REFERENCES TipoProd(Cod_TipoProd),  -- FK para TipoProd
    CONSTRAINT UQ_Prod UNIQUE(Nome_Prod),   -- Nome do produto único
    CONSTRAINT CH_Prod1 CHECK(Qtd_EstqProd >= 0),  -- Estoque não negativo
    CONSTRAINT CH_Prod2 CHECK(Val_UnitProd > 0)   -- Valor unitário positivo
) ENGINE=InnoDB;

-- =============================================
-- 4. Tabelas com dependências de nível 3
-- =============================================

-- Tabela de cônjuges (depende de Cliente - relacionamento 1:1)
CREATE TABLE Conjuge (
    Cod_Cli INT NOT NULL,                   -- Mesmo código do cliente (1:1)
    Nome_Conj VARCHAR(30) NOT NULL,         -- Nome do cônjuge
    Renda_Conj DECIMAL(10,2) NOT NULL DEFAULT 0,  -- Renda do cônjuge
    Sexo_Conj CHAR(1) NOT NULL DEFAULT 'M', -- Sexo (padrão M)
    CONSTRAINT PK_Conj PRIMARY KEY(Cod_Cli),  -- Chave primária
    CONSTRAINT FK_Conj FOREIGN KEY(Cod_Cli) REFERENCES Cliente(Cod_Cli),  -- FK para Cliente
    CONSTRAINT CH_Conj1 CHECK(Renda_Conj >= 0),  -- Renda não negativa
    CONSTRAINT CH_Conj2 CHECK(Sexo_Conj IN ('F','M'))  -- Valida sexo
) ENGINE=InnoDB;

-- Tabela de endereços (depende de TipoEnd, Cidade e Cliente)
CREATE TABLE Endereco (
    Cod_End INT AUTO_INCREMENT NOT NULL,    -- Código auto-incrementado
    Cod_TipoEnd INT NOT NULL,              -- Tipo de endereço (FK)
    Cod_Cid INT NOT NULL,                  -- Cidade (FK)
    Cod_Cli INT NOT NULL,                  -- Cliente (FK)
    Nome_Rua VARCHAR(100) NOT NULL,        -- Nome da rua
    Nome_Bairro VARCHAR(100) NOT NULL,     -- Nome do bairro
    Compl_End VARCHAR(100) NULL,           -- Complemento (opcional)
    CONSTRAINT PK_End PRIMARY KEY(Cod_End),  -- Chave primária
    CONSTRAINT FK_End1 FOREIGN KEY(Cod_TipoEnd) REFERENCES TipoEnd(Cod_TipoEnd),  -- FK para TipoEnd
    CONSTRAINT FK_End2 FOREIGN KEY(Cod_Cid) REFERENCES Cidade(Cod_Cid),  -- FK para Cidade
    CONSTRAINT FK_End3 FOREIGN KEY(Cod_Cli) REFERENCES Cliente(Cod_Cli)  -- FK para Cliente
) ENGINE=InnoDB;

-- Tabela de créditos (depende de Cliente)
CREATE TABLE Credito (
    Num_Lanc INT AUTO_INCREMENT NOT NULL,   -- Número do lançamento
    Cod_Cli INT NOT NULL,                   -- Cliente (FK)
    Cred_Cli DECIMAL(10,2) NOT NULL,        -- Valor do crédito
    Data_CredCli DATETIME NOT NULL,         -- Data do crédito
    CONSTRAINT PK_Cred PRIMARY KEY(Num_Lanc),  -- Chave primária
    CONSTRAINT FK_Cred FOREIGN KEY(Cod_Cli) REFERENCES Cliente(Cod_Cli),  -- FK para Cliente
    CONSTRAINT CH_Cred CHECK(Cred_Cli > 0)  -- Crédito deve ser positivo
) ENGINE=InnoDB;

-- Tabela de telefones (depende de Cliente)
CREATE TABLE Fone (
    Num_Lanc INT AUTO_INCREMENT NOT NULL,   -- Número do lançamento
    Cod_Cli INT NOT NULL,                   -- Cliente (FK)
    Num_Fone VARCHAR(10) NOT NULL,          -- Número do telefone
    Num_DDD VARCHAR(5) NOT NULL DEFAULT '011',  -- DDD (padrão 011)
    CONSTRAINT PK_Fone PRIMARY KEY(Num_Lanc),  -- Chave primária
    CONSTRAINT FK_Fone FOREIGN KEY(Cod_Cli) REFERENCES Cliente(Cod_Cli)  -- FK para Cliente
) ENGINE=InnoDB;

-- Tabela de e-mails (depende de Cliente)
CREATE TABLE EMail (
    Num_Lanc INT AUTO_INCREMENT NOT NULL,   -- Número do lançamento
    Cod_Cli INT NOT NULL,                   -- Cliente (FK)
    EMail_Cli VARCHAR(255) NOT NULL,        -- Endereço de e-mail
    CONSTRAINT PK_Email PRIMARY KEY(Num_Lanc),  -- Chave primária
    CONSTRAINT FK_Emails FOREIGN KEY(Cod_Cli) REFERENCES Cliente(Cod_Cli)  -- FK para Cliente
) ENGINE=InnoDB;

-- Tabela de bônus (depende de Funcionario)
CREATE TABLE Bonus (
    Num_Lanc INT AUTO_INCREMENT NOT NULL,   -- Número do lançamento
    Cod_Func INT NOT NULL,                  -- Funcionário (FK)
    Data_Bonus DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Data do bônus
    Val_Bonus DECIMAL(10,2) NOT NULL,       -- Valor do bônus
    CONSTRAINT PK_Bonus PRIMARY KEY(Num_Lanc),  -- Chave primária
    CONSTRAINT FK_Bonus FOREIGN KEY(Cod_Func) REFERENCES Funcionario(Cod_Func),  -- FK para Funcionario
    CONSTRAINT CH_Bonus1 CHECK(Val_Bonus > 0)  -- Bônus deve ser positivo
) ENGINE=InnoDB;

-- Tabela de pontuação (depende de Funcionario)
CREATE TABLE Pontuacao (
    Num_Lanc INT AUTO_INCREMENT NOT NULL,   -- Número do lançamento
    Cod_Func INT NOT NULL,                  -- Funcionário (FK)
    Data_Pto DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Data da pontuação
    Pto_Func DECIMAL(4,2) NOT NULL,         -- Pontos
    CONSTRAINT PK_Pto PRIMARY KEY(Num_Lanc),  -- Chave primária
    CONSTRAINT FK_Pto FOREIGN KEY(Cod_Func) REFERENCES Funcionario(Cod_Func),  -- FK para Funcionario
    CONSTRAINT CH_Pto2 CHECK(Pto_Func > 0)   -- Pontos devem ser positivos
) ENGINE=InnoDB;

-- Tabela de histórico salarial (depende de Funcionario)
CREATE TABLE Historico (
    Num_Lanc INT AUTO_INCREMENT NOT NULL,   -- Número do lançamento
    Cod_Func INT NOT NULL,                  -- Funcionário (FK)
    Data_Hist DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Data do histórico
    Sal_Ant DECIMAL(10,2) NOT NULL,         -- Salário anterior
    Sal_Atual DECIMAL(10,2) NOT NULL,       -- Salário atual
    CONSTRAINT PK_Hist PRIMARY KEY(Num_Lanc),  -- Chave primária
    CONSTRAINT FK_Hist FOREIGN KEY(Cod_Func) REFERENCES Funcionario(Cod_Func),  -- FK para Funcionario
    CONSTRAINT CH_Hist2 CHECK(Sal_Ant >= 0),  -- Salário anterior não negativo
    CONSTRAINT CH_Hist3 CHECK(Sal_Atual > 0)  -- Salário atual positivo
) ENGINE=InnoDB;

-- Tabela de dependentes (depende de Funcionario)
CREATE TABLE Dependente (
    Cod_Dep INT AUTO_INCREMENT NOT NULL,    -- Código do dependente
    Cod_Func INT NOT NULL,                  -- Funcionário (FK)
    Nome_Dep VARCHAR(100) NOT NULL,         -- Nome do dependente
    Data_NascDep DATETIME NOT NULL,         -- Data de nascimento
    Sexo_Dep CHAR(1) NOT NULL DEFAULT 'F',  -- Sexo (padrão F)
    CONSTRAINT PK_Dep PRIMARY KEY(Cod_Dep),  -- Chave primária
    CONSTRAINT FK_Dep FOREIGN KEY(Cod_Func) REFERENCES Funcionario(Cod_Func),  -- FK para Funcionario
    CONSTRAINT CH_Dep CHECK(Sexo_Dep IN ('F','M'))  -- Valida sexo
) ENGINE=InnoDB;

-- Tabela de pedidos (depende de Cliente, Funcionario e StatusPedido)
CREATE TABLE Pedido (
    Num_Ped INT AUTO_INCREMENT NOT NULL,    -- Número do pedido
    Cod_Cli INT NOT NULL,                   -- Cliente (FK)
    Cod_Func INT NOT NULL,                  -- Funcionário (FK)
    Cod_Sta SMALLINT NOT NULL,              -- Status (FK)
    Data_Ped DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Data do pedido
    Val_Ped DECIMAL(10,2) NOT NULL DEFAULT 0,  -- Valor total (padrão 0)
    CONSTRAINT PK_Pedido PRIMARY KEY(Num_Ped),  -- Chave primária
    CONSTRAINT FK_Pedido1 FOREIGN KEY(Cod_Cli) REFERENCES Cliente(Cod_Cli),  -- FK para Cliente
    CONSTRAINT FK_Pedido2 FOREIGN KEY(Cod_Func) REFERENCES Funcionario(Cod_Func),  -- FK para Funcionario
    CONSTRAINT FK_Pedido3 FOREIGN KEY(Cod_Sta) REFERENCES StatusPedido(Cod_Sta),  -- FK para StatusPedido
    CONSTRAINT CH_Pedido2 CHECK(Val_Ped >= 0)  -- Valor não negativo
) ENGINE=InnoDB;

-- =============================================
-- 5. Tabelas com dependências de nível 4
-- =============================================

-- Tabela de parcelas (depende de Pedido)
CREATE TABLE Parcela (
    Num_Par SMALLINT NOT NULL,              -- Número da parcela
    Num_Ped INT NOT NULL,                   -- Pedido (FK)
    Data_Venc DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Data de vencimento
    Val_Venc DECIMAL(10,2) NOT NULL,        -- Valor de vencimento
    Data_Pgto DATETIME NULL,                -- Data de pagamento (opcional)
    Val_Pgto DECIMAL(10,2) GENERATED ALWAYS AS (  -- Valor de pagamento calculado
        CASE
            WHEN Data_Pgto < Data_Venc THEN Val_Venc * 0.9   -- 10% de desconto se antecipado
            WHEN Data_Pgto = Data_Venc THEN Val_Venc         -- Valor normal se no dia
            WHEN Data_Pgto > Data_Venc THEN Val_Venc * 1.1   -- 10% de acréscimo se atrasado
        END
    ) STORED,  -- Armazena o valor calculado
    CONSTRAINT PK_Parcela PRIMARY KEY(Num_Par, Num_Ped),  -- Chave composta
    CONSTRAINT FK_Parcela FOREIGN KEY(Num_Ped) REFERENCES Pedido(Num_Ped),  -- FK para Pedido
    CONSTRAINT CH_Parcela2 CHECK(Val_Venc >= 0)  -- Valor não negativo
) ENGINE=InnoDB;

-- Tabela de itens de pedido (depende de Pedido e Produto)
CREATE TABLE Itens (
    Num_Ped INT NOT NULL,                   -- Pedido (FK)
    Cod_Prod INT NOT NULL,                  -- Produto (FK)
    Qtd_Vend INT NOT NULL,                  -- Quantidade vendida
    Val_Vend DECIMAL(10,2) NOT NULL,        -- Valor de venda
    CONSTRAINT PK_Itens PRIMARY KEY(Num_Ped, Cod_Prod),  -- Chave composta
    CONSTRAINT FK_Itens1 FOREIGN KEY(Num_Ped) REFERENCES Pedido(Num_Ped),  -- FK para Pedido
    CONSTRAINT FK_Itens2 FOREIGN KEY(Cod_Prod) REFERENCES Produto(Cod_Prod),  -- FK para Produto
    CONSTRAINT CH_Itens1 CHECK(Qtd_Vend > 0),  -- Quantidade positiva
    CONSTRAINT CH_Itens2 CHECK(Val_Vend > 0)   -- Valor positivo
) ENGINE=InnoDB;

-- =============================================
-- Inserção de dados básicos para teste
-- =============================================

-- Tipos de endereço
INSERT INTO TipoEnd (Nome_TipoEnd) VALUES 
('Entrega'), ('Faturamento'), ('Correspondência'), ('Cobrança'), ('Residencial'), ('Comercial');

-- Estados brasileiros
INSERT INTO Estado (Sigla_Est, Nome_Est) VALUES 
('SP', 'São Paulo'), ('RJ', 'Rio de Janeiro'), ('MG', 'Minas Gerais');

-- Cidades por estado
INSERT INTO Cidade (Sigla_Est, Nome_Cid) VALUES 
('SP', 'São Paulo'), ('SP', 'Campinas'), ('RJ', 'Rio de Janeiro'), ('MG', 'Belo Horizonte');

-- Tipos de cliente (categorias)
INSERT INTO TipoCli (Nome_TipoCli) VALUES 
('Diamante'), ('Ouro'), ('Prata'), ('Bronze'), ('Cobre'), ('Zinco');

-- Funcionários de exemplo
INSERT INTO Funcionario (Nome_Func, Data_CadFunc, Sexo_Func, Sal_Func, End_Func) VALUES 
('Carlos Souza', NOW(), 'M', 2500.00, 'Rua A, 123'),
('Ana Paula', NOW(), 'F', 3000.00, 'Av. B, 456');

-- Clientes de exemplo
INSERT INTO Cliente (Cod_TipoCli, Nome_Cli, Data_CadCli, Renda_Cli, Sexo_Cli) VALUES 
(1, 'João Silva', NOW(), 5000.00, 'M'),
(2, 'Maria Oliveira', NOW(), 3000.00, 'F');

-- Status de pedidos
INSERT INTO StatusPedido (Sta_Ped) VALUES 
('Aberto'), ('Pendente'), ('Fechado'), ('Cancelado');

-- Tipos de produtos
INSERT INTO TipoProd (Nome_TipoProd) VALUES 
('Eletrônicos'), ('Móveis'), ('Roupas'), ('Alimentos');

-- Produtos de exemplo com estoque
INSERT INTO Produto (Cod_TipoProd, Nome_Prod, Qtd_EstqProd, Val_UnitProd) VALUES 
(1, 'Smartphone', 100, 1500.00),
(2, 'Sofá', 50, 2000.00),
(3, 'Camiseta', 200, 50.00);

-- =============================================
-- Criação dos Triggers
-- =============================================

-- Altera o delimitador para permitir criação de procedimentos/triggers
DELIMITER //

-- 1. Trigger para baixa em estoque quando item é adicionado a pedido
CREATE TRIGGER tr_baixa_estoque_pedido
AFTER INSERT ON Itens
FOR EACH ROW
BEGIN
    -- Reduz a quantidade em estoque do produto vendido
    UPDATE Produto
    SET Qtd_EstqProd = Qtd_EstqProd - NEW.Qtd_Vend
    WHERE Cod_Prod = NEW.Cod_Prod;
END//

-- 2. Trigger para devolução em estoque quando item é removido de pedido
CREATE TRIGGER tr_devolucao_estoque_pedido
AFTER DELETE ON Itens
FOR EACH ROW
BEGIN
    -- Aumenta a quantidade em estoque do produto devolvido
    UPDATE Produto
    SET Qtd_EstqProd = Qtd_EstqProd + OLD.Qtd_Vend
    WHERE Cod_Prod = OLD.Cod_Prod;
END//

-- 3. Trigger para atualização em estoque quando item é modificado no pedido
CREATE TRIGGER tr_atualiza_estoque_troca
AFTER UPDATE ON Itens
FOR EACH ROW
BEGIN
    -- Devolve a quantidade antiga ao estoque
    UPDATE Produto
    SET Qtd_EstqProd = Qtd_EstqProd + OLD.Qtd_Vend
    WHERE Cod_Prod = OLD.Cod_Prod;
    
    -- Baixa a quantidade nova do estoque
    UPDATE Produto
    SET Qtd_EstqProd = Qtd_EstqProd - NEW.Qtd_Vend
    WHERE Cod_Prod = NEW.Cod_Prod;
END//

-- 4. Triggers para proteger a tabela TipoEnd contra alterações
CREATE TRIGGER tr_protege_tipo_endereco_update
BEFORE UPDATE ON TipoEnd
FOR EACH ROW
BEGIN
    -- Impede atualizações na tabela TipoEnd
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Operação não permitida: a tabela TipoEnd não pode ser alterada.';
END//

CREATE TRIGGER tr_protege_tipo_endereco_delete
BEFORE DELETE ON TipoEnd
FOR EACH ROW
BEGIN
    -- Impede exclusões na tabela TipoEnd
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Operação não permitida: a tabela TipoEnd não pode ser excluída.';
END//

-- 5. Triggers para proteger a tabela Estado contra alterações
CREATE TRIGGER tr_protege_estado_update
BEFORE UPDATE ON Estado
FOR EACH ROW
BEGIN
    -- Impede atualizações na tabela Estado
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Operação não permitida: a tabela Estado não pode ser alterada.';
END//

CREATE TRIGGER tr_protege_estado_delete
BEFORE DELETE ON Estado
FOR EACH ROW
BEGIN
    -- Impede exclusões na tabela Estado
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Operação não permitida: a tabela Estado não pode ser excluída.';
END//

-- 6. Triggers para proteger a tabela TipoProd contra alterações
CREATE TRIGGER tr_protege_tipo_produto_update
BEFORE UPDATE ON TipoProd
FOR EACH ROW
BEGIN
    -- Impede atualizações na tabela TipoProd
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Operação não permitida: a tabela TipoProd não pode ser alterada.';
END//

CREATE TRIGGER tr_protege_tipo_produto_delete
BEFORE DELETE ON TipoProd
FOR EACH ROW
BEGIN
    -- Impede exclusões na tabela TipoProd
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Operação não permitida: a tabela TipoProd não pode ser excluída.';
END//

-- 7. Triggers para proteger a tabela TipoCli contra alterações
CREATE TRIGGER tr_protege_tipo_cliente_update
BEFORE UPDATE ON TipoCli
FOR EACH ROW
BEGIN
    -- Impede atualizações na tabela TipoCli
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Operação não permitida: a tabela TipoCli não pode ser alterada.';
END//

CREATE TRIGGER tr_protege_tipo_cliente_delete
BEFORE DELETE ON TipoCli
FOR EACH ROW
BEGIN
    -- Impede exclusões na tabela TipoCli
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Operação não permitida: a tabela TipoCli não pode ser excluída.';
END//

-- Restaura o delimitador padrão
DELIMITER ;

-- =============================================
-- Teste dos Triggers
-- =============================================

-- Criar um pedido e itens para testar os triggers de estoque
INSERT INTO Pedido (Cod_Cli, Cod_Func, Cod_Sta, Data_Ped, Val_Ped) VALUES 
(1, 1, 1, NOW(), 1500.00);

-- Adiciona itens ao pedido (deve acionar o trigger de baixa de estoque)
INSERT INTO Itens (Num_Ped, Cod_Prod, Qtd_Vend, Val_Vend) VALUES 
(1, 1, 2, 1500.00); -- Deve reduzir estoque do produto 1 em 2 unidades

-- Verifica o estoque após inserção
SELECT Cod_Prod, Nome_Prod, Qtd_EstqProd FROM Produto WHERE Cod_Prod = 1;

-- Testa o trigger de atualização (ajusta quantidade)
UPDATE Itens SET Qtd_Vend = 3 WHERE Num_Ped = 1 AND Cod_Prod = 1; -- Deve ajustar estoque

-- Verifica o estoque após atualização
SELECT Cod_Prod, Nome_Prod, Qtd_EstqProd FROM Produto WHERE Cod_Prod = 1;

-- Testa o trigger de deleção (devolve estoque)
DELETE FROM Itens WHERE Num_Ped = 1 AND Cod_Prod = 1; -- Deve devolver estoque

-- Verifica o estoque após deleção
SELECT Cod_Prod, Nome_Prod, Qtd_EstqProd FROM Produto WHERE Cod_Prod = 1;

-- Testa os triggers de proteção (devem gerar erros)
UPDATE TipoEnd SET Nome_TipoEnd = 'Teste' WHERE Cod_TipoEnd = 1;
DELETE FROM TipoEnd WHERE Cod_TipoEnd = 1;

UPDATE Estado SET Nome_Est = 'Teste' WHERE Sigla_Est = 'SP';
DELETE FROM Estado WHERE Sigla_Est = 'SP';

UPDATE TipoProd SET Nome_TipoProd = 'Teste' WHERE Cod_TipoProd = 1;
DELETE FROM TipoProd WHERE Cod_TipoProd = 1;

UPDATE TipoCli SET Nome_TipoCli = 'Teste' WHERE Cod_TipoCli = 1;
DELETE FROM TipoCli WHERE Cod_TipoCli = 1;