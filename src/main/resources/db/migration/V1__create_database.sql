CREATE TABLE enderecos
(
    endereco_id SERIAL PRIMARY KEY,
    logradouro  VARCHAR(200) NOT NULL,
    numero      INT          NOT NULL,
    complemento VARCHAR(255),
    bairro      VARCHAR(40)  NOT NULL,
    cidade      VARCHAR(40)  NOT NULL,
    uf          CHAR(2)      NOT NULL,
    cep         CHAR(8)      NOT NULL
);
CREATE TABLE medicos
(
    id            SERIAL PRIMARY KEY,
    nome          VARCHAR(100) NOT NULL,
    email         VARCHAR(100),
    telefone      VARCHAR(20)  NOT NULL,
    crm           VARCHAR(20)  NOT NULL,
    especialidade VARCHAR(20)  NOT NULL,
    endereco_id   INT,
    FOREIGN KEY (endereco_id) REFERENCES enderecos (endereco_id) ON DELETE SET NULL
);
CREATE TABLE pacientes
(
    id          SERIAL PRIMARY KEY,
    nome        VARCHAR(100) NOT NULL,
    email       VARCHAR(100),
    telefone    VARCHAR(20)  NOT NULL,
    cpf         VARCHAR(11)  NOT NULL,
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES enderecos (endereco_id) ON DELETE SET NULL
);