package br.com.fiap.rotasdereciclagem.controller;

import br.com.fiap.rotasdereciclagem.dto.RotaExibicaoDTO;
import br.com.fiap.rotasdereciclagem.service.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reciclagem")
public class RotaController {

    @Autowired
    private RotaService rotaService;

    @GetMapping("/rotas")
    @ResponseStatus(HttpStatus.OK)
    public Page<RotaExibicaoDTO> listarTodos(
            @PageableDefault(size = 15)Pageable paginacao
            ){
        return rotaService.listarTodos(paginacao);
    }

    @GetMapping("/rotas/{idRota}")
    public ResponseEntity<RotaExibicaoDTO> buscarPorId(@PathVariable Long idRota){
        try{
            return ResponseEntity.ok(rotaService.buscarPorId(idRota));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<RotaExibicaoDTO> buscarPorPlaca(@RequestParam String pontosColeta){
        try{
            return ResponseEntity.ok(rotaService.buscarPorPontosDeColeta(pontosColeta));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
