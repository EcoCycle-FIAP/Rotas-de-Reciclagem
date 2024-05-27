package br.com.fiap.rotasdereciclagem.service;

import java.util.Optional;

import br.com.fiap.rotasdereciclagem.dto.CaminhaoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.dto.NotificacaoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.dto.RotaCadastroDTO;
import br.com.fiap.rotasdereciclagem.exception.RotaNaoEncontradoException;
import br.com.fiap.rotasdereciclagem.model.Caminhao;
import org.springframework.beans.BeanUtils;
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
    private RotaRepository rotaRepository;

    public RotaExibicaoDTO gravar(RotaCadastroDTO rotaDTO){

        Rota rota = new Rota();
        BeanUtils.copyProperties(rotaDTO, rota);

        Rota rotaSalva = rotaRepository.save(rota);
        return new RotaExibicaoDTO(rotaSalva);
    }

    public Page<RotaExibicaoDTO> listarTodos(Pageable paginacao){
        return rotaRepository.findAll(paginacao).map(RotaExibicaoDTO::new);
    }

    public RotaExibicaoDTO buscarPorId(Long id) {
        Optional<Rota> RotaOptional = rotaRepository.findById(id);

        if (RotaOptional.isPresent()) {
            return new RotaExibicaoDTO(RotaOptional.get());
        } else {
            throw new RotaNaoEncontradoException("Não foi encontrada uma rota com esse id.");
        }
    }

    public RotaExibicaoDTO buscarPorPontosDeColeta(String pontosColeta) {
        Optional<Rota> RotaOptional = rotaRepository.buscarPorPontosDeColeta(pontosColeta);

        if (RotaOptional.isPresent()) {
            return new RotaExibicaoDTO(RotaOptional.get());
        } else {
            throw new RotaNaoEncontradoException("Não foi encontrada uma rota que passa por esses pontos de coleta.");
        }
    }

    public void deletarPorId(Long id) {
        if (!rotaRepository.existsById(id)) {
            throw new RotaNaoEncontradoException("Rota não encontrada.");
        }
        rotaRepository.deleteById(id);
    }

    public RotaExibicaoDTO atualizar(Rota rota) {
        Optional<Rota> rotaOptional =
                rotaRepository.findById(rota.getIdRota());

        if(rotaOptional.isPresent()){
            return new RotaExibicaoDTO(rotaRepository.save(rota));
        }else{
            throw new RotaNaoEncontradoException("Rota não encontrada.");
        }
    }
}
