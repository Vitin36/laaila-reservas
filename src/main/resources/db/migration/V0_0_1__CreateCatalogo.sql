CREATE TABLE CATALOGO(
    ID        integer       NOT NULL PRIMARY KEY,
    NOME      varchar   NOT NULL,
    STATUS    varchar   NOT NULL,
    DESCRICAO varchar
);

CREATE SEQUENCE catalogo_seq START 1;