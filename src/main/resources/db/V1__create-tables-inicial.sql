CREATE TABLE Curso (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL
);

CREATE TABLE Usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL
);

CREATE TABLE Perfil (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Topico (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,
    autor_id INT NOT NULL REFERENCES Usuario(id),
    curso_id INT NOT NULL REFERENCES Curso(id)
);

CREATE TABLE Resposta (
    id SERIAL PRIMARY KEY,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    autor_id INT NOT NULL REFERENCES Usuario(id),
    topico_id INT NOT NULL REFERENCES Topico(id),
    solucao BOOLEAN NOT NULL
);

CREATE TABLE Usuario_Perfil (
    usuario_id INT NOT NULL REFERENCES Usuario(id),
    perfil_id INT NOT NULL REFERENCES Perfil(id),
    PRIMARY KEY (usuario_id, perfil_id)
);
