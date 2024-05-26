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

    public Long getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(Long idMorador) {
        this.idMorador = idMorador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(Long endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}