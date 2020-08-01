CREATE TABLE USUARIO
(
    ID                   uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
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
VALUES ('509cba38-ffc1-49e3-b3d7-53b8e503db51', 'laaila@laaila.com.br', '1234567', 'Laaila Estacio Ribeirao', 'ADMIN',
        '34999999999', true),
       ('ebd48a41-61f6-4542-90eb-ff33633d3d07', 'usuario@usuario.com.br', '1234567', 'Laaila Estacio Ribeirao',
        'CLIENTE', '34999999999', true);
