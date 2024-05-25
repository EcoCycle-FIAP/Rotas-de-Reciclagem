package br.com.fiap.rotasdereciclagem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.rotasdereciclagem.dto.AgendamentoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.model.Agendamento;
import br.com.fiap.rotasdereciclagem.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository AgendamentoRepository;

    public Page<AgendamentoExibicaoDTO> listarTodos(Pageable paginacao){
        return AgendamentoRepository.findAll(paginacao).map(AgendamentoExibicaoDTO::new);
    }

    public AgendamentoExibicaoDTO buscarPorId(Long id) {
        Optional<Agendamento> AgendamentoOptional = AgendamentoRepository.findById(id);

        if (AgendamentoOptional.isPresent()) {
            return new AgendamentoExibicaoDTO(AgendamentoOptional.get());
        } else {
            throw new RuntimeException("Não foi encontrado um agendamento com esse id.");
        }
    }

    public void deletarPorId(Long id) {
        if (!AgendamentoRepository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado.");
        }
        AgendamentoRepository.deleteById(id);
    }
}
