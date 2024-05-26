package br.com.fiap.rotasdereciclagem.service;

import java.util.Optional;

import br.com.fiap.rotasdereciclagem.dto.MoradorExibicaoDTO;
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
    private NotificacaoRepository notificacaoRepository;

    public NotificacaoExibicaoDTO gravar(Notificacao notificacao){
        return new NotificacaoExibicaoDTO((notificacaoRepository.save(notificacao)));
    }

    public Page<NotificacaoExibicaoDTO> listarTodos(Pageable paginacao) {
        return notificacaoRepository.findAll(paginacao).map(NotificacaoExibicaoDTO::new);
    }

    public NotificacaoExibicaoDTO buscarPorId(Long id) {
        Optional<Notificacao> NotificacaoOptional = notificacaoRepository.findById(id);

        if (NotificacaoOptional.isPresent()) {
            return new NotificacaoExibicaoDTO(NotificacaoOptional.get());
        } else {
            throw new RuntimeException("Não foi encontrada uma notificação com esse id.");
        }
    }

    public void deletarPorId(Long id) {
        if (!notificacaoRepository.existsById(id)) {
            throw new RuntimeException("Notificação não encontrada.");
        }
        notificacaoRepository.deleteById(id);
    }

    public NotificacaoExibicaoDTO atualizar(Notificacao notificacao) {
        Optional<Notificacao> notificaoOptional =
                notificacaoRepository.findById(notificacao.getIdNotificacao());

        if(notificaoOptional.isPresent()){
            return new NotificacaoExibicaoDTO(notificacaoRepository.save(notificacao));
        }else{
            throw new RuntimeException("Notificação não encontrada.");
        }
    }
}
