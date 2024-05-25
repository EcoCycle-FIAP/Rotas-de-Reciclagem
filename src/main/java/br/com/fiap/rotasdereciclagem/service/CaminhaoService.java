package br.com.fiap.rotasdereciclagem.service;

import br.com.fiap.rotasdereciclagem.dto.CaminhaoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.model.Caminhao;
import br.com.fiap.rotasdereciclagem.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public Page<CaminhaoExibicaoDTO> listarTodos(Pageable paginacao){
        return caminhaoRepository.findAll(paginacao).map(CaminhaoExibicaoDTO::new);
    }

    public CaminhaoExibicaoDTO buscarPorId(Long id) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);

        if (caminhaoOptional.isPresent()) {
            return new CaminhaoExibicaoDTO(caminhaoOptional.get());
        } else {
            throw new RuntimeException("Não foi encontrado um caminhão com esse id.");
        }
    }

    public CaminhaoExibicaoDTO buscarPorPlaca(String placa) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.buscarPorPlaca(placa);

        if (caminhaoOptional.isPresent()) {
            return new CaminhaoExibicaoDTO(caminhaoOptional.get());
        } else {
            throw new RuntimeException("Não foi encontrado um caminhão com essa placa.");
        }
    }

    public void deletarPorId(Long id) {
        if (!caminhaoRepository.existsById(id)) {
            throw new RuntimeException("Caminhão não encontrado.");
        }
        caminhaoRepository.deleteById(id);
    }
}