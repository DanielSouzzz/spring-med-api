CREATE TABLE IF NOT EXISTS enderecos
(
    enderecoId  SERIAL PRIMARY KEY,
    logradouro  VARCHAR(200) NOT NULL,
    numero      INT NOT NULL,
    complemento VARCHAR(255),
    bairro      VARCHAR(40) NOT NULL,
    cidade      VARCHAR(40) NOT NULL,
    uf          VARCHAR(2) NOT NULL,
    cep         VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS medicos
(
    id            SERIAL PRIMARY KEY,
    nome          VARCHAR(100) NOT NULL,
    email         VARCHAR(100),
    telefone      VARCHAR(20) NOT NULL,
    crm           VARCHAR(20) NOT NULL,
    especialidade VARCHAR(20) NOT NULL,
    enderecoId    INT NOT NULL,
    FOREIGN       KEY (enderecoId) REFERENCES enderecos(enderecoId) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS pacientes
(
    id         SERIAL PRIMARY KEY,
    nome       VARCHAR(100) NOT NULL,
    email      VARCHAR(100),
    telefone   VARCHAR(20) NOT NULL,
    cpf        VARCHAR(20) NOT NULL,
    enderecoId INT NOT NULL,
    FOREIGN    KEY (enderecoId) REFERENCES enderecos(enderecoId) ON DELETE SET NULL
);
