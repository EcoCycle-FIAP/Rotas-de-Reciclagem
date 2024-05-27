package br.com.fiap.rotasdereciclagem.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_agendamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AGENDAMENTOS")
    @SequenceGenerator(name = "SEQ_AGENDAMENTOS", sequenceName = "SEQ_AGENDAMENTOS", allocationSize = 1)
    @Column(name = "id_agendamento")
    private Long idAgendamento;

    private Date data;

    @Column(name = "tipo_residuo")
    private String tipoResiduo;

    @Column(name = "quantidade_litros")
    private Long quantidaeLitros;

    @Column(name = "id_caminhao")
    private Long idCaminhao;
    @Column(name = "id_morador")
    private Long idMorador;
}