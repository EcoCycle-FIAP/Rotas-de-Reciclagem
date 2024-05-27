package br.com.fiap.rotasdereciclagem.service;

import java.util.Optional;

import br.com.fiap.rotasdereciclagem.dto.AgendamentoCadastroDTO;
import br.com.fiap.rotasdereciclagem.dto.CaminhaoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.exception.AgendamentoNaoEncontradoException;
import br.com.fiap.rotasdereciclagem.model.Caminhao;
import org.springframework.beans.BeanUtils;
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
    private AgendamentoRepository agendamentoRepository;

    public AgendamentoExibicaoDTO gravar(AgendamentoCadastroDTO agendamentoDTO){

        Agendamento agendamento = new Agendamento();
        BeanUtils.copyProperties(agendamentoDTO, agendamento);

        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
        return new AgendamentoExibicaoDTO(agendamentoSalvo);
    }

    public Page<AgendamentoExibicaoDTO> listarTodos(Pageable paginacao){
        return agendamentoRepository.findAll(paginacao).map(AgendamentoExibicaoDTO::new);
    }

    public AgendamentoExibicaoDTO buscarPorId(Long id) {
        Optional<Agendamento> AgendamentoOptional = agendamentoRepository.findById(id);

        if (AgendamentoOptional.isPresent()) {
            return new AgendamentoExibicaoDTO(AgendamentoOptional.get());
        } else {
            throw new AgendamentoNaoEncontradoException("Não foi encontrado um agendamento com esse id.");
        }
    }

    public void deletarPorId(Long id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new AgendamentoNaoEncontradoException("Agendamento não encontrado.");
        }
        agendamentoRepository.deleteById(id);
    }

    public AgendamentoExibicaoDTO atualizar(Agendamento agendamento) {
        Optional<Agendamento> agendamentoOptional =
                agendamentoRepository.findById(agendamento.getIdAgendamento());

        if(agendamentoOptional.isPresent()){
            return new AgendamentoExibicaoDTO(agendamentoRepository.save(agendamento));
        }else{
            throw new AgendamentoNaoEncontradoException("Agendamento não encontrado");
        }
    }
}
