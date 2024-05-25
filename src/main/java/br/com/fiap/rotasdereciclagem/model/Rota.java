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


}