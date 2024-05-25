package br.com.fiap.rotasdereciclagem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.rotasdereciclagem.dto.RotaExibicaoDTO;
import br.com.fiap.rotasdereciclagem.model.Rota;
import br.com.fiap.rotasdereciclagem.repository.RotaRepository;

@Service
public class RotaService {

    @Autowired
    private RotaRepository RotaRepository;

    public Page<RotaExibicaoDTO> listarTodos(Pageable paginacao){
        return RotaRepository.findAll(paginacao).map(RotaExibicaoDTO::new);
    }

    public RotaExibicaoDTO buscarPorId(Long id) {
        Optional<Rota> RotaOptional = RotaRepository.findById(id);

        if (RotaOptional.isPresent()) {
            return new RotaExibicaoDTO(RotaOptional.get());
        } else {
            throw new RuntimeException("Não foi encontrada uma rota com esse id.");
        }
    }

    public RotaExibicaoDTO buscarPorPontosDeColeta(String pontosColeta) {
        Optional<Rota> RotaOptional = RotaRepository.buscarPorPontosDeColeta(pontosColeta);

        if (RotaOptional.isPresent()) {
            return new RotaExibicaoDTO(RotaOptional.get());
        } else {
            throw new RuntimeException("Não foi encontrada uma rota que passa por esses pontos de coleta.");
        }
    }

}
