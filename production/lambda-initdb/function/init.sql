CREATE DATABASE IF NOT EXISTS dbtechchallange;

CREATE TABLE IF NOT EXISTS dbtechchallange.customer (
    `cpf` VARCHAR(255) PRIMARY KEY,
    `name` VARCHAR(255),
    `email` VARCHAR(255)
);