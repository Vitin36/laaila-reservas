CREATE TABLE CARRINHO
(
    ID         integer NOT NULL PRIMARY KEY,
    USUARIO_ID integer NOT NULL,
    CONSTRAINT usuario_fk FOREIGN KEY (USUARIO_ID) REFERENCES USUARIO (ID)
);

CREATE SEQUENCE carrinho_seq START 1;

CREATE TABLE PRODUTO_QUANTIDADE
(

    ID          integer NOT NULL PRIMARY KEY,
    QUANTIDADE  integer NOT NULL,
    CARRINHO_ID integer NOT NULL,
    PRODUTO_ID  integer NOT NULL,
    constraint carrinho_pk FOREIGN KEY (CARRINHO_ID) REFERENCES CARRINHO (ID),
    constraint produto_fk FOREIGN KEY (PRODUTO_ID) REFERENCES PRODUTO (ID),
    constraint unique_ck UNIQUE (ID, CARRINHO_ID, PRODUTO_ID)
);

CREATE SEQUENCE produto_quantidade_seq START 1;