package br.com.fiap.rotasdereciclagem.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tbl_moradores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Morador implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_MORADORES")
    @SequenceGenerator(
            name = "SEQ_MORADORES",
            sequenceName = "SEQ_MORADORES",
            allocationSize = 1)
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
    private String senha;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(this.role);
        if (this.role == Roles.ADMIN) {
            System.out.println("admin");
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            System.out.println("user");
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}