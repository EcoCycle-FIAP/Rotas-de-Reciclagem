package br.com.fiap.rotasdereciclagem.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_notificacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTIFICACOES")
    @SequenceGenerator(name = "SEQ_NOTIFICACOES", sequenceName = "SEQ_NOTIFICACOES", allocationSize = 1)
    @Column(name = "id_notificacao")
    private Long idNotificacao;

    private String mensagem;

    @Column(name = "data_envio")
    private Date dataEnvio;

    private String status;

    @Column(name = "id_morador")
    private Long idMorador;

}