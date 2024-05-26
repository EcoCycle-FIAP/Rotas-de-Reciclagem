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

    public Long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipoResiduo() {
        return tipoResiduo;
    }

    public void setTipoResiduo(String tipoResiduo) {
        this.tipoResiduo = tipoResiduo;
    }

    public Long getQuantidaeLitros() {
        return quantidaeLitros;
    }

    public void setQuantidaeLitros(Long quantidaeLitros) {
        this.quantidaeLitros = quantidaeLitros;
    }

    public Long getIdCaminhao() {
        return idCaminhao;
    }

    public void setIdCaminhao(Long idCaminhao) {
        this.idCaminhao = idCaminhao;
    }

    public Long getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(Long idMorador) {
        this.idMorador = idMorador;
    }
}