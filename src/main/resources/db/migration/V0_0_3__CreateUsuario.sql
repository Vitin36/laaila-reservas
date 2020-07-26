CREATE TABLE USUARIO
(
    ID                   integer NOT NULL PRIMARY KEY,
    EMAIL                varchar NOT NULL UNIQUE,
    SENHA                varchar NOT NULL,
    NOME                 varchar NOT NULL,
    ATIVO                boolean NOT NULL,
    PERMISSAO            varchar NOT NULL,
    CONTATO              varchar,
    EXTERNAL_CLIENT_ID   varchar,
    EXTERNAL_CLIENT_TYPE varchar
);

CREATE SEQUENCE usuario_seq START 3;

INSERT INTO USUARIO(ID, EMAIL, SENHA, NOME, PERMISSAO, CONTATO, ATIVO)
VALUES (1, 'laaila@laaila.com.br', '1234567', 'Laaila Estacio Ribeirao', 'ADMIN', '34999999999', true),
       (2, 'usuario@usuario.com.br', '1234567', 'Laaila Estacio Ribeirao', 'CLIENTE', '34999999999', true);
