package br.com.fiap.rotasdereciclagem.service;

import java.util.Optional;

import br.com.fiap.rotasdereciclagem.dto.AgendamentoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.dto.MoradorCadastroDTO;
import br.com.fiap.rotasdereciclagem.exception.MoradorNaoEncontradoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.rotasdereciclagem.dto.MoradorExibicaoDTO;
import br.com.fiap.rotasdereciclagem.model.Morador;
import br.com.fiap.rotasdereciclagem.repository.MoradorRepository;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    public MoradorExibicaoDTO gravar(MoradorCadastroDTO moradorDTO){

        String senhaCriptografada = new BCryptPasswordEncoder().encode(moradorDTO.senha());

        Morador morador = new Morador();
        BeanUtils.copyProperties(moradorDTO, morador);
        morador.setSenha(senhaCriptografada);

        Morador moradorSalvo = moradorRepository.save(morador);

        return new MoradorExibicaoDTO(moradorSalvo);

    }

    public Page<MoradorExibicaoDTO> listarTodos(Pageable paginacao){
        return moradorRepository.findAll(paginacao).map(MoradorExibicaoDTO::new);
    }

    public MoradorExibicaoDTO buscarPorId(Long id) {
        Optional<Morador> MoradorOptional = moradorRepository.findById(id);

        if (MoradorOptional.isPresent()) {
            return new MoradorExibicaoDTO(MoradorOptional.get());
        } else {
            throw new MoradorNaoEncontradoException("Não foi encontrado um morador com esse id.");
        }
    }

    public MoradorExibicaoDTO buscarPorNome(String nome) {
        Optional<Morador> MoradorOptional = moradorRepository.buscarPorNome(nome);

        if (MoradorOptional.isPresent()) {
            return new MoradorExibicaoDTO(MoradorOptional.get());
        } else {
            throw new MoradorNaoEncontradoException("Não foi encontrado um morador com esse nome.");
        }
    }

    public void deletarPorId(Long id) {
        if (!moradorRepository.existsById(id)) {
            throw new MoradorNaoEncontradoException("Morador não encontrado.");
        }
        moradorRepository.deleteById(id);
    }

    public MoradorExibicaoDTO atualizar(Morador morador) {
        Optional<Morador> moradorOptional =
                moradorRepository.findById(morador.getIdMorador());

        if(moradorOptional.isPresent()){
            return new MoradorExibicaoDTO(moradorRepository.save(morador));
        }else{
            throw new MoradorNaoEncontradoException("Morador não encontrado.");
        }
    }
}
