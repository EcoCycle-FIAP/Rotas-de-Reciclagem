package br.com.fiap.rotasdereciclagem.repository;

import br.com.fiap.rotasdereciclagem.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

    @Query("SELECT c FROM Caminhao c WHERE c.placa = :placa")
    Optional<Caminhao> buscarPorPlaca(@Param("placa") String placa);

}
