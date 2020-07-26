CREATE TABLE USUARIO
(
    EMAIL   varchar NOT NULL PRIMARY KEY,
    SENHA   varchar NOT NULL,
    NOME    varchar NOT NULL,
    CONTATO varchar NOT NULL,
    ATIVO   boolean NOT NULL,
    EXTERNAL_CLIENT_ID varchar,
    EXTERNAL_CLIENT_TYPE varchar
);

CREATE TABLE PERMISSAO
(
    ID    integer NOT NULL PRIMARY KEY,
    VALOR varchar NOT NULL
);

CREATE TABLE USUARIO_PERMISSOES
(
    USUARIO_EMAIL varchar NOT NULL,
    PERMISSOES_ID varchar NOT NULL,
    CONSTRAINT usuario_fk FOREIGN KEY (USUARIO_EMAIL) REFERENCES USUARIO (EMAIL),
    PRIMARY KEY (USUARIO_EMAIL, PERMISSOES_ID)
);

INSERT INTO USUARIO(EMAIL, SENHA, NOME, CONTATO, ATIVO)
VALUES ('laaila@laaila.com.br', '1234567', 'Laaila Estacio Ribeirao', '34999999999', true);

INSERT INTO USUARIO_PERMISSOES(USUARIO_EMAIL, PERMISSOES_ID)
VALUES ('laaila@laaila.com.br', 'ADMIN')