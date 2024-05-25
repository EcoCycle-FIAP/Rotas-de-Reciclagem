package br.com.fiap.rotasdereciclagem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.rotasdereciclagem.model.Rota;

public interface RotaRepository extends JpaRepository<Rota, Long> {

    @Query("SELECT r FROM Rota r WHERE r.pontosDeColeta = :pontosDeColeta")
    Optional<Rota> buscarPorPontosDeColeta(@Param("pontosDeColeta") String pontosDeColeta);

}
