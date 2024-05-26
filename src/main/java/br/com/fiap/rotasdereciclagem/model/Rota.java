package br.com.fiap.rotasdereciclagem.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_rotas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROTAS")
    @SequenceGenerator(name = "SEQ_ROTAS", sequenceName = "SEQ_ROTAS", allocationSize = 1)
    @Column(name = "id_rota")
    private Long idRota;

    @Column(name = "pontos_coleta")
    private String pontosDeColeta;

    @Column(name = "horario_inicial")
    private Date horarioInicial;
    @Column(name = "horario_final")
    private Date horarioFinal;

    @Column(name = "id_caminhao")
    private Long idCaminhao;

    public Long getIdRota() {
        return idRota;
    }

    public void setIdRota(Long idRota) {
        this.idRota = idRota;
    }

    public String getPontosDeColeta() {
        return pontosDeColeta;
    }

    public void setPontosDeColeta(String pontosDeColeta) {
        this.pontosDeColeta = pontosDeColeta;
    }

    public Date getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(Date horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public Date getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Date horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public Long getIdCaminhao() {
        return idCaminhao;
    }

    public void setIdCaminhao(Long idCaminhao) {
        this.idCaminhao = idCaminhao;
    }
}