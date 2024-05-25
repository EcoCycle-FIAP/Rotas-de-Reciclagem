package br.com.fiap.rotasdereciclagem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_caminhoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Caminhao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CAMINHOES")
    @SequenceGenerator(name = "SEQ_CAMINHOES", sequenceName = "SEQ_CAMINHOES", allocationSize = 1)
    @Column(name = "id_caminhao")
    private Long idCaminhao;

    private String motorista;
    private String modelo;
    private String placa;

    @Column(name = "capacidade_litros")
    private Long capacidadeLitros;

}