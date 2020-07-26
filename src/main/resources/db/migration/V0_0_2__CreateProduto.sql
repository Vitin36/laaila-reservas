CREATE TABLE PRODUTO
(
    ID          integer NOT NULL PRIMARY KEY,
    NOME        varchar NOT NULL,
    VALOR       decimal NOT NULL,
    DESCRICAO   varchar NOT NULL,
    CATALOGO_ID int     NOT NULL,
    ATIVO       boolean NOT NULL,
    CONSTRAINT catalogo_fk FOREIGN KEY (CATALOGO_ID) REFERENCES CATALOGO (ID)
);


CREATE SEQUENCE produto_seq START 1;