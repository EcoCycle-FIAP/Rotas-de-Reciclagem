package br.com.fiap.rotasdereciclagem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.rotasdereciclagem.dto.MoradorExibicaoDTO;
import br.com.fiap.rotasdereciclagem.model.Morador;
import br.com.fiap.rotasdereciclagem.repository.MoradorRepository;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository MoradorRepository;

    public Page<MoradorExibicaoDTO> listarTodos(Pageable paginacao){
        return MoradorRepository.findAll(paginacao).map(MoradorExibicaoDTO::new);
    }

    public MoradorExibicaoDTO buscarPorId(Long id) {
        Optional<Morador> MoradorOptional = MoradorRepository.findById(id);

        if (MoradorOptional.isPresent()) {
            return new MoradorExibicaoDTO(MoradorOptional.get());
        } else {
            throw new RuntimeException("Não foi encontrado um morador com esse id.");
        }
    }

    public MoradorExibicaoDTO buscarPorNome(String nome) {
        Optional<Morador> MoradorOptional = MoradorRepository.buscarPorNome(nome);

        if (MoradorOptional.isPresent()) {
            return new MoradorExibicaoDTO(MoradorOptional.get());
        } else {
            throw new RuntimeException("Não foi encontrado um caminhão com esse nome.");
        }
    }

    public void deletarPorId(Long id) {
        if (!MoradorRepository.existsById(id)) {
            throw new RuntimeException("Morador não encontrado.");
        }
        MoradorRepository.deleteById(id);
    }
}
