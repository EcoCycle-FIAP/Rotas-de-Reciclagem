package br.com.fiap.rotasdereciclagem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_moradores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MORADORES")
    @SequenceGenerator(name = "SEQ_MORADORES", sequenceName = "SEQ_MORADORES", allocationSize = 1)
    @Column(name = "id_morador")
    private Long idMorador;

    private String nome;

    private String endereco;
    @Column(name = "end_numero")
    private Long endNumero;
    @Column(name = "end_complemento")
    private String endComplemento;
    @Column(name = "end_bairro")
    private String endBairro;

    private String email;
    private String telefone;

}