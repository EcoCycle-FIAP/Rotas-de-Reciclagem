CREATE SEQUENCE SEQ_ROTAS
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE ROTAS (
    id_rota INTEGER DEFAULT SEQ_ROTAS.NEXTVAL NOT NULL PRIMARY KEY,
    pontos_coleta VARCHAR2(1200) NOT NULL,
    horario_inicial DATE NOT NULL,
    horario_final DATE NOT NULL,
    id_caminhao INTEGER NOT NULL,
    CONSTRAINT fk_rota_caminhao FOREIGN KEY (id_caminhao) REFERENCES TBL_CAMINHOES (id_caminhao)
);