CREATE TABLE CLIENTE (
    idcliente   SERIAL          PRIMARY KEY,
    nome        VARCHAR(150)    NOT NULL,
    cpf         VARCHAR(11)     NOT NULL,
    email       VARCHAR(50)     NOT NULL,
    telefone    VARCHAR(14)     NOT NULL,
    observacoes VARCHAR(500)    NOT NULL
);