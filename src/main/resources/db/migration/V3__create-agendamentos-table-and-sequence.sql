CREATE SEQUENCE SEQ_AGENDAMENTOS
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE AGENDAMENTOS (
    id_agendamento INTEGER DEFAULT SEQ_AGENDAMENTOS.NEXTVAL NOT NULL PRIMARY KEY,
    data DATE NOT NULL,
    tipo_residuo VARCHAR2(100),
    quantidade_litros INTEGER NOT NULL,
    status VARCHAR2(60) NOT NULL,
    id_caminhao INTEGER NOT NULL,
    id_morador INTEGER NOT NULL,
    CONSTRAINT fk_agendamento_caminhao FOREIGN KEY (id_caminhao) REFERENCES TBL_CAMINHOES (id_caminhao),
    CONSTRAINT fk_agendamento_morador FOREIGN KEY (id_morador) REFERENCES TBL_MORADORES (id_morador)
);