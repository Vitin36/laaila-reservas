CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE CATALOGO(
    ID        uuid DEFAULT uuid_generate_v4 () PRIMARY KEY ,
    NOME      varchar   NOT NULL,
    ATIVO     boolean NOT NULL,
    DESCRICAO varchar
);

CREATE SEQUENCE catalogo_seq START 1;