package br.com.fiap.rotasdereciclagem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.rotasdereciclagem.dto.NotificacaoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.model.Notificacao;
import br.com.fiap.rotasdereciclagem.repository.NotificacaoRepository;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository NotificacaoRepository;

    public Page<NotificacaoExibicaoDTO> listarTodos(Pageable paginacao) {
        return NotificacaoRepository.findAll(paginacao).map(NotificacaoExibicaoDTO::new);
    }

    public NotificacaoExibicaoDTO buscarPorId(Long id) {
        Optional<Notificacao> NotificacaoOptional = NotificacaoRepository.findById(id);

        if (NotificacaoOptional.isPresent()) {
            return new NotificacaoExibicaoDTO(NotificacaoOptional.get());
        } else {
            throw new RuntimeException("Não foi encontrada uma notificação com esse id.");
        }
    }

    public void deletarPorId(Long id) {
        if (!NotificacaoRepository.existsById(id)) {
            throw new RuntimeException("Notificação não encontrada.");
        }
        NotificacaoRepository.deleteById(id);
    }
}
