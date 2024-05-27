package br.com.fiap.rotasdereciclagem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.rotasdereciclagem.model.Morador;
import org.springframework.security.core.userdetails.UserDetails;

public interface MoradorRepository extends JpaRepository<Morador, Long> {

    @Query("SELECT m FROM Morador m WHERE m.nome = :nome")
    Optional<Morador> buscarPorNome(@Param("nome") String nome);

    UserDetails findByEmail(String email);

}
