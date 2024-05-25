package br.com.fiap.rotasdereciclagem.controller;

import br.com.fiap.rotasdereciclagem.dto.MoradorExibicaoDTO;
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
    private MoradorService MoradorService;

    @GetMapping("/moradores")
    @ResponseStatus(HttpStatus.OK)
    public Page<MoradorExibicaoDTO> listarTodos(
            @PageableDefault(size = 15)Pageable paginacao
            ){
        return MoradorService.listarTodos(paginacao);
    }

    @GetMapping("/moradores/{idMorador}")
    public ResponseEntity<MoradorExibicaoDTO> buscarPorId(@PathVariable Long idMorador){
        try{
            return ResponseEntity.ok(MoradorService.buscarPorId(idMorador));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<MoradorExibicaoDTO> buscarPorNome(@RequestParam String nome){
        try{
            return ResponseEntity.ok(MoradorService.buscarPorNome(nome));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}