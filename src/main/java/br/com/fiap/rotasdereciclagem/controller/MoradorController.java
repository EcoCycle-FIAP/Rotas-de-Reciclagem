package br.com.fiap.rotasdereciclagem.controller;

import br.com.fiap.rotasdereciclagem.dto.CaminhaoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.dto.MoradorExibicaoDTO;
import br.com.fiap.rotasdereciclagem.model.Caminhao;
import br.com.fiap.rotasdereciclagem.model.Morador;
import br.com.fiap.rotasdereciclagem.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reciclagem")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @PostMapping("/moradores")
    @ResponseStatus(HttpStatus.CREATED)
    public MoradorExibicaoDTO gravar(@RequestBody Morador morador){
        return moradorService.gravar(morador);
    }

    @GetMapping("/moradores")
    @ResponseStatus(HttpStatus.OK)
    public Page<MoradorExibicaoDTO> listarTodos(
            @PageableDefault(size = 15)Pageable paginacao
            ){
        return moradorService.listarTodos(paginacao);
    }

    @GetMapping("/moradores/{idMorador}")
    public ResponseEntity<MoradorExibicaoDTO> buscarPorId(@PathVariable Long idMorador){
        try{
            return ResponseEntity.ok(moradorService.buscarPorId(idMorador));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<MoradorExibicaoDTO> buscarPorNome(@RequestParam String nome){
        try{
            return ResponseEntity.ok(moradorService.buscarPorNome(nome));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/moradores/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        try {
            moradorService.deletarPorId(id);
            return ResponseEntity.ok("Morador excluído com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao excluir morador: " + e.getMessage());
        }
    }

    @PutMapping("/moradores")
    @ResponseStatus(HttpStatus.OK)
    public MoradorExibicaoDTO atualizar(@RequestBody Morador morador){
        return moradorService.atualizar(morador);
    }
}
