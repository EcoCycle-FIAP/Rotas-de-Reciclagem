package br.com.fiap.rotasdereciclagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.rotasdereciclagem.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
