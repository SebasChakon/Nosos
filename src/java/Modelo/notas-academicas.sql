CREATE DATABASE IF NOT EXISTS notas_academicas
    CHARACTER SET utf8mb4;

USE notas_academicas;

CREATE TABLE estudiantes (
    id                    INT AUTO_INCREMENT PRIMARY KEY,
    nombre                VARCHAR(150)   NOT NULL,
    nota1                 DECIMAL(3,1)   NOT NULL,
    nota2                 DECIMAL(3,1)   NOT NULL,
    nota3                 DECIMAL(3,1)   NOT NULL,
    nota4                 DECIMAL(3,1)   NOT NULL,
    promedio              DECIMAL(3,1)   NOT NULL,
    estado                VARCHAR(20)    NOT NULL,
    resultado_cualitativo VARCHAR(50)    NOT NULL,

    CONSTRAINT chk_nota1 CHECK (nota1 BETWEEN 0.0 AND 5.0),
    CONSTRAINT chk_nota2 CHECK (nota2 BETWEEN 0.0 AND 5.0),
    CONSTRAINT chk_nota3 CHECK (nota3 BETWEEN 0.0 AND 5.0),
    CONSTRAINT chk_nota4 CHECK (nota4 BETWEEN 0.0 AND 5.0)
);