-- DDL - Desafio Técnico Analista Java PL
CREATE DATABASE IF NOT EXISTS veiculo_api;
USE veiculo_api;

-- 1. Tabela de Clientes (conforme entidade Cliente)
CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefone VARCHAR(15) NOT NULL,
    data_cadastro DATETIME NOT NULL
) ENGINE=InnoDB;

-- 2. Tabela de Usuários (conforme entidade Usuario)
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

-- 3. Tabela de Veículos (conforme entidade Veiculo)
CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(7) NOT NULL UNIQUE,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    ano INT NOT NULL,
    cliente_id BIGINT NOT NULL,
    CONSTRAINT fk_veiculo_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id)
) ENGINE=InnoDB;


-- Usuário: admin / Senha: 123456
INSERT INTO usuarios (username, password) VALUES ('admin', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc2ODE5NTM0NiwiZXhwIjoxNzY4MTk4OTQ2fQ.wX8M-7ejU4SGcQGCMr4nh-QCHzpxqUPS4Q9p2E6nfxs'
