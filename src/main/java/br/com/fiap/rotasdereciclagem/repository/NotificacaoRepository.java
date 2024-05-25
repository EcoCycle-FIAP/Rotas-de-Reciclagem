package br.com.fiap.rotasdereciclagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.rotasdereciclagem.model.Notificacao;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

}
